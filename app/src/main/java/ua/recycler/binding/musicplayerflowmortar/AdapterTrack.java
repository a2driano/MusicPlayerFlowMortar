package ua.recycler.binding.musicplayerflowmortar;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import ua.recycler.binding.musicplayerflowmortar.model.Track;

/**
 * Created by kunde on 30.10.2017.
 */

public class AdapterTrack extends RecyclerView.Adapter<AdapterTrack.TrackHolder> {
    private List<Track> mTrackList;

    public AdapterTrack(List<Track> mTrackList) {
        this.mTrackList = mTrackList;
    }

    @Override
    public TrackHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_view, parent, false);
        return new TrackHolder(view);
    }

    @Override
    public void onBindViewHolder(TrackHolder holder, int position) {
        holder.name.setText(mTrackList.get(position).getName());
        holder.track.setText(mTrackList.get(position).getTrack());
    }

    @Override
    public int getItemCount() {
        return mTrackList.size();
    }

    public class TrackHolder extends RecyclerView.ViewHolder {
        public TextView name;
        public TextView track;

        public TrackHolder(View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.name);
            track = itemView.findViewById(R.id.track);
        }
    }
}
