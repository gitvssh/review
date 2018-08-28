//package com.example.administrator.samplecalendar;
//
//import android.support.v7.app.AppCompatActivity;
//import android.os.Bundle;
//import android.util.Log;
//import android.view.View;
//import android.widget.AdapterView;
//import android.widget.Button;
//import android.widget.GridView;
//import android.widget.TextView;
//
//public class MainActivity extends AppCompatActivity {
//    GridView monthView;
//
//    MonthAdapter monthViewAdapter;
//
//    TextView monthText;
//
//    int curYear;
//    int curMonth;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//
//        monthView = (GridView)findViewById(R.id.monthView);
//        monthViewAdapter = new MonthAdapter(this);
//        monthView.setAdapter(monthViewAdapter);
//
//        monthView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                MonthItem curItem = (MonthItem)monthViewAdapter.getItem(position);
//                int day = curItem.getDay();
//
//                Log.d("MainAcitivity", "Selected :"+day);
//            }
//        });
//
//        monthText = (TextView)findViewById(R.id.monthText);
//        setMonthText();
//
//        Button monthPrevious = (Button)findViewById(R.id.monthPrevious);
//        monthPrevious.setOnClickListener(new View.OnClickListener(){
//            @Override
//            public void onClick(View v) {
//                monthViewAdapter.setPreviousMonth();
//                monthViewAdapter.notifyDataSetChanged();
//
//                setMonthText();
//            }
//        });
//
//        Button monthNext = (Button)findViewById(R.id.monthNext);
//        monthNext.setOnClickListener(new View.OnClickListener(){
//            @Override
//            public void onClick(View v) {
//                monthViewAdapter.setNextMonth();
//                monthViewAdapter.notifyDataSetChanged();
//
//                setMonthText();
//            }
//        });
//    }
//
//    private void setMonthText(){
//        curYear = monthViewAdapter.getCurYear();
//        curMonth = monthViewAdapter.getCurMonth();
//
//        monthText.setText(curYear +"년 : "+(curMonth+1)+"월");
//    }
//}
