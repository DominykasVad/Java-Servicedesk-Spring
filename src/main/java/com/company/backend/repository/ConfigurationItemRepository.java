package com.company.backend.repository;

import com.company.backend.entity.ConfigurationItem;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface ConfigurationItemRepository extends JpaRepository<ConfigurationItem, Long> {

    @Query(value = "SELECT ci FROM ConfigurationItem ci JOIN FETCH ci.serviceRequests sr WHERE sr.id = :serviceRequestId",
            countQuery = "SELECT count(ci) FROM ConfigurationItem ci")
    Page<ConfigurationItem> findAllConfigurationItemsByServiceRequestId(@Param("serviceRequestId") Long serviceRequestIde, Pageable pageable);

}
