package br.edu.infnet.tests;

import br.edu.infnet.dominio.Professor;
import br.edu.infnet.exceptions.NomeInvalido;
import br.edu.infnet.exceptions.SalarioInvalido;

public class ProfessorTeste {

    public static void main(String[] args) {

        try {
            Professor p1 = new Professor();
            p1.setNome("Joao Guido Nunes");
            p1.setSalario(2000);
            p1.setDisciplina("Matematica");
            p1.consultarSituacao();
        } catch (NomeInvalido | SalarioInvalido e) {
            System.out.println(e.getMessage());
        }

        try {
            Professor p2 = new Professor("Andre da Costa Palhares Antunes", 3000, "Java");
            p2.setSalario(8000);
            p2.setCargo("Coordenador");
            p2.consultarSituacao();
        } catch (NomeInvalido | SalarioInvalido e) {
            System.out.println(e.getMessage());
        }

        try {
            Professor p3 = new Professor();
            p3.setNome(null);
            p3.setSalario(8000);
            p3.setCargo("Coordenador");
            p3.consultarSituacao();
        } catch (NomeInvalido | SalarioInvalido e) {
            System.out.println(e.getMessage());
        }

        try {
            Professor p4 = new Professor();
            p4.setSalario(0);
            p4.setCargo("Coordenador");
            p4.consultarSituacao();
        } catch (SalarioInvalido e) {
            System.out.println(e.getMessage());
        }

        try {
            Professor p5 = new Professor();
            p5.setSalario(-10000);
            p5.setCargo("Coordenador");
            p5.consultarSituacao();
        } catch (SalarioInvalido e) {
            System.out.println(e.getMessage());
        }
    }
}
