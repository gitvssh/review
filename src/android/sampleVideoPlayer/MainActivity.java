//package com.example.administrator.samplevideoplayer;
//
//import android.app.Activity;
//import android.media.AudioManager;
//import android.media.MediaPlayer;
//import android.net.Uri;
//import android.os.Bundle;
//import android.view.View;
//import android.widget.Button;
//import android.widget.MediaController;
//import android.widget.Toast;
//import android.widget.VideoView;
//
//public class MainActivity extends Activity {
//    static final String VIDEO_URL = "http://sites.google.com/site/ubiaccessmobile/sample_video.mp4";
//    private VideoView videoView;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//
//        Button startBtn = (Button)findViewById(R.id.startBtn);
//        Button volumeBtn = (Button)findViewById(R.id.volumeBtn);
//
//        startBtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                videoView.seekTo(0);
//                videoView.start();
//            }
//        });
//
//        volumeBtn.setOnClickListener(new View.OnClickListener(){
//            @Override
//            public void onClick(View v) {
//                AudioManager mAudioManager = (AudioManager)getSystemService(AUDIO_SERVICE);
//                int maxVolume = mAudioManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC);
//                mAudioManager.setStreamVolume(AudioManager.STREAM_MUSIC,maxVolume,AudioManager.FLAG_SHOW_UI);
//            }
//        });
//
//        videoView = (VideoView)findViewById(R.id.videoView);
//
//        MediaController mc = new MediaController(this);
//        videoView.setMediaController(mc);
//        videoView.setVideoURI(Uri.parse(VIDEO_URL));
//        videoView.requestFocus();
//
//        videoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener(){
//            @Override
//            public void onPrepared(MediaPlayer mp) {
//                Toast.makeText(getApplicationContext(),"비디오 재생 준비됨",Toast.LENGTH_SHORT).show();
//            }
//        });
//
//        videoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener(){
//            @Override
//            public void onCompletion(MediaPlayer mp) {
//                Toast.makeText(getApplicationContext(),"비디오 재생 완료됨",Toast.LENGTH_SHORT).show();
//            }
//        });
//    }
//
//    protected void onResume(){
//        Toast.makeText(getApplicationContext(),"비디오 재생 다시시작됨",Toast.LENGTH_SHORT).show();
//
//        super.onResume();
//    }
//}
