package Commands;

import CommandManager.ICommand;
import CommandManager.JDBC;
import LavaPlayer.PlayerManager;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;

import java.util.List;

public class PlayEvent implements ICommand {

    public PlayerManager pm = PlayerManager.getInstance();

    @Override
    public void run(List<String> args, GuildMessageReceivedEvent event) {
        String eventName = args.get(0);
        String url = JDBC.playEvent(eventName);

            pm.loadAndPlay(event.getChannel(), url, event.getMember());
        }


    @Override
    public String getCommand() {
        return "playevent";
    }

    @Override
    public String getHelp() {
        return "Usage: !playevent <event name>" + "\n" +
                "Plays that specific event playlist saved on the database";
    }
}


