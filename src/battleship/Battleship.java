package battleship;

class Battleship extends Ship{
	
	// methods
	
	/*
	 * the constructor
	 */
	Battleship() {
		this.length = 4;
		this.hit = new boolean[] {false, false, false, false};
	}
	
	/*
	 * return the type of the ship
	 * @see battleship.Ship#getShipType()
	 */
	@Override
	public String getShipType() {
		return "battleship";
	}
	
}
