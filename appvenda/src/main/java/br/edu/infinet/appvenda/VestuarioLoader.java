package br.edu.infinet.appvenda;

import java.io.BufferedReader;
import java.io.FileReader;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import br.edu.infinet.appvenda.model.domain.Vendedor;
import br.edu.infinet.appvenda.model.domain.Vestuario;
import br.edu.infinet.appvenda.model.service.VestuarioService;

@Order(3)
@Component
public class VestuarioLoader implements ApplicationRunner{

	@Autowired
	VestuarioService service;
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		
		
		FileReader file = new FileReader("file/vestuario.txt");
		BufferedReader leitura = new BufferedReader(file);
		
		String linha = leitura.readLine();
		String[] conteudo = null;
		Vestuario vestuario = null;
		int posicao = 0;
		int idVendedor = 0;
		
		while(linha != null) {
			
			conteudo = linha.split(";");			
			posicao = 0;
			
			vestuario = new Vestuario();
			vestuario.setTamanho(conteudo[posicao]);
			vestuario.setMarca(conteudo[++posicao]);
			vestuario.setEstampada(Boolean.parseBoolean(conteudo[++posicao]));
			
			vestuario.setDescricao(conteudo[++posicao]);
			vestuario.setCodigo(Integer.parseInt(conteudo[++posicao]));
			vestuario.setPreco(Float.parseFloat(conteudo[++posicao]));
			vestuario.setEstoque(Boolean.parseBoolean(conteudo[++posicao]));
			idVendedor = Integer.parseInt(conteudo[++posicao]);
			vestuario.setVendedor(Vendedor.CriarVendedor(idVendedor));
			
			service.incluir(vestuario);
			
			linha = leitura.readLine();
		}
		
		for (Vestuario vestuarioItem : service.ObterLista()) {
			System.out.println(vestuarioItem);
		}
		
		leitura.close();
		
	}	

}
