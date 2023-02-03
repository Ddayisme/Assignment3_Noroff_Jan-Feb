package com.example.assignment3_noroff_janfeb.services.franchise;

import com.example.assignment3_noroff_janfeb.exceptions.FranchiseNotFoundException;
import com.example.assignment3_noroff_janfeb.models.Character;
import com.example.assignment3_noroff_janfeb.models.Franchise;
import com.example.assignment3_noroff_janfeb.models.Movies;
import com.example.assignment3_noroff_janfeb.repositories.FranchiseRepository;
import com.example.assignment3_noroff_janfeb.repositories.MoviesRepository;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

/**
 * Our implementation of the movie service. Which we use in the controller.
 * This layer connects to the database and performs querys behind the scenes through
 * the methods implemented.
 */
@Service
public class FranchiseServiceImpl implements FranchiseService {
    private final FranchiseRepository franchiseRepository;
    private final MoviesRepository moviesRepository;

    public FranchiseServiceImpl(FranchiseRepository franchiseRepository, MoviesRepository moviesRepository) {
        this.franchiseRepository = franchiseRepository;
        this.moviesRepository = moviesRepository;
    }

    /**
     * Find a single franchise object in the database with the specified id
     * @param id
     * @return
     */
    @Override
    public Franchise findById(Integer id) {
        return franchiseRepository.findById(id).orElseThrow(() -> new FranchiseNotFoundException(id));
    }

    /**
     * Find all the franchise objects in the database as a collection
     * @return
     */
    @Override
    public Collection<Franchise> findAll() {
        return franchiseRepository.findAll();
    }

    /**
     * Add a franchise object to the database
     * @param entity -is the franchise object
     * @return
     */
    @Override
    public Franchise add(Franchise entity) {
        return franchiseRepository.save(entity);
    }

    /**
     * Update a franchise object by using a whole new Franchise object as parameter
     * and updates the whole object with the specified id
     * @param entity
     * @return
     */
    @Override
    public Franchise update(Franchise entity) {
        return franchiseRepository.save(entity);
    }

    /**
     * Deleting a franchise object in the database with the specified id
     * @param id
     */
    @Override
    public void deleteById(Integer id) {
        Franchise franchise = franchiseRepository.findById(id).orElseThrow(() -> new FranchiseNotFoundException(id));
        franchise.getMovies().forEach(m -> m.setFranchise(null));
        franchiseRepository.deleteById(id);
    }

    /**
     * Updates the movies field in a franchise
     * @param movieIds -Array of ints as movie ids
     * @param franchiseId -The specified franchise id
     * @return
     */

    @Override
    public Franchise updateMoviesInAFranchise(int[] movieIds, int franchiseId){
        Franchise franchise = franchiseRepository.findById(franchiseId).orElseThrow(() -> new FranchiseNotFoundException(franchiseId));
        if(movieIds[0] == 0){
            for(Movies movie : franchise.getMovies()){
                movie.setFranchise(null);
                moviesRepository.save(movie);
            }
        }
        else{
            for(int i = 0; i < movieIds.length; i++){
                Movies movie = moviesRepository.findById(movieIds[i]).get();
                movie.setFranchise(franchise);
                moviesRepository.save(movie);
            }
        }
        return franchise;
    }
    /**
     * Helper method to check if the specified franchise object
     * exists in the database with the specified id.
     * @param id
     * @return
     */
    @Override
    public boolean exists(Integer id) {
        return franchiseRepository.existsById(id);
    }

    /**
     * The method finds all the movies in a given franchise
     * @param franchiseId
     * @return
     */
    @Override
    public Collection<Movies> findAllMoviesInFranchise(int franchiseId) {
        Franchise franchise = franchiseRepository.findById(franchiseId).orElseThrow(() -> new FranchiseNotFoundException(franchiseId));
        Collection<Movies> movies = new HashSet<>();

        movies.addAll(franchise.getMovies());
        return movies;
    }

    /**
     * find all the characters in a given franchise
     * @param franchiseId
     * @return
     */

    @Override
    public Collection<Character> findAllCharactersInFranchise(int franchiseId){
        Franchise franchise=franchiseRepository.findById(franchiseId).orElseThrow(() -> new FranchiseNotFoundException(franchiseId));
        Collection<Movies >movies= new HashSet<>();

        movies.addAll(franchise.getMovies());
        Collection<Character> characters = new HashSet<>();

        for (Movies var: movies
             ) {
           characters.addAll(var.getCharacters());
        }
        return characters;
    }
}
