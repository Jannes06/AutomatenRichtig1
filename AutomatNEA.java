public class AutomatNEA {
  
  private Zustand startzustand;
  private List<Zustand> aktiveZustaende;
  
  public class Q0 extends Zustand {
    
    public Q0() {
      super();
    }
    
    public List<Zustand> gibFolgezustaende1() {
      return null;
    }
    
    public boolean istEndzustand() {
      return false;
    }
    
  }
  
  public class Q1 extends Zustand {
  
    public Q1() {
      super();
    }

    public List<Zustand> gibFolgezustaende0() {
      return null;
    }
    
    public boolean istEndzustand() {
      return false;
    }
    
  }

  public class Q2 extends Zustand {
  
    public Q2() {
      super();
    }

    public List<Zustand> gibFolgezustaende1() {
      return null;
    }
    
    public boolean istEndzustand() {
      return false;
    }
    
  }
  
  public class Q3 extends Zustand {
  
    public Q3() {
      super();
    }

    public List<Zustand> gibFolgezustaende0() {
      return null;
    }
    
    public boolean istEndzustand() {
      return false;
    }
    
  }
  
  public void pruefeWort(String pWort) {
    
  }

  public boolean akzeptiert() {
    return false;
  }
  
}
