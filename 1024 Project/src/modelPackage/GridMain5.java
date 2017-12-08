package modelPackage;

public class GridMain5 {

	public static void main(String[] args) {
		int[][] m = {	{4,2,4,2},
				        {2,8,2,8}	};
		
		Grid gridMatrix = new Grid(m);
		System.out.println(gridMatrix.noMovesLeft());

	}

}
