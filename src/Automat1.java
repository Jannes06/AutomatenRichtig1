import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Automat1 {
    String parseStrg;
    boolean ok = true;
    char zeichen;

    // Konstruktor 

    public Automat1(String s) {
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
        final int z0 = 0, z1 = 1, z2 = 2, z3 = 3, err = 4;
        zeichen = cutFirst();
        int zustand = z0;
        while (zeichen != '$') {
            switch (zustand) {
                case z0:
                    if (zeichen >= '0' && zeichen <= '9')
                        zustand = z1;
                    else
                        zustand = err;
                    break;
                case z1:
                    if (zeichen >= '0' && zeichen <= '9')

                        zustand = z1;
                    else if (zeichen == '*' || zeichen == '+')
                        zustand = z2;
                    else
                        zustand = err;
                    break;
                case z2:
                    if (zeichen >= '0' && zeichen <= '9')
                        zustand = z3;
                    else
                        zustand = err;
                    break;
                case z3:
                    if (zeichen >= '0' && zeichen <= '9')
                        zustand = z3;
                    else if (zeichen == '*' || zeichen == '+')
                        zustand = z2;
                    else
                        zustand = err;
                default:

            }
            zeichen = cutFirst();
        }
        return (zustand == z3 && (zeichen == '$'));
    }
}

