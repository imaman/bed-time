package com.github.imaman.bedtime;

import android.app.Dialog;
import android.content.Context;
import android.util.Log;
import android.view.View;

public class EditDialog {
    private final Model model;
    private final Context context;
    private final EntryAdapter adapter;

    public EditDialog(Model model, Context context, EntryAdapter adapter) {
        this.model = model;
        this.context = context;
        this.adapter = adapter;
    }

    public void run() {
        final Dialog dialog = new Dialog(context); //, R.style.Theme_AppCompat_DayNight_DarkActionBar);
        dialog.setContentView(R.layout.adddialog);

        dialog.findViewById(R.id.dialogButtonOK).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SliderTimePickerView startedAt = dialog.findViewById(R.id.startedAt);
                SliderTimePickerView endedAt = dialog.findViewById(R.id.endedAt);
                model.add(startedAt.getInstant(), endedAt.getInstant());
                adapter.notifyItemInserted(0);
                dialog.dismiss();
            }
        });

        dialog.show();

    }

    public void edit(SleepEntry se) {
        final Dialog dialog = new Dialog(context); //, R.style.Theme_AppCompat_DayNight_DarkActionBar);
        dialog.setContentView(R.layout.adddialog);

        SliderTimePickerView startedAt = dialog.findViewById(R.id.startedAt);
        startedAt.setInstant(se.from);

        SliderTimePickerView endedAt = dialog.findViewById(R.id.endedAt);
        endedAt.setInstant(se.to);

        dialog.findViewById(R.id.dialogButtonOK).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("AAA", "clicked");
//                SliderTimePickerView startedAt = dialog.findViewById(R.id.startedAt);
//                SliderTimePickerView endedAt = dialog.findViewById(R.id.endedAt);
//                model.add(startedAt.getInstant(), endedAt.getInstant());
//                adapter.notifyItemInserted(0);
                dialog.dismiss();
            }
        });

        dialog.show();
    }
}
