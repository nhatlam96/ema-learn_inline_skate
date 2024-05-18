package com.hs_worms.android.inlineskateacademy;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;
@Dao
public interface LessonNoteDAO {

    @Insert
    void addLessonNote(LessonNote lessonNote);
    @Update
    void updateLessonNote(LessonNote lessonNote);

    @Query("select * from lesson_note where id == :lessonNote_id")
    LessonNote getLessonNote(String lessonNote_id);
}
