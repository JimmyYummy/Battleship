package battleship;

import java.util.Arrays;

class Ship {
	// instance variables

	// minus one stands for not yet implemented
	private int bowRow = -1;
	private int bowColumn = -1;
	protected int length;
	private boolean horizontal;
	protected boolean[] hit;

	// methods
	// getters
	/*
	 * returns the length
	 */
	public int getLength() {
		return this.length;
	}

	/*
	 * return the row corresponding to the position of the bow
	 */
	public int getBowRow() {
		return this.bowRow;
	}

	/*
	 * return the bow column location
	 */
	public int getBowColumn() {
		return this.bowColumn;
	}

	/*
	 *  return the hit array
	 */
	public boolean[] getHit() {
		return this.hit;
	}

	/*
	 * return whether the ship is horizontal or not
	 */
	public boolean isHorizontal() {
		return this.horizontal;
	}

	/*
	 * returns an empty string, to be overridden in subclass
	 */
	public String getShipType() {
		return new String();
	}

	// setters
	/*
	 * Sets the value of bowRow
	 */
	public void setBowRow(int row) {
		// if the input is in range
		if(row >= 0 && row <= 9) {
			this.bowRow = row;
		}
	}

	/*
	 * Sets the value of bowColumn
	 */
	public void setBowColumn(int column) {
		// if the input is in range
		if(column >= 0 && column <= 9) {
			this.bowColumn = column;
		}
	}

	/*
	 * Sets the value of the instance variable horizontal.
	 */
	public void setHorizontal(boolean horizontal) {
		this.horizontal = horizontal;
	}

	//Other methods
	/*
	 * Helper method:
	 * return whether the ship could be placed at the location
	 * dimension1 is the row when horizontal or column when vertical
	 * and dimention2 is the dimension left
	 */
	private boolean isLocationOk(int dimension1, int dimension2,
			boolean horizontal, Ocean ocean) {
		// initialize the primitive to return
		boolean isEmpty = true;
		// these four variables gives the range of squares to check
		int startEdge;
		int endEdge;
		int startPoint;
		int endPoint;

		// if end position of dimension1 does not exceed the range
		if (dimension1 + this.getLength() <= 10) {
			// find the start and end point (length) to scan
			startPoint = dimension1 - 1;
			endPoint = dimension1 + this.getLength();
			
			// if the ship is proposed to be place at a edge
			// modify the startPoint and endPoint
			if (startPoint == -1) {
				startPoint = 0;
			}else if (endPoint == 10) {
				endPoint = 9;
			}

			// find the width of the scan
			startEdge = dimension2 - 1;
			endEdge = dimension2 + 1;
			
			// if the ship is proposed to be placed at a edge
			// modify the startEdge and endEdge
			if (startEdge == -1) {
				startEdge = 0;
			}else if (endEdge == 10){
				endEdge = 9;
			}

			// determine if the ship could be placed
			// iterate through each square in the required range
			// to check whether any of them are o
			// if so return false
			for (int i = startPoint; i <= endPoint; i++) {
				for (int j = startEdge; j <= endEdge; j++) {
					// if the ship is horizontal
					if (horizontal) {
						// dimension1 = column
						if (ocean.isOccupied(j, i)) {
							isEmpty = false;
						}
					// if the ship is vertical
					}else {
						// dimension1 = row
						if (ocean.isOccupied(i, j)) {
							isEmpty = false;
						}
					}
				}
			}
		// return false when the length of the ship exceeds the range
		}else {
			isEmpty = false;
		}
		
		// return the result
		return isEmpty;
	}

	/*
	 * return whether the ship could be placed
	 *  at the location based on the input
	 */
	public boolean okToPlaceShipAt(int row, int column,
									boolean horizontal, Ocean ocean) {
		
		// if the input is in the range of the square
		if (row < 10 && row >= 0 && column < 10 && column >= 0) {
			if (horizontal) {
				// and if the end of the ship is in range
				if (row <= 10 - this.getLength()) {
					// call the helper method to check the location
					return this.isLocationOk(column, row, horizontal, ocean);
				}
			// similar to above, but when the ship is in another direction
			}else {
				if (column <= 10 - this.getLength()) {
					return this.isLocationOk(row, column, horizontal, ocean);
				}
			}
		}
		return false;
	}

	/*
	 * ¡°Puts¡± the ship in the ocean
	 * change the bowRow, bowColumn and horizontal of the ship
	 * place a reference variable in the ocean's corresponding array
	 */
	public void placeShipAt(int row, int column,
							boolean horizontal, Ocean ocean) {
		// only perform the deployment when the deployment is legal
		if (this.okToPlaceShipAt(row, column, horizontal, ocean)) {
			// update the ship
			this.setBowColumn(column);
			this.setBowRow(row);
			this.setHorizontal(horizontal);
			
			// update the ocean by overwriting previous ship in place
			if (this.isHorizontal()) {
				for (int i = 0; i < this.getLength(); i++) {
					// update the square
					ocean.getShipArray()[row][column + i] = this;
				}
			// if the ship is vertical
			}else {
				for (int i = 0; i < this.getLength(); i++) {
					// update the square
					ocean.getShipArray()[row + i][column] = this;
				}
			}
		}
	}

	/*
	 * shot at the target
	 * if the target is not a sunk ship,
	 * mark the ship's slot as hit and return true
	 * otherwise, return false
	 */
	public boolean shootAt(int row, int column) {
		// if the ship is not yet sunk before the hit
		if (! this.isSunk()) {
			if (this.isHorizontal()) {
				// if the ship is shoot at
				if (column < (this.getBowColumn() + this.getLength())) {
					// change corresponding element in hit array to be true
					this.hit[column - this.getBowColumn()] = true;
					// return true
					return true;
				}
			// if the ship is vertical
			// similar to above
			}else {
				if (row < (this.getBowRow() + this.getLength())) {
					this.hit[row - this.getBowRow()] = true;
					return true;
				}
			}

		}

		return false;
	}

	/*
	 * Return true if every part of the ship has been hit, false otherwise.
	 */
	public boolean isSunk() {
		// the ship.hit should be like this when sunk
		boolean[] sunk = {true, true, true, true};
		// if the expectation is meet
		if (Arrays.equals(this.getHit(), sunk)) {
			// return true if so
			return true;
			// return false o/w
		}else {
			return false;
		}
	}

	/*
	 * Returns a single-character String to use in the Ocean¡¯s print method
	 * "x" for ship has been sunk
	 * "S" for not yet sunk
	 * not for location not yet shot at
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		if (this.isSunk()) {
			return "x";
		}else {
			return "S";
		}
	}

	/*
	 * Helper method:
	 * return true of the position is already hitten, false otherwise
	 */
	public boolean isHit(int row, int column) {
		if (this.isHorizontal()) {
			// and if the input is in the range of the ship
			if (column < (this.getBowColumn() + this.getLength())) {
				// return the condition of this part of the ship
				return this.hit[column - this.getBowColumn()];
			}
		// if the ship is vertical
		}else {
			// and if the input is in the range of the ship
			if (row < (this.getBowRow() + this.getLength())) {
				// return the condition of this part of the ship
				return this.hit[row - this.getBowRow()];
			}
		}
		//return false otherwise
		return false;
	}

}

