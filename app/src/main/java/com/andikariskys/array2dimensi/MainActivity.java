package com.andikariskys.array2dimensi;

import static android.graphics.Color.*;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.graphics.Color;
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
    Button btnCancel;
    ListView listData;
    ArrayList<String> dataMakanan = new ArrayList();
    String indexList = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tbTambahData = findViewById(R.id.etTambahMakanan);
        btnSimpan = findViewById(R.id.btnTambah);
        btnCancel = findViewById(R.id.btnCancel);
        btnCancel.setBackgroundColor(RED);
        listData = findViewById(R.id.list_makanan);

        dataMakanan.add("Nasi Goreng");
        dataMakanan.add("Nasi Bakar");
        dataMakanan.add("Nasi Soto");

        getDaftarMakanan();

        btnSimpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (indexList == null) {
                    dataMakanan.add(tbTambahData.getText().toString());
                } else {
                    dataMakanan.set(Integer.parseInt(indexList), tbTambahData.getText().toString());
                }
                getDaftarMakanan();
                resetTextbox();
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
                        resetTextbox();
                    }
                });

                alertDialog.setPositiveButton("Edit", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        indexList = String.valueOf(position);
                        tbTambahData.setText(dataMakanan.get(position));
                        btnSimpan.setText("Simpan");
                        btnCancel.setVisibility(View.VISIBLE);
                    }
                });

                AlertDialog dialog = alertDialog.create();
                dialog.show();
            }
        });

        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resetTextbox();
            }
        });
    }

    private void resetTextbox() {
        tbTambahData.setText("");
        indexList = null;
        btnSimpan.setText("Tambah");
        btnCancel.setVisibility(View.GONE);
    }

    private void getDaftarMakanan() {
        Adapter adapter = new ArrayAdapter(MainActivity.this, com.google.android.material.R.layout.support_simple_spinner_dropdown_item, dataMakanan);
        listData.setAdapter((ListAdapter) adapter);
    }
}