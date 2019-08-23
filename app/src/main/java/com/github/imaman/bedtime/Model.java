package com.github.imaman.bedtime;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Model {
    private final List<SleepEntry> entries = new ArrayList<>();

    public int size() {
        return entries.size();
    }

    public SleepEntry get(int externalIndex) {
        return entries.get(toggleIndex(externalIndex));
    }

    private int toggleIndex(int index) {
        return this.size() - index - 1;
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
        return toggleIndex(index);
    }

    public void add(LocalDateTime from, LocalDateTime to) {
        add(new SleepEntry(from, to));
    }
}
