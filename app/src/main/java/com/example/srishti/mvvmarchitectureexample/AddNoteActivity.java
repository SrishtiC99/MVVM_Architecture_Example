package com.example.srishti.mvvmarchitectureexample;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.NumberPicker;
import android.widget.Toast;

public class AddNoteActivity extends AppCompatActivity {
    public static final String EXTRA_TITLE = "com.example.srishti.mvvmarchitectureexample.EXTRA_TITLE";
    public static final String EXTRA_DESCRIPTION = "com.example.srishti.mvvmarchitectureexample.EXTRA_DESCRIPTION";
    public static final String EXTRA_PRIORITY = "com.example.srishti.mvvmarchitectureexample.EXTRA_PRIORITY";
    private EditText titleEditText;
    private EditText descriptionEditText;
    private NumberPicker priorityNumberPicker;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_note);

        titleEditText = findViewById(R.id.edittext_title);
        descriptionEditText = findViewById(R.id.edittext_description);
        priorityNumberPicker = findViewById(R.id.number_picker_priority);
        priorityNumberPicker.setMinValue(1);
        priorityNumberPicker.setMaxValue(20);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_close);
        setTitle("Add Note");
    }

    public void saveNote(){
        String title = titleEditText.getText().toString();
        String description = descriptionEditText.getText().toString();
        int priority = priorityNumberPicker.getValue();

        if(title.trim().isEmpty() || description.trim().isEmpty()){
            Toast.makeText(this, "Please provide a Title and a Description", Toast.LENGTH_SHORT).show();
            return;
        }
        Intent data = new Intent();
        data.putExtra(EXTRA_TITLE, title);
        data.putExtra(EXTRA_DESCRIPTION, description);
        data.putExtra(EXTRA_PRIORITY, priority);

        setResult(RESULT_OK, data);
        finish();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.add_note_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.save_note:
                saveNote();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}