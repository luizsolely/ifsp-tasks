/*
 Nome: Luiz Gustavo Verissimo Monteiro
 Prontuário: CB3030326

 Nome: Luiz Felipe Gonçalves da Silva
 Prontario: CB3030539
*/

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ConexaoPostgres {

    private static final String url = "jdbc:postgresql://localhost:5432/provajava2";
    private static final String user = "luizfelipeeluizgustavo";
    private static final String password = "123";

    static {
        inicializarBanco();
    }

    public static void inicializarBanco() {
        try (Connection conn = DriverManager.getConnection(url, user, password)) {
            criarTabelaSeNaoExistir(conn);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void criarTabelaSeNaoExistir(Connection conn) throws SQLException {

        String sql = """
            CREATE TABLE IF NOT EXISTS tbpacientes (
                cod_paciente SERIAL PRIMARY KEY,
                nome_paciente VARCHAR(100) NOT NULL,
                idade_paciente INT NOT NULL,
                peso_paciente REAL NOT NULL,
                altura_paciente REAL NOT NULL
            );
        """;

        try (Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
        }
    }

    public static void inserirPaciente(Paciente p) {

        String sql = """
            INSERT INTO tbpacientes (nome_paciente, idade_paciente, peso_paciente, altura_paciente)
            VALUES (?, ?, ?, ?)
        """;

        try (Connection conn = DriverManager.getConnection(url, user, password);
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, p.getNome_paciente());
            stmt.setInt(2, p.getIdade_paciente());
            stmt.setFloat(3, p.getPeso_paciente());
            stmt.setFloat(4, p.getAltura_paciente());
            stmt.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Erro no insert: " + e.getMessage());
        }
    }

    public static List<Paciente> listarPacientes() {

        List<Paciente> lista = new ArrayList<>();
        String sql = "SELECT * FROM tbpacientes ORDER BY cod_paciente";

        try (Connection conn = DriverManager.getConnection(url, user, password);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                lista.add(
                        new Paciente(
                                rs.getInt("cod_paciente"),
                                rs.getInt("idade_paciente"),
                                rs.getString("nome_paciente"),
                                rs.getFloat("peso_paciente"),
                                rs.getFloat("altura_paciente")
                        )
                );
            }

        } catch (SQLException e) {
            System.out.println("Erro no select: " + e.getMessage());
        }

        return lista;
    }

    public static List<Paciente> pesquisarPacientes(String nome) {

        List<Paciente> lista = new ArrayList<>();

        String sql = """
            SELECT * FROM tbpacientes 
            WHERE nome_paciente LIKE ?
            ORDER BY cod_paciente
        """;

        try (Connection conn = DriverManager.getConnection(url, user, password);
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, "%" + nome + "%");

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                lista.add(
                        new Paciente(
                                rs.getInt("cod_paciente"),
                                rs.getInt("idade_paciente"),
                                rs.getString("nome_paciente"),
                                rs.getFloat("peso_paciente"),
                                rs.getFloat("altura_paciente")
                        )
                );
            }

        } catch (SQLException e) {
            System.out.println("Erro na pesquisa: " + e.getMessage());
        }

        return lista;
    }
}
