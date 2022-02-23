package Commands;

import CommandManager.CommandManager;
import CommandManager.ICommand;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;

import java.util.List;

public class Help implements ICommand {
    public CommandManager cManager;

    public Help(CommandManager m) {
        this.cManager = m;
    }

    @Override
    public void run(List<String> args, GuildMessageReceivedEvent event) {
        if(args.isEmpty()) {
            EmbedBuilder e = new EmbedBuilder()
                    .setTitle("List of all the commands: ");
            StringBuilder description = e.getDescriptionBuilder();
            cManager.getCommands().forEach(ICommand -> {
                description.append("`")
                        .append(ICommand.getCommand())
                        .append(" - ")
                        .append(ICommand.getHelp())
                        .append("`\n");
            });
            event.getChannel().sendMessage(e.build()).queue();
            return;
        }
        ICommand command = cManager.getCommand(String.join("", args));//!help noob noob ain't a command so its to check
        if(command == null) {
            event.getChannel().sendMessage("The command " + String.join("", args) + " does not exist! \n" +
                    "Use").queue();
            return;
        }
        event.getChannel().sendMessage("Command help for " + command.getCommand() + " \n" + command.getHelp()).queue();
    }

    @Override
    public String getCommand() {
        return "help";
    }

    @Override
    public String getHelp() {
        return "Usage: !help /n" +
                "Displays all available commands";
    }
}
