package com.hs_worms.android.inlineskateacademy;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.splashscreen.SplashScreen;

public class MainActivity extends AppCompatActivity {

    private static final Handler handler = new Handler(Looper.getMainLooper());
    private CardView noviceCardView, regularCardView, expertCardView, theoryCardView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SplashScreen.installSplashScreen(this);
        setContentView(R.layout.activity_main);
        setTitle(R.string.main_title);

        findViews();
        setupClickListeners();
        handler.post(() -> Toast.makeText(this, getString(R.string.activity_main_toast), Toast.LENGTH_SHORT).show());
    }

    private void findViews() {
        noviceCardView = findViewById(R.id.novice_cardview);
        regularCardView = findViewById(R.id.regular_cardview);
        expertCardView = findViewById(R.id.expert_cardview);
        theoryCardView = findViewById(R.id.theory_cardview);
    }

    private void setupClickListeners() {
        noviceCardView.setOnClickListener(view -> switchToCategory(NoviceCategoryActivity.class));
        regularCardView.setOnClickListener(view -> switchToCategory(RegularCategoryActivity.class));
        expertCardView.setOnClickListener(view -> switchToCategory(ExpertCategoryActivity.class));
        theoryCardView.setOnClickListener(view -> switchToCategory(TheoryCategoryActivity.class));
    }

    private void switchToCategory(Class<?> categoryActivityClass) {
        Intent intent = new Intent(this, categoryActivityClass);
        startActivity(intent);
    }
}