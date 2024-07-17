package com.rajlee.creatingwhatsappapi.service;

import com.rajlee.creatingwhatsappapi.model.Organization;
import com.rajlee.creatingwhatsappapi.repository.OrganizationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrganizationService {

    @Autowired
    private OrganizationRepository organizationRepository;

    public List<Organization> saveOrganizations(List<Organization> organizations) {
        return organizationRepository.saveAll(organizations);
    }

    public Organization saveOrganization(Organization organization){
        return organizationRepository.save(organization);
    }

    public Organization getOrganizationById(int id) {
        return organizationRepository.findById(id).orElse(null);
    }

    public List<Organization> getOrganizations() {
        List<Organization> organizations = organizationRepository.findAll();
        System.out.println("Getting data from db"+organizations);
        return organizations;
    }

    public String deleteOrganization(int id){
        organizationRepository.deleteById(id);
        return "organization removed"+id;
    }

    public Organization updateOrganization(Organization organization) {
        Organization existingOrganization = organizationRepository.findById(organization.getOrgId()).orElse(null);
        existingOrganization.setOrgName(organization.getOrgName());
        existingOrganization.setPlace(organization.getPlace());
        return organizationRepository.save(existingOrganization);
    }
}
