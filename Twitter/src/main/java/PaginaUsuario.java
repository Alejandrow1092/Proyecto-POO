import java.util.*;
import java.awt.*;
import javax.swing.*;


public class PaginaUsuario extends javax.swing.JFrame {
    ArrayList <String> datosUsuario;//obtiene los datos del usuario 
    ArrayList <String> datosTweet;//llevara los datos del tweet
    
    FrameUsuario nuevo;//frame para la pnatilla del tweet
    
    String idUsuario="";
    ImageIcon fotoUsuario;
    Icon icon;
   conexionCliente con;//conexion con el cliente para pedir los tweets
    
    public PaginaUsuario(String usuario, Object datos) {
    
    //  public PaginaUsuario(String usuario) {
        super("Twitter");
        System.out.println("llegada exitosa");
        con=new conexionCliente();
        this.idUsuario=usuario;
        datosUsuario=(ArrayList)datos;
        //icon = new ImageIcon(fotoUsuario.getImage().getScaledInstance(jLabel1.getWidth(), jLabel1.getHeight(), Image.SCALE_DEFAULT));
        
        fotoUsuario=new ImageIcon(""+datosUsuario.get(1));
        
        initComponents();
        
        defineComponents();//le da los valores a los componentos graficos de la BD
        
        cargaTweets();
        
        setVisible(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        textArea1 = new java.awt.TextArea();
        uwu = new javax.swing.JPanel();
        jPencabezado = new javax.swing.JPanel();
        jBatras = new javax.swing.JButton();
        jLNombre = new javax.swing.JLabel();
        jLNoTweets = new javax.swing.JLabel();
        jPcentro = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLNombre1 = new javax.swing.JLabel();
        jBsiguiendo = new javax.swing.JButton();
        jBseguidores = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tweetArea = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        javax.swing.GroupLayout uwuLayout = new javax.swing.GroupLayout(uwu);
        uwu.setLayout(uwuLayout);
        uwuLayout.setHorizontalGroup(
            uwuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        uwuLayout.setVerticalGroup(
            uwuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 252, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPencabezado.setBackground(new java.awt.Color(20, 31, 39));

        jBatras.setText("Atras");
        jBatras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBatrasActionPerformed(evt);
            }
        });

        jLNombre.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
        jLNombre.setForeground(new java.awt.Color(240, 240, 240));
        jLNombre.setText("Alejandro Martinez");

        jLNoTweets.setFont(new java.awt.Font("Tahoma", 0, 9)); // NOI18N
        jLNoTweets.setForeground(new java.awt.Color(240, 240, 240));
        jLNoTweets.setText("200 Tweets");

        javax.swing.GroupLayout jPencabezadoLayout = new javax.swing.GroupLayout(jPencabezado);
        jPencabezado.setLayout(jPencabezadoLayout);
        jPencabezadoLayout.setHorizontalGroup(
            jPencabezadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPencabezadoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jBatras)
                .addGroup(jPencabezadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPencabezadoLayout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jLNoTweets))
                    .addGroup(jPencabezadoLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLNombre)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPencabezadoLayout.setVerticalGroup(
            jPencabezadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPencabezadoLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPencabezadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPencabezadoLayout.createSequentialGroup()
                        .addComponent(jBatras)
                        .addGap(28, 28, 28))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPencabezadoLayout.createSequentialGroup()
                        .addComponent(jLNombre)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLNoTweets)
                        .addGap(24, 24, 24))))
        );

        jPcentro.setBackground(new java.awt.Color(20, 31, 39));

        jLabel1.setBackground(new java.awt.Color(0, 255, 0));
        jLabel1.setText("jLabel1");

        jLNombre1.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
        jLNombre1.setForeground(new java.awt.Color(240, 240, 240));
        jLNombre1.setText("Alejandro Martinez");

        jBsiguiendo.setText("jButton1");
        jBsiguiendo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBsiguiendoActionPerformed(evt);
            }
        });

        jBseguidores.setText("jButton2");
        jBseguidores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBseguidoresActionPerformed(evt);
            }
        });

        jButton3.setBackground(new java.awt.Color(20, 31, 39));
        jButton3.setForeground(new java.awt.Color(0, 172, 238));
        jButton3.setText("Tweets");
        jButton3.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        tweetArea.setBackground(new java.awt.Color(20, 31, 39));

        jPanel1.setBackground(new java.awt.Color(0, 153, 153));

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane2.setViewportView(jTextArea1);

        jLabel2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(240, 240, 240));
        jLabel2.setText("¿Que tienes en mente?");

        jButton1.setText("Twittear");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jLabel2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(116, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(64, 64, 64))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addContainerGap())))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1))
        );

        javax.swing.GroupLayout tweetAreaLayout = new javax.swing.GroupLayout(tweetArea);
        tweetArea.setLayout(tweetAreaLayout);
        tweetAreaLayout.setHorizontalGroup(
            tweetAreaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        tweetAreaLayout.setVerticalGroup(
            tweetAreaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tweetAreaLayout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(298, Short.MAX_VALUE))
        );

        jScrollPane1.setViewportView(tweetArea);

        javax.swing.GroupLayout jPcentroLayout = new javax.swing.GroupLayout(jPcentro);
        jPcentro.setLayout(jPcentroLayout);
        jPcentroLayout.setHorizontalGroup(
            jPcentroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPcentroLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPcentroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPcentroLayout.createSequentialGroup()
                        .addComponent(jBsiguiendo)
                        .addGap(18, 18, 18)
                        .addComponent(jBseguidores))
                    .addComponent(jLNombre1)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPcentroLayout.createSequentialGroup()
                .addComponent(jButton3)
                .addGap(0, 0, Short.MAX_VALUE))
            .addComponent(jScrollPane1)
        );
        jPcentroLayout.setVerticalGroup(
            jPcentroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPcentroLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLNombre1)
                .addGap(18, 18, 18)
                .addGroup(jPcentroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBsiguiendo)
                    .addComponent(jBseguidores))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 19, Short.MAX_VALUE)
                .addComponent(jButton3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 404, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPencabezado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPcentro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPencabezado, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(jPcentro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBseguidoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBseguidoresActionPerformed
        try {
            new ListaUsuario(idUsuario).setVisible(true);
            setVisible(false);
        } catch (Exception e) {
            System.out.println("Error "+e);
        }
       
    }//GEN-LAST:event_jBseguidoresActionPerformed

    private void jBsiguiendoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBsiguiendoActionPerformed
       try {
            new ListaUsuario(idUsuario).setVisible(true);
            setVisible(false);
        } catch (Exception e) {
            System.out.println("Error "+e);
        }
        
    }//GEN-LAST:event_jBsiguiendoActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jBatrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBatrasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jBatrasActionPerformed
    
   /* public static void main(String args[]){
        new PaginaUsuario("Andrea", );
    }*/
    
    public void cargaTweets(){
        Object obj1;
        
        datosTweet=new ArrayList <String>();
        datosTweet.add("6");
        datosTweet.add(""+idUsuario);
        
        datosTweet=(ArrayList)con.envia(datosTweet);
        
        datosTweet.add(datosUsuario.get(0));
        datosTweet.add(datosUsuario.get(1));
       
        
        nuevo=new FrameUsuario(2);
        
        obj1=nuevo.userTemplant(datosTweet);
        
        JPanel agrega=(JPanel)obj1;
        tweetArea.add(agrega);
    }
    
    public class conexionCliente extends Cliente{
        Cliente client;
        conexionCliente(){
            client=new Cliente();
            client.conecta();
        }
        public Object envia(ArrayList datos){
            Object obj2=null;
            try {
                 obj2=client.manejaConexion(datos);
            } catch (Exception e) {
                System.out.println("Error"+e);
            }
           return obj2;
        }
    }
    
    public void defineComponents(){
        
        System.out.println("Los datos son "+datosUsuario.get(0));
        
        jBatras.setText("ATRAS");
        jLNombre.setText(""+datosUsuario.get(0));
        jLNombre1.setText(""+datosUsuario.get(0));
        jLNoTweets.setText(""+datosUsuario.get(2)+" Tweets");
        jBseguidores.setText(""+datosUsuario.get(3)+" Seguidores");
        jBsiguiendo.setText(""+datosUsuario.get(4)+" Siguiendo");
        icon = new ImageIcon(fotoUsuario.getImage().getScaledInstance(jLabel1.getWidth(), jLabel1.getHeight(), Image.SCALE_DEFAULT));
        jLabel1.setIcon(icon);
        //this.repaint();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton jBatras;
    private javax.swing.JButton jBseguidores;
    private javax.swing.JButton jBsiguiendo;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLNoTweets;
    private javax.swing.JLabel jLNombre;
    private javax.swing.JLabel jLNombre1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPcentro;
    public javax.swing.JPanel jPencabezado;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea jTextArea1;
    private java.awt.TextArea textArea1;
    private javax.swing.JPanel tweetArea;
    private javax.swing.JPanel uwu;
    // End of variables declaration//GEN-END:variables
}
