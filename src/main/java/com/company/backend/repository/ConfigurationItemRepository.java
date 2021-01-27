package com.company.backend.repository;

import com.company.backend.entity.ConfigurationItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConfigurationItemRepository extends JpaRepository<ConfigurationItem, Long> {
}
