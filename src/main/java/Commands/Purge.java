package Commands;

import CommandManager.ICommand;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;

import java.util.List;

public class Purge implements ICommand {
    @Override
    public void run(List<String> args, GuildMessageReceivedEvent event) {
        if(args.size() == 1) {
            //Deletes initial !Purge command
            event.getMessage().delete().complete();
            try{
                    List<Message> messages = event.getChannel().getHistory().retrievePast(Integer.parseInt(args.get(0))).complete();
                    event.getChannel().purgeMessages(messages);
            } catch (Exception e) {
                EmbedBuilder eb = new EmbedBuilder();
                eb.setTitle("Can't delete this many messages");
                eb.setDescription("You can only delete 2-100 messages per command invoke");
                event.getChannel().sendMessage(eb.build()).queue();

            }
        }
    }

    @Override
    public String getCommand() {
        return "purge";
    }

    @Override
    public String getHelp() {
        return "Usage: !purge <x> /n" +
                "Deletes the specified amount of messages from the text channel";
    }
}
