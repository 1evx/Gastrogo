/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package runner;

import java.time.LocalDate;
import java.util.Map;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import managefile.Delivery;
import managefile.Runner;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartMouseEvent;
import org.jfree.chart.ChartMouseListener;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.DefaultCategoryDataset;

/**
 *
 * @author Asus
 */
public class RunnerHome extends javax.swing.JPanel {
    private final String runnerId;
    Delivery delivery = new Delivery();
    Runner runner = new Runner();
    runnerAccountManager backend = new runnerAccountManager();
    /**
     * Creates new form RunnerHome
     */
    public RunnerHome(String runnerId) {
        this.runnerId = runnerId;
        initComponents();
        contentPanel.setSize(1000, 300);
        contentPanel.setOpaque(false);
        
        Map<String, Double> yearlyTotalRevenue = backend.getYearlyRevenue(runnerId);
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        for(Map.Entry<String, Double> entry : yearlyTotalRevenue.entrySet()){
            dataset.addValue(entry.getValue(), "Revenue", entry.getKey());
        }
        // Create chart
        JFreeChart barChart = ChartFactory.createBarChart(
                "Revenue Chart",   // Chart title
                "Year",            // X-axis Label
                "Amount ($)",      // Y-axis Label
                dataset
        );
        
        ChartPanel chartPanel = new ChartPanel(barChart);
        chartPanel.setPreferredSize(new java.awt.Dimension(800, 400));
        
        chartPanel.addChartMouseListener(new ChartMouseListener(){
            @Override
            public void chartMouseClicked(ChartMouseEvent e){
                if(e.getEntity() != null){
                    String clickedYear = e.getEntity().getToolTipText();
                    String year = clickedYear.substring(clickedYear.indexOf(",") + 2, clickedYear.indexOf(")"));
                    showDailySalesChart(year, runnerId);
                }
            }

            @Override
            public void chartMouseMoved(ChartMouseEvent cme) {
                //chill
            }
        });
        
        contentPanel.setLayout(new java.awt.BorderLayout());
        contentPanel.add(chartPanel, java.awt.BorderLayout.CENTER);
        contentPanel.validate();
    }
    
    private void showDailySalesChart(String year, String runnerId){
        System.out.println(year);
        Map<LocalDate, Double> dailySales = backend.getDailySalesForYear(year, runnerId);
        System.out.println(dailySales);
        DefaultCategoryDataset dailyDataset = new DefaultCategoryDataset();
        for (Map.Entry<LocalDate, Double> entry : dailySales.entrySet()) {
            dailyDataset.addValue(entry.getValue(), "Daily Sales", entry.getKey());
        }

        // Create a new bar chart for daily sales
        JFreeChart dailyChart = ChartFactory.createBarChart(
                "Daily Sales for " + year,   // Chart title
                "Date",                      // X-axis Label
                "Amount ($)",                // Y-axis Label
                dailyDataset
        );
        
        SwingUtilities.invokeLater(() -> {
            JFrame dailySalesFrame = new JFrame("Daily Sales - " + year);
            dailySalesFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            dailySalesFrame.add(new ChartPanel(dailyChart));
            dailySalesFrame.pack();
            dailySalesFrame.setLocationRelativeTo(null);
            dailySalesFrame.setVisible(true);
            dailySalesFrame.setSize(1000,600);
        });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        contentPanel = new javax.swing.JPanel();

        javax.swing.GroupLayout contentPanelLayout = new javax.swing.GroupLayout(contentPanel);
        contentPanel.setLayout(contentPanelLayout);
        contentPanelLayout.setHorizontalGroup(
            contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 650, Short.MAX_VALUE)
        );
        contentPanelLayout.setVerticalGroup(
            contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 500, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(contentPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(contentPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel contentPanel;
    // End of variables declaration//GEN-END:variables
}
