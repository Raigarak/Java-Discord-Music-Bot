package Commands;

import CommandManager.ICommand;
import CommandManager.JDBC;
import LavaPlayer.PlayerManager;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;

import java.util.List;

public class SetPlaylist implements ICommand {

    public PlayerManager pm = PlayerManager.getInstance();

    @Override
    public void run(List<String> args, GuildMessageReceivedEvent event) {
        String userID = event.getMember().getId();
        String URL = args.get(0);

         JDBC.setPlaylist(userID, URL);
    }

    @Override
    public String getCommand() {
        return "setplaylist";
    }

    @Override
    public String getHelp() {
        return "Returns your personal playlist";
    }
}
