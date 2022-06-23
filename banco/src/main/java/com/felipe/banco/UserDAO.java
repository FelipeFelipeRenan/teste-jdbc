package com.felipe.banco;

import java.sql.*;

public class UserDAO {

    public static void connect(int opt, int idUser, String name, int  conta) {
        String dbInput;
        try (Connection connection = DriverManager.getConnection("jdbc:sqlite:banco.db")) {

            System.out.println("Conexão realizada !!!!");

            Statement statement = connection.createStatement();

            // criando uma tabela
            switch (opt) {
                case 1:
                    statement.execute("CREATE TABLE IF NOT EXISTS BANK_DATA( ID INTEGER, NOME VARCHAR, CONTA VARCHAR  )");

                    break;

                case 2:
                    dbInput = String.format("INSERT INTO BANK_DATA( ID, NOME, CONTA) VALUES (%d, '%s', '%s')", idUser, name, conta);
                    // inserindo registros
                    statement.execute(dbInput);

                    break;

                case 3:
                    // lendo os registros
                    PreparedStatement stmt = connection.prepareStatement("SELECT * FROM BANK_DATA");
                    ResultSet resultSet = stmt.executeQuery();

                    while (resultSet.next()) {
                        Integer id = resultSet.getInt("ID");
                        String nome = resultSet.getString("NOME");
                        String account = resultSet.getString("CONTA");

                        System.out.println(id + " - " + nome + " - " + account);
                    }
                    break;
                case 4:
                    dbInput = String.format("DELETE FROM BANK_DATA WHERE ID=%d", idUser);
                    // inserindo registros
                    statement.execute(dbInput);

                    break;
                case 5:
                    dbInput = String.format("UPDATE BANK_DATA SET NOME=%s WHERE ID=%d", name,idUser);
                    break;
                default:
                    System.out.println("Opção indisponivel!");
                    break;
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

}
