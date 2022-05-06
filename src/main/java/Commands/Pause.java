package Commands;

import CommandManager.ICommand;
import LavaPlayer.PlayerManager;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;

import java.util.List;

public class Pause implements ICommand {
    public PlayerManager pm = PlayerManager.getInstance();
    @Override
    public void run(List<String> args, GuildMessageReceivedEvent event) {
        pm.pauseSong(event.getChannel());

        if(args.get(1).equals("resume")) {
            pm.resumeSong(event.getChannel());
        }
    }

    @Override
    public String getCommand() {
        return "pause";
    }

    @Override
    public String getHelp() {
        return "Usage: !help" + "\n" +
                "Displays all available commands";
    }
}
