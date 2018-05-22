package sg.edu.rp.c346.c390app1;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class RegisterActivity extends AppCompatActivity {

    EditText  etEmail, etPassword , etName;
    Button btnCreateAcc;
    FirebaseAuth firebaseAuth;
    TextView tvBacktoLogin;
    private FirebaseUser fbUser;
    private DatabaseReference nameListRef, existingName;
    private FirebaseDatabase firebaseDatabase;

String displayName = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        etPassword = (EditText) findViewById(R.id.etPassword);
        etEmail = (EditText) findViewById(R.id.etEmail);
        etName = (EditText) findViewById(R.id.editTextName);

        btnCreateAcc = (Button) findViewById(R.id.btnRegister);
tvBacktoLogin = (TextView) findViewById(R.id.link_to_login);

        firebaseAuth = FirebaseAuth.getInstance();
        fbUser = firebaseAuth.getCurrentUser();
        firebaseDatabase = FirebaseDatabase.getInstance();
        nameListRef = firebaseDatabase.getReference("profiles/");

        displayName = etName.getText().toString();



        tvBacktoLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getBaseContext(), LoginActivity.class);
           startActivity(i);
            }
        });

        btnCreateAcc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final ProgressDialog progressDialog = ProgressDialog.show(RegisterActivity.this, "Creating Account...", "Processing...", true);
                (firebaseAuth.createUserWithEmailAndPassword(etEmail.getText().toString().trim(),etPassword.getText().toString())).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        progressDialog.dismiss();
                        if (task.isSuccessful()){
                            Toast.makeText(RegisterActivity.this, "Registration successful", Toast.LENGTH_LONG).show();
                            String uid = fbUser.getUid();
                            nameListRef.child(uid).setValue(displayName);

                            Intent i = new Intent(RegisterActivity.this, LoginActivity.class);
                            startActivity(i);
                        }
                        else{
                            Toast.makeText(RegisterActivity.this, task.getException().getMessage(), Toast.LENGTH_LONG).show();

                        }
                    }
                });

            }
        });

    }
}
