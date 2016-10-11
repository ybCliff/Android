package com.example.yblab3;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;


/**
 * Created by 杨邦 on 2016/10/9.
 */
public class MyAdapter extends BaseAdapter {
    private List<String> list;
    private Context context;
    private LayoutInflater listContainer;
    public MyAdapter(Context context, List<String> anotherlist){
        this.list = anotherlist;
        this.context = context;
        listContainer = LayoutInflater.from(context);
    }
    @Override
    public int getCount() {
        if(list == null)
            return 0;
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        if(list == null)
            return null;
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        if(convertView == null){
            holder = new ViewHolder();
            convertView = listContainer.inflate(R.layout.item, null);

            holder.letter = (Button) convertView.findViewById(R.id.letter);
            holder.name = (TextView) convertView.findViewById(R.id.name);
            convertView.setTag(holder);
        }else{
            holder = (ViewHolder) convertView.getTag();
        }
        holder.letter.setText(String.valueOf(list.get(position).charAt(0)));
        holder.name.setText(list.get(position));

        return convertView;
    }
    public void refresh(List<String> list) {
        this.list = list;
        notifyDataSetChanged();
    }

    private class ViewHolder {
        public Button letter;
        public TextView name;
    }
}