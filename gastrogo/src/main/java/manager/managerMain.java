/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package manager;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.swing.JPanel;
import main.UserLogin;
import managefile.Data;
import managefile.Manager;
import manager.ManagerHome;
/**
 *
 * @author Asus
 */
public class managerMain extends javax.swing.JFrame {
    private String managerId;
    Manager manager = new Manager();
    managerAccountManager backend = new managerAccountManager();
    Data data = new Data();
    /**
     * Creates new form managerMain
     */
    public managerMain(String managerId) {
        initComponents();
        String managerName;
        this.managerId = managerId;
        contentPanel.setOpaque(false);
        this.setSize(1060, 600);
        
        managerName = data.retrieveData(managerId, 1, manager.getFilepath());
        jLabel2.setText("Manager " + managerName);
        logout.setIcon(backend.scale.processImage("src\\main\\java\\image_repository\\log-out.png", 40, 40));
       
        ManagerHome home = new ManagerHome(managerId);
        switchToPanel(home);
    }
    
    private void switchToPanel(JPanel panel) {
        panel.setSize(contentPanel.getWidth(), contentPanel.getHeight());
        panel.setLocation(0, 0);
        contentPanel.removeAll();
        contentPanel.add(panel, BorderLayout.CENTER);
        contentPanel.revalidate();
        contentPanel.repaint();
    }
    
    public void actionPerformed(ActionEvent e){
        if( e.getSource() == revenueBtn){
            managerRevenue managerRevenue = new managerRevenue();
            switchToPanel(managerRevenue);
        }else if( e.getSource() == deliveryBtn){
            managerDelivery managerDelivery = new managerDelivery();
            switchToPanel(managerDelivery);
        }else if(e.getSource() == complaintsBtn){
            ManagerComplaints managerComplaints = new ManagerComplaints(managerId);
            switchToPanel(managerComplaints);
        }else if(e.getSource() == vendorBtn){
            ManagerVendor managerVendor = new ManagerVendor();
            switchToPanel(managerVendor);
        }else if (e.getSource() == logout) {
            UserLogin loginpage = new UserLogin("manager");
            loginpage.run();
            this.dispose();
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

        jPanel2 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        revenueBtn = new javax.swing.JButton();
        deliveryBtn = new javax.swing.JButton();
        complaintsBtn = new javax.swing.JButton();
        vendorBtn = new javax.swing.JButton();
        welcomePanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        logout = new javax.swing.JButton();
        contentPanel = new javax.swing.JPanel();

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel4.setBackground(new java.awt.Color(235, 148, 134));

        revenueBtn.setBackground(new java.awt.Color(243, 222, 138));
        revenueBtn.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        revenueBtn.setText("Revenue");
        revenueBtn.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        revenueBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                revenueBtnActionPerformed(evt);
            }
        });

        deliveryBtn.setBackground(new java.awt.Color(243, 222, 138));
        deliveryBtn.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        deliveryBtn.setText("Delivery");
        deliveryBtn.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        deliveryBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deliveryBtnActionPerformed(evt);
            }
        });

        complaintsBtn.setBackground(new java.awt.Color(243, 222, 138));
        complaintsBtn.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        complaintsBtn.setText("Complaints");
        complaintsBtn.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        complaintsBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                complaintsBtnActionPerformed(evt);
            }
        });

        vendorBtn.setBackground(new java.awt.Color(243, 222, 138));
        vendorBtn.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        vendorBtn.setText("Vendor");
        vendorBtn.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        vendorBtn.setPreferredSize(new java.awt.Dimension(75, 50));
        vendorBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                vendorBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(revenueBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(48, 48, 48)
                .addComponent(deliveryBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42)
                .addComponent(complaintsBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45)
                .addComponent(vendorBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(revenueBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(deliveryBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(complaintsBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(vendorBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        welcomePanel.setBackground(new java.awt.Color(39, 40, 56));
        welcomePanel.setPreferredSize(new java.awt.Dimension(1000, 100));
        welcomePanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 3, 36)); // NOI18N
        jLabel1.setForeground(java.awt.Color.white);
        jLabel1.setText("Welcome back,");
        welcomePanel.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(43, 6, 370, 41));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 3, 36)); // NOI18N
        jLabel2.setForeground(java.awt.Color.white);
        jLabel2.setText("Manager <<Name>>");
        welcomePanel.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(65, 59, 550, -1));

        logout.setBackground(new java.awt.Color(39, 40, 56));
        logout.setBorder(null);
        logout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutActionPerformed(evt);
            }
        });
        welcomePanel.add(logout, new org.netbeans.lib.awtextra.AbsoluteConstraints(952, 20, 80, 70));

        contentPanel.setPreferredSize(new java.awt.Dimension(1000, 300));

        javax.swing.GroupLayout contentPanelLayout = new javax.swing.GroupLayout(contentPanel);
        contentPanel.setLayout(contentPanelLayout);
        contentPanelLayout.setHorizontalGroup(
            contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1000, Short.MAX_VALUE)
        );
        contentPanelLayout.setVerticalGroup(
            contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(welcomePanel, javax.swing.GroupLayout.DEFAULT_SIZE, 1035, Short.MAX_VALUE)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(contentPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(welcomePanel, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(contentPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(36, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void deliveryBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deliveryBtnActionPerformed
        // TODO add your handling code here:
        actionPerformed(evt);
    }//GEN-LAST:event_deliveryBtnActionPerformed

    private void complaintsBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_complaintsBtnActionPerformed
        // TODO add your handling code here:
        actionPerformed(evt);
    }//GEN-LAST:event_complaintsBtnActionPerformed

    private void vendorBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_vendorBtnActionPerformed
        // TODO add your handling code here:
        actionPerformed(evt);
    }//GEN-LAST:event_vendorBtnActionPerformed

    private void revenueBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_revenueBtnActionPerformed
        // TODO add your handling code here:
        actionPerformed(evt); 
    }//GEN-LAST:event_revenueBtnActionPerformed

    private void logoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutActionPerformed
        // TODO add your handling code here:
        actionPerformed(evt);
    }//GEN-LAST:event_logoutActionPerformed

    /**
     * @param args the command line arguments
     */
 
    public void run() {
        new managerMain(managerId).setVisible(true);
    }

 

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton complaintsBtn;
    private javax.swing.JPanel contentPanel;
    private javax.swing.JButton deliveryBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JButton logout;
    private javax.swing.JButton revenueBtn;
    private javax.swing.JButton vendorBtn;
    private javax.swing.JPanel welcomePanel;
    // End of variables declaration//GEN-END:variables

}
