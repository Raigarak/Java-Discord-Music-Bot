package CommandManager;


import Commands.*;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;

import java.util.*;


public class CommandManager {

    private final Map<String, ICommand> commands = new HashMap<>();

    CommandManager() {

        addCommand(new Help(this));
        addCommand(new Play());
        addCommand(new Skip());
        addCommand(new Playlist());
        addCommand(new Purge());
        addCommand(new Song());
        addCommand(new Size());
        addCommand(new SetPlaylist());
        addCommand(new PlayMyPlaylist());
        addCommand(new MyPlaylist());
        addCommand(new UpdatePlaylist());
        addCommand(new Clear());
        addCommand(new SetEvent());
        addCommand(new Pause());
        addCommand(new Resume());
        addCommand(new PlayEvent());
        addCommand(new SetEvent());
        addCommand(new UpdateEvent());
        addCommand(new DeleteEvent());
        addCommand(new Shuffle());
        addCommand(new Jump());
        addCommand(new Remove());
    }

    private void addCommand(ICommand c) {
        if (!commands.containsKey(c.getCommand())) {
            commands.put(c.getCommand(), c);
        }
    }

    public Collection<ICommand> getCommands() {
        return commands.values();
    }

    public ICommand getCommand(String commandName) {
        if (commandName == null) {
            return null;
        }
        return commands.get(commandName);
    }

    void run(GuildMessageReceivedEvent event) {
        String message = event.getMessage().getContentRaw();
        if (!message.startsWith(Bot.PREFIX)) {
            return;
        }
        String[] split = message.replaceFirst(Bot.PREFIX, "").split("\\s+");
        String command = split[0].toLowerCase();
        if (commands.containsKey(command)) {
            List<String> args = Arrays.asList(split).subList(1, split.length);
            commands.get(command).run(args, event);
        }
    }
}
