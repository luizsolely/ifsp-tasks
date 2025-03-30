package Exercicios;

import java.util.Scanner;

public class TP01Ex02 {
    public static double areaQuadrado(int aresta){
        return Math.pow(aresta, 2);
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite a aresta de um quadrado: ");
        int aresta = scanner.nextInt();

        System.out.printf("A Área do quadrado é: " + areaQuadrado(aresta));
        scanner.close();
    }
}
//Dupla: Andre Luiz e Luiz Felipe  Ex: 2. Calcular e exibir a área de um quadrado, a partir do valor de sua aresta que será digitado.
