// Aqui é quando irá ocorrer o molde do java para o banco de dados
// DAO - Dados de acesso para pessoas.
package br.com.cadastro.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.com.cadastro.factory.ConnectionFactory;
import br.com.cadastro.model.Cadastro;

public class CadastroDAO {
	public void save (Cadastro cadastro) {
		String sql = "INSERT INTO cadastro (nome, empresa, telefone, modal, rua, numero, bairro, cidade, uf, cnpj, email) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        
		Connection conn = null;
		PreparedStatement pstm = null;
		
		try {
			// Criar uma conexão com o banco de dados
			conn = ConnectionFactory.createConnectionToMySQL(); 
			
			pstm = (PreparedStatement) conn.prepareStatement(sql);
			
			// Adicionando os valores que são esperandos pela Query
			
			pstm.setString(1, cadastro.getNome());
			pstm.setString(2, cadastro.getEmpresa());
			pstm.setString(3, cadastro.getTelefone());
			pstm.setString(4, cadastro.getModal());
			pstm.setString(5, cadastro.getRua());
			pstm.setString(6, cadastro.getNumero());
			pstm.setString(7, cadastro.getBairro());
			pstm.setString(8, cadastro.getCidade());
			pstm.setString(9, cadastro.getUf());
			pstm.setString(10, cadastro.getCNPJ());
			pstm.setString(11, cadastro.getEmail());
			
			//Executar a Query
			pstm.execute();
			pstm.close();
			
			
			System.out.println ("Contato salvo com sucesso!");
		} catch (Exception e){
			e.printStackTrace();
		} finally {
			
			// Fechar as conexões
			try {
				if (pstm != null) {
					pstm.close();
				}
				
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	
	public static void update (Cadastro cadastro) {
		String sql = "UPDATE cadastro SET nome = ?, empresa = ?, telefone = ?, modal = ?, rua = ?, numero = ?, bairro = ?, cidade = ?, UF = ?, cnpj = ?, email = ?" + "WHERE id = ?";
		
		Connection conn = null;
		PreparedStatement pstm = null;
		
		try {
			//Criar conexão com o banco de dados
			
			conn = ConnectionFactory.createConnectionToMySQL();
			
			// Criar classe para conectar com a Query
			
			pstm = conn.prepareStatement(sql);
			
			// Adicionar os valores para atualizar 
			pstm.setString(1, cadastro.getNome());
			pstm.setString(2, cadastro.getEmpresa());
			pstm.setString(3, cadastro.getTelefone());
			pstm.setString(4, cadastro.getModal());
			pstm.setString(5, cadastro.getRua());
			pstm.setString(6, cadastro.getNumero());
			pstm.setString(7, cadastro.getBairro());
			pstm.setString(8, cadastro.getCidade());
			pstm.setString(9, cadastro.getUf());
			pstm.setString(10, cadastro.getCNPJ());
			pstm.setString(11, cadastro.getEmail());
			
			// Qual o id do registro que deseja realizar
			
			pstm.setInt(12, cadastro.getId());
			
			// Executar a Query
			
			pstm.execute();
			pstm.close();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstm != null) {
					pstm.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	
	public static void deleteById (int id) {
		String sql = "DELETE FROM cadastro WHERE id = ?";
		
		Connection conn = null;
		
		PreparedStatement pstm = null;
		
		try {
			conn = ConnectionFactory.createConnectionToMySQL();
			
			pstm = conn.prepareStatement(sql);
			
			pstm.setInt(1, id);
			
			pstm.execute();
			pstm.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstm != null) {
					pstm.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	
	
	
	
	
	
	public List<Cadastro> getCadastro () {
		String sql = "SELECT * FROM cadastro";
		
		List<Cadastro> cadastros = new ArrayList<Cadastro>();
		
		Connection conn = null;
		PreparedStatement pstm = null;
		
		// Classe que vai recuperar os dados do banco
		ResultSet rset = null;
		
		try {
			conn = ConnectionFactory.createConnectionToMySQL();
			
			pstm = (PreparedStatement) conn.prepareStatement(sql);
			
			rset = pstm.executeQuery();
			
			while (rset.next()) {
				Cadastro cadastross = new Cadastro ();
				
				//Recuperar o id
				
				cadastross.setId(rset.getInt("id"));
				
				//Recuperar o nome
				cadastross.setNome(rset.getString("nome"));
				
				//Recuperar a empresa
				
				cadastross.setEmpresa(rset.getString("empresa"));
				
				//Recuperar o telefone
				
				cadastross.setTelefone(rset.getString("telefone"));
				
				//Recuperar o modal
				
				cadastross.setModal(rset.getString("modal"));
				
				//Recuperar a rua 
				
				cadastross.setRua(rset.getString("rua"));
				
				//Recuperar o número 
				
				cadastross.setNumero(rset.getString("numero"));
				
				//Recuperar o bairro
				
				cadastross.setBairro(rset.getString("bairro"));
				
				//Recuperar a cidade 
				
				cadastross.setCidade(rset.getString("cidade"));
				
				//Recuperar a Uf
				
				cadastross.setUf(rset.getString("uf"));
				
				//Recuperar o Cnpj
				
				cadastross.setCNPJ(rset.getString("CNPJ"));
				
				//Recuperar o e-mail 
				
				cadastross.setEmail(rset.getString("Email"));
				
				cadastros.add(cadastross);
				
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rset != null) {
					rset.close();
				}
				
				if (pstm != null) {
					pstm.close();
				}
				
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
		 return cadastros;
	}

}
