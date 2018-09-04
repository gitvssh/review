//package com.example.administrator.sampleweb;
//
//import android.os.Handler;
//import android.support.v7.app.AppCompatActivity;
//import android.os.Bundle;
//import android.view.View;
//import android.webkit.JavascriptInterface;
//import android.webkit.JsResult;
//import android.webkit.WebChromeClient;
//import android.webkit.WebSettings;
//import android.webkit.WebView;
//import android.widget.Button;
//import android.widget.EditText;
//
//public class MainActivity extends AppCompatActivity {
//    private WebView webView;
//    private Handler handler = new Handler();
//    Button loadButton;
//    EditText urlInput;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//
//        webView = (WebView)findViewById(R.id.webView);
//        urlInput = (EditText)findViewById(R.id.urlInput);
//        loadButton = (Button)findViewById(R.id.loadButton);
//
//        WebSettings webSettings = webView.getSettings();
//        webSettings.setJavaScriptEnabled(true);
//
//        webView.setWebChromeClient(new WebBrowserClient());
//        webView.addJavascriptInterface(new JavaScriptMethods(),"sample");
//        webView.loadUrl("http://naver.com");
//
//        loadButton.setOnClickListener(new View.OnClickListener(){
//            @Override
//            public void onClick(View v) {
//                webView.loadUrl(urlInput.getText().toString());
//            }
//        });
//    }
//
//    final class JavaScriptMethods {
//        JavaScriptMethods() {
//        }
//        @android.webkit.JavascriptInterface
//        public void clickOnFace(){
//            handler.post(new Runnable(){
//                public void run(){
//                    loadButton.setText("클릭 후 열기");
//                    webView.loadUrl("javascript:changeFace()");
//                }
//            });
//        }
//
//    }
//
//
//    final class WebBrowserClient extends WebChromeClient{
//        public boolean onJsAlert(WebView view, String url, String message, JsResult result){
//            result.confirm();
//
//            return true;
//        }
//    }
//}

REVIWED 09/04/18
