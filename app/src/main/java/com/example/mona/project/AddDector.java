package com.example.mona.project;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddDector extends AppCompatActivity {
    private static final String TAG = "AddDector";

    DatabaseHelper mDatabaseHelper;
    private Button add ,save;
    private EditText editText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_dector);
       add=(Button)findViewById(R.id.add);
       save=(Button)findViewById(R.id.save);
       editText =(EditText)findViewById(R.id.editText);
       mDatabaseHelper = new DatabaseHelper(this);


       add.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               String newEntry = editText.getText().toString();
               if (editText.length() != 0) {
                  AddData(newEntry);
                   editText.setText("");
               } else {
                   Toast t=Toast.makeText(getApplicationContext(),"You must put something in the text field!",Toast.LENGTH_LONG);
                   t.show();
               }
           }
       });
       save.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               Intent i =new Intent(AddDector.this ,ListDataActivity.class);
               startActivity(i);
               finish();
           }
       });

    }
    public void AddData(String newEntry) {
        boolean insertData = mDatabaseHelper.addData(newEntry);

        if (insertData) {
            Toast t=Toast.makeText(getApplicationContext(),"Data Successfully Inserted!",Toast.LENGTH_LONG);
            t.show();
        } else {
            Toast t=Toast.makeText(getApplicationContext(),"Something went wrong",Toast.LENGTH_LONG);
            t.show();
        }
    }
}
