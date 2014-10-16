package network;

import javax.swing.JOptionPane;

/**
 * This class is the model structure required for Lab2 of CST8288 - Algonquin
 * College. It calculates values pertaining to Shannon's Theorem & it's
 * maximumDataRate calculations.
 * 
 * @author Larabie Josh, Algonquin College Staff (Design)
 * @version 1.0.0
 * @date 2014/10/04
 */
public class ShannonsTheorem {

	private static ShannonsModel model = new ShannonsModel();

	public static void main(String[] args) {
		try {
			/*
			 * Displays JOptionPane for grabbing data required for
			 * ShannonsModel.
			 */
			double bandwidth = Double.parseDouble(JOptionPane
					.showInputDialog("Enter Bandwidth: "));
			double signalToNoise = Double.parseDouble(JOptionPane
					.showInputDialog("Enter SignalToNoise: "));

			ShannonsTheorem theorem = new ShannonsTheorem();
			theorem.setBandwidth(bandwidth);
			theorem.setSignalToNoise(signalToNoise);

			JOptionPane.showMessageDialog(null, model.toString());

		} catch (NumberFormatException nfex) {
			JOptionPane.showMessageDialog(null,
					"You have entered incorrect input values.");
			nfex.printStackTrace();
			System.exit(0);
		}
	}

	/* CONSTRUCTORS -------------------------------------------------- */
	/**
	 * Creates new ShannonsModel Object.
	 */
	public ShannonsTheorem() {
		super();
	}

	/* ACCESSORS ----------------------------------------------------- */
	/**
	 * gets model.bandwidth
	 * 
	 * @return bandwidth
	 */

	public double getBandwidth() {
		return model.getBandwidth();
	}

	/**
	 * gets model.signalToNoise
	 * 
	 * @return model.signalToNoise
	 */
	public double getSignalToNoise() {
		return model.getSignalToNoise();
	}

	/**
	 * Gets model.maximumDataRate
	 * 
	 * @return model.maximumDataRate(bandwidth, signalToNoise)
	 */
	public double maximumDataRate() {
		return model.maximumDataRate();
	}

	/* MODIFIERS ----------------------------------------------------- */
	/**
	 * Sets model.bandwidth
	 * 
	 * @param h
	 */
	public void setBandwidth(double bandwidth) {
		model.setBandwidth(bandwidth);
	}

	/**
	 * Sets model.signalToNoise
	 * 
	 * @param h
	 */
	public void setSignalToNoise(double snr) {
		model.setSignalToNoise(snr);
	}

}
