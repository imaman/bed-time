package com.github.imaman.bedtime;

import java.util.Date;

public class SleepEntry {
    private final Date from;
    private final Date to;

    public SleepEntry(Date from, Date to) {
        this.from = from;
        this.to = to;
    }
}
