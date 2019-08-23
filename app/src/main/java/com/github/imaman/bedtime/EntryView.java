package com.github.imaman.bedtime;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.time.DayOfWeek;
import java.time.format.DateTimeFormatter;

public class EntryView extends LinearLayout {

    private final EntryAction onEdit;
    private SleepEntry sleepEntry;

    public EntryView(Context context, EntryAction onEdit) {
        super(context);
        this.onEdit = onEdit;

        LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.entry, this, true);

        this.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                clicked();
            }
        });
    }

    private void clicked() {
        if (sleepEntry == null) {
            return;
        }

        onEdit.run(sleepEntry);
    }

    public void assign(SleepEntry se) {
        this.sleepEntry = se;
        TextView textView = findViewById(R.id.entryText);
        textView.setText(se.toString());

        TextView day = findViewById(R.id.day);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("EEE");
        day.setText(formatter.format(se.date.getDayOfWeek()).toUpperCase());
        TextView date = findViewById(R.id.date);
        date.setText(se.date.toString());


        boolean isWeekend = se.date.getDayOfWeek() == DayOfWeek.FRIDAY || se.date.getDayOfWeek() == DayOfWeek.SATURDAY;
        this.setBackgroundResource(isWeekend ? R.color.entryWeekend: R.color.entryWorkday);
    }
}
