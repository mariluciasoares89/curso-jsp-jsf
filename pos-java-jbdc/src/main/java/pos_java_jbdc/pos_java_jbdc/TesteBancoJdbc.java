package pos_java_jbdc.pos_java_jbdc;

import java.util.List;

import org.junit.Test;

import dao.UserPosDAO;
import model.BeanUserFone;
import model.Telefone;
import model.Userposjava;

public class TesteBancoJdbc {

	@Test
	public void initBanco() {
		UserPosDAO userPosDAO = new UserPosDAO();
		Userposjava userposjava = new Userposjava();

		userposjava.setNome("Paulo");
		userposjava.setEmail("paulo@gmail.com");

		userPosDAO.salvar(userposjava);
	}

	@Test
	public void initListar() {
		UserPosDAO dao = new UserPosDAO();
		try {
			List<Userposjava> list = dao.listar();
			for (Userposjava userposjava : list) {
				System.out.println(userposjava);
				System.out.println("-----------------------------------");
			}
		} catch (Exception e) {

			e.printStackTrace();
		}

	}

	@Test
	public void initBuscar() {
		UserPosDAO dao = new UserPosDAO();

		try {
			Userposjava userposjava = dao.buscar(5L);

			System.out.println(userposjava);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Test
	public void initAtualizar() {
		UserPosDAO dao = new UserPosDAO();

		try {
			Userposjava objetoBanco = dao.buscar(5L);

			objetoBanco.setNome("Nome mudado com metodo atualizar ok");
			dao.atualizar(objetoBanco);
		} catch (Exception e) {

			e.printStackTrace();
		}
	}

	@Test
	public void initDeletar() {
		try {
			UserPosDAO dao = new UserPosDAO();
			dao.deletar(11L);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testeInsertTelefone() {
		Telefone telefone = new Telefone();
		telefone.setNumero("(87) 4445-4545");
		telefone.setTipo("Casa");
		telefone.setUsuario(2L);
		UserPosDAO dao = new UserPosDAO();
		dao.salvarTelefone(telefone);
		
	}
	@Test
	public void testeCarregaFonesUser() { 
		
		UserPosDAO dao = new UserPosDAO();	
		
		List<BeanUserFone> beanUserFones = dao.listaUserFone(14L);
		
		for (BeanUserFone beanUserFone : beanUserFones) {
			System.out.println(beanUserFone);
			System.out.println("-----------------------------------------------------");
			
			
		}
	}
	
	/*
	 * public void testConexaoBanco() { Connection connection =
	 * SingleConnection.getConnection();
	 * assertNotNull("A conexão não deve ser nula", connection); try {
	 * connection.close(); } catch (Exception e) { fail("Erro ao fechar a conexão: "
	 * + e.getMessage()); } }
	 */
}
