package Commands;

import CommandManager.ICommand;
import LavaPlayer.PlayerManager;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;

import java.util.List;

public class Clear implements ICommand {

    PlayerManager pm = PlayerManager.getInstance();

    @Override
    public void run(List<String> args, GuildMessageReceivedEvent event) {

        pm.clear(event.getChannel());
    }

    @Override
    public String getCommand() {
        return "clear";
    }

    @Override
    public String getHelp() {
        return "Usage: !clear /n" +
                "Clears all the songs in the current playlist";
    }
}
