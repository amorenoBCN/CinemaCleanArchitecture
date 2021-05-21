package co.com.bancolombia.jpa;

import co.com.bancolombia.jpa.models.CinemaData;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;

import java.util.UUID;

public interface JPARepository extends CrudRepository<CinemaData/* change for adapter model */, UUID>, QueryByExampleExecutor<CinemaData/* change for adapter model */> {
}
