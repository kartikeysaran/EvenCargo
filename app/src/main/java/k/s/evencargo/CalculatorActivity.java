package k.s.evencargo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class CalculatorActivity extends AppCompatActivity {

    Calculator calculator;
    Button add, multiply, subtract, divide;
    TextView textView, editText_history;
    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);
        setUpCalculator();
    }

    private void setUpCalculator() {
        calculator = new Calculator();
        add = findViewById(R.id.btn_add);
        subtract = findViewById(R.id.btn_subtract);
        multiply = findViewById(R.id.btn_multiply);
        divide = findViewById(R.id.btn_divide);
        textView = findViewById(R.id.textView);
        editText = findViewById(R.id.editText);
        editText_history = findViewById(R.id.editText_history);

        add.setOnClickListener(v->{
            if(editText.getText().toString().length()<=0) {
                editText.setError("Required");
            } else {
                textView.setText("Last Method called\ncalculator.add("+editText.getText().toString()+")");
                calculator.add(Double.parseDouble(editText.getText().toString()));
                editText_history.setText(String.valueOf(calculator.getResults()));
                editText.setText("");
            }

        });
        subtract.setOnClickListener(v->{
            if(editText.getText().toString().length()<=0) {
                editText.setError("Required");
            } else {
                textView.setText("Last Method called\ncalculator.subtract("+editText.getText().toString()+")");
                calculator.subtract(Double.parseDouble(editText.getText().toString()));
                editText_history.setText(String.valueOf(calculator.getResults()));
                editText.setText("");
            }

        });
        multiply.setOnClickListener(v->{
            if(editText.getText().toString().length()<=0) {
                editText.setError("Required");
            } else {
                textView.setText("Last Method called\ncalculator.multiply("+editText.getText().toString()+")");
                calculator.multiply(Double.parseDouble(editText.getText().toString()));
                editText_history.setText(String.valueOf(calculator.getResults()));
                editText.setText("");
            }

        });
        divide.setOnClickListener(v->{
            if(editText.getText().toString().length()<=0) {
                editText.setError("Required");
            } else {
                textView.setText("Last Method called\ncalculator.divide("+editText.getText().toString()+")");
                calculator.division(Double.parseDouble(editText.getText().toString()));
                editText_history.setText(String.valueOf(calculator.getResults()));
                editText.setText("");
            }

        });
        findViewById(R.id.btn_clear).setOnClickListener(v->{
            textView.setText("Last Method called\ncalculator.clear()");
            calculator.clear();
            editText_history.setText(String.valueOf(calculator.getResults()));
            editText.setText("");
        });
    }
}