package com.company;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Lista ListaProf = new Lista();
        Scanner teclado = new Scanner(System.in);
        int op;
        do {
            System.out.println("================================");
            System.out.println("Gerenciamento de Professores : |");
            System.out.println("================================");
            System.out.println("Escolha uma das opções abaixo para começar:");
            System.out.println("1 - Inserir um professor");
            System.out.println("2 - Listar todos professores");
            System.out.println("3 - Listar todos professores ao contrario");
            System.out.println("4 - Remover Professor");
            System.out.println("5 - Esvaziar a lista");
            System.out.println("6 - Verifica se um professor existe na lista");
            System.out.println("7 - Sair");
            System.out.println("=================================");
            op = Integer.parseInt(teclado.nextLine());
            switch (op) {
                case 1: // Inserir professor
                Professor x = new Professor();
                    System.out.println("Nome do(a) Professor(a) :");
                    x.Nome= teclado.nextLine();
                    System.out.println("Mátricula.........:");
                    x.Matricula = teclado.nextLine();
                    System.out.println("Email.............:");
                    x.Email= teclado.nextLine();
                    System.out.println("Telefone..........:");
                    x.Telefone = teclado.nextLine();
                    ListaProf.InserirProfessor(x);

                    System.out.printf("\nProfessor(a) cadastrado com sucesso !\n");
                    System.out.printf("Número de professores(as) cadastrados(as) %1$d\n", ListaProf.Tamanho);

                    break;
                case 2: // Mostrar a Lista
                    System.out.println("===============================");
                    ListaProf.MostrarLista();
                    break;
                case 3: // Listar ao inverso
                    System.out.println("===============================");
                    ListaProf.MostrarListaInverso();
                    break;
                case 4: // Remover professor
                    String mat;
                    System.out.println("================================");
                    System.out.println("Informe a matricula do professor a ser excluído:");
                    mat = teclado.nextLine();
                    ListaProf.RemoveProfessor(mat);
                    break;
                case 5: // Esvaziar Lista
                    System.out.println("===============================");
                    ListaProf.EsvaziaLista();
                    break;
                case 6: // Verifica Professor
                    String matr;
                    System.out.println("===============================");
                    System.out.println("Informe a matricula a ser verificada:");
                    matr = teclado.nextLine();
                    ListaProf.VerificaProfessor(matr);
                    break;
            }

        } while (op!= 7 );

    }
}
