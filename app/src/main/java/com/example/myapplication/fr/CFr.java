package com.example.myapplication.fr;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.myapplication.R;

/**
 * description: 陈啊
 * author: 陈吉庆
 * date: 2019/4/2 08:56
 * update: $date$
 */
public class CFr extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.cfr, container, false);

        return view;
    }
}
