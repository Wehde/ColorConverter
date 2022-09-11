package view;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.*;

/**  
* Kilian Wehde - kewehde
* CIS171 20517 WW1
* Apr 30, 2022  
*/

public class ColorSwatch extends JComponent{
	Color color = Color.white;

	public void paintComponent(Graphics g) {
		g.setColor(color);
		g.fillRect(0, 0, 25, 25);
	}
	
	public void changeColor(Color newColor) {
		color = newColor;
		repaint();
	}
}
