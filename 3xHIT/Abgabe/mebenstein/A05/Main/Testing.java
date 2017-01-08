package Main;

import static org.junit.Assert.*;

import java.math.BigInteger;

import org.junit.Before;
import org.junit.Test;


/**
 * 
 * @author Michael Ebenstein
 * @version 12-12-2016
 */

public class Testing {

	//Testing Fibonacci class
	
	Fibonacci f;
	
	@Before
	public void init(){
		f = new Fibonacci();
	}
	
	@Test
	public void testGetNumber1(){
		assertEquals(f.getNumber(1), new BigInteger("1"));
	}
	
	@Test
	public void testGetNumber2(){
		assertEquals(f.getNumber(2), new BigInteger("1"));
	}
	
	@Test
	public void testGetNumber3(){
		assertEquals(f.getNumber(3), new BigInteger("2"));
	}
	
	@Test
	public void testGetNumber4(){
		assertEquals(f.getNumber(4), new BigInteger("3"));
	}
	
	@Test
	public void testGetNumber5(){
		assertEquals(f.getNumber(5), new BigInteger("5"));
	}
	
	@Test
	public void testGetNumber6(){
		assertEquals(f.getNumber(6), new BigInteger("8"));
	}
	
	@Test 
	public void testGetNumbers10(){
		assertEquals(f.getNumbers(10).size(), 10);
	}
	
	@Test 
	public void testGetNumbers35(){
		assertEquals(f.getNumbers(35).size(), 35);
	}
	
	@Test 
	public void testGetNumbers2450(){
		assertEquals(f.getNumbers(2450).size(), 2450);
	}

}
