import java.sql.SQLOutput;

public class Grammatik1 {
    String aussage;

    public Grammatik1(){
        for (int i=0;i<10;i++){
         System.out.println(""+Aussage()+"");
        }

    }
    public String Aussage () {
        aussage = "";
        final int z0 = 0, z1 = 1, z2 = 2, z3 = 3, err = 4;
        int random;
        int zustand = z0;
        while (zustand != '$') {

            switch(zustand) {

                case z0:
                    int zahl =  (int)(Math.random()*9+1);
                     aussage = aussage + zahl;
                    zustand = z1;

                    break;

                case z1 : //Eine Zahl von Null bis Neun wird angehangen und wiederholt, oder das Zeichen * | + wird angehangen

                    random = (int)(Math.random()*2+1);

                    //Entweder Zahl
                    if (random ==1){
                         zahl =  (int)(Math.random()*9+1);
                        aussage = aussage + zahl;
                        zustand = z1;

                    }
                    //Oder Zeichen + | *
                    if (random ==2){
                      int  random1 = (int)(Math.random()*2+1);
                        //Entweder *
                         if (random1 ==1){
                             aussage = aussage + '*';
                         }
                         if (random1 ==2){
                            aussage = aussage + '+';
                         }
                       zustand = z2;
                    }

                    break;
                case z2 :
                    zahl =  (int)(Math.random()*9+1);
                    aussage = aussage + zahl;
                    zustand = z3;
                    break;


                case z3:

                    random = (int)(Math.random()*3+1);
                    //Entweder Zahl
                    if (random ==1){
                        zahl =  (int)(Math.random()*9+1);
                        aussage = aussage + zahl;
                        zustand = z3;
                    }
                    //Oder Zeichen + | *
                    if (random ==2){
                        int random1 = (int)(Math.random()*2+1);
                        //Entweder *
                         if (random1 ==1){
                            aussage = aussage + '*';
                         }
                         if (random1 ==2){
                            aussage = aussage + '+';
                         }
                        zustand = z2;
                    }
                    //Oder Ende
                    if (random ==3) {
                        zustand = '$';
                    }
                    break;
                default:

            }

        }

        return aussage;
    }
}
