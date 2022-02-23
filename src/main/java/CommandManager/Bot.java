package CommandManager;

import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;

import javax.security.auth.login.LoginException;

public class Bot{

    public static final String PREFIX = "!";
    public static final String BOT_OWNER_ID = "";

    public static void main(String[] args) throws LoginException {
        JDABuilder jda = JDABuilder.createDefault("");
        jda.setActivity(Activity.watching("Naruto"));

        jda.addEventListeners(new CommandListener());
        jda.build();

    }


}
