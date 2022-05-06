package Commands;

import CommandManager.ICommand;
import CommandManager.JDBC;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;

import java.util.List;

public class DeleteEvent implements ICommand {
    @Override
    public void run(List<String> args, GuildMessageReceivedEvent event) {
        String eventName = args.get(0);
        JDBC.deleteEvent(eventName);
    }

    @Override
    public String getCommand() {
        return "deleteevent";
    }

    @Override
    public String getHelp() {
        return "Usage: !deleteevent <event name>" + "\n" +
                "Deletes the event in the database";
    }
}
