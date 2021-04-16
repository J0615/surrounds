package edu.neu.madcourse.surrounds;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SignInActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText userName;
    private EditText password;
    private Button loadButton;
    private Button registerButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        // Get variables
        userName = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password);
        //Find two buttons , set tags and set listeners
        loadButton = (Button) findViewById(R.id.signin);
        registerButton = (Button) findViewById(R.id.register);
        loadButton.setTag(1);
        loadButton.setOnClickListener(SignInActivity.this);
        registerButton.setTag(2);
        registerButton.setOnClickListener(SignInActivity.this);
    }


    @Override
    public void onClick(View v) {
        int tag = (int) v.getTag();
        switch (tag) {
            case 1:
                idCorrect();
                if (!SaveSharedPreference.getUserID(SignInActivity.this).equals("id")) {
                    Toast.makeText(SignInActivity.this, "Signin Success", Toast.LENGTH_LONG).show();
                    Intent intent1 = new Intent(SignInActivity.this, MainActivity.class);
                    SaveSharedPreference.setUserName(this, userName.getText().toString());
                    Log.e("sign in user id", SaveSharedPreference.getUserID(this));
                    startActivity(intent1);
                } else {
                    Toast.makeText(SignInActivity.this, "Signin failure", Toast.LENGTH_LONG).show();
                    Intent intent2 = new Intent(SignInActivity.this, SignInActivity.class);
                    startActivity(intent2);
                }
                break;

            case 2:
                Intent intent = new Intent(this, RegisterActivity.class);
                startActivity(intent);
                break;
        }
    }

    public void idCorrect() {

        //Check if username and password is correct

        Thread one = new Thread() {
            public void run() {
                try {
                    FirebaseDatabase database = FirebaseDatabase.getInstance();
                    DatabaseReference myRef = database.getReference("Users");

                    myRef.child("users").child(userName.getText().toString()).get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
                        @Override
                        public void onComplete(@NonNull Task<DataSnapshot> task) {
                            if (!task.isSuccessful()) {
                                Log.e("firebase", "Error getting data", task.getException());
                                Toast.makeText(SignInActivity.this, "Username not found, try again", Toast.LENGTH_LONG).show();
                            } else {

                                Log.d("firebase", String.valueOf(task.getResult().getValue()));
                                String correct_password = String.valueOf(task.getResult().child("password").getValue());

                                if (correct_password == password.getText().toString()) {
                                    String userId = String.valueOf(task.getResult().child("userid").getValue());

                                    SaveSharedPreference.setUserID(SignInActivity.this, userId);
                                } else {
                                    Toast.makeText(SignInActivity.this, "Wrong username password combination, try again", Toast.LENGTH_LONG).show();
                                }
                            }
                        }
                    });
                } catch (Exception e) {
                }}};

                one.start();
                try {
                    one.join();
                } catch (InterruptedException v) {

                }
            }

        }
