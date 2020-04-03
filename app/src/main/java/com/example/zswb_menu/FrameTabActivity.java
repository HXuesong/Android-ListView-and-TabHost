package com.example.zswb_menu;

import android.app.ActivityGroup;
import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TabHost;
import android.widget.TabWidget;
import android.widget.TextView;

public class FrameTabActivity extends ActivityGroup {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);

        TabHost tab = (TabHost) findViewById(android.R.id.tabhost);

        //初始化TabHost容器
        tab.setup(this.getLocalActivityManager());
        //在TabHost创建标签，然后设置：标题／图标／标签页布局
        tab.addTab(tab.newTabSpec("tab1").setIndicator("快捷", getResources().getDrawable(R.drawable.quick)).setContent(new Intent(this,NormalActivity.class)));
        tab.addTab(tab.newTabSpec("tab2").setIndicator("好友", getResources().getDrawable(R.drawable.friend)).setContent(R.id.tab2));
        tab.addTab(tab.newTabSpec("tab3").setIndicator("日志",getResources().getDrawable(R.drawable.log)).setContent(R.id.tab3));
        tab.addTab(tab.newTabSpec("tab4").setIndicator("相册",getResources().getDrawable(R.drawable.photo)).setContent(R.id.tab4));

        TabWidget tw = tab.getTabWidget();
        for (int i = 0; i < tw.getChildCount(); i++)
        {
            TextView tv=(TextView)tw.getChildAt(i).findViewById(android.R.id.title);
            ImageView iv=(ImageView)tw.getChildAt(i).findViewById(android.R.id.icon);
            iv.setPadding(0, 0, 0, 0);
            tv.setPadding(0, 0, 0, -8);
            tv.setTextSize(15);
        }

    }

}
