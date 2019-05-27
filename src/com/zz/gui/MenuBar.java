/*
 * 
 */
package com.zz.gui;

import java.awt.Dimension;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.io.File;

import javax.swing.ButtonGroup;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JTextArea;
import javax.swing.KeyStroke;
import javax.swing.RowFilter;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.filechooser.FileSystemView;

import com.zz.fileutil.FileUtil;
import com.zz.resultvisual.ResultVisual;

// TODO: Auto-generated Javadoc
/**
 * The Class MenuBar.
 */
public class MenuBar {

    /** The menu bar. */
    private static JMenuBar menuBar = new JMenuBar();
    
    /** The file menu. */
    private static JMenu fileMenu = new JMenu("  文件(F)  ");
    
    /** The edit menu. */
    private static JMenu editMenu = new JMenu("  编辑(E)  ");
    
    /** The search menu. */
    private static JMenu searchMenu = new JMenu("  搜索(S)  ");
    
    /** The help menu. */
    private static JMenu helpMenu = new JMenu("  帮助(H)  ");

    /** The choose file menu item. */
    private static JMenuItem chooseFileMenuItem = new JMenuItem("选择文件夹");
    
    /** The visual menu group. */
    private static ButtonGroup visualMenuGroup = new ButtonGroup();
    
    /** The specific histogram menu item. */
    private static JRadioButtonMenuItem specificHistogramMenuItem = new JRadioButtonMenuItem("具体种类柱状图");
    
    /** The kind histogram menu item. */
    private static JRadioButtonMenuItem kindHistogramMenuItem = new JRadioButtonMenuItem("大类柱状图");
    
    /** The specific pie menu item. */
    private static JRadioButtonMenuItem specificPieMenuItem = new JRadioButtonMenuItem("具体种类饼图");
    
    /** The kind pie menu item. */
    private static JRadioButtonMenuItem kindPieMenuItem = new JRadioButtonMenuItem("大类饼图");
    
    /** The exit menu item. */
    private static JMenuItem exitMenuItem = new JMenuItem("退出          ");

    /** The open file menu item. */
    private static JMenuItem openFileMenuItem = new JMenuItem("打开文件      ");
    
    /** The copy file menu item. */
    private static JMenuItem copyFileMenuItem = new JMenuItem("复制文件");
    
    /** The delete file menu item. */
    private static JMenuItem deleteFileMenuItem = new JMenuItem("删除文件");
    
    /** The rename file menu item. */
    private static JMenuItem renameFileMenuItem = new JMenuItem("重命名文件");
    
    /** The open dir menu item. */
    private static JMenuItem openDirMenuItem = new JMenuItem("打开文件夹");
    
    /** The copy dir menu item. */
    private static JMenuItem copyDirMenuItem = new JMenuItem("复制文件夹");
    
    /** The delete dir menu item. */
    private static JMenuItem deleteDirMenuItem = new JMenuItem("删除文件夹");
    
    /** The rename dir menu item. */
    private static JMenuItem renameDirMenuItem = new JMenuItem("重命名文件夹");

    /** The search file menu item. */
    private static JMenuItem searchFileMenuItem = new JMenuItem("搜索          ");
    
    /** The part search menu item. */
    private static JRadioButtonMenuItem partSearchMenuItem = new JRadioButtonMenuItem("部分匹配", true);
    
    /** The regex search menu item. */
    private static JRadioButtonMenuItem regexSearchMenuItem = new JRadioButtonMenuItem("正则匹配");
    
    /** The entire search menu item. */
    private static JRadioButtonMenuItem entireSearchMenuItem = new JRadioButtonMenuItem("完全匹配");
    
    /** The suffix search menu item. */
    private static JRadioButtonMenuItem suffixSearchMenuItem = new JRadioButtonMenuItem("后缀名匹配");
    
    /** The search menu group. */
    private static ButtonGroup searchMenuGroup = new ButtonGroup();
    
    /** The path sort menu item. */
    private static JRadioButtonMenuItem pathSortMenuItem = new JRadioButtonMenuItem("按路径排序");
    
    /** The name sort menu item. */
    private static JRadioButtonMenuItem nameSortMenuItem = new JRadioButtonMenuItem("按名字排序");
    
    /** The size sort menu item. */
    private static JRadioButtonMenuItem sizeSortMenuItem = new JRadioButtonMenuItem("按大小排序");
    
    /** The date sort menu item. */
    private static JRadioButtonMenuItem dateSortMenuItem = new JRadioButtonMenuItem("按修改日期排序");
    
    /** The format sort menu item. */
    private static JRadioButtonMenuItem formatSortMenuItem = new JRadioButtonMenuItem("按文件格式排序");
    
    /** The sort menu group. */
    private static ButtonGroup sortMenuGroup = new ButtonGroup();
    
    /** The reverse menu item. */
    private static JCheckBoxMenuItem reverseMenuItem = new JCheckBoxMenuItem("反序");

    /** The about menu item. */
    private static JMenuItem aboutMenuItem = new JMenuItem("关于...");
    
    /** The help file menu item. */
    private static JMenuItem helpFileMenuItem = new JMenuItem("帮助          ");

    /** The menu font. */
    private static Font menuFont = new Font("微软雅黑", Font.PLAIN, 16);
    
    /** The menu item font. */
    private static Font menuItemFont = new Font("微软雅黑", Font.PLAIN, 14);
    
    /** The label font. */
    private static Font labelFont = new Font("新宋体", Font.PLAIN, 18);

    /** The search mode. */
    private static String searchMode = "part";

    /**
     * Adds the menu bar.
     */
    public static void addMenuBar() {
        GUI.getjFrame().setJMenuBar(menuBar);
        menuBar.add(fileMenu);
        menuBar.add(editMenu);
        menuBar.add(searchMenu);
        menuBar.add(helpMenu);
        fileMenu.setFont(menuFont);
        editMenu.setFont(menuFont);
        searchMenu.setFont(menuFont);
        helpMenu.setFont(menuFont);
        fileMenu.setMnemonic('F');
        editMenu.setMnemonic('E');
        searchMenu.setMnemonic('S');
        helpMenu.setMnemonic('H');

        fileMenu.add(chooseFileMenuItem);
        fileMenu.addSeparator();
        fileMenu.add(specificHistogramMenuItem);
        fileMenu.add(kindHistogramMenuItem);
        fileMenu.add(specificPieMenuItem);
        fileMenu.add(kindPieMenuItem);
        fileMenu.addSeparator();
        fileMenu.add(exitMenuItem);
        chooseFileMenuItem.setFont(menuItemFont);
        specificHistogramMenuItem.setFont(menuItemFont);
        kindHistogramMenuItem.setFont(menuItemFont);
        specificPieMenuItem.setFont(menuItemFont);
        kindPieMenuItem.setFont(menuItemFont);
        exitMenuItem.setFont(menuItemFont);
        chooseFileMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_B, InputEvent.CTRL_MASK));
        exitMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, InputEvent.CTRL_DOWN_MASK));
        specificHistogramMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F1, InputEvent.CTRL_MASK));
        kindHistogramMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F2, InputEvent.CTRL_MASK));
        specificPieMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F3, InputEvent.CTRL_MASK));
        kindPieMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F4, InputEvent.CTRL_MASK));

        visualMenuGroup.add(specificHistogramMenuItem);
        visualMenuGroup.add(kindHistogramMenuItem);
        visualMenuGroup.add(specificPieMenuItem);
        visualMenuGroup.add(kindPieMenuItem);

        editMenu.add(openFileMenuItem);
        editMenu.add(copyFileMenuItem);
        editMenu.add(deleteFileMenuItem);
        editMenu.add(renameFileMenuItem);
        openFileMenuItem.setFont(menuItemFont);
        copyFileMenuItem.setFont(menuItemFont);
        deleteFileMenuItem.setFont(menuItemFont);
        renameFileMenuItem.setFont(menuItemFont);
        openFileMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, InputEvent.CTRL_DOWN_MASK));
        copyFileMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, InputEvent.CTRL_DOWN_MASK));
        deleteFileMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D, InputEvent.CTRL_DOWN_MASK));
        renameFileMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_R, InputEvent.CTRL_DOWN_MASK));
        openFileMenuItem.setEnabled(false);
        copyFileMenuItem.setEnabled(false);
        deleteFileMenuItem.setEnabled(false);
        renameFileMenuItem.setEnabled(false);

        editMenu.addSeparator();
        editMenu.add(openDirMenuItem);
        editMenu.add(copyDirMenuItem);
        editMenu.add(deleteDirMenuItem);
        editMenu.add(renameDirMenuItem);
        openDirMenuItem.setFont(menuItemFont);
        copyDirMenuItem.setFont(menuItemFont);
        deleteFileMenuItem.setFont(menuItemFont);
        renameDirMenuItem.setFont(menuItemFont);
        openDirMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, InputEvent.ALT_MASK));
        copyDirMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, InputEvent.ALT_MASK));
        deleteDirMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D, InputEvent.ALT_MASK));
        renameDirMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_R, InputEvent.ALT_MASK));
        openDirMenuItem.setEnabled(false);
        copyDirMenuItem.setEnabled(false);
        deleteDirMenuItem.setEnabled(false);
        renameDirMenuItem.setEnabled(false);

        searchMenu.add(searchFileMenuItem);
        searchFileMenuItem.setEnabled(false);

        searchMenu.addSeparator();
        searchMenu.add(partSearchMenuItem);
        searchMenu.add(regexSearchMenuItem);
        searchMenu.add(entireSearchMenuItem);
        searchMenu.add(suffixSearchMenuItem);
        partSearchMenuItem.setFont(menuItemFont);
        regexSearchMenuItem.setFont(menuItemFont);
        entireSearchMenuItem.setFont(menuItemFont);
        suffixSearchMenuItem.setFont(menuItemFont);
        partSearchMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_1, InputEvent.CTRL_MASK));
        regexSearchMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_2, InputEvent.CTRL_MASK));
        entireSearchMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_3, InputEvent.CTRL_MASK));
        suffixSearchMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_4, InputEvent.CTRL_MASK));

        searchMenuGroup.add(partSearchMenuItem);
        searchMenuGroup.add(regexSearchMenuItem);
        searchMenuGroup.add(entireSearchMenuItem);
        searchMenuGroup.add(suffixSearchMenuItem);

        searchMenu.addSeparator();
        searchMenu.add(nameSortMenuItem);
        searchMenu.add(pathSortMenuItem);
        searchMenu.add(sizeSortMenuItem);
        searchMenu.add(dateSortMenuItem);
        searchMenu.add(formatSortMenuItem);
        searchFileMenuItem.setFont(menuItemFont);
        pathSortMenuItem.setFont(menuItemFont);
        nameSortMenuItem.setFont(menuItemFont);
        sizeSortMenuItem.setFont(menuItemFont);
        dateSortMenuItem.setFont(menuItemFont);
        formatSortMenuItem.setFont(menuItemFont);
        searchFileMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_MASK));
        pathSortMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P, InputEvent.CTRL_DOWN_MASK));
        nameSortMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, InputEvent.CTRL_DOWN_MASK));
        sizeSortMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_L, InputEvent.CTRL_DOWN_MASK));
        dateSortMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_T, InputEvent.CTRL_DOWN_MASK));
        formatSortMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F, InputEvent.CTRL_DOWN_MASK));

        sortMenuGroup.add(pathSortMenuItem);
        sortMenuGroup.add(nameSortMenuItem);
        sortMenuGroup.add(sizeSortMenuItem);
        sortMenuGroup.add(dateSortMenuItem);
        sortMenuGroup.add(formatSortMenuItem);

        searchMenu.add(reverseMenuItem);
        reverseMenuItem.setFont(menuItemFont);
        reverseMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V, InputEvent.CTRL_MASK));
        reverseMenuItem.setSelected(false);

        helpMenu.add(aboutMenuItem);
        helpMenu.add(helpFileMenuItem);
        aboutMenuItem.setFont(menuItemFont);
        helpFileMenuItem.setFont(menuItemFont);
        aboutMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, InputEvent.CTRL_DOWN_MASK));
        helpFileMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_H, InputEvent.CTRL_DOWN_MASK));

        chooseFileMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GUI.chooseSearchDir();
            }
        });

        specificHistogramMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ResultVisual.showBarChart(10);
            }
        });

        kindHistogramMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ResultVisual.showBarChart(11);
            }
        });

        specificPieMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ResultVisual.showPiChart(20);
            }
        });

        kindPieMenuItem.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                ResultVisual.showPiChart(21);
            }
        });

        exitMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        openFileMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int row = GUI.getSearchResultTable().getSelectedRow();
                String selectedData = (String) GUI.getSearchResultTable().getValueAt(row, 1);
                FileUtil.openFile(selectedData, true);
            }
        });

        copyFileMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int row = GUI.getSearchResultTable().getSelectedRow();
                String selectedData = (String) GUI.getSearchResultTable().getValueAt(row, 1);
                FileSystemView fileSystemView = FileSystemView.getFileSystemView();
                JFileChooser jFileChooser = new JFileChooser();
                jFileChooser.setCurrentDirectory(fileSystemView.getHomeDirectory());
                jFileChooser.setFileSelectionMode(JFileChooser.SAVE_DIALOG | JFileChooser.DIRECTORIES_ONLY);
                SwingUtilities.updateComponentTreeUI(jFileChooser);
                int val = jFileChooser.showSaveDialog(null);
                if (val == JFileChooser.APPROVE_OPTION) {
                    File fileChosen = jFileChooser.getSelectedFile();
                    FileUtil.singleFileCopy(selectedData, fileChosen.getAbsolutePath());
                }
            }
        });

        deleteFileMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int row = GUI.getSearchResultTable().getSelectedRow();
                String selectedData = (String) GUI.getSearchResultTable().getValueAt(row, 1);
                FileUtil.deleteSingleFile(selectedData);
                GUI.getDefaultTableModel().setRowCount(0);
                Search.startSearch();
            }
        });

        renameFileMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int row = GUI.getSearchResultTable().getSelectedRow();
                String selectedData = (String) GUI.getSearchResultTable().getValueAt(row, 1);
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException
                        | UnsupportedLookAndFeelException e1) {
                    e1.printStackTrace();
                }
                String newName = JOptionPane.showInputDialog(null, "请输入新的文件名(包含后缀)：\n", "reName",
                        JOptionPane.PLAIN_MESSAGE);
                System.out.println(newName);
                if (newName != null) {
                    FileUtil.renameFile(selectedData, newName);
                    GUI.getDefaultTableModel().setRowCount(0);
                    Search.startSearch();
                }
            }
        });

        openDirMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int row = GUI.getSearchResultTable().getSelectedRow();
                String selectedData = (String) GUI.getSearchResultTable().getValueAt(row, 1);
                FileUtil.openFile(selectedData, false);
            }
        });

        copyDirMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int row = GUI.getSearchResultTable().getSelectedRow();
                String selectedData = (String) GUI.getSearchResultTable().getValueAt(row, 1);
                FileSystemView fileSystemView = FileSystemView.getFileSystemView();
                JFileChooser jFileChooser = new JFileChooser();
                jFileChooser.setCurrentDirectory(fileSystemView.getHomeDirectory());
                jFileChooser.setFileSelectionMode(JFileChooser.SAVE_DIALOG | JFileChooser.DIRECTORIES_ONLY);
                SwingUtilities.updateComponentTreeUI(jFileChooser);
                int val = jFileChooser.showSaveDialog(null);
                if (val == JFileChooser.APPROVE_OPTION) {
                    File fileChosen = jFileChooser.getSelectedFile();
                    String srcPathSelectedStr = selectedData.substring(0, selectedData.lastIndexOf("\\"));
                    FileUtil.dirCopy(srcPathSelectedStr, fileChosen.getAbsolutePath());
                }
            }
        });

        deleteDirMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int row = GUI.getSearchResultTable().getSelectedRow();
                String selectedData = (String) GUI.getSearchResultTable().getValueAt(row, 1);
                selectedData.substring(0, selectedData.lastIndexOf("\\"));
                FileUtil.deleteFile(selectedData, false);
                GUI.getDefaultTableModel().setRowCount(0);
                Search.startSearch();
            }
        });

        renameDirMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int row = GUI.getSearchResultTable().getSelectedRow();
                String selectedData = (String) GUI.getSearchResultTable().getValueAt(row, 1);
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException
                        | UnsupportedLookAndFeelException e1) {
                    e1.printStackTrace();
                }
                String newName = JOptionPane.showInputDialog(null, "请输入新的文件夹名：\n", "reName", JOptionPane.PLAIN_MESSAGE);
                System.out.println(newName);
                if (newName != null) {
                    FileUtil.renameFile(selectedData.substring(0, selectedData.lastIndexOf("\\")), newName);
                    GUI.getDefaultTableModel().setRowCount(0);
                    Search.startSearch();
                }
            }
        });

        searchFileMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String notExistText = GUI.getNotExistTextField().getText();
                GUI.getTableRowSorter().setRowFilter(null);
                GUI.getDefaultTableModel().setRowCount(0);

                if (notExistText.isEmpty()) {
                    if (!GUI.getSelectedRegex().equals(""))
                        GUI.getTableRowSorter().setRowFilter(RowFilter.regexFilter(GUI.getSelectedRegex(), 0));
                } else {
                    if (GUI.getSelectedRegex().equals(""))
                        GUI.getTableRowSorter()
                                .setRowFilter(RowFilter.regexFilter("^((?!" + notExistText + ").)*$", 0));
                    else
                        GUI.getTableRowSorter().setRowFilter(
                                RowFilter.regexFilter("^((?!" + notExistText + ").)*" + GUI.getSelectedRegex(), 0));
                }

                Search.startSearch();
            }
        });

        partSearchMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                searchMode = "part";
            }
        });

        regexSearchMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                searchMode = "regex";
            }
        });

        entireSearchMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                searchMode = "complete";
            }
        });

        suffixSearchMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                searchMode = "suffix";
            }
        });

        nameSortMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SortBox.getNameSortButton().setSelected(true);
                Search.sortSearchResultMap(0);
            }
        });

        pathSortMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SortBox.getPathSortButton().setSelected(true);
                Search.sortSearchResultMap(1);
            }
        });

        sizeSortMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SortBox.getSizeSortButton().setSelected(true);
                Search.sortSearchResultMap(2);
            }
        });

        dateSortMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SortBox.getDateSortButton().setSelected(true);
                Search.sortSearchResultMap(3);
            }
        });

        formatSortMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SortBox.getFormatSortButton().setSelected(true);
                Search.sortSearchResultMap(4);
            }
        });

        reverseMenuItem.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent arg0) {
                SortBox.setReverseOrder(reverseMenuItem.isSelected());
                SortBox.getReverseCheckBox().setSelected(reverseMenuItem.isSelected());
                if (SortBox.getNameSortButton().isSelected())
                    Search.sortSearchResultMap(0);
                if (SortBox.getPathSortButton().isSelected())
                    Search.sortSearchResultMap(1);
                if (SortBox.getSizeSortButton().isSelected())
                    Search.sortSearchResultMap(2);
                if (SortBox.getDateSortButton().isSelected())
                    Search.sortSearchResultMap(3);
                if (SortBox.getFormatSortButton().isSelected())
                    Search.sortSearchResultMap(4);
            }
        });

        aboutMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JTextArea jTextArea = new JTextArea();
                JFrame aboutFrame = new JFrame("关于……");
                aboutFrame.add(jTextArea);
                aboutFrame.setLocationRelativeTo(null);
                aboutFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                aboutFrame.setSize(new Dimension(300, 200));
                aboutFrame.setResizable(false);
                aboutFrame.setVisible(true);

                String aboutString = "小组成员：\r\n" + "组长：张嘉琦_1120161793_07111603\r\n" + "组员：张圳_1120161795_07111603\r\n"
                        + "组员：艾若琳_1120161768_07111601\r\n" + "组员：高钒骐_1120161650_07111601\r\n";
                jTextArea.setText(aboutString);
            }
        });

        helpFileMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame helpFrame = new JFrame("帮助");
                helpFrame.setLocationRelativeTo(null);
                helpFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                helpFrame.setSize(new Dimension(500, 300));
                helpFrame.setResizable(false);
                helpFrame.setVisible(true);

                String helpString = "这是一个帮助窗口，并且显然没什么卵用。";

                JLabel helpLabel = new JLabel(helpString);
                helpLabel.setFont(labelFont);
                helpLabel.setHorizontalAlignment(JLabel.CENTER);
                helpFrame.add(helpLabel);
            }
        });
    }

    /**
     * Gets the name sort menu item.
     *
     * @return the name sort menu item
     */
    public static JRadioButtonMenuItem getNameSortMenuItem() {
        return nameSortMenuItem;
    }

    /**
     * Gets the path sort menu item.
     *
     * @return the path sort menu item
     */
    public static JRadioButtonMenuItem getPathSortMenuItem() {
        return pathSortMenuItem;
    }

    /**
     * Gets the size sort menu item.
     *
     * @return the size sort menu item
     */
    public static JRadioButtonMenuItem getSizeSortMenuItem() {
        return sizeSortMenuItem;
    }

    /**
     * Gets the date sort menu item.
     *
     * @return the date sort menu item
     */
    public static JRadioButtonMenuItem getDateSortMenuItem() {
        return dateSortMenuItem;
    }

    /**
     * Gets the format sort menu item.
     *
     * @return the format sort menu item
     */
    public static JRadioButtonMenuItem getFormatSortMenuItem() {
        return formatSortMenuItem;
    }

    /**
     * Gets the search file menu item.
     *
     * @return the search file menu item
     */
    public static JMenuItem getSearchFileMenuItem() {
        return searchFileMenuItem;
    }

    /**
     * Gets the open file menu item.
     *
     * @return the open file menu item
     */
    public static JMenuItem getOpenFileMenuItem() {
        return openFileMenuItem;
    }

    /**
     * Gets the copy file menu item.
     *
     * @return the copy file menu item
     */
    public static JMenuItem getCopyFileMenuItem() {
        return copyFileMenuItem;
    }

    /**
     * Gets the rename file menu item.
     *
     * @return the rename file menu item
     */
    public static JMenuItem getRenameFileMenuItem() {
        return renameFileMenuItem;
    }

    /**
     * Gets the delete file menu item.
     *
     * @return the delete file menu item
     */
    public static JMenuItem getDeleteFileMenuItem() {
        return deleteFileMenuItem;
    }

    /**
     * Gets the open dir menu item.
     *
     * @return the open dir menu item
     */
    public static JMenuItem getOpenDirMenuItem() {
        return openDirMenuItem;
    }

    /**
     * Gets the copy dir menu item.
     *
     * @return the copy dir menu item
     */
    public static JMenuItem getCopyDirMenuItem() {
        return copyDirMenuItem;
    }

    /**
     * Gets the rename dir menu item.
     *
     * @return the rename dir menu item
     */
    public static JMenuItem getRenameDirMenuItem() {
        return renameDirMenuItem;
    }

    /**
     * Gets the delete dir menu item.
     *
     * @return the delete dir menu item
     */
    public static JMenuItem getDeleteDirMenuItem() {
        return deleteDirMenuItem;
    }

    /**
     * Gets the search mode.
     *
     * @return the search mode
     */
    public static String getSearchMode() {
        return searchMode;
    }
}
