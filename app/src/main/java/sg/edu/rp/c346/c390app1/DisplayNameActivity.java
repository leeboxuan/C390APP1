package sg.edu.rp.c346.c390app1;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class DisplayNameActivity extends AppCompatActivity {

    private FirebaseAuth fbAuth;
    private FirebaseUser fbUser;
    private DatabaseReference nameListRef, existingName;
    private FirebaseDatabase firebaseDatabase;

    EditText etDisplayName;
    Button btnSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_name);

        etDisplayName = (EditText)findViewById(R.id.editTextDisplayName);
        btnSubmit = (Button)findViewById(R.id.buttonSubmit);

        fbAuth = FirebaseAuth.getInstance();

        fbUser = fbAuth.getCurrentUser();
        String uid = fbUser.getUid();
        firebaseDatabase = FirebaseDatabase.getInstance();
        nameListRef = firebaseDatabase.getReference("profiles/");

        existingName = nameListRef.child(uid);

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String uid = fbUser.getUid();
                String displayName = etDisplayName.getText().toString();
                nameListRef.child(uid).setValue(displayName);
                Intent i = new Intent(DisplayNameActivity.this, NavActivity.class);
                startActivity(i);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){
            case R.id.menu_sign_out:
                logout();

                return true;
            default:
                return super.onOptionsItemSelected(item);

        }
    }

    private void logout(){
        fbAuth.signOut();
    }
}
