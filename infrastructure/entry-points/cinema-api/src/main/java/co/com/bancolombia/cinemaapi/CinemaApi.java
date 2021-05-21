package co.com.bancolombia.cinemaapi;

import co.com.bancolombia.model.cinema.Cinema;
import co.com.bancolombia.model.cinema.ports.ResponseModel;
import co.com.bancolombia.usecase.cinema.CinemaUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api", produces = MediaType.APPLICATION_JSON_VALUE)
public class CinemaApi {

    private final CinemaUseCase useCase;

    @PostMapping(consumes = "application/json", produces = "application/json", value = "/save-cinema")
    private ResponseEntity<ResponseModel> saveCinema(@RequestBody Cinema cinema){
        ResponseModel response = useCase.saveCinema(cinema);

        return ResponseEntity
                .status(response.getStatus())
                .body(response);

    }


}
