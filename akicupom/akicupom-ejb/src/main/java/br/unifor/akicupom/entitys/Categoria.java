package br.unifor.akicupom.entitys;

public enum Categoria{
	
	GASTRONOMIA("Gastronomia"), DIVERSAO("Diversao"), SERVICO("Servicos"), 
	VIAGEM("Viagem"), EVENTO("Evento"), SAUDE("Saude"), SUPERMERCADO("Supermercado");
	
	private String nome;
	
	Categoria(String nome){
		this.nome = nome;
	}
	

	public String getNome(){
		return this.nome;		
	}
}
