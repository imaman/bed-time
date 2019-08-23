package com.github.imaman.bedtime;

import android.app.Dialog;
import android.content.Context;
import android.util.Log;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TextView;

import java.time.LocalDate;

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

        LocalDate d = LocalDate.now();
        DatePicker dp = dialog.findViewById(R.id.datePicker);
        dp.init(d.getYear(), d.getMonthValue() - 1, d.getDayOfMonth(), null);

        dialog.findViewById(R.id.dialogButtonOK).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SleepEntry se = getSleepEntry(dialog);
                model.add(se);
                adapter.notifyItemInserted(0);
                dialog.dismiss();
            }
        });

        dialog.show();

    }

    private SleepEntry getSleepEntry(Dialog dialog) {
        SliderTimePickerView startedAt = dialog.findViewById(R.id.startedAt);
        SliderTimePickerView endedAt = dialog.findViewById(R.id.endedAt);

        DatePicker dp = dialog.findViewById(R.id.datePicker);
        LocalDate d = LocalDate.of(dp.getYear(), dp.getMonth() + 1, dp.getDayOfMonth());


        return new SleepEntry(startedAt.getInstant(), endedAt.getInstant(), d);
    }

    public void edit(final SleepEntry se) {
        final Dialog dialog = new Dialog(context); //, R.style.Theme_AppCompat_DayNight_DarkActionBar);
        dialog.setContentView(R.layout.adddialog);

        SliderTimePickerView startedAt = dialog.findViewById(R.id.startedAt);
        startedAt.setInstant(se.from);

        SliderTimePickerView endedAt = dialog.findViewById(R.id.endedAt);
        endedAt.setInstant(se.to);

        DatePicker dp = dialog.findViewById(R.id.datePicker);
        dp.init(se.date.getYear(), se.date.getMonthValue() - 1, se.date.getDayOfMonth(), null);

        dialog.findViewById(R.id.dialogButtonOK).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SleepEntry newEntry = getSleepEntry(dialog);
                se.copyFrom(newEntry);
                int index = model.update(se);
                adapter.notifyItemChanged(index);
                dialog.dismiss();
            }
        });

        dialog.show();
    }
}
