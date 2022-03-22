package com.example.materiactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;

public class SuccessActivity extends  Activity implements OnClickListener {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.materi_activity);

        TextView UserNameTV=(TextView) findViewById(R.id.UserNametextView);
        UserNameTV.setText(getIntent().getExtras().getString("Nama User"));

        findViewById(R.id.Logoutbutton).setOnClickListener(this);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.login_success, menu);
        return true;
    }
    public void onClick(View v){
        //TODO Auto-generated method stub
        switch (v.getId()){
            case R.id.Logoutbutton:
                finish();
        }
    }
}