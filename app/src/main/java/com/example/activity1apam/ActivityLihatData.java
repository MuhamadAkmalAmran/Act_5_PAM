package com.example.activity1apam;

import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class ActivityLihatData extends AppCompatActivity {

    //Deklarasi variabel dengan jenis data textview
    TextView tvnama, tvnomor;





    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lihat_data);

        tvnama  = findViewById(R.id.tvNamaKontak);
        tvnomor = findViewById(R.id.tvNomorTelepon);

        //Membuat variabel dengan jenis data bundle dan
        //assign valuee dari variabel tersebut dengan
        //getIntent().getExtras()
        Bundle bundle = getIntent().getExtras();

        //Membuat variabel nama dan assign value dari pesan
        //yang dikirimkan dari activity sebelumnya
        String nama = bundle.getString("a");

        //Membuat fungsi untuk mengatur textview nama dan nomor telepon
        //berdaarkan pesan yang dikirimkan dari activity sebelumnya
        switch (nama)
        {
            case "Inayah":
                tvnama.setText("Inayah M");
                tvnomor.setText("0812223344");
                break;
            case "Ilham":
                tvnama.setText("Ilham R");
                tvnomor.setText("0812223344");
                break;
            case "Eris":
                tvnama.setText("Eris J");
                tvnomor.setText("0812223344");
                break;
            case "Fikri":
                tvnama.setText("M Fikri");
                tvnomor.setText("0812223344");
                break;
            case "Maul":
                tvnama.setText("Maul M");
                tvnomor.setText("0812223344");
                break;
            case "Intan":
                tvnama.setText("Intan S");
                tvnomor.setText("0812223344");
                break;
            case "Vina":
                tvnama.setText("Vina R");
                tvnomor.setText("0812223344");
                break;
            case "Gita":
                tvnama.setText("Gita S");
                tvnomor.setText("0812223344");
                break;
            case "Lutfi":
                tvnama.setText("Lutfi M");
                tvnomor.setText("0812223344");
                break;
            case "Vian":
                tvnama.setText("Vian M");
                tvnomor.setText("0812223344");
                break;
        }
    }
}
