package com.github.imaman.bedtime;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class SleepEntry {
    public final String id;
    public LocalTime from;
    public LocalTime to;
    private Duration duration;
    public LocalDate date;

    public SleepEntry(LocalTime from, LocalTime to, LocalDate date, String id) {
        this.from = from;
        this.to = to;
        this.date = date;
        this.id = id;
        this.duration = Duration.between(from, to);
    }

    @Override
    public String toString() {
        long h = duration.toMinutes() / 60;
        long m = duration.toMinutes() % 60;

        return String.format("%dh%dm", h, m);
    }

    public void copyFrom(SleepEntry that) {
        this.from = that.from;
        this.to = that.to;
        this.duration = that.duration;
        this.date = that.date;
    }
}
