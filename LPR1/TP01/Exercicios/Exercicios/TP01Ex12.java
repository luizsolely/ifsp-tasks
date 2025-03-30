package Exercicios;

import java.util.Scanner;

public class TP01Ex12 {
     public static double volumeCone(double raio, double altura, double base){
        return ((raio*raio) * Math.PI * altura) / 3;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite o raio do cone: ");
        double raio = scanner.nextDouble();
        System.out.println("Digite a altura do cone: ");
        double altura = scanner.nextDouble();
        System.out.println("Digite a base do cone: ");
        double base = scanner.nextDouble();
        System.out.printf("O volume do cone e: %.2f\n", volumeCone(raio, altura, base));
        scanner.close();
    }
}
//Dupla: Andre Luiz e Luiz Felipe  Ex: Calcular e exibir o volume de um cone a partir dos valores da altura e do raio da base que serão digitados.
