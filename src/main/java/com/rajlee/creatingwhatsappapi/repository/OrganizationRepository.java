package com.rajlee.creatingwhatsappapi.repository;

import com.rajlee.creatingwhatsappapi.model.Organization;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrganizationRepository extends JpaRepository<Organization,Integer> {
}
