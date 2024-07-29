package com.example.loginsignupui; 
 import android.content.Intent; import android.os.Bundle; import android.view.View; import android.widget.Button; import android.widget.EditText; import android.widget.Toast; 
 
import androidx.annotation.Nullable; 
import androidx.appcompat.app.AppCompatActivity; 
 
public class ActivityLogin extends AppCompatActivity { 
    DBHelper dbHelper; 
    Button btnLogin; 
    EditText username,password; 
 
    @Override 
    protected void onCreate(@Nullable Bundle savedInstances){         super.onCreate(savedInstances);         setContentView(R.layout.login);         dbHelper=new DBHelper(this);         username=findViewById(R.id.user);         password=findViewById(R.id.pass);         btnLogin=findViewById(R.id.btnLogin); 
        btnLogin.setOnClickListener(new View.OnClickListener() { 
            @Override 
            public void onClick(View v) {                 boolean 
isLoggedId=dbHelper.checkUser(username.getText().toString(),password.getText(
).toString()); 
                if(isLoggedId) 
                { 
                    Intent intent=new Intent(ActivityLogin.this,Home.class);                     startActivity(intent); 
 
                }                 else 
                    Toast.makeText(ActivityLogin.this,"Login failed",Toast.LENGTH_LONG).show(); 
 
 
            } 
        }); 
    } 
} 
 
