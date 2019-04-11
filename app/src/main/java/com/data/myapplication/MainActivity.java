package com.data.myapplication;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.Toast;
import com.data.mylibrary.StackNative;

public class MainActivity extends AppCompatActivity {
    StringBuffer bufferString = new StringBuffer();
    ImageView imageView;
    Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            Bitmap bitmap = (Bitmap)msg.obj;
            if(bitmap != null){
                imageView.setImageBitmap(bitmap);
            }

        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageView = findViewById(R.id.image);
        bufferString.append("");

        Thread thread = new Thread() {
            @Override
            public void run() {
                super.run();
                Bitmap bitmap = BitmapFactory.decodeResource(getResources(),R.drawable.bitmap );
                StackNative.blurBitmap(bitmap,50);
                Message message = handler.obtainMessage();
                message.obj = bitmap;
                handler.sendMessage(message);
                bufferString.append("");
            }
        };
        thread.start();

    }

}
