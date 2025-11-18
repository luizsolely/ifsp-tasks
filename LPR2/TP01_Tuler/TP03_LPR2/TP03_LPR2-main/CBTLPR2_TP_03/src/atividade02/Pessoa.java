package atividade02;

/*
Nome: Luiz Felipe Gon�alves da Silva
Prontuário: CB3030539
*/

public class Pessoa {
    private String nome;
    private static int kp;
    private char sexo;
    private int idade;

    public Pessoa() {
        this.nome = "Indefinido";
        this.sexo = 'I';
        this.idade = 0;
    }
    public Pessoa(String nome, char sexo, int idade) {
        setNome(nome);
        setSexo(sexo);
        setIdade(idade);
        Pessoa.kp++;
    }
    public void setKp()
	{
		Pessoa.kp++;
	}
    public void setNome(String nome)
	{
         if (nome == null || nome.trim().isEmpty()) {
            throw new IllegalArgumentException("Nome não pode ser vazio.");
        }
        this.nome = nome.trim();
	}
    public void setSexo(char sexo)
	{
        if (Character.toUpperCase(sexo) != 'M' && Character.toUpperCase(sexo) != 'F') {
            throw new IllegalArgumentException("Sexo deve ser 'M' ou 'F'.");
        }
        this.sexo = sexo;
	}
    public void setIdade(int idade)
	{
        if (idade < 0) {
            throw new IllegalArgumentException("Idade não pode ser negativa.");
        }
        this.idade = idade;
	}
    public int getIdade(){ return this.idade; }
	public String getNome(){ return this.nome; }
	public char getSexo(){ return this.sexo; }
	public int getKp(){ return Pessoa.kp; }

    @Override
    public String toString() {
        return "Nome: " + nome + " | Sexo: " + Character.toUpperCase(sexo) + " | Idade: " + idade;
    }
}