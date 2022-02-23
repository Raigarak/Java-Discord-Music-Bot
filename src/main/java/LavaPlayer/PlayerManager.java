package LavaPlayer;


import com.sedmelluq.discord.lavaplayer.player.AudioLoadResultHandler;
import com.sedmelluq.discord.lavaplayer.player.AudioPlayerManager;
import com.sedmelluq.discord.lavaplayer.player.DefaultAudioPlayerManager;
import com.sedmelluq.discord.lavaplayer.source.AudioSourceManagers;
import com.sedmelluq.discord.lavaplayer.tools.FriendlyException;
import com.sedmelluq.discord.lavaplayer.track.AudioPlaylist;
import com.sedmelluq.discord.lavaplayer.track.AudioTrack;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.entities.VoiceChannel;
import net.dv8tion.jda.api.managers.AudioManager;

import java.util.*;

public class PlayerManager {
    private static PlayerManager INSTANCE;




    private final AudioPlayerManager audioPlayerManager;
    private final Map<Long, GuildMusicManager> musicManagers;


    PlayerManager() {
        this.musicManagers = new HashMap<>();

        this.audioPlayerManager = new DefaultAudioPlayerManager();
        AudioSourceManagers.registerRemoteSources(audioPlayerManager);
        AudioSourceManagers.registerLocalSource(audioPlayerManager);
    }


    private synchronized GuildMusicManager getGuildAudioPlayer(Guild guild) {
        long guildId = Long.parseLong(guild.getId());
        GuildMusicManager musicManager = musicManagers.get(guildId);

        if (musicManager == null) {
            musicManager = new GuildMusicManager(audioPlayerManager);
            musicManagers.put(guildId, musicManager);
        }

        guild.getAudioManager().setSendingHandler(musicManager.getSendHandler());

        return musicManager;
    }

    public void loadAndPlay(final TextChannel channel, final String trackUrl, Member member) {
        GuildMusicManager musicManager = getGuildAudioPlayer(channel.getGuild());

        audioPlayerManager.loadItemOrdered(musicManager, trackUrl, new AudioLoadResultHandler() {
            @Override
            public void trackLoaded(AudioTrack track) {

                channel.sendMessage("Adding to queue: " + track.getInfo().title + " at position " + musicManager.scheduler.getQueue().size()).queue();
                play(channel.getGuild(), musicManager, track, member);
            }

            @Override
            public void playlistLoaded(AudioPlaylist playlist) {


                int numberOfSongs = playlist.getTracks().size();
                for(AudioTrack track: playlist.getTracks()) {

                    //channel.sendMessage("Adding to queue " + track.getInfo().title + " (first track of playlist " + playlist.getName() + ")").queue();
                    play(channel.getGuild(), musicManager, track, member);
                }
                channel.sendMessage("Added " + numberOfSongs + " songs into the queue!").queue();
            }

            @Override
            public void noMatches() {
                channel.sendMessage("Nothing found by " + trackUrl).queue();
            }

            @Override
            public void loadFailed(FriendlyException exception) {
                channel.sendMessage("Could not play: " + exception.getMessage()).queue();
            }

        });
    }

    private void play(Guild guild, GuildMusicManager musicManager, AudioTrack track, Member member) {

        connectToCurrentVoiceChannel(guild.getAudioManager(), member);
        musicManager.scheduler.queue(track);


    }

    public void skipTrack(TextChannel channel) {
        GuildMusicManager musicManager = getGuildAudioPlayer(channel.getGuild());
        channel.sendMessage("Skipping the song: " + musicManager.player.getPlayingTrack().getInfo().title).queue();
        musicManager.scheduler.nextTrack();
    }

    private static void connectToCurrentVoiceChannel(AudioManager audioManager, Member member) {
        if (!audioManager.isConnected() && !audioManager.isAttemptingToConnect()) {
            VoiceChannel voiceChannel = member.getVoiceState().getChannel();
            audioManager.openAudioConnection(voiceChannel);
        }
    }

    public void displayPlaylist(TextChannel channel) {
        GuildMusicManager musicManager = getGuildAudioPlayer(channel.getGuild());
        if(musicManager.scheduler.getQueue().isEmpty()) {
            channel.sendMessage("Empty playlist").queue();
        }
        int index = 1;
        StringBuilder sb = new StringBuilder();
        for(AudioTrack track: musicManager.scheduler.getQueue()) {
            sb.append("Song #" + (index) + " - " + track.getInfo().title);
            sb.append("\n");
            index++;
        }
        channel.sendMessage(sb.toString()).queue();
    }

    public void shufflePlaylist(TextChannel channel) {
        GuildMusicManager musicManager = getGuildAudioPlayer(channel.getGuild());
        List tempList = new ArrayList(musicManager.scheduler.getQueue());
        Collections.shuffle(tempList);
        musicManager.scheduler.getQueue().clear();
        musicManager.scheduler.getQueue().addAll(tempList);
    }



    public void getSize(TextChannel channel) {
        GuildMusicManager musicManager = getGuildAudioPlayer(channel.getGuild());
        channel.sendMessage("There are currently " + musicManager.scheduler.getQueue().size() + " in the playlist").queue();
    }

    public void currentSong(TextChannel channel) {
        GuildMusicManager musicManager = getGuildAudioPlayer(channel.getGuild());
        if(musicManager.scheduler.getQueue().isEmpty()) {
            channel.sendMessage("There is currently no song being played").queue();
        }
        channel.sendMessage("The current song is called " + musicManager.player.getPlayingTrack().getInfo().title).queue();
    }

    public void pauseSong(TextChannel channel) {
        GuildMusicManager musicManager = getGuildAudioPlayer(channel.getGuild());
        musicManager.player.setPaused(true);
    }

    public void jump(TextChannel channel, int index) {
        GuildMusicManager musicManager = getGuildAudioPlayer(channel.getGuild());
        musicManager.player.stopTrack();
        List<AudioTrack> tempList = new ArrayList<>(musicManager.scheduler.getQueue());
        AudioTrack track = tempList.get(index);
        tempList.remove(index);
        tempList.add(0, track);
        musicManager.scheduler.getQueue().clear();
        musicManager.scheduler.getQueue().addAll(tempList);
        musicManager.scheduler.nextTrack();
    }

    public void remove(TextChannel channel, int index) {
        GuildMusicManager musicManager = getGuildAudioPlayer(channel.getGuild());
        List<AudioTrack> tempList = new ArrayList<>(musicManager.scheduler.getQueue());
        tempList.remove(index);
        musicManager.scheduler.getQueue().clear();
        musicManager.scheduler.getQueue().addAll(tempList);
    }

    public void resumeSong(TextChannel channel) {
        GuildMusicManager musicManager = getGuildAudioPlayer(channel.getGuild());
        musicManager.player.setPaused(false);
    }

    public void clear(TextChannel channel) {
        GuildMusicManager musicManager = getGuildAudioPlayer(channel.getGuild());
        musicManager.scheduler.getQueue().clear();
    }

    public static synchronized PlayerManager getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new PlayerManager();
        }
        return INSTANCE;
    }
}
