/*
 Nome: Luiz Gustavo Verissimo Monteiro
 Prontuário: CB3030326

 Nome: Luiz Felipe Gonçalves da Silva
 Prontario: CB3030539
*/
public class Paciente {
	private int cod_paciente;
	private int idade_paciente;
	private String nome_paciente;
	private float peso_paciente;
	private float altura_paciente;
	
	public Paciente() {
		super();
	}
	public Paciente(int cod_paciente, int idade_paciente, String nome_paciente, float peso_paciente, float altura_paciente) {
		super();
		this.cod_paciente = cod_paciente;
		this.idade_paciente = idade_paciente;
		this.nome_paciente = nome_paciente;
		this.peso_paciente = peso_paciente;
		this.altura_paciente = altura_paciente;
	}
	public int getCod_func() {
		return cod_paciente;
	}
	public void setCod_func(int cod_paciente) {
		this.cod_paciente = cod_paciente;
	}
	public int getIdade_paciente() {
		return idade_paciente;
	}
	public void setIdade_paciente(int idade_paciente) {
		this.idade_paciente = idade_paciente;
	}
	public String getNome_paciente() {
		return nome_paciente;
	}
	public void setNome_paciente(String nome_paciente) {
		this.nome_paciente = nome_paciente;
	}
	public float getPeso_paciente() {
		return peso_paciente;
	}
	public void setPeso_paciente(float peso_paciente) {
		this.peso_paciente = peso_paciente;
	}
	public float getAltura_paciente() {
		return altura_paciente;
	}
	public void setAltura_paciente(float altura_paciente) {
		this.altura_paciente = altura_paciente;
	}
}
