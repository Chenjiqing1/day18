package com.example.myapplication;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * description: 陈啊
 * author: 陈吉庆
 * date: 2019/4/2 09:12
 * update: $date$
 */
public class MyAdapter extends BaseAdapter {
    private Context context;
    private List<Bean.ResultBean.DataBean> list;

    public MyAdapter(Context context, List<Bean.ResultBean.DataBean> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder holder;
        if(convertView==null){
            convertView=View.inflate(context,R.layout.buju,null);
              holder=new ViewHolder();
              holder.name=convertView.findViewById(R.id.name);
 convertView.setTag(holder);
        }
        else{
            holder= (ViewHolder) convertView.getTag();

        }
holder.name.setText(list.get(position).getAuthor_name());
        return convertView;
    }
    class ViewHolder{
        private TextView name;


    }
}
