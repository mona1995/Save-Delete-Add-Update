package com.example.mona.project;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class EditDataActivity extends AppCompatActivity {
    private static final String TAG = "EditDataActivity";
    private Button save,delete;
    private EditText editable_item;

    DatabaseHelper mDatabaseHelper;
    private String selectedName;
    private int selectedID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_data);
        save =(Button)findViewById(R.id.save);
        delete=(Button)findViewById(R.id.delete);
        editable_item=(EditText)findViewById(R.id.editable_item);

        mDatabaseHelper = new DatabaseHelper(this);
        Intent receivedIntent = getIntent();

        selectedID = receivedIntent.getIntExtra("id",-1);

        selectedName = receivedIntent.getStringExtra("name");

        editable_item.setText(selectedName);

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String item = editable_item.getText().toString();
                if(!item.equals("")){
                    mDatabaseHelper.updateName(item,selectedID,selectedName);
                }else{
                  Toast t =  Toast.makeText(getApplicationContext(),"You must enter a name",Toast.LENGTH_LONG);
                  t.show();
                }
            }
        });

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mDatabaseHelper.deleteName(selectedID,selectedName);
                editable_item.setText("");
               Toast t =Toast.makeText(getApplicationContext(),"removed from database",Toast.LENGTH_LONG);
                       t.show();
            }
        });

    }
}
