package modelPackage;

public class SequenceMain3 {

	public static void main(String[] args) {
		int[] row_1 = {2,0,4,4};
		int[] row_2 = {2,8,4,2};
		int[] row_3 = {2,2};
		int[] row_4 = {2,4};
		
		Sequence sequence_1 = new Sequence(row_1);
		System.out.println(sequence_1.noMovesLeft());
		
		System.out.println();
			
		Sequence sequence_2 = new Sequence(row_2);
		System.out.println(sequence_2.noMovesLeft());
		
		System.out.println();
		
		Sequence sequence_3 = new Sequence(row_3);
		System.out.println(sequence_3.noMovesLeft());
		
		System.out.println();
		
		Sequence sequence_4 = new Sequence(row_4);
		System.out.println(sequence_4.noMovesLeft());
	}

}
