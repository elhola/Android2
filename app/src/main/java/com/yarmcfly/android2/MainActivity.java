package com.yarmcfly.android2;



import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Button;
import android.widget.EditText;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText etName = findViewById(R.id.etName);
        final Button btnAdd = findViewById(R.id.btnAdd);
        btnAdd.setEnabled(false);



        etName.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                String text = s.toString();
                btnAdd.setEnabled(!text.isEmpty());
                if(!text.isEmpty())
                btnAdd.setTextColor(getResources().getColor(R.color.colorPrimary));
                else btnAdd.setTextColor(getResources().getColor(R.color.Dark));
            }
        });
        }
}