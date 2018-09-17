package com.example.spaceimpactor.findme;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    int n,count=1;

    public void makeToast(String string)
    {
        Toast.makeText(MainActivity.this,string, Toast.LENGTH_SHORT).show();
        count++;
    }

    public void guess(View view){
        EditText guessEditText= (EditText) findViewById(R.id.guessEditText);
        int val = Integer.parseInt(guessEditText.getText().toString());
        if(val>n)
        {
            makeToast("Lower!");
        }
        else if(val<n)
        {
            makeToast("Higher!");
        }
        else
        {
            Toast.makeText(MainActivity.this,"Finally, You've found it in "+count+" Tries!", Toast.LENGTH_LONG).show();
            Random rand = new Random();
            n= rand.nextInt(40)+1;
            count=1;
        }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Random rand = new Random();
        n = rand.nextInt(40)+1;
    }
}
