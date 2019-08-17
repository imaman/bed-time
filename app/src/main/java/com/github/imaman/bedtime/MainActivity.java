package com.github.imaman.bedtime;

import android.app.Dialog;
import android.os.Bundle;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GestureDetectorCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;

import java.time.LocalDateTime;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private final Model model = new Model();
    private EntryAdapter adapter = new EntryAdapter(model);
    private GestureDetectorCompat mDetector;

    MainActivity() {
        model.add(
            LocalDateTime.of(2019, 8, 3, 10, 15),
            LocalDateTime.of(2019, 8, 3, 20, 15));
        model.add(
                LocalDateTime.of(2019, 8, 3, 3, 15),
                LocalDateTime.of(2019, 8, 3, 20, 15));
        model.add(
                LocalDateTime.of(2019, 8, 3, 3, 15),
                LocalDateTime.of(2019, 8, 3, 8, 15));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addData();
//                Snackbar.make(view, "_IAH_!", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
            }
        });


        this.recyclerView = findViewById(R.id.entries);

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        recyclerView.setHasFixedSize(true);

        // use a linear layout manager
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        recyclerView.setAdapter(adapter);

        
        mDetector = new GestureDetectorCompat(this, new MyGestureListener());

        recyclerView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                return mDetector.onTouchEvent(motionEvent);
            }
        });


//        GestureDetector.OnDoubleTapListener

    }

    static class MyGestureListener extends GestureDetector.SimpleOnGestureListener {
        @Override
        public boolean onDown(MotionEvent e) {
            return super.onDown(e);
        }

        @Override
        public boolean onDoubleTap(MotionEvent e) {
            Log.d("GESTURE", "dt");
            return super.onDoubleTap(e);
        }
    }

    private void addData() {
        final Dialog dialog = new Dialog(this, R.style.Theme_AppCompat_DayNight_DarkActionBar);
        dialog.setContentView(R.layout.adddialog);

        Button ok = dialog.findViewById(R.id.dialogButtonOK);
        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SliderTimePicker startedAt = dialog.findViewById(R.id.startedAt);
                SliderTimePicker endedAt = dialog.findViewById(R.id.endedAt);
                model.add(startedAt.getInstant(), endedAt.getInstant());
                adapter.notifyItemInserted(0);
                dialog.dismiss();
            }
        });

        dialog.show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
