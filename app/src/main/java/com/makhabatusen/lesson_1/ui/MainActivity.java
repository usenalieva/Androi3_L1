package com.makhabatusen.lesson_1.ui;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.makhabatusen.lesson_1.R;
import com.makhabatusen.lesson_1.ui.adapter.EmojiAdapter;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    private void init() {
        RecyclerView recyclerView = findViewById(R.id.rv_cards);
        EmojiAdapter emojiAdapter = new EmojiAdapter(new EmojiGame(this));
        recyclerView.setAdapter(emojiAdapter);
    }

}