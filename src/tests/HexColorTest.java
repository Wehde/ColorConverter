package tests;

import model.HexColor;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.awt.Color;


/**  
* Kilian Wehde - kewehde
* CIS171 20517 WW1
* Apr 30, 2022  
*/

public class HexColorTest {
	//ParseHexColor
	@Test
	void testParseHexColorGood1() {
        HexColor test = new HexColor();
        test.parseHexColor("ABCDEF");
        assertEquals(171,test.getR());
        assertEquals(205,test.getG());
        assertEquals(239,test.getB());
	}
	@Test
	void testParseHexColorGood2() {
        HexColor test = new HexColor();
        test.parseHexColor("123456");
        assertEquals(18,test.getR());
        assertEquals(52,test.getG());
        assertEquals(86,test.getB());
	}
	@Test
	void testParseHexColorBadR() {
        HexColor test = new HexColor();
        Exception e = assertThrows(Exception.class, () -> test.parseHexColor("AP1234"));
        assertEquals("null is not a valid color", e.getMessage());

	}
	@Test
	void testParseHexColorBadG() {
        HexColor test = new HexColor();
        Exception e = assertThrows(Exception.class, () -> test.parseHexColor("12RR34"));
        assertEquals("null is not a valid color", e.getMessage());

	}@Test
	void testParseHexColorBadB() {
        HexColor test = new HexColor();
        Exception e = assertThrows(Exception.class, () -> test.parseHexColor("FFFFFG"));
        assertEquals("null is not a valid color", e.getMessage());
    }
	
	//Base10ToHex
	@Test
	void testBase10ToHex() {
		HexColor test = new HexColor();
		assertEquals('1', test.base10ToHex(1));
		assertEquals('2', test.base10ToHex(2));
		assertEquals('3', test.base10ToHex(3));
		assertEquals('4', test.base10ToHex(4));
		assertEquals('5', test.base10ToHex(5));
		assertEquals('6', test.base10ToHex(6));
		assertEquals('7', test.base10ToHex(7));
		assertEquals('8', test.base10ToHex(8));
		assertEquals('9', test.base10ToHex(9));
		assertEquals('A', test.base10ToHex(10));
		assertEquals('B', test.base10ToHex(11));
		assertEquals('C', test.base10ToHex(12));
		assertEquals('D', test.base10ToHex(13));
		assertEquals('E', test.base10ToHex(14));
		assertEquals('F', test.base10ToHex(15));
		assertEquals('R', test.base10ToHex(16));
		assertEquals('R', test.base10ToHex(-1));
		assertEquals('R', test.base10ToHex(-1000));
		assertEquals('R', test.base10ToHex(100));
	}
	
	//HexToBase10
	@Test
	void testHexToBase10() {
		HexColor test = new HexColor();
		assertEquals(1, test.hexToBase10('1'));
		assertEquals(2, test.hexToBase10('2'));
		assertEquals(3, test.hexToBase10('3'));
		assertEquals(4, test.hexToBase10('4'));
		assertEquals(5, test.hexToBase10('5'));
		assertEquals(6, test.hexToBase10('6'));
		assertEquals(7, test.hexToBase10('7'));
		assertEquals(8, test.hexToBase10('8'));
		assertEquals(9, test.hexToBase10('9'));
		assertEquals(10, test.hexToBase10('A'));
		assertEquals(11, test.hexToBase10('B'));
		assertEquals(12, test.hexToBase10('C'));
		assertEquals(13, test.hexToBase10('D'));
		assertEquals(14, test.hexToBase10('E'));
		assertEquals(15, test.hexToBase10('F'));
		assertEquals(-1000, test.hexToBase10('G'));
		assertEquals(-1000, test.hexToBase10('a'));
		assertEquals(-1000, test.hexToBase10('b'));
		assertEquals(-1000, test.hexToBase10('\n'));
	}
	
	//Constructor
	@Test
	void textConstructorGood() {
		HexColor test = new HexColor("ABCDEF");
		assertEquals("ABCDEF",test.getHexColor());
		assertEquals("C7C7C7",test.getHexGray());
		assertEquals(171,test.getR());
        assertEquals(205,test.getG());
        assertEquals(239,test.getB());
        assertEquals(new Color(171, 205, 239),test.getColor());
        assertEquals(new Color(199, 199, 199),test.getGray());
	}
	@Test
	void textConstructorBad1() {
		Exception e = assertThrows(Exception.class, () -> new HexColor("AP1234"));
        assertEquals("AP1234 is not a valid color", e.getMessage());
	}
	@Test
	void textConstructorBad2() {
		Exception e = assertThrows(Exception.class, () -> new HexColor("12345"));
        assertEquals("12345 is not a valid color. There should be 6 characters", e.getMessage());
	}
}
