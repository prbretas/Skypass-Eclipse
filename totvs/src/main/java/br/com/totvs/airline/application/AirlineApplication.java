package br.com.totvs.airline.application;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import org.springframework.stereotype.Service;

import br.com.totvs.airline.application.command.AlterarAirlineCommand;
import br.com.totvs.airline.application.command.CriarAirlineCommand;
import br.com.totvs.airline.model.Airline;
import br.com.totvs.airline.model.AirlineAddress;
import br.com.totvs.airline.model.AirlineAircraft;
import br.com.totvs.airline.model.repository.AirlineRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class AirlineApplication {
	private final AirlineRepository repository;

	Set<Airline> airlines = new HashSet<>();

	public String criar(CriarAirlineCommand criarAirlineCommand) {
		var airlineId = UUID.randomUUID().toString();

		Airline airline = Airline.builder()
				.id(airlineId)
				.companyName(criarAirlineCommand.getCompanyName())
				.numReg(criarAirlineCommand.getNumReg())
				.phone(criarAirlineCommand.getPhone())
				.email(criarAirlineCommand.getEmail())
				.build();

		Set<AirlineAircraft> listaAircraft = new HashSet<>();
		criarAirlineCommand.getAircrafts().stream().forEach(aircraft -> {
			listaAircraft.add(AirlineAircraft.of(aircraft, airlineId));
		});
		airline.setAircrafts(listaAircraft);
		
		Set<AirlineAddress> listaAddress = new HashSet<>();
		criarAirlineCommand.getAddresses().stream().forEach(address -> {
			listaAddress.add(AirlineAddress.of(address, airlineId));
		});
		airline.setAddresses(listaAddress);

		this.repository.save(airline);
		return airline.getId();
	}

	public void alterar(AlterarAirlineCommand alterarAirlineCommand) {
		this.repository.findById(alterarAirlineCommand.getId()).ifPresent(airline -> {
			airline.setCompanyName(alterarAirlineCommand.getCompanyName());
			airline.setNumReg(alterarAirlineCommand.getNumReg());
			airline.setPhone(alterarAirlineCommand.getPhone());
			airline.setEmail(alterarAirlineCommand.getEmail());

			Set<AirlineAircraft> listaAircraft = new HashSet<>();
			alterarAirlineCommand.getAircrafts().stream().forEach(aircraft -> {
				listaAircraft.add(AirlineAircraft.of(aircraft, airline.getId()));
			});
			airline.setAircrafts(listaAircraft);
			
			Set<AirlineAddress> listaAddress = new HashSet<>();
			alterarAirlineCommand.getAddresses().stream().forEach(address -> {
				listaAddress.add(AirlineAddress.of(address, airline.getId()));
			});
			airline.setAddresses(listaAddress);

			this.repository.save(airline);
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