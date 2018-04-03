package com.hikplayer;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

/**
 * author : zhongwr on 2016/7/12
 * SurfaceView类的成员函数draw和dispatchDraw的参数canvas所描述的都是建立在宿主窗口的绘图表面上的画布，
 * 因此，在这块画布上绘制的任何UI都是出现在宿主窗口的绘图表面上的。
 * <p/>
 * 本来SurfaceView类的成员函数draw是用来将自己的UI绘制在宿主窗口的绘图表面上的，
 * 但是这里我们可以看到，如果当前正在处理的SurfaceView不是用作宿主窗口面板的时候，
 * 即其成员变量mWindowType的值不等于WindowManager.LayoutParams.TYPE_APPLICATION_PANEL的时候，
 * SurfaceView类的成员函数draw只是简单地将它所占据的区域绘制为黑色。
 */
public class SinSurfaceView extends SurfaceView implements Runnable {
    private SurfaceHolder mSurfaceHolder;
    /**
     * 用于保存正弦路径坐标
     */
    private Path mPath;
    private Paint mPaint;

    public SinSurfaceView(Context context) {
        super(context);
        init();
    }

    public SinSurfaceView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public SinSurfaceView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        mPaint = new Paint();
        mPaint.setAntiAlias(true);
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeWidth(5);
        mPaint.setColor(Color.GREEN);
        //连接处更加平滑
        mPaint.setStrokeJoin(Paint.Join.ROUND);

        mPath = new Path();

        /**通过holder去申请绘图表面的画布，surfaceview其实draw()或dispathDraw()都只是一块默认的黑色区域，并不是用作宿主
         * 真正要做的事情由开发者自行绘制，绘制之前就是通过holder获取一块内存区域的画布，
         * 然后可在UI线程或工作线程在这个画布上进行绘制所需要的视图，最后还是通过holder提交这个画布就可以显示
         * */
        mSurfaceHolder = getHolder();
        //回调
        mSurfaceHolder.addCallback(new SurfaceHolder.Callback() {
            /***
             * surfaceview的绘图表面（就是activity宿主创建一个透明的表面用于surfaceView绘制）被创建时执行
             * 在updateWindow（）创建宿主（activity的窗口）的绘图表面时会回调，虽然surfaceView是独立于一个线程但还是离不开宿主窗口，
             * 最后还是要粘贴到window中
             *
             * surfaceCreated方法，是当SurfaceView被显示时会调用的方法，所以你需要再这边开启绘制的线 程
             *
             * @param holder
             */
            @Override
            public void surfaceCreated(SurfaceHolder holder) {
                new Thread(SinSurfaceView.this).start();
            }

            /**
             * 创建、更新会认为发生变化也会回调这个方法
             * @param holder
             * @param format
             * @param width
             * @param height
             */
            @Override
            public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

            }

            /***
             *surfaceDestroyed方法是当SurfaceView被隐藏会销毁时调用的方法，在这里你可以关闭绘制的线程
             * @param holder
             */
            @Override
            public void surfaceDestroyed(SurfaceHolder holder) {
                isDrawing = false;
            }
        });
    }

    /***
     * 是否在绘制:用于关闭子线程:true则表示一直循环
     */
    private boolean isDrawing = true;
    private int drawX;
    private int drawY;

    /***
     * 注意这个是在子线程中绘制的
     */
    @Override
    public void run() {
        while (isDrawing) {
            drawX++;
            drawY = (int) (100 * Math.sin(drawX * 2 * Math.PI / 180) + 400);
            mPath.lineTo(drawX, drawY);
            draw(mPath);
        }

    }

    /***
     * 注意这个是在子线程中绘制的，surface支持子线程更新ui，所以
     */
    private void draw(Path path) {
        Canvas canvas = null;
        //给画布加锁，防止线程安全，防止该内存区域被其他线程公用
        canvas = mSurfaceHolder.lockCanvas();
        if (null != canvas) {
            //清屏操作或者设置背景
            canvas.drawColor(Color.WHITE);
            canvas.drawPath(mPath, mPaint);
            //提交显示视图并解锁，防止长期占用此内存
            mSurfaceHolder.unlockCanvasAndPost(canvas);
        }
    }
}
