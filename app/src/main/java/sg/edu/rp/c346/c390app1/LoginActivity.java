package sg.edu.rp.c346.c390app1;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class LoginActivity extends AppCompatActivity {
    EditText  etEmail, etPassword;
    TextView tvBacktoRegister;
    Button btnLogin;
    FirebaseAuth firebaseAuth;
    private FirebaseUser fbUser;
    private FirebaseDatabase fbDatabase;
    private DatabaseReference nameRef, existingName;
String displayname = "";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        etPassword = (EditText) findViewById(R.id.EditTextPassword);
        etEmail = (EditText) findViewById(R.id.EditTextEmail);

        btnLogin = (Button) findViewById(R.id.btnLogin);
        tvBacktoRegister = (TextView) findViewById(R.id.link_to_Register);
firebaseAuth = FirebaseAuth.getInstance();



        tvBacktoRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getBaseContext(), RegisterActivity.class);
                startActivity(i);
            }
        });

        btnLogin.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                final ProgressDialog progressDialog = ProgressDialog.show(LoginActivity.this, "Authenticating...", "Processing...", true);
                (firebaseAuth.signInWithEmailAndPassword(etEmail.getText().toString(),etPassword.getText().toString())).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        progressDialog.dismiss();
                        if (task.isSuccessful()){
                            fbUser = firebaseAuth.getCurrentUser();
                            String uid = fbUser.getUid();
                            fbDatabase = FirebaseDatabase.getInstance();
                            nameRef = fbDatabase.getReference("profiles/");
                            existingName = nameRef.child(uid);

                            Toast.makeText(LoginActivity.this, "Login successful", Toast.LENGTH_LONG).show();

                            existingName.addValueEventListener(new ValueEventListener() {
                                @Override
                                public void onDataChange(DataSnapshot dataSnapshot) {
                                    displayname = (String) dataSnapshot.getValue();
                                    if (displayname != null){
                                        Intent i = new Intent(getBaseContext(), NavActivity.class);
                                        i.putExtra("email", firebaseAuth.getCurrentUser().getEmail());

                                        startActivity(i);

                                    }
                                    else{
                                        Intent iDisplay = new Intent(getBaseContext(), DisplayNameActivity.class);
                                        startActivity(iDisplay);
                                    }
                                }

                                @Override
                                public void onCancelled(DatabaseError databaseError) {

                                }
                            });



//                            if(mName != null){
//                                Intent i = new Intent(getBaseContext(), NavActivity.class);
//                                i.putExtra("email", firebaseAuth.getCurrentUser().getEmail());
//                                startActivity(i);

//                            } else{

//                            }

                        }
                        else{
                            Toast.makeText(LoginActivity.this, task.getException().getMessage(), Toast.LENGTH_LONG).show();

                        }
                    }
                });
            }
        } );
    }
}
