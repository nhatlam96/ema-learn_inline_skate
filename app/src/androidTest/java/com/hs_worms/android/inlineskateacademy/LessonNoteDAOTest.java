package com.hs_worms.android.inlineskateacademy;

import static org.junit.Assert.assertEquals;

import androidx.room.Room;
import androidx.test.core.app.ApplicationProvider;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class LessonNoteDAOTest {

    private LessonNoteDatabase database;
    private LessonNoteDAO lessonNoteDAO;

    @Before
    public void setUp() {
        database = Room.inMemoryDatabaseBuilder(
                        ApplicationProvider.getApplicationContext(),
                        LessonNoteDatabase.class)
                .allowMainThreadQueries() // Only for testing purposes
                .build();
        lessonNoteDAO = database.getLessonNoteDAO();
    }

    @After
    public void tearDown() {
        database.close();
    }

    @Test
    public void testAddAndGetLessonNote() {
        LessonNote lessonNote = new LessonNote("1", "Sample note");
        lessonNoteDAO.addLessonNote(lessonNote);

        LessonNote retrievedNote = lessonNoteDAO.getLessonNote("1");

        assertEquals("Sample note", retrievedNote.getNote());
    }
}