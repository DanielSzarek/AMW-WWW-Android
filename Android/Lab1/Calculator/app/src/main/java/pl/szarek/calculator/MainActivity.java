package pl.szarek.calculator;

import androidx.appcompat.app.AppCompatActivity;

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
            @Override
            public void onClick(View v) {
                String choosenSing = String.valueOf(sign.getSelectedItem());
                int choosenValue = Integer.valueOf(String.valueOf(value1.getSelectedItem()));
                int choosenValue2 = Integer.valueOf(String.valueOf(value2.getSelectedItem()));
                int value;

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
                        value = choosenValue / choosenValue2;
                        break;
                    default:
                        value = 0;
                }
                text.setText(String.valueOf(value));
            }
        });
    }
}
