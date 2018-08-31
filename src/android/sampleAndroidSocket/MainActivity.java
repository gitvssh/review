//package com.example.administrator.sampleandroidsocket;
//
//import android.support.v7.app.AppCompatActivity;
//import android.os.Bundle;
//import android.util.Log;
//import android.view.View;
//import android.widget.Button;
//import android.widget.EditText;
//
//import java.io.ObjectInputStream;
//import java.io.ObjectOutputStream;
//import java.net.Socket;
//
//public class MainActivity extends AppCompatActivity {
//    EditText input01;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//
//        input01 = (EditText)findViewById(R.id.editText);
//
//        Button button01 = (Button)findViewById(R.id.button);
//        button01.setOnClickListener(new View.OnClickListener(){
//            @Override
//            public void onClick(View v) {
//                String addr = input01.getText().toString().trim();
//
//                ConnectThread thread = new ConnectThread(addr);
//                thread.start();
//            }
//        });
//    }
//
//    class ConnectThread extends Thread{
//        String hostname;
//
//        public ConnectThread(String addr){
//            hostname = addr;
//        }
//
//        public void run(){
//            try{
//                int port = 5001;
//
//                Socket socket = new Socket(hostname,port);
//                ObjectOutputStream outstream =  new ObjectOutputStream(socket.getOutputStream());
//                outstream.flush();
//
//                ObjectInputStream instream = new ObjectInputStream(socket.getInputStream());
//                String obj = (String) instream.readObject();
//
//                Log.d("MainActivity","서버에서 받은 메시지 : " +obj);
//
//                socket.close();
//
//            }catch(Exception ex){
//                ex.printStackTrace();;
//            }
//        }
//    }
//}
