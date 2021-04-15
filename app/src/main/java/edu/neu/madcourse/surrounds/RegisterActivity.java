package edu.neu.madcourse.surrounds;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener {
    private Button register;
    private Button back;
    private String userEmail;
    private String password;
    private String userName;
    private EditText editUserName;
    private EditText editUserEmail;
    private EditText pwd;
    private EditText pwdAgain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        editUserName=(EditText)findViewById(R.id.usernameR);
        editUserEmail=(EditText)findViewById(R.id.userEmailR);
        pwd=(EditText)findViewById(R.id.passwordR);
        pwdAgain=(EditText)findViewById(R.id.passwordRCheck);
        register= (Button) findViewById(R.id.registerR);
        register.setTag(1);
        register.setOnClickListener(RegisterActivity.this);
        back=(Button)findViewById(R.id.bSigninR);
        back.setTag(2);
        back.setOnClickListener(RegisterActivity.this);
    }

    @Override
    public void onClick(View v) {
        int Tag=(int)v.getTag();
        switch (Tag){
            case 1:
                userName = editUserName.getText().toString();
                userEmail = editUserEmail.getText().toString();
                password = pwd.getText().toString();
                if (insertData()) {
                    Toast.makeText(RegisterActivity.this,"Sccuessfully Registered ",Toast.LENGTH_LONG).show();
                    Log.e("register user id", SaveSharedPreference.getUserID(this));
                    Intent intent1 = new Intent(RegisterActivity.this, MainActivity.class);
                    startActivity(intent1);
                } else {
                    Intent intent2=new Intent(RegisterActivity.this,RegisterActivity.class);
                    startActivity(intent2);
                }
                break;
            case 2:
                Intent intent=new Intent(this,SignInActivity.class);
                startActivity(intent);
                break;
            default:
                Toast.makeText(RegisterActivity.this,"Register failure, try again",Toast.LENGTH_LONG).show();
                break;

        }

    }

    public boolean insertData(){

        if (pwdCorrect() && checkValid()) {


            Thread one = new Thread() {
                public void run() {
                    try {
                        DatabaseReference ref = FirebaseDatabase.getInstance().getReference();
                        User newUser = new User(userName,userEmail,password);
                        DatabaseReference newRef = ref.child("Users").push();
                        newRef.setValue(newUser);

                        SaveSharedPreference.setUserName(RegisterActivity.this,userName);
                    } catch(Exception v) {
                    }
                }
            };

            one.start();
            try {
                one.join();
            } catch (InterruptedException e) {

            }
            return true;
        }


        return false;

    }

    public boolean pwdCorrect(){
        if(pwd.getText().toString().equals(pwdAgain.getText().toString())){
            return true;
        }
        Toast.makeText(RegisterActivity.this,"Password is not same, type again",Toast.LENGTH_LONG).show();
        return false;
    }


    public boolean checkValid() {
        if (userEmail.matches("") || password.matches("")) {
            Toast.makeText(RegisterActivity.this,"can't be blank",Toast.LENGTH_LONG).show();
            return false;
        }
        return true;
    }

}

