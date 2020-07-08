import java.awt.*;
import javax.swing.*;
import java.util.*;

public class PaginaInicio extends JFrame{
    //++tipo para guardar la foto
    //++Agregar tweet
    JLabel Lnombre, LnoTweets;
        
    JButton Jsiguiendo, Jseguidores, Jseguir;
    
    JButton Jatras;
    
    ArrayList <JButton> ALseguidores;
    ArrayList <JButton> ALseguidos;
    
    JPanel encabezado;
    JPanel centro;
    JPanel tweetArea;
    JPanel feed;
    JPanel top;
            
    public PaginaInicio(){
        super("Twitter");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false); setSize(420, 670);
        
        Jatras= new JButton("Atras");
        Jatras.setPreferredSize(new Dimension(50,10));
        
        Lnombre=new JLabel("Alejandro Martinez");
        LnoTweets=new JLabel ("100");
        
        //hacemos el encabezado
        encabezado=new JPanel(new BorderLayout(5,5));
        encabezado.setSize(700,700);
        encabezado.setBackground(Color.CYAN);
        
        top=new JPanel(new BorderLayout(3,3));
        top.add(Lnombre, BorderLayout.NORTH);
        top.add(LnoTweets, BorderLayout.SOUTH);
        top.setBackground(Color.CYAN);
        
        encabezado.add(Jatras, BorderLayout.WEST); 
        encabezado.add(top);
        
        
        add(encabezado, BorderLayout.NORTH);
        setVisible(true);
        
    }
    
    
    
    
    public static void main(String args[]){
        new PaginaInicio();
    }
}
