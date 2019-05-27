/*
 * 
 */
package com.zz.gui;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

// TODO: Auto-generated Javadoc
/**
 * The Class TableRenderer.
 */
public class TableRenderer extends DefaultTableCellRenderer {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 1L;

    /* £¨·Ç Javadoc£©
     * @see javax.swing.table.DefaultTableCellRenderer#getTableCellRendererComponent(javax.swing.JTable, java.lang.Object, boolean, boolean, int, int)
     */
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
            int row, int column) {
        JLabel label = new JLabel();
        label.setOpaque(true);
        label.setFont(new Font("ÐÂËÎÌå", Font.PLAIN, 16));

        String name = table.getValueAt(row, 0).toString();
        int s = Integer.parseInt(name.substring(0, 1));

        switch (s) {
        case 1:
            if (row % 2 == 0)
                label.setBackground(new Color(254, 206, 254));
            else
                label.setBackground(new Color(253, 230, 253));
            break;
        case 2:
            if (row % 2 == 0)
                label.setBackground(new Color(217, 255, 198));
            else
                label.setBackground(new Color(234, 255, 234));
            break;
        case 3:
            if (row % 2 == 0)
                label.setBackground(new Color(205, 255, 255));
            else
                label.setBackground(new Color(240, 250, 250));
            break;
        case 4:
            if (row % 2 == 0)
                label.setBackground(new Color(255, 254, 210));
            else
                label.setBackground(new Color(255, 255, 232));
            break;
        case 5:
            if (row % 2 == 0)
                label.setBackground(new Color(255, 228, 185));
            else
                label.setBackground(new Color(255, 245, 229));
            break;
        case 6:
            if (row % 2 == 0)
                label.setBackground(new Color(255, 208, 208));
            else
                label.setBackground(new Color(255, 230, 230));
            break;
        case 7:
            if (row % 2 == 0)
                label.setBackground(new Color(194, 197, 255));
            else
                label.setBackground(new Color(229, 230, 255));
            break;
        case 8:
            if (row % 2 == 0)
                label.setBackground(new Color(230, 230, 230));
            else
                label.setBackground(new Color(245, 245, 245));
            break;
        }

        if (isSelected) {
            label.setBackground(Color.BLACK);
            label.setForeground(Color.WHITE);
        }

        if (column == 0)
            label.setText(value != null ? value.toString().substring(2) : "");
        else
            label.setText(value != null ? value.toString() : "");
        return label;
    }
}
