package org.usfirst.frc.team1884.robot;

public enum FieldObstacle {
	Portcullis((byte) 0b000),
	ChevalDeFrise((byte) 0b001),
	Moat((byte) 0b010),
	Ramparts((byte) 0b011),
	Drawbridge((byte) 0b100),
	SallyPort((byte) 0b101),
	RockWall((byte) 0b110),
	RoughTerrain((byte) 0b111);
	
	private byte id;
	private FieldObstacle(byte id) {
		this.id = id;
	}
	
	public byte getID() {
		return id;
	}
}
