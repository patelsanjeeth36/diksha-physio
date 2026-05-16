package com.diksha.physio.repository;

import com.diksha.physio.entity.CallbackRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CallbackRequestRepository extends JpaRepository<CallbackRequest, Long> {
}
