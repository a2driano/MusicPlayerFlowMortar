package ua.recycler.binding.musicplayerflowmortar;

import android.app.Activity;
import android.media.MediaPlayer;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import flow.Dispatcher;
import flow.Flow;
import flow.Traversal;
import flow.TraversalCallback;
import ua.recycler.binding.musicplayerflowmortar.view.TrackInfo;

/**
 * Created by Andrii Papai on 31.10.2017.
 */

public class BasicDispatcher implements Dispatcher {
    private final Activity activity;

    public BasicDispatcher(Activity activity) {
        this.activity = activity;
    }

    @Override
    public void dispatch(@NonNull Traversal traversal, @NonNull TraversalCallback callback) {
        Object destKey = traversal.destination.top();

        ViewGroup frame = (ViewGroup) activity.findViewById(R.id.basic_activity_frame);

        // We're already showing something, clean it up.
        if (frame.getChildCount() > 0) {
            final View currentView = frame.getChildAt(0);

            // Save the outgoing view state.
            if (traversal.origin != null) {
                traversal.getState(traversal.origin.top()).save(currentView);
            }

            // Short circuit if we would just be showing the same view again.
            final Object currentKey = Flow.getKey(currentView);
            if (destKey.equals(currentKey)) {
                callback.onTraversalCompleted();
                return;
            }

            frame.removeAllViews();
        }
        @LayoutRes final int layout;
        if (destKey instanceof TrackScreen) {
            layout = R.layout.recycler_view;
        } else if (destKey instanceof TrackInfo) {
            layout = R.layout.track_layout;
        }
//        else if (destKey instanceof SettingsScreen) {
//            layout = R.layout.settings_screen;
//        }
        else {
            throw new AssertionError("Unrecognized screen " + destKey);
        }

        View incomingView = LayoutInflater.from(traversal.createContext(destKey, activity)) //
                .inflate(layout, frame, false);

        frame.addView(incomingView);
        traversal.getState(traversal.destination.top()).restore(incomingView);

        callback.onTraversalCompleted();
    }
}
