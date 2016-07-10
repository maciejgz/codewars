package pl.mg.codewars;

import java.awt.image.SinglePixelPackedSampleModel;

/**
 * When landing an airplane manually, the pilot knows which runway he is using and usually has up to date wind information (speed and direction). This information alone does not help the pilot make a safe landing; what the pilot really needs to know is the speed of headwind, how much crosswind there is and from which side the crosswind is blowing relative to the plane.
 * <p/>
 * Let's imagine there is a system in the ATC tower with speech recognition that works so that when a pilot says "wind info" over the comms, the system will respond with a helpful message about the wind.
 * <p/>
 * Your task is to write a function that produces the response before it is fed into the text-to-speech engine.
 * <p/>
 * Input:
 * <p/>
 * runway (string: "NN[L/C/R]"). NN is the runway's heading in tens of degrees. A suffix of L, C or R may be present and should be ignored. NN is between 01 and 36.
 * wind_direction (int). Direction wind is blowing from in degrees. Between 0 and 359.
 * wind_speed (int). Wind speed in knots
 * Output:
 * <p/>
 * a string in the following format: "(Head|Tail)wind N knots. Crosswind N knots from your (left|right)."
 * The wind speeds must be correctly rounded integers. If the rounded headwind component is 0, "Head" should be used. Similarly, "right" in case crosswind component is 0.
 * <p/>
 * Calculating crosswind and headwind:
 * <p/>
 * A = Angle of the wind from the direction of travel (radians)
 * WS = Wind speed
 * CW = Crosswind
 * HW = Headwind
 * <p/>
 * CW = sin(A) * WS
 * HW = cos(A) * WS
 * Created by Maciej Gzik on 2015-07-01.
 */
public class WindCalculator {


    public static String calculateWind(String rwy, int windDirection, int windSpeed) {
        String result = null;
        //runaway
        if (rwy.charAt(rwy.length() - 1) == 'L' || rwy.charAt(rwy.length() - 1) == 'C'
                || rwy.charAt(rwy.length() - 1) == 'R') {
            rwy = rwy.substring(0, rwy.length() - 1);
        }

        float cw = (float) (Math.sin(Math.toRadians(getAngle(Double.parseDouble(rwy), windDirection))) * windSpeed);
        float hw = (float) (Math.cos(Math.toRadians(getAngle(Double.parseDouble(rwy), windDirection))) * windSpeed);

        //head/tail
        String front = "";
        if ((getAngle(Double.parseDouble(rwy), windDirection)) < 90
                || (getAngle(Double.parseDouble(rwy), windDirection)) > 270) {
            front = "Head";
        } else {
            front = "Tail";
        }

        //right/left
        String side = "";
        if ((getAngle(Double.parseDouble(rwy), windDirection)) < 180) {
            side = "right";
        } else {
            side = "left";
        }

        result = front + "wind " + (int) hw + " knots. Crosswind " + (int) cw + " knots from your " + side + ".";

        return result;
    }

    public static double getAngle(double runawayDirection, int windDirection) {
        double result = 0.0;
        if (windDirection < runawayDirection) {
            result = 360 - runawayDirection + windDirection;
        } else {
            result = windDirection - runawayDirection;
        }
        return result;
    }
}
