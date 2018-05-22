package sg.edu.rp.c346.c390app1;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;

import static sg.edu.rp.c346.c390app1.R.id.buttonRegister;


public class MainActivity extends AppCompatActivity {

    Button btnSignin, btnRegister;
FirebaseAuth auth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        auth = FirebaseAuth.getInstance();
        if (auth.getCurrentUser() != null){
Intent gg = new Intent(MainActivity.this, NavActivity.class);
            gg.putExtra("email", auth.getCurrentUser().getEmail());

            startActivity(gg);
        }



        btnSignin = (Button) findViewById(R.id.buttonSignin);
        btnRegister = (Button) findViewById(buttonRegister);

        btnSignin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, LoginActivity.class);
                startActivity(i);

            }
        });

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, RegisterActivity.class);
                startActivity(intent);
            }
        });



    }
}
