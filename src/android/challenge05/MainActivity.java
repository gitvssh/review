//package com.example.administrator.challenge05;
//
//import android.content.Intent;
//import android.support.annotation.Nullable;
//import android.support.v7.app.AppCompatActivity;
//import android.os.Bundle;
//import android.view.View;
//import android.widget.Button;
//import android.widget.EditText;
//import android.widget.TextView;
//import android.widget.Toast;
//
//import java.text.SimpleDateFormat;
//import java.util.Date;
//import java.util.zip.Inflater;
//
//public class MainActivity extends AppCompatActivity {
//    public static final int REQUEST_CODE_BIRTH = 101;
//
//    EditText editName,editAge;
//    Button button;
//    TextView birth;
//
//    String name,age,birthday;
//    Date today = new Date();
//    SimpleDateFormat date = new SimpleDateFormat("yyyy년 MM월 dd일");
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//
//        editName = (EditText)findViewById(R.id.editName);
//        editAge = (EditText)findViewById(R.id.editAge);
//        button = (Button)findViewById(R.id.button);
//        birth = (TextView)findViewById(R.id.birthButton);
//
//        birth.setText(date.format(today));
//
//        birth.setOnClickListener(new View.OnClickListener(){
//            @Override
//            public void onClick(View v) {
//            Intent intent = new Intent(getApplicationContext(),birthActivity.class);
//            startActivityForResult(intent,REQUEST_CODE_BIRTH);
//            }
//        });
//
//        button.setOnClickListener(new View.OnClickListener(){
//            @Override
//            public void onClick(View v) {
//                name = editName.getText().toString();
//                age = editName.getText().toString();
//                birthday=birth.getText().toString();
//
//                Toast.makeText(getApplicationContext(),"이름 : "+name+", 나이 : "+age+", 생일 : "+birthday,Toast.LENGTH_LONG).show();
//            }
//        });
//    }
//
//    @Override
//    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
//
//        if(requestCode==REQUEST_CODE_BIRTH){
//            if(resultCode==RESULT_OK){
//                String result = data.getExtras().getString("year")+data.getExtras().getString("month")+data.getExtras().getString("day");
//                birth.setText(result);
//            }
//        }
//    }
//}
