package org.launchcode.techjobs_oo.Tests;
import org.junit.Test;
import org.launchcode.techjobs_oo.*;

import static org.junit.Assert.*;


public class JobTest {

    @Test
    public void testSettingJobId() {
        Job firstJob = new Job();
        Job secondJob = new Job();
        assertEquals((firstJob.getId() + 1), secondJob.getId());
    }

    @Test
    public void testJobConstructorSetsAllFields() {
        Job thirdJob = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality Control"), new CoreCompetency("Persistence"));
        assertEquals(thirdJob.getName(), "Product tester");

        assertTrue(thirdJob.getEmployer() instanceof Employer);
        assertEquals(thirdJob.getEmployer().getValue(), "ACME");

        assertTrue(thirdJob.getLocation() instanceof Location);
        assertEquals(thirdJob.getLocation().getValue(), "Desert");

        assertTrue(thirdJob.getPositionType() instanceof PositionType);
        assertEquals(thirdJob.getPositionType().getValue(), "Quality Control");

        assertTrue(thirdJob.getCoreCompetency() instanceof CoreCompetency);
        assertEquals(thirdJob.getCoreCompetency().getValue(), "Persistence");
    }

    @Test
    public void testJobsForEquality() {
        Job fourthJob = new Job("Data Analyst", new Employer("Optum"), new Location("St. Petersburg"), new PositionType("Medical Economics"), new CoreCompetency("SQL"));
        Job fifthJob = new Job("Data Analyst", new Employer("Optum"), new Location("St. Petersburg"), new PositionType("Medical Economics"), new CoreCompetency("SQL"));
        assertFalse(fourthJob.equals(fifthJob));
    }

    @Test
    public void testingTheToStringSpacing() {
        Job sixthJob = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality Control"), new CoreCompetency("Persistence"));
        Object[] lines = sixthJob.toString().lines().toArray();
        lines[0] = "";
        lines[lines.length - 1] = "";
    }

    @Test
    public void testingTheToStringFieldLabels() {
        Job seventhJob = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality Control"), new CoreCompetency("Persistence"));
        Object[] lines = seventhJob.toString().lines().toArray();
//        System.out.println(seventhJob);
        assertTrue(lines[1].toString().contains("ID: "));
        assertTrue(lines[2].toString().contains("Name: "));
        assertTrue(lines[3].toString().contains("Employer: "));
        assertTrue(lines[4].toString().contains("Location: "));
        assertTrue(lines[5].toString().contains("Position Type: "));
        assertTrue(lines[6].toString().contains("Core Competency: "));

        assertTrue(lines[1].toString().length() > 4);
        assertTrue(lines[2].toString().length() > 6);
        assertTrue(lines[3].toString().length() > 10);
        assertTrue(lines[4].toString().length() > 10);
        assertTrue(lines[5].toString().length() > 15);
        assertTrue(lines[6].toString().length() > 17);
    }

    @Test
    public void testingTheToStringMissingFieldData() {
        Job eighthJob = new Job("Product tester", new Employer(""), new Location("Desert"), new PositionType("Quality Control"), new CoreCompetency("Persistence"));
        Object[] lines = eighthJob.toString().lines().toArray();
        assertEquals(lines[3],"Employer: Data not available");
//        System.out.println(eighthJob);
    }

    @Test
    public void tests() {
        Job seventhJob = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality Control"), new CoreCompetency("Persistence"));


        System.out.println(seventhJob);
    }
}