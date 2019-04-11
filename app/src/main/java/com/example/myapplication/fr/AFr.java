package com.example.myapplication.fr;

import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.myapplication.Bean;
import com.example.myapplication.MyAdapter;
import com.example.myapplication.R;
import com.example.myapplication.Wangluo;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

/**
 * description: 陈啊
 * author: 陈吉庆
 * date: 2019/4/2 08:56
 * update: $date$
 */
public class AFr extends Fragment {
    private String Urldata="http://v.juhe.cn/toutiao/index?type=top&key=dbedecbcd1899c9785b95cc2d17131c5";
private List<Bean.ResultBean.DataBean>list=new ArrayList<>();
private ListView listview;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.afr, container, false);
       listview = view.findViewById(R.id.listview);
        boolean panduan = Wangluo.panduan(getActivity());
        if(panduan){
            new Asy().execute(Urldata);
        }
        return view;
    }
    public class Asy extends AsyncTask<String,Void,String>{


        @Override
        protected String doInBackground(String... strings) {
            return Wangluo.shuju(strings[0]);
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            Log.i("TTTT",s);
            Gson gson = new Gson();
            Bean bean = gson.fromJson(s, Bean.class);
            list.addAll(bean.getResult().getData());
            MyAdapter myAdapter = new MyAdapter(getActivity(),list);
listview.setAdapter(myAdapter);

        }
    }
}
