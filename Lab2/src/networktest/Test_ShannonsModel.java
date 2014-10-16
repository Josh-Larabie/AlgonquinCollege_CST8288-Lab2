/*
 *  @(#)Test_ShannonsModel.java	Feb 17, 2005
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

import java.text.DecimalFormat;
import java.util.Random;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import network.ShannonsModel;

/**
 * JUnit Tests for Lab2 of CST8288:<br>
 * <br>
 * 
 * This class uses various methods of verification to ensure that all members of
 * the ShannonsModel class (required for lab 2) are fully functional.
 * 
 * @date 2014/10/04
 * @author Larabie Josh, Algonquin College Staff
 * @version 1.0.0
 */
public class Test_ShannonsModel extends TestCase {

	public Test_ShannonsModel(String name) {
		super(name);
	}

	public static Test suite() {
		return new TestSuite(Test_ShannonsModel.class);
	}

	protected void setUp() throws Exception {
		System.out.println("Test_ShannonsModel Begin");
	}

	protected void tearDown() throws Exception {
		System.out.println("Test_ShannonsModel End");
	}

	/**
	 * Test the constructors: Determines if constructor was successfully called.<br>
	 * <br>
	 * 
	 * This test was done by instantiating a new instance of ShannonsModel, and
	 * then running a check to see if the object had a null value.<br>
	 * <br>
	 * 
	 * If the object had a null value, the constructor was never called, as the
	 * object wouldn't exist.
	 */
	public void testConstructors() {
		System.out.println("\tExecuting Test_ShannonsModel.testConstructors");
		ShannonsModel = new ShannonsModel();

		ShannonsModel = new ShannonsModel();
		assertNotNull(
				"\t\tTest_ShannonsModel.testConstructors: ShannonsModel is null",
				ShannonsModel);

		/*
		 * Verification of ShannonsModel's instantiation.
		 */
		if (ShannonsModel != null) {
			System.out
					.println("[PASS] ShannonsModel constructor was properly called.");
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
	 * If tempDouble returns null, then the return value from the ShannonsModel
	 * method was not properly accessed.
	 * 
	 * maximumDataRate was tested differently: I set the (bandwidth: 3000,
	 * signalToNoise: 30) and then compared the value against the expected value
	 * of (29901.68).
	 * 
	 * If maximumDataRate did not return 29901.68, it was not properly accessed.
	 */
	public void testAccessors() {
		System.out.println("\tExecuting Test_ShannonsModel.testAccessors");
		ShannonsModel = new ShannonsModel();
		assertNotNull(
				"\t\tTest_ShannonsModel.testAccessors: ShannonsModel is null",
				ShannonsModel);

		Double tempDouble;

		/*
		 * Access verification for the ShannonsModel.getBandwidth method.
		 */
		boolean pass = (tempDouble = new Double(ShannonsModel.getBandwidth())) != null;
		assertEquals(true, pass);

		if (pass)
			System.out
					.println("[PASS] ShannonsModel.getBandwidth() was accessible.");
		else
			System.out
					.println("[FAIL] ShannonsModel.getBandwidth() was not accessible.");

		/*
		 * Access verification for the ShannonsModel.getSignalToNoise method.
		 */
		pass = (tempDouble = new Double(ShannonsModel.getSignalToNoise())) != null;
		assertEquals(true, pass);

		if (pass)
			System.out
					.println("[PASS] ShannonsModel.getSignalToNoise() was accessible.");
		else
			System.out
					.println("[FAIL] ShannonsModel.getSignalToNoise() was not accessible.");

		/*
		 * Access verification for the ShannonsModel.maximumDataRate method.
		 */

		ShannonsModel.setBandwidth(3000);
		ShannonsModel.setSignalToNoise(30);

		pass = (tempDouble = new Double(Double.parseDouble(new DecimalFormat(
				"#.##").format(ShannonsModel.maximumDataRate())))) == 29901.68;

		if (pass)
			System.out
					.println("[PASS] ShannonsModel.maximumDataRate() was accessible.");
		else
			System.out
					.println("[FAIL] ShannonsModel.maximumDataRate() was not accessible.");
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
		System.out.println("\tExecuting Test_ShannonsModel.testMutators");
		ShannonsModel = new ShannonsModel();
		assertNotNull(
				"\t\tTest_ShannonsModel.testMutators: ShannonsModel is null",
				ShannonsModel);

		Random randomDouble = new Random();

		/*
		 * Mutation of the ShannonsModel.bandwidth variable.
		 */

		double tempDouble = randomDouble.nextDouble();

		ShannonsModel.setBandwidth(tempDouble);
		assertEquals(tempDouble, ShannonsModel.getBandwidth());
		boolean pass = ShannonsModel.getBandwidth() == tempDouble;

		if (pass)
			System.out
					.println("[PASS] ShannonsModel.getBandwidth() was properly mutated.");
		else
			System.out
					.println("[FAIL] ShannonsModel.getBandwidth() was not properly mutated.");

		/*
		 * Mutation of the ShannonsModel.signalToNoise variable.
		 */
		tempDouble = randomDouble.nextDouble();

		ShannonsModel.setSignalToNoise(tempDouble);
		assertEquals(tempDouble, ShannonsModel.getSignalToNoise());
		pass = ShannonsModel.getSignalToNoise() == tempDouble;

		if (pass)
			System.out
					.println("[PASS] ShannonsModel.getSignalToNoise() was properly mutated.");
		else
			System.out
					.println("[FAIL] ShannonsModel.getSignalToNoise() was not properly mutated.");

	}

	/**
	 * Test behaviors: The toString method should contain the properly formatted
	 * MDR.<br>
	 * <br>
	 * 
	 * This test was done by setting bandwidth to 3000, and signalToNoice to 30,
	 * then calling toString, and searching it's contents for the specific
	 * formatted MDR value (29901.68) where it would normally contain the value
	 * (29901.67...) - not rounded to two decimal places.<br>
	 * <br>
	 * 
	 * If the value of toString does not contain 29901.68, then the expected
	 * behavior is incorrect.
	 */
	public void testBehaviors() {
		System.out.println("\tExecuting Test_ShannonsModel.testBehaviors");
		ShannonsModel = new ShannonsModel();
		assertNotNull(
				"\t\tTest_ShannonsModel.testBehaviors: ShannonsModel is null",
				ShannonsModel);

		/*
		 * Formatting check for ShannonsModel.toString()
		 */
		ShannonsModel.setBandwidth(3000);
		ShannonsModel.setSignalToNoise(30);

		boolean pass = ShannonsModel.toString().contains("29901.68");
		assertEquals(true, pass);

		if (pass)
			System.out
					.println("[PASS] ShannonsModel.toString() was properly formatted.");
		else
			System.out
					.println("[FAIL] ShannonsModel.toString() was not properly formatted.");

	}

	/* STAND-ALONE ENTRY POINT ----------------------------------------- */
	/**
	 * Main line for standalone operation.
	 *
	 * @param args
	 *            Standard string command line parameters.
	 */
	public static void main(String[] args) {
		System.out.println("Executing Test_ShannonsModel suite");
		junit.textui.TestRunner.run(suite());
	}

	/* ATTRIBUTES ----------------------------------------------- */
	private ShannonsModel ShannonsModel = null;

} /* End of CLASS: Test_ShannonsModel.java */
