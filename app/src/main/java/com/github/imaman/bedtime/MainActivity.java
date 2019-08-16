package com.github.imaman.bedtime;

import android.app.Dialog;
import android.os.Bundle;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private MyAdapter mAdapter;

    static class MyViewHolder extends RecyclerView.ViewHolder {

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
        }

        public void assign(int position) {
            TextView textView = (TextView) itemView.findViewById(R.id.entryText);
            textView.setText("p=" + position);
        }
    }

    static class MyAdapter extends RecyclerView.Adapter<MyViewHolder> {
        private final SleepEntry[] entries;

        MyAdapter(SleepEntry[] entries) {
            this.entries = entries;
        }

        @NonNull
        @Override
        public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View v = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.my_text_view, parent, false);
            return new MyViewHolder(v);
        }

        @Override
        public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
            holder.assign(position);
        }

        @Override
        public int getItemCount() {
            return entries.length;
        }
    }
    private RecyclerView recyclerView;

    private SleepEntry[] myDataset = new SleepEntry[100];
    
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


        this.recyclerView = (RecyclerView) findViewById(R.id.entries);

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        recyclerView.setHasFixedSize(true);

        // use a linear layout manager
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        // specify an adapter (see also next example)
        mAdapter = new MyAdapter(myDataset);
        recyclerView.setAdapter(mAdapter);
    }


    private void addData() {
        final Dialog dialog = new Dialog(this, R.style.Theme_AppCompat_DayNight_DarkActionBar);
        dialog.setContentView(R.layout.adddialog);

        Button dialogButton = (Button) dialog.findViewById(R.id.dialogButtonOK);
        dialogButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
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
