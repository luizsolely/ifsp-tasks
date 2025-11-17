using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using Microsoft.Win32;

namespace Proj_Filas_Acessos
{
    internal class Program
    {
        static void Main(string[] args)
        {
            int opcao;
            Cadastro gerenciador = new Cadastro();

            do
            {
                Console.WriteLine("\nMenu de opções:" +
                    "\n0. Finalizar processo" +
                    "\n1.Cadastrar ambiente" +
                    "\n2.Consultar ambiente" +
                    "\n3.Excluir ambiente" +
                    "\n4.Cadastrar usuario" +
                    "\n5.Consultar usuario" +
                    "\n6.Excluir usuario" +
                    "\n7.Conceder permissão de acesso ao usuario" + //(informar ambiente e usuário - vincular ambiente ao usuário)"
                    "\n8.Revogar permissão de acesso ao usuario" + //(informar ambiente e usuário - desvincular ambiente do usuário)"
                    "\n9.Registrar acesso" + //(informar o ambiente e o usuário - registrar o log respectivo)"
                    "\n10.Consultar logs de acesso" + //(informar o ambiente e listar os logs - filtrar por logs autorizados / negados" / todos));
                    "\nEscolha a opção desejada: ");
                string inputOpcao = Console.ReadLine();
                if (!int.TryParse(inputOpcao, out opcao))
                {
                    Console.WriteLine("Ocorreu um erro, verifique se digitou corretamente.\n");
                    continue;
                }
                switch (opcao)
                {
                    case 0:
                        break;
                    case 1:
                        Console.WriteLine("\ndigite o ID do novo ambiente: ");
                        if (!int.TryParse(Console.ReadLine(), out int addIDAmbiente))
                        {
                            Console.WriteLine("ID inválido!\n");
                            break;
                        }
                        Console.WriteLine("digite o Nome: ");
                        string addNomeAmbiente = Console.ReadLine();

                        gerenciador.adicionarAmbiente(new Ambiente(addIDAmbiente, addNomeAmbiente));
                        break;
                    case 2:
                        Console.WriteLine("\ndigite o ID do ambiente pesquisado: ");
                        if (!int.TryParse(Console.ReadLine(), out int pesqAmbiente))
                        {
                            Console.WriteLine("ID inválido!\n");
                            break;
                        }
                        Ambiente ambientePesquisado = gerenciador.pesquisarAmbiente(new Ambiente(pesqAmbiente));
                        if (ambientePesquisado.Id == -1)
                        {
                            Console.WriteLine("Ambiente não encontrado!");
                            break;
                        }
                        Console.WriteLine("\n-----Ambiente encontrado-----");
                        Console.WriteLine($"ID: {ambientePesquisado.Id} - Nome: {ambientePesquisado.Nome}\n");
                        break;
                    case 3:
                        Console.WriteLine("\ndigite o ID do ambiente a ser removido: ");
                        if (!int.TryParse(Console.ReadLine(), out int removerAmbiente))
                        {
                            Console.WriteLine("ID inválido!\n");
                            break;
                        }
                        Console.WriteLine(gerenciador.removerAmbiente(new Ambiente(removerAmbiente))
                            ? "Removido com sucesso!"
                            : "Falha ao remover!");
                        break;
                    case 4:
                        Console.WriteLine("\ndigite o ID do novo usuario: ");
                        if (!int.TryParse(Console.ReadLine(), out int addIDUsuario))
                        {
                            Console.WriteLine("ID inválido!\n");
                            break;
                        }
                        Console.WriteLine("digite o Nome: ");
                        string addNomeUsuario = Console.ReadLine();

                        gerenciador.adicionarUsuario(new Usuario(addIDUsuario, addNomeUsuario));
                        break;
                    case 5:
                        Console.WriteLine("\ndigite o ID do usuario pesquisado: ");
                        if (!int.TryParse(Console.ReadLine(), out int pesqUsuario))
                        {
                            Console.WriteLine("ID inválido!\n");
                            break;
                        }
                        Usuario usuarioPesquisado = gerenciador.pesquisarUsuario(new Usuario(pesqUsuario));
                        if (usuarioPesquisado.Id == -1)
                        {
                            Console.WriteLine("Usuário não encontrado!");
                            break;
                        }
                        Console.WriteLine("\n-----usuario encontrado-----");
                        Console.WriteLine($"ID: {usuarioPesquisado.Id} - Nome: {usuarioPesquisado.Nome}\n");
                        break;
                    case 6:
                        Console.WriteLine("\ndigite o ID do usuario a ser removido: ");
                        if (!int.TryParse(Console.ReadLine(), out int removerUsuario))
                        {
                            Console.WriteLine("ID inválido!\n");
                            break;
                        }
                        Console.WriteLine(gerenciador.removerUsuario(new Usuario(removerUsuario))
                            ? "Removido com sucesso!"
                            : "Falha ao remover!");
                        break;
                    case 7:
                        Console.WriteLine("\ndigite o ID do usuario: ");
                        if (!int.TryParse(Console.ReadLine(), out int idU1))
                        {
                            Console.WriteLine("ID inválido!\n");
                            break;
                        }
                        Console.WriteLine("\ndigite o ID do ambiente: ");
                        if (!int.TryParse(Console.ReadLine(), out int idA1))
                        {
                            Console.WriteLine("ID inválido!\n");
                            break;
                        }
                        Usuario u1 = gerenciador.pesquisarUsuario(new Usuario(idU1));
                        if (u1.Id == -1)
                        {
                            Console.WriteLine("Usuário não encontrado!");
                            break;
                        }
                        Ambiente amb1 = gerenciador.pesquisarAmbiente(new Ambiente(idA1));
                        if (amb1.Id == -1)
                        {
                            Console.WriteLine("Ambiente não encontrado!");
                            break;
                        }
                        Console.WriteLine(u1.concederPermissao(amb1)
                            ? "Permissão garantida!"
                            : "Não foi possível garantir permissão (já existe?)");
                        break;
                    case 8:
                        Console.WriteLine("\ndigite o ID do usuario: ");
                        if (!int.TryParse(Console.ReadLine(), out int idU2))
                        {
                            Console.WriteLine("ID inválido!\n");
                            break;
                        }
                        Console.WriteLine("\ndigite o ID do ambiente: ");
                        if (!int.TryParse(Console.ReadLine(), out int idA2))
                        {
                            Console.WriteLine("ID inválido!\n");
                            break;
                        }
                        Usuario u2 = gerenciador.pesquisarUsuario(new Usuario(idU2));
                        if (u2.Id == -1)
                        {
                            Console.WriteLine("Usuário não encontrado!");
                            break;
                        }

                        Ambiente amb2 = gerenciador.pesquisarAmbiente(new Ambiente(idA2));
                        if (amb2.Id == -1)
                        {
                            Console.WriteLine("Ambiente não encontrado!");
                            break;
                        }

                        Console.WriteLine(u2.revogarPermissao(amb2)
                            ? "Permissão revogada!"
                            : "Não foi possível revogar permissão");
                        break;
                    case 9:
                        Console.WriteLine("\ndigite o ID do usuario: ");
                        if (!int.TryParse(Console.ReadLine(), out int idU))
                        {
                            Console.WriteLine("ID inválido!\n");
                            break;
                        }
                        Console.WriteLine("\ndigite o ID do ambiente: ");
                        if (!int.TryParse(Console.ReadLine(), out int idA))
                        {
                            Console.WriteLine("ID inválido!\n");
                            break;
                        }
                        Usuario u = gerenciador.pesquisarUsuario(new Usuario(idU));
                        if (u.Id == -1)
                        {
                            Console.WriteLine("Usuário não encontrado!");
                            break;
                        }

                        Ambiente a = gerenciador.pesquisarAmbiente(new Ambiente(idA));
                        if (a.Id == -1)
                        {
                            Console.WriteLine("Ambiente não encontrado!");
                            break;
                        }
                        bool autorizado = u.Ambientes.Any(x => x.Id == a.Id);
                        Log log = new Log(DateTime.Now, u, autorizado);
                        a.registrarLog(log);

                        Console.WriteLine(autorizado ? "Acesso autorizado." : "Acesso negado.");
                        break;
                    case 10:
                        Console.WriteLine("\ndigite o ID do ambiente: ");
                        if (!int.TryParse(Console.ReadLine(), out int idConsulta))
                        {
                            Console.WriteLine("ID inválido!\n");
                            break;
                        }
                        Ambiente logConsulta = gerenciador.pesquisarAmbiente(new Ambiente(idConsulta));
                        if (logConsulta.Id == -1)
                        {
                            Console.WriteLine("Ambiente não encontrado!");
                            break;
                        }
                        Console.WriteLine("\nFiltrar logs por:" +
                                            "\n1 - Autorizados" +
                                            "\n2 - Negados"+
                                            "\n3 - Todos");
                        Console.WriteLine("\nEscolha: ");
                        if (!int.TryParse(Console.ReadLine(), out int filtro))
                        {
                            Console.WriteLine("Ocorreu um erro, verifique se digitou corretamente.\n");
                            continue;
                        }
                        IEnumerable<Log> listaFiltrada = Enumerable.Empty<Log>();
                        switch (filtro)
                        {
                            case 1:
                                listaFiltrada = logConsulta.Logs.Where(l => l.TipoAcesso);
                                Console.WriteLine("----- Logs Autorizados -----\n");
                                break;
                            case 2:
                                listaFiltrada = logConsulta.Logs.Where(l => !l.TipoAcesso);
                                Console.WriteLine("----- Logs Negados -----\n");
                                break;
                            case 3:
                                listaFiltrada = logConsulta.Logs;
                                Console.WriteLine("----- Todos os Logs -----\n");
                                break;
                            default:
                                Console.WriteLine("Opção inválida!");
                                break;
                        }
                        foreach (Log logAcesso in listaFiltrada)
                        {
                            Console.WriteLine(
                                $"Data/Hora: {logAcesso.DtAcesso} - " +
                                $"Usuario: {logAcesso.Usuario.Nome} - " +
                                $"Acesso: {(logAcesso.TipoAcesso ? "Autorizado" : "Negado")}\n"
                            );
                        }
                        break;
                    default:
                        Console.WriteLine("\nOcorreu um erro, verifique se digitou corretamente.\n");
                        break;
                }
            } while (opcao != 0);
        }
    }
}
