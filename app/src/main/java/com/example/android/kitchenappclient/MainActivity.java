package com.example.android.kitchenappclient;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    private EditText email;
    private EditText pass;
    private DatabaseReference mDatabaseReference;
    private FirebaseAuth mFirebaseAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        email = (EditText) findViewById(R.id.editEmail);
        pass = (EditText) findViewById(R.id.editPass);
        mFirebaseAuth = FirebaseAuth.getInstance();
        mDatabaseReference = FirebaseDatabase.getInstance().getReference().child("users");
    }

    protected void signupButtonClicked(View view) {
        final String Email_Text = email.getText().toString().trim();
        String Pass_Text = pass.getText().toString().trim();

        if (!TextUtils.isEmpty(Email_Text) && !TextUtils.isEmpty(Pass_Text)) {
            mFirebaseAuth.createUserWithEmailAndPassword(Email_Text, Pass_Text).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful()) {
                        String userID = mFirebaseAuth.getCurrentUser().getUid();
                        DatabaseReference current_user = mDatabaseReference.child(userID);
                        current_user.child("Name").setValue(Email_Text);

                        Intent loginIntent = new Intent(MainActivity.this, LoginActivity.class);
                        startActivity(loginIntent);
                    }
                }
            });
        }

    }

    public void signinButtonClicked(View view){
        Intent loginIntent = new Intent(MainActivity.this, LoginActivity.class);
        startActivity(loginIntent);
    }
}
