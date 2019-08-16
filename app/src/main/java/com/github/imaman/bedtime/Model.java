package com.github.imaman.bedtime;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Model {
    private final List<SleepEntry> entries = new ArrayList<>();

    public int size() {
        return entries.size();
    }

    public SleepEntry get(int index) {
        return entries.get(this.size() - index - 1);
    }

    public void add(LocalDateTime from, LocalDateTime to) {
        SleepEntry se = new SleepEntry(from, to);
        entries.add(se);
    }
}
