package battleship;

class EmptySea extends Ship{

	// methods

	/*
	 * the constructor
	 */
	public EmptySea() {
		this.length = 1;
		this.hit = new boolean[] {false, false, false, false};
	}

	/*
	 * mark the ship as hit when is hit
	 * always returns false to indicate that nothing was hit
	 * @see battleship.Ship#shootAt(int, int)
	 */
	@Override
	public boolean shootAt(int row, int column) {
		this.getHit()[0] = true;
		return false;
	}

	/*
	 * always returns false to indicate that you didn¡¯t sink anything
	 * @see battleship.Ship#isSunk()
	 */
	@Override
	public boolean isSunk() {
		return false;
	}

	/*
	 * returns a single-character String to use in the Ocean¡¯s print method
	 * @see battleship.Ship#toString()
	 */
	@Override
	public String toString() {
			return ".";
	}

	/*
	 * returns empty
	 * @see battleship.Ship#getShipType()
	 */
	@Override
	public String getShipType() {
		return "empty";
	}

}
