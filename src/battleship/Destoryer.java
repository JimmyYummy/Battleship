package battleship;

class Destoryer extends Ship{
	
	// methods
	
	/*
	 * the constructor
	 */
	Destoryer() {
		this.length = 2;
		this.hit = new boolean[] {false, false, true, true};
	}

	/*
	 * return the type of the ship
	 * @see battleship.Ship#getShipType()
	 */
	@Override
	public String getShipType() {
		return "destoryer";
	}
	
}
