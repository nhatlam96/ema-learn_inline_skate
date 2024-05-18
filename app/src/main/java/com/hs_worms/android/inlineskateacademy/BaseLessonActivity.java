package com.hs_worms.android.inlineskateacademy;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public abstract class BaseLessonActivity extends AppCompatActivity {

    protected abstract int getNoteId();
    protected abstract int getYouTubeVideoEmbedCode();
    protected abstract int getTutorialText();

    private static String NOTE_ID;
    private EditText editLessonNote;
    private DatabaseHelper databaseHelper;
    private static final Handler handler = new Handler(Looper.getMainLooper());

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base_lesson);
        NOTE_ID = getString(getNoteId());

        defineContentView();
        databaseHelper = new DatabaseHelper(this);

        loadLessonNoteInBackground();
    }

    private void loadLessonNoteInBackground() {
        new Thread(() -> {
            LessonNote lessonNote = databaseHelper.loadLessonNoteBackground(NOTE_ID);
            handler.post(() -> displayLessonNote(lessonNote));
        }).start();
    }

    private void displayLessonNote(LessonNote lessonNote) {
        if (lessonNote != null) {
            editLessonNote.setText(lessonNote.getNote());
        } else {
            handler.post(() -> Toast.makeText(this, getString(R.string.error_load_note), Toast.LENGTH_SHORT).show());
        }
    }

    @SuppressLint("SetJavaScriptEnabled")
    private void defineContentView() {
        // Init WebView for YouTube video
        WebView webView = findViewById(R.id.base_lesson_web_view);
        String video = getString(getYouTubeVideoEmbedCode());
        webView.loadData(video, "text/html", "utf-8");
        webView.getSettings().setJavaScriptEnabled(true);
        webView.setWebChromeClient(new WebChromeClient());

        // Init TextView for tutorial
        TextView textView = findViewById(R.id.base_lesson_text_view);
        textView.setText(getTutorialText());

        // Init EditText for lesson note
        editLessonNote = findViewById(R.id.base_lesson_edit_text);

        // Init Button for updating lesson note
        Button updateLessonNote = findViewById(R.id.base_lesson_button);
        updateLessonNote.setOnClickListener(v -> updateLessonNoteBackground());
    }

    private void updateLessonNoteBackground() {
        String note = editLessonNote.getText().toString();
        databaseHelper.updateLessonNoteBackground(NOTE_ID, note);
        handler.post(() -> Toast.makeText(this, getString(R.string.note_updated), Toast.LENGTH_SHORT).show());
    }
}