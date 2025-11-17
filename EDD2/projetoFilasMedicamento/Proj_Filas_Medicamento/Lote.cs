using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Proj_Filas_Medicamento
{
    internal class Lote
    {
        private int id;
        private int qtde;
        private DateTime venc;
        public int Id { get => id; set => id = value; }
        public int Qtde { get => qtde; set => qtde = value; }
        public DateTime Venc { get => venc; set => venc = value; }
        public Lote() : this(-1, 0, DateTime.MinValue){ }
        public Lote(int id, int qtde, DateTime venc)
        {
            Id = id;
            Qtde = qtde;
            Venc = venc;
        }
        public override string ToString()
        {
            return $"{Id} - {Qtde} - {Venc.ToShortDateString()}";
        }
    }
}
