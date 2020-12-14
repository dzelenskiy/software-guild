/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.superherosightings.dao;

import com.sg.superherosightings.model.HeroVillain;
import com.sg.superherosightings.model.Location;
import com.sg.superherosightings.model.Organization;
import com.sg.superherosightings.model.Sighting;
import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author DZ
 */
public interface SuperheroSightingsDao {

    public void addHeroVillain(HeroVillain heroVillain);

    public void updateHeroVillain(HeroVillain heroVillain);

    public void deleteHeroVillain(int id);

    public HeroVillain getHeroVillainById(int id);

    public List<HeroVillain> getHeroVillainsBySightingId(int sightingId);

    public List<HeroVillain> getHeroVillainsByOrganizationId(int organizationId);

    public List<HeroVillain> getAllHeroVillains();

    public void addLocation(Location location);

    public void updateLocation(Location location);

    public void deleteLocation(int id);

    public Location getLocationById(int id);

    public Location getLocationBySightingId(int sightingId);

    public List<Location> getAllLocations();

    public void addOrganization(Organization organization);

    public void updateOrganization(Organization organization);

    public void deleteOrganization(int id);

    public Organization getOrganizationById(int id);

    public List<Organization> getOrganizationsByHeroVillainId(int heroVillainId);

    public List<Organization> getAllOrganizations();

    public void addSighting(Sighting sighting);

    public void updateSighting(Sighting sighting);

    public void deleteSighting(int id);

    public Sighting getSightingById(int id);

    public List<Sighting> getAllSightingsByDate(LocalDate date);

    public List<Sighting> getAllSightingsByLocationId(int locationId);

    public List<Sighting> getAllSightingsByHeroVillainId(int heroVillainId);

    public List<Sighting> getAllSightings();

    public List<Sighting> getLastTenSightings();

}
