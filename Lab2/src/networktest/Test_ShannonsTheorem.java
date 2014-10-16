/*
 *  @(#)Test_ShannonsTheorem.java	Feb 17, 2005
 *	
 *
 *  This software contains confidential and proprietary information
 *  of Dyer Consulting ("Confidential Information").  You shall not disclose
 *  such Confidential Information and shall use it only in accordance with the
 *  terms of the license agreement you entered into with Dyer Consulting.
 *
 *  This software is provided "AS IS,".  No warrantee of any kind, express
 *  or implied, is included with this software; use at your own risk, responsibility
 *  for damages (if any) to anyone resulting from the use of this software rests
 *  entirely with the user even if Dyer Consulting has been advised of the
 *  possibility of such damages.
 *
 *  This software is not designed or intended for use in on-line control of
 *  aircraft, air traffic, aircraft navigation or aircraft communications; or in
 *  the design, construction, operation or maintenance of any nuclear
 *  facility. Licensee represents and warrants that it will not use or
 *  redistribute the Software for such purposes.
 *
 *  Distribute freely, except: don't remove my name from the source or
 *  documentation, mark your changes (don't blame me for your possible bugs),
 *  don't alter or remove any of this notice.
 *
 */

package networktest;

import java.util.Random;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import network.ShannonsTheorem;

/**
 * JUnit Tests for Lab2 of CST8288:<br>
 * <br>
 * 
 * This class uses various methods of verification to ensure that all members of
 * the ShannonsTheorem class (required for lab 2) are fully functional.
 * 
 * @date 2014/10/04
 * @author Larabie Josh, Algonquin College Staff
 * @version 1.0.0
 */
public class Test_ShannonsTheorem extends TestCase {

	public Test_ShannonsTheorem(String name) {
		super(name);
	}

	public static Test suite() {
		return new TestSuite(Test_ShannonsTheorem.class);
	}

	protected void setUp() throws Exception {
		System.out.println("Test_ShannonsTheorem Begin");
	}

	protected void tearDown() throws Exception {
		System.out.println("Test_ShannonsTheorem End");
	}

	/**
	 * Test the constructors: Determines if constructor was successfully called.<br>
	 * <br>
	 * 
	 * This test was done by instantiating a new instance of ShannonsTheorem,
	 * and then running a check to see if the object had a null value.<br>
	 * <br>
	 * 
	 * If the object had a null value, the constructor was never called, as the
	 * object wouldn't exist.
	 */
	public void testConstructors() {
		System.out.println("\tExecuting Test_ShannonsTheorem.testConstructors");
		ShannonsTheorem = new ShannonsTheorem();

		ShannonsTheorem = new ShannonsTheorem();
		assertNotNull(
				"\t\tTest_ShannonsTheorem.testConstructors: ShannonsTheorem is null",
				ShannonsTheorem);

		/*
		 * Verification of ShannonsTheorem's instantiation.
		 */
		if (ShannonsTheorem != null) {
			System.out
					.println("[PASS] ShannonsTheorem constructor was properly called.");
		}
	}

	/**
	 * Test the accessors: Determines if getSignalToNoise, getBandwidth, and
	 * maximumDataRate are accessible.<br>
	 * <br>
	 * 
	 * This test was done by filling the value of a Double object (tempDouble)
	 * with the return value of the accessed method and then running a check to
	 * see if the object returned null.<br>
	 * <br>
	 * 
	 * If tempDouble returns null, then the return value from the
	 * ShannonsTheorem method was not properly accessed.
	 */
	public void testAccessors() {
		System.out.println("\tExecuting Test_ShannonsTheorem.testAccessors");
		ShannonsTheorem = new ShannonsTheorem();
		assertNotNull(
				"\t\tTest_ShannonsTheorem.testAccessors: ShannonsTheorem is null",
				ShannonsTheorem);

		Double tempDouble;

		/*
		 * Access verification for the ShannonsTheorem.getBandwidth method.
		 */
		boolean pass = (tempDouble = new Double(ShannonsTheorem.getBandwidth())) != null;
		assertEquals(true, pass);

		if (pass)
			System.out
					.println("[PASS] ShannonsTheorem.getBandwidth() was accessible.");
		else
			System.out
					.println("[FAIL] ShannonsTheorem.getBandwidth() was not accessible.");

		/*
		 * Access verification for the ShannonsTheorem.getSignalToNoise method.
		 */
		pass = (tempDouble = new Double(ShannonsTheorem.getSignalToNoise())) != null;
		assertEquals(true, pass);

		if (pass)
			System.out
					.println("[PASS] ShannonsTheorem.getSignalToNoise() was accessible.");
		else
			System.out
					.println("[FAIL] ShannonsTheorem.getSignalToNoise() was not accessible.");

		/*
		 * Access verification for the ShannonsTheorem.maximumDataRate method.
		 */
		pass = (tempDouble = new Double(ShannonsTheorem.maximumDataRate())) != null;
		if (pass)
			System.out
					.println("[PASS] ShannonsTheorem.maximumDataRate() was accessible.");
		else
			System.out
					.println("[FAIL] ShannonsTheorem.maximumDataRate() was not accessible.");
		assertEquals(true, pass);
	}

	/**
	 * Test the mutators/modifiers: Determines if the bandwidth and
	 * signalToNoise values are mutable<br>
	 * <br>
	 * 
	 * This test was done by calling the setter of bandwidth and signalToNoise,
	 * assigning them a random value, and then running a check to see if the
	 * value was modified.<br>
	 * <br>
	 * 
	 * If the value of bandwidth/signalToNoise did not matched the random value,
	 * then bandwidth/signalToNoise was not modified.
	 */
	public void testMutators() {
		System.out.println("\tExecuting Test_ShannonsTheorem.testMutators");
		ShannonsTheorem = new ShannonsTheorem();
		assertNotNull(
				"\t\tTest_ShannonsTheorem.testMutators: ShannonsTheorem is null",
				ShannonsTheorem);

		Random randomDouble = new Random();

		/*
		 * Mutation of the ShannonsTheorem.bandwidth variable.
		 */

		double tempDouble = randomDouble.nextDouble();

		ShannonsTheorem.setBandwidth(tempDouble);
		assertEquals(tempDouble, ShannonsTheorem.getBandwidth());
		boolean pass = ShannonsTheorem.getBandwidth() == tempDouble;

		if (pass)
			System.out
					.println("[PASS] ShannonsTheorem.getBandwidth() was properly mutated.");
		else
			System.out
					.println("[FAIL] ShannonsTheorem.getBandwidth() was not properly mutated.");

		/*
		 * Mutation of the ShannonsTheorem.signalToNoise variable.
		 */
		tempDouble = randomDouble.nextDouble();

		ShannonsTheorem.setSignalToNoise(tempDouble);
		assertEquals(tempDouble, ShannonsTheorem.getSignalToNoise());
		pass = ShannonsTheorem.getSignalToNoise() == tempDouble;

		if (pass)
			System.out
					.println("[PASS] ShannonsTheorem.getSignalToNoise() was properly mutated.");
		else
			System.out
					.println("[FAIL] ShannonsTheorem.getSignalToNoise() was not properly mutated.");

	}

	/**
	 * Test behaviors: No Behaviors are applicable for testing.
	 */
	public void testBehaviors() {
		System.out.println("\tExecuting Test_ShannonsTheorem.testBehaviors");
		ShannonsTheorem = new ShannonsTheorem();
		assertNotNull(
				"\t\tTest_ShannonsTheorem.testBehaviors: ShannonsTheorem is null",
				ShannonsTheorem);

		System.out.println("No behaviors are testable.");
	}

	/* STAND-ALONE ENTRY POINT ----------------------------------------- */
	/**
	 * Main line for standalone operation.
	 *
	 * @param args
	 *            Standard string command line parameters.
	 */
	public static void main(String[] args) {
		System.out.println("Executing Test_ShannonsTheorem suite");
		junit.textui.TestRunner.run(suite());
	}

	/* ATTRIBUTES ----------------------------------------------- */
	private ShannonsTheorem ShannonsTheorem = null;

} /* End of CLASS: Test_ShannonsTheorem.java */
