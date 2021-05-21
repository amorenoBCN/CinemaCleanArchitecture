package co.com.bancolombia.jpa;

import co.com.bancolombia.jpa.helper.AdapterOperations;
import co.com.bancolombia.jpa.models.CinemaData;
import co.com.bancolombia.model.cinema.Cinema;
import co.com.bancolombia.model.cinema.gateways.CinemaRepository;
import lombok.extern.log4j.Log4j2;
import org.reactivecommons.utils.ObjectMapper;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Log4j2
@Repository
public class JPARepositoryAdapter extends AdapterOperations<Cinema/* change for domain model */, CinemaData/* change for adapter model */, UUID, JPARepository>
 implements CinemaRepository
{

    public JPARepositoryAdapter(JPARepository repository, ObjectMapper mapper) {
        /**
         *  Could be use mapper.mapBuilder if your domain model implement builder pattern
         *  super(repository, mapper, d -> mapper.mapBuilder(d,ObjectModel.ObjectModelBuilder.class).build());
         *  Or using mapper.map with the class of the object model
         */
        super(repository, mapper, d -> mapper.mapBuilder(d, Cinema.CinemaBuilder.class/* change for domain model */).build());
    }

    @Override
    public Cinema saveCinema(Cinema cinema) {
        log.info("Guardando...");
        CinemaData cinemaData = mapper.mapBuilder(cinema, CinemaData.class);
        cinemaData.setId(cinema.getId());
        cinemaData.setName(cinema.getName());
        repository.save(cinemaData);

        //Validaciones a nivel de base datos que necesitemos

        repository.existsById(cinema.getId());

        return cinema;
    }
}
