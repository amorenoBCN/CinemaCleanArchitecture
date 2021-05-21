package co.com.bancolombia.model.cinema.gateways;

import co.com.bancolombia.model.cinema.Cinema;

public interface CinemaRepository {
    Cinema saveCinema(Cinema cinema);
}
