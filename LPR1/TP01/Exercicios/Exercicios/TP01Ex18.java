package Exercicios;

import java.util.Scanner;

public class TP01Ex18 {
     public static double totalProduto(double p1, double p2, double p3, double p4, double p5){
        return p1+p2+p3+p4+p5;    
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite o valor do produto1: ");
        double p1= scanner.nextDouble();
        System.out.println("Digite o valor do produto2: ");
        double p2= scanner.nextDouble();
        System.out.println("Digite o valor do produto3: ");
        double p3= scanner.nextDouble();
        System.out.println("Digite o valor do produto4: ");
        double p4= scanner.nextDouble();
        System.out.println("Digite o valor do produto5: ");
        double p5= scanner.nextDouble();
        System.out.println("O valor total da compra e de: "+ totalProduto(p1, p2, p3, p4, p5));
        System.out.println("Digite quanto ira pagar: ");
        double valor = scanner.nextDouble();
        if(valor >= totalProduto(p1, p2, p3, p4, p5))
            System.out.printf("Seu troco sera de: %.2f\n", valor - totalProduto(p1, p2, p3, p4, p5) );
        else{
            System.out.println("O valor do troco deve ser maior que a soma dos produtos!");
        }
    
        scanner.close();
    }
}
//Dupla: Andre Luiz e Luiz Felipe  Ex: Entrar via teclado com o valor de cinco produtos. Após as entradas, digitar um valor referente ao pagamento da somatória destes valores. Calcular e exibir o troco que deverá ser devolvido.
