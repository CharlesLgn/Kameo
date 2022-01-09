package fr.metz.iut.kameo.web.graphql.schema.input;

import fr.metz.iut.film.structure.type.FilmType;

import java.time.LocalDate;

public record FilmInput(String name,
                        LocalDate releaseDate,
                        String directorId,
                        String summary,
                        FilmType typeOfFilm,
                        String imdbID) {
}
