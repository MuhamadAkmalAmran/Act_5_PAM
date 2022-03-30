package com.example.activity1apam;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

public class DaftarActivity  extends AppCompatActivity {
    //Deklarasi variabel dengan tipe data edittext
    EditText edtNama, edtAlamat, edtEmail, edtPassword, edtrepass;

    //Deklarasi variabel dengan tipe data floating Action Button
    FloatingActionButton fab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pendaftaran);

        edtNama = (EditText) findViewById(R.id.edNama);
        edtAlamat = (EditText) findViewById(R.id.edAlamat);
        edtEmail = (EditText) findViewById(R.id.EdEmail);
        edtPassword = (EditText) findViewById(R.id.edPass);
        edtrepass = (EditText) findViewById(R.id.edrepass);
        fab = (FloatingActionButton) findViewById(R.id.fabSimpan);

        //membuat method untuk event dari floating button
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //membuat kondisi untuk mengecek apakah Edittext kosong atau tidak
                if (edtNama.getText().toString().isEmpty() ||
                        edtAlamat.getText().toString().isEmpty() ||
                        edtEmail.getText().toString().isEmpty() ||
                        edtPassword.getText().toString().isEmpty() ||
                        edtrepass.getText().toString().isEmpty())
                {
                    //menampilkan pesan notifikasi jika seluruh edittext wajib diisi
                    Snackbar.make(view, "Wajib isi seluruh !!!", Snackbar.LENGTH_LONG).show();
                }
                else
                {
                    //membuat kondisi untuk mengecek apakah isi dari edit text password dan edittext repassword
                    //sama atau tidak
                    if(edtPassword.getText().toString().equals(edtrepass.getText().toString()))
                    {
                        //menampilkan pesan notifikasi jika pendaftaran berhasil
                        Toast.makeText(getApplicationContext(),"Pendaftaran Berhasil...",
                                Toast.LENGTH_LONG).show();

                        //method untuk kembali ke activity Main
                        Intent i = new Intent(getApplicationContext(), MainActivity.class);
                        startActivity(i);
                    }
                    else
                    {
                        //menampilkan pesan bahwa isi dari edittext password dan edittext repassword
                        //tidak sama
                        Snackbar.make(view,"Password dan Repassword harus sama!!!",
                                Snackbar.LENGTH_LONG).show();
                    }
                }
            }
        });
    }
}