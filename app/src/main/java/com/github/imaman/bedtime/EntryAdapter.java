package com.github.imaman.bedtime;

import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

class EntryAdapter extends RecyclerView.Adapter<EntryViewHolder> {
    private final Model model;
    private EntryAction onEdit;

    EntryAdapter(Model model) {
        this.model= model;
    }


    void setOnEdit(EntryAction ea) {
        this.onEdit = ea;
    }

    @NonNull
    @Override
    public EntryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        EntryView v = new EntryView(parent.getContext(), new EntryAction() {
            @Override
            public void run(SleepEntry se) {
                onEdit.run(se);
            }
        });
//        v.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Log.d("APPACT", "click");
//            }
//        });
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
