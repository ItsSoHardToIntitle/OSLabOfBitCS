/*
 * 
 */
package com.zz.gui;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

// TODO: Auto-generated Javadoc
/**
 * The Class SortBox.
 */
public class SortBox {
    
    /** The sort box. */
    private static Box sortBox = Box.createHorizontalBox();
    
    /** The choose sort label. */
    private static JLabel chooseSortLabel;
    
    /** The path sort button. */
    private static JRadioButton pathSortButton;
    
    /** The name sort button. */
    private static JRadioButton nameSortButton;
    
    /** The size sort button. */
    private static JRadioButton sizeSortButton;
    
    /** The date sort button. */
    private static JRadioButton dateSortButton;
    
    /** The format sort button. */
    private static JRadioButton formatSortButton;
    
    /** The sort button group. */
    private static ButtonGroup sortButtonGroup = new ButtonGroup();
    
    /** The reverse check box. */
    private static JCheckBox reverseCheckBox;
    
    /** The reverse order. */
    private static boolean reverseOrder = false;

    /** The button font. */
    private static Font buttonFont = new Font("Œ¢»Ì—≈∫⁄", Font.PLAIN, 15);

    /**
     * Adds the sort box.
     */
    public static void addSortBox() {
        sortBox.add(Box.createHorizontalGlue());

        chooseSortLabel = new JLabel("—°‘Ò≈≈–Ú∑Ω Ω£∫");
        chooseSortLabel.setFont(buttonFont);
        sortBox.add(chooseSortLabel);

        nameSortButton = new JRadioButton("NAME");
        pathSortButton = new JRadioButton("PATH");
        sizeSortButton = new JRadioButton("SIZE");
        dateSortButton = new JRadioButton("DATE");
        formatSortButton = new JRadioButton("FORMAT");
        nameSortButton.setFont(buttonFont);
        pathSortButton.setFont(buttonFont);
        sizeSortButton.setFont(buttonFont);
        dateSortButton.setFont(buttonFont);
        formatSortButton.setFont(buttonFont);

        sortBox.add(nameSortButton);
        sortBox.add(pathSortButton);
        sortBox.add(sizeSortButton);
        sortBox.add(dateSortButton);
        sortBox.add(formatSortButton);

        sortButtonGroup.add(nameSortButton);
        sortButtonGroup.add(pathSortButton);
        sortButtonGroup.add(sizeSortButton);
        sortButtonGroup.add(dateSortButton);
        sortButtonGroup.add(formatSortButton);

        reverseCheckBox = new JCheckBox("∑¥–Ú");
        reverseCheckBox.setFont(buttonFont);
        sortBox.add(reverseCheckBox);

        nameSortButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MenuBar.getNameSortMenuItem().setSelected(true);
                Search.sortSearchResultMap(0);
            }
        });

        pathSortButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MenuBar.getPathSortMenuItem().setSelected(true);
                Search.sortSearchResultMap(1);
            }
        });

        sizeSortButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MenuBar.getSizeSortMenuItem().setSelected(true);
                Search.sortSearchResultMap(2);
            }
        });

        dateSortButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MenuBar.getDateSortMenuItem().setSelected(true);
                Search.sortSearchResultMap(3);
            }
        });

        formatSortButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MenuBar.getFormatSortMenuItem().setSelected(true);
                Search.sortSearchResultMap(4);
            }
        });

        reverseCheckBox.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                reverseOrder = reverseCheckBox.isSelected();
                if (nameSortButton.isSelected())
                    Search.sortSearchResultMap(0);
                if (pathSortButton.isSelected())
                    Search.sortSearchResultMap(1);
                if (sizeSortButton.isSelected())
                    Search.sortSearchResultMap(2);
                if (dateSortButton.isSelected())
                    Search.sortSearchResultMap(3);
                if (formatSortButton.isSelected())
                    Search.sortSearchResultMap(4);
            }
        });
    }

    /**
     * Gets the sort box.
     *
     * @return the sort box
     */
    public static Box getSortBox() {
        return sortBox;
    }

    /**
     * Gets the path sort button.
     *
     * @return the path sort button
     */
    public static JRadioButton getPathSortButton() {
        return pathSortButton;
    }

    /**
     * Gets the name sort button.
     *
     * @return the name sort button
     */
    public static JRadioButton getNameSortButton() {
        return nameSortButton;
    }

    /**
     * Gets the date sort button.
     *
     * @return the date sort button
     */
    public static JRadioButton getDateSortButton() {
        return dateSortButton;
    }

    /**
     * Gets the size sort button.
     *
     * @return the size sort button
     */
    public static JRadioButton getSizeSortButton() {
        return sizeSortButton;
    }

    /**
     * Gets the format sort button.
     *
     * @return the format sort button
     */
    public static JRadioButton getFormatSortButton() {
        return formatSortButton;
    }

    /**
     * Gets the reverse check box.
     *
     * @return the reverse check box
     */
    public static JCheckBox getReverseCheckBox() {
        return reverseCheckBox;
    }

    /**
     * Checks if is reverse order.
     *
     * @return true, if is reverse order
     */
    public static boolean isReverseOrder() {
        return reverseOrder;
    }

    /**
     * Sets the reverse order.
     *
     * @param reverseOrder the new reverse order
     */
    public static void setReverseOrder(boolean reverseOrder) {
        SortBox.reverseOrder = reverseOrder;
    }
}
