package battleship;

class Cruiser extends Ship{
	
	// methods
	
	/*
	 * the constructor
	 */
	Cruiser() {
		this.length = 3;
		this.hit = new boolean[] {false, false, false, true};
	}

	/*
	 * return the type of the ship
	 * @see battleship.Ship#getShipType()
	 */
	@Override
	public String getShipType() {
		return "cruiser";
	}
	
}
