package Commands;

import CommandManager.ICommand;
import LavaPlayer.PlayerManager;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;

import java.util.List;


public class Song implements ICommand {
    private PlayerManager pm = PlayerManager.getInstance();

    @Override
    public void run(List<String> args, GuildMessageReceivedEvent event) {
        pm.currentSong(event.getChannel());
    }

    @Override
    public String getCommand() {
        return "song";
    }

    @Override
    public String getHelp() {
        return "Returns the current song playing";
    }
}
