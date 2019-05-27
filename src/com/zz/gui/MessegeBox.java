/*
 * 
 */
package com.zz.gui;

import java.awt.Font;

import javax.swing.Box;
import javax.swing.JLabel;

// TODO: Auto-generated Javadoc
/**
 * The Class MessegeBox.
 */
public class MessegeBox {
	
	/** The messege box. */
	private static Box messegeBox = Box.createHorizontalBox();
	
	/** The time label. */
	private static JLabel timeLabel;
	
	/** The size label. */
	private static JLabel sizeLabel;
    
    /** The label font. */
    private static Font labelFont = new Font("新宋体", Font.PLAIN, 18);
	
	/**
	 * Adds the messege box.
	 */
	public static void addMessegeBox() {
		timeLabel = new JLabel();
		sizeLabel = new JLabel();
		timeLabel.setFont(labelFont);
		sizeLabel.setFont(labelFont);
		String time = "搜索时间：" + String.valueOf(0) + "ms";
		String size = "条目数量：" + String.valueOf(0);
		timeLabel.setText(time);
		sizeLabel.setText(size);
		
		messegeBox.add(timeLabel);
		messegeBox.add(Box.createHorizontalGlue());
		messegeBox.add(sizeLabel);
	}
	
	/**
	 * Gets the messege box.
	 *
	 * @return the messege box
	 */
	public static Box getMessegeBox() {
		return messegeBox;
	}
	
	/**
	 * Gets the time label.
	 *
	 * @return the time label
	 */
	public static JLabel getTimeLabel() {
		return timeLabel;
	}
	
	/**
	 * Gets the size label.
	 *
	 * @return the size label
	 */
	public static JLabel getSizeLabel() {
		return sizeLabel;
	}
}
