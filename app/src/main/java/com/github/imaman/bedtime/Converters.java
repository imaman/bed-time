package com.github.imaman.bedtime;

import androidx.room.TypeConverter;

import java.time.LocalDate;
import java.time.LocalTime;

public class Converters {
    @TypeConverter
    public static LocalTime fromTimestamp(Integer value) {
        return value == null ? null : LocalTime.ofSecondOfDay(value);
    }

    @TypeConverter
    public static Integer dateToTimestamp(LocalTime t) {
        return t == null ? null : t.toSecondOfDay();
    }

    @TypeConverter
    public static LocalDate localDateFromLong(Long value) {
        return value == null ? null : LocalDate.ofEpochDay(value);
    }

    @TypeConverter
    public static Long longFromLocalDate(LocalDate t) {
        return t == null ? null : t.toEpochDay();
    }
}
