package br.com.agenda.aplicacao;

import br.com.agenda.dao.ContatoDAO;
import br.com.agenda.model.Contato;

import java.sql.SQLException;
import java.util.Date;

public class Main {

    public static void main(String[] args) throws SQLException {

        ContatoDAO contatoDAO = new ContatoDAO();

        Contato contato = new Contato();
        contato.setNome("Gustavo R");
        contato.setIdade(54);
        contato.setDataCadastro(new Date());

        //contatoDAO.save(contato);
        //System.out.println("");

        Contato c1 = new Contato();
        c1.setNome("Gustavo Radcheski");
        c1.setIdade(37);
        c1.setDataCadastro(new Date());
        c1.setId(5);

        contatoDAO.update(c1);


        for (Contato c : contatoDAO.getContatos()) {
            System.out.println("Contato: " + c.getNome());
        }
    }
}
