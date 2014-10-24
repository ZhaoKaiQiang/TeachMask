package com.qust.teachmask;

import android.app.Activity;
import android.graphics.PixelFormat;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;

public class MainActivity extends Activity {

	private ImageView img;

	private WindowManager windowManager;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		windowManager = getWindowManager();

		// 动态初始化图层
		img = new ImageView(this);
		img.setLayoutParams(new LayoutParams(
				android.view.ViewGroup.LayoutParams.MATCH_PARENT,
				android.view.ViewGroup.LayoutParams.MATCH_PARENT));
		img.setScaleType(ScaleType.FIT_XY);
		img.setImageResource(R.drawable.guide);

		// 设置LayoutParams参数
		LayoutParams params = new WindowManager.LayoutParams();
		// 设置显示的类型，TYPE_PHONE指的是来电话的时候会被覆盖，其他时候会在最前端，显示位置在stateBar下面，其他更多的值请查阅文档
		params.type = WindowManager.LayoutParams.TYPE_PHONE;
		// 设置显示格式
		params.format = PixelFormat.RGBA_8888;
		// 设置对齐方式
		params.gravity = Gravity.LEFT | Gravity.TOP;
		// 设置宽高
		params.width = ScreenUtils.getScreenWidth(this);
		params.height = ScreenUtils.getScreenHeight(this);

		// 添加到当前的窗口上
		windowManager.addView(img, params);

		// 点击图层之后，将图层移除
		img.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				windowManager.removeView(img);
			}
		});

	}
}
