package Commands;

import CommandManager.ICommand;
import LavaPlayer.PlayerManager;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;

import java.util.List;

public class Size implements ICommand {
    private PlayerManager pm = PlayerManager.getInstance();

    @Override
    public void run(List<String> args, GuildMessageReceivedEvent event) {
        pm.getSize(event.getChannel());
    }

    @Override
    public String getCommand() {
        return "size";
    }

    @Override
    public String getHelp() {
        return "Usage: !size /n" +
                "Returns the total amount of songs in the current playlist";
    }
}
