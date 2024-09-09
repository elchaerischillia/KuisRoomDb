package com.elcha.uts.kuis.data.dao;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.elcha.uts.kuis.data.entity.Mahasiswa;

import java.util.List;

@Dao
public interface MahasiswaDao {
    @Query("SELECT * FROM mahasiswa")
    List<Mahasiswa> getAll();

    @Query("SELECT * FROM mahasiswa WHERE uid IN (:userIds)")
    List<Mahasiswa> loadAllByIds(int[] userIds);

    @Query("SELECT * FROM mahasiswa WHERE first_name LIKE :first AND last_name LIKE :last LIMIT 1")
    Mahasiswa findByName(String first, String last);

    @Insert
    void insertAll(Mahasiswa... mahasiswa);

    @Delete
    void delete(Mahasiswa mahasiswa);
}
