package Exercicios;

import java.util.Scanner;

public class TP01Ex08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite a quantidade de milhas marítimas: ");
        double milhas = scanner.nextDouble();

        double quilometros = milhas * 1.852;

        System.out.printf("%.2f milhas marítimas equivalem a %.2f quilômetros.\n", milhas, quilometros);

        scanner.close();
    }
}

//Dupla: Andre Luiz e Luiz Felipe  Ex: Calcular e exibir a média geométrica de dois valores quaisquer que serão digitados.