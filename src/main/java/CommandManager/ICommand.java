package CommandManager;

import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;

import java.util.List;

public interface ICommand {
    void run(List<String> args, GuildMessageReceivedEvent event);
    String getCommand();
    String getHelp();
}

