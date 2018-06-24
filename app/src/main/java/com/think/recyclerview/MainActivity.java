package com.think.recyclerview;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.demonstrate.DialogUtil;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    protected Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setContentView(R.layout.activity_main);
        initView();
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.btn) {
            DialogUtil.showListDialog(this, "recyclerview操作", new String[]{
                    "0线性纵向列表",
                    "1表格列表",
                    "2流式列表",
                    "3线性横向列表",
                    "4线性纵向列表带分隔线",
            }, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    switch (which){
                        case 0:
                            MainActivity.this.startActivity(new Intent(MainActivity.this,RecyclerView1DemoAcitity.class));
                            break;
                        case 1:
                            MainActivity.this.startActivity(new Intent(MainActivity.this,RecyclerView2DemoAcitity.class));
                            break;
                        case 2:
                            MainActivity.this.startActivity(new Intent(MainActivity.this,RecyclerView3DemoAcitity.class));
                            break;
                        case 3:
                            MainActivity.this.startActivity(new Intent(MainActivity.this,RecyclerView4DemoAcitity.class));
                            break;
                        case 4:
                            MainActivity.this.startActivity(new Intent(MainActivity.this,RecyclerView5DemoAcitity.class));
                            break;
                    }
                }
            });
        }
    }

    private void initView() {
        btn = (Button) findViewById(R.id.btn);
        btn.setOnClickListener(MainActivity.this);
    }
}
