package com.hs_worms.android.inlineskateacademy;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "lesson_note")
public class LessonNote {

    @ColumnInfo(name = "id")
    @PrimaryKey
    @NonNull
    private final String id;

    @ColumnInfo(name = "note")
    private final String note;

    public LessonNote(@NonNull String id, String note) {
        this.id = id;
        this.note = note;
    }

    @NonNull
    public String getId() {
        return id;
    }

    public String getNote() {
        return note;
    }
}