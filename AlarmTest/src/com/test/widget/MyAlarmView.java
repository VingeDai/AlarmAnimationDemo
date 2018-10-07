package com.test.widget;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

/**
 * @author daij 地震波效果,可根据故障严重程度调节闪烁速度
 */
public class MyAlarmView extends View {

	private Paint paint;
	private int maxWidth = 128;
	private boolean isStarting = false;
	private int delay;
	private List<String> alphaList = new ArrayList<String>();
	private List<String> startWidthList = new ArrayList<String>();

	public MyAlarmView(Context context) {
		super(context);
		init();
	}

	public MyAlarmView(Context context, AttributeSet attrs) {
		super(context, attrs);
		init();
	}

	public MyAlarmView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		init();
	}

	private void init() {
		paint = new Paint();
		paint.setColor(Color.RED);// 此处颜色可以改为自己喜欢的
		alphaList.add("128");// 圆心的不透明度
		startWidthList.add("0");
	}

	@Override
	public void onDraw(Canvas canvas) {
		super.onDraw(canvas);
		setBackgroundColor(Color.TRANSPARENT);// 颜色：完全透明
		// 依次绘制 同心圆
		for (int i = 0; i < alphaList.size(); i++) {
			int alpha = Integer.parseInt(alphaList.get(i));
			int startWidth = Integer.parseInt(startWidthList.get(i));
			paint.setAlpha(alpha);// 设置透明度
			canvas.drawCircle(getWidth() / 2, getHeight() / 2, startWidth,
					paint);
			// 同心圆扩散
			if (isStarting && alpha > 0 && startWidth < maxWidth) {
				alphaList.set(i, (alpha - 1) + "");
				startWidthList.set(i, (startWidth + 1) + "");
			}
		}
		if (isStarting
				&& Integer
						.parseInt(startWidthList.get(startWidthList.size() - 1)) == maxWidth / 5) {
			alphaList.add("128");
			startWidthList.add("0");
		}
		// 同心圆数量达到6个，删除最外层圆
		if (isStarting && startWidthList.size() == 6) {
			startWidthList.remove(0);
			alphaList.remove(0);
		}
		postDelayed(new Runnable() {
			@Override
			public void run() {
				// 刷新界面
				invalidate();
			}
		}, delay);
	}

	// 地震波开始/继续进行
	public void start() {
		isStarting = true;
	}

	// 地震波暂停
	public void stop() {
		isStarting = false;
	}

	public boolean isStarting() {
		return isStarting;
	}

	/**
	 * 根据传入的数值决定刷新的频度，数值越大，刷新越快，效果越醒目
	 * 
	 * @param red
	 */
	public void handleDelay(int red) {
		delay = 100 - red;
	}

}
