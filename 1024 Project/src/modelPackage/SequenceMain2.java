package modelPackage;

public class SequenceMain2 {
	
	public static void main(String[] args) {
		int[] numbers = { 0,0,2,4,0,4,0,0};
		
		Sequence sequence = new Sequence( numbers );
		System.out.println( " Sequence" );
		System.out.println( "\t" + sequence.toString() );
		
		
//		Sequence sequenceReversed = sequence.inReverse();
//		System.out.println( "\n Sequence reversed" );
//		System.out.println( "\t" + sequenceReversed.toString() );
//		
//		Sequence sequenceReversedLeftJustified = sequence.inReverse().leftJustified();
//		System.out.println( "\n Sequence reversed, left justified" );
//		System.out.println( "\t" + sequenceReversedLeftJustified.toString() );
//		
//		Sequence sequenceReversedLeftJustiifedReversed = sequence.inReverse().leftJustified().inReverse();
//		System.out.print( "\n Sequence reversed, left justified, and reversed; same as" );
//		System.out.println( " sequence right justified." );
//		System.out.println( "\t" + sequenceReversedLeftJustiifedReversed .toString() );

		Sequence sequenceCombinedRightJustified = sequence.combinedRightJustified();
		System.out.println( "\n Sequence combined right justified" );
		System.out.println( "\t" + sequenceCombinedRightJustified.toString() );
	
	}
}
