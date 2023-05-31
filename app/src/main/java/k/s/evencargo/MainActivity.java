package k.s.evencargo;

import static java.lang.Character.isUpperCase;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText editText;
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Question 1
        setUpUpperCase();

        //Question 2
        setUpCalculator();

        //Question 3
        setUpItemView();
    }

    private int getUpperCaseLetters(String s) {
        int count = 0;
        for(char c : s.toCharArray()) {
            if(isUpperCase(c)) {
                count++;
            }
        }
        return count;
    }

    private void setUpUpperCase() {
        editText = findViewById(R.id.editText);
        textView = findViewById(R.id.textView);
        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if(charSequence.toString().length() <= 0) textView.setText("");
                else textView.setText(getUpperCaseLetters(charSequence.toString())+ " Uppercase letters.");
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
    }

    private void setUpItemView() {
        findViewById(R.id.btn_view_items).setOnClickListener(v->{
            startActivity(new Intent(MainActivity.this, ItemViewActivity.class));
        });

    }

    private void setUpCalculator() {
        findViewById(R.id.btn_calculator).setOnClickListener(v->{
            startActivity(new Intent(MainActivity.this, CalculatorActivity.class));
        });
    }
}

