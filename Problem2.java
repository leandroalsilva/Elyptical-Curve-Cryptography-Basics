import java.util.Scanner;
public class Problem2 {

    public static void main(String[] args) {

        Scanner scan = new Scanner (System.in);
        int xp,yp;
        int xq,yq;
        int tam_campo;
        int a;
        
        
        int xr,yr;
        System.out.println("Entre com a:");
        a = scan.nextInt();        
        System.out.println("Entre com o tamanho do campo:");
        tam_campo = scan.nextInt();
        System.out.println("Entre com xp:");
        System.out.println("Entre com o primeiro Ponto P:");
        System.out.println("Entre com xp:");
        xp = scan.nextInt();
        System.out.println("Entre com yp:");
        yp = scan.nextInt();
        System.out.println("Entre com o segundo Ponto Q:");
        System.out.println("Entre com xq:");
        xq = scan.nextInt();
        System.out.println("Entre com yq:");
        yq = scan.nextInt();
        
        while (true){
//            System.out.println("Somando...");
//            System.out.println("P = "+ "("+xp+","+yp+")");
//            System.out.println("Q = "+ "("+xq+","+yq+")");
            int lambda;
            if (xp == xq && yp == yq){
                if(yp == 0){
                    System.out.println("Ponto R esta no infinito");
                    break;        
                }
                else{
                    int numerador = (int)(3*(float)Math.pow(xp,2) + a) ;
                    int denominador = 2 * yp;
                    if (numerador <0 && denominador <0){
                        numerador = Math.abs(numerador);
                        denominador = Math.abs(denominador);
                    }else if(denominador <0){
                        numerador = - numerador;
                        denominador = Math.abs(denominador);
                    }
                    numerador = numerador % tam_campo;
                    if(numerador <0) numerador += tam_campo;
                    denominador = getInverse(denominador, tam_campo);
                    lambda = numerador*denominador;
                    lambda = lambda % tam_campo;
                    if(lambda <0) lambda += tam_campo;                 
                }
  
            }
            else if (xp == xq && yp != yq){
                System.out.println("Ponto R esta no infinito");
                System.out.println("R = "+"("+xq+","+yq+")");
                break;
            }
            else{
                int numerador = (yq-yp) ;
                int denominador = (xq-xp);
                if (numerador <0 && denominador <0){
                    numerador = Math.abs(numerador);
                    denominador = Math.abs(denominador);
                }
                else if(denominador <0){
                    numerador = - numerador;
                    denominador = Math.abs(denominador);
                }
                numerador = numerador % tam_campo;
                if(numerador <0) numerador += tam_campo;
                denominador = getInverse(denominador, tam_campo);    
                lambda = numerador*denominador;
                lambda = lambda % tam_campo;
                if(lambda <0) lambda += tam_campo;
            }
            xr = (int)((float)Math.pow(lambda,2) - xp - xq);
            xr = xr % tam_campo;
            if(xr <0) xr += tam_campo;
            yr = lambda*(xp - xr) - yp;
            yr = yr % tam_campo;
            if(yr <0) yr += tam_campo;
            System.out.println("R = "+ "("+xr+","+yr+")");

            xp = xr;          
            yp = yr;
        }

    }
    public static int getInverse(int number, int modnum)
	{
            number = number % modnum;
            for (int x = 1; x < modnum; x++)
               if ((number * x) % modnum == 1)
                  return x;
            return 1;
	}
}
