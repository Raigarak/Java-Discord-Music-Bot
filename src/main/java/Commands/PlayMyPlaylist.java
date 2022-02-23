package Commands;

import CommandManager.ICommand;
import CommandManager.JDBC;
import LavaPlayer.PlayerManager;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;

import java.util.List;

public class PlayMyPlaylist implements ICommand {

    public PlayerManager pm = PlayerManager.getInstance();

    @Override
    public void run(List<String> args, GuildMessageReceivedEvent event) {
        String userID = event.getMember().getId();

        String playlistURL = JDBC.myPlaylist(userID);

        if(playlistURL.equals(null)) {
            event.getChannel().sendMessage("WRONG TEST").queue();
        } else {
            pm.loadAndPlay(event.getChannel(), playlistURL, event.getMember());
        }
    }

    @Override
    public String getCommand() {
        return "playmyplaylist";
    }

    @Override
    public String getHelp() {
        return "Usage: !playmyplaylist /n" +
                "Plays your personal playlist if you have one saved on the database. Use !setplaylist <youtube url> to set one";
    }
}
