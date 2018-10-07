package com.test.app.adapter;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.alarmtest.R;
import com.test.app.entity.StatePojo;
import com.test.widget.MyAlarmView;

/**
 * @author daij
 * @version 1.0
 * 
 *          状态的adapter
 */
public class StateAdapter extends BaseAdapter {
	Context context;
	private List<StatePojo> messages = null;
	private int resourceId;

	public StateAdapter(Context con) {
		this.context = con;
	}

	public StateAdapter(Context con, int gridviewItem,
			ArrayList<StatePojo> messages) {
		this.context = con;
		resourceId = gridviewItem;
		this.messages = messages;
	}

	@Override
	public int getCount() {
		// return messages.size();
		return 8;
	}

	@Override
	public StatePojo getItem(int arg0) {
		return messages.get(arg0);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		View rowView = convertView;
		ViewHolder viewHolder;
		final StatePojo state = getItem(position);

		if (rowView == null) {
			LayoutInflater vi = (LayoutInflater) context
					.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			rowView = vi.inflate(resourceId, parent, false);
			viewHolder = new ViewHolder();

			// 配置ViewHolder
			viewHolder.tvArea = (TextView) rowView.findViewById(R.id.tv_area);
			viewHolder.smwWave = (MyAlarmView) rowView
					.findViewById(R.id.swvWave);
			viewHolder.tvRedNum = (TextView) rowView
					.findViewById(R.id.tv_red_state);
			// viewHolder.tvYellowNum = (TextView) rowView
			// .findViewById(R.id.tv_yellow_state);
			// viewHolder.tvBlueNum = (TextView) rowView
			// .findViewById(R.id.tv_blue_state);

			rowView.setTag(viewHolder);
		} else {
			viewHolder = (ViewHolder) rowView.getTag();
		}

		viewHolder.tvArea.setText(state.area);
		viewHolder.smwWave.handleDelay(state.red);
		viewHolder.smwWave.start();
		viewHolder.tvRedNum.setText(String.valueOf(state.red));

		viewHolder.tvRedNum.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				// TODO 处理点击事件
				// context.startActivity(new Intent(context,
				// MalfunctionList.class));
			}
		});
//		 viewHolder.tvYellowNum.setText(String.valueOf(state.yellow));
//		 viewHolder.tvBlueNum.setText(String.valueOf(state.blue));

		return rowView;
	}

	static class ViewHolder {
		// 获取所有item组件
		TextView tvArea;// 地区
		MyAlarmView smwWave;// 水波
		TextView tvRedNum;// 红色
//		 TextView tvYellowNum;// 黄色
//		 TextView tvBlueNum;// 绿色
	}
}
