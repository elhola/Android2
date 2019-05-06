package com.yarmcfly.android2.taskmanager;

import android.content.Intent;
import android.renderscript.RenderScript;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.yarmcfly.android2.R;
import com.yarmcfly.android2.db.Task;

public class AddTaskActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final EditText etName = findViewById(R.id.etName);
        final Button btnAdd = findViewById(R.id.btnAdd);
        btnAdd.setEnabled(false);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) {
                Task task = new Task(etName.getText().toString(), 0);
                Intent data = new Intent().putExtra(Task.class.getName(), task);
                setResult(RESULT_OK, data);
                finish();
            }
        });
        etName.addTextChangedListener(new TextWatcher() {
            @Override public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }
            @Override public void onTextChanged(CharSequence s, int start, int before, int count) {
            }
            @Override public void afterTextChanged(Editable s) {
                String text = s.toString();
                btnAdd.setEnabled(!text.isEmpty());
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
    public boolean onOptionsItemSelected(MenuItem item) {
        // получим идентификатор выбранного пункта меню
        int id = item.getItemId();

        TextView infoTextView = (TextView) findViewById(R.id.etPrior);

        // Операции для выбранного пункта меню
        switch (id) {
            //case R.id.action_email:
          //      infoTextView.setText("Вы выбрали емейл!");
          //      return true;
            case R.id.action_settings:
                infoTextView.setText("Вы выбрали настройки!");
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
    // у атрибута пункта меню email установлено значение android:onClick="onEmailMenuClick"
    public void onEmailMenuClick(MenuItem item) {
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("plain/text");
        intent.putExtra(Intent.EXTRA_EMAIL, new String[] {  "yarmcfly@gmail.address" });
        intent.putExtra(Intent.EXTRA_SUBJECT, "subject");
        intent.putExtra(Intent.EXTRA_TEXT, "yarmcfly@gmail.com");
        startActivity(Intent.createChooser(intent, ""));
        //TextView infoTextView = (TextView) findViewById(R.id.etName);
       // infoTextView.setText("почта разработчика: yarmcfly@gmail.com");
    }


}