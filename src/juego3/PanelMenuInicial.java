package juego3;
//panel menu principal 
//


import java.awt.*;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.*;

public class PanelMenuInicial extends JPanel implements Constantes {
	public int inicia;
	public JButton comenzar, salir;
    public JCheckBox with_feedback, with_feedback2, castellano, ingles;
    public JLabel nombre, email;
    public JTextField campo_nombre, campo_email;
    public ImageIcon icono_mundo;
    public String[] tipos_letra;
    public JFrame ventana_principal;
    public boolean toShow_feedback;
    
    public PanelMenuInicial(JFrame ventana_principal){
        
    	this.ventana_principal=ventana_principal;
        this.setName("Cavernarios!!!");
        this.setLayout(null);
        this.setSize(SCREEN_SIZE.width,SCREEN_SIZE.height);
        toShow_feedback=true;
        
        nombre=new JLabel("N A M E : ");
        nombre.setFont(new Font("Times New Roman", Font.BOLD,40));
        nombre.setForeground(Color.orange);
        nombre.setBounds(20, 20, 400, 200);
        
        campo_nombre=new JTextField("");
        campo_nombre.setFont(new Font("Times New Roman",Font.BOLD,40));
        campo_nombre.setForeground(Color.LIGHT_GRAY);
        campo_nombre.setCaretColor(Color.orange);
        campo_nombre.setBounds(260, 100, 700, 50);
        campo_nombre.setOpaque(false);
        
        email=new JLabel("E M A I L : ");
        email.setFont(new Font("Times New Roman", Font.BOLD,40));
        email.setForeground(Color.orange);
        email.setBounds(20, 80, 400, 200);
        
        campo_email=new JTextField("");
        campo_email.setFont(new Font("Times New Roman",Font.BOLD,40));
        campo_email.setForeground(Color.LIGHT_GRAY);
        campo_email.setCaretColor(Color.orange);
        campo_email.setBounds(260, 160, 700, 50);
        campo_email.setOpaque(false);
        
        with_feedback=new JCheckBox("Intelligent Feedback",toShow_feedback);
        with_feedback.setFont(new Font("Times New Roman", Font.BOLD,30));
        with_feedback.setForeground(Color.LIGHT_GRAY);
        with_feedback.setBounds(60, 260, 800, 40);
        with_feedback.setOpaque(false);
        with_feedback.addActionListener(this::seleccionarFeedbackInteligente);
        
        with_feedback2=new JCheckBox("Final Linguistic Feedback via email",false);
        with_feedback2.setFont(new Font("Times New Roman", Font.BOLD,30));
        with_feedback2.setForeground(Color.LIGHT_GRAY);
        with_feedback2.setBounds(60, 300, 1000, 40);
        with_feedback2.setOpaque(false);
        
        castellano=new JCheckBox("Castellano", false);
        castellano.setFont(new Font("Times New Roman", Font.BOLD,20));
        castellano.setForeground(Color.orange);
        castellano.setBounds(320, 0, 150, 100);
        castellano.setOpaque(false);
        castellano.addActionListener(this::seleccionarCastellano);
        
        ingles=new JCheckBox("English", true);
        ingles.setFont(new Font("Times New Roman", Font.BOLD,20));
        ingles.setForeground(Color.orange);
        ingles.setBounds(160, 0, 150, 100);
        ingles.setOpaque(false);
        ingles.addActionListener(this::seleccionarIngles);
        
        comenzar=new JButton("P R E S S   S T A R T");
        comenzar.setBounds(980, 100, 310, 50);
        
        //comenzar.setOpaque(false); //en OSx no funciona
        comenzar.setContentAreaFilled(false);
        comenzar.setFont(new Font("Times New Roman", Font.BOLD,20));
        comenzar.setBackground(Color.RED);
        comenzar.setForeground(Color.orange);
        comenzar.setHorizontalTextPosition(JButton.CENTER);
        comenzar.setVerticalTextPosition(JButton.CENTER);
        comenzar.addActionListener(this::pulsarBotonComenzar);
        
        salir=new JButton("E X I T");
        salir.setBounds(980, 160, 310, 50);
        //salir.setOpaque(false); //en OSx no  funcionan
        salir.setFont(new Font("Times New Roman", Font.BOLD,20));
        salir.setBackground(Color.RED);
        salir.setForeground(Color.orange);
        salir.setHorizontalTextPosition(JButton.CENTER);
        salir.setVerticalTextPosition(JButton.CENTER);
        salir.addActionListener(this::pulsarBotonComenzar);
        
        add(comenzar);
        add(salir);
        add(nombre);
        add(campo_nombre);
        add(email);
        add(campo_email);
        add(with_feedback);
        add(with_feedback2);
        add(castellano);
        add(ingles);
        
    }
    
    public void pulsarBotonComenzar(ActionEvent e){
        if(campo_nombre.getText().isEmpty() && campo_email.getText().isEmpty())
        {
            JOptionPane.showMessageDialog(null,"DEBES INTRODUCIR TU NOMBRE","Cavernarios",JOptionPane.PLAIN_MESSAGE);
        }else{
        	 inicia=1;

     	/*	VentanaPrincipal vp=new VentanaPrincipal();
             vp.setTitle("Futbolito");
             vp.setLocationRelativeTo(null); //ventana centrada
             vp.setVisible(true); //y visible (obivo xd)
             vp.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
             this.setVisible(false);*/
         //  JOptionPane.showMessageDialog(null,"LANZAR EL VIDEO JUEGO", "Cavernarios", JOptionPane.PLAIN_MESSAGE);
            
            if(castellano.isSelected())
            {
                JOptionPane.showMessageDialog(null,"EN IDIOMA CASTELLANO", "Cavernarios", JOptionPane.PLAIN_MESSAGE);
            }
            if(with_feedback2.isSelected())
            {
                JOptionPane.showMessageDialog(null,"Y CON FEEDBACK ACTIVADO", "Cavernarios", JOptionPane.PLAIN_MESSAGE);
            }
        }
    }
    
   public void pulsarBotonSalir(ActionEvent e){
       System.exit(0);
   }
   
   public void seleccionarCastellano(ActionEvent e){
       JOptionPane.showMessageDialog(null,"SE SELECCIONO CASTELLANO", "Cavernarios", JOptionPane.PLAIN_MESSAGE);
       ingles.setSelected(false);
       nombre.setText("NOMBRE:");
       email.setText("CORREO:");
       with_feedback.setText("Activar Feedback Inteligente");
       with_feedback2.setText("Enviar Feedback por Correo Electronico");
       comenzar.setText("Comenzar");
       salir.setText("Salir");
   }
   
   public void seleccionarIngles(ActionEvent e)
   {
       JOptionPane.showMessageDialog(null,"SE SELECCIONO INGLES", "Cavernarios", JOptionPane.PLAIN_MESSAGE);
       castellano.setSelected(false);
       nombre.setText("N A M E:");
       email.setText("E M A I L:");
       with_feedback.setText("Intelligent Feedback");
       with_feedback2.setText("Linguistic Feedback via email");
       comenzar.setText("P R E S S   S T A R T");
       salir.setText("E X I T");
   }
   
   public void seleccionarFeedbackInteligente(ActionEvent e)
   {
       JOptionPane.showMessageDialog(null,"SE SELECCIONO FEEDBACK INTELIGENTE", "Cavernarios", JOptionPane.PLAIN_MESSAGE);
       toShow_feedback = with_feedback.isSelected();
   }
   
   @Override
   public void paintComponent(Graphics g){
       Dimension d=getSize();
       BufferedImage fondo=null;
       try{
           fondo= ImageIO.read(new File("img/caver.jpg"));
       }catch(IOException ex){
           Logger.getLogger(PanelMenuInicial.class.getName()).log(Level.SEVERE,null, ex);           
       }
       g.drawImage(fondo,0,0,d.width, d.height, null);
       super.paintComponents(g);
   }
   
}