
/**
 * @author Tim Reed
 * 
 * Haversine formula is defined below:
 * hav (omega) = hav (z2 - z1) + cos (z1) * cos (z2) * hav (l2 - l1)
 * 
 * where z1, z2: latitude of point 1 and latitude of point 2
 * l1, l2: longitude of point 1 and longitude of point 2 
 * omega is the central angle 
 * 
 * hav (theta) = sin^2 (theta / 2) = (1 - cos (theta)) / 2.
 * 
 * to solve for distance, d = 2r * arcsin (sqrt (hav(omega)))
 * 
 * for more, see https://en.wikipedia.org/wiki/Haversine_formula
 */

import java.lang.Math;

public class Haversine {
	
	// The earth is not a perfect sphere.  The average global radii will be used. Distance in miles.
	static final int R_EARTH = 3959;
	
	public Haversine () {}
	public double calculate (double lat1, double lng1, double lat2, double lng2) {
		
		// stores positions after converting degrees to radians.
		position1.lat = Math.toRadians(lat1);
		position1.lng = Math.toRadians(lng1);
		position2.lat = Math.toRadians(lat2);
		position2.lng = Math.toRadians(lng2);
		
		return 2 * R_EARTH * Math.asin(Math.sqrt(havForm ()));
		
	}
	
	// hav (theta) = (1 - cos (theta)) / 2
	private double havFunc (double theta) {
		return (1 - Math.cos(theta)) / 2;
	}
	
	//hav (omega) = hav (z2 - z1) + cos (z1) * cos (z2) * hav (l2 - l1)
	private double havForm () {
		return (havFunc (position2.lat - position1.lat) + Math.cos(position1.lat) * Math.cos(position2.lat) * havFunc (position2.lng - position1.lng));
	}

	// stored in radians.
	private class position {
		private double lat;
		private double lng;
		
		private position () {
			lat = 0;
			lng = 0;
		}
	}
	
	private position position1 = new position ();
	private position position2 = new position ();
}
