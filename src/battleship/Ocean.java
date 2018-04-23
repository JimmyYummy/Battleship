package battleship;

import java.util.Random;

class Ocean {
	// instance variables
	private Ship[][] ships = new Ship[10][10];
	private int shotsFired;
	private int hitCount;
	private int shipsSunk;

	// methods

	/*
	 * constructor
	 * creates an ¡±empty¡± ocean
	 * initializes game variables
	 */
	public Ocean() {
		// initialize the variables
		shotsFired = 0;
		hitCount = 0;
		shipsSunk = 0;
		EmptySea emptysea;

		// create the empty ocean
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				emptysea = new EmptySea();
				emptysea.placeShipAt(i, j, false, this);
			}
		}
	}


	// getters
	/*
	 * Returns the number of shots fired
	 */
	public int getShotsFired() {
		return this.shotsFired;
	}

	/*
	 * Returns the number of hits recorded
	 *  All hits are counted,
	 *  not just the first time a given square is hit.
	 */
	public int getHitCount() {
		return this.hitCount;
	}

	/*
	 * Returns the number of ships sunk (in this game).
	 */
	public int getShipsSunk() {
		return this.shipsSunk;
	}

	/*
	 * Returns true if all ships have been sunk, otherwise false
	 */
	public boolean isGameOver() {
		if (this.shipsSunk == 10) {
			return true;
		}else {
			return false;
		}
	}

	/*
	 * Returns the 10x10 array of Ships for ship objects to use
	 */
	public Ship[][] getShipArray(){
		return this.ships;
	}

	// other utility methods
	
	/*
	 * Helper method:
	 * randomly place one ship in a legal place
	 * ship could be any type of ship
	 */
	private void placeSingleShipRandomly(Ship ship) {
		// declare the variables to be the random arguments
		int row;
		int column;
		boolean horizontal;

		//create a random object to call
		Random rnd = new Random();
		
		//get the random arguments
		row = rnd.nextInt(10);
		column = rnd.nextInt(10);
		horizontal = rnd.nextBoolean();
		
		// check if the ship could be placed, 
		// get another set of random input o/w.
		while(! ship.okToPlaceShipAt(row, column, horizontal, this)) {
			row = rnd.nextInt(10);
			column = rnd.nextInt(10);
			horizontal = rnd.nextBoolean();
		}
		
		// if the ship could be placed, then place it
		ship.placeShipAt(row, column, horizontal, this);
	}

	/*
	 * Helper method:
	 * place all ten ships randomly on the (initially empty) ocean
	 * 1 battleship, 2 cruiser, 3 destroyer, 4 submarine.
	 */
	public void placeAllShipsRandomly() {
		// declare the local variables used to place the ships

		// create the instance of the battleship
		Battleship battleship = new Battleship();
		// place it
		this.placeSingleShipRandomly(battleship);
		
		// create the instance array of the cruisers
		Cruiser[] cruisers = {new Cruiser(), new Cruiser()};
		// place them one by one
		for (int i = 0; i < 2; i ++) {
			this.placeSingleShipRandomly(cruisers[i]);
		}
		
		// similarly procedure below for the destroyers and submarines
		Destoryer[]  destoryers = {new Destoryer(), 
									new Destoryer(), 
									new Destoryer()};
		for (int i = 0; i < 3; i ++) {
			this.placeSingleShipRandomly(destoryers[i]);
		}

		Submarine[]  submarines = {new Submarine(), new Submarine(), 
									new Submarine(), new Submarine()};
		for (int i = 0; i < 4; i ++) {
			this.placeSingleShipRandomly(submarines[i]);
		}
	}

	/*
	 * returns true if the given location contains a ship, 
	 * false if it does not.
	 */
	public boolean isOccupied(int row, int column) {
		// if the row and column is the the range
		if (row < 10 && row >= 0 && column < 10 && column >= 0) {
			// and if the corresponding square is initialized
			if (this.getShipArray()[row][column] != null ) {
				// and if the "ship" in the square is not empty sea
				if (this.getShipArray()[row][column].getShipType() 
						!= "empty") {
					// return true
					return true;
				}
			}
		}
		// return false in any other condition
		return false;
	}
	
	/*
	 * Returns true if the given location contains an un-sunk ¡±real¡± ship
	 * false if it does not. 
	 * In addition, this method updates shotFired and hitCount
	 */
	public boolean shootAt(int row, int column) {
		// return false by default
		boolean result = false;
		// if the input is in the range
		if (row < 10 && row >= 0 && column < 10 && column >= 0) {
			// consider as an legal input, increase the shotFired
			this.shotsFired ++;
	
			// get the result of the shoot hit/miss
			result = ships[row][column].shootAt(row, column);
			// if it is a hit
			if(result) {
				// increase the hitCount
				this.hitCount ++;
				// and if the ship is sunk by this hit
				if(ships[row][column].isSunk()) {
					// increment the shipsSunk
					this.shipsSunk ++;
				}
			}
		}
		// return the result of the shoot, true when hit, false when miss
		return result;
	}

	/*
	 * Prints the Ocean, including the row number and the column number
	 * which both range from 0 to 9
	 */
	public void print() {
		// print the column number
		System.out.println("  0 1 2 3 4 5 6 7 8 9");
		for (int i = 0; i < 10; i++) {
			// print the row number
			System.out.print(i);
			// iterat though each square in this row
			for (int j = 0; j < 10; j++) {
				// print space between squares
				System.out.print(" ");
				// print the square
				// if it has been hit
				if (this.ships[i][j].isHit(i, j)) {
					// print the ship
					System.out.print(this.ships[i][j]);
				}else {
					// o./w. print "-"
					System.out.print("-");
				}
			}
			// change the line to the next row
			System.out.print("\n");
		}
	}

}