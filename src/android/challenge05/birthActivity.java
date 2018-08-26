//package com.example.administrator.challenge05;
//
//import android.content.Intent;
//import android.support.v7.app.AppCompatActivity;
//import android.os.Bundle;
//import android.view.View;
//import android.widget.Button;
//import android.widget.EditText;
//
//public class birthActivity extends AppCompatActivity {
//    EditText year,month,day;
//    Button confirm,cancel;
//
//    String yearInput,monthInput,dayInput;
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_birth);
//
//        year = (EditText)findViewById(R.id.editText);
//        month = (EditText)findViewById(R.id.editText2);
//        day = (EditText)findViewById(R.id.editText3);
//        confirm = (Button)findViewById(R.id.button2);
//        cancel = (Button)findViewById(R.id.button3);
//
//        confirm.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                yearInput = year.getText().toString();
//                monthInput = month.getText().toString();
//                dayInput = day.getText().toString();
//
//                Intent intent = new Intent();
//                intent.putExtra("year",yearInput);
//                intent.putExtra("month",monthInput);
//                intent.putExtra("day",dayInput);
//                setResult(RESULT_OK,intent);
//                finish();
//            }
//        });
//
//        cancel.setOnClickListener(new View.OnClickListener(){
//            @Override
//            public void onClick(View v) {
//                setResult(RESULT_CANCELED);
//                finish();
//            }
//        });
//
//    }
//}
