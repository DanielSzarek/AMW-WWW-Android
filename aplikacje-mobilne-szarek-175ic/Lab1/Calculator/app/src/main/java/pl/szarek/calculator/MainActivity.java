package pl.szarek.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        onClickCalculate();
    }

    public void onClickCalculate() {
        final Spinner value1 = findViewById(R.id.spinner1);
        final Spinner sign = findViewById(R.id.spinner2);
        final Spinner value2 = findViewById(R.id.spinner3);
        final TextView text = findViewById(R.id.resultTextView);
        Button button = findViewById(R.id.calculateButton);
        button.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("DefaultLocale")
            @Override
            public void onClick(View v) {
                String choosenSing = String.valueOf(sign.getSelectedItem());
                float choosenValue = Integer.valueOf(String.valueOf(value1.getSelectedItem()));
                float choosenValue2 = Integer.valueOf(String.valueOf(value2.getSelectedItem()));
                float value = 0;
                boolean error = false;

                switch(choosenSing) {
                    case "+":
                        value = choosenValue + choosenValue2;
                        break;
                    case "-":
                        value = choosenValue - choosenValue2;
                        break;
                    case "*":
                        value = choosenValue * choosenValue2;
                        break;
                    case "/":
                        if (choosenValue2 == 0) {
                            error = true;
                            text.setText("Nie dziel przez zero!");
                        }
                        else {
                            value = choosenValue / choosenValue2;
                        }
                        break;
                    default:
                        value = 0;
                }
                if (!error) {
                    text.setText(String.format("%.3f%n", value));
                }
            }
        });
    }
}
