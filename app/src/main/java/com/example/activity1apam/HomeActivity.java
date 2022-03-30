package com.example.activity1apam;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.PopupMenu;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class HomeActivity extends AppCompatActivity implements PopupMenu.OnMenuItemClickListener{
    //Deklarasi variabel dengan jenis data Listview
    private ListView list;

    //memanggil class ListviewAdapter dan diiniasiasi menjadi variabel adapter
    private ListViewAdapter adapter;

    //Deklarasi array untuk menyimpan nama
    String[] listNama;

    //Memanggil class ClassNama
    public static ArrayList<ClassName> ClassNameArrayList = new ArrayList<ClassName>();

    //membuat objek Bundle
    Bundle bundle = new Bundle();

    //membuat objek intent
    Intent intent;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        //Menyimpan nama didalam array ListNama
        listNama = new String[] {"Inayah","Ilham","Eris","Fikri","Maul","Intan","Vina","Gita","Lutfi","Vian"};

        list = findViewById(R.id.ListKontak);

        //membuat objek dari class ClassNama menjadi arraylist
        ClassNameArrayList = new ArrayList<>();

        //membaca seluruh data pada array listNama
        for (int i = 0 ; i < listNama.length; i++)
        {
            ClassName className = new ClassName(listNama[i]);

            ClassNameArrayList.add(className);
        }

        //membuat objek dari ListViewAdapter
        adapter = new ListViewAdapter(this);

        //binds adapater ke listview
        list.setAdapter(adapter);

        //Membuat event dari list onclick
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                //Deklarasi variabel nama yang berisis item yg dklik
                String nama = ClassNameArrayList.get(position).getName();

                //Memasukan value dari variabel nama dengan kunci "a"
                //dan dimasukkan kedalam bundle
                bundle.putString("a",nama.trim());

                //Membuat objek popup menu
                PopupMenu pm = new PopupMenu(getApplicationContext(), view);

                //membuat event untuk popup menu ketika dipilih
                pm.setOnMenuItemClickListener(HomeActivity.this);

                //menampilkan popup menu dari layout menu
                pm.inflate(R.menu.popup_menu);

                pm.show();
            }
        });


    }

    //event yang terjadi ketika menu dipilih
    @Override
    public boolean onMenuItemClick(MenuItem menuItem) {

        switch (menuItem.getItemId())
        {
            case R.id.mnview:
                intent = new Intent(getApplicationContext(), ActivityLihatData.class);
                intent.putExtras(bundle);
                startActivity(intent);
                break;
            case R.id.mnedit:
                Toast.makeText(getApplicationContext(),"Ini untuk edit kontak",Toast.LENGTH_LONG).show();
                break;
        }
        return false;
    }
}
