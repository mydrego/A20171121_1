package com.example.student.a20171121_1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by student on 2017/11/21.
 */

public class baseAdapter extends BaseAdapter {
    ArrayList<String> data;
    ArrayList<String> pics;
    Context context;
    public boolean chkArray[];

    public baseAdapter(Context context, ArrayList<String> data, ArrayList<String> pics) {
        this.context = context;
        this.data = data;
        this.pics = pics;
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
            LayoutInflater inflater = LayoutInflater.from(context);
            view = inflater.inflate(R.layout.mylayout, null);
            holder = new ViewHolder();
            holder.tv = (TextView) view.findViewById(R.id.textView);
            holder.chk = (CheckBox) view.findViewById(R.id.checkBox);
            holder.img = (ImageView) view.findViewById(R.id.imageView);
            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
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
                if (chkArray.length - 1 >= p) {
                    chkArray[p] = b;
                }
            }
        });
        Picasso.with(context).load(pics.get(i)).into(holder.img);
        return v;
    }

    static class ViewHolder {
        TextView tv;
        CheckBox chk;
        ImageView img;
    }
}
