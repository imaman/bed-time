package com.github.imaman.bedtime;


import android.content.Context;
import android.view.LayoutInflater;
import android.widget.LinearLayout;

public class EntryView extends LinearLayout {
    public EntryView(Context context) {
        super(context);

        LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.entry, this, true);

    }
}
