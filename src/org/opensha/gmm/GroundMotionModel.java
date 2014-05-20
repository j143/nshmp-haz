package org.opensha.gmm;

import org.opensha.calc.ScalarGroundMotion;

/**
 * Interface implemented by all ground motion models (GMMs); these are also
 * commonly referred to as ground motion prediction equations (GMPEs) or
 * attenuation relationships. Direct instantiation of GMMs is discouraged in
 * concrete implementations in favor of using the corresponding {@link GMM}
 * {@code enum} identifier and its {@link GMM#instance(IMT)} method. Concrete
 * implementations are public solely for the purpose of documentation.
 * 
 * <p>Models generally have a single concrete implementation. However, for those
 * supplying region- or source-specific variants, there will typically be an
 * abstract base-model implementation and subclasses to handle each flavor (e.g.
 * {@link ZhaoEtAl_2006}. Each flavor has a unique {@link GMM} identifier.</p>
 * 
 * @author Peter Powers
 * @see GMM
 */
public interface GroundMotionModel {

	/**
	 * Compute the scalar ground motion and its standard deviation for the
	 * supplied arguments.
	 * @param args a ground motion model input argument container
	 * @return a scalar ground motion wrapper
	 */
	public ScalarGroundMotion calc(GMM_Source args);

	/*
	 * Compute the scalar ground motion for the supplied arguments at all
	 * spectral periods.
	 */
	// Map<IMT, ScalarGroundMotion> calcAll(GMM_Source args);

}