package com.example.updateprofile;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

import java.io.Serializable;

public class MainActivity extends AppCompatActivity {
    Intern intern;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        intern = new Intern();

        FillStudentCategory();
        FillCourse();
    }

    public void UpdateProfile(View view){
        EditText editTextRegNo = findViewById(R.id.editTextRegNo);
        EditText editTextName = findViewById(R.id.editTextName);
        EditText editTextCollege = findViewById(R.id.editTextCollege);
        EditText editTextCity = findViewById(R.id.editTextCity);
        EditText editTextCGPA = findViewById(R.id.editTextCGPA);

        intern.RegNo = editTextRegNo.getText().toString();
        intern.Name = editTextName.getText().toString();
        intern.College = editTextCollege.getText().toString();
        intern.City = editTextCity.getText().toString();
        intern.CGPA = editTextCGPA.getText().toString();

        GetGender();

//        TextView textViewProfileData = findViewById(R.id.textViewProfileData);
//        textViewProfileData.setText(intern.Course);

        Intent intent = new Intent(MainActivity.this,SecondActivity.class);
        intent.putExtra("KEY" , intern);
        startActivity(intent);
    }
    private void GetGender(){
        RadioGroup rbGroupGender = findViewById(R.id.rbGroupGender);
        RadioButton selectedRadioButton;

        int selectedRadioButtonId = rbGroupGender.getCheckedRadioButtonId();

        if (selectedRadioButtonId != -1){
            selectedRadioButton = findViewById(selectedRadioButtonId);
            String selectedGender = selectedRadioButton.getText().toString();
            intern.Gender = selectedGender;
        }
    }

    private void FillStudentCategory(){
        String[] data = {"Student","Fresher","Working"};

        Spinner spinnerStudentCategory = (Spinner) findViewById(R.id.spinnerStudentCategory);

        ArrayAdapter aa = new ArrayAdapter(this,android.R.layout.simple_spinner_item,data);
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinnerStudentCategory.setAdapter(aa);

        spinnerStudentCategory.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                intern.StudentCategory = adapterView.getItemAtPosition(i).toString();
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView){

            }

        });
    }

    private void FillCourse(){
        String[] data = {"BTech(CSE)","BTech(Data Science)","BTech(AIML)","Others"};

        Spinner spinnerCourse= (Spinner) findViewById(R.id.spinnerCourse);

        ArrayAdapter aa = new ArrayAdapter(this,android.R.layout.simple_spinner_item,data);
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinnerCourse.setAdapter(aa);

       spinnerCourse.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                intern.Course = adapterView.getItemAtPosition(i).toString();
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView){

            }

        });
    }


}