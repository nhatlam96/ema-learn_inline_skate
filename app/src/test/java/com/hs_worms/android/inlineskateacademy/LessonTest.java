package com.hs_worms.android.inlineskateacademy;

import static org.junit.Assert.*;

import org.junit.Test;

public class LessonTest {

    @Test
    public void testGetTitle() {
        String title = "Lesson Title";
        Lesson lesson = new Lesson(title, "Description", R.drawable.novice_image, R.color.expert, "https://hs-worms.de");

        assertEquals(title, lesson.getTitle());
    }

    @Test
    public void testGetWebLink() {
        String webLink = "https://hs-worms.de";
        Lesson lesson = new Lesson("Lesson Title", "Description", R.drawable.novice_image, R.color.expert, webLink);

        assertEquals(webLink, lesson.getWebLink());
    }
}