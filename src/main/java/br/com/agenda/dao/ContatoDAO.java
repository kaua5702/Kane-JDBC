package br.com.agenda.dao;

import br.com.agenda.factory.ConnectionFactory;
import br.com.agenda.model.Contato;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ContatoDAO {

    public void save(Contato contato) throws SQLException {

        String sql = "INSERT INTO contatos(nome, idade, dataCadastro) VALUES (?,?,?)";

        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            conn = ConnectionFactory.createConnectionToMySQL();
            pstmt = conn.prepareStatement(sql);

            pstmt.setString(1, contato.getNome());
            pstmt.setInt(2, contato.getIdade());
            pstmt.setDate(3, new Date(contato.getDataCadastro().getTime()));

            pstmt.execute();

        } catch (Exception e) {
            e.printStackTrace();

        } finally {

            try {
                if (pstmt != null) {
                    pstmt.close();
                }

                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
