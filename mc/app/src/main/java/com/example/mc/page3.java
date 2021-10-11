package com.example.mc;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AlertDialogLayout;
import androidx.appcompat.widget.Toolbar;

import android.content.ContentValues;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.friendb;

import java.security.ProtectionDomain;
import java.util.concurrent.TimeUnit;

public class page3 extends AppCompatActivity {
    private static final String DB_FILE = "friend.db",
            DB_TABLE = "friends";
    private friendb mFriend;
    private ImageView imageView5;
    private Button button4;
  //  private TextView textview5;
    int rdo;
    int a=0,b=0,c=0,d=0,e=0,f=0,g=0,h=0;
   // private TextView textView3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page3);
        //toorbar
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        imageView5=(ImageView)findViewById(R.id.imageView5);
        button4=findViewById(R.id.button4);
       // textview5=findViewById(R.id.textView5);
       // textView3=findViewById(R.id.textView3);

        button4.setOnClickListener(btn4);


        //處理圖片要取哪個資料傳輸
        Bundle bundle2 = getIntent().getExtras();
        if(bundle2!=null)
        {
            int resId2 = bundle2.getInt("res");
            rdo =bundle2.getInt("res");
            imageView5.setImageResource(resId2);
       /*    if(resId2==R.drawable.a) {
                textview5.setText(resId2);
            }*/

        }

        //資料庫部分
        mFriend = new friendb(getApplicationContext(), DB_FILE, null, 1);
        SQLiteDatabase friendDB = mFriend.getReadableDatabase();
        Cursor cursor = friendDB.rawQuery("select DISTINCT tbl_name from sqlite_master where " + " tbl_name = '" + DB_TABLE + "'", null);
        if (cursor != null) {
            if (cursor.getCount() == 0)
                friendDB.execSQL("CREATE TABLE " + DB_TABLE + " (" +
                        "_id INTEGER PRIMARY KEY," +
                        "name TEXT NOT NULL," +
                        "number INTERGER );"
                        );
            cursor.close();
        }

        friendDB.close();
    }

    private Button.OnClickListener btn4 = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.button4:
                    new AlertDialog.Builder(page3.this)
                            .setTitle("確認兌換優惠")
                            .setMessage("請確認您已在麥當勞櫃台,點選「立即兌換」後,需於兩分鐘內出示給結帳人員")
                            .setPositiveButton("立即兌換",new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    int Second=119;
                                    new CountDownTimer(Second* 1000+1000, 1000) {

                                        public void onTick(long millisUntilFinished) {
                                            int seconds = (int) (millisUntilFinished / 1000);
                                            int minutes = seconds / 60;
                                            seconds = seconds % 60;
                                            Drawable drawable=getDrawable(R.drawable.a);
                                            button4.setText(" ⏰ "+" 優惠倒數  " + String.format("%02d", minutes)
                                                    + ":" + String.format("%02d", seconds));
                                        }

                                        public void onFinish() {
                                            button4.setText("兌換優惠");
                                        }
                                    }.start();
                                    //資料庫輸入
                                    SQLiteDatabase friendDB = mFriend.getWritableDatabase();
                                    if(rdo==R.drawable.a){
                                        friendDB = mFriend.getWritableDatabase();
                                        ContentValues newRow = new ContentValues();
                                        a++;
                                        newRow.put("name", "麥克雞塊分享盒+大薯");
                                        newRow.put("number", a);
                                        friendDB.insert(DB_TABLE, null, newRow);
                                        friendDB.close();
                                    }
                                    //2
                                    else if(rdo==R.drawable.b){
                                        friendDB = mFriend.getWritableDatabase();
                                        ContentValues newRow = new ContentValues();
                                        b++;
                                        newRow.put("name", "BLT安格斯黑牛+中杯可樂");
                                        newRow.put("number", b);
                                        friendDB.insert(DB_TABLE, null, newRow);
                                        friendDB.close();
                                    }
                                    //3
                                    else if(rdo==R.drawable.c){
                                        friendDB = mFriend.getWritableDatabase();
                                        ContentValues newRow = new ContentValues();
                                        c++;
                                        newRow.put("name", "勁辣雞腿堡買一送一");
                                        newRow.put("number", c);
                                        friendDB.insert(DB_TABLE, null, newRow);
                                        friendDB.close();
                                    }
                                    //4
                                    else if(rdo==R.drawable.d){
                                        friendDB = mFriend.getWritableDatabase();
                                        ContentValues newRow = new ContentValues();
                                        d++;
                                        newRow.put("name", "大麥克買一送一");
                                        newRow.put("number", d);
                                        friendDB.insert(DB_TABLE, null, newRow);
                                        friendDB.close();
                                    }
                                    //5
                                    else if(rdo==R.drawable.l){
                                        friendDB = mFriend.getWritableDatabase();
                                        ContentValues newRow = new ContentValues();
                                        e++;
                                        newRow.put("name", "酪梨安格斯黑牛堡買一送一");
                                        newRow.put("number", e);
                                        friendDB.insert(DB_TABLE, null, newRow);
                                        friendDB.close();
                                    }
                                    //6
                                    else if(rdo==R.drawable.h){
                                        friendDB = mFriend.getWritableDatabase();
                                        ContentValues newRow = new ContentValues();
                                        f++;
                                        newRow.put("name", "大薯買一送一");
                                        newRow.put("number", f);
                                        friendDB.insert(DB_TABLE, null, newRow);
                                        friendDB.close();
                                    }
                                    //7
                                    else if(rdo==R.drawable.z){
                                        friendDB = mFriend.getWritableDatabase();
                                        ContentValues newRow = new ContentValues();
                                        g++;
                                        newRow.put("name", "麥克雞塊買一送一");
                                        newRow.put("number", g);
                                        friendDB.insert(DB_TABLE, null, newRow);
                                        friendDB.close();
                                    }
                                    //8
                                    else if(rdo==R.drawable.e){
                                        friendDB = mFriend.getWritableDatabase();
                                        ContentValues newRow = new ContentValues();
                                        h++;
                                        newRow.put("name", "大蛋捲冰淇淋+1元多一份");
                                        newRow.put("number", h);
                                        friendDB.insert(DB_TABLE, null, newRow);
                                        friendDB.close();
                                    }


                                }
                            })
                            .setNegativeButton("暫不兌換",new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {

                                }
                            })
                           .show();

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
            intent.setClass(page3.this, MainActivity.class);
            startActivityForResult(intent, 1);
        }
        if(id==R.id.menu_about){
            Intent intent = new Intent();
            intent.setClass(page3.this, exchange.class);
            startActivityForResult(intent, 1);
        }
        if(id==R.id.finish){
            finishAffinity();
        }


        return super.onOptionsItemSelected(item);
    }
}