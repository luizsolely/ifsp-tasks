using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Collections.Generic;
using System.Linq;

namespace Models
{
    public class Contato
    {
        public string Email { get; set; }
        public string Nome { get; set; }
        public Data DtNasc { get; set; }
        public List<Telefone> Telefones { get; private set; }

        public Contato()
        {
            Telefones = new List<Telefone>();
        }

        public int GetIdate()
        {
            var today = DateTime.Today;
            var birthDate = new DateTime(DtNasc.Ano, DtNasc.Mes, DtNasc.Dia);
            int age = today.Year - birthDate.Year;
            if (birthDate > today.AddYears(-age)) age--;
            return age;
        }

        public void AdicionarTelefone(Telefone t)
        {
            if (t.Principal)
            {
                foreach (var tel in Telefones)
                    tel.Principal = false;
            }
            Telefones.Add(t);
        }

        public string GetTelefonePrincipal()
        {
            var principal = Telefones.FirstOrDefault(t => t.Principal);
            return principal != null ? principal.Numero : "Sem telefone principal";
        }

        public override string ToString()
        {
            return $"Nome: {Nome}\nEmail: {Email}\nNascimento: {DtNasc}\nIdade: {GetIdate()}\nTelefone Principal: {GetTelefonePrincipal()}";
        }

        public override bool Equals(object obj)
        {
            return obj is Contato contato &&
                   Email == contato.Email; // Email como identificador único
        }

        public override int GetHashCode()
        {
            return Email.GetHashCode();
        }
    }
}

