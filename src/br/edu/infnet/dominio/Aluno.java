package br.edu.infnet.dominio;

public class Aluno extends Pessoa {

	private float av1;
	private float av2;
	private float media;

	
	public Aluno() {
		this.setNome("Aluno");
	}
	
	public Aluno(String nome, int idade, String instituicao) {
		super(nome, idade, instituicao);
	}
	
	public Aluno(String nome, int idade, String instituicao, float av1, float av2) {
		super(nome, idade, instituicao);
		setAv1(av1);
		setAv2(av2);
		setMedia((getAv1() + getAv2()) / 2);
	}

	@Override
	protected String consultarSituacao() {
		return super.consultarSituacao() + " situacao: " + calcularSituacaoDoAluno();
	}

	private String calcularSituacaoDoAluno() {
		int mediaArrendondada = Math.round(getMedia());
		return mediaArrendondada < 4 ? "Reprovado" : mediaArrendondada < 7 ? "Prova Final" : "Aprovado";
	}


	public float getAv1() {
		return av1;
	}

	public void setAv1(float av1) {
		this.av1 = av1;
	}

	public float getAv2() {
		return av2;
	}

	public void setAv2(float av2) {
		this.av2 = av2;
	}

	public float getMedia() {
		return media;
	}

	public void setMedia(float media) {
		this.media = media;
	}

}
