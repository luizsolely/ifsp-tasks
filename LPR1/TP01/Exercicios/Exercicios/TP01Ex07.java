package Exercicios;

import java.util.Scanner;

public class TP01Ex07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite o primeiro valor: ");
        double valor1 = scanner.nextDouble();

        System.out.print("Digite o segundo valor: ");
        double valor2 = scanner.nextDouble();

        double mediaGeometrica = Math.sqrt(valor1 * valor2);

        System.out.printf("A média geométrica é: %.2f\n", mediaGeometrica);

        scanner.close();
    }
}



//Dupla: Andre Luiz e Luiz Felipe  Ex: Calcular e exibir a média geométrica de dois valores quaisquer que serão digitados.