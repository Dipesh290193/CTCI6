package ch7_ObjectOrientedDesign;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Jukebox {

	private CDPlayer cdPlayer;
	private User user;
	private Set<CD> cdCollection;
}

class User{
	private String name;
	private long ID;
	
	public User(String name, long id)
	{
		this.ID = id;
		this.name = name;
	}
	
	public static User addUser(String name, long id)
	{
		User u = new User(name, id);
		return u;
	}
}

class CD{
	
}

class Song{
	
}

class Playlist{
	private Song song;
	private List<Song> songs = new ArrayList<Song>();
	
	public Playlist(Song song, List<Song> songs)
	{
		this.song=song;
		this.songs = songs;
	}
}

class CDPlayer{
	private Playlist p;
	private CD c;
}
