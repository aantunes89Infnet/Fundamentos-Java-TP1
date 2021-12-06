package br.edu.infnet.dominio;

import br.edu.infnet.auxiliar.Constante;
import br.edu.infnet.exceptions.NomeInvalido;
import br.edu.infnet.exceptions.SalarioInvalido;

public class Professor extends Pessoa {

    private float salario;
    private String disciplina;

    public Professor() {
        super(Constante.PROFESSOR);
    }

    public Professor(String nome, float salario, String disciplina) throws NomeInvalido {
        super(Constante.PROFESSOR);
        this.setNome(nome);
        this.salario = salario;
        this.disciplina = disciplina;
    }

    @Override
    public void consultarSituacao() {
        super.consultarSituacao();
        System.out.println("MATERIA QUE LECIONA: " + getDisciplina());
        System.out.println("SALARIO: " + getSalario());
        System.out.println("SITUACAO: " + calcularSituacaoDoProfessor());
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        String nomeCompleto = getNome() + " " + getSobreNome() + " " + getUltimoNome();

        sb.append("Nome: " + nomeCompleto);
        sb.append("| Cargo: " + getCargo());
        sb.append("| Salario: " + getSalario());
        sb.append("| Disciplina: " + getDisciplina());

        return sb.toString();
    }

    @Override
    public void setNome(String nome) throws NomeInvalido {
        String[] nomeSeparado = nome.split("\\s");

        if (nomeSeparado.length < 3) {
            throw new NomeInvalido("Nome invalido, por favor forneca nome sobrenome e ultimo nome");
        }

        String nomeDoMeio = "";

        for (int i = 1; i < nomeSeparado.length; i++){
                if (i != nomeSeparado.length - 1)
                    nomeDoMeio += " " + nomeSeparado[i];
        }

        super.setNome(nomeSeparado[0]);
        super.setSobreNome(nomeDoMeio);
        super.setUltimoNome(nomeSeparado[nomeSeparado.length - 1]);
    }

    private String calcularSituacaoDoProfessor() {
        float salario = getSalario();

        if(salario <= Constante.SALARIO_MEIO_PERIODO) {
            return "trabalhando meio período";
        } else if (salario >= Constante.SALARIO_HORA_EXTRA_BASE) {
            return "fazendo horas extras";
        } else {
            return "trabalhando 8h diarias";
        }
    }

    public String getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(String disciplina) {
        this.disciplina = disciplina;
    }

    public float getSalario() {
        return salario;
    }

    public void setSalario(float salario) throws SalarioInvalido {
        if (salario <= Constante.SALARIO_MIN || salario != (int)salario ) {
            throw new SalarioInvalido("O salario do professor deve ser maior que R$1500");
        }

        this.salario = salario;
    }
}
