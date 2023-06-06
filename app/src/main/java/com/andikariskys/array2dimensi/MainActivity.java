package com.andikariskys.array2dimensi;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

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

        listData.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                AlertDialog.Builder alertDialog = new AlertDialog.Builder(MainActivity.this);
                alertDialog.setTitle("Opsi Anda");
                alertDialog.setMessage(dataMakanan.get(position));

                alertDialog.setNegativeButton("Hapus", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dataMakanan.remove(position);
                        getDaftarMakanan();
                    }
                });

                AlertDialog dialog = alertDialog.create();
                dialog.show();
            }
        });
    }

    private void getDaftarMakanan() {
        Adapter adapter = new ArrayAdapter(MainActivity.this, com.google.android.material.R.layout.support_simple_spinner_dropdown_item, dataMakanan);
        listData.setAdapter((ListAdapter) adapter);
    }
}