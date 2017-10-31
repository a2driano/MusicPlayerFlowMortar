package ua.recycler.binding.musicplayerflowmortar.view;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.widget.FrameLayout;

import flow.Flow;
import ua.recycler.binding.musicplayerflowmortar.AdapterTrack;
import ua.recycler.binding.musicplayerflowmortar.App;
import ua.recycler.binding.musicplayerflowmortar.R;
import ua.recycler.binding.musicplayerflowmortar.TrackScreen;
import ua.recycler.binding.musicplayerflowmortar.model.Track;

/**
 * Created by kunde on 30.10.2017.
 */

public class TrackList extends FrameLayout implements AdapterTrack.OnItemClick {
    private RecyclerView mRecyclerView;
    private Context mContext;

    public TrackList(@NonNull Context context) {
        super(context);
        mContext = context;
    }

    public TrackList(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        mContext = context;
    }

    public TrackList(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mContext = context;
    }

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        TrackScreen screen = Flow.getKey(this);

        mRecyclerView = findViewById(R.id.recycler_view);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(mContext));
        mRecyclerView.setAdapter(new AdapterTrack(screen.track));
    }

    @Override
    public void onItemClick(Track track) {
        Flow.get(this).set(new TrackInfo(track));
    }
}
