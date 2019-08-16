package com.github.imaman.bedtime;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

class EntryAdapter extends RecyclerView.Adapter<EntryViewHolder> {
    private final Model model;

    EntryAdapter(Model model) {
        this.model= model;
    }

    @NonNull
    @Override
    public EntryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.my_text_view, parent, false);
        return new EntryViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull EntryViewHolder holder, int position) {
        holder.assign(model.get(position));
    }

    @Override
    public int getItemCount() {
        return model.size();
    }
}
