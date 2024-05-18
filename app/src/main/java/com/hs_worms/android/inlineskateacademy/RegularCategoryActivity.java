package com.hs_worms.android.inlineskateacademy;

import android.content.Intent;

import androidx.core.content.ContextCompat;

public class RegularCategoryActivity extends BaseCategoryActivity {

    @Override
    protected int getCategoryTitle() {
        return R.string.regular_title;
    }
    @Override
    protected Lesson[] getLessons() {
        return new Lesson[] {
                new Lesson(getString(R.string.regular_lesson_1_title), getString(R.string.regular_lesson_1_description), R.drawable.baseline_filter_1_24, ContextCompat.getColor(this, R.color.regular), ""),
                new Lesson(getString(R.string.regular_lesson_2_title), getString(R.string.regular_lesson_2_description), R.drawable.baseline_filter_2_24, ContextCompat.getColor(this, R.color.regular), ""),
                new Lesson(getString(R.string.regular_lesson_3_title), getString(R.string.regular_lesson_3_description), R.drawable.baseline_filter_3_24, ContextCompat.getColor(this, R.color.regular), ""),
                new Lesson(getString(R.string.regular_lesson_4_title), getString(R.string.regular_lesson_4_description), R.drawable.baseline_filter_4_24, ContextCompat.getColor(this, R.color.regular), ""),
                new Lesson(getString(R.string.regular_lesson_5_title), getString(R.string.regular_lesson_5_description), R.drawable.baseline_filter_5_24, ContextCompat.getColor(this, R.color.regular), "")
        };
    }
    @Override
    protected Intent getIntentForLesson(Lesson lesson) {
        Intent intent = null;
        if (getString(R.string.regular_lesson_1_title).equals(lesson.getTitle())) {
            intent = new Intent(this, RegularLesson1Activity.class);
        } else if (getString(R.string.regular_lesson_2_title).equals(lesson.getTitle())) {
            intent = new Intent(this, RegularLesson2Activity.class);
        } else if (getString(R.string.regular_lesson_3_title).equals(lesson.getTitle())) {
            intent = new Intent(this, RegularLesson3Activity.class);
        } else if (getString(R.string.regular_lesson_4_title).equals(lesson.getTitle())) {
            intent = new Intent(this, RegularLesson4Activity.class);
        } else if (getString(R.string.regular_lesson_5_title).equals(lesson.getTitle())) {
            intent = new Intent(this, RegularLesson5Activity.class);
        }
        return intent;
    }
}