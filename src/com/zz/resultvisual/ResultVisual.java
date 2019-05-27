// <张圳>

/*
    将用户搜索+筛选后的结果进行可视化，主要包含：
    1. 具体类（.ppt .png等）数量最多的前6种以柱状图展示
    2. 大类（文档类 图片类等）数量最多的前6种以柱状图展示
    3. 具体类（.ppt .png等）数量以饼图展示
    4. 大类（文档类 图片类等）数量以饼图展示

 * 
 */
package com.zz.resultvisual;

import java.awt.Dimension;
import java.awt.Font;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.swing.JFrame;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;

import com.zz.gui.Search;
import com.zz.searchhistorydb.InsertIntoDB;
import com.zz.sortuitl.SortUtil;

// TODO: Auto-generated Javadoc
/**
 * The Class ResultVisual.
 */
public class ResultVisual {

    /** The Constant MAX_NUM_SHOWN. */
    private static final int MAX_NUM_SHOWN = 6;
    
    /** The max num show. */
    private static int maxNumShow = 6;

    /** The specific kind list. */
    private static List<Map.Entry<String, Integer>> specificKindList;
    
    /** The kind list. */
    private static List<Map.Entry<String, Integer>> kindList;

    /** The j frame. */
    private static JFrame jFrame;
    
    /** The chart panel. */
    private static ChartPanel chartPanel;

    /** The bar J free chart. */
    private static JFreeChart barJFreeChart;
    
    /** The default category dataset. */
    private static DefaultCategoryDataset defaultCategoryDataset;

    /** The pi J free chart. */
    private static JFreeChart piJFreeChart;
    
    /** The default pie dataset. */
    private static DefaultPieDataset defaultPieDataset;

    /**
     * Show by J frame.
     */
    public static void showByJFrame() {
        jFrame.add(chartPanel);
        jFrame.setVisible(true);
    }

    /**
     * Clear list.
     */
    public static void clearList() {
        maxNumShow = MAX_NUM_SHOWN;
        if (specificKindList != null) {
            specificKindList.clear();
        }
        if (kindList != null) {
            kindList.clear();
        }
    }

    /**
     * Show bar chart.
     *
     * @param no the no
     */
    public static void showBarChart(int no) {
        clearList();
        if (no == 10) {
            specificKindList = new ArrayList<Map.Entry<String, Integer>>(Search.getSpecificKindMap().entrySet());
            creatBarChart(specificKindList);
        } else {
            kindList = new ArrayList<Map.Entry<String, Integer>>(Search.getKindMap().entrySet());
            creatBarChart(kindList);
        }
        jFrame = new JFrame("可视化——柱状图");
        jFrame.setSize(new Dimension(800, 600));
        chartPanel = new ChartPanel(barJFreeChart, true);
        showByJFrame();

        InsertIntoDB.intsertIntoVisualRes();
    }

    /**
     * Show pi chart.
     *
     * @param no the no
     */
    public static void showPiChart(int no) {
        clearList();
        if (no == 20) {
            specificKindList = new ArrayList<Map.Entry<String, Integer>>(Search.getSpecificKindMap().entrySet());
            creatPiChart(specificKindList);
        } else {
            kindList = new ArrayList<Map.Entry<String, Integer>>(Search.getKindMap().entrySet());
            creatPiChart(kindList);
        }
        jFrame = new JFrame("可视化——饼图");
        jFrame.setSize(new Dimension(800, 600));
        chartPanel = new ChartPanel(piJFreeChart, true);
        showByJFrame();

        InsertIntoDB.intsertIntoVisualRes();
    }

    /**
     * Creat bar chart.
     *
     * @param list the list
     */
    public static void creatBarChart(List<Map.Entry<String, Integer>> list) {
        Collections.sort(list, SortUtil.sortByValue());
        defaultCategoryDataset = getBarDataSet(list);
        barJFreeChart = ChartFactory.createBarChart3D("张圳-zxy-cyq", "kind", "number", defaultCategoryDataset,
                PlotOrientation.VERTICAL, false, false, false);
        barJFreeChart.setTitle(new TextTitle("类型-数量", new Font("宋体", Font.BOLD + Font.ITALIC, 20)));
    }

    /**
     * Creat pi chart.
     *
     * @param list the list
     */
    public static void creatPiChart(List<Map.Entry<String, Integer>> list) {
        Collections.sort(list, SortUtil.sortByValue());
        defaultPieDataset = getPiDataSet(list);
        piJFreeChart = ChartFactory.createPieChart3D("张圳-zry-ty", defaultPieDataset, true, false, false);
        piJFreeChart.setTitle(new TextTitle("类型-占比", new Font("宋体", Font.BOLD + Font.ITALIC, 20)));
        PiePlot pieplot = (PiePlot) piJFreeChart.getPlot();
        DecimalFormat df = new DecimalFormat("0.00%");
        NumberFormat nf = NumberFormat.getNumberInstance();
        StandardPieSectionLabelGenerator sp1 = new StandardPieSectionLabelGenerator("{0}  {2}", nf, df);
        pieplot.setLabelGenerator(sp1);
    }

    /**
     * Gets the bar data set.
     *
     * @param list the list
     * @return the bar data set
     */
    public static DefaultCategoryDataset getBarDataSet(List<Map.Entry<String, Integer>> list) {
        int cnt = 0;
        maxNumShow = maxNumShow < list.size() ? maxNumShow : list.size();
        defaultCategoryDataset = new DefaultCategoryDataset();
        Iterator<Map.Entry<String, Integer>> iterator = list.iterator();
        while (cnt < maxNumShow && iterator.hasNext()) {
            Map.Entry<String, Integer> entry = iterator.next();
            defaultCategoryDataset.addValue(entry.getValue(), String.valueOf(cnt), entry.getKey());
            cnt++;
        }
        return defaultCategoryDataset;
    }

    /**
     * Gets the pi data set.
     *
     * @param list the list
     * @return the pi data set
     */
    public static DefaultPieDataset getPiDataSet(List<Map.Entry<String, Integer>> list) {
        int cnt = 0;
        boolean hasOthers = false;
        maxNumShow = maxNumShow < list.size() ? maxNumShow : list.size();
        DefaultPieDataset defaultPieDataset = new DefaultPieDataset();
        Iterator<Map.Entry<String, Integer>> iterator = list.iterator();
        while (cnt < maxNumShow && iterator.hasNext()) {
            Map.Entry<String, Integer> entry = iterator.next();
            if (!hasOthers && "others".equals(entry.getKey())) {
                hasOthers = true;
            }
            defaultPieDataset.setValue(entry.getKey(), entry.getValue());
            cnt++;
        }
        if (!hasOthers && cnt != 1) {
            defaultPieDataset.setValue("others", list.size() - cnt);
        }
        return defaultPieDataset;
    }

    /**
     * Gets the specific kind list.
     *
     * @return the specific kind list
     */
    public static List<Map.Entry<String, Integer>> getSpecificKindList() {
        return specificKindList;
    }

    /**
     * Gets the kind list.
     *
     * @return the kind list
     */
    public static List<Map.Entry<String, Integer>> getKindList() {
        return kindList;
    }
}

// <张圳>
