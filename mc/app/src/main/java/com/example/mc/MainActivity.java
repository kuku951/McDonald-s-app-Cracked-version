package com.example.mc;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.res.ResourcesCompat;

import android.view.View;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ImageButton;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ImageButton ba,bb,bc,bd,be,bf,bg,bh;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ba=findViewById(R.id.ba);
        bb=findViewById(R.id.bb);
        bc=findViewById(R.id.bc);
        bd=findViewById(R.id.bd);
        be=findViewById(R.id.be);
        bf=findViewById(R.id.bf);
        bg=findViewById(R.id.bg);
        bh=findViewById(R.id.bh);
        ba.setOnClickListener(btnba);
        bb.setOnClickListener(btnba);
        bc.setOnClickListener(btnba);
        bd.setOnClickListener(btnba);
        be.setOnClickListener(btnba);
        bf.setOnClickListener(btnba);
        bg.setOnClickListener(btnba);
        bh.setOnClickListener(btnba);
    }
    private Button.OnClickListener btnba= new Button.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.ba:
                    Intent intent = new Intent();
                    intent.setClass(MainActivity.this, page2.class);
                    intent.putExtra("resId", R.drawable.a);
                    startActivityForResult(intent, 1);
                    break;
                case R.id.bb:
                    intent = new Intent();
                    intent.setClass(MainActivity.this, page2.class);
                    intent.putExtra("resId", R.drawable.b);
                    startActivityForResult(intent, 1);
                    break;
                case R.id.bc:
                    intent = new Intent();
                    intent.setClass(MainActivity.this, page2.class);
                    intent.putExtra("resId", R.drawable.c);
                    startActivityForResult(intent, 1);
                    break;

                case R.id.bd:
                    intent = new Intent();
                    intent.setClass(MainActivity.this, page2.class);
                    intent.putExtra("resId", R.drawable.d);
                    startActivityForResult(intent, 1);
                    break;

                case R.id.be:
                    intent = new Intent();
                    intent.setClass(MainActivity.this, page2.class);
                    intent.putExtra("resId", R.drawable.l);
                    startActivityForResult(intent, 1);
                    break;

                case R.id.bf:
                    intent = new Intent();
                    intent.setClass(MainActivity.this, page2.class);
                    intent.putExtra("resId", R.drawable.h);
                    startActivityForResult(intent, 1);
                    break;
                case R.id.bg:
                    intent = new Intent();
                    intent.setClass(MainActivity.this, page2.class);
                    intent.putExtra("resId", R.drawable.z);
                    startActivityForResult(intent, 1);
                    break;
                case R.id.bh:
                    intent = new Intent();
                    intent.setClass(MainActivity.this, page2.class);
                    intent.putExtra("resId", R.drawable.e);
                    startActivityForResult(intent, 1);
                    break;
            }

        }
    };

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            Intent intent = new Intent();
            intent.setClass(MainActivity.this, MainActivity.class);
            startActivityForResult(intent, 1);
        }
        if(id==R.id.menu_about){
            Intent intent = new Intent();
            intent.setClass(MainActivity.this, exchange.class);
            startActivityForResult(intent, 1);
        }
        if(id==R.id.finish){
          /*  Intent intent = new Intent(getApplicationContext(), .class);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            intent.putExtra("EXIT", true);
            startActivity(intent);*/
            finishAffinity();


        }

        return super.onOptionsItemSelected(item);
    }

}