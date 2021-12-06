package br.edu.infnet.dominio;

import br.edu.infnet.auxiliar.Constante;
import br.edu.infnet.exceptions.NomeInvalido;
import br.edu.infnet.exceptions.NotaInvalida;

public class Aluno extends Pessoa {

	private float av1;
	private float av2;
	private float media;

	
	public Aluno() {
		super(Constante.ALUNO);
	}

	public Aluno(String nome) throws NomeInvalido {
		super(Constante.ALUNO);
		setNome(nome);
	}

	public Aluno(String nome, float av1, float av2) throws NomeInvalido {
		super(Constante.ALUNO);
		this.setNome(nome);
		this.av1 = av1;
		this.av2 = av2;
	}

	@Override
	public void consultarSituacao() {
		super.consultarSituacao();
		System.out.println("NOTA AV1: " + getAv1());
		System.out.println("NOTA AV2: " + getAv2());
		System.out.println("SITUACAO: " + calcularSituacaoDoAluno());
	}

	@Override
	public String toString() {
		return super.toString() + " " + calcularSituacaoDoAluno();
	}

	private String calcularSituacaoDoAluno() {
		int media = Math.round(calcularMedia());
		setMedia(media);
		return media < 4 ? "Reprovado" : media < 7 ? "Prova Final" : "Aprovado";
	}

	private float calcularMedia() {
		return (getAv1() + getAv2()) / 2;
	}


	public float getAv1() {
		return av1;
	}

	@Override
	public void setNome(String nome) throws NomeInvalido {
		int posInit = nome.indexOf(" ");
		int posEnd = nome.lastIndexOf(" ");


		if(posInit <= 0 && posEnd <= 0)
			throw new NomeInvalido("Nome invalido, por favor forneca nome sobrenome e ultimo nome");

		super.setNome(nome.substring(0, posInit));
		super.setSobreNome(nome.substring(posInit, posEnd));
		super.setUltimoNome(nome.substring(posEnd));
	}

	public void setAv1(float av1) throws NotaInvalida {

		if(av1 < 0.0f || av1 > 10) {
			throw new NotaInvalida("A nota nao pode ser negativa ou maior que 10!");
		}

		this.av1 = av1;
	}

	public float getAv2() {
		return av2;
	}

	public void setAv2(float av2) throws NotaInvalida {
		if(av2 < 0.0f || av2 > 10) {
			throw new NotaInvalida("A nota nao pode ser negativa ou maior que 10!");
		}
		this.av2 = av2;
	}

	public float getMedia() {
		return media;
	}

	private void setMedia(float media) {
		this.media = media;
	}
}
