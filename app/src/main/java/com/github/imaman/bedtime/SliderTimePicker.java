package com.github.imaman.bedtime;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;

public class SliderTimePicker extends RelativeLayout {

    private static final int MAX = 96;
    private static final int MINUTES_IN_DAY = 1440;

    public SliderTimePicker(Context context, AttributeSet as) {
        super(context, as);

        LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.slidertimepicker, this, true);


        final TextView text = (TextView) this.findViewById(R.id.text);
        SeekBar from = (SeekBar) this.findViewById(R.id.seekBar);

        from.setMax(MAX - 1);
        from.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                int minutes = (i * MINUTES_IN_DAY) / MAX;
                int hh = minutes / 60;
                int mm = minutes % 60;
                text.setText(String.format("%02d:%02d", hh, mm));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {}

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {}
        });



    }
}
