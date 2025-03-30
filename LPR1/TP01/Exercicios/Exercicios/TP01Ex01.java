package Exercicios;

import java.util.Scanner;

public class TP01Ex01 {
    public static double areaRetangulo(int base, int altura){
        return base*altura;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite a base de um retângulo: ");
        int base = scanner.nextInt();

        System.out.println("Digite a base de um retângulo: ");
        int altura = scanner.nextInt();

        System.out.printf("A Área do retângulo é: " + areaRetangulo(base, altura));
        scanner.close();
    }
}
//Dupla: Andre Luiz e Luiz Felipe  Ex: 1. Entrar via teclado com a base e a altura de um retângulo, calcular e exibir sua área.
