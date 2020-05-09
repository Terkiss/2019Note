package com.example.firebase_auths;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    EditText edtEmail, edtPssword;
    TextView txtSign, txtMessage;

    ProgressDialog progressDialog;

    FirebaseAuth firebaseAuth;

    Button btnSignup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        firebaseAuth = FirebaseAuth.getInstance();

        if(firebaseAuth.getCurrentUser() != null)
        {
            finish();
            startActivity(new Intent(getApplicationContext(), ProfileActivity.class));
        }

        edtEmail = findViewById(R.id.edtEmail);
        edtPssword = findViewById(R.id.edtPassword);

        txtSign = findViewById(R.id.viewSignIn);
        txtMessage = findViewById(R.id.textView2);

        btnSignup = findViewById(R.id.btnSignUP);
        progressDialog = new ProgressDialog(this);
    }
    public void onClick(View v)
    {
        if(v==btnSignup)
        {
            registerUser();
        }
        else if(v== txtSign)
        {
            startActivity(new Intent(getApplicationContext(), LoginActivity.class));
        }
    }
    private void registerUser()
    {
        String email = edtEmail.getText().toString();

        String password = edtPssword.getText().toString();

        if(email.isEmpty())
        {
            Toast.makeText(getApplicationContext(), "Email 을 입력해주세요", Toast.LENGTH_LONG).show();

        }
        if(password.isEmpty())
        {
            Toast.makeText(getApplicationContext(), "password 를 등록하세요 ", Toast.LENGTH_LONG).show();

        }

        progressDialog.setMessage("등록");
        progressDialog.show();

        firebaseAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task task) {
                               if(task.isSuccessful())
                                {
                                    finish();
                                    startActivity(new Intent(getApplicationContext(), ProfileActivity.class));

                                }
                                else
                                    {
                                        txtMessage.setText("에러 유형 \n - 이밎 등록된 이메일 - 암호 최소 6자리 이상 \n -server error");
                                    }
                                progressDialog.dismiss();
                            }
                        }

                );
    }


}
