package org.usfirst.frc.team1884.robot.util;

public class Timer {
	private long beginTime;
	
	public Timer(long beginTime) {
		this.beginTime = beginTime;
	}
	
	public boolean hasTimeElapsed(long time) {
		return (System.currentTimeMillis() - beginTime >= time);
	}
	
	public void beginAgainNow() {
		beginTime = System.currentTimeMillis();
	}
}
