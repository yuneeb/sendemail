package com.example.emailsender;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.File;

public class MainActivity extends AppCompatActivity {

    EditText email;
    EditText subject;
    EditText body;
    Button buttonSend;
    Button buttonChange;

    String filename = "testFile.txt";
    String filepath = "/storage/emulated/0/Download/barTRENDer";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        email = findViewById(R.id.editText1);
        subject = findViewById(R.id.editText2);
        body = findViewById(R.id.editText3);

        buttonSend = findViewById(R.id.buttonSend);
        buttonChange = findViewById(R.id.buttonChange);


        buttonSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!email.getText().toString().isEmpty() && !subject.getText().toString().isEmpty() && !body.getText().toString().isEmpty()) {

                    Intent intent = new Intent((Intent.ACTION_SEND));
                    intent.putExtra(Intent.EXTRA_EMAIL, new String[]{email.getText().toString()});
                    intent.setData(Uri.parse("mailto:"));
                    intent.putExtra(Intent.EXTRA_SUBJECT, subject.getText().toString());
                    intent.putExtra(Intent.EXTRA_TEXT, body.getText().toString());
                    intent.setType("text/plain");
                    intent.putExtra(Intent.EXTRA_STREAM, Uri.fromFile(new File(filepath + "/" + filename)));

                    if (intent.resolveActivity(getPackageManager()) != null) {
                        startActivity(intent);
                    }

                    else{
                        Toast.makeText(MainActivity.this, "No app that supports this", Toast.LENGTH_SHORT).show();
                    }

                }

                else {
                    Toast.makeText(MainActivity.this, "Please fill all the fields", Toast.LENGTH_SHORT).show();
                }

            }
        });


        buttonChange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 = new Intent(getApplicationContext() ,MainActivity2.class);
                startActivity(intent2);
            }
        });

    }



}