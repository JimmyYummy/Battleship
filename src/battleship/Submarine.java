package battleship;

class Submarine extends Ship{
	
	// methods
	
	/*
	 * the constructor
	 */
	Submarine() {
		this.length = 1;
		this.hit = new boolean[] {false, true, true, true};
	}

	/*
	 * return the type of the ship
	 * @see battleship.Ship#getShipType()
	 */
	@Override
	public String getShipType() {
		return "submarine";
	}
	
}
