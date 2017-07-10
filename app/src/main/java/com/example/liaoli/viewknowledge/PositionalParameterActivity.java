package com.example.liaoli.viewknowledge;

import android.support.v4.view.ViewConfigurationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ViewConfiguration;
import android.widget.TextView;

public class PositionalParameterActivity extends AppCompatActivity {

    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_positional_parameter);


        textView = (TextView) findViewById(R.id.tv);



        getWindow().getDecorView().post(new Runnable() {

            @Override
            public void run() {
                StringBuilder sb = new StringBuilder("TextView 的位置参数：");

                sb.append("l = ").append(textView.getLeft()).
                        append(",t = ").append(textView.getTop()).
                        append(",r = ").append(textView.getRight()).
                        append(",b = ").append(textView.getBottom()).
                        append(",x = ").append(textView.getX()).
                        append(",y = ").append(textView.getY()).
                        append(",translationX = ").append(textView.getTranslationX()).
                        append(",translationY = ").append(textView.getTranslationY()).
                        append(",其中 x = left + translationX,y = left + translationX，需要注意的是在view的平移动画过程中，left和 top 是原始的左上角的位置坐标，不会发生变化的，改变的是translationX和translationY,系统所能识别的最小滑动距离：TouchSlop = ").
                        append(ViewConfiguration.get(PositionalParameterActivity.this).getScaledTouchSlop());
                textView.setText(sb.toString());
            }
        });
    }
}
