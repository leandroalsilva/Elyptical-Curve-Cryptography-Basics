import java.util.Scanner;
public class Problem2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner (System.in);
        int xp,yp,xq,yq,p,a,b,xr,yr;
        System.out.println("Digite A:");
        a = scan.nextInt();
        System.out.println("Digite B:");
        b = scan.nextInt();          
        System.out.println("Digite p:");
        p = scan.nextInt();
        System.out.println("Digite Xp:");
        xp = scan.nextInt();
        System.out.println("Digite Yp:");
        yp = scan.nextInt();
        System.out.println("Digite Xq:");
        xq = scan.nextInt();
        System.out.println("Digite Yq:");
        yq = scan.nextInt();
        if (4*(Math.pow(a,3)) + 27*(Math.pow(b,2))==0 || p<=1){ // Condição para curva elíptica não singular
           System.out.println("A e B não são aceitáveis");
           return;         
        } 
        while (true){
            int lambda;
            if (xp == xq && yp == yq){ // Loop que roda enquanto o ponto final não for igual ao inicial
                if(yp == 0){
                    System.out.println("Ponto R está no infinito");
                    break;        
                }
                else{
                    int numerador = (int)(3*(float)Math.pow(xp,2) + a) ; // Equação do numerador da inclinação da reta para pontos iguais
                    int denominador = 2 * yp; // Equação do denominador da inclinação da reta para pontos iguais
                    if (numerador <0 && denominador <0){
                        numerador = Math.abs(numerador);
                        denominador = Math.abs(denominador);
                    }else if(denominador <0){
                        numerador = - numerador;
                        denominador = Math.abs(denominador);
                    }
                    numerador = numerador % p;
                    if(numerador <0) numerador += p;
                    denominador = getInverse(denominador, p); 
                    lambda = numerador*denominador; // Cálculo da fração em relação ao modular p
                    lambda = lambda % p;
                    if(lambda <0) lambda += p;                 
                }  
            }
            else if (xp == xq && yp != yq){
                System.out.println("Ponto R está no infinito");
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
                numerador = numerador % p;
                if(numerador <0) numerador += p;
                denominador = getInverse(denominador, p);    
                lambda = numerador*denominador;
                lambda = lambda % p;
                if(lambda <0) lambda += p;
            }
            xr = (int)((float)Math.pow(lambda,2) - xp - xq);
            xr = xr % p;
            if(xr <0) xr += p;
            yr = lambda*(xp - xr) - yp;
            yr = yr % p;
            if(yr <0) yr += p;
            System.out.println("R = "+ "("+xr+","+yr+")");

            xp = xr;          
            yp = yr;
        }

    }
    public static int getInverse(int numerador, int modnum) // Função para achar o multiplicador modular inverso
	{
            numerador = numerador % modnum;
            for (int x = 1; x < modnum; x++)
               if ((numerador * x) % modnum == 1)
                  return x;
            return 1;
	}
}
