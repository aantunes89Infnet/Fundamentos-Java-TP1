package br.edu.infnet.tests;

import br.edu.infnet.auxiliar.Constante;
import br.edu.infnet.dominio.Aluno;
import br.edu.infnet.dominio.Pessoa;
import br.edu.infnet.dominio.Professor;
import br.edu.infnet.exceptions.FluxoInterrompido;
import br.edu.infnet.exceptions.NomeInvalido;
import br.edu.infnet.exceptions.NotaInvalida;
import br.edu.infnet.exceptions.SalarioInvalido;

import java.util.Scanner;


public class InstitutionManager {

    private static Pessoa[] pessoas;

    private static int qtde = 0;

    private static void showOptions() {
        System.out.println("");
        System.out.println("[1] Cadastrar Aluno");
        System.out.println("[2] Cadastrar Professor");
        System.out.println("[3] Consultar situacao docente/discente");
        System.out.println("[4] Sair");
        System.out.print("Selecione uma operacao: ");
    }


    private static String calcStudentSituation(float mean) {
        int roundedMean = Math.round(mean);
        return roundedMean < 4 ? "Reprovado" : roundedMean < 7 ? "Prova Final" : "Aprovado";
    }

    private static void registerStudent(int quantity) {

    }


    public static void main(String[] args) throws FluxoInterrompido {

        pessoas = new Pessoa[Constante.QTD_MAX];
        Scanner inScanner = new Scanner(System.in);
        Integer opt = 0;

        do {
            showOptions();
            opt = inScanner.nextInt();

            switch (opt) {

                case 1:
                    if (qtde < Constante.QTD_MAX) {
                        Aluno aluno = new Aluno();

                        try {
                            System.out.print("Informe o nome do aluno: ");
                            String nome = inScanner.next();

                            System.out.print("Informe o sobrenome do aluno: ");
                            String sobreNome = inScanner.next();

                            System.out.print("Informe o ultimo nome do aluno: ");
                            String ultimoNome = inScanner.next();

                            aluno.setNome(nome + " " + sobreNome + " " + ultimoNome);

                            System.out.print("Informe a nota da AV1: ");
                            aluno.setAv1(inScanner.nextFloat());

                            System.out.print("Informe a nota da AV2: ");
                            aluno.setAv2(inScanner.nextFloat());

                            pessoas[qtde] = aluno;

                            pessoas[qtde].consultarSituacao();
                            System.out.println("ID: " + qtde);

                            qtde++;
                        } catch (NomeInvalido | NotaInvalida e) {
                            System.out.println(e.getMessage());
                            break;
                        } finally {
                            System.out.println("----------------------------------------------");
                        }

                    } else {
                        throw new FluxoInterrompido("Nao e possivel adicionar mais alunos");
                    }
                    break;
                case 2:
                    if (qtde < Constante.QTD_MAX) {
                        Professor professor = new Professor();

                        try {
                            System.out.print("Informe o nome do Professor: ");
                            String nome = inScanner.next();

                            System.out.print("Informe o sobrenome do Professor: ");
                            String sobreNome = inScanner.next();

                            System.out.print("Informe o ultimo nome do Professor: ");
                            String ultimoNome = inScanner.next();

                            professor.setNome(nome + " " + sobreNome + " " + ultimoNome);

                            System.out.print("Informe o Salario do Professor: ");
                            professor.setSalario(inScanner.nextFloat());

                            System.out.print("Informe a disciplina: ");
                            professor.setDisciplina(inScanner.next());

                            pessoas[qtde] = professor;

                            pessoas[qtde].consultarSituacao();
                            System.out.println("ID: " + qtde);

                            qtde++;
                        } catch (SalarioInvalido | NomeInvalido e) {
                            System.out.println(e.getMessage());
                            break;
                        } finally {
                            System.out.println("----------------------------------------------");
                        }

                    } else {
                        throw new FluxoInterrompido("Nao e possivel adicionar mais professores");
                    }
                    break;
                case 3:
                    System.out.println("Informe codigo da pessoa: ");
                    int codigo = inScanner.nextInt();

                    if(codigo >= 0 && codigo <= qtde) {
                        pessoas[codigo].consultarSituacao();
                    } else {
                        throw new FluxoInterrompido("Codigo Invalido");
                    }

                    break;
                case 4:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Operacao invalida.");
                    break;
            }


        } while(opt != 4);

        System.out.println("Finalizando operacao!!");
        inScanner.close();
    }
}
