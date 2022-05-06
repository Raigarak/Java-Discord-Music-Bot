package Commands;

import CommandManager.ICommand;
import LavaPlayer.PlayerManager;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;

import java.util.List;

public class Jump implements ICommand {
    PlayerManager pm = PlayerManager.getInstance();

    @Override
    public void run(List<String> args, GuildMessageReceivedEvent event) {
        int index = Integer.parseInt(args.get(0));

        if(index == 0) {
            event.getChannel().sendMessage("Song #0 does not exist.").queue();
        } else {
            pm.jump(event.getChannel(), index - 1);
        }
    }

    @Override
    public String getCommand() {
        return "jump";
    }

    @Override
    public String getHelp() {
        return "Usage: !jump <song position>" + "\n" +
                "playlist jumps to the designated song position";
    }
}
