package com.cp.librarymanagement.repository;

import com.cp.librarymanagement.entity.Location;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocationRepository extends JpaRepository<Location, Long> {
}
