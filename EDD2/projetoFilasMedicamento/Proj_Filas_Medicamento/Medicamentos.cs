using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Proj_Filas_Medicamento
{
    internal class Medicamentos
    {
        private List<Medicamento> listaMedicamentos;
        internal List<Medicamento> ListaMedicamentos { get => listaMedicamentos; set => listaMedicamentos = value; }
        public Medicamentos() 
        {
            listaMedicamentos = new List<Medicamento>();
        }
        public void adicionar(Medicamento medicamento)
        {
            if (pesquisa(medicamento).Id != -1)
            {
                Console.WriteLine("Medicamento já cadastrado!\n");
                return;
            }
            ListaMedicamentos.Add(medicamento);
            Console.WriteLine("Medicamento adicionado com sucesso!\n");
        }
        public bool deletar(Medicamento medicamento)
        {
            Medicamento medicamentoRemover = pesquisa(medicamento);
            if (medicamentoRemover.Id == -1) return false;
            if (medicamentoRemover.qtdeDisponivel() == 0)
            {
                ListaMedicamentos.Remove(medicamentoRemover);
                return true;
            }
            return false;
        }
        public Medicamento pesquisa(Medicamento medicamento)
        {
            foreach (Medicamento med in ListaMedicamentos)
            {
                if (med.Id == medicamento.Id)
                {
                    return med;
                }
            }
            return new Medicamento();
        }
    }
}
