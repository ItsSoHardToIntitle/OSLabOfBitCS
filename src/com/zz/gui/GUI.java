/*
 * 
 */
package com.zz.gui;

import java.awt.Color;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.RowFilter;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.filechooser.FileSystemView;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.table.TableRowSorter;

import com.zz.fileutil.FileUtil;
import com.zz.sortuitl.DefaultSortUtil;

// TODO: Auto-generated Javadoc
/**
 * The Class GUI.
 */
public class GUI {
    
    /** The gui. */
    private static GUI gui;
    
    /** The j frame. */
    private static JFrame jFrame = new JFrame("OSLab");
    
    /** The main box. */
    private static Box mainBox;

    /** The file box. */
    private static Box fileBox;
    
    /** The choose file button. */
    private static JButton chooseFileButton;
    
    /** The choose file label. */
    private static JLabel chooseFileLabel;
    
    /** The has chosen. */
    private static boolean hasChosen = false;

    /** The search box. */
    private static Box searchBox;
    
    /** The input text field. */
    private static JTextField inputTextField;
    
    /** The search button. */
    private static JButton searchButton;
    
    /** The clear button. */
    private static JButton clearButton;

    /** The filter box. */
    private static Box filterBox;
    
    /** The filter label. */
    private static JLabel filterLabel;
    
    /** The not exist label. */
    private static JLabel notExistLabel;
    
    /** The not exist text field. */
    private static JTextField notExistTextField;
    
    /** The choose format label. */
    private static JLabel chooseFormatLabel;
    
    /** The format combo box. */
    private static JComboBox<Object> formatComboBox;

    /** The selected regex. */
    private static String selectedRegex = "";

    /** The search result scroll pane. */
    private static JScrollPane searchResultScrollPane;
    
    /** The search result table. */
    private static Table searchResultTable; // ***此处的MyTable继承自JTable，设定该表格不可编辑（但可以选择）
    
    /** The default table model. */
    private static DefaultTableModel defaultTableModel;

    /** The table row sorter. */
    private static TableRowSorter<DefaultTableModel> tableRowSorter;

    /** The popup menu. */
    private static JPopupMenu popupMenu;
    
    /** The open menu item. */
    private static JMenuItem openMenuItem;
    
    /** The copy menu item. */
    private static JMenuItem copyMenuItem;
    
    /** The rename menu item. */
    private static JMenuItem renameMenuItem;
    
    /** The delete menu item. */
    private static JMenuItem deleteMenuItem;

    /** The popup dir menu. */
    private static JPopupMenu popupDirMenu;
    
    /** The open dir menu item. */
    private static JMenuItem openDirMenuItem;
    
    /** The copy dir menu item. */
    private static JMenuItem copyDirMenuItem;
    
    /** The rename dir menu item. */
    private static JMenuItem renameDirMenuItem;
    
    /** The delete dir menu item. */
    private static JMenuItem deleteDirMenuItem;

    /** The j file chooser. */
    private static JFileChooser jFileChooser;

    /** The point. */
    private static Point point = null;
    
    /** The row no. */
    private static int rowNo = 0;
    
    /** The col no. */
    private static int colNo = 0;
    
    /** The selected data. */
    private static String selectedData = null;
    
    /** The is file. */
    private static boolean isFile = true;

    /** The menu item font. */
    private static Font menuItemFont = new Font("微软雅黑", Font.PLAIN, 14);
    
    /** The button font. */
    private static Font buttonFont = new Font("微软雅黑", Font.PLAIN, 15);
    
    /** The label font. */
    private static Font labelFont = new Font("新宋体", Font.PLAIN, 18);
    
    /** The input font. */
    private static Font inputFont = new Font("新宋体", Font.PLAIN, 16);
    
    /** The result font. */
    private static Font resultFont = new Font("新宋体", Font.PLAIN, 14);
    
    /** The head font. */
    private static Font headFont = new Font("新宋体", Font.BOLD, 15);

    /**
     * Inits the.
     */
    public void init() {
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        } catch (Exception exception) {
            exception.printStackTrace();
        }

        jFrame.setSize(600, 600);
        jFrame.setLocationRelativeTo(null);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        jFrame.setMinimumSize(new Dimension(600, 400));
        MenuBar.addMenuBar();

        mainBox = Box.createVerticalBox();
        fileBox = Box.createHorizontalBox();
        searchBox = Box.createHorizontalBox();
        filterBox = Box.createHorizontalBox();
        jFrame.add(mainBox);

        mainBox.add(Box.createVerticalStrut(10));
        mainBox.add(fileBox);
        fileBox.setPreferredSize(new Dimension(600, 30));
        fileBox.setMinimumSize(new Dimension(600, 30));
        fileBox.setMaximumSize(new Dimension(2000, 30));
        addFileControls();

        mainBox.add(Box.createVerticalStrut(3));
        mainBox.add(searchBox);
        searchBox.setPreferredSize(new Dimension(600, 30));
        searchBox.setMinimumSize(new Dimension(600, 30));
        searchBox.setMaximumSize(new Dimension(2000, 30));

        mainBox.add(Box.createVerticalStrut(3));
        mainBox.add(filterBox);
        filterBox.setPreferredSize(new Dimension(600, 30));
        filterBox.setMinimumSize(new Dimension(600, 30));
        filterBox.setMaximumSize(new Dimension(2000, 30));
        addFilterBox();

        mainBox.add(Box.createVerticalStrut(3));
        mainBox.add(SortBox.getSortBox());
        SortBox.getSortBox().setPreferredSize(new Dimension(600, 30));
        SortBox.getSortBox().setMinimumSize(new Dimension(600, 30));
        SortBox.getSortBox().setMaximumSize(new Dimension(2000, 30));
        SortBox.addSortBox();

        addControls();
        mainBox.add(Box.createVerticalStrut(3));
        mainBox.add(MessegeBox.getMessegeBox());
        MessegeBox.getMessegeBox().setPreferredSize(new Dimension(600, 30));
        MessegeBox.getMessegeBox().setMinimumSize(new Dimension(600, 30));
        MessegeBox.getMessegeBox().setMaximumSize(new Dimension(2000, 30));
        MessegeBox.addMessegeBox();
    }

    /**
     * Adds the file controls.
     */
    private void addFileControls() {
        chooseFileButton = new JButton("选择文件夹");
        chooseFileButton.setBackground(Color.WHITE);
        chooseFileButton.setFont(buttonFont);
        fileBox.add(chooseFileButton);

        chooseFileButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                chooseSearchDir();
            }
        });

        fileBox.add(Box.createHorizontalStrut(10));
        chooseFileLabel = new JLabel("PLEASE CHOOSE A FILE");
        chooseFileLabel.setFont(labelFont);
        chooseFileLabel.setForeground(Color.red);
        fileBox.add(chooseFileLabel);
    }

    /**
     * Adds the filter box.
     */
    private void addFilterBox() {
        filterLabel = new JLabel("筛选：");
        filterLabel.setFont(labelFont);
        filterBox.add(filterLabel);

        filterBox.add(Box.createHorizontalGlue());
        filterBox.add(Box.createHorizontalStrut(50));

        notExistLabel = new JLabel("不含的字符串");
        notExistLabel.setFont(buttonFont);
        filterBox.add(notExistLabel);

        notExistTextField = new JTextField();
        notExistTextField.setFont(inputFont);
        notExistTextField.setPreferredSize(new Dimension(125, 30));
        filterBox.add(notExistTextField);

        filterBox.add(Box.createHorizontalGlue());
        filterBox.add(Box.createHorizontalStrut(50));

        chooseFormatLabel = new JLabel("文件格式");
        chooseFormatLabel.setFont(buttonFont);
        filterBox.add(chooseFormatLabel);

        String[] ct = { "所有文件： .*", "可执行文件：.exe", "压缩文件：.rar .zip .7z",
                "文档：.doc .docx .html .pdf .ppt .pptx .txt .xls .xlsx",
                "图片：.ai .bmp .gif .jpeg .jpg .png .psd .svg .tiff", "视频：.avi .flv .mkv .mp4 .rmvb",
                "音频：.cda .flac .mp3 .wav .wma", "程序：.c .cpp .jar .java .m .py" };
        formatComboBox = new JComboBox<Object>(ct);
        formatComboBox.setFont(menuItemFont);
        formatComboBox.setPreferredSize(new Dimension(150, 30));
        filterBox.add(formatComboBox);

        notExistTextField.addKeyListener(new KeyListener() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    if (!hasChosen) {
                        JOptionPane.showMessageDialog(null, "请先选择文件夹", "Error", JOptionPane.ERROR_MESSAGE);
                    } else if (inputTextField.getText().isEmpty()) {
                        JOptionPane.showMessageDialog(null, "请输入搜索内容", "Error", JOptionPane.ERROR_MESSAGE);
                    } else {
                        tableRowSorter.setRowFilter(null);
                        String notExistText = notExistTextField.getText();
                        if (!notExistText.isEmpty() && !notExistText.matches("[a-zA-Z0-9\\u4e00-\\u9fa5]+")) {
                            JOptionPane.showMessageDialog(null, "请输入字母、数字或中文字符", "Error", JOptionPane.WARNING_MESSAGE);
                        } else {
                            tableRowSorter.setRowFilter(null);
                            defaultTableModel.setRowCount(0);

                            if (notExistText.isEmpty()) {
                                if (!selectedRegex.equals(""))
                                    tableRowSorter.setRowFilter(RowFilter.regexFilter(selectedRegex, 0));
                            } else {
                                if (selectedRegex.equals(""))
                                    tableRowSorter
                                            .setRowFilter(RowFilter.regexFilter("^((?!" + notExistText + ").)*$", 0));
                                else
                                    tableRowSorter.setRowFilter(
                                            RowFilter.regexFilter("^((?!" + notExistText + ").)*" + selectedRegex, 0));
                            }
                            Search.startSearch();
                        }
                    }
                }
            }

            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyReleased(KeyEvent e) {
            }
        });

        formatComboBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                int selectedIndex = formatComboBox.getSelectedIndex();
                selectedRegex = DefaultSortUtil.getAllregex()[selectedIndex];
            }
        });
    }

    /**
     * Choose search dir.
     */
    public static void chooseSearchDir() {
        FileSystemView fileSystemView = FileSystemView.getFileSystemView();
        jFileChooser = new JFileChooser();
        jFileChooser.setCurrentDirectory(fileSystemView.getHomeDirectory());
        jFileChooser.setDialogTitle("选择文件夹");
        jFileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        SwingUtilities.updateComponentTreeUI(jFileChooser);
        int val = jFileChooser.showSaveDialog(null);
        if (val == JFileChooser.APPROVE_OPTION) {
            File fileChosen = jFileChooser.getSelectedFile();
            Search.setSearchPathChosen(fileChosen.getAbsolutePath());

            chooseFileLabel.setText(Search.getSearchPathChosen());
            chooseFileLabel.setForeground(Color.BLACK);

            hasChosen = true;
            if (!inputTextField.getText().isEmpty()) {
                searchButton.setEnabled(true);
                clearButton.setEnabled(true);
                MenuBar.getSearchFileMenuItem().setEnabled(true);
            }
        }
    }

    /**
     * Adds the controls.
     */
    public void addControls() {
        inputTextField = new JTextField();
        inputTextField.setFont(inputFont);
        searchBox.add(inputTextField);
        inputTextField.addKeyListener(new KeyListener() {

            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    if (!hasChosen) {
                        JOptionPane.showMessageDialog(null, "请先选择文件夹", "Error", JOptionPane.ERROR_MESSAGE);
                    } else {
                        String notExistText = notExistTextField.getText();
                        tableRowSorter.setRowFilter(null);
                        defaultTableModel.setRowCount(0);

                        if (notExistText.isEmpty()) {
                            if (!selectedRegex.equals(""))
                                tableRowSorter.setRowFilter(RowFilter.regexFilter(selectedRegex, 0));
                        } else {
                            if (selectedRegex.equals(""))
                                tableRowSorter.setRowFilter(RowFilter.regexFilter("^((?!" + notExistText + ").)*$", 0));
                            else
                                tableRowSorter.setRowFilter(
                                        RowFilter.regexFilter("^((?!" + notExistText + ").)*" + selectedRegex, 0));
                        }

                        Search.startSearch();
                    }
                }
            }

            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyReleased(KeyEvent e) {
                if (!inputTextField.getText().isEmpty() && hasChosen) {
                    searchButton.setEnabled(true);
                    clearButton.setEnabled(true);
                    MenuBar.getSearchFileMenuItem().setEnabled(true);
                } else {
                    searchButton.setEnabled(false);
                    clearButton.setEnabled(false);
                    MenuBar.getSearchFileMenuItem().setEnabled(false);
                }
            }
        });

        searchButton = new JButton("查 找");
        searchButton.setBackground(Color.WHITE);
        searchButton.setFont(buttonFont);
        searchBox.add(Box.createHorizontalStrut(5));
        searchBox.add(searchButton);
        searchButton.setEnabled(false);
        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String notExistText = notExistTextField.getText();
                tableRowSorter.setRowFilter(null);
                defaultTableModel.setRowCount(0);

                if (notExistText.isEmpty()) {
                    if (!selectedRegex.equals(""))
                        tableRowSorter.setRowFilter(RowFilter.regexFilter(selectedRegex, 0));
                } else {
                    if (selectedRegex.equals(""))
                        tableRowSorter.setRowFilter(RowFilter.regexFilter("^((?!" + notExistText + ").)*$", 0));
                    else
                        tableRowSorter.setRowFilter(
                                RowFilter.regexFilter("^((?!" + notExistText + ").)*" + selectedRegex, 0));
                }

                Search.startSearch();

            }
        });

        clearButton = new JButton("清 空");
        clearButton.setBackground(Color.WHITE);
        clearButton.setFont(buttonFont);
        searchBox.add(Box.createHorizontalStrut(5));
        searchBox.add(clearButton);
        clearButton.setEnabled(false);
        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                inputTextField.setText("");
                defaultTableModel.setRowCount(0);
            }
        });

        searchResultTable = new Table(null);
        searchResultTable.setEnabled(true);
        searchResultTable.setCellSelectionEnabled(true);

        defaultTableModel = (DefaultTableModel) searchResultTable.getModel();
        defaultTableModel.setColumnIdentifiers(Search.getResTabAttribute());
        searchResultScrollPane = new JScrollPane(searchResultTable);

        mainBox.add(Box.createVerticalStrut(10));
        mainBox.add(searchResultScrollPane);
        searchResultTable.setFont(resultFont);

        TableCellRenderer tcr = new TableRenderer();
        searchResultTable.setDefaultRenderer(Object.class, tcr);

        JTableHeader head = searchResultTable.getTableHeader();
        head.setPreferredSize(new Dimension(head.getWidth(), 20));
        head.setFont(headFont);

        TableColumn tableColumn;
        tableColumn = searchResultTable.getColumnModel().getColumn(0);
        tableColumn.setWidth(170);
        tableColumn.setPreferredWidth(170);
        tableColumn.setMinWidth(50);
        tableColumn.setMaxWidth(1500);

        tableColumn = searchResultTable.getColumnModel().getColumn(1);
        tableColumn.setWidth(220);
        tableColumn.setPreferredWidth(220);
        tableColumn.setMinWidth(50);
        tableColumn.setMaxWidth(1500);

        tableColumn = searchResultTable.getColumnModel().getColumn(2);
        tableColumn.setWidth(60);
        tableColumn.setPreferredWidth(60);
        tableColumn.setMinWidth(50);
        tableColumn.setMaxWidth(1500);

        tableColumn = searchResultTable.getColumnModel().getColumn(3);
        tableColumn.setWidth(150);
        tableColumn.setPreferredWidth(150);
        tableColumn.setMinWidth(50);
        tableColumn.setMaxWidth(1500);

        searchResultTable.setColumnSelectionAllowed(false);
        searchResultTable.setRowSelectionAllowed(true);
        ListSelectionModel cellSelectionModel = searchResultTable.getSelectionModel();
        cellSelectionModel.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        cellSelectionModel.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                MenuBar.getOpenFileMenuItem().setEnabled(true);
                MenuBar.getCopyFileMenuItem().setEnabled(true);
                MenuBar.getRenameFileMenuItem().setEnabled(true);
                MenuBar.getDeleteFileMenuItem().setEnabled(true);
                MenuBar.getOpenDirMenuItem().setEnabled(true);
                MenuBar.getCopyDirMenuItem().setEnabled(true);
                MenuBar.getRenameDirMenuItem().setEnabled(true);
                MenuBar.getDeleteDirMenuItem().setEnabled(true);
            }
        });

        tableRowSorter = new TableRowSorter<>(defaultTableModel);

        searchResultTable.setRowSorter(tableRowSorter);

        JTableHeader header = searchResultTable.getTableHeader();
        header.setEnabled(false);

        searchResultTable.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) {
                    getSelectedTableInfo(e);
                    System.out.println("选中数据为：" + selectedData);
                    if (colNo <= 1) {
                        FileUtil.openFile(selectedData, isFile);
                    }
                } else if (e.getButton() == MouseEvent.BUTTON3) {
                    point = e.getPoint();
                    rowNo = searchResultTable.rowAtPoint(point);
                    colNo = searchResultTable.columnAtPoint(point);
                    if (colNo == 1)
                        popupDirMenu.show(searchResultTable, e.getX(), e.getY());
                    else
                        popupMenu.show(searchResultTable, e.getX(), e.getY());
                    getSelectedTableInfo(e);
                }
            }

            @Override
            public void mousePressed(MouseEvent e) {
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {
            }

            @Override
            public void mouseExited(MouseEvent e) {
            }
        });

        popupMenu = new JPopupMenu();
        openMenuItem = new JMenuItem("打开文件");
        popupMenu.add(openMenuItem);
        openMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FileUtil.openFile(selectedData, isFile);
            }
        });

        copyMenuItem = new JMenuItem("复制文件");
        popupMenu.add(copyMenuItem);
        copyMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FileSystemView fileSystemView = FileSystemView.getFileSystemView();
                jFileChooser = new JFileChooser();
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

        renameMenuItem = new JMenuItem("重命名文件");
        popupMenu.add(renameMenuItem);
        renameMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
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
                    defaultTableModel.setRowCount(0);
                    Search.startSearch();
                }
            }
        });

        deleteMenuItem = new JMenuItem("删除文件");
        popupMenu.add(deleteMenuItem);
        deleteMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FileUtil.deleteSingleFile(selectedData);
                defaultTableModel.setRowCount(0);
                Search.startSearch();
            }
        });

        popupDirMenu = new JPopupMenu();
        openDirMenuItem = new JMenuItem("打开文件夹");
        popupDirMenu.add(openDirMenuItem);
        openDirMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FileUtil.openFile(selectedData, isFile);
            }
        });

        copyDirMenuItem = new JMenuItem("复制文件夹");
        popupDirMenu.add(copyDirMenuItem);
        copyDirMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FileSystemView fileSystemView = FileSystemView.getFileSystemView();
                jFileChooser = new JFileChooser();
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

        renameDirMenuItem = new JMenuItem("重命名文件夹");
        popupDirMenu.add(renameDirMenuItem);
        renameDirMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
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
                    defaultTableModel.setRowCount(0);
                    Search.startSearch();
                }
            }
        });

        deleteDirMenuItem = new JMenuItem("删除文件夹");
        popupDirMenu.add(deleteDirMenuItem);
        deleteDirMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String desPathSelectedStr = selectedData.substring(0, selectedData.lastIndexOf("\\"));
                FileUtil.deleteFile(desPathSelectedStr, false);
                defaultTableModel.setRowCount(0);
                Search.startSearch();
            }
        });

        jFrame.setVisible(true);

    }

    /**
     * Gets the selected table info.
     *
     * @param e the e
     * @return the selected table info
     */
    public void getSelectedTableInfo(MouseEvent e) {
        point = e.getPoint();
        rowNo = searchResultTable.rowAtPoint(point);
        colNo = searchResultTable.columnAtPoint(point);

        if (colNo == 2 || colNo == 3)
            colNo = 0;

        isFile = colNo == 0 ? true : false;
        selectedData = isFile ? (String) searchResultTable.getValueAt(rowNo, colNo + 1)
                : (String) searchResultTable.getValueAt(rowNo, colNo);
    }

    /**
     * Gets the GUI instance.
     *
     * @return the GUI instance
     */
    public static GUI getGUIInstance() {
        if (gui == null) {
            gui = new GUI();
        }
        return gui;
    }

    /**
     * Gets the j frame.
     *
     * @return the j frame
     */
    public static JFrame getjFrame() {
        return jFrame;
    }

    /**
     * Gets the search result table.
     *
     * @return the search result table
     */
    public static Table getSearchResultTable() {
        return searchResultTable;
    }

    /**
     * Gets the default table model.
     *
     * @return the default table model
     */
    public static DefaultTableModel getDefaultTableModel() {
        return defaultTableModel;
    }

    /**
     * Gets the not exist text field.
     *
     * @return the not exist text field
     */
    public static JTextField getNotExistTextField() {
        return notExistTextField;
    }

    /**
     * Gets the table row sorter.
     *
     * @return the table row sorter
     */
    public static TableRowSorter<DefaultTableModel> getTableRowSorter() {
        return tableRowSorter;
    }

    /**
     * Gets the selected regex.
     *
     * @return the selected regex
     */
    public static String getSelectedRegex() {
        return selectedRegex;
    }

    /**
     * Gets the input text field.
     *
     * @return the input text field
     */
    public static JTextField getInputTextField() {
        return inputTextField;
    }

    /**
     * Sets the default table model.
     *
     * @param defaultTableModel the new default table model
     */
    public static void setDefaultTableModel(DefaultTableModel defaultTableModel) {
        GUI.defaultTableModel = defaultTableModel;
    }

    /**
     * Instantiates a new gui.
     */
    public GUI() {
        init();
    }

}