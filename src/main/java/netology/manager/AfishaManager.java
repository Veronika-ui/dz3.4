package netology.manager;

import lombok.NoArgsConstructor;
import netology.domain.MovieItem;


@NoArgsConstructor
public class AfishaManager {
    private MovieItem[] movies = new MovieItem[0];
    private int moviesToReturn;
    private int moviesToReturnDefault = 10;

    public AfishaManager(int moviesToReturn) {
        this.moviesToReturn = moviesToReturn;
    }

    public AfishaManager() {

    }

    public void add(MovieItem movieItem) {

        MovieItem[] tmp = new MovieItem[movies.length + 1];

        System.arraycopy(movies, 0, tmp, 0, movies.length);

        tmp[tmp.length - 1] = movieItem;

        movies = tmp;
    }

    public MovieItem[] getMovies() {
        int arrayLength;

        if (moviesToReturn <= 0)
            moviesToReturn = moviesToReturnDefault;
        arrayLength = moviesToReturn;

        if (moviesToReturn > movies.length) {
            arrayLength = movies.length;
        }


        MovieItem[] result = new MovieItem[arrayLength];

        for (int i = 0; i < arrayLength; i++) {
            int index = movies.length - i - 1;
            result[i] = movies[index];
        }

        return result;
    }
}