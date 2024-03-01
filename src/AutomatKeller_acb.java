public class AutomatKeller_acb {
    String parseStrg;
    boolean ok = true;
    char zeichen;

    // Konstruktor

    public AutomatKeller_acb(String s) {
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
        final int z0 = 0, z1 = 1, err = 2;
        zeichen = cutFirst();
        int zustand = z0;
        Stack <String> speicher = new Stack<>();
        speicher.push("#");
        while (zeichen != '$') {
            switch (zustand) {

                case z0: //================================================

                        if (zeichen == 'a') {
                            if (speicher.top() == "#") {
                                speicher.push("a");
                                zustand = z1;
                            }
                        }
                        else if (zeichen == 'b') {
                            if (speicher.top() == "#") {
                                speicher.push("b");
                                zustand = z1;
                            }
                        }
                       else  if (zeichen == 'c') {
                           zustand = z0;
                        }
                       else {zustand = err;}

                       break;
                case z1:   //======================================================
                    if (zeichen == 'a') {
                        if (speicher.top() == "#") {
                            speicher.push("a");
                            zustand = z1;
                        }
                        else if (speicher.top() == "a") {
                            speicher.push("a");
                            zustand = z1;
                        }
                        else if (speicher.top() == "b") {
                            speicher.pop();
                            zustand = z1;
                        }
                    }
                   else if (zeichen == 'b') {
                        if (speicher.top() == "#") {
                            speicher.push("b");
                            zustand = z1;
                        }
                      else  if (speicher.top() == "b") {
                            speicher.push("b");
                            zustand = z1;
                        }
                      else  if (speicher.top() == "a") {
                            speicher.pop();
                            zustand = z1;
                        }
                    }
                    else if (zeichen == 'c') {
                        zustand = z1;
                    }
                    else {zustand = err;}
                    
                    break;

                default:

            }
            zeichen = cutFirst();
        }
        return((speicher.top()=="#") && zeichen == '$'&& zustand!=err );


        
    }





}
