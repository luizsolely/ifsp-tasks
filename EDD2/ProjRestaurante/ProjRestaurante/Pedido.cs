using System.Text;

public class Pedido
{
    public int Id { get; }
    public string Cliente { get; }
    private Item[] Itens { get; }
    private int qtdItens;

    public Pedido(int id, string cliente)
    {
        Id = id;
        Cliente = cliente;
        Itens = new Item[10];
        qtdItens = 0;
    }

    public bool AdicionarItem(Item item)
    {
        if (qtdItens < 10)
        {
            Itens[qtdItens] = item;
            qtdItens++;
            return true;
        }
        return false;
    }

    public bool RemoverItem(int idItem)
    {
        for (int i = 0; i < qtdItens; i++)
        {
            if (Itens[i].Id == idItem)
            {
                for (int j = i; j < qtdItens - 1; j++)
                {
                    Itens[j] = Itens[j + 1];
                }
                Itens[qtdItens - 1] = null;
                qtdItens--;
                return true;
            }
        }
        return false;
    }

    public double CalcularTotal()
    {
        double total = 0;
        for (int i = 0; i < qtdItens; i++)
        {
            total += Itens[i].Preco;
        }
        return total;
    }

    public string DadosDoPedido()
    {
        StringBuilder sb = new StringBuilder();
        sb.AppendLine($"Pedido ID: {Id} | Cliente: {Cliente}");
        sb.AppendLine("Itens:");
        for (int i = 0; i < qtdItens; i++)
        {
            sb.AppendLine("  - " + Itens[i].ToString());
        }
        sb.AppendLine($"Total: {CalcularTotal():C}");
        return sb.ToString();
    }
}
