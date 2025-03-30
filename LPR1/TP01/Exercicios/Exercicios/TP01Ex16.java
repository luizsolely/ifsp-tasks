package Exercicios;

import java.util.Scanner;

public class TP01Ex16 {
    public static double anguloEmRadianos(int angulo){
        return angulo * Math.PI / 180;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite o angulo: ");
        int angulo= scanner.nextInt();
        double seno = Math.sin(anguloEmRadianos(angulo));
        double cosseno = Math.cos(anguloEmRadianos(angulo));
        double tangente = Math.tan(anguloEmRadianos(angulo));
        double secante = 1/cosseno;
        System.out.printf("Seno: %.4f\n", seno);
        System.out.printf("Cosseno: %.4f\n", cosseno);
        System.out.printf("Tangente: %.4f\n", tangente);
        System.out.printf("Secante: %.4f\n", secante);
        scanner.close();
    }
}
//Dupla: Andre Luiz e Luiz Felipe  Ex: Entrar via teclado com o valor de um ângulo em graus, calcular e exibir as seguintes funções trigonométricas: seno, cosseno, tangente e secante deste ângulo. Lembre-se que uma função trigonométrica trabalha em radianos.
