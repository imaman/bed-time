package com.github.imaman.bedtime;

import java.time.Duration;
import java.time.LocalDateTime;

public class SleepEntry {
    private final LocalDateTime from;
    private final LocalDateTime to;

    public SleepEntry(LocalDateTime from, LocalDateTime to) {
        this.from = from;
        this.to = to;
    }

    @Override
    public String toString() {
        Duration d = Duration.between(from, to);
        return d.toString();
    }
}
