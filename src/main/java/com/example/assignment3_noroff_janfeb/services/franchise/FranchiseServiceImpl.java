package com.example.assignment3_noroff_janfeb.services.franchise;

import com.example.assignment3_noroff_janfeb.models.Franchise;
import com.example.assignment3_noroff_janfeb.models.Movies;
import com.example.assignment3_noroff_janfeb.repositories.FranchiseRepository;
import com.example.assignment3_noroff_janfeb.repositories.MoviesRepository;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class FranchiseServiceImpl implements FranchiseService {
    private final FranchiseRepository franchiseRepository;
    private final MoviesRepository moviesRepository;

    public FranchiseServiceImpl(FranchiseRepository franchiseRepository, MoviesRepository moviesRepository) {
        this.franchiseRepository = franchiseRepository;
        this.moviesRepository = moviesRepository;
    }

    @Override
    public Franchise findById(Integer id) {
        return franchiseRepository.findById(id).get();
    }

    @Override
    public Collection<Franchise> findAll() {
        return franchiseRepository.findAll();
    }

    @Override
    public Franchise add(Franchise entity) {
        return franchiseRepository.save(entity);
    }

    @Override
    public Franchise update(Franchise entity) {
        return franchiseRepository.save(entity);
    }

    @Override
    public void deleteById(Integer id) {
        Franchise franchise = franchiseRepository.findById(id).get();
        franchise.getMovies().forEach(m -> m.setFranchise(null));
        franchiseRepository.deleteById(id);
    }

    @Override
    public Franchise updateMoviesInAFranchise(int[] movieIds, int franchiseId){
        Franchise franchise = franchiseRepository.findById(franchiseId).get();
        for(int i = 0; i < movieIds.length; i++){
            Movies movie = moviesRepository.findById(movieIds[i]).get();
            movie.setFranchise(franchise);
            moviesRepository.save(movie);
        }
        return franchise;
    }

    @Override
    public boolean exists(Integer id) {
        return franchiseRepository.existsById(id);
    }
}
