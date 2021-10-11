package com.example.mc;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.friendb;

import static java.nio.file.attribute.AclEntryPermission.DELETE;

public class exchange extends AppCompatActivity {
    private TextView txt;
    private Button bitch;
    private static final String DB_FILE = "friend.db",
            DB_TABLE = "friends";
    private friendb mFriend;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exchange);

        txt = findViewById(R.id.txt);
        bitch = findViewById(R.id.bitch);

        bitch.setOnClickListener(btn5);

        mFriend = new friendb(getApplicationContext(), DB_FILE, null, 1);
        SQLiteDatabase friendDB = mFriend.getWritableDatabase();

        Cursor c = friendDB.query(true, DB_TABLE, new String[]{"name", "number"}, null, null, null, null, null, null);
        if (c == null) {
            //         Toast.makeText(exchange.this, "哈哈", Toast.LENGTH_SHORT).show();
            return;
        }
        if (c.getCount() == 0) {
            txt.setText("");
            Toast.makeText(exchange.this, "沒有這筆資料", Toast.LENGTH_SHORT).show();
        } else {
            c.moveToFirst();
            txt.setText(" 已點餐點 : " + c.getString(0) + " 累積份數 : " + c.getInt(1));
            while (c.moveToNext())
                txt.append("\n" + " 已點餐點 : " + c.getString(0) + " 累積份數 : " + c.getInt(1));
        }
        friendDB.close();
    }

    private Button.OnClickListener btn5 = new Button.OnClickListener() {

        @Override
        public void onClick(View v) {
            //這邊是刪除部分
            friendb mFriend2 = new friendb(getApplicationContext(), DB_FILE, null, 1);
            SQLiteDatabase friendDB2 = mFriend2.getWritableDatabase();
            friendDB2.execSQL("DELETE FROM "+ DB_TABLE);
            //friendDB.close();
          // friendDB.delete("name", null, null);
           // friendDB.close();
           /* mFriend = new friendb(getApplicationContext(), DB_FILE, null, 1);
            friendDB = mFriend.getWritableDatabase();
            friendDB.delete("number", null, null);*/

            Toast.makeText(exchange.this, "已清除資料", Toast.LENGTH_SHORT).show();
            txt.setText("");

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
                intent.setClass(exchange.this, MainActivity.class);
                startActivityForResult(intent, 1);
            }
            if (id == R.id.menu_about) {
                Intent intent = new Intent();
                intent.setClass(exchange.this, exchange.class);
                startActivityForResult(intent, 1);
            }
            if(id==R.id.finish){
                finishAffinity();
            }

            return super.onOptionsItemSelected(item);
        }
    }
