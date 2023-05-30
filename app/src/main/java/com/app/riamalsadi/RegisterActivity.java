package com.app.riamalsadi;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.google.firebase.auth.FirebaseAuth;

public class RegisterActivity extends AppCompatActivity {
    private EditText edEmail, edPassword, edConfirmPass;
    private Button btnRegister;
    private TextView tvLogin;
    private ImageView imgBack;
    private String email, password, confirmPass;
    private FirebaseAuth firebaseAuth;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        firebaseAuth = FirebaseAuth.getInstance();

        edEmail = findViewById(R.id.edEmail);
        edPassword = findViewById(R.id.edPassword);
        edConfirmPass = findViewById(R.id.edConfirmPass);
        btnRegister = findViewById(R.id.btnRegister);
        tvLogin = findViewById(R.id.tvLogin);
        imgBack = findViewById(R.id.imgBack);

        btnRegister.setOnClickListener(view -> {

            email = edEmail.getText().toString();
            password = edPassword.getText().toString();
            confirmPass = edConfirmPass.getText().toString();

            if (email.isEmpty()) {
                Toast.makeText(RegisterActivity.this, "Please Enter Your Email", Toast.LENGTH_SHORT).show();
            } else if (!isEmailValid(email)) {
                Toast.makeText(RegisterActivity.this, "Please Enter a Valid Email Format", Toast.LENGTH_SHORT).show();
            } else if (password.isEmpty()) {
                Toast.makeText(RegisterActivity.this, "Please Enter Your Password", Toast.LENGTH_SHORT).show();
            } else if (password.length() < 6) {
                Toast.makeText(RegisterActivity.this, "Please Enter a Password Of More Than 6 Digits", Toast.LENGTH_SHORT).show();
            } else if (confirmPass.isEmpty()) {
                Toast.makeText(RegisterActivity.this, "Please Enter Confirmation Password", Toast.LENGTH_SHORT).show();
            } else if (!password.equals(confirmPass)) {
                Toast.makeText(RegisterActivity.this, "Password Does Not Match..", Toast.LENGTH_SHORT).show();
            } else {
                registerUser(email, password);
            }
        });

        imgBack.setOnClickListener(view -> {
            finish();
        });

        tvLogin.setOnClickListener(view -> {
            finish();
        });
    }
    private void registerUser(String email, String password) {
        Toast.makeText(RegisterActivity.this, "Loading..", Toast.LENGTH_SHORT).show();
        firebaseAuth.createUserWithEmailAndPassword(email, password).addOnSuccessListener(task -> {
                    Toast.makeText(RegisterActivity.this, "Registration Completed Successfully, Please Login", Toast.LENGTH_SHORT).show();
                    finish();
                }
        ).addOnFailureListener(e -> {
            Toast.makeText(RegisterActivity.this, e.toString(), Toast.LENGTH_SHORT).show();
        });
    }
    private static boolean isEmailValid(String email) {
        return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }
}
