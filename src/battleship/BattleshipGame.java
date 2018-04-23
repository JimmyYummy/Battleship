package battleship;

import java.util.Scanner;

class BattleshipGame {

	// instance variable
	private Ocean theOcean;

	// methods

	/*
	 * Help method:
	 * this method ask the user to input
	 * a valid row number and a valid column number respectively
	 * the an illegal input is detected, the input will be asked again
	 * after satisfied, the method will return a int array
	 * that contains the row (in position 0) and column (in position 1)
	 * the parameter is the scanner the main method currently using
	 */
	private int[] inputLocation(Scanner scanner) {
		// create the array to return
		int[] location = new int[2];
		// create the variable that save the input
		int input;

		// ask the player to input the row number
		System.out.println("Please enter a row number.");
		input =  scanner.nextInt();
		//check if the input is legal, ask again if not
		while (input < 0 || input > 9) {
			System.out.println("Please enter a valid row number.");
			input =  scanner.nextInt();
		}
		// save the legal input in the return array
		location[0] = input;

		// similar procedure to ask for the column number
		System.out.println("Please enter a column number.");
		input = scanner.nextInt();
		while (input < 0 || input > 9) {
			System.out.println("Please enter a valid column number.");
			input = scanner.nextInt();
		}
		location[1] = input;
		
		return location;
	}

	/*
	 * Helper method:
	 * this method will perform the shoot and evaluate the performance
	 * and then print the related information to the player:
	 * hit or miss, whether a ship is sunk and what type it is
	 */
	private void shootEvaluation(int row, int column) {
		// perform the shoot, and get if it is a hit
		if(this.theOcean.shootAt(row, column)) {
			// when true, print hit
			System.out.println("hit");
			// check if the ship is sunk, print the information when true
			if (this.theOcean.getShipArray()[row][column].isSunk()) {
				System.out.println("You just sank a ship-" +
					this.theOcean.getShipArray()[row][column].getShipType());
			}
		}else {
			// print miss if is not a hit
			System.out.println("miss");
		}
	}

	/*
	 * Helper method:
	 * this method is called when the game is over
	 * it will print the statistic of the of game
	 * and ask whether the player want to player again
	 * and get the input
	 * return false if the player choose to continue
	 * true otherwise
	 */
	private boolean postGameAndWhetherCont(Scanner scanner) {
		//print the statistics
		System.out.println("Games is over!");
		System.out.println("You beat the fleet with " + 
				this.theOcean.getShotsFired() + " shots");
		
		System.out.println("enter Y/y to play again");
		// refresh the scanner
		scanner.nextLine();
		// get the string input
		String again = scanner.nextLine();
		// return true if the input is y or Y, false o/w
		return again.equalsIgnoreCase("y");
	}

	/*
	 * the main method to perform the game
	 */
	public static void main(String[] args) {
		BattleshipGame game = new BattleshipGame();
		Scanner scanner = new Scanner(System.in);
		while(true) {

			// setup the game
			game.theOcean = new Ocean();
			System.out.println("Game Starts!");
			game.theOcean.placeAllShipsRandomly();
			int[] location;

			while (! game.theOcean.isGameOver()) {
				//print the ocean
				game.theOcean.print();
				//get the input
				//location[0] is the row and [1] is the column
				location = game.inputLocation(scanner);
				//shot the ship and give feedback
				game.shootEvaluation(location[0],location[1]);
			}

			//print the statistics and let the player choose whether continue
			if (! game.postGameAndWhetherCont(scanner)) {
				// end the game if not continue
				break;
			}
		}
		scanner.close();
		System.out.println("Game closed.");
	}

}
