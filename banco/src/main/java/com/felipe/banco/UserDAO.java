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
                    statement.execute("CREATE TABLE IF NOT EXISTS RC_TEST( ID INTEGER, NOME VARCHAR, CONTA VARCHAR  )");

                    break;

                case 2:
                    dbInput = String.format("INSERT INTO RC_TEST( ID, NOME, CONTA) VALUES (%d, '%s', '%s')", idUser, name, conta);
                    // inserindo registros
                    statement.execute(dbInput);

                    break;

                case 3:
                    // lendo os registros
                    PreparedStatement stmt = connection.prepareStatement("SELECT * FROM RC_TEST");
                    ResultSet resultSet = stmt.executeQuery();

                    while (resultSet.next()) {
                        Integer id = resultSet.getInt("ID");
                        String nome = resultSet.getString("NOME");

                        System.out.println(id + " - " + nome);
                    }
                    break;
                case 4:
                    dbInput = String.format("DELETE FROM RC_TEST WHERE ID=%d", idUser);
                    // inserindo registros
                    statement.execute(dbInput);

                    break;
                case 5:
                    dbInput = String.format("UPDATE RC_TEST SET NOME=%s WHERE ID=%d", name,idUser);
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
