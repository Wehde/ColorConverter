package view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import model.HexColor;

/**  
* Kilian Wehde - kewehde
* CIS171 20517 WW1
* Apr 30, 2022  
*/

public class HexColorPanel extends JPanel{
	
	private JLabel colorLabel = new JLabel("Starting Color:");
	private JTextField colorInput = new JTextField(6);
	private ColorSwatch colorSwatch = new ColorSwatch();
	
	private JButton convertButton = new JButton("Convert");
	
	private JLabel grayLabel = new JLabel("Gray Color:");
	private JTextField grayOutput = new JTextField(6);
	private ColorSwatch graySwatch = new ColorSwatch();
	
	private JButton clearButton = new JButton("Clear");
	
	public HexColorPanel() {
		grayOutput.setEditable(false);
		
		colorSwatch.setPreferredSize(new Dimension(25, 25));
		graySwatch.setPreferredSize(new Dimension(25, 25));
		
		ConvertButtonListener convertListener = new ConvertButtonListener();
		convertButton.addActionListener(convertListener);
		
		ClearButtonListener clearListener = new ClearButtonListener();
		clearButton.addActionListener(clearListener);
		
		GroupLayout layout = new GroupLayout(this);
		this.setLayout(layout);
		
		layout.setAutoCreateGaps(true);
		layout.setAutoCreateContainerGaps(true);
		
		layout.setHorizontalGroup(
				layout.createSequentialGroup()
				      .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
					           .addComponent(colorLabel)
					           .addComponent(grayLabel))
				      .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
					           .addComponent(colorInput, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					           .addComponent(convertButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					           .addComponent(grayOutput, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					           .addComponent(clearButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
				      .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
					           .addComponent(colorSwatch)
					           .addComponent(graySwatch))
				      
				);
		
		layout.setVerticalGroup(
				layout.createSequentialGroup()
				      .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
				    		  .addComponent(colorLabel)
				    		  .addComponent(colorInput)
				    		  .addComponent(colorSwatch))
				      .addComponent(convertButton)
				      .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
				    		  .addComponent(grayLabel)
				    		  .addComponent(grayOutput)
				    		  .addComponent(graySwatch))
				      .addComponent(clearButton)
				);
		
	}
	
	class ConvertButtonListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			try {
				String input = colorInput.getText().toUpperCase();
				HexColor color = new HexColor(input);
				
				colorInput.setText(color.getHexColor());
				colorSwatch.changeColor(color.getColor());
				
				grayOutput.setText(color.getHexGray());
				graySwatch.changeColor(color.getGray());
				
			} catch (IllegalArgumentException ex) {
				resetFields();
				JOptionPane.showMessageDialog(new JFrame(), ex.getMessage());
			}
		}
		
	}
	
	class ClearButtonListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			resetFields();
		}
		
	}
	
	/**
	 * Resets the fields to their initial state.
	 */
	public void resetFields() {
		colorInput.setText("");
		grayOutput.setText("");
		colorSwatch.changeColor(Color.white);
		graySwatch.changeColor(Color.white);
	}
	
}
