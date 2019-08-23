package com.github.imaman.bedtime;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

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

    public void add(LocalTime from, LocalTime to, LocalDate date) {
        add(new SleepEntry(from, to, date, UUID.randomUUID().toString()));
    }

    public void load(List<Record> records) {
        this.entries.clear();
        for (Record r : records) {
            SleepEntry se = new SleepEntry(r.from, r.to, r.date, r.id);
            add(se);
        }
    }
}
