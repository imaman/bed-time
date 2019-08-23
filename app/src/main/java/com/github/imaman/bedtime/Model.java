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

    public void add(SleepEntry se) {
        entries.add(se);
    }

    public int update(SleepEntry se) {
        int index = this.entries.indexOf(se);
        if (index < 0) {
            throw new RuntimeException("Could not find an entry (" + se + ")");
        }

//        entries.set(index, newOne);
        return index;
    }

    public void add(LocalDateTime from, LocalDateTime to) {
        add(new SleepEntry(from, to));
    }
}
