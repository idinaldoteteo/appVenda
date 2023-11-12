package br.edu.infinet.appvenda;

import java.io.BufferedReader;
import java.io.FileReader;

import javax.validation.ConstraintViolationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import br.edu.infinet.appvenda.model.domain.Livro;
import br.edu.infinet.appvenda.model.domain.Produto;
import br.edu.infinet.appvenda.model.domain.Vendedor;
import br.edu.infinet.appvenda.model.domain.Vestuario;
import br.edu.infinet.appvenda.model.service.ProdutoService;

@Order(4)
@Component
public class ProdutoLoader implements ApplicationRunner{

	@Autowired
	ProdutoService service;
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		
		
		FileReader file = new FileReader("file/produto.txt");
		BufferedReader leitura = new BufferedReader(file);
		
		String linha = leitura.readLine();
		String[] conteudo = null;
		int posicao = 0;
		int idVendedor = 0;
		
		while(linha != null) {
			
			conteudo = linha.split(";");			
			posicao = 0;
			
			switch (conteudo[posicao]) {
			case "V":
				Vestuario vestuario = new Vestuario();
				vestuario.setTamanho(conteudo[++posicao]);
				vestuario.setMarca(conteudo[++posicao]);
				vestuario.setEstampada(Boolean.parseBoolean(conteudo[++posicao]));
				
				vestuario.setDescricao(conteudo[++posicao]);
				vestuario.setCodigo(Integer.parseInt(conteudo[++posicao]));
				vestuario.setPreco(Float.parseFloat(conteudo[++posicao]));
				vestuario.setEstoque(Boolean.parseBoolean(conteudo[++posicao]));
				idVendedor = Integer.parseInt(conteudo[++posicao]);
				vestuario.setVendedor(Vendedor.CriarVendedor(idVendedor));
				
				
				try {
					service.incluir(vestuario);
				} catch (ConstraintViolationException ex) {
					StringBuilder builder = new StringBuilder();
					builder
						.append("[VALIDAÇÃO]")
						.append(this.getClass().getSimpleName())
						.append(ex.getMessage());
					
					FileLogger.LogException(builder.toString());
				}
				
				break;
			case "L":
				Livro livro = new Livro();			
				livro.setNome(conteudo[++posicao]);
				livro.setEditora(conteudo[++posicao]);
				livro.setPeso(Float.parseFloat(conteudo[++posicao]));			
				
				livro.setDescricao(conteudo[++posicao]);
				livro.setCodigo(Integer.parseInt(conteudo[++posicao]));
				livro.setPreco(Float.parseFloat(conteudo[++posicao]));
				livro.setEstoque(Boolean.parseBoolean(conteudo[++posicao]));
				idVendedor = Integer.parseInt(conteudo[++posicao]);
				livro.setVendedor(Vendedor.CriarVendedor(idVendedor));
				
				
				try {
					service.incluir(livro);
				} catch (ConstraintViolationException ex) {
					StringBuilder builder = new StringBuilder();
					builder
						.append("[VALIDAÇÃO]")
						.append(this.getClass().getSimpleName())
						.append(ex.getMessage());
					
					FileLogger.LogException(builder.toString());
				}
				
				break;
			default:
				break;
			}			
			
			linha = leitura.readLine();
		}
		
		service.GerarRelatorioProdutos();
		
		service.GerarRelatorioProdutosPorVendedorComId(1);		
		
		leitura.close();
		
	}
}
