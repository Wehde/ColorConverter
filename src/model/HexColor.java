package model;

import java.awt.Color;

/**  
* Kilian Wehde - kewehde
* CIS171 20517 WW1
* Apr 30, 2022  
*/

public class HexColor{
	//---------------------------------------Variables---------------------------------------
	private final double CONVERT_R = 0.299;
    private final double CONVERT_G = 0.587;
    private final double CONVERT_B = 0.114;
    private final double ROUND = 0.5;
    private final int BASE_16 = 16;
	private String hexColor, hexGray;
	private int r, g, b;
	private Color color, gray;
	
	//----------------------------------Getters and Setters----------------------------------
	public String getHexColor() {
		return hexColor;
	}
	public void setHexColor(String hexColor) {
		if (hexColor.length() == 6) {
			this.hexColor = hexColor;
		}
		else if (hexColor.length() == 0) {
			throw new IllegalArgumentException("The color field is empty");
		}
		else {
			throw new IllegalArgumentException(hexColor + " is not a valid color. There should be 6 characters");
		}
		parseHexColor(hexColor);
		this.color = new Color(this.r, this.g, this.b);
		int y = (int)((r * CONVERT_R) + (g * CONVERT_G) + (b * CONVERT_B) + ROUND);
        this.gray = new Color(y, y, y);
        this.hexGray = ("" + base10ToHex(y / BASE_16) + base10ToHex(y % BASE_16)).repeat(3);
	}
	public String getHexGray() {
		return hexGray;
	}
	public int getR() {
		return r;
	}
	private void setR(int r) {
		if (r < 0) {
			throw new IllegalArgumentException(hexColor + " is not a valid color");
		}
		else {
			this.r = r;
		}
	}
	public int getG() {
		return g;
	}
	private void setG(int g) {
		if (g < 0) {
			throw new IllegalArgumentException(hexColor + " is not a valid color");
		}
		else {
			this.g = g;
		}
	}
	public int getB() {
		return b;
	}
	private void setB(int b) {
		if (b < 0) {
			throw new IllegalArgumentException(hexColor + " is not a valid color");
		}
		else {
			this.b = b;
		}
	}
	public Color getColor() {
		return color;
	}
	public Color getGray() {
		return gray;
	}
	
	//--------------------------------------Constructors-------------------------------------
	/**
	 * Default no-arg constructor
	 */
	public HexColor() {
	}
	/**
	 * Constructor that takes one argument
	 * @param hexColor String of a color in hex.
	 */
	public HexColor(String hexColor) {
		setHexColor(hexColor);
	}

	
	//----------------------------------------Methods----------------------------------------
	/**
	 * Parses the hexColor string and sets the RGB values in the class
	 * @param hexColor
	 */
	public void parseHexColor(String hexColor) {
		int[] colorArray = new int[hexColor.length()];
		for(int i = 0; i < hexColor.length(); i++) {
			colorArray[i] = hexToBase10(hexColor.charAt(i));
		}
        setR(colorArray[0] * BASE_16 + colorArray[1]);
        setG(colorArray[2] * BASE_16 + colorArray[3]);
        setB(colorArray[4] * BASE_16 + colorArray[5]);
	}
	/**
     * Converts an integer to its corresponding hex character
     * @param base10 integer between 0-16
     * @return A character with the hex value of the integer provided. Will be 'R' if invalid
     */
	public char base10ToHex (int base10){
        return switch (base10) {
            case 0 -> '0';
            case 1 -> '1';
            case 2 -> '2';
            case 3 -> '3';
            case 4 -> '4';
            case 5 -> '5';
            case 6 -> '6';
            case 7 -> '7';
            case 8 -> '8';
            case 9 -> '9';
            case 10 -> 'A';
            case 11 -> 'B';
            case 12 -> 'C';
            case 13 -> 'D';
            case 14 -> 'E';
            case 15 -> 'F';
            default -> 'R';
        };
    }
    /**
     * Converts a hex character to its base 10 value
     * @param hex character of the hex value
     * @return An integer with the base10 equivalent to the hex character provided. Will be -1000 if invalid.
     */
	public int hexToBase10 (char hex){
        final int ERROR = -1000;
        return switch (hex) {
            case '0' -> 0;
            case '1' -> 1;
            case '2' -> 2;
            case '3' -> 3;
            case '4' -> 4;
            case '5' -> 5;
            case '6' -> 6;
            case '7' -> 7;
            case '8' -> 8;
            case '9' -> 9;
            case 'A' -> 10;
            case 'B' -> 11;
            case 'C' -> 12;
            case 'D' -> 13;
            case 'E' -> 14;
            case 'F' -> 15;
            default -> ERROR;
        };
	}
}
