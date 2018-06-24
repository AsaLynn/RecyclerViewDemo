package com.think.recyclerview;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by think on 2017/12/8.
 */

public class Rv1Adapter extends RecyclerView.Adapter<Rv1Adapter.ViewHolder> {

    private String[] mTitles = new String[21];

    //无参数构造
    public Rv1Adapter() {
        for (int i = 0; i <= 20; i++) {
            mTitles[i] = "item" + i;
        }
    }

    /**
     * item显示类型,视图创建
     *
     * @param parent   父控件,在这里就是reclerview
     * @param viewType 指的是条目类型.
     * @return
     */
    @Override
    public Rv1Adapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_rv1, parent, false);
        //使用下面方法布局属性部分不生效.
//        View.inflate(parent.getContext(), R.layout.item_rv1, null);
        return new ViewHolder(view);
    }

    /**
     * 数据的绑定显示,
     *
     * @param holder
     * @param position
     */
    @Override
    public void onBindViewHolder(Rv1Adapter.ViewHolder holder, int position) {
        holder.tv1.setText(mTitles[position]);
    }

    /**
     * 重写此方法,返回条目数量.
     * @return
     */
    @Override
    public int getItemCount() {
        return mTitles.length;
    }


    public static class ViewHolder extends RecyclerView.ViewHolder {

        TextView tv1;

        public ViewHolder(View view) {
            super(view);
            tv1 = view.findViewById(R.id.tv1);
        }
    }
}
