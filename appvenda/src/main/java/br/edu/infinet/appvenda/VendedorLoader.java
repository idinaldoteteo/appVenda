package br.edu.infinet.appvenda;

import java.io.BufferedReader;
import java.io.FileReader;

import javax.validation.ConstraintViolationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import br.edu.infinet.appvenda.model.domain.Endereco;
import br.edu.infinet.appvenda.model.domain.Vendedor;
import br.edu.infinet.appvenda.model.service.VendedorService;

@Order(1)
@Component
public class VendedorLoader implements ApplicationRunner{

	@Autowired
	VendedorService service;
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		
		
		FileReader file = new FileReader("file/vendedor.txt");
		BufferedReader leitura = new BufferedReader(file);
		
		String linha = leitura.readLine();
		String[] conteudo = null;
		Vendedor vendedor = null;
		int posicao = 0;
		
		while(linha != null) {
			
			conteudo = linha.split(";");
			posicao = 0;
			
			vendedor = new Vendedor();			
			vendedor.setNome(conteudo[posicao]);
			vendedor.setCpf(conteudo[++posicao]);
			vendedor.setEmail(conteudo[++posicao]);
			vendedor.setEndereco(Endereco.CriarEndereco(conteudo[++posicao]));
			
			try {
				service.incluir(vendedor);	
			} catch (ConstraintViolationException ex) {
				StringBuilder builder = new StringBuilder();
				builder
					.append("[VALIDAÇÃO]")
					.append(this.getClass().getSimpleName())
					.append(ex.getMessage());
				
				FileLogger.LogException(builder.toString());
			}
			
			
			linha = leitura.readLine();
		}
		
		for (Vendedor vendedorItem : service.ObterLista()) {
			System.out.println(vendedorItem);
		}
		
		leitura.close();
		
	}

}
