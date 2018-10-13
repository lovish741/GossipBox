package com.lovish.areeba.gossipbox;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Reg_activity extends AppCompatActivity {

    private FirebaseAuth mAuth;

    private TextInputEditText username;
    private TextInputEditText email;
    private TextInputEditText password;
    private Button create_button;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reg_activity);

        mAuth=FirebaseAuth.getInstance();


        username=(TextInputEditText) findViewById(R.id.register_username);
        email=(TextInputEditText)findViewById(R.id.register_email_id);
        password=(TextInputEditText)findViewById(R.id.register_password);

        create_button=(Button)findViewById(R.id.register_create_button);

        create_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String fire_username=username.getText().toString();
                String fire_email=email.getText().toString();
                String fire_password=password.getText().toString();

                if(!TextUtils.isEmpty(fire_username)||!TextUtils.isEmpty(fire_email)||!TextUtils.isEmpty(fire_password))
                {
                    mAuth.createUserWithEmailAndPassword(fire_email,fire_password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if(task.isSuccessful())
                            {
                                Intent main_activity=new Intent(Reg_activity.this,MainActivity.class);
                                startActivity(main_activity);
                                finish();
                            }
                            else
                            {
                                //toast not login
                            }
                        }
                    });
                }




            }
        });
    }



}
