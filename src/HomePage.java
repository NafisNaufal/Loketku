
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
import javax.swing.BorderFactory;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author joshu
 */
class Event {
    public String title;
    public String date;
    public String price;
    public String imagePath;

    public Event(String title, String date, String price, String imagePath) {
        this.title = title;
        this.date = date;
        this.price = price;
        this.imagePath = imagePath;
    }
    
    public String getTitle(){
        return title;
    }
    
    public String getDate(){
        return date;
    }
    
    public String getPrice(){
        return price;
    }
    
    public String getImagePath(){
        return imagePath;
    }
}

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

public class HomePage extends javax.swing.JFrame {

    /**
     * Creates new form HomePage
     */
    public HomePage() {
        initComponents();
        tampilkanEvent();
    }
    
    private void tampilkanEvent(){
    Event[] events = {
      new Event("Intimate Concert J-ROCKS", "28 June 2025", "Rp361.250", "/images/Intimate Concert 'RINDU SELALU' bersama J-ROCKS (1).jpg"),
      new Event("ColdPlay Music of the SPHERS", "15 Agustus 2025", "Rp576.540", "C:\\Users\\joshu\\OneDrive\\Documents\\GitHub\\Loketku\\src\\images\\coldplay-jakarta-concert.jpg"),
      new Event("Intimate Concert J-ROCKS", "28 June 2025", "Rp361.250", "/images/Intimate Concert 'RINDU SELALU' bersama J-ROCKS (1).jpg"),
      new Event("ColdPlay Music of the SPHERS", "15 Agustus 2025", "Rp576.540", "C:\\Users\\joshu\\OneDrive\\Documents\\GitHub\\Loketku\\src\\images\\coldplay-jakarta-concert.jpg"),
      new Event("Intimate Concert J-ROCKS", "28 June 2025", "Rp361.250", "/images/Intimate Concert 'RINDU SELALU' bersama J-ROCKS (1).jpg"),
      new Event("ColdPlay Music of the SPHERS", "15 Agustus 2025", "Rp576.540", "C:\\Users\\joshu\\OneDrive\\Documents\\GitHub\\Loketku\\src\\images\\coldplay-jakarta-concert.jpg")
    };
    
    ListEventPanel1.removeAll();
    ListEventPanel1.setLayout(new WrapLayout(FlowLayout.LEFT, 20, 20));  // // <-- Perbaikan: gunakan ListEventPanel1, bukan ListEventPane1

    for(Event event : events){
        JPanel eventPanel = new JPanel();
        eventPanel.setLayout(new BoxLayout(eventPanel, BoxLayout.Y_AXIS));
        eventPanel.setBackground(Color.WHITE);
        eventPanel.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        eventPanel.setPreferredSize(new Dimension(250, 300));

        JLabel gambar;
        if(event.imagePath.startsWith("/")) {
            // load dari resource classpath
            java.net.URL imgURL = getClass().getResource(event.imagePath);
            if(imgURL != null){
                gambar = new JLabel(new javax.swing.ImageIcon(imgURL));
            } else {
                gambar = new JLabel("Image not found");
            }
        } else {
            // load dari path absolut sistem file
            gambar = new JLabel(new javax.swing.ImageIcon(event.imagePath));
        }

        JLabel judul = new JLabel(event.title);
        JLabel tanggal = new JLabel(event.date);
        tanggal.setForeground(new java.awt.Color(153, 153, 153));
        JLabel harga = new JLabel(event.price);

        eventPanel.add(gambar);
        eventPanel.add(judul);
        eventPanel.add(tanggal);
        eventPanel.add(harga);
        
        eventPanel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        eventPanel.addMouseListener(new java.awt.event.MouseAdapter(){
            public void mouseClicked(java.awt.event.MouseEvent evt){
                new EventDetails(1).setVisible(true);
                HomePage.this.dispose();
            }
        });

        ListEventPanel1.add(eventPanel);
    }

    ListEventPanel1.revalidate();
    ListEventPanel1.repaint();
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
        DaftarButton1 = new javax.swing.JButton();
        MasukButton1 = new javax.swing.JButton();
        LoketkuLabel1 = new javax.swing.JLabel();
        AddEventButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        ListEventPanel1 = new javax.swing.JPanel();
        GambarEvent1 = new javax.swing.JLabel();
        JudulLabel2 = new javax.swing.JLabel();
        jtanggalLabel4 = new javax.swing.JLabel();
        hargaLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1200, 800));

        LayarAtasPanel1.setBackground(new java.awt.Color(0, 87, 166));
        LayarAtasPanel1.setPreferredSize(new java.awt.Dimension(1200, 120));

        DaftarButton1.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        DaftarButton1.setText("Sign up");
        DaftarButton1.setMaximumSize(new java.awt.Dimension(72, 26));
        DaftarButton1.setMinimumSize(new java.awt.Dimension(72, 26));

        MasukButton1.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        MasukButton1.setText("Login");

        LoketkuLabel1.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        LoketkuLabel1.setForeground(new java.awt.Color(255, 255, 255));
        LoketkuLabel1.setText("Loketku");

        AddEventButton1.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        AddEventButton1.setText("Add Event");

        javax.swing.GroupLayout LayarAtasPanel1Layout = new javax.swing.GroupLayout(LayarAtasPanel1);
        LayarAtasPanel1.setLayout(LayarAtasPanel1Layout);
        LayarAtasPanel1Layout.setHorizontalGroup(
            LayarAtasPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, LayarAtasPanel1Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(LoketkuLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 758, Short.MAX_VALUE)
                .addComponent(AddEventButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(DaftarButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(MasukButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35))
        );
        LayarAtasPanel1Layout.setVerticalGroup(
            LayarAtasPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(LayarAtasPanel1Layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(LayarAtasPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(DaftarButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(MasukButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LoketkuLabel1)
                    .addComponent(AddEventButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(41, Short.MAX_VALUE))
        );

        jLabel1.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        jLabel1.setText("List Of Event");

        GambarEvent1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Intimate Concert 'RINDU SELALU' bersama J-ROCKS (1).jpg"))); // NOI18N
        ListEventPanel1.add(GambarEvent1);

        JudulLabel2.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        JudulLabel2.setText("Intimate Concert 'RINDU SELALU' bersama...");
        ListEventPanel1.add(JudulLabel2);

        jtanggalLabel4.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        jtanggalLabel4.setForeground(new java.awt.Color(153, 153, 153));
        jtanggalLabel4.setText("28 June 2025");
        ListEventPanel1.add(jtanggalLabel4);

        hargaLabel5.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        hargaLabel5.setText("Rp361.250");
        ListEventPanel1.add(hargaLabel5);

        jScrollPane1.setViewportView(ListEventPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(LayarAtasPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(LayarAtasPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 624, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new HomePage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AddEventButton1;
    private javax.swing.JButton DaftarButton1;
    private javax.swing.JLabel GambarEvent1;
    private javax.swing.JLabel JudulLabel2;
    private javax.swing.JPanel LayarAtasPanel1;
    private javax.swing.JPanel ListEventPanel1;
    private javax.swing.JLabel LoketkuLabel1;
    private javax.swing.JButton MasukButton1;
    private javax.swing.JLabel hargaLabel5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel jtanggalLabel4;
    // End of variables declaration//GEN-END:variables
}
