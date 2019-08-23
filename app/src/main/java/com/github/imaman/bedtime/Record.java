package com.github.imaman.bedtime;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.time.LocalTime;

@Entity
public class Record {
    @PrimaryKey
    public int uid;

    @ColumnInfo(name = "from")
    public LocalTime from;

    @ColumnInfo(name = "to")
    public LocalTime to;


}
