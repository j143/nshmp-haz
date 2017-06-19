package org.opensha2.gmm;

import org.opensha2.data.Data;

import java.util.Arrays;

/**
 * Extension to {@code ScalarGroundMotion} heirarchy added in support of
 * NGA-East. The {@link #mean} method of this class returns the weighted mean of
 * the NGA-East
 *
 * @author Peter Powers
 */
public class MultiScalarGroundMotion extends DefaultScalarGroundMotion {

  // TODO package privatize if possible? no weight validation is
  // performed or length agreement checking

  // TODO array exposure is dangerous and should be changed in favor of
  // immutable lists; this is agood candidate for immutable DataArrays
  
  // TODO can we avoid instanceof tests in exceedance/probabilityModle enums

  private final double[] means;
  private final double[] meanWts;

  private final double[] sigmas;
  private final double[] sigmaWts;

  MultiScalarGroundMotion(
      double[] means, double[] meanWts,
      double[] sigmas, double[] sigmaWts) {

    super(
        Data.sum(Data.multiply(Arrays.copyOf(means, means.length), meanWts)),
        Data.sum(Data.multiply(Arrays.copyOf(sigmas, sigmas.length), sigmaWts)));

    this.means = means;
    this.meanWts = meanWts;
    this.sigmas = sigmas;
    this.sigmaWts = sigmaWts;
  }

  public double[] means() {
    return means;
  }

  public double[] meanWeights() {
    return meanWts;
  }

  public double[] sigmas() {
    return sigmas;
  }

  public double[] sigmaWeights() {
    return sigmaWts;
  }

}
