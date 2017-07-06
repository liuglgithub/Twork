package com.liugl.alltest.view.shijianzhou;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import com.liugl.alltest.R;

public class ShiJianZhouActivity extends AppCompatActivity {
    private TimeLineView timeLine;
    /**
     * 显示物流的listview
     * */
    private ListView lvLogistics;
    /**
     * 自定义的物流跟踪状态显示的view
     * */
    private TimeLineView timeLines;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shi_jian_zhou);
        timeLine=(TimeLineView) findViewById(R.id.tv_timelines);
        timeLine.setTimelineCount(6);//设置显示多少个时间轴
//		timeLine.setTimelineHeadRadius(10);
        timeLine.setTimelineRadius(8);//设置下面那些轴的圆点直径
        timeLine.setTimelineWidth(3);//设置时间轴的宽度
        timeLine.setTimelineRadiusDistance(80);//设置时间轴的高度
    }
}
