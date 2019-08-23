package com.github.imaman.bedtime;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
public class Record {
    @PrimaryKey
    @NonNull
    public String id;

    public LocalTime from;
    public LocalTime to;
    public LocalDate date;

    public static Record of(SleepEntry se) {
        Record ret = new Record();
        ret.id = se.id;
        ret.from = se.from;
        ret.to = se.to;
        ret.date = se.date;
        return ret;
    }
}
