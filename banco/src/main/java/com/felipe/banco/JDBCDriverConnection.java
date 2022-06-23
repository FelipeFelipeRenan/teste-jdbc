package com.felipe.banco;

/**
 * Hello world!
 *
 */

import java.util.Scanner;
//import com.felipe.banco.UserDAO;

public class JDBCDriverConnection {
    UserDAO user = new UserDAO();

    public static void main(String[] args) {
        // 1Statement statement = connection.createStatement();

        Scanner sc = new Scanner(System.in);
        String opcao, nome = null;
        int opt = 0, id = 0, conta = 0 ;

        do {
            System.out.println("------------------------------------------------");
            System.out.println("-----BDSM - Banco de Dados Simples Multiuso-----");
            System.out.println("------------------------------------------------");
            System.out.println("Digite 1 para inicializar o banco");
            System.out.println("Digite 2 para adicionar um novo registro");
            System.out.println("Digite 3 para visualizar registros existentes");
            System.out.println("Digite 4 para remover o registro indicado ");
            System.out.println("Digite 5 para atualizar o registro indicado ");
            opt = sc.nextInt();
            switch (opt) {
                case 1:
                    UserDAO.connect(1, id, nome, conta);
                    break;
                case 2:
                    System.out.println("Adicionando na base de dados");
                    System.out.println("Entre com o ID: ");
                    id = sc.nextInt();
                    sc.nextLine();

                    System.out.println("Entre com o nome: ");
                    nome = sc.nextLine();
                    sc.nextLine();

                    System.out.println("Entre com o numero da conta: ");
                    conta = sc.nextInt();
                    UserDAO.connect(2, id, nome, conta) ;

                    break;
                case 3:
                    UserDAO.connect(3, id, nome, conta);
                    break;
                case 4:
                    System.out.println("Excluindo da base de dados");
                    System.out.println("Entre com o ID: ");
                    id = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Entre com o numero da conta: ");
                    conta = sc.nextInt();
                    
                    UserDAO.connect(4, id, nome, conta);
                    sc.nextLine();

                    break;

                case 5:

                    System.out.println("Modificando o registro");
                    System.out.println("Entre com o ID: ");
                    id = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Entre com o nome");
                    nome = sc.nextLine();
                    sc.nextLine();
                    System.out.println("Entre com o numero da conta: ");
                    conta = sc.nextInt();
                    sc.nextLine();
                    UserDAO.connect(5, id, nome, conta);
                    sc.nextLine();

                    break;

                default:
                    System.out.println("Opção inválida!");
                    break;
            }
            sc.nextLine();
            System.out.println("Deseja continuar? Y | N");
            opcao = String.valueOf(sc.nextLine());
        } while (opcao.equals("Y") || opcao.equals("y"));

        sc.close();
    }
}
