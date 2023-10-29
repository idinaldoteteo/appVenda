package br.edu.infinet.appvenda;

import java.io.BufferedReader;
import java.io.FileReader;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import br.edu.infinet.appvenda.model.domain.Livro;
import br.edu.infinet.appvenda.model.domain.Vendedor;
import br.edu.infinet.appvenda.model.service.LivroService;

@Order(2)
@Component
public class LivroLoader implements ApplicationRunner{

	@Autowired
	LivroService service;
	
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		
		
		FileReader file = new FileReader("file/livro.txt");
		BufferedReader leitura = new BufferedReader(file);
		
		String linha = leitura.readLine();
		String[] conteudo = null;
		Livro livro = null;
		int posicao = 0;
		int idVendedor = 0;
		
		while(linha != null) {
			
			conteudo = linha.split(";");
			posicao = 0;
			
			livro = new Livro();			
			livro.setNome(conteudo[posicao]);
			livro.setEditora(conteudo[++posicao]);
			livro.setPeso(Float.parseFloat(conteudo[++posicao]));			
			
			livro.setDescricao(conteudo[++posicao]);
			livro.setCodigo(Integer.parseInt(conteudo[++posicao]));
			livro.setPreco(Float.parseFloat(conteudo[++posicao]));
			livro.setEstoque(Boolean.parseBoolean(conteudo[++posicao]));
			idVendedor = Integer.parseInt(conteudo[++posicao]);
			livro.setVendedor(Vendedor.CriarVendedor(idVendedor));
			
			service.incluir(livro);
			
			linha = leitura.readLine();
		}
		
		for (Livro livroItem : service.ObterLista()) {
			System.out.println(livroItem);
		}

		
		leitura.close();
		
	}

}
