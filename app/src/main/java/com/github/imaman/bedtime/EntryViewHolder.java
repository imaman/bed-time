package com.github.imaman.bedtime;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

class EntryViewHolder extends RecyclerView.ViewHolder {

    public EntryViewHolder(@NonNull EntryView itemView) {
        super(itemView);
    }

    private EntryView getEntryView() {
        return (EntryView) itemView;
    }

    public void assign(SleepEntry se) {
        getEntryView().assign(se);
    }
}
