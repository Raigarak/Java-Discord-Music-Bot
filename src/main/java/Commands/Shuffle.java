package Commands;

import CommandManager.ICommand;
import LavaPlayer.PlayerManager;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;

import java.util.List;

public class Shuffle implements ICommand {
    PlayerManager pm = PlayerManager.getInstance();
    @Override
    public void run(List<String> args, GuildMessageReceivedEvent event) {
        pm.shufflePlaylist(event.getChannel());
    }

    @Override
    public String getCommand() {
        return "shuffle";
    }

    @Override
    public String getHelp() {
        return "Usage: !shuffle" + "\n" +
                "Shuffles the songs in the playlist";
    }
}
