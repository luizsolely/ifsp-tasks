public class Item
{
    public int Id { get; }
    public string Descricao { get; }
    public double Preco { get; }

    public Item(int id, string descricao, double preco)
    {
        Id = id;
        Descricao = descricao;
        Preco = preco;
    }

    public override string ToString()
    {
        return $"Item {{ Id={Id}, Descricao='{Descricao}', Preco={Preco:C} }}";
    }
}
