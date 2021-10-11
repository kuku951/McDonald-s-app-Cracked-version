package com.example.mc;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Paint;
import android.icu.util.Calendar;
import android.location.Location;
import android.os.Build;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Parcelable;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.DateFormat;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Date;
import java.util.Random;

public class page2 extends AppCompatActivity {
    private ImageView imageView,imageView2;
    private TextView textView2;
    private Button button;
    int xx;

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page2);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        imageView=(ImageView)findViewById(R.id.imageView);
        imageView2=(ImageView)findViewById(R.id.imageView2);
        textView2=findViewById(R.id.textView2);
        button=findViewById(R.id.button);

        button.setOnClickListener(btn);

        imageView2=findViewById(R.id.imageView2);
        imageView2.setOnClickListener(btnimg);
        //按鈕增加底線
        Button button = (Button) findViewById(R.id.button);
        button.setPaintFlags(button.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);

        //處理時間part
        Calendar calendar = Calendar.getInstance();
        int years = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH)+1;
        int day = calendar.get(Calendar.DAY_OF_MONTH)+2;
        Random x = new Random();
        int a= x.nextInt(49);
        while(a>=24||a<0){
             a= x.nextInt(49);
        }
        textView2 .setText("期限 : " + years+" 年 "+ month+" 月 "+day+" 日 "+" "+"尚餘 : 1 天 "+a+" 小時");

        //處理圖片要取哪個資料傳輸
        Bundle bundle = getIntent().getExtras();
        xx= bundle.getInt("resId");
        if(bundle!=null)
        {
            int resId = bundle.getInt("resId");
            imageView.setImageResource(resId);
        }

    }
    private Button.OnClickListener btn= new View.OnClickListener(){//選擇viewOnclick
        @Override
        public void onClick(View v) {
            Intent intent2=new Intent();
            intent2.setClass(page2.this,page3.class);
            intent2.putExtra("res", xx);
            startActivityForResult(intent2,1);
        }
    };

    private Button.OnClickListener btnimg= new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent3=new Intent();
            intent3.setClass(page2.this,MainActivity.class);
            startActivityForResult(intent3,1);
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
            intent.setClass(page2.this, MainActivity.class);
            startActivityForResult(intent, 1);
        }
        if(id==R.id.menu_about){
            Intent intent = new Intent();
            intent.setClass(page2.this, exchange.class);
            startActivityForResult(intent, 1);
        }
        if(id==R.id.finish){
            finishAffinity();
           // startActivity(intent);


        }

        return super.onOptionsItemSelected(item);
    }


}