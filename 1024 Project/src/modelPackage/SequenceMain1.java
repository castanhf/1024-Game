package modelPackage;

public class SequenceMain1 {

	public static void main(String[] args) {
		
		int[] numbers = { 0,0,2,4,0,4,0,0};
		
		Sequence sequence = new Sequence( numbers );
		System.out.println( " Sequence" );
		System.out.println( "\t" + sequence.toString() );
		
//		Sequence sequenceLeft = sequence.leftJustified();
//		System.out.println( "\n Sequence left justified" );
//		System.out.println( "\t" + sequenceLeft.toString() );
		
		Sequence sequenceCombinedLeftJustified = sequence.combinedLeftJustified();
		System.out.println( "\n Sequence combined left justified" );
		System.out.println( "\t" + sequenceCombinedLeftJustified.toString() );
	}
}
