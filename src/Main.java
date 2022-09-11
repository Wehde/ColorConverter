import javax.swing.JFrame;
import javax.swing.JPanel;

import view.HexColorPanel;

/**  
* Kilian Wehde - kewehde
* CIS171 20517 WW1
* Apr 30, 2022  
*/

public class Main {
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		JPanel panel = new HexColorPanel();
		
		frame.setTitle("GrayScale");
		frame.add(panel);
		frame.setSize(250, 200);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}
