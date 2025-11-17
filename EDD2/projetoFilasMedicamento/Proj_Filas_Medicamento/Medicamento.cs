using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using static System.Runtime.InteropServices.JavaScript.JSType;

namespace Proj_Filas_Medicamento
{
    internal class Medicamento
    {
        private int id;
        private string nome;
        private string laboratorio;
        private Queue<Lote> lotes;
        public int Id { get => id; set => id = value; }
        public string Nome { get => nome; set => nome = value; }
        public string Laboratorio { get => laboratorio; set => laboratorio = value; }
        internal Queue<Lote> Lotes { get => lotes; set => lotes = value; }
        public Medicamento(int id, string nome, string laboratorio)
        {
            Id = id;
            Nome = nome;
            Laboratorio = laboratorio;
            Lotes = new Queue<Lote>();
        }
        public Medicamento(int id) : this(id, "", "") { }
        public Medicamento() : this(-1, "", "") { }
        
        public int qtdeDisponivel()
        {
            int total = 0;
            foreach (Lote lote in Lotes)
            {
                total += lote.Qtde;
            }
            return total;
        }
        public void comprar(Lote lote)
        {
            Lotes.Enqueue(lote);
        }
        public bool vender(int qtde)
        {
            if (qtde > qtdeDisponivel())
            {
                return false;
            }
            while (qtde > 0 && Lotes.Count > 0)
            {
                Lote loteAtual = Lotes.Peek();
                if (loteAtual.Qtde > qtde)
                {
                    loteAtual.Qtde -= qtde;
                    qtde = 0;
                }
                else
                {
                    qtde -= loteAtual.Qtde;
                    Lotes.Dequeue();
                }
            }
            return true;
        }
        public override string ToString()
        {
            return $"{Id} - {Nome} - {Laboratorio} - {qtdeDisponivel()}";
        }
        public override bool Equals(object obj)
        {
            return (this.Id == ((Medicamento)obj).Id);
        }
    }
}
