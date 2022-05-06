package Commands;

import CommandManager.ICommand;
import LavaPlayer.PlayerManager;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;

import java.util.List;

public class Remove implements ICommand {
    PlayerManager pm = PlayerManager.getInstance();
    @Override
    public void run(List<String> args, GuildMessageReceivedEvent event) {
        int index = Integer.parseInt(args.get(0));
        pm.remove(event.getChannel(), index-1);
    }

    @Override
    public String getCommand() {
        return "remove";
    }

    @Override
    public String getHelp() {
        return "Usage: !remove <x>" + "\n" +
                "Remove the song at position specified";
    }
}
