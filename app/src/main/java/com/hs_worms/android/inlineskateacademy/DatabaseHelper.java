package com.hs_worms.android.inlineskateacademy;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class DatabaseHelper {

    private final LessonNoteDAO lessonNoteDAO;
    private final ExecutorService executorService;

    public DatabaseHelper(Context context) {
        RoomDatabase.Callback roomCallback = new RoomDatabase.Callback() {
            @Override
            public void onCreate(@NonNull SupportSQLiteDatabase db) {
                super.onCreate(db);
            }

            @Override
            public void onOpen(@NonNull SupportSQLiteDatabase db) {
                super.onOpen(db);
            }
        };
        LessonNoteDatabase lessonNoteDatabase = Room.databaseBuilder(context, LessonNoteDatabase.class, "lessonNoteDatabase")
                .addCallback(roomCallback)
                .build();
        lessonNoteDAO = lessonNoteDatabase.getLessonNoteDAO();
        executorService = Executors.newSingleThreadExecutor();
    }

    public void updateLessonNoteBackground(String noteId, String note) {
        LessonNote lessonNote = new LessonNote(noteId, note);
        executorService.execute(() -> {
            try {
                lessonNoteDAO.updateLessonNote(lessonNote);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public LessonNote loadLessonNoteBackground(String noteId) {
        try {
            LessonNote lessonNote = lessonNoteDAO.getLessonNote(noteId);
            if (lessonNote == null) {
                lessonNote = new LessonNote(noteId, "");
                lessonNoteDAO.addLessonNote(lessonNote);
            }
            return lessonNote;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}