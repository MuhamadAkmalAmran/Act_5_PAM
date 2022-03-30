package com.example.activity1apam;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText edEmail, edPassword;
    Button okBtn;
    String email, password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edEmail = (EditText) findViewById(R.id.edEmail);
        edPassword = (EditText) findViewById(R.id.edPassword);
        okBtn = (Button) findViewById(R.id.btSignin);

        okBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                email = edEmail.getText().toString();
                password = edPassword.getText().toString();

                if (email.equals("admin") && password.equals("admin")) {
                    Toast.makeText(MainActivity.this, "Login Sukses", Toast.LENGTH_SHORT).show();

                    //membuat objek bundle
                    Bundle b = new Bundle();

                    //memasukkan value dari variabel nama dengan kunci "a"
                    //dan dimasukkan kedalam bundle
                    b.putString("a", email.trim());

                    //memasukkan value dari variabel password dengan kunci "b"
                    // dan dimasukkan kedalam bundle
                    b.putString("b", password.trim());

                    //membuat objek intent berpindah activity dari mainactivity ke Activitykedua
                    //Intent i = new Intent(getApplicationContext(), Activity_kedua.class);

                    Intent i = new Intent(getApplicationContext(),HomeActivity.class );

                    //memasukkan bundle kedalam intent untuk dikirim ke AcitivityKedua
                    i.putExtras(b);

                    //berpindah ke ActivityKedua
                    startActivity(i);

                } else if(email != ("admin") && password.equals("admin"))
                {
                    Toast.makeText(MainActivity.this, "Email Salah", Toast.LENGTH_SHORT).show();

                }
                else if(email.equals("admin") && password != ("admin"))
                {
                    Toast.makeText(MainActivity.this, "Password Salah", Toast.LENGTH_SHORT).show();
                }
                else if(email != ("admin") && password != ("admin"))
                {
                    Toast.makeText(MainActivity.this, "Email dan Password Salah", Toast.LENGTH_SHORT).show();

                }
            }

        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //Method untuk menampilkan menu.
        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        //Membuat kondisi jika yang dipilih adalah id mnDaftar
        if (item.getItemId() == R.id.mnDaftar)
        {
            //Method untuk memanggil activity "DaftarActivity"
            Intent i = new Intent(getApplicationContext(), DaftarActivity.class);
            startActivity(i);
        }
        return super.onOptionsItemSelected(item);
    }

}