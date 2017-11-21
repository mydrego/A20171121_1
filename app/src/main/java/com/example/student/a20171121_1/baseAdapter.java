package com.example.student.a20171121_1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by student on 2017/11/21.
 */

public class baseAdapter extends BaseAdapter {
    ArrayList<String> data;
    Context context;
    public baseAdapter(Context context, ArrayList<String> data)
    {
        this.context = context;
        this.data = data;
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
        LayoutInflater inflater = LayoutInflater.from(context);
        View v = inflater.inflate(R.layout.mylayout, null);
        TextView tv = (TextView) v.findViewById(R.id.textView);
        tv.setText(data.get(i));
        return v;
    }
}
