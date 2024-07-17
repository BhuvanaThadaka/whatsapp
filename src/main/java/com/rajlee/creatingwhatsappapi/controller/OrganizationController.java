package com.rajlee.creatingwhatsappapi.controller;

import com.rajlee.creatingwhatsappapi.model.Organization;
import com.rajlee.creatingwhatsappapi.service.ApiWhatsappService;
import com.rajlee.creatingwhatsappapi.service.OrganizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OrganizationController {

    @Autowired
    private OrganizationService organizationService;

    @PostMapping("/addOrganization")
    public Organization addOrganization(@RequestBody Organization organization) {
        return organizationService.saveOrganization(organization);
    }

    @PostMapping("/addOrganizations")
    public List<Organization> addOrganizations(@RequestBody List<Organization> organizations) {
        return organizationService.saveOrganizations(organizations);
    }

    @GetMapping("/org/{id}")
    public Organization findOrganizationById(@PathVariable int id) {
        return organizationService.getOrganizationById(id);
    }

    @GetMapping("/organizations")
    public List<Organization> findAllOrganizations() {
        return organizationService.getOrganizations();
    }

    @DeleteMapping("/deleteOrg/{id}")
    public String deleteOrganizationById(@PathVariable int id) {
        return organizationService.deleteOrganization(id);
    }

    @PutMapping("/updateOrg")
    public Organization updateOrganizatio(@RequestBody Organization org) {
        return organizationService.updateOrganization(org);
    }
}
