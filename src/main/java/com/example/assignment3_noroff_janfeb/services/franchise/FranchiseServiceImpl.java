package com.example.assignment3_noroff_janfeb.services.franchise;

import com.example.assignment3_noroff_janfeb.models.Franchise;
import com.example.assignment3_noroff_janfeb.repositories.FranchiseRepository;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class FranchiseServiceImpl implements FranchiseService {

    private final FranchiseRepository franchiseRepository;

    public FranchiseServiceImpl(FranchiseRepository franchiseRepository) {
        this.franchiseRepository = franchiseRepository;
    }

    @Override
    public Franchise findById(Integer integer) {
        return franchiseRepository.findById(integer).get();
    }

    @Override
    public Collection<Franchise> findAll() {
        return null;
    }

    @Override
    public Franchise add(Franchise entity) {
        return null;
    }

    @Override
    public Franchise update(Franchise entity) {
        return null;
    }

    @Override
    public void deleteById(Integer integer) {

    }

    @Override
    public boolean exists(Integer integer) {
        return false;
    }
}
