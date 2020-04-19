package pl.szarek.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class FirstActivity extends AppCompatActivity {
    private Button mainActivityButton;
    private Button secondActivityButton;
    private TextView intTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);

        findViews();
        setListeners();

        int number = getIntent().getExtras().getInt("key_int");
        intTextView.setText(String.valueOf(number));
    }

    private void findViews() {
        mainActivityButton = findViewById(R.id.main_activity_button);
        secondActivityButton = findViewById(R.id.second_activity_button);
        intTextView = findViewById(R.id.int_text_view);
    }

    private void setListeners() {
        mainActivityButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToMainActivity();
            }
        });

        secondActivityButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToSecondActivity();
            }
        });
    }

    private void goToMainActivity() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    private void goToSecondActivity() {
        Intent intent = new Intent(this, SecondActivity.class);
        intent.putExtra("key_string", "Test string");
        startActivity(intent);
    }
}
