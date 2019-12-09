package com.example.homework4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private EditText etname;
    private EditText etEmail;
    private EditText etPword;

    //Creating a sharedpreference
    private SharedPreferences sharedPreferences;

    //Keys that need to be stored with the values
    private static final String mypref="myPref";
    private static final String Name="NameKey";
    private static final String Email="EmailNoKey";
    private static final String Password="PwordKey";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etname=(EditText)findViewById(R.id.txtName);
        etEmail=(EditText)findViewById(R.id.txtEmail);
        etPword=(EditText)findViewById(R.id.txtPassword);


    }
    public void save(View v){

        String n=etname.getText().toString();

        String e=etEmail.getText().toString();

        String p=etPword.getText().toString();

        //editor will let the app store values in  sharedpererence
        SharedPreferences.Editor editor=sharedPreferences.edit();

        //adding name with its key to the shared preference
        editor.putString(Name,n);

        editor.putString(Email,e);

        editor.putString(Password,p);

        //Saving the changes
        editor.commit();
    }
    public void retrieve(View v){
        //this will get the shared preference that is available
        sharedPreferences= getSharedPreferences(mypref, Context.MODE_PRIVATE);
        
        if(sharedPreferences.contains(Name)){
            //If yes then etName's text will be set to the value that is asociated with the key
             etname.setText(sharedPreferences.getString(Name,""));
        }
        //If key is not available then No values saved will be added as text
        else
        {
            etname.setText("No Values Saved");
        }
        //This will check for key that is in MobileNo if that is present then it will be displayed. else No values saved will be displayed
        if(sharedPreferences.contains(Email)){
            etEmail.setText(sharedPreferences.getString(Email,""));
        }
        else
        {
            etEmail.setText("No Values Saved");
        }
        if(sharedPreferences.contains(Password)){
            etPword.setText(sharedPreferences.getString(Password,""));
        }
        else
        {
            etPword.setText("No Values Saved");
        }

    }
    public void clear(View v){
        etname.setText("");
        etEmail.setText("");
        etPword.setText("");
    }
}
