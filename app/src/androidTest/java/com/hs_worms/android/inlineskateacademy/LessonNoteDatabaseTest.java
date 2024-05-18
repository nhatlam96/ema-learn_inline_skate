package com.hs_worms.android.inlineskateacademy;

import static org.junit.Assert.assertNotNull;

import android.content.Context;

import androidx.room.Room;
import androidx.test.core.app.ApplicationProvider;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
public class LessonNoteDatabaseTest {

    private LessonNoteDatabase lessonNoteDatabase;
    private LessonNoteDAO lessonNoteDAO;

    @Before
    public void setUp() {
        Context context = ApplicationProvider.getApplicationContext();
        lessonNoteDatabase = Room.inMemoryDatabaseBuilder(context, LessonNoteDatabase.class).build();
        lessonNoteDAO = lessonNoteDatabase.getLessonNoteDAO();
    }

    @After
    public void tearDown() {
        lessonNoteDatabase.close();
    }

    @Test
    public void testGetLessonNoteDAO() {
        assertNotNull(lessonNoteDAO);
    }
}