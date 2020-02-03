package com.example.asst02_tg_2016_106;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    DatabaseHelper mydb;
    EditText editName, editAge, editMarks;
    Button buttonAdd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mydb = new DatabaseHelper(this);

        editName = (EditText) findViewById(R.id.edit_name);
        editAge = (EditText) findViewById(R.id.edit_age);
        editMarks = (EditText) findViewById(R.id.edit_marks);
        buttonAdd = (Button) findViewById(R.id.button_add);
        AddData();
    }

    public void AddData(){
        buttonAdd.setOnClickListener(
                new View.OnClickListener(){

                    @Override
                    public void onClick(View v) {
                        boolean isInserted = mydb.insertData(editName.getText().toString(), editAge.getText().toString(), editMarks.getText().toString());
                        if(isInserted = true)
                            Toast.makeText(MainActivity.this, "Data Inseretd", Toast.LENGTH_LONG).show();
                        else
                            Toast.makeText(MainActivity.this, "Data not Inseretd", Toast.LENGTH_LONG).show();
                    }
                }
        );
    }
}
