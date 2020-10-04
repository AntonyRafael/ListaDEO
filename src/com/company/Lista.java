package com.company;

import java.util.Scanner;

class Elemento {
    public Professor Prof;
    public Elemento Prox;
    public Elemento Anterior;

    public Elemento() {
        this.Prof=null;
        this.Prox=null;
        this.Anterior=null;
    }

}
public class Lista {

    private Elemento Início;
    private Elemento Fim;
    private Elemento Aux; // Aux se refere ao meu elemento atual
    private Elemento Anterior;
    public int Tamanho;

    public Lista() {
        this.Início =null;
        this.Fim=null;
        this.Tamanho = 0;

    }

    public void InserirProfessor(Professor P) {
        Elemento Novo = new Elemento();
        Novo.Prof= P;

        if (Início == null) { // Sem elementos transforma o inicio e fim neste elemento
            Início = Novo;
            Fim=Novo;
        } else { // Se entrou aqui e pq ja havia outro elemento na lista
            // Agora deve se decidir em qual lugar se deve colocar (inicio,meio ou fim)
            Anterior=null;
            Aux = Início;
            while (Aux!= null && Novo.Prof.Nome.compareTo(Aux.Prof.Nome) >0) {
                Anterior=Aux;
                Aux= Aux.Prox;
            }
            if (Anterior == null) { // while deu falso e ele é o primeiro da ordem.
                Novo.Prox=Início;
                Início.Anterior=Novo;
                Início=Novo;
            } else if (Aux == null) { // Percorreu toda a lista e não achou elemento maior, logo ele será o ultimo.
                Fim.Prox=Novo;
                Novo.Anterior =Fim;
                Fim=Novo;

            } else { // A inserção acontecera no meio da lista
              Novo.Prox = Anterior.Prox;
              Novo.Prox = Novo.Prox.Anterior;
              Novo.Prox=Aux;
            }

        }
        Tamanho++;

    }

    public void MostrarLista() {

        if (Início == null ) { // Case -> não existem dados cadastrados
            System.out.println("Não existem dados cadastrados na lista :(");
            Parada();
        } else {
            Aux = Início;
            while (Aux!=null) { // Listagem
                System.out.printf("\n %1$2s - Nome : %2$s ", Aux.Prof.Matricula,Aux.Prof.Nome);
                System.out.printf("\n Email: %1$s ", Aux.Prof.Email);
                System.out.printf("\n Telefone : %1$s\n", Aux.Prof.Telefone);
                Aux=Aux.Prox;

            }
            System.out.printf("\nNúmero de professores(as) -> %1$s\n\n", Tamanho);
            Parada();
        }
    }

    public void MostrarListaInverso() {
        if (Início == null) {
            System.out.println("Não existem dados cadastrados na lista");
        } else {
            Aux = Fim;
            while (Aux!=null) {
                System.out.printf("\n %1$2s - Nome : %2$s ", Aux.Prof.Matricula,Aux.Prof.Nome);
                System.out.printf("\n Email: %1$s ", Aux.Prof.Email);
                System.out.printf("\n Telefone : %1$s\n", Aux.Prof.Telefone);
                Aux = Aux.Anterior;
            }
            System.out.printf("\nNúmero de professores(as) -> %1$s \n", Tamanho);
            Parada();
        }
    }

    public void RemoveProfessor(String mat) {
        if (Início == null) {
            System.out.println("A lista não possui elementos");
            Parada();
        } else {
            Aux = Início;
            int Achou = 0;

            while (Aux != null) {
                if (Aux.Prof.Matricula.equals(mat)) {
                    Achou++;
                    if (Aux == Início) { // Primeiro elemento será excluido
                        Início = Aux.Prox;
                        if (Início!= null){
                            Início.Anterior =null;
                        }
                        Aux =Início;
                        Tamanho--;
                    } else if (Aux == Fim) { // ultimo elemento sera excluido
                        Fim = Fim.Anterior;
                        Fim.Prox=null;
                        Aux = null;

                        Tamanho--;
                    } else { // Elemento do meio será excluido
                        Aux.Anterior.Prox = Aux.Prox;
                        Aux.Prox.Anterior = Aux.Anterior;
                        Aux = Aux.Prox;
                        Tamanho--;
                    }
                } else {
                    Aux = Aux.Prox;
                }
            }
            if (Achou == 0) {
                System.out.printf("A mátricula %1$s não foi encontrada ou não existe !\n", mat);
                Parada();
            } else  {
                System.out.printf("O valor %1$s foi encontrado e removido da lista !\n", mat);
                Parada();
            }
            System.out.printf("Total de professores(as) -> %1$s", Tamanho);
        }
    }

    public void EsvaziaLista() {
        if (Início == null) {
            System.out.println("A lista já esta vazia ! ");
            Parada();
        } else {
            Início = null;
            Tamanho = 0;

            System.out.println("Lista esvaziada com sucesso ! ");
            System.out.printf("\nTamanho -> %1$s\n", Tamanho);
            Parada();

        }

    }

    public void VerificaProfessor(String matricula) {
        int Achou = 0;
        if (Início==null) {
            System.out.println("A lista não possui elementos !");
            Parada();
        } else {
            Aux = Início;
            while (Aux != null) {
                if (Aux.Prof.Matricula.equals(matricula)) {
                    Achou++;
                }
                Aux = Aux.Prox;
            }
        }
        if (Achou == 0 ) {
            System.out.println("Não existe professor cadastrado \n");
            Parada();
        } else {
            System.out.printf("A matricula %1$s já está cadastrada \n", matricula);
            Parada();
        }
    }

    private void Parada() {
        Scanner teclado = new Scanner(System.in);

        System.out.println("Pressione <ENTER> para continuar");
        teclado.nextLine();
    }

}
