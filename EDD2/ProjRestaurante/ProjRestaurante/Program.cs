using System;

class Program
{
    static void Main()
    {
        Restaurante restaurante = new Restaurante();
        int opcao;

        do
        {
            Console.WriteLine("\n--- MENU ---");
            Console.WriteLine("0. Sair");
            Console.WriteLine("1. Criar novo pedido");
            Console.WriteLine("2. Adicionar item ao pedido");
            Console.WriteLine("3. Remover item do pedido");
            Console.WriteLine("4. Consultar pedido");
            Console.WriteLine("5. Cancelar pedido");
            Console.WriteLine("6. Listar todos os pedidos");
            Console.Write("Escolha uma opção: ");

            if (!int.TryParse(Console.ReadLine(), out opcao))
            {
                Console.WriteLine("Opção inválida!");
                continue;
            }

            switch (opcao)
            {
                case 1:
                    Console.Write("Nome do cliente: ");
                    string cliente = Console.ReadLine();
                    if (restaurante.NovoPedido(cliente))
                        Console.WriteLine("Pedido criado com sucesso!");
                    else
                        Console.WriteLine("Não foi possível criar o pedido (limite atingido).");
                    break;

                case 2:
                    Console.Write("ID do pedido: ");
                    int idPedidoAdd = int.Parse(Console.ReadLine());
                    Pedido pedidoAdd = restaurante.BuscarPedido(idPedidoAdd);
                    if (pedidoAdd != null)
                    {
                        Console.Write("ID do item: ");
                        int idItem = int.Parse(Console.ReadLine());
                        Console.Write("Descrição do item: ");
                        string desc = Console.ReadLine();
                        Console.Write("Preço do item: ");
                        double preco = double.Parse(Console.ReadLine());

                        Item item = new Item(idItem, desc, preco);
                        if (pedidoAdd.AdicionarItem(item))
                            Console.WriteLine("Item adicionado!");
                        else
                            Console.WriteLine("Não foi possível adicionar item (limite atingido).");
                    }
                    else
                    {
                        Console.WriteLine("Pedido não encontrado.");
                    }
                    break;

                case 3:
                    Console.Write("ID do pedido: ");
                    int idPedidoRem = int.Parse(Console.ReadLine());
                    Pedido pedidoRem = restaurante.BuscarPedido(idPedidoRem);
                    if (pedidoRem != null)
                    {
                        Console.Write("ID do item para remover: ");
                        int idItemRem = int.Parse(Console.ReadLine());
                        if (pedidoRem.RemoverItem(idItemRem))
                            Console.WriteLine("Item removido!");
                        else
                            Console.WriteLine("Item não encontrado.");
                    }
                    else
                    {
                        Console.WriteLine("Pedido não encontrado.");
                    }
                    break;

                case 4:
                    Console.Write("ID do pedido: ");
                    int idConsulta = int.Parse(Console.ReadLine());
                    Pedido pedidoCons = restaurante.BuscarPedido(idConsulta);
                    if (pedidoCons != null)
                        Console.WriteLine(pedidoCons.DadosDoPedido());
                    else
                        Console.WriteLine("Pedido não encontrado.");
                    break;

                case 5:
                    Console.Write("ID do pedido: ");
                    int idCanc = int.Parse(Console.ReadLine());
                    if (restaurante.CancelarPedido(idCanc))
                        Console.WriteLine("Pedido cancelado!");
                    else
                        Console.WriteLine("Pedido não encontrado.");
                    break;

                case 6:
                    restaurante.ListarPedidos();
                    break;

                case 0:
                    Console.WriteLine("Saindo...");
                    break;

                default:
                    Console.WriteLine("Opção inválida.");
                    break;
            }

        } while (opcao != 0);
    }
}
