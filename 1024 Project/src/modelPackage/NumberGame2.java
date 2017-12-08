package modelPackage;

import java.util.EmptyStackException;
import java.util.Random;
import java.util.Stack;
import modelPackage.NumberSlider;

public class NumberGame2 implements NumberSlider {
	private int            goalValue;
    
    public  Cell[][]       rows;     // rows contains the model for the 1024 game board.
    private Cell[]         allCells; // allCells is a one-dimensional array of all Cells on the board

    private GameStatus     gameStatus;
    private Stack<Grid>    grids;  //Camera snapshots of the integer configuration on the board
    private boolean        gridChanged;
    
    private static Random random = new Random();
    
    

    
    /** ------------------------------------------------------
     * For starters, the following code uses a 4 by 4 board.
     * 
     * @param numRows the number of rows of the board
     * @param numColumns the number of columns of the board
     * @param goal the value that the user has to reach in order
     * to win the game. Normally, the goal value is 1024
     * ------------------------------------------------------
     */
    public NumberGame2(int numRows, int numColumns, int goal)
    {
    	this.resizeBoard( numRows, numColumns, goal);
    }
    
    /**
     * @return the Cell stored at the specified location
     * 
     * @param r the row location on the board
     * @param c the column location the board
     */
    public Cell getCell(int r, int c) {
    	
    	Cell theCell = new Cell(rows[r][c].value);
    	
    	return theCell;
    }
    
    /** ------------------------------------------------------
     * 1) set the goal value
     * 2) creates the allCells and rows arrays.
     * 3) populate the allCells and rows arrays with cells
     * 4) invoke reset
     * 
     * @param numRows the number of rows of the board
     * @param numColumns the number of columns of the board
     * @param goal the value that the user has to reach in order
     * ------------------------------------------------------
     */    
    @Override
	public void resizeBoard(int numRows, int numColumns, int goal) {

		this.goalValue = goal;

		this.allCells = new Cell[numRows * numColumns];
		this.rows     = new Cell[numRows][numColumns];

		/*
		 * --------------------------------------------------------------
		 * Populate rows, columns, and allCells to share the same Cells
		 * --------------------------------------------------------------
		 */
		
		Cell cell;
		int n = 0;
		for (int j = 0; j < numRows; j++)
		{
			for (int k = 0; k < numColumns; k++)
			{
				cell = new Cell();
				this.rows[j][k]    = cell;
				this.allCells[n]   = cell;
				n++;
			}
		}

		this.reset();
	}
    
    
    /** -------------------------------------------------------
     * 1) sets the game status to game IN_PROGRESS
     * 2) zeros out all cells of the game board
     * 3) places two random values
     * 4) creates the grids field to be a stack of Grid values
     * 5) pushes the current grid values onto the grids stack.
     * --------------------------------------------------------
     */
    @Override
    public void reset() {

    	gameStatus = GameStatus.IN_PROGRESS;
    	
    	Cell cell;
		int n = 0;
		for (int j = 0; j < rows.length; j++)
		{
			for (int k = 0; k < rows[0].length; k++)
			{
				cell = new Cell();
				this.rows[j][k]    = cell;
				this.allCells[n]   = cell;
				n++;
			}
		}
		
		placeRandomValue();
		placeRandomValue();
        
    	this.grids = new Stack<Grid>();
		this.grids.push(new Grid( this.getValues()).copy() );
	}
 
  
    /** ---------------------------------------------
     * @return the number of cells that are filled.
     * ---------------------------------------------
     */
    private int cellsFilled()
    {
    	int filled = 0;
    	
    	for (int j = 0; j <rows.length; j++)
		{
			for (int k = 0; k < rows[0].length; k++ )
			{
				if (this.rows[j][k].value != 0) {
					filled++;
				
				}
			}
		}
    	
		return filled;	
    }

    /** ------------------------------------------------
     * Restores the Cell values of the board with the
     * top grid on the grids stack.
     * ------------------------------------------------
     */
   @Override
    public void undo() {
	   
	   try {
		   if (this.grids.size() > 0)
		   {
   
			   // to do
//		   		this.grids.pop();
		   		this.setValues(this.grids.peek().getGrid());
		   }
	   }
	   catch (EmptyStackException e) {
		   throw new IllegalStateException();
	   }
	   
   }
   
    /** ------------------------------------------------
     * Mutator Method (Setter)
     * 
     * Sets the values of the cells in the 2-d array.
     * 
     * @param input, which is a final int two dimensional array
     * ------------------------------------------------
     */
    @Override
    public void setValues (final int[][] input)
    {
        for (int j = 0; j < this.rows.length; j++)
        {
            for (int k = 0; k < this.rows[0].length; k++)
            {
                this.rows[j][k].value = input[j][k];
            }
        }
    }


    /** ------------------------------------------------
     * Accessor Method (Getter)
     * 
     * @return a grid of the values stored by the 2-d
     * array of cells.
     * ------------------------------------------------
     */
    public int[][] getValues()
    {
    	int[][] grid = new int[this.rows.length][this.rows[0].length];
    	
    	for (int j = 0; j < this.rows.length; j++)
        {
            for (int k = 0; k < this.rows[0].length; k++)
            {
            	grid[j][k] = rows[j][k].value;
            }
            System.out.println();
        }    	    	
        return grid;
    }
    
    /** ------------------------------
     * @return a random power of 2.
     * ------------------------------
     */
    private int randomTileValue() /* generate random value  2, 4, 8, 16 */
    {   
    	int randNumber = 1;
    	int value = random.nextInt(4) + 1;
    	
    	for (int j = 1; j <= value; j++) {
    		randNumber = randNumber * 2;
    	}
    	
    	return randNumber;
    }   

    /** --------------------------------------------------------------
     * Starts with a random cell index. Loops forward to find a cell 
     * is not yet filled. 
     * --------------------------------------------------------------
     */
	public void placeRandomValue() {
		if (this.cellsFilled() < allCells.length) {
			
			int numRand = randomTileValue();
			int randLocation = random.nextInt(allCells.length);
				
			if (allCells[randLocation].value == 0) {
					allCells[randLocation].value = numRand;
		    }
			else {
				while (allCells[randLocation].value != 0) {	
					randLocation = random.nextInt(allCells.length);
				}
					
				allCells[randLocation].value = numRand;
			}
			

			
		}
		else
		{
			throw new RuntimeException("Cannot place a new cell; board is full.");
		}
	}	
	
	/**
     * ------------------------------------------------------------------
     * The following slide method uses the Grid class to do the sliding.
     * 
     * @param direction of the class SlideDirection, which can be UP, RIGHT,
     * DOWN, and LEFT
     * @return true if the move changes the board
     * ------------------------------------------------------------------
     */
    @Override
	public boolean slide(SlideDirection direction) {
    	
    	Grid grid = new Grid(this.getValues());
    	
    	this.grids.push(new Grid(this.getValues()).copy());

		switch (direction) {
		case UP:
			this.setValues( grid.combineUp1024().getGrid() );
			break;
		case DOWN:
			this.setValues( grid.combineDown1024().getGrid() );
			break;
		case LEFT:
			this.setValues( grid.combineLeft1024().getGrid() );
			break;
		case RIGHT:
			this.setValues( grid.combineRight1024().getGrid() );
			break;
		default:
		}
		
		Grid newGrid = new Grid(this.getValues());	
		this.gridChanged = !newGrid.equals(grid);

//		if (this.gridChanged) {
//			this.grids.push(new Grid(this.getValues()).copy());
//		}

		return this.gridChanged;
	} 

    /**
     * --------------------------------------------------------------
     * A move is possible if a space is still available on the board
     * or if the board has changed on the last turn.
     * 
     * @return true if there are no more moves left.
     * --------------------------------------------------------------
     */ 
    private boolean moveIsPossible() {
    	Grid grid = new Grid(this.getValues());

    	return grid.noMovesLeft();
    }
    
    /**
     * ------------------------------------------------------------------
     * The player wins the game if one of the cells holds the goalValue.
     * 
     * @return true if the player wins the game.
     * ------------------------------------------------------------------
     */ 
	public boolean hasWon() {
		for (Cell x : this.allCells)
		{
			if (x.value == this.goalValue)
			{
				return true;
		
			}
		}
		return false;
	}

	/**
     * Return the current state of the game
     * @return one of the possible values of GameStatus enum
     */
    @Override
    public GameStatus getStatus() {

    	if ( this.hasWon())
    	{
    		return GameStatus.USER_WON;
    	}
    	else if (!this.moveIsPossible())
        {
            return this.gameStatus;
        }
        else
        {
            return GameStatus.USER_LOST;
        }
    }


    /**
     * ----------------------------------------------------------
     * Invokes the Grid renderBoard method to print the current
     * state of the game board.
     * ----------------------------------------------------------
     */
    public void renderBoard() {

        Grid grid = new Grid(this.getValues());
        
        grid.renderBoard();
    }
    
    /**
     * The main method will test some of the methods of this class.
     * @param args
     */
    public static void main( String[] args)
    {
		int[][] matrix = {
				{32,32,32,32},
				{32,32,32,32},
				{32,32,32,32},
				{32,32,32,32}	
		};
		    	
	NumberGame2 gameLogic = new NumberGame2( 4,4,64);
        gameLogic.resizeBoard(4, 4, 64);
        gameLogic.setValues( matrix);
	gameLogic.grids.push(new Grid(matrix) );
       
        gameLogic.renderBoard();
        gameLogic.slide(SlideDirection.DOWN);
        gameLogic.renderBoard();
    }
}

