package Commands;

import CommandManager.ICommand;
import LavaPlayer.*;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;

import java.util.List;

public class Play implements ICommand {

    public PlayerManager pm = PlayerManager.getInstance();

    @Override
    public void run(List<String> args, GuildMessageReceivedEvent event) {
        if(event.getMember().getVoiceState().getChannel() == null) {
            event.getChannel().sendMessage("Please join the voice chat channel first!").queue();
        }
        pm.loadAndPlay(event.getChannel(),args.get(0), event.getMember());


    }

    @Override
    public String getCommand() {
        return "play";
    }

    @Override
    public String getHelp() {
        return "Usage: !play <Youtube URL> or <Youtube Playlist URL>" + "\n" +
                "Plays a youtube video or a youtube playlist. (You can queue up videos or playlist as well)";
    }
}
