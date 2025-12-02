/*
 Nome: Luiz Gustavo Verissimo Monteiro
 Prontuário: CB3030326

 Nome: Luiz Felipe Gonçalves da Silva
 Prontario: CB3030539
*/
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ConexaoSQLServer {
    
    private static final String url = "jdbc:sqlserver://localhost:1433;databaseName=aulajava;encrypt=false;trustServerCertificate=true";
    private static final String user = "user2";
    private static final String password = "Senha@123";

     public static void inicializarBanco() {

        try (Connection conn = DriverManager.getConnection(url, user, password);
             Statement stmt = conn.createStatement()) {

            System.out.println("Conectado ao SQL Server!");

        } catch (SQLException e) {
            System.out.println("Erro no SQL: " + e.getMessage());
        }
    }

    public static List<Paciente> listarFuncionarios() {

        inicializarBanco(); // garante tabelas antes de listar

        List<Paciente> listaDeFuncionarios = new ArrayList<>();
        String sqlSelect =
                "SELECT f.cod_func, f.nome_func, f.sal_func, c.ds_cargo " +
                "FROM tbfuncs f " +
                "JOIN tbcargos c ON f.cod_cargo = c.cod_cargo";

        try (Connection conn = DriverManager.getConnection(url, user, password);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sqlSelect)) {

            while (rs.next()) {
                listaDeFuncionarios.add(
                    new Paciente(
                        rs.getInt("cod_paciente"),
                        rs.getInt("idade_paciente"),
                        rs.getString("nome_paciente"),
                        rs.getFloat("peso_paciente"),
                        rs.getFloat("altura_paciente")
                    ));
            }

        } catch (SQLException e) {
            System.out.println("Erro no select: " + e.getMessage());
        }
        return listaDeFuncionarios;
    }
    public static List<Paciente> pesquisarFuncionarios(String nome) {
        List<Paciente> lista = new ArrayList<>();
        String sql = "SELECT f.cod_func, f.nome_func, f.sal_func, c.ds_cargo " +
                        "FROM tbfuncs f " +
                        "JOIN tbcargos c ON f.cod_cargo = c.cod_cargo " +
                        "WHERE f.nome_func LIKE ?";
        try (Connection conn = DriverManager.getConnection(url, user, password);
            PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, "%" + nome + "%");
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
            lista.add(new Paciente(
                    rs.getInt("cod_paciente"),
                    rs.getInt("idade_paciente"),
                    rs.getString("nome_paciente"),
                    rs.getFloat("peso_paciente"),
                    rs.getFloat("altura_paciente")
                ));
        }
        } catch (SQLException e) {
            System.out.println("Erro na pesquisa: " + e.getMessage());
        }
    return lista;
    }
}