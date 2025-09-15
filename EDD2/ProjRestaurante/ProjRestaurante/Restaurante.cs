using System;

public class Restaurante
{
    private int proxPedido;
    private Pedido[] pedidos;
    private int qtdPedidos;

    public Restaurante()
    {
        proxPedido = 1;
        pedidos = new Pedido[50];
        qtdPedidos = 0;
    }

    public bool NovoPedido(string cliente)
    {
        if (qtdPedidos < 50)
        {
            Pedido p = new Pedido(proxPedido, cliente);
            pedidos[qtdPedidos] = p;
            qtdPedidos++;
            proxPedido++;
            return true;
        }
        return false;
    }

    public Pedido BuscarPedido(int id)
    {
        for (int i = 0; i < qtdPedidos; i++)
        {
            if (pedidos[i].Id == id)
                return pedidos[i];
        }
        return null;
    }

    public bool CancelarPedido(int id)
    {
        for (int i = 0; i < qtdPedidos; i++)
        {
            if (pedidos[i].Id == id)
            {
                for (int j = i; j < qtdPedidos - 1; j++)
                {
                    pedidos[j] = pedidos[j + 1];
                }
                pedidos[qtdPedidos - 1] = null;
                qtdPedidos--;
                return true;
            }
        }
        return false;
    }

    public void ListarPedidos()
    {
        double somaTotal = 0;
        Console.WriteLine("Pedidos do dia:");
        for (int i = 0; i < qtdPedidos; i++)
        {
            double total = pedidos[i].CalcularTotal();
            Console.WriteLine($"ID: {pedidos[i].Id} | Cliente: {pedidos[i].Cliente} | Total: {total:C}");
            somaTotal += total;
        }
        Console.WriteLine($"Soma geral do dia: {somaTotal:C}");
    }
}
