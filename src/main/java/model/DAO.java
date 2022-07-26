package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import conexaoJDBC.SingleConnetcion;

/**
 * The Class DAO.
 */
public class DAO {

	/** The connection. */
	private Connection connection;

	/**
	 * Instantiates a new dao.
	 */
	public DAO() {
		connection = SingleConnetcion.getConnection();
	}

	/**
	 * Inserir contato.
	 *
	 * @param contato the contato
	 */
	public void inserirContato(Contato contato) {

		try {

			String create = "insert into contato (nome, fone, email) values(?,?,?)";

			PreparedStatement preparedStatement = connection.prepareStatement(create);
			preparedStatement.setString(1, contato.getNome());
			preparedStatement.setString(2, contato.getFone());
			preparedStatement.setString(3, contato.getEmail());

			preparedStatement.executeUpdate();

//			connection.close();

		} catch (Exception e) {
			System.out.println(e);
		}
	}

	/**
	 * Listar contatos.
	 *
	 * @return the array list
	 */
	public ArrayList<Contato> listarContatos() {

		ArrayList<Contato> contatos = new ArrayList<>();

		try {

			String read = "select * from contato order by nome";

			PreparedStatement preparedStatement = connection.prepareStatement(read);
			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				String idcon = resultSet.getString(1);
				String nome = resultSet.getString(2);
				String fone = resultSet.getString(3);
				String email = resultSet.getString(4);

				contatos.add(new Contato(idcon, nome, fone, email));
			}

			return contatos;

		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}

	/**
	 * Selecionar contato.
	 *
	 * @param contato the contato
	 */
	public void selecionarContato(Contato contato) {

		try {

			String read = "select * from contato where idcon = ?";

			PreparedStatement preparedStatement = connection.prepareStatement(read);
			preparedStatement.setString(1, contato.getIdcon());
			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				contato.setIdcon(resultSet.getString(1));
				contato.setNome(resultSet.getString(2));
				contato.setFone(resultSet.getString(3));
				contato.setEmail(resultSet.getString(4));
			}

		} catch (Exception e) {
			System.out.println(e);
		}
	}

	/**
	 * Alterar contato.
	 *
	 * @param contato the contato
	 */
	public void alterarContato(Contato contato) {

		try {

			String update = "update contato set nome=?, fone=?, email=? where idcon=?";

			PreparedStatement preparedStatement = connection.prepareStatement(update);
			preparedStatement.setString(1, contato.getNome());
			preparedStatement.setString(2, contato.getFone());
			preparedStatement.setString(3, contato.getEmail());
			preparedStatement.setString(4, contato.getIdcon());
			preparedStatement.executeUpdate();

		} catch (Exception e) {
			System.out.println(e);
		}
	}

	/**
	 * Deletar contato.
	 *
	 * @param contato the contato
	 */
	public void deletarContato(Contato contato) {

		try {

			String delete = "delete from contato where idcon=?";

			PreparedStatement preparedStatement = connection.prepareStatement(delete);
			preparedStatement.setString(1, contato.getIdcon());
			preparedStatement.executeUpdate();

		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
