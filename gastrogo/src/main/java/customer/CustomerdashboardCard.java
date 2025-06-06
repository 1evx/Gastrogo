/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package customer;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import managefile.Transaction;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

/**
 *
 * @author USER
 */
public class CustomerdashboardCard extends javax.swing.JPanel {
    String[] month_text = new String[]{"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
    private ChartPanel chartPanel;
    private double totalExpense, averageExpense;
    private List<managefile.Transaction> transactions;
    /**
     * Creates new form dashboardCard
     */
    public CustomerdashboardCard(List<managefile.Transaction> transactions) {
        this.transactions = transactions;
        initComponents();
        
        HashSet<String> transactionYear = new HashSet<>();
        for (managefile.Transaction transaction: transactions) {
            String yearIndex = transaction.getDatetime().split("T")[0].split("-")[0];
            if (!transactionYear.contains(yearIndex)){
                transactionYear.add(yearIndex);
                yearComboBox.addItem(yearIndex);
            }
        }
        chartPanel = new ChartPanel(createExpense(transactions));
        chartPanel.setPreferredSize(new Dimension(800, 400));
        chartPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK,2));
        
        totalLabel.setText(String.format("RM %.2f", totalExpense));
        averageLabel.setText(String.format("RM %.2f", averageExpense));
        
        dashboardPanel.setLayout(new BorderLayout());
        dashboardPanel.add(chartPanel, BorderLayout.CENTER);
        mainInnerPanel.add(dashboardPanel);
    }
    private JFreeChart createExpense(List<managefile.Transaction> transactions){
        String selectedYear = (String) yearComboBox.getSelectedItem();
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        int[] monthList = new int[transactions.size()];
        totalExpense = 0.0;
        for (int j=0;j<month_text.length;j++) {
            Double total =0.0;
            for (int i = 0; i < transactions.size(); i++) {
                Transaction transaction = transactions.get(i);
                String yearIndex = transaction.getDatetime().split("T")[0].split("-")[0];
                int monthIndex = Integer.parseInt(transaction.getDatetime().split("T")[0].split("-")[1]);
                if (yearIndex.equals(selectedYear)){
                    if (transaction.getTransactionType().equalsIgnoreCase("debit")){
                        if (monthIndex == j + 1) {
                            double amount = Double.parseDouble(transaction.getAmount());
                            total += amount;
                        }
                    }else if (transaction.getTransactionType().equalsIgnoreCase("refund")){
                        if (monthIndex == j + 1) {
                            double amount = Double.parseDouble(transaction.getAmount());
                            total -= amount;
                        }
                    }
                    monthList[i] = monthIndex;
                }
            }
            dataset.addValue(total, "Expenses (RM)", month_text[j].substring(0,3));
            totalExpense += total;
        }
        method.scaleImage sc = new method.scaleImage();
        int maximumMonth = sc.maxMonth(monthList);
        averageExpense = totalExpense/maximumMonth;
        JFreeChart barChart = ChartFactory.createBarChart("Expense for Year "+selectedYear,"Months","Expenses (RM)",dataset, PlotOrientation.VERTICAL,false,true, false);

        CategoryPlot plot = barChart.getCategoryPlot();
        plot.setRangeGridlinePaint(Color.BLACK);
        return barChart;
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainInnerPanel = new method.RoundedPanel();
        yearComboBox = new javax.swing.JComboBox<>();
        dashboardPanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        totalLabel = new javax.swing.JLabel();
        averageLabel = new javax.swing.JLabel();

        yearComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                yearComboBoxActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout dashboardPanelLayout = new javax.swing.GroupLayout(dashboardPanel);
        dashboardPanel.setLayout(dashboardPanelLayout);
        dashboardPanelLayout.setHorizontalGroup(
            dashboardPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        dashboardPanelLayout.setVerticalGroup(
            dashboardPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 392, Short.MAX_VALUE)
        );

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("Total Expenses:");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setText("Average Expenses:");

        totalLabel.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        totalLabel.setText("jLabel3");

        averageLabel.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        averageLabel.setText("jLabel3");

        javax.swing.GroupLayout mainInnerPanelLayout = new javax.swing.GroupLayout(mainInnerPanel);
        mainInnerPanel.setLayout(mainInnerPanelLayout);
        mainInnerPanelLayout.setHorizontalGroup(
            mainInnerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mainInnerPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(mainInnerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(dashboardPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(mainInnerPanelLayout.createSequentialGroup()
                        .addGroup(mainInnerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 172, Short.MAX_VALUE)
                            .addComponent(totalLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(31, 31, 31)
                        .addGroup(mainInnerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 172, Short.MAX_VALUE)
                            .addComponent(averageLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 374, Short.MAX_VALUE)
                        .addComponent(yearComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        mainInnerPanelLayout.setVerticalGroup(
            mainInnerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainInnerPanelLayout.createSequentialGroup()
                .addGroup(mainInnerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(mainInnerPanelLayout.createSequentialGroup()
                        .addGroup(mainInnerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(mainInnerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(totalLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(averageLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)))
                    .addGroup(mainInnerPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(yearComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(dashboardPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainInnerPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainInnerPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void yearComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_yearComboBoxActionPerformed
        // TODO add your handling code here:
        updateChart();
    }//GEN-LAST:event_yearComboBoxActionPerformed
    private void updateChart() {
        chartPanel = new ChartPanel(createExpense(transactions));
        chartPanel.setPreferredSize(new Dimension(800, 400));
        chartPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK,2));
        totalLabel.setText(String.format("RM %.2f", totalExpense));
        averageLabel.setText(String.format("RM %.2f", averageExpense));

        dashboardPanel.removeAll();
        dashboardPanel.add(chartPanel, BorderLayout.CENTER);
        dashboardPanel.revalidate();
        dashboardPanel.repaint();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel averageLabel;
    private javax.swing.JPanel dashboardPanel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private method.RoundedPanel mainInnerPanel;
    private javax.swing.JLabel totalLabel;
    private javax.swing.JComboBox<String> yearComboBox;
    // End of variables declaration//GEN-END:variables
}
