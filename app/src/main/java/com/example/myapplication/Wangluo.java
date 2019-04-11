package com.example.myapplication;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 * description: 陈啊
 * author: 陈吉庆
 * date: 2019/4/2 08:44
 * update: $date$
 */
public class Wangluo {
    public static boolean panduan(Context context){
        ConnectivityManager manager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = manager.getActiveNetworkInfo();
           if(networkInfo!=null){
               return networkInfo.isAvailable();
           }
           else{
               Toast.makeText(context,"网络连接失败",Toast.LENGTH_LONG).show();

           }
        return false;
    }
public static String shuju(String Urldata){
    try {
        URL url = new URL(Urldata);
        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
httpURLConnection.setRequestMethod("GET");
        int code = httpURLConnection.getResponseCode();
if(code==200){
    InputStream inputStream = httpURLConnection.getInputStream();
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
    StringBuilder builder = new StringBuilder();
String a="";
while ((a=bufferedReader.readLine())!=null){
    builder.append(a);
}
return  builder.toString();


}


    } catch (Exception e) {
        e.printStackTrace();
    }


    return "";
}
}
