package Exercicios;

import java.util.Scanner;

public class TP01Ex06 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite o primeiro valor: ");
        double v1 = scanner.nextDouble();

        System.out.print("Digite o segundo valor: ");
        double v2 = scanner.nextDouble();

        System.out.print("Digite o terceiro valor: ");
        double v3 = scanner.nextDouble();

        System.out.print("Digite o quarto valor: ");
        double v4 = scanner.nextDouble();

        double media = (v1 + v2 + v3 + v4) / 4;

        System.out.printf("A média aritmética é: %.2f\n", media);

        scanner.close();
    }
}


//Dupla: Andre Luiz e Luiz Felipe  Ex: Calcular e exibir a média aritmética de quatro valores quaisquer que serão digitados.