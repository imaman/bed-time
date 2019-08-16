package com.github.imaman.bedtime;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

class EntryViewHolder extends RecyclerView.ViewHolder {

    public EntryViewHolder(@NonNull View itemView) {
        super(itemView);
    }

    public void assign(SleepEntry se) {
        TextView textView = itemView.findViewById(R.id.entryText);
        textView.setText("p=" + se);
    }
}
