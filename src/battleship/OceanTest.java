package battleship;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class OceanTest {
	Ocean ocean;
	Submarine submarine;
	EmptySea emptySea;
	Battleship battleship;

	@Before
	public void setUp() throws Exception {
		ocean = new Ocean();
		submarine = new Submarine();
		emptySea = new EmptySea();
		battleship = new Battleship();
	}

	@Test
	public void testGetShotsFired() {
		assertEquals(0, ocean.getShotsFired());
	}

	@Test
	public void testGetHitCount() {
		assertEquals(0, ocean.getHitCount());
	}
	
	@Test
	public void testGetHitCountOnEmptySea() {
		assertEquals(0, ocean.getHitCount());
		ocean.shootAt(0, 0);
		assertEquals(0, ocean.getHitCount());
	}

	@Test
	public void testGetShipsSunk() {
		assertEquals(0, ocean.getShipsSunk());
	}

	@Test
	public void testIsGameOverFalse() {
		assertFalse(ocean.isGameOver());
		for (int i = 0; i < 10; i ++) {
			for (int j = 0; j < 10; j ++) {
				ocean.shootAt(i,j);
				assertFalse(ocean.isGameOver());
			}
		}
		
		assertEquals(100, ocean.getShotsFired());
		assertEquals(0, ocean.getHitCount());
		assertEquals(0, ocean.getShipsSunk());
	}

	@Test
	public void testIsGameOverTrue() {
		Submarine subm;
		for (int i = 0; i < 5; i ++) {
			assertFalse(ocean.isGameOver());
			subm = new Submarine();
			subm.placeShipAt(0, 2 * i, true, ocean);
			ocean.shootAt(0, 2 * i);
			
			assertEquals(2 * i + 1, ocean.getShotsFired());
			assertEquals(2 * i + 1, ocean.getHitCount());
			assertEquals(2 * i + 1, ocean.getShipsSunk());
			
			subm = new Submarine();
			subm.placeShipAt(9, 2 * i, true, ocean);
			ocean.shootAt(9, 2 * i);
			assertEquals(2 * i + 2, ocean.getShotsFired());
			assertEquals(2 * i + 2, ocean.getHitCount());
			assertEquals(2 * i + 2, ocean.getShipsSunk());

		}

		assertTrue(ocean.isGameOver());
	}


	@Test
	public void testGetShipArrayBasic() {
		assertEquals(10, ocean.getShipArray().length);
		assertEquals(10, ocean.getShipArray()[0].length);
		for (int i = 0; i < 10; i ++) {
			for (int j = 0; j < 10; j ++)
				assertEquals("empty", 
							ocean.getShipArray()[i][j].getShipType());
		}
	}

	@Test
	public void testGetShipArrayUpdated() {
		submarine.placeShipAt(0, 0, true, ocean);
		assertEquals("submarine", ocean.getShipArray()[0][0].getShipType());
	}

	@Test
	public void testGetShipArrayOutOfBound() {
		for (int i = 0; i < 10; i ++) {
			for (int j = 0; j < 10; j ++);
		}

		submarine.placeShipAt(-1, -1, true, ocean);

		for (int i = 0; i < 10; i ++) {
			for (int j = 0; j < 10; j ++)
				assertEquals("empty", 
							ocean.getShipArray()[i][j].getShipType());
		}
	}

	@Test
	public void testGetShipArrayLengthOutOfBound() {
		battleship.placeShipAt(7, 0, false, ocean);

		for (int i = 0; i < 10; i ++) {
			for (int j = 0; j < 10; j ++)
				assertEquals("empty", 
							ocean.getShipArray()[i][j].getShipType());
		}
	}

	@Test
	public void testIsOccupiedEmptySea() {
		assertFalse(ocean.isOccupied(0, 0));
		emptySea.placeShipAt(0, 0, true, ocean);
		assertFalse(ocean.isOccupied(0, 0));
	}

	@Test
	public void testIsOccupiedSubmarine() {
		assertFalse(ocean.isOccupied(0, 0));
		submarine.placeShipAt(0, 0, true, ocean);
		assertTrue(ocean.isOccupied(0, 0));
	}

	@Test
	public void testIsOccupiedBattleship() {
		assertFalse(ocean.isOccupied(0, 0));
		battleship.placeShipAt(0, 0, true, ocean);
		assertTrue(ocean.isOccupied(0, 3));
	}

	@Test
	public void testShootAtEmptySea() {
		assertEquals(0, ocean.getShotsFired());
		assertEquals(0, ocean.getHitCount());
		assertEquals(0, ocean.getShipsSunk());

		assertFalse(ocean.shootAt(0, 0));

		assertEquals(1, ocean.getShotsFired());
		assertEquals(0, ocean.getHitCount());
		assertEquals(0, ocean.getShipsSunk());

	}

	@Test
	public void testShootAtOutOfBound() {
		assertEquals(0, ocean.getShotsFired());
		assertEquals(0, ocean.getHitCount());
		assertEquals(0, ocean.getShipsSunk());

		assertFalse(ocean.shootAt(10, 10));

		assertEquals(0, ocean.getShotsFired());
		assertEquals(0, ocean.getHitCount());
		assertEquals(0, ocean.getShipsSunk());
	}

	@Test
	public void testShootAtSubmarine() {
		submarine.placeShipAt(0, 0, true, ocean);

		assertEquals(0, ocean.getShotsFired());
		assertEquals(0, ocean.getHitCount());
		assertEquals(0, ocean.getShipsSunk());

		assertTrue(ocean.shootAt(0, 0));

		assertEquals(1, ocean.getShotsFired());
		assertEquals(1, ocean.getHitCount());
		assertEquals(1, ocean.getShipsSunk());
	}

	@Test
	public void testShootAtBattleship() {
		battleship.placeShipAt(0, 0, true, ocean);
		for (int i = 0; i < battleship.getLength(); i ++) {

			assertEquals(i, ocean.getShotsFired());
			assertEquals(i, ocean.getHitCount());
			assertEquals(0, ocean.getShipsSunk());

			assertTrue(ocean.shootAt(0, i));
		}

		assertEquals(4, ocean.getShotsFired());
		assertEquals(4, ocean.getHitCount());
		assertEquals(1, ocean.getShipsSunk());


	}
	
	@Test
	public void testPlaceAllShipsRandomly() {
		int battleship = 0;
		int cruiser = 0;
		int destoryer = 0;
		int submarine = 0;
		
		ocean.placeAllShipsRandomly();
		
		for (int i = 0; i < 10; i ++) {
			for (int j = 0; j < 10; j ++) {
				if (ocean.shootAt(i, j)) {
					if (ocean.getShipArray()[i][j].isSunk()) {
						if(ocean.getShipArray()[i][j].getShipType()
								== "battleship") {
							battleship ++;
						}else if(ocean.getShipArray()[i][j].getShipType()
								== "cruiser") {
							cruiser ++;
						}else if(ocean.getShipArray()[i][j].getShipType()
								== "destoryer") {
							destoryer ++;
						}else if(ocean.getShipArray()[i][j].getShipType()
								== "submarine") {
							submarine ++;
						}
					}
				}
			}
		}
		
		assertEquals(1, battleship);
		assertEquals(2, cruiser);
		assertEquals(3, destoryer);
		assertEquals(4, submarine);
		assertEquals(10, ocean.getShipsSunk());
		assertEquals(20, ocean.getHitCount());
	}
}