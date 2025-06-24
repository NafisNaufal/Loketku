
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Insets;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.JScrollPane;
import java.awt.Dimension;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import database.Koneksi;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


class WrapLayout extends FlowLayout {
    public WrapLayout() {
        super();
    }

    public WrapLayout(int align) {
        super(align);
    }

    public WrapLayout(int align, int hgap, int vgap) {
        super(align, hgap, vgap);
    }

    @Override
    public Dimension preferredLayoutSize(Container target) {
        return layoutSize(target, true);
    }

    @Override
    public Dimension minimumLayoutSize(Container target) {
        Dimension minimum = layoutSize(target, false);
        minimum.width -= (getHgap() + 1);
        return minimum;
    }

    private Dimension layoutSize(Container target, boolean preferred) {
        synchronized (target.getTreeLock()) {
            int targetWidth = target.getWidth();
            if (targetWidth == 0) targetWidth = Integer.MAX_VALUE;

            Insets insets = target.getInsets();
            int hgap = getHgap();
            int vgap = getVgap();
            int maxWidth = targetWidth - (insets.left + insets.right + hgap * 2);

            int width = 0, height = insets.top + vgap;
            int rowWidth = 0, rowHeight = 0;

            for (Component m : target.getComponents()) {
                if (!m.isVisible()) continue;
                Dimension d = preferred ? m.getPreferredSize() : m.getMinimumSize();
                if (rowWidth + d.width > maxWidth) {
                    width = Math.max(width, rowWidth);
                    height += rowHeight + vgap;
                    rowWidth = 0;
                    rowHeight = 0;
                }
                rowWidth += d.width + hgap;
                rowHeight = Math.max(rowHeight, d.height);
            }
            width = Math.max(width, rowWidth);
            height += rowHeight + insets.bottom;

            return new Dimension(width + insets.left + insets.right, height);
        }
    }
}


public class AddEvent extends javax.swing.JFrame {
 private static final String URL = "jdbc:sqlserver://localhost:1500;databaseName=Loketku";
    private static final String USER = "sa";
    private static final String PASSWORD = "hiinicandy";
    private String loggedInUsername;
    private boolean isAdmin; 
    private static final String IMAGE_PATH = "C:\\Users\\LENOVO IDP GAMING\\OneDrive\\Documents\\NetBeansProjects\\Loketku2\\src\\images\\common-image.jpg";
    private HomePage homePage;

    
    public AddEvent(String username, boolean isAdmin) {
        this.loggedInUsername = username;
        this.isAdmin = isAdmin;
    this.homePage = new HomePage(loggedInUsername, isAdmin);  
    initComponents();
    MasukButton1.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            homePage.setVisible(true);  
            AddEvent.this.dispose();  
        }
    });
}

public void addEvent(String eventName, String date, String description, String location, String time, String price) {
    String sql = "INSERT INTO EVENT_TABLE (event_name, date, description, location, time, price) VALUES (?, ?, ?, ?, ?, ?)";

    try (Connection conn = Koneksi.getKoneksi();  
         PreparedStatement pstmt = conn.prepareStatement(sql)) {

        pstmt.setString(1, eventName);  
        pstmt.setString(2, date);       
        pstmt.setString(3, description); 
        pstmt.setString(4, location);   
        pstmt.setString(5, time);        
        pstmt.setString(6, price);      

        int rowsAffected = pstmt.executeUpdate();
        if (rowsAffected > 0) {
            JOptionPane.showMessageDialog(this, "Event added successfully!");
            new HomePage(loggedInUsername,isAdmin).setVisible(true);
            this.dispose();  
        } else {
            JOptionPane.showMessageDialog(this, "Event insertion failed.");
        }
    } catch (SQLException e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(this, "Error adding event: " + e.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
    }
}




    

private boolean isValidDate(String date) {
    try {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        sdf.setLenient(false);
        sdf.parse(date);
        return true;
    } catch (ParseException e) {
        return false;
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

        LayarAtasPanel1 = new javax.swing.JPanel();
        MasukButton1 = new javax.swing.JButton();
        LoketkuLabel1 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jButtonConfirm = new javax.swing.JButton();
        jEventName = new javax.swing.JTextField();
        jEventDate = new javax.swing.JTextField();
        jEventPrice = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLocation = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jDescription = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jTime = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1200, 800));

        LayarAtasPanel1.setBackground(new java.awt.Color(0, 87, 166));
        LayarAtasPanel1.setPreferredSize(new java.awt.Dimension(1200, 120));

        MasukButton1.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        MasukButton1.setText("Back to Home");

        LoketkuLabel1.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        LoketkuLabel1.setForeground(new java.awt.Color(255, 255, 255));
        LoketkuLabel1.setText("Loketku");

        javax.swing.GroupLayout LayarAtasPanel1Layout = new javax.swing.GroupLayout(LayarAtasPanel1);
        LayarAtasPanel1.setLayout(LayarAtasPanel1Layout);
        LayarAtasPanel1Layout.setHorizontalGroup(
            LayarAtasPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, LayarAtasPanel1Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(LoketkuLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(MasukButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35))
        );
        LayarAtasPanel1Layout.setVerticalGroup(
            LayarAtasPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(LayarAtasPanel1Layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(LayarAtasPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(MasukButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LoketkuLabel1))
                .addContainerGap(42, Short.MAX_VALUE))
        );

        jLabel1.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        jLabel1.setText("Add Event");

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel2.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLabel2.setText("Event Name:");

        jLabel3.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLabel3.setText("Event Date:");

        jLabel4.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLabel4.setText("Event Price:");

        jButtonConfirm.setBackground(new java.awt.Color(0, 87, 166));
        jButtonConfirm.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jButtonConfirm.setForeground(new java.awt.Color(255, 255, 255));
        jButtonConfirm.setText("Confirm");
        jButtonConfirm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonConfirmActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLabel5.setText("Location: ");

        jLabel6.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLabel6.setText("Description:");

        jLabel7.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLabel7.setText("Time:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addComponent(jEventName, javax.swing.GroupLayout.PREFERRED_SIZE, 381, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jEventDate, javax.swing.GroupLayout.PREFERRED_SIZE, 381, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jEventPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 381, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLocation))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jDescription))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButtonConfirm, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTime))))
                .addContainerGap(31, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jEventName, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jEventDate, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jEventPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLocation, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jDescription, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTime, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jButtonConfirm, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(LayarAtasPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(620, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(LayarAtasPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    private void jButtonConfirmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonConfirmActionPerformed
String eventName = jEventName.getText().trim();
    String eventDate = jEventDate.getText().trim();
    String eventPrice = jEventPrice.getText().trim();  
    String location = jLocation.getText().trim();
    String description = jDescription.getText().trim();
    String time = jTime.getText().trim();

    if (eventName.isEmpty() || eventDate.isEmpty() || eventPrice.isEmpty() || location.isEmpty() || description.isEmpty() || time.isEmpty()) {
        JOptionPane.showMessageDialog(this, "All fields must be filled out!", "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }

    if (!isValidDate(eventDate)) {
        JOptionPane.showMessageDialog(this, "Please enter a valid date (yyyy-MM-dd).", "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }

    addEvent(eventName, eventDate, description, location, time, eventPrice);

    jEventName.setText("");
    jEventDate.setText("");
    jEventPrice.setText("");
    jLocation.setText("");
    jDescription.setText("");
    jTime.setText("");

    JOptionPane.showMessageDialog(this, "Event added successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_jButtonConfirmActionPerformed

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
            java.util.logging.Logger.getLogger(HomePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(HomePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(HomePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HomePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
String username = "john_doe";  // Example username
boolean isAdmin = true; 
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                
                new AddEvent(username,isAdmin).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel LayarAtasPanel1;
    private javax.swing.JLabel LoketkuLabel1;
    private javax.swing.JButton MasukButton1;
    private javax.swing.JButton jButtonConfirm;
    private javax.swing.JTextField jDescription;
    private javax.swing.JTextField jEventDate;
    private javax.swing.JTextField jEventName;
    private javax.swing.JTextField jEventPrice;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JTextField jLocation;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jTime;
    // End of variables declaration//GEN-END:variables
}
