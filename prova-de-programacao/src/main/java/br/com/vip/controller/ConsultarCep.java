package br.com.vip.controller;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import com.google.gson.Gson;

import br.com.vip.model.Endereco;

public class ConsultarCep {

	public Endereco buscarEndereco(String cep) {

		URI endereco = URI.create("https://viacep.com.br/ws/" + cep + "/json/");
		HttpRequest request = HttpRequest.newBuilder().uri(endereco).build();

		try {
			HttpResponse<String> response = HttpClient.newHttpClient().send(request,
					HttpResponse.BodyHandlers.ofString());
			System.out.println(response.body());
			return new Gson().fromJson(response.body(), Endereco.class);
		} catch (Exception e) {
			throw new RuntimeException("Não consegui obter o endereço a partir desse CEP.");
		}
	}
}
