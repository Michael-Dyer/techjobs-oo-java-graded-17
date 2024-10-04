package org.launchcode.techjobs.oo;



import org.junit.Test;

import static org.junit.Assert.*;

public class JobTest {
    //TODO: Create your unit tests here

    Job testJob1;
    Job testJob2;


    @Test
    public void testSettingJobId(){
        testJob1 = new Job();
        testJob2 = new Job();


        assertNotEquals(testJob1,testJob2);
    }

    @Test
    public void testJobConstructorSetsAllFields(){
        testJob1 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));

        assertTrue(testJob1.getName() instanceof String);
        assertTrue(testJob1.getEmployer() instanceof Employer);
        assertTrue(testJob1.getLocation() instanceof Location);
        assertTrue(testJob1.getPositionType() instanceof PositionType);
        assertTrue(testJob1.getCoreCompetency() instanceof CoreCompetency);

        assertEquals(testJob1.getName(), "Product tester");
        assertEquals(testJob1.getEmployer().getValue() , "ACME");
        assertEquals(testJob1.getLocation().getValue() , "Desert");
        assertEquals(testJob1.getPositionType().getValue() , "Quality control");
        assertEquals(testJob1.getCoreCompetency().getValue() , "Persistence");
    }

    @Test
    public void testJobsForEquality(){

        testJob1 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        testJob2 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));

        assertFalse(testJob1.equals(testJob2));
    }

    @Test
    public void testToStringStartsAndEndsWithNewLine(){
        testJob1 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));

        assertEquals(testJob1.toString().charAt(0), '\n');
        assertEquals(testJob1.toString().charAt(testJob1.toString().length() - 1), '\n');

    }

    @Test
    public void testToStringContainsCorrectLabelsAndData(){
        testJob1 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));

        assertEquals(testJob1.toString(), "\nID: " + testJob1.getId() + "\nName: Product tester\nEmployer: ACME\nLocation: Desert\nPosition Type: Quality control\nCore Competency: Persistence\n");

    }

    @Test
    public void testToStringHandlesEmptyField(){
        testJob1 = new Job("Product tester", new Employer(""), new Location(""), new PositionType(""), new CoreCompetency(""));
        testJob2 = new Job("", new Employer(""), new Location(""), new PositionType(""), new CoreCompetency("Persistence"));

        assertEquals(testJob1.toString(), "\nID: " + testJob1.getId() + "\nName: Product tester\nEmployer: Data not available\nLocation: Data not available\nPosition Type: Data not available\nCore Competency: Data not available\n");
        assertEquals(testJob2.toString(), "\nID: " + testJob2.getId() + "\nName: Data not available\nEmployer: Data not available\nLocation: Data not available\nPosition Type: Data not available\nCore Competency: Persistence\n");
    }

    @Test
    public void testToStringHandlesAllEmptyFields(){
        testJob1 = new Job("", new Employer(""), new Location(""), new PositionType(""), new CoreCompetency(""));
        assertEquals(testJob1.toString(),"OOPS! This job does not seem to exist." );
    }

}
