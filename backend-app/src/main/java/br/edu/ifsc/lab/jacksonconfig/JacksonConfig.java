package br.edu.ifsc.lab.jacksonconfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;

import com.fasterxml.jackson.databind.ObjectMapper;

import br.edu.ifsc.lab.domain.PagamentoAVista;
import br.edu.ifsc.lab.domain.PagamentoBoleto;
import br.edu.ifsc.lab.domain.PagamentoCartao;
import br.edu.ifsc.lab.domain.ProdutoVenda;

@Configuration
public class JacksonConfig {
// https://stackoverflow.com/questions/41452598/overcome-can-not-construct-instance-ofinterfaceclass-without-hinting-the-pare
	@Bean
	public Jackson2ObjectMapperBuilder objectMapperBuilder() {
		Jackson2ObjectMapperBuilder builder = new Jackson2ObjectMapperBuilder() {
			public void configure(ObjectMapper objectMapper) {
				objectMapper.registerSubtypes(PagamentoCartao.class);
				objectMapper.registerSubtypes(PagamentoBoleto.class);
				objectMapper.registerSubtypes(PagamentoAVista.class);
				objectMapper.registerSubtypes(ProdutoVenda.class);
				super.configure(objectMapper);
			};
		};
		return builder;
	}
}