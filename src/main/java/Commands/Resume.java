package Commands;

import CommandManager.ICommand;
import LavaPlayer.PlayerManager;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;

import java.util.List;

public class Resume implements ICommand {
    public PlayerManager pm = PlayerManager.getInstance();
    @Override
    public void run(List<String> args, GuildMessageReceivedEvent event) {
        pm.resumeSong(event.getChannel());
    }

    @Override
    public String getCommand() {
        return "resume";
    }

    @Override
    public String getHelp() {
        return "Usage: !resume" + "\n" +
                "Resumes the playlist if the pause command was used";
    }
}
