package com.github.imaman.bedtime;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class SliderTimePickerView extends RelativeLayout {

    private static final int MAX = 96;
    private static final int MINUTES_IN_DAY = 1440;

    public SliderTimePickerView(Context context, AttributeSet as) {
        super(context, as);

        LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.slidertimepicker, this, true);


        final TextView text = this.findViewById(R.id.text);
        SeekBar from = this.findViewById(R.id.seekBar);

        from.setMax(MAX - 1);
        from.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                text.setText(String.format("%02d:%02d", hours(), minutes()));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {}

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {}
        });



    }

    private int hours() {
        SeekBar sb = this.findViewById(R.id.seekBar);
        int minutes = (sb.getProgress() * MINUTES_IN_DAY) / MAX;
        return minutes / 60;
    }

    private int minutes() {
        SeekBar sb = this.findViewById(R.id.seekBar);
        int minutes = (sb.getProgress() * MINUTES_IN_DAY) / MAX;
        return minutes % 60;
    }

    public LocalDateTime getInstant() {
        LocalDateTime sod = LocalDate.now().atStartOfDay();
        LocalDateTime ret = sod.plusHours(hours()).plusMinutes(minutes());
        return ret;
    }

    public void setInstant(LocalDateTime ldt) {
        int h = ldt.getHour();
        int m =  ldt.getMinute();

        int minutes = h * 60 + m;

        SeekBar sb = this.findViewById(R.id.seekBar);
        sb.setProgress((minutes * MAX)/MINUTES_IN_DAY);
    }
}
