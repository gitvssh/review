//package com.example.administrator.samplepagesliding;
//
//import androidx.appcompat.app.AppCompatActivity;
//
//import android.os.Bundle;
//import android.view.View;
//import android.view.animation.Animation;
//import android.view.animation.AnimationUtils;
//import android.widget.Button;
//import android.widget.LinearLayout;
//
//public class MainActivity extends AppCompatActivity {
//    boolean isPageOpen = false;
//
//    Animation translateLeftAnim,translateRightAnim;
//
//    LinearLayout page;
//    Button button;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//
//        page = (LinearLayout)findViewById(R.id.page);
//
//        translateLeftAnim = AnimationUtils.loadAnimation(this,R.anim.translate_left);
//        translateRightAnim = AnimationUtils.loadAnimation(this,R.anim.translate_right);
//
//        button = (Button)findViewById(R.id.button);
//        SlidingPageAnimationListener animLisstener = new SlidingPageAnimationListener();
//        translateLeftAnim.setAnimationListener(animLisstener);
//        translateRightAnim.setAnimationListener(animLisstener);
//    }
//
//    public void onButton1Clicked(View v){
//        if(isPageOpen){
//            page.startAnimation(translateRightAnim);
//        }else{
//            page.setVisibility(View.VISIBLE);
//            page.startAnimation(translateLeftAnim);
//        }
//    }
//    private class SlidingPageAnimationListener implements Animation.AnimationListener {
//        @Override
//        public void onAnimationStart(Animation animation) {
//
//        }
//
//        @Override
//        public void onAnimationEnd(Animation animation) {
//            if (isPageOpen) {
//                page.setVisibility(View.INVISIBLE);
//
//                button.setText("Open");
//                isPageOpen=false;
//            }else{
//                button.setText("Close");
//                isPageOpen=true;
//            }
//        }
//
//        @Override
//        public void onAnimationRepeat(Animation animation) {
//
//        }
//    }
//
//}
