package br.edu.infnet;

import java.util.Scanner;

public class StudentManagement {

    // #region
    private static String[] students;
    private static float[] avOne;
    private static float[] avTwo;
    private final static int MAX_QUANTITY = 5;
    private final static Scanner inScanner = new Scanner(System.in);

    private static void showOptions() {
        System.out.println("[1] Registrar as notas de um novo aluno");
        System.out.println("[2] Consultar boletim de um aluno");
        System.out.println("[3] Consultar notas da turma");
        System.out.println("[4] Sair");
        System.out.print("Selecione uma opção: ");
    }

    private static void printSeparator() {
        System.out.println("---------------------------------------------");
    }

    private static void printStudentDetails(int code) {
        float mean = (avOne[code] + avTwo[code]) / 2;
        String situation = calcStudentSituation(mean);
        System.out.printf(
                " Aluno: %s%n Nota da AV1: %s%n Nota da AV2 %s%n Média Final %s%n Situação %s%n",
                students[code],
                avOne[code],
                avTwo[code],
                mean,
                situation
        );
        printSeparator();
    }

    private static String calcStudentSituation(float mean) {
        int roundedMean = Math.round(mean);
        return roundedMean < 4 ? "Reprovado" : roundedMean < 7 ? "Prova Final" : "Aprovado";
    }

    private static void listStudents() {
        printSeparator();
        for (int i = 0; i < MAX_QUANTITY; i++) {
            if(students[i] == null) break;
            printStudentDetails(i);
        }
        printSeparator();
    }

    private static void displayStudentInfoById() {
        printSeparator();
        System.out.print("Digite o código do aluno para realizar a consulta: ");
        int code = inScanner.nextInt();
        if (students[code] != null)
            printStudentDetails(code);
        else {
            System.out.println("Não foi possível encontrar um aluno com esse código, tente outra vez");
            displayStudentInfoById();
        }
    }

    private static void registerStudent(int quantity) {
        System.out.print("Informe o nome do aluno: ");
        students[quantity] = inScanner.next();

        System.out.print("Informe a nota da AV1: ");
        avOne[quantity] = inScanner.nextFloat();

        System.out.print("Informe a nota da AV2: ");
        avTwo[quantity] = inScanner.nextFloat();

        printSeparator();
        System.out.printf(
                " Aluno: %s%n Nota da AV1: %s%n Nota da AV2 %s%n",
                students[quantity],
                avOne[quantity],
                avTwo[quantity]
        );
        printSeparator();
    }


    public static void main(String[] args) {
        students = new String[MAX_QUANTITY];
        avOne = new float[MAX_QUANTITY];
        avTwo = new float[MAX_QUANTITY];

        int quantity = 0;
        String opt;

        do {
            showOptions();
            opt = inScanner.next();

            switch (opt) {

                case "1":
                    if (quantity < MAX_QUANTITY) {
                        registerStudent(quantity);
                        quantity++;
                    } else {
                        printSeparator();
                        System.out.println("Não é possivel adicionar mais alunos");
                        printSeparator();
                    }
                    break;
                case "2":
                    displayStudentInfoById();
                    break;
                case "3":
                    listStudents();
                    break;
                case "4":
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Operação inválida.");
                    printSeparator();
                    break;
            }


        } while(opt != "4");

        System.out.println("Finalizando operação!!");
        inScanner.close();
    }
}
