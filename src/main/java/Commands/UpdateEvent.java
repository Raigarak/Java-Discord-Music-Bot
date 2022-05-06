package Commands;

import CommandManager.ICommand;
import CommandManager.JDBC;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;

import java.util.List;

public class UpdateEvent implements ICommand {
    @Override
    public void run(List<String> args, GuildMessageReceivedEvent event) {
        String eventName = args.get(0);
        String url = args.get(1);

        JDBC.updateEvent(eventName, url);
    }

    @Override
    public String getCommand() {
        return "updateevent";
    }

    @Override
    public String getHelp() {
        return "Usage: !updateevent <event name> <youtube url>" + "\n" +
                "Updates the event playlist saved in the database to the new one";
    }
}
