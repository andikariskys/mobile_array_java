package com.andikariskys.array2dimensi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<String> dataMakanan = new ArrayList();
    EditText tbTambahData;
    Button btnSimpan;
    ListView listData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tbTambahData = findViewById(R.id.etTambahMakanan);
        btnSimpan = findViewById(R.id.btnTambah);
        listData = findViewById(R.id.list_makanan);

        dataMakanan.add("Nasi Goreng");
        dataMakanan.add("Nasi Bakar");
        dataMakanan.add("Nasi Soto");

        Adapter adapter = new ArrayAdapter(MainActivity.this, com.google.android.material.R.layout.support_simple_spinner_dropdown_item, dataMakanan);

        listData.setAdapter((ListAdapter) adapter);
    }
}