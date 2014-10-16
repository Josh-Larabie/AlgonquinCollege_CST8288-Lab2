package network;

import java.text.DecimalFormat;

/**
 * This class is the model structure required for Lab2 of CST8288 - Algonquin
 * College. It calculates values pertaining to Shannon's Theorem & it's
 * maximumDataRate calculations.
 * 
 * @author Larabie Josh, Algonquin College Staff (Design)
 * @version 1.0.0
 * @date 2014/10/04
 */

public class ShannonsModel {

	/* CONSTRUCTORS -------------------------------------------------- */

	/**
	 * Creates new ShannonsModel Object.
	 */
	public ShannonsModel() {
		super();
	}

	/* ACCESSORS ----------------------------------------------------- */

	/**
	 * gets bandwidth
	 * 
	 * @return bandwidth
	 */
	public double getBandwidth() {
		return bandwidth;
	}

	/**
	 * gets signalToNoise
	 * 
	 * @return signalToNoise
	 */
	public double getSignalToNoise() {
		return signalToNoise;
	}

	/**
	 * Calls overloaded maximumDataRate(hertz, snr) and returns it's calculated
	 * value.
	 * 
	 * @return maximumDataRate(bandwidth, signalToNoise)
	 */
	public double maximumDataRate() {
		return maximumDataRate(bandwidth, signalToNoise);
	}

	/**
	 * Calculates the maximum data rate.
	 * 
	 * @param hertz
	 * @param signalToNoise
	 * @return (bandwidth * (Math.log(1 + Math.pow(10, signalToNoise / 10)) /
	 *         Math .log(2))
	 */
	private double maximumDataRate(double hertz, double signalToNoise) {
		return (hertz * (Math.log(1 + Math.pow(10, signalToNoise / 10)) / Math
				.log(2)));
	}

	/* MODIFIERS ----------------------------------------------------- */

	/**
	 * Sets bandwidth
	 * 
	 * @param h
	 */
	public void setBandwidth(double h) {
		this.bandwidth = h;
	}

	/**
	 * Sets signalToNoise
	 * 
	 * @param snr
	 */
	public void setSignalToNoise(double snr) {
		this.signalToNoise = snr;
	}

	/* NORMAL BEHAVIOR ------------------------------------------------- */

	/**
	 * Returns information related to the attributes and calculations for
	 * maximumDataRate. maximumDataRate is displayed in a 2 decimal place
	 * rounding format.
	 */
	@Override
	public String toString() {
		return "Bandwidth: "
				+ bandwidth
				+ "    SignalToNoise: "
				+ signalToNoise
				+ "    MDR: "
				+ new DecimalFormat("#.##").format(maximumDataRate(bandwidth,
						signalToNoise));
	}

	/* ATTRIBUTES ----------------------------------------------------- */
	/**
	 * Provides a value in hertz, required for maximumDataRate Calculation.
	 */
	private double bandwidth;
	/**
	 * Provides a value in decibels, required for maximumDataRate Calculation.
	 */
	private double signalToNoise;

}
