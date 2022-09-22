package com.example.cashier;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class StrukActivity extends AppCompatActivity {

    EditText j, n, h, t, b, k;
    Button quit;
    double dj, dh, hasil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_struk);

        j = findViewById(R.id.txtJumlah);
        n = findViewById(R.id.txtNama);
        h = findViewById(R.id.editHarga);
        t = findViewById(R.id.txtTotal);
        b = findViewById(R.id.txtBayar);
        k = findViewById(R.id.txtKembali);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();

        String in = bundle.getString("NAMA");
        String ij = bundle.getString("JUMLAH");
        String ih = bundle.getString("HARGA");
        String it = bundle.getString("TOTAL");
        String ib = bundle.getString("BAYAR");

        j.setText(ij);
        n.setText(in);
        h.setText(ih);
        t.setText(it);
        b.setText(ib);

        dj = Double.parseDouble(ij);
        dh = Double.parseDouble(ih);
        hasil = dj * dh;

        k.setText(String.valueOf(hasil));

        quit.setOnClickListener(view -> {
            Intent quitIntent = new Intent(this, MainActivity.class);
            quitIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
            quitIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            quitIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(quitIntent);
        });
    }
}