package br.com.totvs.airport.application;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import org.springframework.stereotype.Service;

import br.com.totvs.airport.application.command.AlterarAirportCommand;
import br.com.totvs.airport.application.command.CriarAirportCommand;
import br.com.totvs.airport.model.Airport;
import br.com.totvs.airport.model.repository.AirportRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class AirportApplication {
	private final AirportRepository repository;

	Set<Airport> airports = new HashSet<>();

	public String criar(CriarAirportCommand criarAirportCommand) {
		Airport airport = Airport.builder().id(UUID.randomUUID().toString())
				.airportName(criarAirportCommand.getAirportName())
				.iataCode(criarAirportCommand.getIataCode())
				.phone(criarAirportCommand.getPhone())
				.email(criarAirportCommand.getEmail())	
				.addressId(criarAirportCommand.getAddressId())
				.build();

		this.repository.save(airport);
		return airport.getId();
	}

	public void alterar(AlterarAirportCommand alterarAirportCommand) {
		this.repository.findById(alterarAirportCommand.getId()).ifPresent(airport -> {
			airport.setAirportName(alterarAirportCommand.getAirportName());
			airport.setIataCode(alterarAirportCommand.getIataCode());
			airport.setPhone(alterarAirportCommand.getPhone());
			airport.setEmail(alterarAirportCommand.getEmail());
			airport.setAddressId(alterarAirportCommand.getAddressId());
			
			this.repository.save(airport);
		});
	}

	public void ativar(String id) {
		this.repository.findById(id).ifPresent(airport -> {
			airport.ativar();

			this.repository.save(airport);
		});
	}

	public void inativar(String id) {
		this.repository.findById(id).ifPresent(airport -> {
			airport.inativar();

			this.repository.save(airport);
		});
	}
}