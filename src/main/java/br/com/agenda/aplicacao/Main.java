package br.com.agenda.aplicacao;

import br.com.agenda.dao.ContatoDAO;
import br.com.agenda.model.Contato;

import java.sql.SQLException;
import java.util.Date;

public class Main {

    public static void main(String[] args) throws SQLException {

        ContatoDAO contatoDAO = new ContatoDAO();

        Contato contato = new Contato();
        contato.setNome("Kauã Biscotto");
        contato.setIdade(17);
        contato.setDataCadastro(new Date());

        contatoDAO.save(contato);
    }
}
