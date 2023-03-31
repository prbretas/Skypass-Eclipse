package br.com.totvs.airline.application;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import org.springframework.stereotype.Service;

import br.com.totvs.airline.application.command.AlterarAirlineCommand;
import br.com.totvs.airline.application.command.CriarAirlineCommand;
import br.com.totvs.airline.model.Airline;
import br.com.totvs.airline.model.repository.AirlineRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class AirlineApplication {
	private final AirlineRepository repository;

	Set<Airline> airlines = new HashSet<>();

	public String criar(CriarAirlineCommand criarAirlineCommand) {
		Airline airline = Airline.builder().id(UUID.randomUUID().toString())
				.companyName(criarAirlineCommand.getCompanyName())
				.numReg(criarAirlineCommand.getNumReg())
				.phone(criarAirlineCommand.getPhone())
				.email(criarAirlineCommand.getEmail())	
				.addressId(criarAirlineCommand.getAddressId())
				//INCLUIR AIRCRAFTS
				.build();

		this.repository.save(airline);
		return airline.getId();
	}

	public void alterar(AlterarAirlineCommand alterarAirlineCommand) {
		this.repository.findById(alterarAirlineCommand.getId()).ifPresent(airport -> {
			airport.setCompanyName(alterarAirlineCommand.getCompanyName());
			airport.setNumReg(alterarAirlineCommand.getNumReg());
			airport.setPhone(alterarAirlineCommand.getPhone());
			airport.setEmail(alterarAirlineCommand.getEmail());
			airport.setAddressId(alterarAirlineCommand.getAddressId());
			//INCLUIR AIRCRAFTS
			this.repository.save(airport);
		});
	}

	public void ativar(String id) {
		this.repository.findById(id).ifPresent(airline -> {
			airline.ativar();

			this.repository.save(airline);
		});
	}

	public void inativar(String id) {
		this.repository.findById(id).ifPresent(airline -> {
			airline.inativar();

			this.repository.save(airline);
		});
	}
}