package com.gl.framelayoutexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class FrameLayoutMain extends AppCompatActivity {
private ImageView imageViewSetVisible,imageViewSetInvisible;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frame_layout_main);
    }

    public void imageClick(View view) {
        switch (view.getId()) {
            case R.id.imageView1:
                imageViewSetVisible=(ImageView)findViewById(R.id.imageView2);
                imageViewSetInvisible=(ImageView)findViewById(R.id.imageView1);
                imageViewSetInvisible.setVisibility(View.INVISIBLE);
                imageViewSetVisible.setVisibility(View.VISIBLE);
                break;
            case R.id.imageView2:
                imageViewSetVisible=(ImageView)findViewById(R.id.imageView3);
                imageViewSetInvisible=(ImageView)findViewById(R.id.imageView2);
                imageViewSetInvisible.setVisibility(View.INVISIBLE);
                imageViewSetVisible.setVisibility(View.VISIBLE);
                break;
            case R.id.imageView3:
                imageViewSetVisible=(ImageView)findViewById(R.id.imageView4);
                imageViewSetInvisible=(ImageView)findViewById(R.id.imageView3);
                imageViewSetInvisible.setVisibility(View.INVISIBLE);
                imageViewSetVisible.setVisibility(View.VISIBLE);
                break;

            case R.id.imageView4:
                imageViewSetVisible=(ImageView)findViewById(R.id.imageView5);
                imageViewSetInvisible=(ImageView)findViewById(R.id.imageView4);
                imageViewSetInvisible.setVisibility(View.INVISIBLE);
                imageViewSetVisible.setVisibility(View.VISIBLE);
                break;

            case R.id.imageView5:
                imageViewSetVisible=(ImageView)findViewById(R.id.imageView1);
                imageViewSetInvisible=(ImageView)findViewById(R.id.imageView5);
                imageViewSetInvisible.setVisibility(View.INVISIBLE);
                imageViewSetVisible.setVisibility(View.VISIBLE);
                break;
        }
    }

}
