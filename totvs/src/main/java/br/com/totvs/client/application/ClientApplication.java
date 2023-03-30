package br.com.totvs.client.application;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import org.springframework.stereotype.Service;

import br.com.totvs.client.application.command.AlterarClientCommand;
import br.com.totvs.client.application.command.CriarClientCommand;
import br.com.totvs.client.model.Client;
import br.com.totvs.client.model.repository.ClientRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ClientApplication {
	private final ClientRepository repository;

	Set<Client> clients = new HashSet<>();

	public String criar(CriarClientCommand criarClientCommand) {
		Client client = Client.builder().id(UUID.randomUUID().toString())
				.userName(criarClientCommand.getUserName())
				.name(criarClientCommand.getName())
				.lastName(criarClientCommand.getLastName())
				.numReg(criarClientCommand.getNumReg())
				.phone(criarClientCommand.getPhone())
				.email(criarClientCommand.getEmail())
				.password(criarClientCommand.getPassword())
				.birthdate(criarClientCommand.getBirthdate())
				.build();

		this.repository.save(client);

		return client.getId();
	}

	public void alterar(AlterarClientCommand alterarClientCommand) {
		this.repository.findById(alterarClientCommand.getId()).ifPresent(client -> {
			client.setUserName(alterarClientCommand.getUserName());
			client.setName(alterarClientCommand.getName());
			client.setLastName(alterarClientCommand.getLastName());
			client.setNumReg(alterarClientCommand.getNumReg());
			client.setPhone(alterarClientCommand.getPhone());
			client.setEmail(alterarClientCommand.getEmail());
			client.setPassword(alterarClientCommand.getPassword());
			client.setBirthdate(alterarClientCommand.getBirthdate());

			this.repository.save(client);
		});
	}

	public void ativar(String id) {
		this.repository.findById(id).ifPresent(client -> {
			client.ativar();

			this.repository.save(client);
		});
	}

	public void inativar(String id) {
		this.repository.findById(id).ifPresent(client -> {
			client.inativar();

			this.repository.save(client);
		});
	}
}