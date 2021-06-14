package br.com.cadastro.aplicaçao;

import br.com.cadastro.dao.CadastroDAO;
import br.com.cadastro.model.Cadastro;

public class Main {

	public static void main(String[] args) {
		CadastroDAO cadastroum = new CadastroDAO ();
		
		Cadastro cadastro = new Cadastro ();
		cadastro.setNome("Laryssa Maria");
		cadastro.setEmpresa("Metropolitana");
		cadastro.setTelefone("081987675545");
		cadastro.setModal("Rodoviário");
		cadastro.setRua("Rua General Vargas");
		cadastro.setNumero("36");
		cadastro.setBairro("Curado");
		cadastro.setCidade("Recife");
		cadastro.setUf("PE");
		cadastro.setCNPJ("09591649000107");
		cadastro.setEmail("metropolitana@gmail.com");
		
		// cadastroum.save(cadastro);
		
		// Atualizar um contato.
		
		Cadastro c1 = new Cadastro ();
		c1.setNome("Jorge Medeiros");
		c1.setEmpresa("TransportesPinguins");
		c1.setTelefone("031987675564");
		c1.setModal("Aquaviário");
		c1.setRua("Rua Gonçalvos Dias");
		c1.setNumero("234");
		c1.setBairro("Lourdes");
		c1.setCidade("Montes Claros");
		c1.setUf("MG");
		c1.setCNPJ("20315595000181");
		c1.setEmail("transportespin@gmail.com");
		c1.setId(1); // Esse id corresponde ao número que está no banco de dados.
		
		// CadastroDAO.update (c1);
		
		// Deletar o contato pelo seu número de identificação (id)
		
		// CadastroDAO.deleteById (1);
		
		
		
		
		// Listagem de todos os registros - Read
		
		for (Cadastro c : cadastroum.getCadastro()) {
			System.out.println ("Cadastro: " + c.getNome());
			System.out.println ("Cadastro: " + c.getEmpresa());
			System.out.println ("Cadastro: " + c.getTelefone());
			System.out.println ("Cadastro: " + c.getModal());
			System.out.println ("Cadastro: " + c.getRua());
			System.out.println ("Cadastro: " + c.getNumero());
			System.out.println ("Cadastro: " + c.getBairro());
			System.out.println ("Cadastro: " + c.getCidade());
			System.out.println ("Cadastro: " + c.getUf());
			System.out.println ("Cadastro: " + c.getCNPJ());
			System.out.println ("Cadastro: " + c.getEmail());
		}
		
	}

}
