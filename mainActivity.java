package com.example.loginsignupui; 
 
import androidx.appcompat.app.AppCompatActivity; 
 import android.content.Intent; import android.os.Bundle; import android.view.View; import android.widget.Button; import android.widget.EditText; import android.widget.Toast; 
 public class MainActivity extends AppCompatActivity { 
    EditText username,password1,password2; 
    Button SignUpBtn,LoginBtn; 
    DBHelper dbHelper; 
    @Override 
    protected void onCreate(Bundle savedInstanceState) {         super.onCreate(savedInstanceState);         setContentView(R.layout.activity_main);         username=findViewById(R.id.username);         password1=findViewById(R.id.password1);         password2=findViewById(R.id.password2);         SignUpBtn=findViewById(R.id.SignUpBtn); 
        LoginBtn=findViewById(R.id.LoginInBtn); 
        LoginBtn.setOnClickListener(new View.OnClickListener() { 
            @Override 
            public void onClick(View v) { 
                Intent intent=new 
Intent(MainActivity.this,ActivityLogin.class);                 startActivity(intent); 
            }         }); 
        dbHelper=new DBHelper(this); 
        SignUpBtn.setOnClickListener(new View.OnClickListener() { 
            @Override 
            public void onClick(View v) {                 String user,pass1,pass2; 
                user=username.getText().toString();                 pass1=password1.getText().toString();                 pass2=password2.getText().toString(); 
                if(user.equals("") || pass1.equals("") || pass2.equals("")){                     Toast.makeText(MainActivity.this,"Please fill in all the details",Toast.LENGTH_LONG).show();                     return; 
                }                 else{ 
                    if(pass1.equals(pass2)){ 
                        if(dbHelper.checkUsername(user)){ 
                            Toast.makeText(MainActivity.this,"User Already 
Exists",Toast.LENGTH_LONG).show(); 
 
                        }                         boolean 
registeredSuccess=dbHelper.insertData(user,pass1);                         if(registeredSuccess) 
                            Toast.makeText(MainActivity.this,"User Registered 
Successfully",Toast.LENGTH_LONG).show();                         else 
                            Toast.makeText(MainActivity.this,"Registration failed",Toast.LENGTH_LONG).show(); 
 
 
 
                    }                     else{ 
                        Toast.makeText(MainActivity.this,"Passwords do not match",Toast.LENGTH_LONG).show();  
                    } 
                } 
            } 
        }); 
 
    } 
} 
