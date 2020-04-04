package com.challenge.repository;
import com.challenge.entity.Challenge;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Component
public interface ChallengeRepository extends CrudRepository<Challenge, Long> {
	@Query(value = "SELECT c from Challenge c JOIN c.submissions s JOIN c.accelerations a where a.id = ?1 and s.id.user.id = ?2")
    List<Challenge> findByAccelerationIdAndUserId(Long accelerationId, Long userId);}