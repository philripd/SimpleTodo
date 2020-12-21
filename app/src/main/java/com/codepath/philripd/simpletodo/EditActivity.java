package com.codepath.philripd.simpletodo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.Objects;

public class EditActivity extends AppCompatActivity {

    EditText etItem;
    Button btnSave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);

        etItem = findViewById(R.id.etItem);
        btnSave = findViewById(R.id.btnSave);

        Objects.requireNonNull(getSupportActionBar()).setTitle("Edit item");

        etItem.setText(getIntent().getStringExtra(MainActivity.KEY_ITEM_TEXT));

        // When the user is done editing, they click the save button
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create an intent which will contain the results
                Intent intent = new Intent();
                // Pass the data (results of editing)
                String newItemText = etItem.getText().toString();
                intent.putExtra(MainActivity.KEY_ITEM_TEXT, newItemText);
                intent.putExtra(MainActivity.KEY_ITEM_POSITION, Objects.requireNonNull(getIntent().getExtras()).getInt(MainActivity.KEY_ITEM_POSITION));
                // Set the result of the intent
                // If data is blank, set result to RESULT_CANCELED, otherwise set result to RESULT_OK
                if (newItemText.isEmpty())
                    setResult(RESULT_CANCELED, intent);
                else
                    setResult(RESULT_OK, intent);
                // Finish activity, close the screen and go back
                finish();
            }
        });
    }
}