package com.kelompok3.listpresidenindonesia;

import android.app.ActionBar;
import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Objects;

public class DetailPresidentActivity extends AppCompatActivity {
    TextView name,masa_jabat,deskripsi;
    ImageView foto;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_president);

        name = findViewById(R.id.txt_intent_nama_presiden);
        masa_jabat = findViewById(R.id.txt_intent_masa_jabatan);
        //deskripsi = findViewById(R.id.txt_deskripsi_presiden);
        WebView webView = (WebView)findViewById(R.id.txt_deskripsi_presiden);


        foto = findViewById(R.id.img_presiden);


        Intent intent = getIntent();
        String receivedName = intent.getStringExtra("name");
        String receivedMasaJabat = intent.getStringExtra("masa_jabat");
        String receivedDeskripsi = intent.getStringExtra("deskripsi");
        int receivedFoto = intent.getIntExtra("foto",0);

        name.setText(receivedName);
        masa_jabat.setText(receivedMasaJabat);
        //deskripsi.setText(receivedDeskripsi);
        webView.loadData("<p style=\"text-align: justify\">"+ receivedDeskripsi +"</p>", "text/html", "UTF-8");
        foto.setImageResource(receivedFoto);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(receivedName);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            onBackPressed();
        }
        return super.onOptionsItemSelected(item);

    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}
