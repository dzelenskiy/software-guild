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
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author DZ
 */
public class SuperheroSightingsDaoTest {

    SuperheroSightingsDao dao;

    public SuperheroSightingsDaoTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("test-applicationContext.xml");
        dao = ctx.getBean("superheroSightingsDao", SuperheroSightingsDao.class);

        List<Location> locations = dao.getAllLocations();
        for (Location location : locations) {
            dao.deleteLocation(location.getId());
        }

        List<Organization> organizations = dao.getAllOrganizations();
        for (Organization organization : organizations) {
            dao.deleteOrganization(organization.getId());
        }

        List<Sighting> sightings = dao.getAllSightings();
        for (Sighting sighting : sightings) {
            dao.deleteSighting(sighting.getId());
        }

        List<HeroVillain> heroVillains = dao.getAllHeroVillains();
        for (HeroVillain heroVillain : heroVillains) {
            dao.deleteHeroVillain(heroVillain.getId());
        }
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of addHeroVillain method, of class SuperheroSightingsDao.
     */
    @Test
    public void testAddDeleteGetHVById() {
        HeroVillain heroVillain = new HeroVillain();
        heroVillain.setName("TestHero One");
        heroVillain.setDescription("This is a test description for TestHero One.");
        heroVillain.setPower("TestHero One Power");

        dao.addHeroVillain(heroVillain);

        Organization organization = new Organization();
        organization.setName("TestOrganization One");
        organization.setDescription("This is a test description for TestOrganization One.");
        organization.setAddress("123 Test St.");
        organization.setCity("Testville One");
        organization.setState("MN");
        organization.setPhone("1112223333");
        organization.setEmail("contactus@testorganizationone.com");
        organization.setWebsite("www.testorganizationone.com");
        List<HeroVillain> heroVillains = new ArrayList<>();
        heroVillains.add(heroVillain);
        organization.setHeroVillains(heroVillains);

        dao.addOrganization(organization);

        Location location = new Location();
        location.setName("TestLocation One");
        location.setDescription("This is a test description for TestLocation One.");
        location.setAddress("123 Test St.");
        location.setCity("Testville One");
        location.setState("MN");
        location.setLatitude(44.986656);
        location.setLongitude(-93.258133);

        dao.addLocation(location);

        Sighting sighting = new Sighting();
        sighting.setDate(LocalDate.parse("2018-01-01"));
        sighting.setLocation(location);
        sighting.setHeroVillains(heroVillains);

        dao.addSighting(sighting);

        HeroVillain fromDao = dao.getHeroVillainById(heroVillain.getId());
        assertEquals(heroVillain, fromDao);

        dao.deleteHeroVillain(fromDao.getId());
        assertNull(dao.getHeroVillainById(fromDao.getId()));
    }

    /**
     * Test of updateHeroVillain method, of class SuperheroSightingsDao.
     */
    @Test
    public void testUpdateHV() {
        HeroVillain heroVillain = new HeroVillain();
        heroVillain.setName("TestHero One");
        heroVillain.setDescription("This is a test description for TestHero One.");
        heroVillain.setPower("TestHero One Power");

        dao.addHeroVillain(heroVillain);

        HeroVillain fromDao = dao.getHeroVillainById(heroVillain.getId());
        assertEquals(heroVillain, fromDao);

        fromDao.setName("UpdatedHero One");
        fromDao.setDescription("This is an updated test description for UpdatedHero One.");
        fromDao.setPower("UpdateHero One UpdatedPower");

        dao.updateHeroVillain(fromDao);

        HeroVillain editedHV = dao.getHeroVillainById(fromDao.getId());

        assertNotSame(heroVillain, editedHV);
        assertEquals(editedHV, fromDao);
    }

    /**
     * Test of getHeroVillainsBySightingId method, of class SuperheroSightingsDao.
     */
    @Test
    public void testGetHVsBySightId() {
        Location location = new Location();
        location.setName("TestLocation One");
        location.setDescription("This is a test description for TestLocation One.");
        location.setAddress("123 Test St.");
        location.setCity("Testville One");
        location.setState("MN");
        location.setLatitude(44.986656);
        location.setLongitude(-93.258133);

        dao.addLocation(location);

        Location location2 = new Location();
        location2.setName("TestLocation Two");
        location2.setDescription("This is a test description for TestLocation Two.");
        location2.setAddress("456 Test St.");
        location2.setCity("Testville Two");
        location2.setState("WI");
        location2.setLatitude(48.986656);
        location2.setLongitude(-97.258133);

        dao.addLocation(location2);

        HeroVillain heroVillain = new HeroVillain();
        heroVillain.setName("TestHero One");
        heroVillain.setDescription("This is a test description for TestHero One.");
        heroVillain.setPower("TestHero One Power");

        dao.addHeroVillain(heroVillain);

        HeroVillain heroVillain2 = new HeroVillain();
        heroVillain2.setName("TestHero Two");
        heroVillain2.setDescription("This is a test description for TestHero Two.");
        heroVillain2.setPower("TestHero Two Power");

        dao.addHeroVillain(heroVillain2);

        HeroVillain heroVillain3 = new HeroVillain();
        heroVillain3.setName("TestHero Three");
        heroVillain3.setDescription("This is a test description for TestHero Three.");
        heroVillain3.setPower("TestHero Three Power");

        dao.addHeroVillain(heroVillain3);

        HeroVillain heroVillain4 = new HeroVillain();
        heroVillain4.setName("TestHero Four");
        heroVillain4.setDescription("This is a test description for TestHero Four.");
        heroVillain4.setPower("TestHero Four Power");

        dao.addHeroVillain(heroVillain4);

        Sighting sighting = new Sighting();
        sighting.setDate(LocalDate.parse("2018-01-01"));
        sighting.setLocation(location);
        List<HeroVillain> heroVillains = new ArrayList<>();
        heroVillains.add(heroVillain);
        heroVillains.add(heroVillain4);
        sighting.setHeroVillains(heroVillains);

        dao.addSighting(sighting);

        Sighting sighting2 = new Sighting();
        sighting2.setDate(LocalDate.parse("2018-02-02"));
        sighting2.setLocation(location2);
        List<HeroVillain> heroVillains2 = new ArrayList<>();
        heroVillains2.add(heroVillain2);
        heroVillains2.add(heroVillain3);
        sighting2.setHeroVillains(heroVillains2);

        dao.addSighting(sighting2);

        List<HeroVillain> retrievedHVs1 = dao.getHeroVillainsBySightingId(sighting.getId());
        List<HeroVillain> retrievedHVs2 = dao.getHeroVillainsBySightingId(sighting2.getId());

        assertEquals(retrievedHVs1, heroVillains);
        assertEquals(retrievedHVs2, heroVillains2);
        assertNotSame(retrievedHVs1, heroVillains2);
        assertNotSame(retrievedHVs2, heroVillains);
    }

    /**
     * Test of getHeroVillainsByOrganizationId method, of class SuperheroSightingsDao.
     */
    @Test
    public void testGetHVsByOrgId() {
        HeroVillain heroVillain = new HeroVillain();
        heroVillain.setName("TestHero One");
        heroVillain.setDescription("This is a test description for TestHero One.");
        heroVillain.setPower("TestHero One Power");

        dao.addHeroVillain(heroVillain);

        HeroVillain heroVillain2 = new HeroVillain();
        heroVillain2.setName("TestHero Two");
        heroVillain2.setDescription("This is a test description for TestHero Two.");
        heroVillain2.setPower("TestHero Two Power");

        dao.addHeroVillain(heroVillain2);

        HeroVillain heroVillain3 = new HeroVillain();
        heroVillain3.setName("TestHero Three");
        heroVillain3.setDescription("This is a test description for TestHero Three.");
        heroVillain3.setPower("TestHero Three Power");

        dao.addHeroVillain(heroVillain3);

        Organization organization = new Organization();
        organization.setName("TestOrganization One");
        organization.setDescription("This is a test description for TestOrganization One.");
        organization.setAddress("123 Test St.");
        organization.setCity("Testville One");
        organization.setState("MN");
        organization.setPhone("1112223333");
        organization.setEmail("contactus@testorganizationone.com");
        organization.setWebsite("www.testorganizationone.com");
        List<HeroVillain> heroVillains = new ArrayList<>();
        heroVillains.add(heroVillain);
        heroVillains.add(heroVillain3);
        organization.setHeroVillains(heroVillains);

        dao.addOrganization(organization);

        List<HeroVillain> listFromDao = dao.getHeroVillainsByOrganizationId(organization.getId());
        assertEquals(listFromDao, heroVillains);
    }

    /**
     * Test of getAllHeroVillains method, of class SuperheroSightingsDao.
     */
    @Test
    public void testGetAllHVs() {
        HeroVillain heroVillain = new HeroVillain();
        heroVillain.setName("TestHero One");
        heroVillain.setDescription("This is a test description for TestHero One.");
        heroVillain.setPower("TestHero One Power");

        dao.addHeroVillain(heroVillain);

        HeroVillain heroVillain2 = new HeroVillain();
        heroVillain2.setName("TestHero Two");
        heroVillain2.setDescription("This is a test description for TestHero Two.");
        heroVillain2.setPower("TestHero Two Power");

        dao.addHeroVillain(heroVillain2);

        HeroVillain heroVillain3 = new HeroVillain();
        heroVillain3.setName("TestHero Three");
        heroVillain3.setDescription("This is a test description for TestHero Three.");
        heroVillain3.setPower("TestHero Three Power");

        dao.addHeroVillain(heroVillain3);

        List<HeroVillain> addedHVs = new ArrayList<>();
        addedHVs.add(heroVillain);
        addedHVs.add(heroVillain2);
        addedHVs.add(heroVillain3);

        List<HeroVillain> retrievedHVs = dao.getAllHeroVillains();

        assertEquals(retrievedHVs, addedHVs);
    }

    /**
     * Test of addLocation method, of class SuperheroSightingsDao.
     */
    @Test
    public void testAddDeleteGetLocById() {
        Location location = new Location();
        location.setName("TestLocation One");
        location.setDescription("This is a test description for TestLocation One.");
        location.setAddress("123 Test St.");
        location.setCity("Testville One");
        location.setState("MN");
        location.setLatitude(44.986656);
        location.setLongitude(-93.258133);

        dao.addLocation(location);

        HeroVillain heroVillain = new HeroVillain();
        heroVillain.setName("TestHero One");
        heroVillain.setDescription("This is a test description for TestHero One.");
        heroVillain.setPower("TestHero One Power");

        dao.addHeroVillain(heroVillain);

        Sighting sighting = new Sighting();
        sighting.setDate(LocalDate.parse("2018-01-01"));
        sighting.setLocation(location);
        List<HeroVillain> heroVillains = new ArrayList<>();
        heroVillains.add(heroVillain);
        sighting.setHeroVillains(heroVillains);

        dao.addSighting(sighting);

        Location fromDao = dao.getLocationById(location.getId());
        assertEquals(location, fromDao);

        dao.deleteLocation(fromDao.getId());
        assertNull(dao.getLocationById(fromDao.getId()));
    }

    /**
     * Test of updateLocation method, of class SuperheroSightingsDao.
     */
    @Test
    public void testUpdateLocation() {
        Location location = new Location();
        location.setName("TestLocation One");
        location.setDescription("This is a test description for TestLocation One.");
        location.setAddress("123 Test St.");
        location.setCity("Testville One");
        location.setState("MN");
        location.setLatitude(44.986656);
        location.setLongitude(-93.258133);

        dao.addLocation(location);

        Location fromDao = dao.getLocationById(location.getId());
        assertEquals(location, fromDao);

        fromDao.setName("UpdatedLocation One");
        fromDao.setDescription("This is an updated test description for UpdatedLocation One.");
        fromDao.setAddress("123 Updated St.");
        fromDao.setCity("Updateville One");
        fromDao.setState("WI");
        fromDao.setLatitude(47.986656);
        fromDao.setLongitude(-95.258133);

        dao.updateLocation(fromDao);

        Location updatedLoc = dao.getLocationById(fromDao.getId());

        assertNotSame(updatedLoc, location);
        assertEquals(updatedLoc, fromDao);
    }

    /**
     * Test of getLocationBySightingId method, of class SuperheroSightingsDao.
     */
    @Test
    public void testGetLocationBySightingId() {
        Location location = new Location();
        location.setName("TestLocation One");
        location.setDescription("This is a test description for TestLocation One.");
        location.setAddress("123 Test St.");
        location.setCity("Testville One");
        location.setState("MN");
        location.setLatitude(44.986656);
        location.setLongitude(-93.258133);

        dao.addLocation(location);

        Location location2 = new Location();
        location2.setName("TestLocation Two");
        location2.setDescription("This is a test description for TestLocation Two.");
        location2.setAddress("456 Test St.");
        location2.setCity("Testville Two");
        location2.setState("WI");
        location2.setLatitude(48.986656);
        location2.setLongitude(-97.258133);

        dao.addLocation(location2);

        HeroVillain heroVillain = new HeroVillain();
        heroVillain.setName("TestHero One");
        heroVillain.setDescription("This is a test description for TestHero One.");
        heroVillain.setPower("TestHero One Power");

        dao.addHeroVillain(heroVillain);

        HeroVillain heroVillain2 = new HeroVillain();
        heroVillain2.setName("TestHero Two");
        heroVillain2.setDescription("This is a test description for TestHero Two.");
        heroVillain2.setPower("TestHero Two Power");

        dao.addHeroVillain(heroVillain2);

        HeroVillain heroVillain3 = new HeroVillain();
        heroVillain3.setName("TestHero Three");
        heroVillain3.setDescription("This is a test description for TestHero Three.");
        heroVillain3.setPower("TestHero Three Power");

        dao.addHeroVillain(heroVillain3);

        HeroVillain heroVillain4 = new HeroVillain();
        heroVillain4.setName("TestHero Four");
        heroVillain4.setDescription("This is a test description for TestHero Four.");
        heroVillain4.setPower("TestHero Four Power");

        dao.addHeroVillain(heroVillain4);

        Sighting sighting = new Sighting();
        sighting.setDate(LocalDate.parse("2018-01-01"));
        sighting.setLocation(location);
        List<HeroVillain> heroVillains = new ArrayList<>();
        heroVillains.add(heroVillain);
        heroVillains.add(heroVillain4);
        sighting.setHeroVillains(heroVillains);

        dao.addSighting(sighting);

        Sighting sighting2 = new Sighting();
        sighting2.setDate(LocalDate.parse("2018-02-02"));
        sighting2.setLocation(location2);
        List<HeroVillain> heroVillains2 = new ArrayList<>();
        heroVillains2.add(heroVillain2);
        heroVillains2.add(heroVillain3);
        sighting2.setHeroVillains(heroVillains2);

        dao.addSighting(sighting2);

        Location retrievedLoc1 = dao.getLocationBySightingId(sighting.getId());
        Location retrievedLoc2 = dao.getLocationBySightingId(sighting2.getId());

        assertEquals(retrievedLoc1, location);
        assertEquals(retrievedLoc2, location2);
        assertNotSame(retrievedLoc1, location2);
        assertNotSame(retrievedLoc2, location);
    }

    /**
     * Test of getAllLocations method, of class SuperheroSightingsDao.
     */
    @Test
    public void testGetAllLocations() {
        Location location = new Location();
        location.setName("TestLocation One");
        location.setDescription("This is a test description for TestLocation One.");
        location.setAddress("123 Test St.");
        location.setCity("Testville One");
        location.setState("MN");
        location.setLatitude(44.986656);
        location.setLongitude(-93.258133);

        dao.addLocation(location);

        Location location2 = new Location();
        location2.setName("TestLocation Two");
        location2.setDescription("This is a test description for TestLocation Two.");
        location2.setAddress("456 Test St.");
        location2.setCity("Testville Two");
        location2.setState("WI");
        location2.setLatitude(45.986656);
        location2.setLongitude(-95.258133);

        dao.addLocation(location2);

        Location location3 = new Location();
        location3.setName("TestLocation Three");
        location3.setDescription("This is a test description for TestLocation Three.");
        location3.setAddress("890 Test St.");
        location3.setCity("Testville Three");
        location3.setState("MI");
        location3.setLatitude(42.986656);
        location3.setLongitude(-91.258133);

        dao.addLocation(location3);

        List<Location> addedLocs = new ArrayList<>();
        addedLocs.add(location);
        addedLocs.add(location2);
        addedLocs.add(location3);

        List<Location> retrievedLocs = dao.getAllLocations();

        assertEquals(retrievedLocs, addedLocs);
    }

    /**
     * Test of addOrganization method, of class SuperheroSightingsDao.
     */
    @Test
    public void testAddDeleteGetOrgById() {
        HeroVillain heroVillain = new HeroVillain();
        heroVillain.setName("TestHero One");
        heroVillain.setDescription("This is a test description for TestHero One.");
        heroVillain.setPower("TestHero One Power");

        dao.addHeroVillain(heroVillain);

        Organization organization = new Organization();
        organization.setName("TestOrganization One");
        organization.setDescription("This is a test description for TestOrganization One.");
        organization.setAddress("123 Test St.");
        organization.setCity("Testville One");
        organization.setState("MN");
        organization.setPhone("1112223333");
        organization.setEmail("contactus@testorganizationone.com");
        organization.setWebsite("www.testorganizationone.com");
        List<HeroVillain> heroVillains = new ArrayList<>();
        heroVillains.add(heroVillain);
        organization.setHeroVillains(heroVillains);

        dao.addOrganization(organization);

        Organization fromDao = dao.getOrganizationById(organization.getId());
        assertEquals(organization, fromDao);

        dao.deleteOrganization(fromDao.getId());
        assertNull(dao.getOrganizationById(fromDao.getId()));
    }

    /**
     * Test of updateOrganization method, of class SuperheroSightingsDao.
     */
    @Test
    public void testUpdateOrg() {
        HeroVillain heroVillain = new HeroVillain();
        heroVillain.setName("TestHero One");
        heroVillain.setDescription("This is a test description for TestHero One.");
        heroVillain.setPower("TestHero One Power");

        dao.addHeroVillain(heroVillain);

        Organization organization = new Organization();
        organization.setName("TestOrganization One");
        organization.setDescription("This is a test description for TestOrganization One.");
        organization.setAddress("123 Test St.");
        organization.setCity("Testville One");
        organization.setState("MN");
        organization.setPhone("1112223333");
        organization.setEmail("contactus@testorganizationone.com");
        organization.setWebsite("www.testorganizationone.com");
        List<HeroVillain> heroVillains = new ArrayList<>();
        heroVillains.add(heroVillain);
        organization.setHeroVillains(heroVillains);

        dao.addOrganization(organization);

        Organization fromDao = dao.getOrganizationById(organization.getId());
        assertEquals(organization, fromDao);

        fromDao.setName("UpdatedOrganization One");
        fromDao.setDescription("This is an updated test description for UpdatedOrganization One.");
        fromDao.setAddress("123 Updated St.");
        fromDao.setCity("Updateville One");
        fromDao.setState("WI");
        fromDao.setPhone("4445556666");
        fromDao.setEmail("contactus@updatedorganizationone.com");
        fromDao.setWebsite("www.updatedorganizationone.com");

        dao.updateOrganization(fromDao);

        Organization updatedOrg = dao.getOrganizationById(fromDao.getId());
        assertNotSame(updatedOrg, organization);
        assertEquals(updatedOrg, fromDao);
    }

    /**
     * Test of getOrganizationsByHeroVillainId method, of class SuperheroSightingsDao.
     */
    @Test
    public void testGetOrgsByHVId() {
        HeroVillain heroVillain = new HeroVillain();
        heroVillain.setName("TestHero One");
        heroVillain.setDescription("This is a test description for TestHero One.");
        heroVillain.setPower("TestHero One Power");

        dao.addHeroVillain(heroVillain);

        HeroVillain heroVillain2 = new HeroVillain();
        heroVillain2.setName("TestHero Two");
        heroVillain2.setDescription("This is a test description for TestHero Two.");
        heroVillain2.setPower("TestHero Two Power");

        dao.addHeroVillain(heroVillain2);

        Organization organization = new Organization();
        organization.setName("TestOrganization One");
        organization.setDescription("This is a test description for TestOrganization One.");
        organization.setAddress("123 Test St.");
        organization.setCity("Testville One");
        organization.setState("MN");
        organization.setPhone("1112223333");
        organization.setEmail("contactus@testorganizationone.com");
        organization.setWebsite("www.testorganizationone.com");
        List<HeroVillain> heroVillains = new ArrayList<>();
        heroVillains.add(heroVillain);
        heroVillains.add(heroVillain2);
        organization.setHeroVillains(heroVillains);

        dao.addOrganization(organization);

        HeroVillain heroVillain3 = new HeroVillain();
        heroVillain3.setName("TestHero Three");
        heroVillain3.setDescription("This is a test description for TestHero Three.");
        heroVillain3.setPower("TestHero Three Power");

        dao.addHeroVillain(heroVillain3);

        HeroVillain heroVillain4 = new HeroVillain();
        heroVillain4.setName("TestHero Four");
        heroVillain4.setDescription("This is a test description for TestHero Four.");
        heroVillain4.setPower("TestHero Four Power");

        dao.addHeroVillain(heroVillain4);

        Organization organization2 = new Organization();
        organization2.setName("TestOrganization Two");
        organization2.setDescription("This is a test description for TestOrganization Two.");
        organization2.setAddress("456 Test St.");
        organization2.setCity("Testville Two");
        organization2.setState("WI");
        organization2.setPhone("4445556666");
        organization2.setEmail("contactus@testorganizationtwo.com");
        organization2.setWebsite("www.testorganizationtwo.com");
        List<HeroVillain> heroVillains2 = new ArrayList<>();
        heroVillains2.add(heroVillain3);
        heroVillains2.add(heroVillain4);
        organization2.setHeroVillains(heroVillains2);

        dao.addOrganization(organization2);

        List<Organization> retrievedOrg1 = dao.getOrganizationsByHeroVillainId(heroVillain.getId());
        List<Organization> retrievedOrg2 = dao.getOrganizationsByHeroVillainId(heroVillain2.getId());
        List<Organization> retrievedOrg3 = dao.getOrganizationsByHeroVillainId(heroVillain3.getId());
        List<Organization> retrievedOrg4 = dao.getOrganizationsByHeroVillainId(heroVillain4.getId());

        assertEquals(retrievedOrg1, retrievedOrg2);
        assertEquals(retrievedOrg3, retrievedOrg4);
        assertNotSame(retrievedOrg1, retrievedOrg4);
        assertNotSame(retrievedOrg2, retrievedOrg3);
    }

    /**
     * Test of getAllOrganizations method, of class SuperheroSightingsDao.
     */
    @Test
    public void testGetAllOrgs() {
        HeroVillain heroVillain = new HeroVillain();
        heroVillain.setName("TestHero One");
        heroVillain.setDescription("This is a test description for TestHero One.");
        heroVillain.setPower("TestHero One Power");

        dao.addHeroVillain(heroVillain);

        HeroVillain heroVillain2 = new HeroVillain();
        heroVillain2.setName("TestHero Two");
        heroVillain2.setDescription("This is a test description for TestHero Two.");
        heroVillain2.setPower("TestHero Two Power");

        dao.addHeroVillain(heroVillain2);

        Organization organization = new Organization();
        organization.setName("TestOrganization One");
        organization.setDescription("This is a test description for TestOrganization One.");
        organization.setAddress("123 Test St.");
        organization.setCity("Testville One");
        organization.setState("MN");
        organization.setPhone("1112223333");
        organization.setEmail("contactus@testorganizationone.com");
        organization.setWebsite("www.testorganizationone.com");
        List<HeroVillain> heroVillains = new ArrayList<>();
        heroVillains.add(heroVillain);
        heroVillains.add(heroVillain2);
        organization.setHeroVillains(heroVillains);

        dao.addOrganization(organization);

        HeroVillain heroVillain3 = new HeroVillain();
        heroVillain3.setName("TestHero Three");
        heroVillain3.setDescription("This is a test description for TestHero Three.");
        heroVillain3.setPower("TestHero Three Power");

        dao.addHeroVillain(heroVillain3);

        HeroVillain heroVillain4 = new HeroVillain();
        heroVillain4.setName("TestHero Four");
        heroVillain4.setDescription("This is a test description for TestHero Four.");
        heroVillain4.setPower("TestHero Four Power");

        dao.addHeroVillain(heroVillain4);

        Organization organization2 = new Organization();
        organization2.setName("TestOrganization Two");
        organization2.setDescription("This is a test description for TestOrganization Two.");
        organization2.setAddress("456 Test St.");
        organization2.setCity("Testville Two");
        organization2.setState("WI");
        organization2.setPhone("4445556666");
        organization2.setEmail("contactus@testorganizationtwo.com");
        organization2.setWebsite("www.testorganizationtwo.com");
        List<HeroVillain> heroVillains2 = new ArrayList<>();
        heroVillains2.add(heroVillain3);
        heroVillains2.add(heroVillain4);
        organization2.setHeroVillains(heroVillains2);

        dao.addOrganization(organization2);

        Organization organization3 = new Organization();
        organization3.setName("TestOrganization Three");
        organization3.setDescription("This is a test description for TestOrganization Three.");
        organization3.setAddress("789 Test St.");
        organization3.setCity("Testville Three");
        organization3.setState("MI");
        organization3.setPhone("7778889999");
        organization3.setEmail("contactus@testorganizationthree.com");
        organization3.setWebsite("www.testorganizationthree.com");
        List<HeroVillain> heroVillains3 = new ArrayList<>();
        heroVillains3.add(heroVillain);
        heroVillains3.add(heroVillain3);
        organization3.setHeroVillains(heroVillains3);

        dao.addOrganization(organization3);

        List<Organization> addedOrgs = new ArrayList<>();
        addedOrgs.add(organization);
        addedOrgs.add(organization2);
        addedOrgs.add(organization3);

        List<Organization> retrievedOrgs = dao.getAllOrganizations();

        assertEquals(retrievedOrgs, addedOrgs);
    }

    /**
     * Test of addSighting method, of class SuperheroSightingsDao.
     */
    @Test
    public void testAddDeleteGetSightById() {
        Location location = new Location();
        location.setName("TestLocation One");
        location.setDescription("This is a test description for TestLocation One.");
        location.setAddress("123 Test St.");
        location.setCity("Testville One");
        location.setState("MN");
        location.setLatitude(44.986656);
        location.setLongitude(-93.258133);

        dao.addLocation(location);

        HeroVillain heroVillain = new HeroVillain();
        heroVillain.setName("TestHero One");
        heroVillain.setDescription("This is a test description for TestHero One.");
        heroVillain.setPower("TestHero One Power");

        dao.addHeroVillain(heroVillain);

        HeroVillain heroVillain2 = new HeroVillain();
        heroVillain2.setName("TestHero Two");
        heroVillain2.setDescription("This is a test description for TestHero Two.");
        heroVillain2.setPower("TestHero Two Power");

        dao.addHeroVillain(heroVillain2);

        Sighting sighting = new Sighting();
        sighting.setDate(LocalDate.parse("2018-01-01"));
        sighting.setLocation(location);
        List<HeroVillain> heroVillains = new ArrayList<>();
        heroVillains.add(heroVillain);
        heroVillains.add(heroVillain2);
        sighting.setHeroVillains(heroVillains);

        dao.addSighting(sighting);
        Sighting fromDao = dao.getSightingById(sighting.getId());

        assertEquals(fromDao, sighting);

        dao.deleteSighting(fromDao.getId());
        assertNull(dao.getSightingById(fromDao.getId()));
    }

    /**
     * Test of updateSighting method, of class SuperheroSightingsDao.
     */
    @Test
    public void testUpdateSighting() {
        Location location = new Location();
        location.setName("TestLocation One");
        location.setDescription("This is a test description for TestLocation One.");
        location.setAddress("123 Test St.");
        location.setCity("Testville One");
        location.setState("MN");
        location.setLatitude(44.986656);
        location.setLongitude(-93.258133);

        dao.addLocation(location);

        HeroVillain heroVillain = new HeroVillain();
        heroVillain.setName("TestHero One");
        heroVillain.setDescription("This is a test description for TestHero One.");
        heroVillain.setPower("TestHero One Power");

        dao.addHeroVillain(heroVillain);

        HeroVillain heroVillain2 = new HeroVillain();
        heroVillain2.setName("TestHero Two");
        heroVillain2.setDescription("This is a test description for TestHero Two.");
        heroVillain2.setPower("TestHero Two Power");

        dao.addHeroVillain(heroVillain2);

        Sighting sighting = new Sighting();
        sighting.setDate(LocalDate.parse("2018-01-01"));
        sighting.setLocation(location);
        List<HeroVillain> heroVillains = new ArrayList<>();
        heroVillains.add(heroVillain);
        heroVillains.add(heroVillain2);
        sighting.setHeroVillains(heroVillains);

        dao.addSighting(sighting);
        Sighting fromDao = dao.getSightingById(sighting.getId());

        assertEquals(fromDao, sighting);

        Location location2 = new Location();
        location2.setName("TestLocation Two");
        location2.setDescription("This is a test description for TestLocation Two.");
        location2.setAddress("456 Test St.");
        location2.setCity("Testville Two");
        location2.setState("WI");
        location2.setLatitude(48.986656);
        location2.setLongitude(-97.258133);

        dao.addLocation(location2);

        HeroVillain heroVillain3 = new HeroVillain();
        heroVillain3.setName("TestHero Three");
        heroVillain3.setDescription("This is a test description for TestHero Three.");
        heroVillain3.setPower("TestHero Three Power");

        dao.addHeroVillain(heroVillain3);

        HeroVillain heroVillain4 = new HeroVillain();
        heroVillain4.setName("TestHero Four");
        heroVillain4.setDescription("This is a test description for TestHero Four.");
        heroVillain4.setPower("TestHero Four Power");

        dao.addHeroVillain(heroVillain4);

        fromDao.setDate(LocalDate.parse("2018-02-02"));
        fromDao.setLocation(location2);
        List<HeroVillain> heroVillains2 = new ArrayList<>();
        heroVillains2.add(heroVillain3);
        heroVillains2.add(heroVillain4);
        fromDao.setHeroVillains(heroVillains2);

        dao.updateSighting(fromDao);

        Sighting updatedSight = dao.getSightingById(fromDao.getId());
        assertEquals(updatedSight, fromDao);
        assertNotSame(updatedSight, sighting);
    }

    /**
     * Test of getAllSightingsByDate method, of class SuperheroSightingsDao.
     */
    @Test
    public void testGetAllSightingsByDate() {
        Location location = new Location();
        location.setName("TestLocation One");
        location.setDescription("This is a test description for TestLocation One.");
        location.setAddress("123 Test St.");
        location.setCity("Testville One");
        location.setState("MN");
        location.setLatitude(44.986656);
        location.setLongitude(-93.258133);

        dao.addLocation(location);

        Location location2 = new Location();
        location2.setName("TestLocation Two");
        location2.setDescription("This is a test description for TestLocation Two.");
        location2.setAddress("456 Test St.");
        location2.setCity("Testville Two");
        location2.setState("WI");
        location2.setLatitude(48.986656);
        location2.setLongitude(-97.258133);

        dao.addLocation(location2);

        Location location3 = new Location();
        location3.setName("TestLocation Three");
        location3.setDescription("This is a test description for TestLocation Three.");
        location3.setAddress("789 Test St.");
        location3.setCity("Testville Three");
        location3.setState("MI");
        location3.setLatitude(43.986656);
        location3.setLongitude(-91.258133);

        dao.addLocation(location3);

        HeroVillain heroVillain = new HeroVillain();
        heroVillain.setName("TestHero One");
        heroVillain.setDescription("This is a test description for TestHero One.");
        heroVillain.setPower("TestHero One Power");

        dao.addHeroVillain(heroVillain);

        HeroVillain heroVillain2 = new HeroVillain();
        heroVillain2.setName("TestHero Two");
        heroVillain2.setDescription("This is a test description for TestHero Two.");
        heroVillain2.setPower("TestHero Two Power");

        dao.addHeroVillain(heroVillain2);

        HeroVillain heroVillain3 = new HeroVillain();
        heroVillain3.setName("TestHero Three");
        heroVillain3.setDescription("This is a test description for TestHero Three.");
        heroVillain3.setPower("TestHero Three Power");

        dao.addHeroVillain(heroVillain3);

        HeroVillain heroVillain4 = new HeroVillain();
        heroVillain4.setName("TestHero Four");
        heroVillain4.setDescription("This is a test description for TestHero Four.");
        heroVillain4.setPower("TestHero Four Power");

        dao.addHeroVillain(heroVillain4);

        HeroVillain heroVillain5 = new HeroVillain();
        heroVillain5.setName("TestHero Five");
        heroVillain5.setDescription("This is a test description for TestHero Five.");
        heroVillain5.setPower("TestHero Five Power");

        dao.addHeroVillain(heroVillain5);

        HeroVillain heroVillain6 = new HeroVillain();
        heroVillain6.setName("TestHero Six");
        heroVillain6.setDescription("This is a test description for TestHero Six.");
        heroVillain6.setPower("TestHero Six Power");

        dao.addHeroVillain(heroVillain6);

        Sighting sighting = new Sighting();
        sighting.setDate(LocalDate.parse("2018-01-01"));
        sighting.setLocation(location);
        List<HeroVillain> heroVillains = new ArrayList<>();
        heroVillains.add(heroVillain);
        heroVillains.add(heroVillain4);
        sighting.setHeroVillains(heroVillains);

        dao.addSighting(sighting);

        Sighting sighting2 = new Sighting();
        sighting2.setDate(LocalDate.parse("2018-02-02"));
        sighting2.setLocation(location2);
        List<HeroVillain> heroVillains2 = new ArrayList<>();
        heroVillains2.add(heroVillain2);
        heroVillains2.add(heroVillain3);
        sighting2.setHeroVillains(heroVillains2);

        dao.addSighting(sighting2);

        Sighting sighting3 = new Sighting();
        sighting3.setDate(LocalDate.parse("2018-01-01"));
        sighting3.setLocation(location3);
        List<HeroVillain> heroVillains3 = new ArrayList<>();
        heroVillains3.add(heroVillain5);
        heroVillains3.add(heroVillain6);
        sighting3.setHeroVillains(heroVillains3);

        dao.addSighting(sighting3);

        List<Sighting> addedSights1 = new ArrayList<>();
        addedSights1.add(sighting);
        addedSights1.add(sighting3);

        List<Sighting> addedSights2 = new ArrayList<>();
        addedSights2.add(sighting2);

        List<Sighting> retrievedSights1 = dao.getAllSightingsByDate(LocalDate.parse("2018-01-01"));
        List<Sighting> retrievedSights2 = dao.getAllSightingsByDate(LocalDate.parse("2018-02-02"));

        assertEquals(retrievedSights1, addedSights1);
        assertEquals(retrievedSights2, addedSights2);
        assertNotSame(retrievedSights1, addedSights2);
        assertNotSame(retrievedSights2, addedSights1);
    }

    /**
     * Test of getAllSightingsByLocationId method, of class SuperheroSightingsDao.
     */
    @Test
    public void testGetAllSightingsByLocationId() {
        Location location = new Location();
        location.setName("TestLocation One");
        location.setDescription("This is a test description for TestLocation One.");
        location.setAddress("123 Test St.");
        location.setCity("Testville One");
        location.setState("MN");
        location.setLatitude(44.986656);
        location.setLongitude(-93.258133);

        dao.addLocation(location);

        Location location2 = new Location();
        location2.setName("TestLocation Two");
        location2.setDescription("This is a test description for TestLocation Two.");
        location2.setAddress("456 Test St.");
        location2.setCity("Testville Two");
        location2.setState("WI");
        location2.setLatitude(48.986656);
        location2.setLongitude(-97.258133);

        dao.addLocation(location2);

        HeroVillain heroVillain = new HeroVillain();
        heroVillain.setName("TestHero One");
        heroVillain.setDescription("This is a test description for TestHero One.");
        heroVillain.setPower("TestHero One Power");

        dao.addHeroVillain(heroVillain);

        HeroVillain heroVillain2 = new HeroVillain();
        heroVillain2.setName("TestHero Two");
        heroVillain2.setDescription("This is a test description for TestHero Two.");
        heroVillain2.setPower("TestHero Two Power");

        dao.addHeroVillain(heroVillain2);

        HeroVillain heroVillain3 = new HeroVillain();
        heroVillain3.setName("TestHero Three");
        heroVillain3.setDescription("This is a test description for TestHero Three.");
        heroVillain3.setPower("TestHero Three Power");

        dao.addHeroVillain(heroVillain3);

        HeroVillain heroVillain4 = new HeroVillain();
        heroVillain4.setName("TestHero Four");
        heroVillain4.setDescription("This is a test description for TestHero Four.");
        heroVillain4.setPower("TestHero Four Power");

        dao.addHeroVillain(heroVillain4);

        HeroVillain heroVillain5 = new HeroVillain();
        heroVillain5.setName("TestHero Five");
        heroVillain5.setDescription("This is a test description for TestHero Five.");
        heroVillain5.setPower("TestHero Five Power");

        dao.addHeroVillain(heroVillain5);

        HeroVillain heroVillain6 = new HeroVillain();
        heroVillain6.setName("TestHero Six");
        heroVillain6.setDescription("This is a test description for TestHero Six.");
        heroVillain6.setPower("TestHero Six Power");

        dao.addHeroVillain(heroVillain6);

        Sighting sighting = new Sighting();
        sighting.setDate(LocalDate.parse("2018-02-02"));
        sighting.setLocation(location);
        List<HeroVillain> heroVillains = new ArrayList<>();
        heroVillains.add(heroVillain);
        heroVillains.add(heroVillain4);
        sighting.setHeroVillains(heroVillains);

        dao.addSighting(sighting);

        Sighting sighting2 = new Sighting();
        sighting2.setDate(LocalDate.parse("2018-02-02"));
        sighting2.setLocation(location2);
        List<HeroVillain> heroVillains2 = new ArrayList<>();
        heroVillains2.add(heroVillain);
        heroVillains2.add(heroVillain3);
        sighting2.setHeroVillains(heroVillains2);

        dao.addSighting(sighting2);

        Sighting sighting3 = new Sighting();
        sighting3.setDate(LocalDate.parse("2018-01-01"));
        sighting3.setLocation(location);
        List<HeroVillain> heroVillains3 = new ArrayList<>();
        heroVillains3.add(heroVillain3);
        heroVillains3.add(heroVillain4);
        sighting3.setHeroVillains(heroVillains3);

        dao.addSighting(sighting3);

        List<Sighting> addedSights1 = new ArrayList<>();
        addedSights1.add(sighting);
        addedSights1.add(sighting3);

        List<Sighting> addedSights2 = new ArrayList<>();
        addedSights2.add(sighting2);

        List<Sighting> retrievedSights1 = dao.getAllSightingsByLocationId(location.getId());
        List<Sighting> retrievedSights2 = dao.getAllSightingsByLocationId(location2.getId());

        assertEquals(retrievedSights1, addedSights1);
        assertEquals(retrievedSights2, addedSights2);
        assertNotSame(retrievedSights1, addedSights2);
        assertNotSame(retrievedSights2, addedSights1);
    }

    /**
     * Test of getAllSightingsByHeroVillainId method, of class SuperheroSightingsDao.
     */
    @Test
    public void testGetAllSightingsByHeroVillainId() {
        Location location = new Location();
        location.setName("TestLocation One");
        location.setDescription("This is a test description for TestLocation One.");
        location.setAddress("123 Test St.");
        location.setCity("Testville One");
        location.setState("MN");
        location.setLatitude(44.986656);
        location.setLongitude(-93.258133);

        dao.addLocation(location);

        Location location2 = new Location();
        location2.setName("TestLocation Two");
        location2.setDescription("This is a test description for TestLocation Two.");
        location2.setAddress("456 Test St.");
        location2.setCity("Testville Two");
        location2.setState("WI");
        location2.setLatitude(48.986656);
        location2.setLongitude(-97.258133);

        dao.addLocation(location2);

        Location location3 = new Location();
        location3.setName("TestLocation Three");
        location3.setDescription("This is a test description for TestLocation Three.");
        location3.setAddress("789 Test St.");
        location3.setCity("Testville Three");
        location3.setState("MI");
        location3.setLatitude(43.986656);
        location3.setLongitude(-91.258133);

        dao.addLocation(location3);

        HeroVillain heroVillain = new HeroVillain();
        heroVillain.setName("TestHero One");
        heroVillain.setDescription("This is a test description for TestHero One.");
        heroVillain.setPower("TestHero One Power");

        dao.addHeroVillain(heroVillain);

        HeroVillain heroVillain2 = new HeroVillain();
        heroVillain2.setName("TestHero Two");
        heroVillain2.setDescription("This is a test description for TestHero Two.");
        heroVillain2.setPower("TestHero Two Power");

        dao.addHeroVillain(heroVillain2);

        HeroVillain heroVillain3 = new HeroVillain();
        heroVillain3.setName("TestHero Three");
        heroVillain3.setDescription("This is a test description for TestHero Three.");
        heroVillain3.setPower("TestHero Three Power");

        dao.addHeroVillain(heroVillain3);

        HeroVillain heroVillain4 = new HeroVillain();
        heroVillain4.setName("TestHero Four");
        heroVillain4.setDescription("This is a test description for TestHero Four.");
        heroVillain4.setPower("TestHero Four Power");

        dao.addHeroVillain(heroVillain4);

        HeroVillain heroVillain5 = new HeroVillain();
        heroVillain5.setName("TestHero Five");
        heroVillain5.setDescription("This is a test description for TestHero Five.");
        heroVillain5.setPower("TestHero Five Power");

        dao.addHeroVillain(heroVillain5);

        HeroVillain heroVillain6 = new HeroVillain();
        heroVillain6.setName("TestHero Six");
        heroVillain6.setDescription("This is a test description for TestHero Six.");
        heroVillain6.setPower("TestHero Six Power");

        dao.addHeroVillain(heroVillain6);

        Sighting sighting = new Sighting();
        sighting.setDate(LocalDate.parse("2018-01-01"));
        sighting.setLocation(location);
        List<HeroVillain> heroVillains = new ArrayList<>();
        heroVillains.add(heroVillain);
        heroVillains.add(heroVillain4);
        sighting.setHeroVillains(heroVillains);

        dao.addSighting(sighting);

        Sighting sighting2 = new Sighting();
        sighting2.setDate(LocalDate.parse("2018-02-02"));
        sighting2.setLocation(location2);
        List<HeroVillain> heroVillains2 = new ArrayList<>();
        heroVillains2.add(heroVillain);
        heroVillains2.add(heroVillain3);
        sighting2.setHeroVillains(heroVillains2);

        dao.addSighting(sighting2);

        Sighting sighting3 = new Sighting();
        sighting3.setDate(LocalDate.parse("2018-01-01"));
        sighting3.setLocation(location3);
        List<HeroVillain> heroVillains3 = new ArrayList<>();
        heroVillains3.add(heroVillain3);
        heroVillains3.add(heroVillain4);
        sighting3.setHeroVillains(heroVillains3);

        dao.addSighting(sighting3);

        List<Sighting> addedSights1 = new ArrayList<>();
        addedSights1.add(sighting);
        addedSights1.add(sighting2);

        List<Sighting> addedSights2 = new ArrayList<>();
        addedSights2.add(sighting);
        addedSights2.add(sighting3);

        List<Sighting> addedSights3 = new ArrayList<>();
        addedSights3.add(sighting2);
        addedSights3.add(sighting3);

        List<Sighting> retrievedSights1 = dao.getAllSightingsByHeroVillainId(heroVillain.getId());
        List<Sighting> retrievedSights2 = dao.getAllSightingsByHeroVillainId(heroVillain4.getId());
        List<Sighting> retrievedSights3 = dao.getAllSightingsByHeroVillainId(heroVillain3.getId());

        assertEquals(retrievedSights1, addedSights1);
        assertEquals(retrievedSights2, addedSights2);
        assertEquals(retrievedSights3, addedSights3);
        assertNotSame(retrievedSights1, addedSights2);
        assertNotSame(retrievedSights2, addedSights1);
        assertNotSame(retrievedSights1, addedSights3);
        assertNotSame(retrievedSights2, addedSights3);
    }

    /**
     * Test of getAllSightings method, of class SuperheroSightingsDao.
     */
    @Test
    public void testGetAllSightings() {
        Location location = new Location();
        location.setName("TestLocation One");
        location.setDescription("This is a test description for TestLocation One.");
        location.setAddress("123 Test St.");
        location.setCity("Testville One");
        location.setState("MN");
        location.setLatitude(44.986656);
        location.setLongitude(-93.258133);

        dao.addLocation(location);

        Location location2 = new Location();
        location2.setName("TestLocation Two");
        location2.setDescription("This is a test description for TestLocation Two.");
        location2.setAddress("456 Test St.");
        location2.setCity("Testville Two");
        location2.setState("WI");
        location2.setLatitude(48.986656);
        location2.setLongitude(-97.258133);

        dao.addLocation(location2);

        Location location3 = new Location();
        location3.setName("TestLocation Three");
        location3.setDescription("This is a test description for TestLocation Three.");
        location3.setAddress("789 Test St.");
        location3.setCity("Testville Three");
        location3.setState("MI");
        location3.setLatitude(43.986656);
        location3.setLongitude(-91.258133);

        dao.addLocation(location3);

        HeroVillain heroVillain = new HeroVillain();
        heroVillain.setName("TestHero One");
        heroVillain.setDescription("This is a test description for TestHero One.");
        heroVillain.setPower("TestHero One Power");

        dao.addHeroVillain(heroVillain);

        HeroVillain heroVillain2 = new HeroVillain();
        heroVillain2.setName("TestHero Two");
        heroVillain2.setDescription("This is a test description for TestHero Two.");
        heroVillain2.setPower("TestHero Two Power");

        dao.addHeroVillain(heroVillain2);

        HeroVillain heroVillain3 = new HeroVillain();
        heroVillain3.setName("TestHero Three");
        heroVillain3.setDescription("This is a test description for TestHero Three.");
        heroVillain3.setPower("TestHero Three Power");

        dao.addHeroVillain(heroVillain3);

        HeroVillain heroVillain4 = new HeroVillain();
        heroVillain4.setName("TestHero Four");
        heroVillain4.setDescription("This is a test description for TestHero Four.");
        heroVillain4.setPower("TestHero Four Power");

        dao.addHeroVillain(heroVillain4);

        HeroVillain heroVillain5 = new HeroVillain();
        heroVillain5.setName("TestHero Five");
        heroVillain5.setDescription("This is a test description for TestHero Five.");
        heroVillain5.setPower("TestHero Five Power");

        dao.addHeroVillain(heroVillain5);

        HeroVillain heroVillain6 = new HeroVillain();
        heroVillain6.setName("TestHero Six");
        heroVillain6.setDescription("This is a test description for TestHero Six.");
        heroVillain6.setPower("TestHero Six Power");

        dao.addHeroVillain(heroVillain6);

        Sighting sighting = new Sighting();
        sighting.setDate(LocalDate.parse("2018-01-01"));
        sighting.setLocation(location);
        List<HeroVillain> heroVillains = new ArrayList<>();
        heroVillains.add(heroVillain);
        heroVillains.add(heroVillain4);
        sighting.setHeroVillains(heroVillains);

        dao.addSighting(sighting);

        Sighting sighting2 = new Sighting();
        sighting2.setDate(LocalDate.parse("2018-02-02"));
        sighting2.setLocation(location2);
        List<HeroVillain> heroVillains2 = new ArrayList<>();
        heroVillains2.add(heroVillain);
        heroVillains2.add(heroVillain3);
        sighting2.setHeroVillains(heroVillains2);

        dao.addSighting(sighting2);

        Sighting sighting3 = new Sighting();
        sighting3.setDate(LocalDate.parse("2018-01-01"));
        sighting3.setLocation(location3);
        List<HeroVillain> heroVillains3 = new ArrayList<>();
        heroVillains3.add(heroVillain3);
        heroVillains3.add(heroVillain4);
        sighting3.setHeroVillains(heroVillains3);

        dao.addSighting(sighting3);

        List<Sighting> allSights = new ArrayList<>();
        allSights.add(sighting);
        allSights.add(sighting2);
        allSights.add(sighting3);

        List<Sighting> notAllSights = new ArrayList<>();
        notAllSights.add(sighting);
        notAllSights.add(sighting3);

        List<Sighting> notAllSights2 = new ArrayList<>();
        notAllSights2.add(sighting2);
        notAllSights2.add(sighting3);

        List<Sighting> retrievedSights1 = dao.getAllSightings();

        assertEquals(retrievedSights1, allSights);
        assertNotSame(retrievedSights1, notAllSights);
        assertNotSame(retrievedSights1, notAllSights2);
    }

    @Test
    public void testGetLast10Sightings() {
        Location location = new Location();
        location.setName("TestLocation One");
        location.setDescription("This is a test description for TestLocation One.");
        location.setAddress("123 Test St.");
        location.setCity("Testville One");
        location.setState("MN");
        location.setLatitude(44.986656);
        location.setLongitude(-93.258133);

        dao.addLocation(location);

        Location location2 = new Location();
        location2.setName("TestLocation Two");
        location2.setDescription("This is a test description for TestLocation Two.");
        location2.setAddress("456 Test St.");
        location2.setCity("Testville Two");
        location2.setState("WI");
        location2.setLatitude(48.986656);
        location2.setLongitude(-97.258133);

        dao.addLocation(location2);

        Location location3 = new Location();
        location3.setName("TestLocation Three");
        location3.setDescription("This is a test description for TestLocation Three.");
        location3.setAddress("789 Test St.");
        location3.setCity("Testville Three");
        location3.setState("MI");
        location3.setLatitude(43.986656);
        location3.setLongitude(-91.258133);

        dao.addLocation(location3);

        Location location4 = new Location();
        location4.setName("TestLocation Four");
        location4.setDescription("This is a test description for TestLocation Four.");
        location4.setAddress("789 TestFour St.");
        location4.setCity("Testville Four");
        location4.setState("FL");
        location4.setLatitude(53.986656);
        location4.setLongitude(-71.258133);

        dao.addLocation(location4);

        Location location5 = new Location();
        location5.setName("TestLocation Five");
        location5.setDescription("This is a test description for TestLocation Five.");
        location5.setAddress("789 TestFive St.");
        location5.setCity("Testville Five");
        location5.setState("IL");
        location5.setLatitude(43.986656);
        location5.setLongitude(-51.258133);

        dao.addLocation(location5);

        Location location6 = new Location();
        location6.setName("TestLocation Six");
        location6.setDescription("This is a test description for TestLocation Six.");
        location6.setAddress("789 TestSix St.");
        location6.setCity("Testville Six");
        location6.setState("WA");
        location6.setLatitude(51.956656);
        location6.setLongitude(-70.254133);

        dao.addLocation(location6);

        Location location7 = new Location();
        location7.setName("TestLocation Seven");
        location7.setDescription("This is a test description for TestLocation Seven.");
        location7.setAddress("789 TestSeven St.");
        location7.setCity("Testville Seven");
        location7.setState("CA");
        location7.setLatitude(33.186656);
        location7.setLongitude(-41.298133);

        dao.addLocation(location7);

        HeroVillain heroVillain = new HeroVillain();
        heroVillain.setName("TestHero One");
        heroVillain.setDescription("This is a test description for TestHero One.");
        heroVillain.setPower("TestHero One Power");

        dao.addHeroVillain(heroVillain);

        HeroVillain heroVillain2 = new HeroVillain();
        heroVillain2.setName("TestHero Two");
        heroVillain2.setDescription("This is a test description for TestHero Two.");
        heroVillain2.setPower("TestHero Two Power");

        dao.addHeroVillain(heroVillain2);

        HeroVillain heroVillain3 = new HeroVillain();
        heroVillain3.setName("TestHero Three");
        heroVillain3.setDescription("This is a test description for TestHero Three.");
        heroVillain3.setPower("TestHero Three Power");

        dao.addHeroVillain(heroVillain3);

        HeroVillain heroVillain4 = new HeroVillain();
        heroVillain4.setName("TestHero Four");
        heroVillain4.setDescription("This is a test description for TestHero Four.");
        heroVillain4.setPower("TestHero Four Power");

        dao.addHeroVillain(heroVillain4);

        HeroVillain heroVillain5 = new HeroVillain();
        heroVillain5.setName("TestHero Five");
        heroVillain5.setDescription("This is a test description for TestHero Five.");
        heroVillain5.setPower("TestHero Five Power");

        dao.addHeroVillain(heroVillain5);

        HeroVillain heroVillain6 = new HeroVillain();
        heroVillain6.setName("TestHero Six");
        heroVillain6.setDescription("This is a test description for TestHero Six.");
        heroVillain6.setPower("TestHero Six Power");

        dao.addHeroVillain(heroVillain6);

        HeroVillain heroVillain7 = new HeroVillain();
        heroVillain7.setName("TestHero Seven");
        heroVillain7.setDescription("This is a test description for TestHero Seven.");
        heroVillain7.setPower("TestHero Seven Power");

        dao.addHeroVillain(heroVillain7);

        HeroVillain heroVillain8 = new HeroVillain();
        heroVillain8.setName("TestHero Eight");
        heroVillain8.setDescription("This is a test description for TestHero Eight.");
        heroVillain8.setPower("TestHero Eight Power");

        dao.addHeroVillain(heroVillain8);

        Sighting sighting = new Sighting();
        sighting.setDate(LocalDate.parse("2018-01-01"));
        sighting.setLocation(location);
        List<HeroVillain> heroVillains = new ArrayList<>();
        heroVillains.add(heroVillain);
        heroVillains.add(heroVillain2);
        sighting.setHeroVillains(heroVillains);

        dao.addSighting(sighting);

        Sighting sighting2 = new Sighting();
        sighting2.setDate(LocalDate.parse("2018-01-02"));
        sighting2.setLocation(location2);
        List<HeroVillain> heroVillains2 = new ArrayList<>();
        heroVillains2.add(heroVillain2);
        heroVillains2.add(heroVillain3);
        sighting2.setHeroVillains(heroVillains2);

        dao.addSighting(sighting2);

        Sighting sighting3 = new Sighting();
        sighting3.setDate(LocalDate.parse("2018-01-03"));
        sighting3.setLocation(location3);
        List<HeroVillain> heroVillains3 = new ArrayList<>();
        heroVillains3.add(heroVillain3);
        heroVillains3.add(heroVillain4);
        sighting3.setHeroVillains(heroVillains3);

        dao.addSighting(sighting3);

        Sighting sighting4 = new Sighting();
        sighting4.setDate(LocalDate.parse("2018-01-04"));
        sighting4.setLocation(location4);
        List<HeroVillain> heroVillains4 = new ArrayList<>();
        heroVillains4.add(heroVillain5);
        heroVillains4.add(heroVillain6);
        sighting4.setHeroVillains(heroVillains4);

        dao.addSighting(sighting4);

        Sighting sighting5 = new Sighting();
        sighting5.setDate(LocalDate.parse("2018-01-05"));
        sighting5.setLocation(location5);
        List<HeroVillain> heroVillains5 = new ArrayList<>();
        heroVillains5.add(heroVillain7);
        heroVillains5.add(heroVillain8);
        sighting5.setHeroVillains(heroVillains5);

        dao.addSighting(sighting5);

        Sighting sighting6 = new Sighting();
        sighting6.setDate(LocalDate.parse("2018-01-06"));
        sighting6.setLocation(location6);
        List<HeroVillain> heroVillains6 = new ArrayList<>();
        heroVillains6.add(heroVillain);
        heroVillains6.add(heroVillain8);
        sighting6.setHeroVillains(heroVillains6);

        dao.addSighting(sighting6);

        Sighting sighting7 = new Sighting();
        sighting7.setDate(LocalDate.parse("2018-01-07"));
        sighting7.setLocation(location7);
        List<HeroVillain> heroVillains7 = new ArrayList<>();
        heroVillains7.add(heroVillain2);
        heroVillains7.add(heroVillain7);
        sighting7.setHeroVillains(heroVillains7);

        dao.addSighting(sighting7);

        Sighting sighting8 = new Sighting();
        sighting8.setDate(LocalDate.parse("2018-01-08"));
        sighting8.setLocation(location);
        sighting8.setHeroVillains(heroVillains7);

        dao.addSighting(sighting8);

        Sighting sighting9 = new Sighting();
        sighting9.setDate(LocalDate.parse("2018-01-09"));
        sighting9.setLocation(location2);
        sighting9.setHeroVillains(heroVillains6);

        dao.addSighting(sighting9);

        Sighting sighting10 = new Sighting();
        sighting10.setDate(LocalDate.parse("2018-01-10"));
        sighting10.setLocation(location3);
        sighting10.setHeroVillains(heroVillains5);

        dao.addSighting(sighting10);

        Sighting sighting11 = new Sighting();
        sighting11.setDate(LocalDate.parse("2018-01-11"));
        sighting11.setLocation(location4);
        sighting11.setHeroVillains(heroVillains4);

        dao.addSighting(sighting11);

        Sighting sighting12 = new Sighting();
        sighting12.setDate(LocalDate.parse("2018-01-12"));
        sighting12.setLocation(location5);
        sighting12.setHeroVillains(heroVillains3);

        dao.addSighting(sighting12);

        List<Sighting> lastTenSights = new ArrayList<>();
        lastTenSights.add(sighting12);
        lastTenSights.add(sighting11);
        lastTenSights.add(sighting10);
        lastTenSights.add(sighting9);
        lastTenSights.add(sighting8);
        lastTenSights.add(sighting7);
        lastTenSights.add(sighting6);
        lastTenSights.add(sighting5);
        lastTenSights.add(sighting4);
        lastTenSights.add(sighting3);

        List<Sighting> lastTwelveSights = new ArrayList<>();
        lastTwelveSights.add(sighting12);
        lastTwelveSights.add(sighting11);
        lastTwelveSights.add(sighting10);
        lastTwelveSights.add(sighting9);
        lastTwelveSights.add(sighting8);
        lastTwelveSights.add(sighting7);
        lastTwelveSights.add(sighting6);
        lastTwelveSights.add(sighting5);
        lastTwelveSights.add(sighting4);
        lastTwelveSights.add(sighting3);
        lastTwelveSights.add(sighting2);
        lastTwelveSights.add(sighting);

        List<Sighting> firstTenSights = new ArrayList<>();
        firstTenSights.add(sighting10);
        firstTenSights.add(sighting9);
        firstTenSights.add(sighting8);
        firstTenSights.add(sighting7);
        firstTenSights.add(sighting6);
        firstTenSights.add(sighting5);
        firstTenSights.add(sighting4);
        firstTenSights.add(sighting3);
        firstTenSights.add(sighting2);
        firstTenSights.add(sighting);

        List<Sighting> retrievedLastTen = dao.getLastTenSightings();

        assertEquals(retrievedLastTen, lastTenSights);
        assertNotSame(retrievedLastTen, lastTwelveSights);
        assertNotSame(retrievedLastTen, firstTenSights);
    }

}
