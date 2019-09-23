package com.kelompok3.listpresidenindonesia;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Objects;

public class MainActivity extends AppCompatActivity {
    private String[] dataName;
    private String[] dataMasaJabat;
    private String[] dataDeskripsi;
    private int tmp;
    private TypedArray dataPhoto;
    private PresidenAdapter adapter;
    private ArrayList<Presiden> presidens;
    int[] photo = new int[1000];


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        adapter = new PresidenAdapter(this);
        ListView listView = findViewById(R.id.listview);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(getApplicationContext(), DetailPresidentActivity.class);
                intent.putExtra("name", dataName[i]);
                intent.putExtra("masa_jabat", dataMasaJabat[i]);
                intent.putExtra("deskripsi", dataDeskripsi[i]);
                intent.putExtra("foto", photo[i]);
                //intent.putExtra("foto",dataPhoto.getResourceId(i));
                startActivity(intent);
            }
        });

        prepare();
        addItem();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.more_vert, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.show_about:
                Intent intent = new Intent(getApplicationContext(), ShowAboutActivity.class);
                startActivity(intent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void addItem() {
        presidens = new ArrayList<>();

        for (int i = 0; i < dataName.length; i++) {
            Presiden presiden = new Presiden();
            tmp = dataPhoto.getResourceId(i, -1);
            presiden.setPhoto(tmp);

            photo[i] = tmp;
            //presiden.setPhoto(dataPhoto.getResourceId(i,-1));
            presiden.setNama(dataName[i]);
            presiden.setMasa_jabatan(dataMasaJabat[i]);
            presiden.setDeskripsi(dataDeskripsi[i]);
            presidens.add(presiden);
        }
        adapter.setPresiden(presidens);
    }

    private void prepare() {
        dataName = getResources().getStringArray(R.array.data_name);
        dataMasaJabat = getResources().getStringArray(R.array.data_masa_jabat);
        dataDeskripsi = getResources().getStringArray(R.array.data_deskripsi);
        dataPhoto = getResources().obtainTypedArray(R.array.data_photo);
    }


}
