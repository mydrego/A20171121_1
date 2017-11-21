package com.example.student.a20171121_1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by student on 2017/11/21.
 */

public class baseAdapter extends BaseAdapter {
    ArrayList<String> data;
    Context context;
    public boolean chkArray[];

    public baseAdapter(Context context, ArrayList<String> data) {
        this.context = context;
        this.data = data;
        chkArray = new boolean[data.size()];
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder;
        if (view == null) {

        }else {

        }

        LayoutInflater inflater = LayoutInflater.from(context);
        View v = inflater.inflate(R.layout.mylayout, null);
        TextView tv = (TextView) v.findViewById(R.id.textView);
        tv.setText(data.get(i));
        final int p = i;
        CheckBox chk = v.findViewById(R.id.checkBox);
        chk.setChecked(chkArray[i]);
        chk.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                chkArray[p] = b;
            }
        });
        return v;
    }

    static class ViewHolder {
        TextView tv;
        CheckBox chk;
    }
}
