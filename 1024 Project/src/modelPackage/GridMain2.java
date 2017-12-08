package modelPackage;

public class GridMain2 {

	public static void main(String[] args) {

		int[][] grid = { 
				{ 0, 2, 0, 4, 0, 4 },
				{ 0, 0, 0, 0, 0, 0 }, 
				{ 0, 0, 0, 0, 0, 0 }, 
				{ 8, 0, 0, 0, 0, 4 },
				};
		Grid g = new Grid(grid);

		
		System.out.println(" grid\n");
		g.renderBoard();

		
		System.out.println("\n\ngrid tranposed\n");
		g.transpose().renderBoard();
	}
}
