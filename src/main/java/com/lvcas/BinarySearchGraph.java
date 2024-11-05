package com.lvcas;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

import javax.swing.JFrame;

public class BinarySearchGraph extends JFrame {

    public BinarySearchGraph() {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        int[] sizes = {10, 100, 1000, 10000, 100000, 1000000, 10000000, 100000000};
        int target = -1; // Elemento que não está na lista

        for (int size : sizes) {
            int[] array = new int[size];
            for (int i = 0; i < size; i++) {
                array[i] = i;
            }
            BinarySearch.Result result = BinarySearch.binarySearch(array, target);
            dataset.addValue(result.comparisons, "Comparações", Integer.toString(size));
        }

        JFreeChart chart = ChartFactory.createLineChart(
                "Busca Binária - Comparações vs Tamanho da Lista",
                "Tamanho da Lista",
                "Número de Comparações",
                dataset,
                PlotOrientation.VERTICAL,
                true,
                true,
                false
        );

        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(new java.awt.Dimension(800, 600));
        setContentPane(chartPanel);
    }

    public static void main(String[] args) {
        BinarySearchGraph chart = new BinarySearchGraph();
        chart.pack();
        chart.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        chart.setVisible(true);
    }
}
