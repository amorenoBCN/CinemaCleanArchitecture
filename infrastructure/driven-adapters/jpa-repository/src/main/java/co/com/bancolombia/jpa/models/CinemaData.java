package co.com.bancolombia.jpa.models;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.UUID;

@Data
@RequiredArgsConstructor
@Entity
@Table(schema = "schcinema", name = "cinema")
public class CinemaData {

    @Id
    private UUID id;
    private String name;

}
