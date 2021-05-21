package co.com.bancolombia.usecase.cinema;

import co.com.bancolombia.model.cinema.Cinema;
import co.com.bancolombia.model.cinema.gateways.CinemaRepository;
import co.com.bancolombia.model.cinema.ports.ResponseModel;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CinemaUseCase {

    private final CinemaRepository cinemaRepository;

    public ResponseModel saveCinema(Cinema cinema){
        //Desarrollo de logica de negocio
        //Response Model - Clase de respuesta
        ResponseModel response = ResponseModel.builder().build();

        //Consulta a base de datos
        Cinema result = cinemaRepository.saveCinema(cinema);

        //Validaciones necesarias para controlar el flujo de negocio
        if(result.getId() != null){
            response.setStatus(201);
            response.setDescription("Cinema ".concat(result.getName().concat(" fue creado con exito")));
        }else{
            response.setStatus(400);
            response.setDescription("Error al guardar el cinema.");
        }

        return response;

    }

}
