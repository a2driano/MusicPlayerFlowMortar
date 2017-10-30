package ua.recycler.binding.musicplayerflowmortar.model;

/**
 * Created by kunde on 30.10.2017.
 */

public class Track {
    private String name;
    private String track;

    public Track(String name, String track) {
        this.name = name;
        this.track = track;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTrack() {
        return track;
    }

    public void setTrack(String track) {
        this.track = track;
    }
}
