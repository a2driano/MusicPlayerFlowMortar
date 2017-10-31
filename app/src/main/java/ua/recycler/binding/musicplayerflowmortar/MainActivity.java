package ua.recycler.binding.musicplayerflowmortar;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import flow.Flow;
import ua.recycler.binding.musicplayerflowmortar.model.Track;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

    @Override
    protected void attachBaseContext(Context baseContext) {

        baseContext = Flow.configure(baseContext, this)
                .defaultKey(new TrackScreen(App.getList()))
                .dispatcher(new BasicDispatcher(this))
                .install();
        super.attachBaseContext(baseContext);


    }

    @Override public void onBackPressed() {
        if (!Flow.get(this).goBack()) {
            super.onBackPressed();
        }
    }
}
