package com.hs_worms.android.inlineskateacademy;

import android.content.Intent;

import androidx.core.content.ContextCompat;

public class ExpertCategoryActivity extends BaseCategoryActivity {

    @Override
    protected int getCategoryTitle() {
        return R.string.expert_title;
    }
    @Override
    protected Lesson[] getLessons() {
        return new Lesson[] {
                new Lesson(getString(R.string.expert_lesson_1_title), getString(R.string.expert_lesson_1_description), R.drawable.baseline_filter_1_24, ContextCompat.getColor(this, R.color.expert), ""),
                new Lesson(getString(R.string.expert_lesson_2_title), getString(R.string.expert_lesson_2_description), R.drawable.baseline_filter_2_24, ContextCompat.getColor(this, R.color.expert), ""),
                new Lesson(getString(R.string.expert_lesson_3_title), getString(R.string.expert_lesson_3_description), R.drawable.baseline_filter_3_24, ContextCompat.getColor(this, R.color.expert), ""),
                new Lesson(getString(R.string.expert_lesson_4_title), getString(R.string.expert_lesson_4_description), R.drawable.baseline_filter_4_24, ContextCompat.getColor(this, R.color.expert), ""),
                new Lesson(getString(R.string.expert_lesson_5_title), getString(R.string.expert_lesson_5_description), R.drawable.baseline_filter_5_24, ContextCompat.getColor(this, R.color.expert), "")
        };
    }
    @Override
    protected Intent getIntentForLesson(Lesson lesson) {
        Intent intent = null;
        if (getString(R.string.expert_lesson_1_title).equals(lesson.getTitle())) {
            intent = new Intent(this, ExpertLesson1Activity.class);
        } else if (getString(R.string.expert_lesson_2_title).equals(lesson.getTitle())) {
            intent = new Intent(this, ExpertLesson2Activity.class);
        } else if (getString(R.string.expert_lesson_3_title).equals(lesson.getTitle())) {
            intent = new Intent(this, ExpertLesson3Activity.class);
        } else if (getString(R.string.expert_lesson_4_title).equals(lesson.getTitle())) {
            intent = new Intent(this, ExpertLesson4Activity.class);
        } else if (getString(R.string.expert_lesson_5_title).equals(lesson.getTitle())) {
            intent = new Intent(this, ExpertLesson5Activity.class);
        }
        return intent;
    }
}