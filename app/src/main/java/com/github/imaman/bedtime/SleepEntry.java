package com.github.imaman.bedtime;

import java.time.Duration;
import java.time.LocalDateTime;

public class SleepEntry {
    public LocalDateTime from;
    public LocalDateTime to;
    private Duration duration;

    public SleepEntry(LocalDateTime from, LocalDateTime to) {
        this.from = from;
        this.to = to;
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
    }
}
