/*
 * 
 */
package com.zz.gui;

import javax.swing.JTable;

import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellRenderer;

// TODO: Auto-generated Javadoc
/**
 * The Class Table.
 */
@SuppressWarnings("serial")
public class Table extends JTable {
    
    /**
     * Instantiates a new table.
     *
     * @param tableModel the table model
     */
    public Table(DefaultTableModel tableModel) {
        super(tableModel);

    }

    /* ���� Javadoc��
     * @see javax.swing.JTable#getTableHeader()
     */
    public JTableHeader getTableHeader() {
        JTableHeader tableHeader = super.getTableHeader();
        tableHeader.setReorderingAllowed(false);
        DefaultTableCellRenderer hr = (DefaultTableCellRenderer) tableHeader.getDefaultRenderer();// ��ñ��ͷ�ĵ�Ԫ�����
        hr.setHorizontalAlignment(DefaultTableCellRenderer.CENTER);
        return tableHeader;
    }

    /**
     * Gets the d cell renderer.
     *
     * @param columnClass the column class
     * @return the d cell renderer
     */
    public TableCellRenderer getDCellRenderer(Class<?> columnClass) {
        DefaultTableCellRenderer cr = (DefaultTableCellRenderer) super.getDefaultRenderer(columnClass);// ��ñ��ĵ�Ԫ�����
        cr.setHorizontalAlignment(DefaultTableCellRenderer.CENTER);
        return cr;

    }

    /* ���� Javadoc��
     * @see javax.swing.JTable#isCellEditable(int, int)
     */
    public boolean isCellEditable(int row, int column) {
        return false;
    }
}
