package com.example.activity1apam;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class ListViewAdapter extends BaseAdapter {

    //Deklarasi varibale dengan jenis data context
    Context mContext;

    //Deklarasi variabel dengan jenis data layout inflater
    LayoutInflater inflater;

    //Deklarasi variabel dengan jenis data arraylist
    private ArrayList<ClassName> arraylist;

    //membuat konstruktor ListViewadapter
    public ListViewAdapter(Context context)
    {
        //Memberi nilai mContext dengan context
        mContext = context;

        //mengatur layoutinflater dari context yang diberikan
        inflater = LayoutInflater.from(mContext);

        //Memberikan nilai arrayList dari class ClassNama
        this.arraylist = new ArrayList<ClassName>();

        //menambahkan semua elemen ke arraylist
        this.arraylist.addAll(HomeActivity.ClassNameArrayList);
    }

    //Membuat class untuk mendeklarasikan tempat untuk meletakkan isi kedalam listview
    public class ViewHolder
    {
        //mendeklarasikan variabel dengan jenis Textview
        TextView name;
    }

    //Fungsi getCount() mengembalikan jumlah item yang akan ditampilkan dalam list
    @Override
    public int getCount() {
        //mengembalikan nilai berupa jumlah data dari array data
        return HomeActivity.ClassNameArrayList.size();
    }

    //Fungsi ini digunakan untuk mendapatkan data item yang terkait dengan posisi
    //Tertentu dalam kumpulan data untuk mendapatkan data yang sesuai dari lokasi
    //tertentu dalam pengumpulan data item.
    @Override
    public Object getItem(int i) {
        //mengembalikan nilai berupa objek dari array data
        return HomeActivity.ClassNameArrayList.get(i);
    }

    //Fungsi mengembalikan "nilai" dari posisi item ke adaptor
    @Override
    public long getItemId(int i) {
        return i;
    }

    //Fungsi ini secara otomatis dipanggil ketika tampilan item list siap untuk
    //ditampilkan atau akan ditampilkan
    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        //deklarasi variabel dengan jenis data ViewHolder
        final ViewHolder holder;

        //membuat kondisi apakah view null atau tidak
        if(view == null){

            //membuat objek view holder
            holder = new ViewHolder();

            //mengatur layout untuk menampilkan item
            view = inflater.inflate(R.layout.item_listview,null);

            //set id untuk textview
            holder.name = (TextView) view.findViewById(R.id.tvnama_item);

            //menyimpan data dalam tampilan tanpa menggunakan struktur data lain.
            view.setTag(holder);
        }else {
            //mengatur holder untuk mengembalikan nilai dari view tag.
            holder = (ViewHolder) view.getTag();
        }
        //set item ke TextViews
        holder.name.setText(HomeActivity.ClassNameArrayList.get(i).getName());

        //mengembalikan nilai ke variabel view
        return view;
    }
}
