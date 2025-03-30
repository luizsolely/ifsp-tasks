package Exercicios;

import java.util.Scanner;

public class TP01Ex05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite o diâmetro da esfera: ");
        double diametro = scanner.nextDouble();

        double raio = diametro / 2;

        double volume = (4.0 / 3.0) * Math.PI * Math.pow(raio, 3);

        System.out.printf("O volume da esfera é: %.2f\n", volume);

        scanner.close();
    }
}

//Dupla: Andre Luiz e Luiz Felipe  Ex: Calcular e exibir o volume de uma esfera a partir do valor de seu diâmetro que será digitado.