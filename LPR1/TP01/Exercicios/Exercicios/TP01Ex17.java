package Exercicios;

import java.util.Scanner;

public class TP01Ex17 {
    public static double xelevadoY(int x, int y){
        return Math.pow(x, y);
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite o valor de x: ");
        int x= scanner.nextInt();
        System.out.println("Digite o valor de y: ");
        int y= scanner.nextInt();
        System.out.printf("O valor de x elevado a y e: ", xelevadoY(x, y) );
        scanner.close();
    }
}
//Dupla: Andre Luiz e Luiz Felipe  Ex: Entrar via teclado com dois valores quaisquer “X” e “Y”. Calcular e exibir o cálculo XY (“X” elevado a “Y”). Pesquisar as funções Exp e Ln.
