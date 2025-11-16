package com.example.lyngoclong_bai01;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class QgiaAdapter extends BaseAdapter {
    private Context context;
    private List<Qgia> list;
    private LayoutInflater inflater;

    public QgiaAdapter(Context context, List<Qgia> list) {
        this.context = context;
        this.list = list;
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View convertView, ViewGroup viewGroup) {
        ViewHolder holder;

        if (convertView == null) {
            convertView = inflater.inflate(R.layout.row_item_quocgia, viewGroup, false);
            holder = new ViewHolder();
            holder.tenQG = (TextView) convertView.findViewById(R.id.customtenqg);
            holder.danSo = (TextView) convertView.findViewById(R.id.customdansoqg);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        Qgia qgia = list.get(i);
        holder.tenQG.setText(qgia.getTenQG());
        holder.danSo.setText(String.valueOf(qgia.getDanSo()));

        return convertView;
    }

    private static class ViewHolder {
        TextView tenQG;
        TextView danSo;
    }
}
