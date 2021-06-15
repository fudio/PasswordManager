/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GuiNetbean;

import java.text.DecimalFormat;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.labels.ItemLabelAnchor;
import org.jfree.chart.labels.ItemLabelPosition;
import org.jfree.chart.labels.StandardCategoryItemLabelGenerator;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.CategoryItemRenderer;
import org.jfree.chart.renderer.category.LineAndShapeRenderer;
import org.jfree.chart.ui.TextAnchor;

/**
 *
 * @author theng
 */
public class guiStatisticalChart extends javax.swing.JFrame {

    /**
     * Creates new form guiStatisticalChart
     */
    public guiStatisticalChart() {
        initComponents();

        // Create dataset
        DefaultCategoryDataset dataset = createDataset();
        // Create chart
//        JFreeChart chart = ChartFactory.createLineChart(
//                "Statistical Chart", // Chart title  
//                "Date", // X-Axis Label  
//                "Number of Register", // Y-Axis Label  
//                dataset, PlotOrientation.VERTICAL, false, true, true
//        );
//        CategoryPlot plot = (CategoryPlot) chart.getPlot();
//        LineAndShapeRenderer renderer = (LineAndShapeRenderer) plot.getRenderer();
//        renderer.setDefaultShapesVisible(true);
//        DecimalFormat decimalformat1 = new DecimalFormat("##");
//        renderer.setDefaultItemLabelGenerator(new StandardCategoryItemLabelGenerator("{2}", decimalformat1));
//        renderer.setDefaultItemLabelsVisible(true);
//        renderer.setSeriesVisible(true);

        JFreeChart chart = ChartFactory.createBarChart("Statistical Chart",
                "Date",
                "Number of Register",
                dataset, PlotOrientation.VERTICAL, false, true, true);
        CategoryItemRenderer renderer = ((CategoryPlot)chart.getPlot()).getRenderer();
        renderer.setDefaultItemLabelGenerator(new StandardCategoryItemLabelGenerator());
        renderer.setDefaultItemLabelsVisible(true);
        ItemLabelPosition position = new ItemLabelPosition(ItemLabelAnchor.OUTSIDE12, 
                TextAnchor.TOP_CENTER);
        renderer.setDefaultPositiveItemLabelPosition(position);
        ChartPanel panel = new ChartPanel(chart);
        setContentPane(panel);
    }

    private DefaultCategoryDataset createDataset() {

        String series1 = "2020";

        DefaultCategoryDataset dataset = new DefaultCategoryDataset();

        dataset.addValue(200, series1, "1");
        dataset.addValue(150, series1, "2");
        dataset.addValue(100, series1, "3");
        dataset.addValue(0, series1, "4");
        dataset.addValue(240, series1, "5");
        dataset.addValue(195, series1, "6");
        dataset.addValue(245, series1, "7");
        dataset.addValue(200, series1, "8");
        dataset.addValue(0, series1, "9");
        dataset.addValue(100, series1, "10");
        dataset.addValue(210, series1, "11");
        dataset.addValue(240, series1, "12");

        return dataset;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated
	// Code">//GEN-BEGIN:initComponents
	private void initComponents() {

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		setPreferredSize(new java.awt.Dimension(950, 520));
		getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

		pack();
	}// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        // <editor-fold defaultstate="collapsed" desc=" Look and feel setting code
        // (optional) ">
        /*
		 * If Nimbus (introduced in Java SE 6) is not available, stay with the default
		 * look and feel. For details see
		 * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(guiStatisticalChart.class.getName()).log(java.util.logging.Level.SEVERE,
                    null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(guiStatisticalChart.class.getName()).log(java.util.logging.Level.SEVERE,
                    null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(guiStatisticalChart.class.getName()).log(java.util.logging.Level.SEVERE,
                    null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(guiStatisticalChart.class.getName()).log(java.util.logging.Level.SEVERE,
                    null, ex);
        }
        // </editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
//                new guiStatisticalChart().setVisible(true);
                guiStatisticalChart example = new guiStatisticalChart();
                example.setAlwaysOnTop(true);
                example.pack();
                example.setSize(950, 520);
                example.setVisible(true);
            }
        });
    }

	// Variables declaration - do not modify//GEN-BEGIN:variables
	// End of variables declaration//GEN-END:variables
}
