/*
 * I'm Floored flooring application.
 * Sarah Bohn, CIS355A
 */
package imfloored;

import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
/**
 * @author Sarah
 */
public class FlooringGUI extends javax.swing.JFrame {

    /**
     * Creates new form FlooringGUI
     */

    private FloorOrder aOrder; 
    private final DefaultListModel<FloorOrder> listModel;
    private final FloorOrder floorOrder;
   
    public FlooringGUI()  {
        initComponents();
        super.setLocationRelativeTo(null);
        newOrder();
        
        listModel = new DefaultListModel<>();
        lstOrders.setModel(listModel);
        OrderList orderList = new OrderList();
        retrieveOrderList();
    }
    private void retrieveOrderList()  {
        int count = 0;
        String message;
        count = orderList.setList(listModel);
        message = count + " pizza order records retrieved";
        JOptionPane.showMessageDialog(null, message, "Pizza Orders Retrieved", JOptionPane.INFORMATION_MESSAGE);
     
        
    }
  
    private void showOrderDetails() {
        if (lstOrders.getSelectedIndex() != -1) {
            aOrder = lstOrders.getSelectedValue();
            txtOrderDetails.setText(aOrder.getOrderInformation());
        }
    }    
    private void submitOrder()  {
        StringBuilder str = new StringBuilder();
        boolean success = false;
        String prompt;
        if (aOrder != null) {
            str.append("Order submitted\n");
            str.append (aOrder.getOrderInformation());
            listModel.addElement(aOrder);  
            success = orderList.add(aOrder);
            if (success) {
                prompt = "Succesfully added " + aOrder.getFullName() + " to the database";
                JOptionPane.showMessageDialog(null, prompt, "Record added successfully", JOptionPane.INFORMATION_MESSAGE);
           
            }
            else {
                prompt = "DID NOT successfully add " + aOrder.getFullName() + " to the database";
                JOptionPane.showMessageDialog(null, prompt, "Record NOT added successfully", JOptionPane.ERROR);
            }
            
        }
    }
     private void deleteOrder() {
        int item = lstOrders.getSelectedIndex();
        if (item != -1) {
            int response;
            FloorOrder theOrder = lstOrders.getSelectedValue();
            String prompt = "Are you sure you want to delete order for: " + theOrder.toString();
            response = JOptionPane.showConfirmDialog(null, prompt, "Delete order " + theOrder.toString(), 
                                                    JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (response == JOptionPane.YES_OPTION) {
                listModel.removeElement(theOrder);
                orderList.remove(theOrder);
                txtOrderDetails.setText("");
               
            }
        }
    }
    private void updateOrder()  {
        double value;
        try {
            value = Double.parseDouble(txtTotal.getText());
            aOrder.setTotal(value);
            txtOrderDetails.setText(aOrder.getOrderInformation());
            orderList.update(aOrder);
           
        }
        catch (NumberFormatException ex) {
            String message = txtTotal.getText() + " value is an illegal, enter a number greater than 0";
            JOptionPane.showMessageDialog(null, message, "Illegal total value", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    /************** existing functions from previous iteration *****************/


    private void setSize(FloorOrder.FloorType size) {
        aOrder.setFloorType(size);
   
    }
   
     
     private void terminateApplication() {
         int response = JOptionPane.NO_OPTION;
			String prompt = "Do you want to quit the pizza program?";
			String title = "Quit Pizza Program";
			response = JOptionPane.showConfirmDialog(null, prompt, title, 
										  JOptionPane.OK_CANCEL_OPTION, 
										  JOptionPane.QUESTION_MESSAGE);
			if(response == JOptionPane.YES_OPTION) {
				System.exit(0);
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
        bindingGroup = new org.jdesktop.beansbinding.BindingGroup();

        buttonGroup1 = new javax.swing.ButtonGroup();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        firstName = new javax.swing.JTextField();
        lastName = new javax.swing.JTextField();
        address = new javax.swing.JTextField();
        woodFl = new javax.swing.JRadioButton();
        carpetFl = new javax.swing.JRadioButton();
        lavaFl = new javax.swing.JRadioButton();
        lengthFl = new javax.swing.JTextField();
        widthFl = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        areaFl = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Adobe Gothic Std B", 1, 24)); // NOI18N
        jLabel1.setText("I'm Floored!");

        firstName.setText("Enter your first name");
        firstName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                firstNameActionPerformed(evt);
            }
        });

        lastName.setText("Enter your last name");

        address.setText("Enter your address");

        buttonGroup1.add(woodFl);
        woodFl.setText("Wood Flooring");

        org.jdesktop.beansbinding.Binding binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, buttonGroup1, org.jdesktop.beansbinding.ObjectProperty.create(), woodFl, org.jdesktop.beansbinding.BeanProperty.create("selected"));
        bindingGroup.addBinding(binding);

        woodFl.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                woodFlActionPerformed(evt);
            }
        });

        buttonGroup1.add(carpetFl);
        carpetFl.setText("Carpet Flooring");

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, buttonGroup1, org.jdesktop.beansbinding.ObjectProperty.create(), carpetFl, org.jdesktop.beansbinding.BeanProperty.create("selected"));
        bindingGroup.addBinding(binding);

        carpetFl.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                carpetFlActionPerformed(evt);
            }
        });

        buttonGroup1.add(lavaFl);
        lavaFl.setText("The floor is Lava");

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, buttonGroup1, org.jdesktop.beansbinding.ObjectProperty.create(), lavaFl, org.jdesktop.beansbinding.BeanProperty.create("selected"));
        bindingGroup.addBinding(binding);

        lengthFl.setText("Enter the length of the room");

        widthFl.setText("Enter the width of the room");

        jLabel2.setText("First Name");

        jLabel3.setText("Last Name");

        jLabel4.setText("Address");

        jLabel5.setText("Length of room");

        jLabel6.setText("Width of room");

        areaFl.setText("Calculate Area");
        areaFl.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                areaFlActionPerformed(evt);
            }
        });

        jButton1.setText("Submit Order");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Clear Fields");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Exit Program");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(woodFl)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(address, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(lastName)
                                    .addComponent(firstName, javax.swing.GroupLayout.DEFAULT_SIZE, 139, Short.MAX_VALUE)))
                            .addComponent(carpetFl)
                            .addComponent(lavaFl))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 98, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                        .addGap(56, 56, 56)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(42, 42, 42))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addGap(37, 37, 37))
                            .addComponent(lengthFl, javax.swing.GroupLayout.DEFAULT_SIZE, 153, Short.MAX_VALUE)
                            .addComponent(widthFl))
                        .addGap(55, 55, 55))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(areaFl)
                        .addGap(76, 76, 76))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(18, 18, 18)
                .addComponent(jButton2)
                .addGap(40, 40, 40)
                .addComponent(jButton3)
                .addGap(22, 22, 22))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(27, 27, 27))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(18, 18, 18)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(firstName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel2))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lastName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3))
                                .addGap(14, 14, 14)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(address, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel4)
                                    .addComponent(widthFl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(lengthFl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel6)))
                        .addGap(55, 55, 55))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(areaFl)
                        .addComponent(woodFl)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(carpetFl)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lavaFl)
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2)
                    .addComponent(jButton3))
                .addContainerGap(26, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Flooring", jPanel1);

        jLabel7.setText("Order Total:");

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(90, 90, 90)
                .addComponent(jLabel7)
                .addGap(58, 58, 58)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(163, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(136, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Order Info", jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );

        bindingGroup.bind();

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        //exit program
        System.exit(0);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        //clear button, clear everything
        firstName.setText("");
        lastName.setText("");
        address.setText("");
        lengthFl.setText("");
        widthFl.setText("");
        woodFl.setSelected(false);
        carpetFl.setSelected(false);
        lavaFl.setSelected(false);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

    }//GEN-LAST:event_jButton1ActionPerformed

    private void areaFlActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_areaFlActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_areaFlActionPerformed

    private void carpetFlActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_carpetFlActionPerformed
        setSize(FloorOrder.FloorType.Carpet);
    }//GEN-LAST:event_carpetFlActionPerformed

    private void woodFlActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_woodFlActionPerformed
     setSize(FloorOrder.FloorType.Wood);
    }//GEN-LAST:event_woodFlActionPerformed

    private void firstNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_firstNameActionPerformed
        // TODO add your handling code here:
        String text = firstName.getText();
    }//GEN-LAST:event_firstNameActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FlooringGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FlooringGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FlooringGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FlooringGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FlooringGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField address;
    private javax.swing.JButton areaFl;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JRadioButton carpetFl;
    private javax.swing.JTextField firstName;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField lastName;
    private javax.swing.JRadioButton lavaFl;
    private javax.swing.JTextField lengthFl;
    private javax.swing.JTextField widthFl;
    private javax.swing.JRadioButton woodFl;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables
