package com.example.liaoli.viewknowledge;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.widget.TextView;

public class VelocityActivity extends AppCompatActivity {

    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_velocity);
         textView = (TextView) findViewById(R.id.tv);
    }


    private VelocityTracker velocityTracker = null;
    @Override
    public boolean onTouchEvent(MotionEvent event) {

        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:

                //【1.1】通过静态消息VelocityTracker.obtain()获取对象
                if(velocityTracker == null){
                    velocityTracker = VelocityTracker.obtain();
                }else {
                    //【1.2】对于重用的vt，清空，回复初始状态
                    velocityTracker.clear();
                }
                //【2.1】加入MotionEvent信息，这是获取的第一个event信息，速度为0。
                velocityTracker.addMovement(event);

                break;
            case MotionEvent.ACTION_MOVE:
                //【2.2】加入MotionEvent的信息，获得第二个event信息，就可以有效计算速度
                velocityTracker.addMovement(event);
                //【3】设置计算速度的单位 pixel/unit，unit为1，单位为pixels/ms，我们设置为1000，速度单位为pixels/s
                velocityTracker.computeCurrentVelocity(1000);
                //【4】获取X方向和Y方向的速度，在调用getX|YVelocity()之前必须先执行computeCurrentVelocity()。
                textView.setText("x 方向的速度"+velocityTracker.getXVelocity() + "\ny 方向的速度"+velocityTracker.getYVelocity());


                break;
            case MotionEvent.ACTION_UP:
            case MotionEvent.ACTION_CANCEL:
            /* 【5】回收，其他人可以用，我们将用在下一个动作。此外，我们不在ACTION_UP的时候计算，因为此时速度为0。
             * 如果我们在游戏中计算抛投物体的速度，通常是ACTION_MOVE的最后速度，不要在ACTION_UP中计算。
             * VelocityTracker是比较费资源的，因此当我们不需要的使用就应该recycle()，运行其他人使用，虽然
             * Android允许多个VelocityTracker，但这会消耗大量内存，因此不同应recycle()，并重复使用 */
                if (velocityTracker != null) {
                    velocityTracker.recycle();
                    velocityTracker = null;
                }
                break;
        }




        return super.onTouchEvent(event);
    }
}
