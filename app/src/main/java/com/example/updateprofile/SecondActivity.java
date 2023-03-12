package com.example.updateprofile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;


public class SecondActivity extends AppCompatActivity {

    Intern intern;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Intent intent = getIntent();
        intern = (Intern) intent.getSerializableExtra("KEY");

        TextView textViewProfileData = findViewById(R.id.textViewProfileData);
        textViewProfileData.setText(GetData());
    }
    private String GetData(){
        String data = intern.RegNo + "\r\n";
        data += intern.Name + "\r\n";
        data += intern.Gender + "\r\n";
        data += intern.StudentCategory + "\r\n";
        data += intern.College + "\r\n";
        data += intern.City + "\r\n";
        data += intern.Course + "\r\n";
        data += intern.CGPA + "\r\n";

        return data;

    }
}