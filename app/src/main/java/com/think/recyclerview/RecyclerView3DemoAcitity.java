package com.think.recyclerview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;

public class RecyclerView3DemoAcitity extends AppCompatActivity {

    private RecyclerView rv1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view1_demo_acitity);
        initView();
    }

    private void initView() {
        //实例化RecyclerView
        rv1 = (RecyclerView) findViewById(R.id.rv1);

        //设置固定大小,设置条目固定大小.
        rv1.setHasFixedSize(true);
        //创建流式布局
        //给RecyclerView设置布局管理器
        //参数:1,列数.2,方向的常量.
        rv1.setLayoutManager(new StaggeredGridLayoutManager(2, OrientationHelper.VERTICAL));
        //创建适配器，并且设置
        rv1.setAdapter(new Rv1Adapter());
    }
}
