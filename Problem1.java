import java.util.Scanner;
class Problem1 {
    public static void main(String[] args) {
        Scanner variavel = new Scanner (System.in);
        int p, A, B, numpontos;
        numpontos = 1;
        System.out.println("Digite o número primo p:");
        p = variavel.nextInt();
        System.out.println("Digite A:");
        A = variavel.nextInt();
        System.out.println("Digite B:");
        B = variavel.nextInt();
        if (4*(Math.pow(A,3)) + 27*(Math.pow(B,2))!=0 && p>1){ // Condição para curva elíptica não singular
        int y2[] = new int [p]; 
        for (int i = 0; i < p;i++){
            y2 [i] = (int)((Math.pow(i,2)) % 47); // Vetor com módulos em relação a y
        }
        int x2[] = new int [p]; 
        for (int i = 0; i < p;i++){
            x2 [i] = (int)(((Math.pow(i,3)) + A*i + B) % 47); // Vetor com módulos em relação a x
        }
        for (int i = 0; i < x2.length; i++){
            for (int j = 0; j < y2.length; j++){
                if (x2[i] == y2[j] ){
                    numpontos++; // Incrementação do número de pontos na curva
                    System.out.println("<"+ i+ ","+ j + ">"); // Print dos pontos x e y cujo módulo é o mesmo
            }
        }
    }System.out.println("A curva tem " + numpontos + 
            " pontos incluindo o ponto no infinito");
    }else{
        System.out.println("Valores para A, B ou p não são aceitáveis");
    }
}
}
