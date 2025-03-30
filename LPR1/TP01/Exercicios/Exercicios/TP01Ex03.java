package Exercicios;

import java.util.Scanner;

public class TP01Ex03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite a diagonal de um quadrado: ");
        double diagonal = scanner.nextDouble();

        double area = (diagonal * diagonal) / 2;

        System.out.printf("A área do quadrado é: %.2f\n", area);
        scanner.close();
    }
}
//Dupla: Andre Luiz e Luiz Felipe  Ex: Calcular e exibir a área de um quadrado a partir do valor de sua diagonal que será digitado.