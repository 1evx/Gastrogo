/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package runner;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.List;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import managefile.Delivery;
import managefile.readFile;

/**
 *
 * @author Asus
 */
public class RunnerHistory extends javax.swing.JPanel {
    private String runnerId;
    Delivery delivery = new Delivery();
    readFile read = new readFile();
    private JPanel containerPanel;
    private JScrollPane scrollPane;
    /**
     * Creates new form RunnerHistory
     */
    public RunnerHistory(String runnerId) {
        initComponents();
        this.runnerId = runnerId;
        this.setSize(1000, 300);
        this.setLayout(new BorderLayout());
        containerPanel = new JPanel(new GridLayout(0, 2, 10, 10));
        
        
        JScrollPane scrollPane = new JScrollPane(containerPanel);
        scrollPane.setPreferredSize(new Dimension(628,460));
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
        scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.getVerticalScrollBar().setUnitIncrement(20);
        scrollPane.getHorizontalScrollBar().setUnitIncrement(20);
        scrollPane.setBorder(null);
        this.add(scrollPane, BorderLayout.CENTER);
        
        initializeTasks();
    }
    
    private void initializeTasks(){
        List<Delivery> deliveries = read.readDelivery(delivery.getFilepath());
        for(Delivery delivery : deliveries){
            if((delivery.getRunnerID().equals(runnerId) && delivery.getStatus().equals("Completed")) || (delivery.getRunnerID().equals(runnerId) && delivery.getStatus().equals("Rejected"))){
                String deliveryId = delivery.getDeliveryID();
                RunnerHistoryPanel historyPanel = new RunnerHistoryPanel(deliveryId);
                containerPanel.add(historyPanel);
            }
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
