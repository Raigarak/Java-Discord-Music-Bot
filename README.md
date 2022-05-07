# Java Discord Music Bot

[Youtube Demo](https://www.youtube.com/watch?v=ZozieD_TiN4)

A java discord music bot with over 20+ music commands. It has a unique feature where it can save a youtube playlist for each user into a database. Each user can just type !playmyplaylist command, it'll retrieve their specific youtube playlist from the database and plays it.

**Setup** - 

Go into the `Bot.java` file to change the command prefix symbol, discord bot owner id, and discord bot token.

You need to download mysql database and set it up to use this bot. 
In the `JDBC.java` file, You have to change the DBURL, USER, PASSWORD variables to your own database information.

Use the !help command to find out every command and how to use it.

After you finish the initalizing all the stuff above, all you have to do is compile and run the program. The default command prefix is `!` You can change it in `Bot.java`

**Commands** - 

`clear` - !clear 

Clears all the songs in the current playlist

`DeleteEvent` !deleteevent <event name>
	
Deletes the event in the database

`Help` !help
	
Displays all available commands

`Jump` !jump <song position>
	
Playlist jumps to the designated song position

`MyPlaylist` !myplaylist
	
Retrieves your playlist from the database if you have it set

`Pause` !pause
	
Pauses the song that's currently playing

`Play` !play <Youtube URL> or <Youtube Playlist URL>
	
Plays a youtube video or a youtube playlist. (You can queue up videos or playlist as well)

`PlayEvent` !playevent <event name>
	
Plays that specific event playlist saved on the database

`Playlist` !playlist
	
Returns a list of all the songs in the queue

`PlayMyPlaylist` !playmyplaylist
	
Plays your personal playlist if you have one saved on the database. Use !setplaylist <youtube url> to set one

`Purge` !purge <x>
	
Deletes the specified amount of messages from the text channel

`Remove` !remove <x>
	
Remove the song at position specified
	
`Resume` !resume
	
Resumes the playlist if the pause command was used

`SetEvent` !setevent <event name> <youtube url>
	
Saves the event name and the url associated with the event into the database

`SetPlaylist` !setplaylist <youtube url>
	
Saves your personal playlist to the database

`Shuffle`!shuffle
	
Shuffles the songs that are in the queue

`Size` !size
	
Returns the count of all the songs in the queue 

`Skip` !skip
	
Skips the current song in play and plays the next song in the list

`Song` !song

Returns the current song playing
	
`UpdateEvent` !updateevent <event name> <youtube url>
	
Updates the event playlist saved in the database to the new one

`UpdatePlaylist` !updateplaylist <youtube url>
	
Update your personal playlist with a new youtube playlist
