# JavaDiscordMusicBot

A java discord music bot with over 20+ music commands. It has a unique feature where it can save a youtube playlist for each user into a database. Each user can just type !playmyplaylist command, it'll retrieve their specific youtube playlist from the database and plays it.

**Setup** - 
Go into the `Bot.java` file to change the command prefix symbol, discord bot owner id, and discord bot token.

You need to download mysql database and set it up to use this bot. 
In the `JDBC.java` file, You have to change the DBURL, USER, PASSWORD variables to your own database information.

Use the !help command to find out every command and how to use it.

After you finish the initalizing all the stuff above, all you have to do is compile and run the program. The default command prefix is `!` You can change it in `Bot.java`

**Commands** - 

`clear` - !clear 
Clears all the songs in the current playlist\

`DeleteEvent`

`Help` 

`Jump`

`MyPlaylist

`Pause`

`Play`

`PlayEvent`

`Playlist`

`PlayMyPlaylist`

`Purge`

`Remove`

`SetEvent`

`SetPlaylist`

`Shuffle`

`Size`

`Skip`

`Song`

`UpdateEvent`

`UpdatePlaylist`
