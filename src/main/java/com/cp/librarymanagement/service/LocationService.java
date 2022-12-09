package com.cp.librarymanagement.service;

import com.cp.librarymanagement.dto.LocationDTO;
import com.cp.librarymanagement.entity.Book;
import com.cp.librarymanagement.entity.Location;
import com.cp.librarymanagement.repository.BookRepository;
import com.cp.librarymanagement.repository.LocationRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@Service
public class LocationService {
    @Autowired
    private LocationRepository locationRepo;

    @Autowired
    private BookRepository bookRepo;

    public List<LocationDTO> getAllLocation() {
        log.info("Get all location list");
        return locationRepo.findAll().stream().map(this::convertEntityToDTO).collect(Collectors.toList());
    }

    private LocationDTO convertEntityToDTO(Location entity) {
        LocationDTO dto = new LocationDTO();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setCountBook(bookRepo.findBookByLocation_Id(entity.getId()).size());
        return dto;
    }

    public void saveLocation(Location entity) {
        log.info("Save location #name: " + entity.getName());
        locationRepo.save(entity);
    }

    public void deleteLocation(Long id) {
        log.info("Delete location - #id: " + id);
        locationRepo.deleteById(id);
    }

    public Optional<Location> findLocationById(Long id) {
        log.info("Find location - #id: " + id);
        Optional<Location> location = locationRepo.findById(id);
        return location;
    }
}
