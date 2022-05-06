package Commands;

import CommandManager.ICommand;
import CommandManager.JDBC;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;

import java.util.List;

public class MyPlaylist implements ICommand {
    @Override
    public void run(List<String> args, GuildMessageReceivedEvent event) {
            String userID = event.getMember().getId();

            String playlist = JDBC.myPlaylist(userID);
            event.getChannel().sendMessage("Your current playlist is: " + playlist).queue();
    }

    @Override
    public String getCommand() {
        return "myplaylist";
    }

    @Override
    public String getHelp() {
        return "Usage: !myplaylist" + "\n" +
                "Retrieves your playlist from the database if you have it set";
    }
}
