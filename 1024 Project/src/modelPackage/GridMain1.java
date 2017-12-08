package modelPackage;

public class GridMain1 {

	public static void main(String[] args) {

		int[][] grid = {
				{ 1, 2, 3, 4, 5, 6 }, 
				{ 7, 8, 9, 10, 11, 12 } };
		Grid g = new Grid(grid);

		System.out.println("grid\n");
		g.renderBoard();

		System.out.println("\n\n grid tranposed\n");
		g.transpose().renderBoard();
	}
}
