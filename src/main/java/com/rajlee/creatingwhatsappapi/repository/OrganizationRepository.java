package com.rajlee.creatingwhatsappapi.repository;

import com.rajlee.creatingwhatsappapi.model.Organization;
//import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrganizationRepository extends MongoRepository<Organization,Integer> {
}
