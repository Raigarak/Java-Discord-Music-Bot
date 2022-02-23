package Commands;

import CommandManager.ICommand;
import LavaPlayer.PlayerManager;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;

import java.util.List;

public class Skip implements ICommand {

    private PlayerManager pm = PlayerManager.getInstance();



    @Override
    public void run(List<String> args, GuildMessageReceivedEvent event) {
        pm.skipTrack(event.getChannel());
    }

    @Override
    public String getCommand() {
        return "skip";
    }

    @Override
    public String getHelp() {
        return "Usage: !skip\n" +
                "Skips the current song in play and plays the next song in the list";
    }
}
