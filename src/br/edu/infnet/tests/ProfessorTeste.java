package br.edu.infnet.tests;

import br.edu.infnet.dominio.Professor;
import br.edu.infnet.exceptions.NomeInvalido;
import br.edu.infnet.exceptions.SalarioInvalido;

public class ProfessorTeste {

    public static void main(String[] args) {

        Professor p1 = new Professor();
        try {
            p1.setNome("Joao Guido Nunes");
            p1.setSalario(2000);
            p1.setDisciplina("Matematica");
            p1.consultarSituacao();
        } catch (NomeInvalido | SalarioInvalido e) {
            System.out.println(e.getMessage());
        }

        Professor p2 = null;
        try {
            p2 = new Professor("Andre da Costa Palhares Antunes", 3000, "Java");
            p2.setSalario(8000);
            p2.setCargo("Coordenador");
            p2.consultarSituacao();
        } catch (NomeInvalido | SalarioInvalido e) {
            e.printStackTrace();
        }
    }
}
