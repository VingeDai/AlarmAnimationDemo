package com.test.app;

import java.util.ArrayList;

import android.app.Activity;
import android.os.Bundle;
import android.widget.GridView;

import com.example.alarmtest.R;
import com.test.app.adapter.StateAdapter;
import com.test.app.entity.StatePojo;

/**
 * @author daij 设备监测
 */
public class MainActivity extends Activity {
	private ArrayList<StatePojo> messages = new ArrayList<StatePojo>();
	private StateAdapter stateAdapter;
	private GridView gvStates;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_monitror);

		setViews();
	}

	private void setViews() {
		gvStates = (GridView) findViewById(R.id.gv_monitor);

		messages.add(new StatePojo().setArea("地区A").setRed(89).setYellow(45)
				.setBlue(1));
		messages.add(new StatePojo().setArea("地区B").setRed(56).setYellow(12)
				.setBlue(3));
		messages.add(new StatePojo().setArea("地区C").setRed(32).setYellow(98)
				.setBlue(4));
		messages.add(new StatePojo().setArea("地区D").setRed(121).setYellow(11)
				.setBlue(5));
		messages.add(new StatePojo().setArea("地区E").setRed(12).setYellow(23)
				.setBlue(9));
		messages.add(new StatePojo().setArea("地区F").setRed(0).setYellow(12)
				.setBlue(7));
		messages.add(new StatePojo().setArea("地区G").setRed(45).setYellow(25)
				.setBlue(8));
		messages.add(new StatePojo().setArea("地区H").setRed(65).setYellow(8)
				.setBlue(0));

		// 设置适配器
		stateAdapter = new StateAdapter(this, R.layout.gridview_item, messages);
		gvStates.setAdapter(stateAdapter);
	}

}
