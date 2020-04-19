package pl.szarek.views;

import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class NextActivity extends AppCompatActivity {
    private ImageButton toastImageButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_next);

        findViews();
        setListeners();
    }

    private void findViews() {
        toastImageButton = findViewById(R.id.toast_button);
    }

    private void setListeners() {
        toastImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showToast();
            }
        });
    }

    private void showToast() {
        Toast.makeText(this, "Toast message", Toast.LENGTH_LONG)
                .show();
    }
}
