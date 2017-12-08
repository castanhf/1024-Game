package modelPackage;

public class GridMain4 {

	public static void main(String[] args) {

		int[][] grid = {
				{ 0, 2, 0, 4, 0, 4 }, 
				{ 0, 0, 0, 0, 0, 0 }, 
				{ 0, 0, 0, 0, 0, 0 }, 
				{ 8, 0, 0, 0, 0, 4 }
				};
		Grid g = new Grid(grid);

		
		System.out.println(" original grid\n");
		g.renderBoard();

		
		System.out.println("\n\n grid copy combined up\n");
		g.transpose().combineLeft1024().transpose().renderBoard();

		
		System.out.println("\n\n grid copy combined down\n");
		g.transpose().combineRight1024().transpose().renderBoard();

		
		System.out.println("\n\n original grid\n");
		g.renderBoard();
	}
}
