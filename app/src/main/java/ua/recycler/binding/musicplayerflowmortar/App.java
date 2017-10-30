package ua.recycler.binding.musicplayerflowmortar;

import android.app.Application;

import java.util.ArrayList;
import java.util.List;

import ua.recycler.binding.musicplayerflowmortar.model.Track;

/**
 * Created by kunde on 30.10.2017.
 */

public class App extends Application {
    private static List<Track> track;

    @Override
    public void onCreate() {
        super.onCreate();

        track = new ArrayList<>();

        fillList();
    }

    public static List<Track> getList(){
        return track;
    }

    private void fillList() {
        track.add(new Track("Rockstar", "Post Malone Featuring 21 Savage"));
        track.add(new Track("Cardi B", "Bodak Yellow "));
        track.add(new Track("Feel It Still", "Portugal. The Man"));
        track.add(new Track("Mi Gente", "J Balvin & Willy William Featuring Beyonce"));
    }
}
