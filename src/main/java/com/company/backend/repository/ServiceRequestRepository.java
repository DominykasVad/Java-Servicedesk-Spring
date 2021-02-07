package com.company.backend.repository;

import com.company.backend.entity.ConfigurationItem;
import com.company.backend.entity.ServiceRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ServiceRequestRepository extends JpaRepository<ServiceRequest, Long> {

    @Query(value = "SELECT sr FROM ServiceRequest sr WHERE sr.owner.id = :ownerId")
    Page<ServiceRequest> findAllByOwnerId(@Param("ownerId") Long ownerId, Pageable pageable);

}
