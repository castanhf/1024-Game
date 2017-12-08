package modelPackage;

import static org.junit.Assert.*;

// import java.util.Random;

import org.junit.BeforeClass;
import org.junit.Test;

import modelPackage.GameStatus;
import modelPackage.NumberGame2;
import modelPackage.NumberSlider;
import modelPackage.SlideDirection;

public class TestNumberGame {
	
	int[][] grid = {
			{0,2,0,2},
			{0,2,0,4},
			{4,0,4,2},
			{0,0,8,8}	
	};

    private final static int GAME_GOAL = 1024;
    private static NumberSlider gameLogic;
//  private static Random gen = new Random();

    @BeforeClass
    public static void globalSetup()
    {
        System.out.println ("Setting up Unit Testing");

        gameLogic = new NumberGame2(4,4,GAME_GOAL);
    }
    
    
	
    @Test(timeout = 1000)
    public void testWinningValue()
    {
        final int N = 10;
        gameLogic.resizeBoard(N, N, GAME_GOAL);
        int[][] mat = new int[N][N];
        for (int k = 0; k < mat.length; k++) {
            for (int m = 0; m < mat[k].length; m++)
                mat[k][m] = GAME_GOAL / 2;
        }
        gameLogic.setValues(mat);
        gameLogic.slide(SlideDirection.DOWN);
        assertEquals(GameStatus.USER_WON, gameLogic.getStatus());
    }

    
	@Test
	public void testWinningValue2() {
		
		int[][] matrix = {
				{32,32,32,32},
				{32,32,32,32},
				{32,32,32,32},
				{32,32,32,32}	
		};
		
        gameLogic.resizeBoard(4, 4, 64);
        gameLogic.setValues( matrix);
        gameLogic.slide(SlideDirection.DOWN);
        assertEquals( GameStatus.USER_WON,gameLogic.getStatus());
	}

	@Test
	public void testSlideLeft() {
				
		int[][] grid = {
					  {0,2,0,2},
					  {0,2,0,4},
					  {4,0,4,2},
					  {0,0,8,8}	
		};		
		int[][] grid2 = {
					   { 4,0,0,0},
					   { 2,4,0,0},
					   { 8,2,0,0},
					   {16,0,0,0}	
		};				
        gameLogic.resizeBoard(4, 4, 64);
        gameLogic.setValues( grid);
        gameLogic.slide(SlideDirection.LEFT);
        Grid g1 = new Grid( grid2 );
        Grid g2 = new Grid( gameLogic.getValues( ) );
        
        assertEquals( g1, g2 );
	}
        
    @Test
    public void testSlideRight() {
    				
    		int[][] grid = {
    				{0,2,0,2},
    				{0,2,0,4},
    				{4,0,4,2},
    				{0,0,8,8}	
    		};		
    		int[][] grid2 = {
    				{ 0,0,0, 4},
    				{ 0,0,2, 4},
    				{ 0,0,8, 2},
    				{ 0,0,0,16}	
    		};				
            gameLogic.resizeBoard(4, 4, 64);
            gameLogic.setValues( grid);
            gameLogic.slide(SlideDirection.RIGHT);
            Grid g1 = new Grid( grid2 );
            Grid g2 = new Grid( gameLogic.getValues( ) );
            
            assertEquals( g1, g2 );
    	}
    	
    	
    	@Test
    	public void testSlideUp() {
    				
    		int[][] matrix = {
    				{0,2,0,2},
    				{0,2,0,4},
    				{4,0,4,2},
    				{0,0,8,8}	
    		};		
    		int[][] matrix2 = {
    				{4,4,4,2},
    				{0,0,8,4},
    				{0,0,0,2},
    				{0,0,0,8}	
    		};				
            gameLogic.resizeBoard(4, 4, 64);
            gameLogic.setValues( matrix);
            gameLogic.slide(SlideDirection.UP);
            Grid g1 = new Grid( matrix2 );
            Grid g2 = new Grid( gameLogic.getValues( ) );
            
            assertEquals( g1, g2 );
    	}
    	
    	@Test
    	public void testSlideDown() {
    				
    		int[][] matrix = {
    				{0,2,0,2},
    				{0,2,0,4},
    				{4,0,4,2},
    				{0,0,8,8}	
    		};		
    		int[][] matrix2 = {
    				{0,0,0,2},
    				{0,0,0,4},
    				{0,0,4,2},
    				{4,4,8,8}	
    		};				
            gameLogic.resizeBoard(4, 4, 64);
            gameLogic.setValues( matrix);
            gameLogic.slide(SlideDirection.DOWN);
            Grid g1 = new Grid( matrix2 );
            Grid g2 = new Grid( gameLogic.getValues( ) );
            
            assertEquals( g1, g2 );
    	}
	}

