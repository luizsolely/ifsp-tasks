package Exercicios;

import java.util.Scanner;

public class TP01Ex13 {
     public static double velocidadeFinal(double vo, double aceleracao, double tempo){
        return vo +aceleracao*tempo ;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite a velocidade inicial: ");
        double vo= scanner.nextDouble();
        System.out.println("Digite a aceleracao: ");
        double aceleracao = scanner.nextDouble();
        System.out.println("Digite o tempo: ");
        double tempo = scanner.nextDouble();
        System.out.printf("A velocidade final e: %.2f\n", velocidadeFinal(vo, aceleracao, tempo), " m/s");
        scanner.close();
    }
}
//Dupla: Andre Luiz e Luiz Felipe  Ex: Calcular e exibir a velocidade final (em km/h) de um automóvel, a partir dos valores da velocidade inicial (em m/s), da aceleração (m/s2) e do tempo de percurso (em s) que serão digitados.
