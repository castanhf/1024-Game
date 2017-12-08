// JUnit test Case for Grid class

package modelPackage;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestGrid {

	int[][] grid = {
			{0,2,0,2},
			{0,2,0,4},
			{4,0,4,2},
			{0,0,8,8}	
	};

	
	@Test
	public void testTranpose() {
		
		int[][] gridTranspose = {
				{0,0,4,0},
				{2,2,0,0},
				{0,0,4,8},
				{2,4,2,8}	
		};
		Grid g1 = new Grid(grid);
		Grid g2 = g1.transpose();
		Grid g3 = new Grid( gridTranspose );
		assertEquals( g2, g3);
	}
	
	
	@Test
	public void testCombineLeft1024() {
		
		int[][] gridLeft = {
				{4, 0,0,0},
				{2, 4,0,0},
				{8, 2,0,0},
				{16,0,0,0}	
		};
		Grid g1 = new Grid(grid);
		Grid g2 = g1.combineLeft1024();
		Grid g3 = new Grid( gridLeft );
		assertEquals( g2, g3);
	}
	
	@Test
	public void testCombineRight1024() {
		
		int[][] gridRight = {
				{0,0,0, 4},
				{0,0,2, 4},
				{0,0,8, 2},
				{0,0,0,16}	
		};
		Grid g1 = new Grid(grid);
		Grid g2 = g1.combineRight1024();
		Grid g3 = new Grid( gridRight );
		assertEquals( g2, g3);
	}	
	
	@Test
	public void testCombineUp1024() {
		
		int[][] gridUp = {
				{4,4,4,2},
				{0,0,8,4},
				{0,0,0,2},
				{0,0,0,8}	
		};
		Grid g1 = new Grid(grid);
		Grid g2 = g1.combineUp1024();
		Grid g3 = new Grid( gridUp );
		assertEquals( g2, g3);
	}
	
	@Test
	public void testCombineDown1024() {
		
		int[][] gridDown = {
				{0,0,0,2},
				{0,0,0,4},
				{0,0,4,2},
				{4,4,8,8}	
		};
		Grid g1 = new Grid(grid);
		Grid g2 = g1.combineDown1024();
		Grid g3 = new Grid( gridDown );
		assertEquals( g2, g3);
	}	
		

}
