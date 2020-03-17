package affix.java.basic.movie;

/**
 * 
 */

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;


/**
 * @author Wael Al Henawe
 *
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class AATestJUnitJavaMovie {
//Movie [ Id: 10, Title: Casino Royale, Main Actor: Daniel Craig, Production Year: 2006, Length: 144]
	@Test
	public void AAtestJavaMovie1() {
		Movie temp = new Movie("Casino Royale","Daniel Craig",2006,100);
		assertNotNull(temp);
	}
	
	@Test //(expected = IllegalArgumentException.class)
	public void ABtestJavaCircle2() {
		Movie temp = new Movie("Casino Royale","Daniel Craig",2006,100);
		Assert.assertEquals("Casino Royale" , temp.getMovieName());
	}
	
	@Test
	public void ACtestJavaCircle3() {
		Movie temp = new Movie("Casino Royale","Daniel Craig",2006,100);
		Assert.assertEquals("Daniel Craig", temp.getActor());
	}
	
	@Test
	public void ADtestJavaCircle4() {
		Movie temp = new Movie("Casino Royale","Daniel Craig",2006,100);
		Assert.assertEquals(2006, temp.getYear());;
	}
	
	@Test
	public void AEtestJavaCircle5() {
		Movie temp = new Movie("Casino Royale","Daniel Craig",2006,100);
		Assert.assertEquals(100, temp.getLenght());;
	}
	
	@Test
	public void AFtestJavaCircle6() {
		Movie temp = new Movie("Casino Royale","Daniel Craig",2006,100);
		Movie temp2 = new Movie("Casino Royale","Daniel Craig",2006,100);
		Assert.assertEquals(true, temp.equals(temp2));;
	}
	
	@Test
	public void AGtestJavaCircle7() {
		Movie temp = new Movie("Casino Royale","Daniel Craig",2006,100);
		Movie temp2 = null;
		Assert.assertEquals(false, temp.equals(temp2));;
	}
	
	@Test
	public void AHtestJavaCircle8() {
		Movie temp = new Movie("Casino Royale","Daniel Craig",2006,100);
		int temp2 = 0;
		Assert.assertEquals(false, temp.equals(temp2));;
	}
	
	@Test
	public void AItestJavaCircle9() {
		Movie temp = new Movie("Casino Royale","Daniel Craig",2006,100);
		Movie temp2 = new Movie("Casino Royal","Daniel Craig",2006,100);
		Assert.assertEquals(false, temp.equals(temp2));;
	}
	
	@Test
	public void AJtestJavaCircle10() {
		Movie temp = new Movie("Casino Royale","Daniel Craig",2006,100);
		Movie temp2 = new Movie("Casino Royale","Danie Craig",2006,100);
		Assert.assertEquals(false, temp.equals(temp2));;
	}
	
	@Test
	public void AKtestJavaCircle11() {
		Movie temp = new Movie("Casino Royale","Daniel Craig",2006,100);
		Movie temp2 = new Movie("Casino Royale","Daniel Craig",2007,100);
		Assert.assertEquals(false, temp.equals(temp2));;
	}
	
	@Test
	public void ALtestJavaCircle12() {
		Movie temp = new Movie("Casino Royale","Daniel Craig",2006,100);
		Movie temp2 = new Movie("Casino Royale","Daniel Craig",2006,110);
		Assert.assertEquals(false, temp.equals(temp2));;
	}
	
	@Test
	public void AMtestJavaCircle13() {
		Movie temp = new Movie("Casino Royale","Daniel Craig",2006,100);
		String expectedValue = "Movie id=18, name=Casino Royale, actor=Daniel Craig, year=2006, lenght=100.";
		Assert.assertEquals(true, String.valueOf(temp.toString()).equals(expectedValue));
	}
	
	@Test
	public void ANtestJavaCircle14() {
		Movie temp = new Movie("Casino Royale","Daniel Craig",2006,100);
		Assert.assertEquals(19, temp.getElementNo());
	}
	
	@Test
	public void AOtestJavaCircle15() {
		Movie temp = new Movie("Casino Royale","Daniel Craig",2006,100);
		Movie temp2 = new Movie("Casino Royale","Daniel Craig",2006,100);
		Assert.assertEquals(0, temp.compareTo(temp2));
	}
	
	@Test
	public void APtestJavaCircle16() {
		Movie temp = new Movie("Dasino Royale","Daniel Craig",2006,100);
		Movie temp2 = new Movie("Casino Royale","Daniel Craig",2006,100);
		Assert.assertEquals(1, temp.compareTo(temp2));
	}
	
	@Test
	public void AQtestJavaCircle17() {
		Movie temp = new Movie("Basino Royale","Daniel Craig",2006,100);
		Movie temp2 = new Movie("Casino Royale","Daniel Craig",2006,100);
		Assert.assertEquals(-1, temp.compareTo(temp2));
	}
	
	@Test
	public void ARtestJavaCircle18() {
		Movie temp = new Movie("Casino Royale","Daniel Craig",2007,100);
		Movie temp2 = new Movie("Casino Royale","Daniel Craig",2006,100);
		Assert.assertEquals(1, temp.compareTo(temp2));
	}
	
	@Test
	public void AStestJavaCircle19() {
		Movie temp = new Movie("Casino Royale","Daniel Craig",2006,100);
		Movie temp2 = new Movie("Casino Royale","Daniel Craig",2007,100);
		Assert.assertEquals(-1, temp.compareTo(temp2));
	}
	
	@Test
	public void ATtestJavaCircle20() {
		Movie temp = new Movie("Casino Royale","Daniel Craig",2007,100);
		Movie temp2 = new Movie("Casino Royale","Daniel Craig",2006,100);
		Assert.assertEquals(1, temp.compareTo(temp2));
	}
	
	@Test
	public void AUtestJavaCircle21() {
		Movie temp = new Movie("Casino Royale","Daniel Craig",2005,100);
		Movie temp2 = new Movie("Casino Royale","Daniel Craig",2006,100);
		Assert.assertEquals(-1, temp.compareTo(temp2));
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void AXtestJavaCircle22() {
		new Movie("Casino Royale","",2006,100);
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void AYtestJavaCircle23() {
		new Movie("Casino Royale",null,2006,100);
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void AZtestJavaCircle24() {
		new Movie("","Daniel Craig",2006,100);
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void BAtestJavaCircle25() {
		new Movie(null,"Daniel Craig",2006,100);
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void BBtestJavaCircle26() {
		new Movie("Casino Royale", "Daniel Craig",1899,100);
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void BCtestJavaCircle27() {
		new Movie("Casino Royale", "Daniel Craig",2021,100);
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void BDtestJavaCircle28() {
		new Movie("Casino Royale", "Daniel Craig",2006,59);
	}
	
	@Test 
	public void BEtestJavaCircle29() {
		Movie temp = new Movie("Casino Royale","Daniel Craig",2006,100);
		Movie temp2 = new Movie("Casino Royale","Daniel Craig",2006,100);
		Assert.assertEquals(temp.hashCode(), temp2.hashCode());
	}
	
	
}
