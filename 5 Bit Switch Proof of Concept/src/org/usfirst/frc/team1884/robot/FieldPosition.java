package org.usfirst.frc.team1884.robot;

public enum FieldPosition {
	pos1((byte) 0b00), pos2((byte) 0b01), pos3((byte) 0b10), pos4((byte) 0b11);
	
	private byte id;
	
	private FieldPosition(byte id) {
		this.id = id;
	}
	
	public byte getID() {
		return id;
	}
}
