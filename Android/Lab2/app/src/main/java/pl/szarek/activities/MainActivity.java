package pl.szarek.activities;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    private Button firstActivityButton;
    private Button secondActivityButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViews();
        setListeners();
    }

    private void findViews() {
        firstActivityButton = findViewById(R.id.first_activity_button);
        secondActivityButton = findViewById(R.id.second_activity_button);
    }

    private void setListeners() {
        firstActivityButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToFirstActivity();
            }
        });

        secondActivityButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToSecondActivity();
            }
        });
    }

    private void goToFirstActivity() {
        Intent intent = new Intent(this, FirstActivity.class);
        intent.putExtra("key_int", 123);
        startActivity(intent);
    }

    private void goToSecondActivity() {
        Intent intent = new Intent(this, SecondActivity.class);
        intent.putExtra("key_string", "Test string");
        startActivity(intent);
    }
}
