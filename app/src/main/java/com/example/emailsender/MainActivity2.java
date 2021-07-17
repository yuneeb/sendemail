package com.example.emailsender;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;

public class MainActivity2 extends AppCompatActivity {


    EditText input1;
    EditText input2;
    EditText input3;
    EditText input4;
    EditText input5;
    Button buttonSave;

    String filename = "";
    String filepath = "";
    String fileContent = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        buttonSave = findViewById(R.id.saveAsFile);
        input1 = findViewById(R.id.input1);
        input2 = findViewById(R.id.input2);
        input3 = findViewById(R.id.input3);
        input4 = findViewById(R.id.input4);
        input5 = findViewById(R.id.input5);
        filename = "testFile.txt";
        filepath = "/storage/emulated/0/Download/barTRENDer";

        buttonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                fileContent = input1.getText().toString() +
                        "," + input2.getText().toString() +
                        "," + input3.getText().toString() +
                        "," + input4.getText().toString() +
                        "," + input5.getText().toString();

                File directory = new File(filepath);
                if(!directory.exists()) {
                    directory.mkdir();
                }

                File myfile = new File(filepath + "/" + filename);
                FileOutputStream fos = null;

                try {
                    fos = new FileOutputStream(myfile);
                    fos.write(fileContent.getBytes());
                }

                catch(FileNotFoundException e) {
                    e.printStackTrace();
                }

                catch(IOException io){
                    io.printStackTrace();
                }

            }
        });


    }
}