// JUnit test Case for Sequence class

package modelPackage;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestSequence {

    @Test
    public void test() {
        //fail("Not yet implemented");
    }
    
    
    @Test
    public void test2() {
        int[] n1 = {0,2,0,8,8 };

        assertEquals(n1, n1);
    }

    
    @Test
    public void test3() {
        int[] n1 = {0,2,0,8,8 };
        int[] n2 = {0,2,0,8,8 };
        
          assertTrue(n1 != n2);
//        assertEquals(n1, n2);
    }

    
    @Test
    public void testConstructor() {
        
        int[] numbers = {0,2,0,8,8 };
        
        assertEquals( numbers[1], 2);
    }

    
    @Test
    public void testConstructor2() {
        
        int[] numbers = {0,2,0,8,8 };
        Sequence s = new Sequence(numbers);
        
        assertEquals( s.numbers[1], 2);
    }   

    
    @Test
    public void testConstructor3() {
        
        int[] numbers = {0,2,0,8,8 };
        Sequence s = new Sequence(numbers);
        
        assertEquals( s, s);
        assertEquals( s.numbers, s.numbers);
    }       
    
    
    @Test
    public void testConstructor4() {
        
        int[] numbers = {0,2,0,8,8 };
        Sequence s1 = new Sequence(numbers);
        Sequence s2 = new Sequence(numbers);
        
        assertEquals( s1.numbers, numbers);
        assertEquals( s2.numbers, numbers);
        assertEquals( s1, s2);
    }   
    
    
    @Test
    public void testReverse() {
        
        int[] n = {0,2,0,8,8 };
        int[] r1 = {8,8,0,2,0};
        
        Sequence s = new Sequence(n);
        int[] r2 = s.reverse();
   
        assertTrue( r1 != r2 );
//      assertEquals( r1,  r2);
    }   
    
    
    @Test
    public void testReverse2() {
        
        int[] n = {0,2,0,8,8 };
        int[] r1 = {8,8,0,2,0};
        
        Sequence s = new Sequence(n);
        int[] r2 = s.reverse();
        
        Sequence s1 = new Sequence( r1 );
        Sequence s2 = new Sequence( r2 );
        
        assertEquals( s1,  s2);
    }   
        
    
    @Test
    public void testReverse3() {
        
        int[] n = {0,2,0,8,8 };
        int[] r1 = {8,8,0,2,0};
        
        Sequence s = new Sequence(n);
        int[] r2 = s.reverse();
        
        Sequence s1 = new Sequence( r1 );
        Sequence s2 = new Sequence( r2 );
        
        assertTrue( s1.numbers != s2.numbers);
//      assertEquals( s1.numbers,  s2.numbers);
    }   

    
    @Test
    public void slideLeft() {
        
        int[] n = {0,2,0,8,8 };
        int[] r = {2,8,8,0,0 };
        
        Sequence s = new Sequence(n);
        
        Sequence s1 = new Sequence( s.slideLeft() );
        
        Sequence s2 = new Sequence( r );
        assertEquals( s1, s2);
    }       
    
    
    @Test
    public void combineLeft1024_1() {
        
        int[] n = {0,2,0,8,8 };
        int[] r = {2,16,0,0,0 };
        
        Sequence s = new Sequence(n);
        
        Sequence s1 = new Sequence( s.combineLeft1024() );
        
        Sequence s2 = new Sequence( r );
        assertEquals( s1, s2);
    }       
    
    
    @Test
    public void combineLeft1024_2() {
        
        int[] n = {2,2,0,8,8 };
        int[] r = {4,16,0,0,0 };
        
        Sequence s = new Sequence(n);
        
        Sequence s1 = new Sequence( s.combineLeft1024() );
        
        Sequence s2 = new Sequence( r );
        assertEquals( s1, s2);
    }       
        
    @Test
    public void combineRight1024_1() {
        
        int[] n = {0,2,0,8,8 };
        int[] r = {0,0,0,2,16 };
        
        Sequence s = new Sequence(n);
        
        Sequence s1 = new Sequence( s.combineRight1024() );
        
        Sequence s2 = new Sequence( r );
        assertEquals( s1, s2);
    }       
    
    
    @Test
    public void combineRight1024_2() {
        
        int[] n = {2,2,0,8,8 };
        int[] r = {0,0,0,4,16 };
        
        Sequence s = new Sequence(n);
        
        Sequence s1 = new Sequence( s.combineRight1024() );
        
        Sequence s2 = new Sequence( r );
        assertEquals( s1, s2);
    }
}
