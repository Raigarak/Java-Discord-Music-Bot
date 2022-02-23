package Commands;

import CommandManager.ICommand;
import CommandManager.JDBC;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;

import java.util.List;

public class UpdatePlaylist implements ICommand {
    @Override
    public void run(List<String> args, GuildMessageReceivedEvent event) {
        String userID = event.getMember().getId();
        String URL = args.get(0);

        JDBC.updatePlaylist(userID, URL);
    }

    @Override
    public String getCommand() {
        return "updateplaylist";
    }

    @Override
    public String getHelp() {
        return null;
    }
}
