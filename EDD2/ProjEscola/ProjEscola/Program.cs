using System;
using System.Linq;

namespace ProjEscola
{
    internal class Program
    {
        static void Main(string[] args)
        {
            Escola escola = new Escola();
            int opcao;

            do
            {
                Console.WriteLine("\nMENU");
                Console.WriteLine("1. Adicionar curso");
                Console.WriteLine("2. Pesquisar curso");
                Console.WriteLine("3. Remover curso");
                Console.WriteLine("4. Adicionar disciplina no curso");
                Console.WriteLine("5. Pesquisar disciplina");
                Console.WriteLine("6. Remover disciplina do curso");
                Console.WriteLine("7. Matricular aluno na disciplina");
                Console.WriteLine("8. Remover aluno da disciplina");
                Console.WriteLine("9. Pesquisar aluno");
                Console.WriteLine("0. Sair");
                Console.Write("Escolha: ");
                opcao = int.Parse(Console.ReadLine());

                switch (opcao)
                {
                    case 1:
                        Console.Write("ID Curso: ");
                        int idC = int.Parse(Console.ReadLine());
                        Console.Write("Descrição: ");
                        string descC = Console.ReadLine();
                        if (escola.AdicionarCurso(new Curso(idC, descC)))
                            Console.WriteLine("Curso adicionado!");
                        else
                            Console.WriteLine("Limite de cursos atingido.");
                        break;

                    case 2:
                        Console.Write("Informe ID curso: ");
                        idC = int.Parse(Console.ReadLine());
                        var curso = escola.PesquisarCurso(idC);
                        Console.WriteLine(curso == null ? "Não encontrado." : curso.ToString());
                        break;

                    case 3:
                        Console.Write("Informe ID curso: ");
                        idC = int.Parse(Console.ReadLine());
                        curso = escola.PesquisarCurso(idC);
                        if (curso == null) Console.WriteLine("Não encontrado.");
                        else if (escola.RemoverCurso(curso)) Console.WriteLine("Removido.");
                        else Console.WriteLine("Curso possui disciplinas, não pode remover.");
                        break;

                    case 4:
                        Console.Write("ID curso: ");
                        idC = int.Parse(Console.ReadLine());
                        curso = escola.PesquisarCurso(idC);
                        if (curso == null) { Console.WriteLine("Curso não encontrado."); break; }
                        Console.Write("ID disciplina: ");
                        int idD = int.Parse(Console.ReadLine());
                        Console.Write("Descrição: ");
                        string descD = Console.ReadLine();
                        if (curso.AdicionarDisciplina(new Disciplina(idD, descD)))
                            Console.WriteLine("Disciplina adicionada!");
                        else
                            Console.WriteLine("Limite atingido.");
                        break;

                    case 5:
                        Console.Write("ID curso: ");
                        idC = int.Parse(Console.ReadLine());
                        curso = escola.PesquisarCurso(idC);
                        if (curso == null) { Console.WriteLine("Curso não encontrado."); break; }
                        Console.Write("ID disciplina: ");
                        idD = int.Parse(Console.ReadLine());
                        var disc = curso.PesquisarDisciplina(idD);
                        Console.WriteLine(disc == null ? "Não encontrada." : disc.ToString());
                        break;

                    case 6:
                        Console.Write("ID curso: ");
                        idC = int.Parse(Console.ReadLine());
                        curso = escola.PesquisarCurso(idC);
                        if (curso == null) { Console.WriteLine("Curso não encontrado."); break; }
                        Console.Write("ID disciplina: ");
                        idD = int.Parse(Console.ReadLine());
                        disc = curso.PesquisarDisciplina(idD);
                        if (disc == null) Console.WriteLine("Não encontrada.");
                        else if (curso.RemoverDisciplina(disc)) Console.WriteLine("Removida.");
                        else Console.WriteLine("Disciplina possui alunos, não pode remover.");
                        break;

                    case 7:
                        Console.Write("ID curso: ");
                        idC = int.Parse(Console.ReadLine());
                        curso = escola.PesquisarCurso(idC);
                        if (curso == null) { Console.WriteLine("Curso não encontrado."); break; }
                        Console.Write("ID disciplina: ");
                        idD = int.Parse(Console.ReadLine());
                        disc = curso.PesquisarDisciplina(idD);
                        if (disc == null) { Console.WriteLine("Disciplina não encontrada."); break; }
                        Console.Write("ID aluno: ");
                        int idA = int.Parse(Console.ReadLine());
                        Console.Write("Nome: ");
                        string nomeA = Console.ReadLine();
                        Aluno a = new Aluno(idA, nomeA) { Curso = curso };
                        if (disc.MatricularAluno(a)) Console.WriteLine("Aluno matriculado!");
                        else Console.WriteLine("Não foi possível matricular.");
                        break;

                    case 8:
                        Console.Write("ID curso: ");
                        idC = int.Parse(Console.ReadLine());
                        curso = escola.PesquisarCurso(idC);
                        if (curso == null) { Console.WriteLine("Curso não encontrado."); break; }
                        Console.Write("ID disciplina: ");
                        idD = int.Parse(Console.ReadLine());
                        disc = curso.PesquisarDisciplina(idD);
                        if (disc == null) { Console.WriteLine("Disciplina não encontrada."); break; }
                        Console.Write("ID aluno: ");
                        idA = int.Parse(Console.ReadLine());
                        var aluno = disc.Alunos.FirstOrDefault(x => x != null && x.Id == idA);
                        if (aluno == null) Console.WriteLine("Aluno não encontrado nesta disciplina.");
                        else if (disc.DesmatricularAluno(aluno)) Console.WriteLine("Removido.");
                        else Console.WriteLine("Erro ao remover.");
                        break;

                    case 9:
                        Console.Write("Nome do aluno: ");
                        string nome = Console.ReadLine();
                        bool achou = false;
                        foreach (var c in escola.GetCursos())
                        {
                            foreach (var d in c.GetDisciplinas())
                            {
                                foreach (var al in d.Alunos)
                                {
                                    if (al != null && al.Nome == nome)
                                    {
                                        Console.WriteLine(al.ToString());
                                        achou = true;
                                    }
                                }
                            }
                        }
                        if (!achou) Console.WriteLine("Aluno não encontrado.");
                        break;
                }

            } while (opcao != 0);
        }
    }
}
