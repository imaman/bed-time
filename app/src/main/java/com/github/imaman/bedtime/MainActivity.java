package com.github.imaman.bedtime;

import android.os.Bundle;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private final Model model = new Model();

    private EntryAdapter adapter = new EntryAdapter(model);
    private final EditDialog editDialog = new EditDialog(model, this, adapter);
    private RecordDao dao;

    MainActivity() {
        model.add(
            LocalTime.of(10, 15),
            LocalTime.of(20, 15),
            LocalDate.of(2019, 8, 3));
        model.add(
            LocalTime.of(3, 15),
            LocalTime.of(20, 15),
            LocalDate.of(2019, 8, 2));
        model.add(
            LocalTime.of(3, 15),
            LocalTime.of(8, 15),
            LocalDate.of(2019, 8, 1));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        AppDatabase db = Room.databaseBuilder(getApplicationContext(),
                AppDatabase.class, "bedtime-database").build();
        dao = db.recordDao();
        for (Record r : dao.getAll()) {
//            model.add(r);
        }

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        final FloatingActionButton fab = findViewById(R.id.fab);


        EntryAction onEdit = new EntryAction() {
            @Override
            public void run(SleepEntry se) {
                editDialog.edit(se);
            }
        };

        this.adapter.setOnEdit(onEdit);

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
    }


    private void addData() {
        editDialog.run();
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
