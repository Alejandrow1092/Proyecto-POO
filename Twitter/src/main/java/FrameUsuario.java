import java.util.*;
import java.awt.*;
import javax.swing.*;

public class FrameUsuario extends JFrame{
    ArrayList <String> data;
    // JPanel cola;
     public javax.swing.JPanel cola;
     ImageIcon foto;
     Icon icon;
     int opcion;
  
    public FrameUsuario(int opcion) {
        this.opcion=opcion;
        initComponents();
        data=new ArrayList<String>();
       
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        userPanel = new javax.swing.JPanel();
        jLfoto = new javax.swing.JLabel();
        jLuserName = new javax.swing.JLabel();
        jBseguir = new javax.swing.JButton();
        tweetArea = new javax.swing.JPanel();
        jLfotoTweet = new javax.swing.JLabel();
        jLnombreTweet = new javax.swing.JLabel();
        jLfecha = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        panel = new javax.swing.JTextPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        userPanel.setBackground(new java.awt.Color(20, 31, 39));

        jLfoto.setText("jLabel1");

        jLuserName.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLuserName.setForeground(new java.awt.Color(240, 240, 240));
        jLuserName.setText("ALEJANDRO MARTINEZ");

        jBseguir.setText("Siguiendo");

        javax.swing.GroupLayout userPanelLayout = new javax.swing.GroupLayout(userPanel);
        userPanel.setLayout(userPanelLayout);
        userPanelLayout.setHorizontalGroup(
            userPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(userPanelLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLfoto, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLuserName, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 92, Short.MAX_VALUE)
                .addComponent(jBseguir)
                .addContainerGap())
        );
        userPanelLayout.setVerticalGroup(
            userPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(userPanelLayout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jBseguir)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(userPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(userPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLfoto, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLuserName, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tweetArea.setBackground(new java.awt.Color(20, 31, 39));

        jLfotoTweet.setText("jLfoto");

        jLnombreTweet.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLnombreTweet.setForeground(new java.awt.Color(240, 240, 240));
        jLnombreTweet.setText("ALEJANDRO MARTINEZ");

        jLfecha.setForeground(new java.awt.Color(144, 151, 229));
        jLfecha.setText("FECHA");

        panel.setBackground(new java.awt.Color(20, 31, 39));
        panel.setForeground(new java.awt.Color(240, 240, 240));
        jScrollPane1.setViewportView(panel);

        javax.swing.GroupLayout tweetAreaLayout = new javax.swing.GroupLayout(tweetArea);
        tweetArea.setLayout(tweetAreaLayout);
        tweetAreaLayout.setHorizontalGroup(
            tweetAreaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tweetAreaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(tweetAreaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(tweetAreaLayout.createSequentialGroup()
                        .addComponent(jLfotoTweet, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 313, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(tweetAreaLayout.createSequentialGroup()
                        .addGap(72, 72, 72)
                        .addComponent(jLnombreTweet)
                        .addGap(35, 35, 35)
                        .addComponent(jLfecha, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(26, Short.MAX_VALUE))
        );
        tweetAreaLayout.setVerticalGroup(
            tweetAreaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tweetAreaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(tweetAreaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLnombreTweet, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLfecha, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1)
                .addGroup(tweetAreaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(tweetAreaLayout.createSequentialGroup()
                        .addComponent(jLfotoTweet, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 26, Short.MAX_VALUE))
                    .addComponent(jScrollPane1))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(userPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(tweetArea, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(userPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addComponent(tweetArea, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 415, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public Object userTemplant(Object datos){
        Object obj=null;
        if(opcion==1){
            data=(ArrayList)datos;
            foto=new ImageIcon(""+data.get(2));
            icon = new ImageIcon(foto.getImage().getScaledInstance(jLfoto.getWidth(), jLfoto.getHeight(), Image.SCALE_DEFAULT));


            
            cola=new JPanel();
            cola=userPanel;//user panel es el panel que lleva la plantilla de usuario 

            jLuserName.setText(data.get(1));
            jLfoto.setIcon(icon);

            obj=cola;
            
        }
        if(opcion==2){
            data=(ArrayList)datos;
            
             foto=new ImageIcon(data.get(3));
            icon = new ImageIcon(foto.getImage().getScaledInstance(jLfoto.getWidth(), jLfoto.getHeight(), Image.SCALE_DEFAULT));
            
            cola=new JPanel();
            cola=tweetArea;//user panel es el panel que lleva la plantilla de usuario 
            
           // jLtexto.setText(data.get(1));
           panel.setText(data.get(1));
           jLfecha.setText(data.get(0));
            jLnombreTweet.setText(data.get(2));
            jLfotoTweet.setIcon(icon);
            obj=cola;
        }
        return obj;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBseguir;
    private javax.swing.JLabel jLfecha;
    private javax.swing.JLabel jLfoto;
    private javax.swing.JLabel jLfotoTweet;
    private javax.swing.JLabel jLnombreTweet;
    private javax.swing.JLabel jLuserName;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JTextPane panel;
    private javax.swing.JPanel tweetArea;
    private javax.swing.JPanel userPanel;
    // End of variables declaration//GEN-END:variables
}
