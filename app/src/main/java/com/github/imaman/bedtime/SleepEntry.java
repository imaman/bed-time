package com.github.imaman.bedtime;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class SleepEntry {
    public LocalDateTime from;
    public LocalDateTime to;
    private Duration duration;
    public LocalDate date;

    public SleepEntry(LocalDateTime from, LocalDateTime to, LocalDate date) {
        this.from = from;
        this.to = to;
        this.date = date;
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
