package Commands;

import CommandManager.ICommand;
import LavaPlayer.*;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;

import java.util.List;

public class Playlist implements ICommand {

    public PlayerManager pm = PlayerManager.getInstance();


    @Override
    public void run(List<String> args, GuildMessageReceivedEvent event) {
        pm.displayPlaylist(event.getChannel());
    }

    @Override
    public String getCommand() {
        return "playlist";
    }

    @Override
    public String getHelp() {
        return "Usage: !playlist" + "\n" +
        "Returns a list of all the songs currency in the list";
    }
}
