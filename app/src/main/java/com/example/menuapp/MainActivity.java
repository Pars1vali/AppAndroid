import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.nfc.Tag;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import com.example.menuapp.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

public class MainActivity extends AppCompatActivity {


    Button menu;

    ImageButton bt1;
    ImageButton bt2;
    ImageButton bt3;
    ImageButton bt4;
    ImageButton bt5;

    LinkedList<ImageButton> imgBtList = new LinkedList<>();

    boolean isClick = false;
    float startX = 574;
    int numberBtn = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_main);

        menu = findViewById(R.id.main_b);
        menu.setText("Menu");

        bt1 = findViewById(R.id.bt1);
        bt1.setVisibility(View.GONE);
        bt1.setContentDescription("It's first Button");
        imgBtList.add(bt1);

        bt2 = findViewById(R.id.bt2);
        bt2.setVisibility(View.GONE);
        bt2.setContentDescription("It's second Button");
        imgBtList.add(bt2);

        bt3 = findViewById(R.id.bt3);
        bt3.setVisibility(View.GONE);
        bt3.setContentDescription("It's third Button");
        imgBtList.add(bt3);

        bt4 = findViewById(R.id.bt4);
        bt4.setVisibility(View.GONE);
        bt4.setContentDescription("It's second Button");
        imgBtList.add(bt4);

        bt5 = findViewById(R.id.bt5);
        bt5.setVisibility(View.GONE);
        bt5.setContentDescription("It's second Button");
        imgBtList.add(bt5);

        menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!isClick) { //  open menu
                    for (int i = 0, fromY = 200; i < imgBtList.size(); i++, fromY += 200) {
                        animationView(imgBtList.get(i), fromY, 0);
                        imgBtList.get(i).setVisibility(View.VISIBLE);

                    }

                } else { //  hide  menu
                    for (int i = 0, toY = 400; i < imgBtList.size(); i++, toY += 200) {
                        animationView(imgBtList.get(i), 0, toY);
                        imgBtList.get(i).clearAnimation();
                        imgBtList.get(i).setVisibility(View.GONE);
                    }
                }
                isClick = !isClick;
            }
        });

        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberBtn = 1;
            }
        });
        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberBtn = 2;
            }
        });
        bt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberBtn = 3;
            }
        });
        bt4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberBtn = 4;
            }
        });
        bt5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberBtn = 5;
            }
        });

    }


    public boolean onTouchEvent(MotionEvent event) {
        if (event.getX() < startX && event.getAction() == MotionEvent.ACTION_UP) {
            switch (numberBtn) {
                case 1:
                    bt1.clearAnimation();
                    bt1.setVisibility(View.GONE);
                    imgBtList.remove(bt1);
                    numberBtn = 0;
                    break;
                case 2:
                    bt2.clearAnimation();
                    bt2.setVisibility(View.GONE);
                    imgBtList.remove(bt2);
                    numberBtn = 0;
                    break;
                case 3:
                    bt3.clearAnimation();
                    bt3.setVisibility(View.GONE);
                    imgBtList.remove(bt3);
                    numberBtn = 0;
                    break;
                case 4:
                    bt4.clearAnimation();
                    bt4.setVisibility(View.GONE);
                    imgBtList.remove(bt4);
                    numberBtn = 0;
                    break;
                case 5:
                    bt5.clearAnimation();
                    bt5.setVisibility(View.GONE);
                    imgBtList.remove(bt5);
                    numberBtn = 0;
                    break;
                case 0:
                    break;
            }
        }
        return true;
    }

    private void animationView(View view, float fromY, float toY) { //animation open/hide menu
        TranslateAnimation translateAnimation = new TranslateAnimation(0, 0, fromY, toY);
        translateAnimation.setDuration(500);
        translateAnimation.setFillAfter(true);
        view.startAnimation(translateAnimation);
    }
}

