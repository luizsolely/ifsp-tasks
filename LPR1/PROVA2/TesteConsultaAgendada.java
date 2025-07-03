import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class TesteConsultaAgendada {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try (PrintWriter writer = new PrintWriter(new FileWriter("resultado_exercicio3.txt"))) {

            writer.println("=== TESTE INTERATIVO DA CLASSE CONSULTAAGENDADA ===\n");

            writer.println("1. Criando objeto p1 com construtor parametrizado...");
            ConsultaAgendada p1 = new ConsultaAgendada(
                    14, 30, 0,
                    15, 3, 2024,
                    "João Silva",
                    "Dr. Maria Santos"
            );
            writer.println("Objeto p1 criado com sucesso!\n");

            writer.println("2. Exibindo todas as propriedades de p1:");
            escreverPropriedades(writer, "p1", p1);

            writer.println("3. Criando objeto p2 com construtor padrão...");
            System.out.println("   ATENÇÃO: O sistema solicitará a entrada de dados!");
            System.out.print("Pressione ENTER para continuar...");
            scanner.nextLine();

            ConsultaAgendada p2 = new ConsultaAgendada();
            writer.println("Objeto p2 criado com sucesso!\n");

            writer.println("4. Exibindo todas as propriedades de p2:");
            escreverPropriedades(writer, "p2", p2);

            writer.println("5. Alterando propriedades de p1 usando métodos set...");
            System.out.println("   O sistema solicitará a entrada de novos dados para p1!");
            System.out.print("Pressione ENTER para continuar...");
            scanner.nextLine();

            System.out.println("\n   Alterando data de p1:");
            p1.setData();

            System.out.println("\n   Alterando hora de p1:");
            p1.setHora();

            System.out.println("\n   Alterando nome do paciente de p1:");
            p1.setNomePaciente();

            System.out.println("\n   Alterando nome do médico de p1:");
            p1.setNomeMedico();

            writer.println("\n   Alterações realizadas com sucesso!\n");

            writer.println("6. Exibindo todas as propriedades de p1 após alterações:");
            escreverPropriedades(writer, "p1", p1);

            writer.println("=== RESUMO DO TESTE ===");
            writer.println("Consulta p1 (após alterações): " + p1.toString());
            writer.println("Consulta p2 (original): " + p2.toString());
            writer.println("Total de consultas agendadas: " + ConsultaAgendada.getQuantidade());

            System.out.println("\nOs resultados foram salvos no arquivo 'resultado_exercicio3.txt'.");

        } catch (IOException e) {
            System.out.println("Erro ao escrever no arquivo: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Erro durante o teste: " + e.getMessage());
            e.printStackTrace();
        } finally {
            scanner.close();
        }
    }

    private static void escreverPropriedades(PrintWriter writer, String nomeObjeto, ConsultaAgendada consulta) {
        writer.println("   === Propriedades de " + nomeObjeto + " ===");
        writer.println("   Data: " + consulta.getData());
        writer.println("   Hora: " + consulta.getHora());
        writer.println("   Nome do Paciente: " + consulta.getNomePaciente());
        writer.println("   Nome do Médico: " + consulta.getNomeMedico());
        writer.println("   Quantidade total de consultas: " + ConsultaAgendada.getQuantidade());
        writer.println();
    }
}
