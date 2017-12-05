package com.example.student.a20171121_1;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<String> mylist;
    ArrayList<String> mypics;
    ListView lv;
    baseAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mylist = new ArrayList<>();
        mypics = new ArrayList<>();
        String data[] = getResources().getStringArray(R.array.mydata);
        String pics[] = getResources().getStringArray(R.array.pics);
        for (String s : data) {
            mylist.add(s);
        }
        for (String s : pics)
        {
            mypics.add(s);
        }
        lv = (ListView) findViewById(R.id.listview);
        adapter = new baseAdapter(this, mylist, mypics);
        lv.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.mymenu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.showchk) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < mylist.size(); i++) {
                if (adapter.chkArray[i]) {
                    sb.append(mylist.get(i));
                    sb.append(",");
                }
            }
            Toast.makeText(MainActivity.this, sb.toString(), Toast.LENGTH_SHORT).show();
        }

        if (item.getItemId() == R.id.add) {
            AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
            builder.setTitle("ADD");
            final EditText ed = new EditText(this);
            builder.setView(ed);
            builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    mylist.add(ed.getText().toString());
                    adapter.chkArray = new boolean[mylist.size()];
                }
            });
            builder.setNegativeButton("ESC", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                }
            });
            builder.show();
        }

        if (item.getItemId() == R.id.del) {
            for (int i = mylist.size() - 1; i >= 0; i--) {
                if (adapter.chkArray[i]) {
                    mylist.remove(i);
                }
            }
            adapter.chkArray = new boolean[mylist.size()];
            adapter.notifyDataSetChanged();
        }
        return super.onOptionsItemSelected(item);
    }
}




