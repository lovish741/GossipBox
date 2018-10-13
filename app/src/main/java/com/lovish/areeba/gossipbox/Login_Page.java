package com.lovish.areeba.gossipbox;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Login_Page extends AppCompatActivity {

    private TextInputEditText email;
    private TextInputEditText password;
    private Button login_button;


    private Button reg_button;


    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login__page);

        mAuth=FirebaseAuth.getInstance();

        login_button_submit();

        reg_button_submit();
    }

    public void login_button_submit()
    {
        email=(TextInputEditText)findViewById(R.id.login_email_id);
        password=(TextInputEditText)findViewById(R.id.login_password);
        login_button=(Button)findViewById(R.id.login_login_button);

        login_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String fire_email=email.getText().toString();
                String fire_password=password.getText().toString();

                if(!TextUtils.isEmpty(fire_email)||!TextUtils.isEmpty(fire_password))
                {
                    mAuth.signInWithEmailAndPassword(fire_email,fire_password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if(task.isSuccessful())
                            {
                                Intent main_activity=new Intent(Login_Page.this,MainActivity.class);
                                startActivity(main_activity);
                                finish();
                            }
                            else
                            {
                                //error in login
                            }
                        }
                    });
                }
            }
        });
    }

    public void reg_button_submit()
    {
        reg_button = (Button) findViewById(R.id.login_reg_button);

        reg_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent reg_intent= new Intent(Login_Page.this,Reg_activity.class);
                startActivity(reg_intent);
            }
        });

    }

}
