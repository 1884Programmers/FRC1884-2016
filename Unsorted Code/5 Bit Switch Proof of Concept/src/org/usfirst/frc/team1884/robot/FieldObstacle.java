package org.usfirst.frc.team1884.robot;

public enum FieldObstacle {
	Portcullis((byte) 0b000, "Portcullis"),
	ChevalDeFrise((byte) 0b001, "Cheval de Frise"),
	Moat((byte) 0b010, "Moat"),
	Ramparts((byte) 0b011, "Ramparts"),
	Drawbridge((byte) 0b100, "Drawbridge"),
	SallyPort((byte) 0b101, "Sally Port"),
	RockWall((byte) 0b110, "Rock Wall"),
	RoughTerrain((byte) 0b111, "Rough Terrain");
	
	private byte id;
	private String name;
	
	private FieldObstacle(byte id, String name) {
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
