package Exercicios;

import java.util.Scanner;

public class TP01Ex11 {
    public static double areaCirculo(double raio){
        return (raio*raio) * Math.PI;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite o diametro do circulo: ");
        double raio = scanner.nextDouble() / 2;
        System.out.printf("O valor da area do circulo e: %.2f\n", areaCirculo(raio));
        scanner.close();
    }
}
//Dupla: Andre Luiz e Luiz Felipe  Ex: A partir do diâmetro de um círculo que será digitado, calcular e exibir sua área.
