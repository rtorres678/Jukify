package jukify.jukify;

import java.util.ArrayList;

import jukify.jukify.Song;

public class Playlist {
    private String name;
    private int song_count;
    private ArrayList<Song> song_list;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSong_count() {
        return song_count;
    }

    public void setSong_count(int song_count) {
        this.song_count = song_count;
    }

    public ArrayList<Song> getSong_list() {
        return song_list;
    }

    public void setSong_list(ArrayList<Song> song_list) {
        this.song_list = song_list;
    }
}
