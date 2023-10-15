package com.example.demo.service;

import com.example.demo.domain.OutsourcedPart;
import com.example.demo.repositories.OutsourcedPartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 *
 *
 *
 *
 */
@Service
public class OutsourcedPartServiceImpl implements OutsourcedPartService{
    private OutsourcedPartRepository partRepository;

    @Autowired
    public OutsourcedPartServiceImpl(OutsourcedPartRepository partRepository) {
        this.partRepository = partRepository;
    }

    //method to find all outsourced parts in the repo
    @Override
    public List<OutsourcedPart> findAll() {
        return (List<OutsourcedPart>) partRepository.findAll();
    }

    //method to find an inhouse part in the repo by its id
    @Override
    public OutsourcedPart findById(int theId) {
        Long theIdl=(long)theId;
        Optional<OutsourcedPart> result = partRepository.findById(theIdl);

        OutsourcedPart thePart = null;

        if (result.isPresent()) {
            thePart = result.get();
        }
        else {
            // we didn't find the OutSourced id
            //throw new RuntimeException("Did not find part id - " + theId);
            return null;
        }

        return thePart;
    }

    //method to save the inhouse part to the repo
    @Override
    public void save(OutsourcedPart thePart) {
        partRepository.save(thePart);

    }

    //method to delete the inhouse part from the repo by its id
    @Override
    public void deleteById(int theId) {
        Long theIdl=(long)theId;
        partRepository.deleteById(theIdl);
    }

}
