import java.awt.*;
import java.awt.event.*;
import javax.swing.*; 

public class EinAus extends JFrame implements ActionListener { 
  
  private JTextField EingabeFeld, AusgabeFeld;
               
   public EinAus() {  
     super("Syntaxanalyse durch Automaten");
      this.getContentPane().setBackground(Color.lightGray);
      this.getContentPane().setLayout(new FlowLayout());
      //Dialog-Button
      JButton button = new JButton("Analyse");
      button.setBackground(Color.red);
      button.addActionListener(this);
      this.getContentPane().add(button);
      //Ende-Button
      button = new JButton("Ende");
      button.setBackground(Color.red);
      button.addActionListener(this);
      this.getContentPane().add(button);
      //Eingabe-Textfeld
      EingabeFeld = new JTextField (20);
      this.getContentPane().add (EingabeFeld);
      //Ausgabe-Textfeld
      AusgabeFeld = new JTextField (20);
      this.getContentPane().add (AusgabeFeld);
   }

   public void actionPerformed(ActionEvent event) {  
      String cmd = event.getActionCommand();
      String antwort, quelltext;
      if (cmd.equals("Analyse")) {   
        String zeile = EingabeFeld.getText();
         //Erzeugen und Initialisieren des Automaten
         Automat_IPAddress meinAutomat = new Automat_IPAddress (zeile);
         if (meinAutomat.sagtJa())   
            AusgabeFeld.setText ("Ja");
        else
            AusgabeFeld.setText ("Nein");
      } 
      else if (cmd.equals("Ende")) { 
        setVisible(false);
         dispose();
         System.exit(0);
      }
   }
}