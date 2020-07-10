import java.util.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;

public class ListaUsuario extends javax.swing.JFrame{
   
    FrameUsuario nuevo;//hace las pantillas

    LoginPrueba tablaSeguidores, tablaSeguidos;//variables para acceder al socket cliente
    
    String nombreSeguidor;//guarda correoE2
    
    ArrayList <String> datosPU;//guardara los datos para abrir una pagina de usuario de un 
                               //seguidor/seguido
    
    conexionCliente con;
    
    public ListaUsuario(String idUser) throws IOException{
       
        initComponents();
        
        con=new conexionCliente();
        
        agregaUsuarios(idUser) ;//funcion donde se hace la logica de agregar usuarios

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

   
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jBseguidores = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jPlistaUsuarios1 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(20, 31, 39));

        jButton1.setText("Atras");

        jLabel1.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(240, 240, 240));
        jLabel1.setText("Alejandro Martinez");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 9)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(240, 240, 240));
        jLabel2.setText("Seguidores");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton1)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2))
                    .addComponent(jButton1))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        jBseguidores.setBackground(new java.awt.Color(20, 31, 39));
        jBseguidores.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jBseguidores.setForeground(new java.awt.Color(0, 172, 238));
        jBseguidores.setText("Seguidores");
        jBseguidores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBseguidoresActionPerformed(evt);
            }
        });

        jButton3.setBackground(new java.awt.Color(20, 31, 39));
        jButton3.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jButton3.setForeground(new java.awt.Color(0, 172, 238));
        jButton3.setText("Siguiendo");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jPlistaUsuarios1.setBackground(new java.awt.Color(20, 31, 39));
        jPlistaUsuarios1.setMinimumSize(new java.awt.Dimension(420, 665));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jBseguidores, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, 209, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPlistaUsuarios1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jBseguidores, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(543, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addGap(0, 114, Short.MAX_VALUE)
                    .addComponent(jPlistaUsuarios1, javax.swing.GroupLayout.PREFERRED_SIZE, 541, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBseguidoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBseguidoresActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jBseguidoresActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

    
   /* public static void main(String args[]){
        String idUser="amrkratos@hotmail.com";
        try {
            new ListaUsuario(idUser).setVisible(true);
        } catch (Exception e) {
        }
        
    }*/
    
    public void agregaUsuarios(String usuario) throws IOException{
        
        ArrayList <String> seguidores;//contiene la lista de seguidores
        ArrayList <String> datos;//arreglo que contiene los datos de los usuarios
                                 //para la plantilla
        seguidores=new ArrayList <String>();//hago arreglo que le voy a mandar al servidor
                                            //para tener lista de seguidores
        seguidores.add("3");
        seguidores.add(usuario);
        
        
        //tablaSeguidores.enviarDatos(seguidores);
       //Recibo un arreglo con la lista de seguidores
        seguidores=(ArrayList)con.envia(seguidores);
              
        
        Iterator it =seguidores.iterator();
        while(it.hasNext()){
            nuevo=new FrameUsuario(1);
            nombreSeguidor=(String)it.next();//obtengo el correE2
            
            //JPanel panel=new JPanel();
            
             
            
            datos=new ArrayList <String>();//le mando al servidor que me traiga los demas datos
            datos.add("4");        
            datos.add(nombreSeguidor);
            //tablaSeguidores.enviarDatos(datos);
            datos=(ArrayList)con.envia(datos);//me trajo el dato de su fot y nombre
            
            System.out.println(""+nombreSeguidor);
            
            Object obj=nuevo.userTemplant(datos);//mando a llenar la plantilla
            
            /*panel=(JPanel)obj;
            panel.setName(""+nombreSeguidor);
            panelUsuario.add(panel);*/
            
            
            JPanel averts=(JPanel)obj;
            averts.setName(""+nombreSeguidor); 
           // panelUsuario.add(averts);
            
            //jPlistaUsuarios1.add(aver);
            
            jPlistaUsuarios1.add(averts);
            jPlistaUsuarios1.updateUI();//actualizaUI

            mouse m1=new mouse();//objeto que hereda de Mouseadapter
            averts.addMouseListener(m1);//agrego el mouse listener
            
            
        }
        
    }
    
    
    public class mouse extends MouseAdapter  {//clase que hereda de MouseAdapter(MouseListener)
        @Override
        public void mouseClicked(MouseEvent evt){
            Component panel=(Component)evt.getSource();
            nombreSeguidor=""+panel.getName();
            
            
            datosPU=new ArrayList <String>();
            System.out.println("Se oprimio "+panel.getName());//nombre del panel oprimido
            datosPU.add("5");
            datosPU.add(""+panel.getName());
            
            try {
                datosPU=(ArrayList)con.envia(datosPU);
            } catch (Exception e) {
                System.out.println("Error "+e);
            }
            
            System.out.println("nombre presionaaaado "+datosPU.get(0));
             
            new PaginaUsuario(nombreSeguidor, datosPU);
            setVisible(false);
            
            //AbstractButton EventSource = (AbstractButton)evt.getSource();
            //System.out.println("Toggled on? " + EventSource.isSelected() );
        }
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBseguidores;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPlistaUsuarios1;
    // End of variables declaration//GEN-END:variables
}
