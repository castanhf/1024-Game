package modelPackage;

public class Grid {

	private int[][] grid;

	
	/**
	 * Default Constructor
	 * @param grid, which is a two dimensional array of type int
	 */
	public Grid(int[][] grid) {

		this.grid = grid;
	}
	
	/**
	 * Accessor Method
	 * 
	 * @return grid, which is a two dimensional array of type int
	 */
	public int[][] getGrid()
	{
		return this.grid;
	}
	
	/**
	 * @return a copy of the grid
	 * 
	 */
	private int[][]  copyGrid()
	{
		int[][] copied = new int[grid.length][grid[0].length];
		
		int j, k;
		for (j = 0; j <grid.length; j++)
		{
			for (k = 0; k < grid[0].length; k++ )
			{
				copied[j][k] = grid[j][k];
			}
		}
		return copied;
	}
	
	/**
	 * @return a new grid, which is the copy of itself
	 * 
	 */
	public Grid copy()
	{
		return new Grid( this.copyGrid() );
	}
	
	/**
	 * @return a transposed grid.
	 * In other words, the rows and columns from the original grid
	 * are now, respectively, the columns and rows of the transposed
	 * grid
	 * 
	 */
	public Grid transpose()
	{
		int[][] transposed = new int[grid[0].length][grid.length];
		
// Tested: Checked
		for (int j = 0; j <grid.length; j++)
		{
			for (int k = 0; k < grid[0].length; k++ )
			{
				transposed[k][j] = this.grid[j][k];
			}
		}


		return new Grid( transposed );
	}

	/**
	 * 
	 * @param g, which is a grid
	 * @return true if the parameter g grid's elements are equal
	 * to the elements of this grid
	 */
	public boolean equals(Grid g) {
		
		if (this.grid.length != g.grid.length || this.grid[0].length != g.grid[0].length) {	
			return false;
		}
	
	//Test it
		for (int j = 0; j <grid.length; j++)
		{
			for (int k = 0; k < grid[0].length; k++ )
			{
				if (this.grid[j][k] != g.grid[j][k]) {
					return false;
				}
			}
		}
	
	
		return true;
	}
	
	/**
	 * @return true if the Object g is equal to this grid
	 */
	public boolean equals(Object g) {
		if (g instanceof Grid) {
			return this.equals((Grid) g);
		} else {
			return false;
		}
	}	
	
	
	/**
	 * @return a grid with the elements shifted to the left
	 * 
	 */
	public Grid combineLeft1024( ) {
		
		Grid g = this.copy();
		
		Sequence sequence;
		
		for (int j = 0; j < g.grid.length; j++) {
			sequence = new Sequence(g.grid[j]);
			g.grid[ j ] = sequence.combineLeft1024();
		}
		return g;
	}	

	
	/**
	 * @return a grid with the elements shifted to the right
	 * 
	 */
	public Grid combineRight1024( ) {
		Grid g = this.copy();
	
		Sequence sequence;
		
		for (int j = 0; j < g.grid.length; j++) {
			sequence = new Sequence(g.grid[j]);
			g.grid[ j ] = sequence.combineRight1024();
		}
		return g;
	}
	

	/**
	 * The method will transpose the original grid and shift its elements
	 * to the left. After that it is transposed once again.
	 * @return a grid with the elements shifted up
	 */
	public Grid combineUp1024( ) {
		
		return this.transpose().combineLeft1024().transpose();
	}	
	
	
	/**
	 * The method will transpose the original grid and shift its elements
	 * to the right. After that it is transposed once again.
	 * @return a grid with the elements shifted down
	 */
	public Grid combineDown1024( ) {
		
		return this.transpose().combineRight1024().transpose();
	}	
	
	
	/**
	 * This method will print the the values of this grid
	 */
    public void renderBoard() {
    	
        final int     CELL_WIDTH = 3;
        
        /* Set the string to %4d */
        final String NUM_FORMAT = String.format("%%%dd", CELL_WIDTH + 1);

        /* Set the string to %4s, but without using String.format() */
        final String BLANK_FORMAT = "%" + (CELL_WIDTH + 1) + "s";	
    	

        /* Print the 2D array using dots and numbers */
        for (int k = 0; k < this.grid.length; k++)
        {
            for (int m = 0; m < this.grid[0].length; m++)
            {
                if (this.grid[k][m] == 0)
                {
//                	System.out.printf (NUM_FORMAT, this.grid[k][m]);
                	System.out.printf (BLANK_FORMAT, ".");
                }
                else
                {
                	System.out.printf (NUM_FORMAT, this.grid[k][m]);
                }
            }
            System.out.println();
        }
    }
    
    
    /**-------------------------------------------------------
	 * noMovesLeft() checks if there are any more options to play.
	 * This happens when:
	 * 		1. All elements of the grid/matrix are greater than zero;
	 * 		2. No two adjacent elements are equal. 
	 * ------------------------------------------------------
	 */
    public boolean noMovesLeft() {
    	for (int j = 0; j < this.grid.length; j++) {
    		Sequence s = new Sequence(this.grid[j]);
    		
    		if (s.noMovesLeft() == false) {
    			return false;
    		}
    	}
    	
    	Grid transpoGrid = this.copy().transpose();
    	
    	for (int i = 0; i < transpoGrid.grid.length; i++) {
    		Sequence t = new Sequence(transpoGrid.grid[i]);
    		
    		if (t.noMovesLeft() == false) {
    			return false;
    		}
    	}
    	
    	return true;
    }    
    
    
    /**
     * The main method will test some of the methods of this class.
     * @param args
     */
    public static void main(String[] args)
    {
//    	int[][] grid = { 
//    			{1,2,3,4,5,6},
//       			{7,8,9,10,11,12}
    	
    	int[][] grid = { 
    			{0,4,8,4,2,8},
       			{8,2,4,8,4,2}
    	};
    	Grid g = new Grid(grid);
    	
    	
    	System.out.println("\ngrid\n");
    	g.renderBoard();
    	
    	System.out.println("\ngrid tranposed\n");
    	g.transpose().renderBoard();
    	
    	System.out.println();
    	
//    	System.out.println(g.transpose().grid.length);
    	
    	System.out.println();
    	
    	System.out.println(g.noMovesLeft());
    	
    	


    	
    }
}
