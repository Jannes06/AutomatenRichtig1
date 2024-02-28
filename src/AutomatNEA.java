public class AutomatNEA {

  private Zustand startzustand;
   String parseStrg;
   char zeichen;
  private List <Zustand> aktiveZustaende;

  public class Q0 extends Zustand {

    public Q0() {
      super();
    }

    public List<Zustand> gibFolgezustaendeA() {
      Q1 q1 = new Q1();
      List folgezustaende = new List <Zustand>();
      folgezustaende.append(q1);
      return folgezustaende;
    }

    public List<Zustand> gibFolgezustaendeB() {
      Q1 q1 = new Q1();
      Q2 q2 = new Q2();
    List folgezustaende = new List <Zustand>();
     folgezustaende.append(q1);
     folgezustaende.append(q2);
     return folgezustaende;
    }



    public boolean istEndzustand() {
      return true;
    }

  }

  public class Q1 extends Zustand {

    public Q1() {
      super();
    }

    public List<Zustand> gibFolgezustaendeB() {
      Q2 q2 = new Q2();
      List folgezustaende = new List <Zustand>();
      folgezustaende.append(q2);
      return folgezustaende;
    }

    public boolean istEndzustand() {
      return true;
    }

  }

  public class Q2 extends Zustand {

    public Q2() {
      super();
    }

    public List<Zustand> gibFolgezustaendeA() {
      Q1 q1 = new Q1();
      List folgezustaende = new List <Zustand>();
      folgezustaende.append(q1);
      return folgezustaende;
    }

    public boolean istEndzustand() {
      return false;
    }

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

  public void pruefeWort(String pWort) {
    aktiveZustaende = new List<>();
    parseStrg = pWort;
    zeichen = cutFirst();

    Q0 q0 = new Q0();
    aktiveZustaende.append(q0);

    while(zeichen != '$') {

      List <Zustand> speicher = new List<>();
      aktiveZustaende.toFirst();

      if (zeichen == 'a') {
        while (aktiveZustaende.hasAccess()) {
          speicher.concat(aktiveZustaende.getContent().gibFolgezustaendeA());
          aktiveZustaende.next();
        }
      }

        if (zeichen == 'b') {
          while (aktiveZustaende.hasAccess()) {
          speicher.concat(aktiveZustaende.getContent().gibFolgezustaendeB());
          aktiveZustaende.next();
        }
      }
        aktiveZustaende = speicher;
      zeichen=cutFirst();
    }
    System.out.println("Ergebnis");
    while (!aktiveZustaende.isEmpty()) {
      aktiveZustaende.toFirst();
      if (aktiveZustaende.getContent().istEndzustand()) {
        System.out.println("richtig");
        return;
      }

      aktiveZustaende.remove();
    }
    System.out.println("false");
  }


  public boolean akzeptiert() {
    return false;
  }
  
}
