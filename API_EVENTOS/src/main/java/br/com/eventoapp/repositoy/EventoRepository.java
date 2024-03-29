package br.com.eventoapp.repositoy;

import org.springframework.data.repository.CrudRepository;

import br.com.eventoapp.models.Evento;

public interface EventoRepository extends CrudRepository<Evento, String>{
	
	Evento findByCodigo(long codigo);

}
