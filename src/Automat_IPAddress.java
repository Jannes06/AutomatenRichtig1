import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLOutput;

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
        while (zeichen != '$' ) {
            switch (zustand) {

                case z0: //-----------------------------------------------------

                  if (zeichen == '0'){
                    zustand = z5;
                  }
                 else if (zeichen == '1'){
                    zustand = z1;

                  }
                else if (zeichen == '2'){
                    zustand = z2;
                  }
                 else if ((zeichen >='3' )&& (zeichen<='9')){
                      zustand = z3;
                      System.out.println("test");
                  }
                 else {zustand =err;}
                    break;

                case z1://-----------------------------------------------------------
                    if ((zeichen >='0' )&& (zeichen<='9')){
                        zustand = z3;
                    }
                    else {zustand = err;}
                    break;

                case z2://------------------------------------------------------------
                    if ((zeichen >='0' )&& (zeichen<='4')){
                        zustand = z3;
                    }
                   else  if ((zeichen >='6' )&& (zeichen<='9')){
                        zustand = z5;
                    }
                   else if (zeichen == '5'){
                        zustand = z4;
                    }
                   else {zustand =err;}
                    break;

                case z3://------------------------------------------------------------
                    if ((zeichen >='0' )&& (zeichen<='9')){
                        zustand = z5;
                    }
                    else {zustand = err;}

                    break;

                case z4://------------------------------------------------------------
                    if ((zeichen >='0' )&& (zeichen<='5')){
                        zustand = z5;
                    }
                    else {zustand =err;}

                    break;

                case z5://-----------------------------------------------------------
                    if (zeichen != '$') {
                        zustand = err;
                    }
                    break;
                default:
            }
            zeichen = cutFirst();
        }
        return (zustand !=z0 && zustand != err  && (zeichen == '$'));
    }
}
