package com.lovish.areeba.gossipbox;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Login_Page extends AppCompatActivity {

    private Button reg_button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login__page);

        reg_button_submit();
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
