package br.edu.infnet.tests;

import br.edu.infnet.dominio.Aluno;
import br.edu.infnet.exceptions.NomeInvalido;
import br.edu.infnet.exceptions.NotaInvalida;

public class AlunoTeste {

    public static void main(String[] args) {


        Aluno a1 = new Aluno();
        try {
            a1.setNome("Andre Palhares Antunes");
            a1.setAv1(10);
            a1.setAv2(9);
            a1.setCargo("Aluno de Vestibular");
            a1.consultarSituacao();
        } catch (NomeInvalido | NotaInvalida e) {
            System.out.println(e.getMessage());
        }

        try {
            Aluno a2 = new Aluno("Farid Germano Filho", 6, 10);
            a2.setCargo("Aluno do terceiro ano");
            a2.consultarSituacao();
        } catch (NomeInvalido e) {
            e.printStackTrace();
        }

        try {
            Aluno a3 = new Aluno("Alex Roberto Rockenbach");
            a3.setAv1(8);
            a3.setAv2(10);
            a3.consultarSituacao();
        } catch (NomeInvalido | NotaInvalida e) {
            e.printStackTrace();
        }
    }
}
