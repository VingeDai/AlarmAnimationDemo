package com.test.app.entity;

/**
 * @author daij 状态实体
 */
public class StatePojo {

	public static final String TAG = "StatePojo";

	public String area;
	public int red;// 这里我只设置了红色报警，以下其他属性可根据需求选则
	public int blue;
	public int yellow;

	public String getArea() {
		return area;
	}

	public StatePojo setArea(String area) {
		this.area = area;
		return this;
	}

	public int getRed() {
		return red;
	}

	public StatePojo setRed(int red) {
		this.red = red;
		return this;
	}

	public int getBlue() {
		return blue;
	}

	public StatePojo setBlue(int blue) {
		this.blue = blue;
		return this;
	}

	public int getYellow() {
		return yellow;
	}

	public StatePojo setYellow(int yellow) {
		this.yellow = yellow;
		return this;
	}

}
