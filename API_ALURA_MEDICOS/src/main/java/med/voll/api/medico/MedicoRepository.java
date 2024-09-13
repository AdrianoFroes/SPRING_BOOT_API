package med.voll.api.medico;

import java.lang.annotation.Repeatable;

import org.hibernate.query.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicoRepository extends JpaRepository<Medico, Long>{

	Object findAll(Repeatable paginacao);

	Page findAllByAtivoTrue(Pageable paginacao);

}
