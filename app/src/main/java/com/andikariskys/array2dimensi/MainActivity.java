package com.andikariskys.array2dimensi;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText tbTambahData;
    Button btnSimpan;
    ListView listData;
    ArrayList<String> dataMakanan = new ArrayList();


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

        getDaftarMakanan();

        btnSimpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dataMakanan.add(tbTambahData.getText().toString());
                getDaftarMakanan();
                tbTambahData.setText("");
                System.out.println(tbTambahData.getText());
            }
        });
    }

    private void getDaftarMakanan() {
        Adapter adapter = new ArrayAdapter(MainActivity.this, com.google.android.material.R.layout.support_simple_spinner_dropdown_item, dataMakanan);
        listData.setAdapter((ListAdapter) adapter);
    }
}