package org.usfirst.frc.team1884.robot.debug;

public enum FieldPosition {
	pos1((byte) 0b00, "pos1"), pos2((byte) 0b01, "pos2"), pos3((byte) 0b10, "pos3"), pos4((byte) 0b11, "pos4");
	
	private byte id;
	private String name;
	
	private FieldPosition(byte id, String name) {
		this.id = id;
		this.name = name;
	}
	
	public byte getID() {
		return id;
	}
	
	public String toString() {
		return name;
	}
}
