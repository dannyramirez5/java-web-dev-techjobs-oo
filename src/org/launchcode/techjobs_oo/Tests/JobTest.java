package org.launchcode.techjobs_oo.Tests;
import org.junit.Test;
import org.launchcode.techjobs_oo.*;

import static org.junit.Assert.*;


public class JobTest {

    @Test
    public void testSettingJobId(){
        Job firstJob = new Job();
        Job secondJob = new Job();
        assertEquals((firstJob.getId()+1), secondJob.getId());
    }

    @Test
    public void testJobConstructorSetsAllFields(){
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
    public void testJobsForEquality(){
        Job fourthJob = new Job("Data Analyst", new Employer("Optum"), new Location("St. Petersburg"), new PositionType("Medical Economics"), new CoreCompetency("SQL"));
        Job fifthJob = new Job("Data Analyst", new Employer("Optum"), new Location("St. Petersburg"), new PositionType("Medical Economics"), new CoreCompetency("SQL"));

        assertFalse(fourthJob.equals(fifthJob));

    }
}
