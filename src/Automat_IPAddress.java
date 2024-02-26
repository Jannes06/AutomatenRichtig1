import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class Automat_IPAddress {
    String parseStrg;
    boolean ok = true;
    char zeichen;
    public Automat_IPAddress(String s) {
        parseStrg = s;
    }

    char cutFirst() {
        if (parseStrg.length() == 0)
            return '$';
        else {
            char first = parseStrg.charAt(0);
            parseStrg = parseStrg.substring(1);
            return first;
        }
    }

    public boolean sagtJa() {
        final int z0 = 0, z1 = 1, z2 = 2, z3 = 3, z4 = 4, z5 = 5, err = 6;
        zeichen = cutFirst();
        int zustand = z0;
        while (zeichen != '$') {
            switch (zustand) {
                case z0:
                  if (zeichen == 1){
                    zustand = z1;
                  }
                  if ((zeichen >=3 )&& (zeichen<=9)){
                      zustand = z3;
                }





                    break;
                case z1:

                    break;
                case z2:


                    break;
                case z3:


                    break;
                case z4:


                    break;
                case z5:


                    break;
                default:

            }
            zeichen = cutFirst();
        }
        return (zustand == z3 && (zeichen == '$'));
    }
}
