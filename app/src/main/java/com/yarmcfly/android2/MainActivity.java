package com.yarmcfly.android2;


import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.Layout;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextWatcher;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.text.style.StyleSpan;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText etName = findViewById(R.id.etName);
        final Button btnAdd = findViewById(R.id.btnAdd);
        btnAdd.setEnabled(false);

        TextView textView = findViewById(R.id.etPrior);

        Spannable sp = new SpannableString("• Приоритет");
        sp.setSpan(new RelativeSizeSpan(1), 0, 1, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        sp.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.orangey_red)), 0, 1, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        sp.setSpan(new StyleSpan(Typeface.BOLD), 0, 1, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        textView.setText(sp);


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
                if (!text.isEmpty()) {
                    btnAdd.setTextColor(getResources().getColor(R.color.colorPrimary));
                } else {
                    btnAdd.setTextColor(getResources().getColor(R.color.Dark));
                }
            }
        });

    }
}