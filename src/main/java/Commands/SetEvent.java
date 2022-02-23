package Commands;

import CommandManager.Bot;
import CommandManager.ICommand;
import CommandManager.JDBC;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;

import java.util.List;

public class SetEvent implements ICommand {
    @Override
    public void run(List<String> args, GuildMessageReceivedEvent event) {

        String userID = event.getMember().getId();
        String eventName = args.get(0);
        String URL = args.get(1);

            if(userID.equals(Bot.BOT_OWNER_ID)) {
                JDBC.setEvent(eventName, URL);
            } else {
                event.getChannel().sendMessage("Only owner can use this command");
            }

    }

    @Override
    public String getCommand() {
        return "setevent";
    }

    @Override
    public String getHelp() {
        return null;
    }
}
