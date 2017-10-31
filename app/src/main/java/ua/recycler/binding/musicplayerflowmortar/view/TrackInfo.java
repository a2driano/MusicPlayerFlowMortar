package ua.recycler.binding.musicplayerflowmortar.view;

import ua.recycler.binding.musicplayerflowmortar.model.Track;

/**
 * Created by Andrii Papai on 31.10.2017.
 */

public class TrackInfo {
    private Track mTrack;

    public TrackInfo(Track track) {
        mTrack = track;
    }

    public Track getTrack() {
        return mTrack;
    }

    public void setTrack(Track track) {
        mTrack = track;
    }
}
