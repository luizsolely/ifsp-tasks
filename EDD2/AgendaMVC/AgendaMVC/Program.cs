using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using Controller;

class Program
{
    static void Main(string[] args)
    {
        AgendaController controller = new AgendaController();
        controller.Iniciar();
    }
}
