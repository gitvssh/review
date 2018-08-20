//package com.example.administrator.exercise03;
//
//import android.support.v7.app.AppCompatActivity;
//import android.os.Bundle;
//import android.telephony.SmsManager;
//import android.text.Editable;
//import android.text.TextWatcher;
//import android.view.View;
//import android.widget.EditText;
//import android.widget.TextView;
//import android.widget.Toast;
//
//public class MainActivity extends AppCompatActivity {
//
//    EditText editText;
//    String text;
//    TextView textView;
//
//    TextWatcher textWatcher = new TextWatcher() {
//        @Override
//        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
//
//        }
//
//        @Override
//        public void onTextChanged(CharSequence s, int start, int before, int count) {
//            text = editText.getText().toString();
//            textView.setText(text.length()+"/80 諛붿씠�듃");
//        }
//
//        @Override
//        public void afterTextChanged(Editable s) {
//
//        }
//    };
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//
//        editText = (EditText)findViewById(R.id.edittext);
//        textView = (TextView)findViewById(R.id.textView);
//        editText.addTextChangedListener(textWatcher);
//    }
//
//
//
//    public void onClickButton1(View view) {
//        text = editText.getText().toString();
//
//        SmsManager smsManager = SmsManager.getDefault();
//        Toast.makeText(MainActivity.this,text,Toast.LENGTH_LONG).show();
//
//    }
//
//    public void onClickButton2(View view){
//        finish();
//    }
//}
