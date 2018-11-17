package jukify.jukify;

import java.io.Serializable;

public class Song implements Serializable {

    private String name;
    private String artist;
    private int up_votes;
    private int down_votes;
    private int score;
    private boolean super_skipper;
    private String song_uri;

    public Song(String name, String artist, int up_votes, int down_votes, int score, boolean super_skipper, String song_uri) {
        this.name = name;
        this.artist = artist;
        this.up_votes = up_votes;
        this.down_votes = down_votes;
        this.score = score;
        this.super_skipper = super_skipper;
        this.song_uri = song_uri;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public int getUp_votes() {
        return up_votes;
    }

    public void setUp_votes(int up_votes) {
        this.up_votes = up_votes;
    }

    public int getDown_votes() {
        return down_votes;
    }

    public void setDown_votes(int down_votes) {
        this.down_votes = down_votes;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public boolean isSuper_skipper() {
        return super_skipper;
    }

    public void setSuper_skipper(boolean super_skipper) {
        this.super_skipper = super_skipper;
    }

    public String getSong_uri() {
        return song_uri;
    }

    public void setSong_uri(String song_uri) {
        this.song_uri = song_uri;
    }
}

