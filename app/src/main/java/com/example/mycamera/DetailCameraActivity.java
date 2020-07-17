package com.example.mycamera;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class DetailCameraActivity extends AppCompatActivity {

    protected Cursor cursor;
    String sMerk, sHarga, sGambar;
    DataHelper dbHelper;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_camera);

        Bundle terima = getIntent().getExtras();

        dbHelper = new DataHelper(this);
        Intent intent = getIntent();

        String merk = terima.getString("merk");

        SQLiteDatabase db = dbHelper.getReadableDatabase();
        cursor = db.rawQuery("select * from camera where merk = '" + merk + "'", null);
        cursor.moveToFirst();
        if (cursor.getCount() > 0) {
            sMerk = cursor.getString(0);
            sHarga = cursor.getString(1);
        }

        if (sMerk.equals("Canon EOS 5D Mark IV")) {
            sGambar = "canon EOS 5D Mark IV";
        } else if (sMerk.equals("Canon EOS 77D")) {
            sGambar = "canon EOS 77D";
        } else if (sMerk.equals("Sony alpha A6000")) {
            sGambar = "sony alpha A6500";
        } else if (sMerk.equals("Sony alpha a7 II")) {
            sGambar = "sony alpha a7 III";
        } else if (sMerk.equals("Fujifilm X-A20")) {
            sGambar = "fujifilm X-A20";
        } else if (sMerk.equals("Fujifilm X-A5")) {
            sGambar = "fujifilm X_A5";
        } else if (sMerk.equals("Fujifim-X-Pro2")) {
            sGambar = "fujifil-X-Pro2";
        } else if (sMerk.equals("Nikon-D7500")) {
            sGambar = "nikon-D7500";
        } else if (sMerk.equals("Nikon-D5")) {
            sGambar = "nikon-D5";
        }

        ImageView ivGambar = findViewById(R.id.ivCamera);
        TextView tvMerk = findViewById(R.id.JCamera);
        TextView tvHarga = findViewById(R.id.JHarga);

        setupToolbar();

    }

    private void setupToolbar() {
        Toolbar toolbar = findViewById(R.id.tbDetailCmr);
        toolbar.setTitle("Detail Camera");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

}
