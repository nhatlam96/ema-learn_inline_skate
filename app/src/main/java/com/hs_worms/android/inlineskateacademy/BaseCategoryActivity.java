package com.hs_worms.android.inlineskateacademy;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

public abstract class BaseCategoryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base_category);

        setupTitle();
        setupRecyclerView();
    }

    private void setupTitle() {
        setTitle(getCategoryTitle());
    }

    private void setupRecyclerView() {
        RecyclerView recyclerView = findViewById(R.id.recycler_view_base_category);
        Lesson[] lessons = getLessons();
        LessonAdapter.OnItemClickListener listener = lesson -> {
            Intent intent = getIntentForLesson(lesson);
            if (intent != null) {
                startActivity(intent);
            }
        };
        LessonAdapter adapter = new LessonAdapter(lessons);
        adapter.setOnItemClickListener(listener);
        recyclerView.setAdapter(adapter);
    }

    protected abstract int getCategoryTitle();
    protected abstract Lesson[] getLessons();
    protected abstract Intent getIntentForLesson(Lesson lesson);
}