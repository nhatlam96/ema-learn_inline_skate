package com.hs_worms.android.inlineskateacademy;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;

import androidx.core.content.ContextCompat;

public class TheoryCategoryActivity extends BaseCategoryActivity implements LessonAdapter.OnItemClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected int getCategoryTitle() {
        return R.string.theory_title;
    }

    @Override
    protected Lesson[] getLessons() {
        return new Lesson[] {
                new Lesson(getString(R.string.theory_lesson_1_title), getString(R.string.theory_lesson_1_description), R.drawable.baseline_filter_1_24, ContextCompat.getColor(this, R.color.theory), getString(R.string.theory_lesson_1_weblink)),
                new Lesson(getString(R.string.theory_lesson_2_title), getString(R.string.theory_lesson_2_description), R.drawable.baseline_filter_2_24, ContextCompat.getColor(this, R.color.theory), getString(R.string.theory_lesson_2_weblink)),
                new Lesson(getString(R.string.theory_lesson_3_title), getString(R.string.theory_lesson_3_description), R.drawable.baseline_filter_3_24, ContextCompat.getColor(this, R.color.theory), getString(R.string.theory_lesson_3_weblink)),
                new Lesson(getString(R.string.theory_lesson_4_title), getString(R.string.theory_lesson_4_description), R.drawable.baseline_filter_4_24, ContextCompat.getColor(this, R.color.theory), getString(R.string.theory_lesson_4_weblink)),
                new Lesson(getString(R.string.theory_lesson_5_title), getString(R.string.theory_lesson_5_description), R.drawable.baseline_filter_5_24, ContextCompat.getColor(this, R.color.theory), getString(R.string.theory_lesson_5_weblink))
        };
    }

    @Override
    protected Intent getIntentForLesson(Lesson lesson) {
        String webLink = lesson.getWebLink();
        if (!TextUtils.isEmpty(webLink)) {
            return new Intent(Intent.ACTION_VIEW, Uri.parse(webLink));
        }
        return null;
    }

    @Override
    public void onItemClick(Lesson lesson) {
        String webLink = lesson.getWebLink();
        if (!TextUtils.isEmpty(webLink)) {
            Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(webLink));
            startActivity(browserIntent);
        }
    }
}