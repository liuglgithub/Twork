package com.liugl.alltest.view.datapick;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.liugl.alltest.BaseActivity;
import com.liugl.alltest.R;

public class DatePickActivity extends BaseActivity {
    private CalendarView calendarView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_date_pick);
        calendarView = (CalendarView) findViewById(R.id.calendarview);
        calendarView.setDate("2016-12-31");
        calendarView.setOnDateSelectedListener(new CalendarView.OnDateSelectedListener() {
            @Override
            public void onDateSelected(int year, int month, int day) {
                Toast.makeText(DatePickActivity.this, year+"=" + month + "=" + day, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
