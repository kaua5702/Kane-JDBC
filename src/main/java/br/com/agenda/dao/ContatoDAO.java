package br.com.agenda.dao;

import br.com.agenda.factory.ConnectionFactory;
import br.com.agenda.model.Contato;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

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
            System.out.println("Contato salvo com sucesso!");

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

    public void update(Contato contato) throws SQLException {

        String sql = "UPDATE contatos SET nome = ?, idade = ?, dataCadastro = ? WHERE id = ?";

        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            conn = ConnectionFactory.createConnectionToMySQL();
            pstmt = conn.prepareStatement(sql);

            pstmt.setString(1, contato.getNome());
            pstmt.setInt(2, contato.getIdade());
            pstmt.setDate(3, new Date(contato.getDataCadastro().getTime()));
            pstmt.setInt(4, contato.getId());

            pstmt.execute();
            System.out.println("Contato atualizado com sucesso!");

        } catch (Exception e) {
            e.printStackTrace();

        }  finally {

            try {
                if (pstmt != null) {
                    pstmt.close();
                }

                if (conn != null) {
                    conn.close();
                }

            } catch (Exception e) {
                e.printStackTrace();
            }


        }
    }

    public void deleteById(int id) throws SQLException {

        String sql = "DELETE FROM contatos WHERE id = ?";

        Connection conn = null;
        PreparedStatement pstmt = null;

        try {

            conn = ConnectionFactory.createConnectionToMySQL();
            pstmt = conn.prepareStatement(sql);

            pstmt.setInt(1, id);
            pstmt.execute();
            System.out.println("Contato deletado com sucesso!");
            System.out.println();

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

    public List<Contato> getContatos() {

        String sql = "SELECT * FROM contatos";

        List<Contato> contatos = new ArrayList<>();

        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rset = null;

        try {
            conn = ConnectionFactory.createConnectionToMySQL();

            pstmt = conn.prepareStatement(sql);

            rset = pstmt.executeQuery();

            while (rset.next()) {
                Contato contato = new Contato();

                contato.setId(rset.getInt("id"));
                contato.setNome(rset.getString("nome"));
                contato.setIdade(rset.getInt("idade"));
                contato.setDataCadastro(rset.getDate("dataCadastro"));

                contatos.add(contato);
            }
        } catch (Exception e) {
            e.printStackTrace();

        } finally {
            try {
                if (rset != null) {
                    rset.close();
                }

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
        return contatos;
    }
}
