package com.github.imaman.bedtime;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface RecordDao {
    @Query("SELECT * FROM record")
    List<Record> getAll();

//    @Query("SELECT * FROM record WHERE uid IN (:userIds)")
//    List<Record> loadAllByIds(int[] userIds);

//    @Query("SELECT * FROM user WHERE first_name LIKE :first AND " +
//           "last_name LIKE :last LIMIT 1")
//    Record findByName(String first, String last);

    @Insert
    void insertAll(Record... users);

    @Delete
    void delete(Record se);
}