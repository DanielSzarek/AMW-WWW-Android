package pl.szarek.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {
    private Button firstActivityButton;
    private Button mainActivityButton;
    private TextView stringTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        findViews();
        setListeners();

        String text = getIntent().getExtras().getString("key_string");
        stringTextView.setText(text);
    }

    private void findViews() {
        firstActivityButton = findViewById(R.id.first_activity_button);
        mainActivityButton = findViewById(R.id.main_activity_button);
        stringTextView = findViewById(R.id.string_text_view);
    }

    private void setListeners() {
        firstActivityButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToFirstActivity();
            }
        });

        mainActivityButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToMainActivity();
            }
        });
    }

    private void goToFirstActivity() {
        Intent intent = new Intent(this, FirstActivity.class);
        intent.putExtra("key_int", 123);
        startActivity(intent);
    }

    private void goToMainActivity() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
