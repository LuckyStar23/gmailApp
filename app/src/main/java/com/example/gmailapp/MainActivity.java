package com.example.gmailapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText mail;
    EditText theme;
    EditText message;
    Button button;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mail = findViewById(R.id.mail);
        theme = findViewById(R.id.theme);
        message = findViewById(R.id.message);

        button = findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!mail.getText().toString().isEmpty() && !theme.getText().toString().isEmpty()
                        && !message.getText().toString().isEmpty()) {
                    Intent intent = new Intent(Intent.ACTION_SENDTO);
                    intent.putExtra(Intent.EXTRA_EMAIL, new String[]{mail.getText().toString()});
                    intent.putExtra(Intent.EXTRA_SUBJECT, theme.getText().toString());
                    intent.putExtra(Intent.EXTRA_TEXT, message.getText().toString());
                    intent.setData(Uri.parse("mailto:"));
                    startActivity(intent);

                } else {
                    Toast.makeText(MainActivity.this, "Введены не все данные",
                            Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
}


