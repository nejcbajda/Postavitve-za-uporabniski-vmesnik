package com.example.uporabniski_vmesnik;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private int mCount = 0;
    private TextView mShowCount;
    private Button mButtonZero;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        mShowCount = findViewById(R.id.show_count);
        mButtonZero = findViewById(R.id.button_zero);
    }

    public void showToast(View view) {
        Toast.makeText(this, R.string.toast_message, Toast.LENGTH_SHORT).show();
    }

    public void countUp(View view) {
        mCount++;
        mShowCount.setText(String.valueOf(mCount));

        // barva gumba Count glede na sodo/liho vrednost (parameter view)
        if (mCount % 2 == 0) {
            view.setBackgroundColor(Color.GREEN);
        } else {
            view.setBackgroundColor(Color.BLUE);
        }

        // gumb Zero je zdaj aktiven
        mButtonZero.setBackgroundColor(Color.MAGENTA);
    }

    public void zeroCount(View view) {
        mCount = 0;
        mShowCount.setText(String.valueOf(mCount));
        view.setBackgroundColor(Color.GRAY);
    }
}