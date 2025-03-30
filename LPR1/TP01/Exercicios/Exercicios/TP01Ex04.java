package Exercicios;

import java.util.Scanner;

public class TP01Ex04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite a base de um triângulo: ");
        double base = scanner.nextDouble();

        System.out.print("Digite a altura de um triângulo: ");
        double altura = scanner.nextDouble();

        System.out.printf("A área do triângulo é: %.2f\n", (base*altura)/2);
        scanner.close();
    }
}
//Dupla: Andre Luiz e Luiz Felipe  Ex: A partir dos valores da base e altura de um triângulo, calcular e exibir sua área.