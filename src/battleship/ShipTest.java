package battleship;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ShipTest {

	Battleship battleship;
	Cruiser cruiser;
	Destoryer destoryer;
	Submarine submarine;
	EmptySea emptySea;
	Ocean ocean;

	@Before
	public void setUp() throws Exception {
		battleship = new Battleship();
		cruiser = new Cruiser();
		destoryer = new Destoryer();
		submarine = new Submarine();
		emptySea = new EmptySea();
		ocean = new Ocean();
	}

	@Test
	public void testGetLengthBattleship() {
		assertEquals(4, battleship.getLength());
	}

	@Test
	public void testGetLengthCruiser() {
		assertEquals(3, cruiser.getLength());
	}

	@Test
	public void testGetLengthDestoryer() {
		assertEquals(2, destoryer.getLength());
	}	

	@Test
	public void testGetLengthSubmarine() {
		assertEquals(1, submarine.getLength());
	}

	@Test
	public void testGetLengthEmptySea() {
		assertEquals(1, emptySea.getLength());
	}

	@Test
	public void testBowRowDefault() {
		assertEquals(-1, battleship.getBowRow());
		assertEquals(-1, cruiser.getBowRow());
		assertEquals(-1, destoryer.getBowRow());
		assertEquals(-1, submarine.getBowRow());
		assertEquals(-1, emptySea.getBowRow());
	}

	@Test
	public void testBowRowBattleshipInBound() {
		battleship.setBowRow(0);
		assertEquals(0, battleship.getBowRow());
	}

	@Test
	public void testBowRowBattleshipOutOfBound() {
		battleship.setBowRow(10);
		assertEquals(-1, battleship.getBowRow());
	}

	@Test
	public void testBowRowCruiserInBound() {
		cruiser.setBowRow(0);
		assertEquals(0, cruiser.getBowRow());
	}

	@Test
	public void testBowRowCruiserOutOfBound() {
		cruiser.setBowRow(10);
		assertEquals(-1, cruiser.getBowRow());
	}

	@Test
	public void testBowRowDestoryerInBound() {
		destoryer.setBowRow(0);
		assertEquals(0, destoryer.getBowRow());
	}

	@Test
	public void testBowRowDestoryerOutOfBound() {
		destoryer.setBowRow(10);
		assertEquals(-1, destoryer.getBowRow());
	}

	@Test
	public void testBowRowSubmarineInBound() {
		submarine.setBowRow(0);
		assertEquals(0, submarine.getBowRow());
	}

	@Test
	public void testBowRowSubmarineOutOfBound() {
		submarine.setBowRow(10);
		assertEquals(-1, submarine.getBowRow());
	}

	@Test
	public void testBowRowEmptySeaInBound() {
		emptySea.setBowRow(0);
		assertEquals(0, emptySea.getBowRow());
	}

	@Test
	public void testBowRowEmptySeaOutOfBound() {
		emptySea.setBowRow(10);
		assertEquals(-1, emptySea.getBowRow());
	}

	@Test
	public void testBowColumnDefault() {
		assertEquals(-1, battleship.getBowColumn());
		assertEquals(-1, cruiser.getBowColumn());
		assertEquals(-1, destoryer.getBowColumn());
		assertEquals(-1, submarine.getBowColumn());
		assertEquals(-1, emptySea.getBowColumn());
	}

	@Test
	public void testBowColumnBattleshipInBound() {
		battleship.setBowColumn(0);
		assertEquals(0, battleship.getBowColumn());
	}

	@Test
	public void testBowColumnBattleshipOutOfBound() {
		battleship.setBowColumn(10);
		assertEquals(-1, battleship.getBowColumn());
	}

	@Test
	public void testBowColumnCruiserInBound() {
		cruiser.setBowColumn(0);
		assertEquals(0, cruiser.getBowColumn());
	}

	@Test
	public void testBowColumnCruiserOutOfBound() {
		cruiser.setBowColumn(10);
		assertEquals(-1, cruiser.getBowColumn());
	}

	@Test
	public void testBowColumnDestoryerInBound() {
		destoryer.setBowColumn(0);
		assertEquals(0, destoryer.getBowColumn());
	}

	@Test
	public void testBowColumnDestoryerOutOfBound() {
		destoryer.setBowColumn(10);
		assertEquals(-1, destoryer.getBowColumn());
	}

	@Test
	public void testBowColumnSubmarineInBound() {
		submarine.setBowColumn(0);
		assertEquals(0, submarine.getBowColumn());
	}

	@Test
	public void testBowColumnSubmarineOutOfBound() {
		submarine.setBowColumn(10);
		assertEquals(-1, submarine.getBowColumn());
	}

	@Test
	public void testBowColumnEmptySeaInBound() {
		emptySea.setBowColumn(0);
		assertEquals(0, emptySea.getBowColumn());
	}

	@Test
	public void testBowColumnEmptySeaOutOfBound() {
		emptySea.setBowColumn(10);
		assertEquals(-1, emptySea.getBowColumn());
	}

	@Test
	public void testGetHitBattleship() {
		boolean[] expected = {false, false, false, false}; 
		boolean[] hit = battleship.getHit();
		for (int i = 0; i < 4; i ++) {
			assertEquals(expected[i],hit[i]);
		}
	}
	
	@Test
	public void testGetHitCruiser() {
		boolean[] expected = {false, false, false, true}; 
		boolean[] hit = cruiser.getHit();
		for (int i = 0; i < 4; i ++) {
			assertEquals(expected[i],hit[i]);
		}
	}
	
	@Test
	public void testGetHitDestoryer() {
		boolean[] expected = {false, false, true, true}; 
		boolean[] hit = destoryer.getHit();
		for (int i = 0; i < 4; i ++) {
			assertEquals(expected[i],hit[i]);
		}
	}
	
	@Test
	public void testGetHitSubmarine() {
		boolean[] expected = {false, true, true, true}; 
		boolean[] hit = submarine.getHit();
		for (int i = 0; i < 4; i ++) {
			assertEquals(expected[i],hit[i]);
		}
	}
	
	@Test
	public void testGetHitEmptySea() {
		boolean[] expected = {false, false, false, false}; 
		boolean[] hit = emptySea.getHit();
		for (int i = 0; i < 4; i ++) {
			assertEquals(expected[i],hit[i]);
		}
	}

	@Test
	public void testHorizontalDefault() {
		assertEquals(false, battleship.isHorizontal());
		assertEquals(false, cruiser.isHorizontal());
		assertEquals(false, destoryer.isHorizontal());
		assertEquals(false, emptySea.isHorizontal());
	}

	@Test
	public void testHorizontalTrueBattleShip() {
		battleship.setHorizontal(true);
		assertEquals(true, battleship.isHorizontal());

	}

	@Test
	public void testHorizontalFalseBattleShip() {
		battleship.setHorizontal(true);
		battleship.setHorizontal(false);
		assertEquals(false, battleship.isHorizontal());

	}

	@Test
	public void testHorizontalTrueCruiser() {
		cruiser.setHorizontal(true);
		assertEquals(true, cruiser.isHorizontal());

	}

	@Test
	public void testHorizontalFalseCruiser() {
		cruiser.setHorizontal(true);
		cruiser.setHorizontal(false);
		assertEquals(false, cruiser.isHorizontal());

	}

	@Test
	public void testHorizontalTrueDestoryer() {
		destoryer.setHorizontal(true);
		assertEquals(true, destoryer.isHorizontal());

	}

	@Test
	public void testHorizontalFalseDestoryer() {
		destoryer.setHorizontal(true);
		destoryer.setHorizontal(false);
		assertEquals(false, destoryer.isHorizontal());

	}

	@Test
	public void testHorizontalTrueSubmarine() {
		submarine.setHorizontal(true);
		assertEquals(true, submarine.isHorizontal());

	}

	@Test
	public void testHorizontalFalseSubmarine() {
		submarine.setHorizontal(true);
		submarine.setHorizontal(false);
		assertEquals(false, submarine.isHorizontal());

	}

	@Test
	public void testHorizontalTrueEmptySea() {
		emptySea.setHorizontal(true);
		assertEquals(true, emptySea.isHorizontal());

	}

	@Test
	public void testHorizontalFalseEmptySea() {
		emptySea.setHorizontal(true);
		emptySea.setHorizontal(false);
		assertEquals(false, emptySea.isHorizontal());

	}

	@Test
	public void testGetShipTypeBattleShip() {
		assertEquals("battleship", battleship.getShipType());
	}

	@Test
	public void testGetShipTypeCruiser() {
		assertEquals("cruiser", cruiser.getShipType());
	}

	@Test
	public void testGetShipTypeDestoryer() {
		assertEquals("destoryer", destoryer.getShipType());
	}

	@Test
	public void testGetShipTypeSubmarine() {
		assertEquals("submarine", submarine.getShipType());
	}

	@Test
	public void testGetShipTypeEmptySea() {
		assertEquals("empty", emptySea.getShipType());
	}

	@Test
	public void testOkToPlaceShipAtOutLeft() {
		assertFalse(submarine.okToPlaceShipAt(-1, 0, false, ocean));
	}

	@Test
	public void testOkToPlaceShipAtOutRight() {
		assertFalse(submarine.okToPlaceShipAt(10, 0, false, ocean));
	}

	@Test
	public void testOkToPlaceShipAtOutTop() {
		assertFalse(submarine.okToPlaceShipAt(0, -1, false, ocean));
	}

	@Test
	public void testOkToPlaceShipAtOutBottom() {
		assertFalse(submarine.okToPlaceShipAt(0, 10, false, ocean));
	}

	@Test
	public void testOkToPlaceShipAtBattleshipOutBottom() {
		assertFalse(battleship.okToPlaceShipAt(0, 7, true, ocean));
	}

	@Test
	public void testOkToPlaceShipAtBattleshipOutRight() {
		assertFalse(battleship.okToPlaceShipAt(7, 0, false, ocean));
	}

	@Test
	public void testOkToPlaceShipAtCruiserOutBottom() {
		assertFalse(cruiser.okToPlaceShipAt(0, 8, true, ocean));
	}

	@Test
	public void testOkToPlaceShipAtCruiserOutRight() {
		assertFalse(cruiser.okToPlaceShipAt(8, 0, false, ocean));
	}

	@Test
	public void testOkToPlaceShipAtDestoryerOutBottom() {
		assertFalse(destoryer.okToPlaceShipAt(0, 9, true, ocean));
	}

	@Test
	public void testOkToPlaceShipAtDestoryerOutRight() {
		assertFalse(destoryer.okToPlaceShipAt(9, 0, false, ocean));
	}

	@Test
	public void testOkToPlaceShipBattleshipAtAllowed() {
		assertTrue(battleship.okToPlaceShipAt(0, 0, true, ocean));
		assertTrue(battleship.okToPlaceShipAt(0, 0, false, ocean));
	}

	@Test
	public void testOkToPlaceShipAtCruiserAllowed() {
		assertTrue(cruiser.okToPlaceShipAt(0, 0, true, ocean));
		assertTrue(cruiser.okToPlaceShipAt(0, 0, false, ocean));
	}

	@Test
	public void testOkToPlaceShipAtDestoryerAllowed() {
		assertTrue(destoryer.okToPlaceShipAt(0, 0, true, ocean));
		assertTrue(destoryer.okToPlaceShipAt(0, 0, false, ocean));
	}

	@Test
	public void testOkToPlaceShipAtSubmarineAllowed() {
		assertTrue(submarine.okToPlaceShipAt(0, 0, true, ocean));
		assertTrue(submarine.okToPlaceShipAt(0, 0, false, ocean));
	}

	@Test
	public void testOkToPlaceShipAtNearAShip() {
		ocean.getShipArray()[1][1] = new Submarine();
		assertFalse(submarine.okToPlaceShipAt(0, 0, true, ocean));
		assertFalse(submarine.okToPlaceShipAt(0, 1, true, ocean));
		assertFalse(submarine.okToPlaceShipAt(0, 2, true, ocean));
		assertFalse(submarine.okToPlaceShipAt(1, 0, true, ocean));
		assertFalse(submarine.okToPlaceShipAt(1, 2, true, ocean));
		assertFalse(submarine.okToPlaceShipAt(2, 0, true, ocean));
		assertFalse(submarine.okToPlaceShipAt(2, 1, true, ocean));
		assertFalse(submarine.okToPlaceShipAt(2, 2, true, ocean));
	}

	@Test
	public void testPlaceShipAtBattleShipHorizontal() {
		for (int i = 0; i < battleship.length; i ++) {
			assertEquals("empty",ocean.getShipArray()[0][i].getShipType());
		}

		battleship.placeShipAt(0, 0, true, ocean);
		for (int i = 0; i < battleship.length; i ++) {
			assertEquals("battleship",
						ocean.getShipArray()[0][i].getShipType());
		}
	}

	@Test
	public void testPlaceShipAtBattleShipVertical() {
		for (int i = 0; i < battleship.length; i ++) {
			assertEquals("empty",
						ocean.getShipArray()[i][0].getShipType());
		}

		battleship.placeShipAt(0, 0, false, ocean);
		for (int i = 0; i < battleship.length; i ++) {
			assertEquals("battleship",
						ocean.getShipArray()[i][0].getShipType());
		}
	}

	@Test
	public void testPlaceShipAtCruiserHorizontal() {
		for (int i = 0; i < cruiser.length; i ++) {
			assertEquals("empty",
						ocean.getShipArray()[0][i].getShipType());
		}

		cruiser.placeShipAt(0, 0, true, ocean);
		for (int i = 0; i < cruiser.length; i ++) {
			assertEquals("cruiser",
						ocean.getShipArray()[0][i].getShipType());
		}
	}

	@Test
	public void testPlaceShipAtCruiserVertical() {
		for (int i = 0; i < cruiser.length; i ++) {
			assertEquals("empty",
						ocean.getShipArray()[i][0].getShipType());
		}

		cruiser.placeShipAt(0, 0, false, ocean);
		for (int i = 0; i < cruiser.length; i ++) {
			assertEquals("cruiser",
						ocean.getShipArray()[i][0].getShipType());
		}
	}

	@Test
	public void testPlaceShipAtDestoryerHorizontal() {
		for (int i = 0; i < destoryer.length; i ++) {
			assertEquals("empty",
						ocean.getShipArray()[0][i].getShipType());
		}

		destoryer.placeShipAt(0, 0, true, ocean);
		for (int i = 0; i < destoryer.length; i ++) {
			assertEquals("destoryer",
						ocean.getShipArray()[0][i].getShipType());
		}
	}

	@Test
	public void testPlaceShipAtDestoryerVertical() {
		for (int i = 0; i < destoryer.length; i ++) {
			assertEquals("empty",
						ocean.getShipArray()[i][0].getShipType());
		}

		destoryer.placeShipAt(0, 0, false, ocean);
		for (int i = 0; i < destoryer.length; i ++) {
			assertEquals("destoryer",
						ocean.getShipArray()[i][0].getShipType());
		}
	}

	@Test
	public void testPlaceShipAtSubmarineHorizontal() {
		for (int i = 0; i < submarine.length; i ++) {
			assertEquals("empty",
						ocean.getShipArray()[0][i].getShipType());
		}

		submarine.placeShipAt(0, 0, true, ocean);
		for (int i = 0; i < submarine.length; i ++) {
			assertEquals("submarine",
						ocean.getShipArray()[0][i].getShipType());
		}
	}

	@Test
	public void testPlaceShipAtSubmarineVertical() {
		for (int i = 0; i < submarine.length; i ++) {
			assertEquals("empty",
						ocean.getShipArray()[i][0].getShipType());
		}

		submarine.placeShipAt(0, 0, false, ocean);
		for (int i = 0; i < submarine.length; i ++) {
			assertEquals("submarine",
						ocean.getShipArray()[i][0].getShipType());
		}
	}


	@Test
	public void testShootAtBattleship() {
		battleship.placeShipAt(0, 0, true, ocean);
		for(int i = 0; i < battleship.getLength(); i ++) {
			assertFalse(battleship.getHit()[i]);
			assertTrue(battleship.shootAt(0, i));
			assertTrue(battleship.getHit()[i]);
		}
		assertFalse(battleship.shootAt(0, 0));
	}
	
	@Test
	public void testShootAtCruiser() {
		cruiser.placeShipAt(0, 0, true, ocean);
		for(int i = 0; i < cruiser.getLength(); i ++) {
			assertFalse(cruiser.getHit()[i]);
			assertTrue(cruiser.shootAt(0, i));
			assertTrue(cruiser.getHit()[i]);
		}
		assertFalse(cruiser.shootAt(0, 0));
	}
	
	@Test
	public void testShootAtDestoryer() {
		destoryer.placeShipAt(0, 0, true, ocean);
		for(int i = 0; i < destoryer.getLength(); i ++) {
			assertFalse(destoryer.getHit()[i]);
			assertTrue(destoryer.shootAt(0, i));
			assertTrue(destoryer.getHit()[i]);
		}
		assertFalse(destoryer.shootAt(0, 0));
	}
	
	@Test
	public void testShootAtSubmarine() {
		submarine.placeShipAt(0, 0, true, ocean);
		for(int i = 0; i < submarine.getLength(); i ++) {
			assertFalse(submarine.getHit()[i]);
			assertTrue(submarine.shootAt(0, i));
			assertTrue(submarine.getHit()[i]);
		}
		assertFalse(submarine.shootAt(0, 0));
	}
	
	@Test
	public void testShootAtEmptySea() {
		emptySea.placeShipAt(0, 0, true, ocean);
		assertFalse(emptySea.getHit()[0]);
		assertFalse(emptySea.shootAt(0, 0));
		assertTrue(emptySea.getHit()[0]);
	}
	
	
	@Test
	public void testIsSunkBattleship() {
		boolean[] hit = battleship.getHit();
		for (int i = 0; i < battleship.getLength(); i ++) {
			assertFalse(battleship.isSunk());
			hit[i] = true;
		}
		assertTrue(battleship.isSunk());
	}
	
	@Test
	public void testIsSunkCruiser() {
		boolean[] hit = cruiser.getHit();
		for (int i = 0; i < cruiser.getLength(); i ++) {
			assertFalse(cruiser.isSunk());
			hit[i] = true;
		}
		assertTrue(cruiser.isSunk());
	}
	
	@Test
	public void testIsSunkDestoryer() {
		boolean[] hit = destoryer.getHit();
		for (int i = 0; i < destoryer.getLength(); i ++) {
			assertFalse(destoryer.isSunk());
			hit[i] = true;
		}
		assertTrue(destoryer.isSunk());
	}
	
	@Test
	public void testIsSunkSubmarine() {
		boolean[] hit = submarine.getHit();
		for (int i = 0; i < submarine.getLength(); i ++) {
			assertFalse(submarine.isSunk());
			hit[i] = true;
		}
		assertTrue(submarine.isSunk());
	}

	@Test
	public void testIsSunkEmptySea() {
		assertFalse(emptySea.isSunk());
		
	}
	@Test
	public void testToStringBattleShipNotSunk() {
		assertEquals("S", battleship.toString());
	}

	@Test
	public void testToStringBattleShipSunk() {
		boolean[] hit = battleship.getHit();
		for (int i = 0; i < 4; i ++) {
			hit[i] = true;
		}
		assertEquals("x", battleship.toString());
	}

	@Test
	public void testToStringCruiserNotSunk() {
		assertEquals("S", cruiser.toString());
	}

	@Test
	public void testToStringCruiserSunk() {
		boolean[] hit = cruiser.getHit();
		for (int i = 0; i < 4; i ++) {
			hit[i] = true;
		}
		assertEquals("x", cruiser.toString());
	}

	@Test
	public void testToStringDestoryerNotSunk() {
		assertEquals("S", destoryer.toString());
	}

	@Test
	public void testToStringDestoryerSunk() {
		boolean[] hit = destoryer.getHit();
		for (int i = 0; i < 4; i ++) {
			hit[i] = true;
		}
		assertEquals("x", destoryer.toString());
	}

	@Test
	public void testToStringSubmarineNotSunk() {
		assertEquals("S", submarine.toString());
	}

	@Test
	public void testToStringSubmarineSunk() {
		boolean[] hit = submarine.getHit();
		for (int i = 0; i < 4; i ++) {
			hit[i] = true;
		}
		assertEquals("x", submarine.toString());
	}

	@Test
	public void testToStringEmptySea() {
		assertEquals(".", emptySea.toString());
	}

	@Test
	public void testIsHitBattleShipVertical() {
		boolean[] hit = battleship.getHit();
		battleship.placeShipAt(0, 0, false, ocean);

		for (int i = 0; i < battleship.getLength(); i ++) {
			assertFalse(battleship.isHit(i, 0));
			hit[i] = true;
			assertTrue(battleship.isHit(i, 0));
		}
	}

	@Test
	public void testIsHitBattleShipHorizontal() {
		boolean[] hit = battleship.getHit();
		battleship.placeShipAt(0, 0, true, ocean);

		for (int i = 0; i < battleship.getLength(); i ++) {
			assertFalse(battleship.isHit(0, i));
			hit[i] = true;
			assertTrue(battleship.isHit(0, i));
		}
	}

	@Test
	public void testIsHitCruiserVertical() {
		boolean[] hit = cruiser.getHit();
		cruiser.placeShipAt(0, 0, false, ocean);

		for (int i = 0; i < cruiser.getLength(); i ++) {
			assertFalse(cruiser.isHit(i, 0));
			hit[i] = true;
			assertTrue(cruiser.isHit(i, 0));
		}
	}

	@Test
	public void testIsHitCruiserHorizontal() {
		boolean[] hit = cruiser.getHit();
		cruiser.placeShipAt(0, 0, true, ocean);

		for (int i = 0; i < cruiser.getLength(); i ++) {
			assertFalse(cruiser.isHit(0, i));
			hit[i] = true;
			assertTrue(cruiser.isHit(0, i));
		}
	}

	@Test
	public void testIsHitDestoryerVertical() {
		boolean[] hit = destoryer.getHit();
		destoryer.placeShipAt(0, 0, false, ocean);

		for (int i = 0; i < destoryer.getLength(); i ++) {
			assertFalse(destoryer.isHit(i, 0));
			hit[i] = true;
			assertTrue(destoryer.isHit(i, 0));
		}
	}

	@Test
	public void testIsHitDestoryerHorizontal() {
		boolean[] hit = destoryer.getHit();
		destoryer.placeShipAt(0, 0, true, ocean);

		for (int i = 0; i < destoryer.getLength(); i ++) {
			assertFalse(destoryer.isHit(0, i));
			hit[i] = true;
			assertTrue(destoryer.isHit(0, i));
		}
	}

	@Test
	public void testIsHitSubmarineVertical() {
		boolean[] hit = submarine.getHit();
		submarine.placeShipAt(0, 0, false, ocean);

		for (int i = 0; i < submarine.getLength(); i ++) {
			assertFalse(submarine.isHit(i, 0));
			hit[i] = true;
			assertTrue(submarine.isHit(i, 0));
		}
	}

	@Test
	public void testIsHitSubmarineHorizontal() {
		boolean[] hit = submarine.getHit();
		submarine.placeShipAt(0, 0, true, ocean);

		for (int i = 0; i < submarine.getLength(); i ++) {
			assertFalse(submarine.isHit(0, i));
			hit[i] = true;
			assertTrue(submarine.isHit(0, i));
		}
	}

	@Test
	public void testIsHitEmptySeaVertical() {
		boolean[] hit = emptySea.getHit();
		emptySea.placeShipAt(0, 0, false, ocean);

		for (int i = 0; i < emptySea.getLength(); i ++) {
			assertFalse(emptySea.isHit(i, 0));
			hit[i] = true;
			assertTrue(emptySea.isHit(i, 0));
		}
	}

	@Test
	public void testIsHitEmptySeaHorizontal() {
		boolean[] hit = emptySea.getHit();
		emptySea.placeShipAt(0, 0, true, ocean);

		for (int i = 0; i < emptySea.getLength(); i ++) {
			assertFalse(emptySea.isHit(0, i));
			hit[i] = true;
			assertTrue(emptySea.isHit(0, i));
		}
	}
	
	@Test
	public void testIsHitOutOfBound() {
		emptySea.placeShipAt(0, 0, true, ocean);

		assertFalse(emptySea.isHit(9, 9));
	}

}
