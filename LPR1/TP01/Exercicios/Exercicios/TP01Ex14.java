package Exercicios;

import java.util.Scanner;

public class TP01Ex14 {
    public static double volumeCubo(double ladoCubo){
        return Math.pow(ladoCubo, 3) ;
    }
    public static double volumeEsfera(double raioEsfera){
        return 4.0/3.0 * Math.PI * Math.pow(raioEsfera, 3) ;
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite o lado do cubo ");
        double ladoCubo= scanner.nextDouble();
        System.out.println("Digite o raio da esfera: ");
        double raioEsfera= scanner.nextDouble();
        double volumeLivre = volumeCubo(ladoCubo) - volumeEsfera(raioEsfera);
        System.out.printf("A volume livre sera: %.2f\n", volumeLivre);
        scanner.close();
    }
}
//Dupla: Andre Luiz e Luiz Felipe  Ex: Calcular e exibir o volume livre de um ambiente que contém uma esfera de raio “r” inscrita em um cubo perfeito de aresta “a”. Os valores de “r “ e “a” serão digitados.
