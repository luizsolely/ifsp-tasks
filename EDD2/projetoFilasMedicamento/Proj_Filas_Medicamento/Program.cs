using System;
using System.Collections.Generic;
using System.Diagnostics;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using Proj_Filas_Medicamento;
using static System.Runtime.InteropServices.JavaScript.JSType;

namespace Proj_Listas_Agenda
{
    internal class Program
    {
        static void Main(string[] args)
        {
            int opcao;
            Medicamentos farmacia = new Medicamentos();
        /*
            Console.WriteLine("\n=== INÍCIO DOS TESTES AUTOMATIZADOS ===");
            // Criar alguns medicamentos
            Medicamento m1 = new Medicamento(1, "Paracetamol", "NeoQuímica");
            Medicamento m2 = new Medicamento(2, "Ibuprofeno", "EMS");
            // Adicionar medicamentos
            farmacia.adicionar(m1);
            farmacia.adicionar(m2);
            // Tentar adicionar um duplicado
            farmacia.adicionar(new Medicamento(1, "Duplicado", "Teste"));
            // Criar lotes
            Lote lote1 = new Lote(1001, 50, new DateTime(2025, 12, 31));
            Lote lote2 = new Lote(1002, 30, new DateTime(2026, 6, 15));
            Lote lote3 = new Lote(2001, 20, new DateTime(2025, 8, 10));
            // Comprar lotes
            m1.comprar(lote1);
            m1.comprar(lote2);
            m2.comprar(lote3);
            // Mostrar dados analíticos
            Console.WriteLine("\n--- Consulta Analítica ---");
            foreach (Medicamento med in farmacia.ListaMedicamentos)
            {
                Console.WriteLine(med.ToString());
                foreach (Lote lote in med.Lotes)
                {
                    Console.WriteLine("   " + lote.ToString());
                }
            }
            // Testar venda
            Console.WriteLine("\n--- Venda de Paracetamol (60 unidades) ---");
            bool sucessoVenda = m1.vender(60);
            Console.WriteLine(sucessoVenda ? "Venda realizada com sucesso!" : "Venda falhou!");
            Console.WriteLine(m1.ToString());
            // Tentar vender mais do que o disponível
            Console.WriteLine("\n--- Tentativa de venda além do estoque ---");
            bool falhaVenda = m1.vender(100);
            Console.WriteLine(falhaVenda ? "Venda realizada!" : "Estoque insuficiente!");
            // Mostrar lista final
            Console.WriteLine("\n--- Lista Final de Medicamentos ---");
            foreach (Medicamento med in farmacia.ListaMedicamentos)
            {
                Console.WriteLine(med.ToString());
            }
            // Testar exclusão
            Console.WriteLine("\n--- Tentando excluir Ibuprofeno (ainda tem estoque) ---");
            bool deleteFalha = farmaciaTeste.deletar(m2);
            Console.WriteLine(deleteFalha ? "Removido com sucesso!" : "Não foi possível remover (estoque ainda disponível).");

            // Zerar estoque e tentar excluir novamente
            m2.vender(20);
            bool deleteOk = farmaciaTeste.deletar(m2);
            Console.WriteLine(deleteOk ? "Removido com sucesso!" : "Não foi possível remover (estoque ainda disponível).");
            
            Console.WriteLine("\n=== FIM DOS TESTES AUTOMATIZADOS ===");
        */
            do
            {
                Console.WriteLine("\nMenu de opções:" +
                    "\n0. Finalizar processo" +
                    "\n1. Cadastrar medicamento" +
                    "\n2. Consultar medicamento (sintético)" +
                    "\n3. Consultar medicamento (analítico)" +
                    "\n4. Comprar medicamento (cadastrar lote)" +
                    "\n5. Vender medicamento (abater do lote mais antigo)" +
                    "\n6. Listar medicamentos" +
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
                        Console.WriteLine("\ndigite o ID: ");
                        if (!int.TryParse(Console.ReadLine(), out int addID))
                        {
                            Console.WriteLine("ID inválido!\n");
                            break;
                        }
                        Console.WriteLine("digite o Nome: ");
                        string addNome = Console.ReadLine();
                        Console.WriteLine("digite o laboratorio: ");
                        string addLaboratorio = Console.ReadLine();

                        Medicamento novo = new Medicamento(addID, addNome, addLaboratorio);
                        farmacia.adicionar(novo);
                        break;
                    case 2:
                        Console.WriteLine("\ndigite o ID do medicamento");
                        if (!int.TryParse(Console.ReadLine(), out int idPesquisa))
                        {
                            Console.WriteLine("ID inválido!\n");
                            break;
                        }
                        Medicamento medicamentoPesquisado = farmacia.pesquisa(new Medicamento(idPesquisa));
                        if (medicamentoPesquisado != null && medicamentoPesquisado.Id != -1)

                            {
                                Console.WriteLine(medicamentoPesquisado.ToString());
                        }
                        else { Console.WriteLine("Medicamento não encontrado!\n"); }
                        break;
                    case 3:
                        Console.WriteLine("\nDigite o ID do medicamento: ");
                        if (!int.TryParse(Console.ReadLine(), out int idPesquisa2))
                        {
                            Console.WriteLine("ID inválido!\n");
                            break;
                        }
                        Medicamento medicamentoPesquisado2 = farmacia.pesquisa(new Medicamento(idPesquisa2));
                        if (medicamentoPesquisado2 != null && medicamentoPesquisado2.Id != -1)
                        {
                            Console.WriteLine(medicamentoPesquisado2.ToString());
                            if (medicamentoPesquisado2.Lotes.Count > 0)
                            {
                                Console.WriteLine("Lotes cadastrados:");
                                foreach (Lote lote in medicamentoPesquisado2.Lotes)
                                {
                                    Console.WriteLine("   " + lote.ToString());
                                }
                            }
                            else { Console.WriteLine("Nenhum lote cadastrado para este medicamento.\n"); }
                        }
                        else { Console.WriteLine("Medicamento não encontrado!\n"); }
                        break;
                    case 4:
                        Console.WriteLine("\nDigite o Id pra comprar : ");
                        if (!int.TryParse(Console.ReadLine(), out int IdComprar))
                        {
                            Console.WriteLine("ID inválido!\n");
                            break;
                        }
                        Medicamento medicamentoComprado = farmacia.pesquisa(new Medicamento(IdComprar));
                        if (medicamentoComprado != null && medicamentoComprado.Id != -1)
                        {
                            Console.WriteLine("Digite o ID do lote: ");
                            if (!int.TryParse(Console.ReadLine(), out int idLote))
                            {
                                Console.WriteLine("ID inválido!\n");
                                break;
                            }
                            Console.WriteLine("Digite a quantidade do lote: ");
                            if (!int.TryParse(Console.ReadLine(), out int qtdeLote))
                            {
                                Console.WriteLine("Quantidade inválida!\n");
                                return;
                            }
                            Lote novoLote = new Lote(idLote,qtdeLote,DateTime.Now);
                            medicamentoComprado.comprar(novoLote);
                            Console.WriteLine("Lote comprado com sucesso!\n");
                        }
                        else
                        {
                            Console.WriteLine("Medicamento não encontrado!\n");
                        }
                        break;
                    case 5:
                        Console.WriteLine("\nDigite o Id pra vender: ");
                        if (!int.TryParse(Console.ReadLine(), out int IdVender))
                        {
                            Console.WriteLine("ID inválido!\n");
                            break;
                        }
                        Medicamento medicamentoVendido = farmacia.pesquisa(new Medicamento(IdVender));
                        if (medicamentoVendido != null && medicamentoVendido.Id != -1)
                        {
                            Console.WriteLine("Digite a quantidade a vender: ");
                            if (!int.TryParse(Console.ReadLine(), out int qtdeVender))
                            {
                                Console.WriteLine("Quantidade inválida!\n");
                                return;
                            }
                            if (medicamentoVendido.vender(qtdeVender))
                            {
                                Console.WriteLine("Venda realizada com sucesso!\n");
                            }
                            else { Console.WriteLine("Quantidade indisponível para venda!\n"); }
                        }
                        else{ Console.WriteLine("Medicamento não encontrado!\n"); }
                        break;
                    case 6:
                        Console.WriteLine("\nLista de medicamentos cadastrados:\n");
                        foreach (Medicamento med in farmacia.ListaMedicamentos)
                        {
                            Console.WriteLine(med.ToString());
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