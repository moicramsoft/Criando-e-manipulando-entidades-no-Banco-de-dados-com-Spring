package com.challenge.repository;

import com.challenge.entity.Acceleration;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccelerationRepository extends CrudRepository<Acceleration, Long> {
    @Query(value = "SELECT a FROM Acceleration a JOIN a.candidates c WHERE c.id.company.id = ?1")
    List<Acceleration> findByCompanyId(Long companyId);
}