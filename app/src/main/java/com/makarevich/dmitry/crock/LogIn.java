package com.makarevich.dmitry.crock;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LogIn extends AppCompatActivity {
    private FirebaseAuth firebaseAuth;
    private ImageView  ic_logo;
    private EditText edit_mail, edit_password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);
        firebaseAuth = FirebaseAuth.getInstance();
        ic_logo = findViewById(R.id.ic_logo);
        Button btn_login = findViewById(R.id.btn_login);
        edit_password = findViewById(R.id.edit_password);
        edit_mail = findViewById(R.id.edit_mail);
        Button btn_registration = findViewById(R.id.btn_registration);
        Button btn_skip_login = findViewById(R.id.btn_skip_login);
        btn_skip_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent next = new Intent(LogIn.this, MainMenu.class);
                startActivity(next);
            }
        });
        btn_registration.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new LogIn();
            }
        });
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent back = new Intent(LogIn.this, Registration.class);
                startActivity(back);
            }
        });
        PushImage();
    }

    @Override
    public void onBackPressed() {
        Intent back = new Intent(LogIn.this, Registration.class);
        startActivity(back);
    }

    public void PushImage() {
        int first = R.drawable.crocko_green;
        Glide
                .with(this)
                .load(first)
                .into(ic_logo);
    }

    public LogIn() {
        try {

            String email = edit_mail.getText().toString().trim();
            String password = edit_password.getText().toString().trim();
            if (TextUtils.isEmpty(email) || TextUtils.isEmpty(password)) {
                Toast.makeText(this, getString(R.string.please), Toast.LENGTH_SHORT).show();
            } else {
                firebaseAuth.signInWithEmailAndPassword(email, password)
                        .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    Toast.makeText(LogIn.this, getString(R.string.succes), Toast.LENGTH_SHORT).show();
                                    Intent next = new Intent(LogIn.this, MainMenu.class);
                                    startActivity(next);
                                }
                            }
                        });
            }
        } catch (Exception e) {
        }


    }
}
