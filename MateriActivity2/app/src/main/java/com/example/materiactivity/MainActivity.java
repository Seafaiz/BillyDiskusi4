package com.example.materiactivity;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;

public class MainActivity extends Activity implements OnClickListener{
    private String[][]dataUser={{"Bagas","ADMIN","Bagas Dwi Cahyo"},{"user1","password","ruben27"},{"user2","password2","ruben02"}};
    private EditText UserNameET,PasswordET;
    private final int SUCCESS=1;

    @Override
    public void onCreate(Bundle saveInstanceState){
        super.onCreate(saveInstanceState);
        setContentView(R.layout.login_failed);

        UserNameET=(EditText) findViewById(R.id.UserNameEditText1);
        PasswordET=(EditText) findViewById(R.id.PasswordEditText1);


        findViewById(R.id.loginbutton1).setOnClickListener(this);
        findViewById(R.id.tutupbutton1).setOnClickListener(this);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.materi_activity,menu);
        return true;
    }

    public void onClick(View view){
        //TODO Auto-genereted method stub
        switch (view.getId()){
            case R.id.loginbutton1:
                int i=0;
                boolean success=false;
                while((i<dataUser.length)&&(!success)){
                    if ((UserNameET.getText().toString().equals(dataUser[i][0]))&&(PasswordET.getText().toString().equals(dataUser[i][1]))){
                        success=true;

                    }else{
                        i++;
                    }
                }
                Intent intent;
                if (success){
                    intent=new Intent(this,SuccessActivity.class);
                    intent.putExtra("Nama User",dataUser[i][2]);
                    startActivityForResult(intent,SUCCESS);
                }else{
                    intent=new Intent(this, FailedActivity.class);
                    startActivity(intent);
                }
                startActivity(intent);
                break;
            case R.id.tutupbutton1:
                System.exit(0);
        }
    }
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data){
        switch (requestCode){
            case SUCCESS:
                UserNameET.setText("");
                PasswordET.setText("");
                break;
        }
    }
}