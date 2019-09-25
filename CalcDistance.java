/*** 
 * This is a program which calculates the shortest distance (great circle) between two points on the earth
 * using latitude and longitude of the two points.
 * Input is either done by command line parameters:
 * CalcDistance [lat1][long1][lat2][long2]
 * or by just running CalcDistance and entering the values when requested
 * 
 * Inputs do not have degree symbols or cardinal direction (N, W, S, E) labels. They are inputted as decimal degrees (not mins, seconds).
 * For values that are in the S latitude, use negative numbers.
 * For example, if I was to input San Juan, Puerto Rico, it would be: 18.4655 -66.1057
 * 
 * This program uses the Haversine formula.  Info on this can be found: https://en.wikipedia.org/wiki/Haversine_formula
 * 
 * @author Tim Reed
 *  9/25/2019
 */

import java.util.Scanner;

public class CalcDistance {
	
	static public void main (String args []) {
		
		double []lat = new double [4];
		// uses console input
		if (args.length== 0)
		{
			Scanner in = new Scanner (System.in);
			for (int i = 0; i < 3; i += 2)
			{
				System.out.print ("Enter position " + (i/2+1)+ " coordinates, separated by a space. W and S are negatives: ");
				lat[i] = in.nextDouble();
				lat[i+1] = in.nextDouble();
			}
			in.close ();
		}
		// get positions from command line parameters
		else if (args.length == 4)
		{
			for (int i = 0; i < 4; ++i)
			{
				lat[i] = Double.parseDouble(args[i]);
			}
		}
		else // invalid use of command line parameters
		{
			System.out.println ("Usage: CalcDistance [lat1] [lng1] [lat2] [lng2]");
			System.exit(1);
		}
		
		/* Calculate the distance using the Haversine formula */
		Haversine calc = new Haversine ();
		double distance = calc.calculate (lat[0], lat [1], lat[2], lat[3]);
		System.out.println ("Distance between these two points is: " + distance + " miles.");
	}
}
