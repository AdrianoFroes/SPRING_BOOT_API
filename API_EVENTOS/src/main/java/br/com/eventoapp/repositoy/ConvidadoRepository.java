package br.com.eventoapp.repositoy;

import org.springframework.data.repository.CrudRepository;

import br.com.eventoapp.models.Convidado;
import br.com.eventoapp.models.Evento;


public interface ConvidadoRepository extends CrudRepository<Convidado, String> {
	Iterable<Convidado> findByEvento(Evento evento);

}
