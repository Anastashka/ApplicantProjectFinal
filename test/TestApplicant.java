import junit.framework.Assert;
import org.junit.Test;
import org.sourceit.db.ApplicantDBProvider;
import org.sourceit.entities.Applicant;

import java.util.List;

/**
 * Created by Anastasia on 19.09.2015.
 */
public class TestApplicant {
     ApplicantDBProvider provider = ApplicantDBProvider.INSTANCE;

    @Test
    public void testGetApplicantsNotNull(){
        List<Applicant> applicants = null;
        try{
            applicants = ApplicantDBProvider.INSTANCE.getApplicants();
        }catch (Exception e){
            e.printStackTrace();
        }
        Assert.assertNotNull(applicants);
    }

    @Test
    public void testGetApplicantTrue(){
        Applicant applicant = null;
        try{
            applicant = ApplicantDBProvider.INSTANCE.getApplicant(6);
        }catch (Exception e){
            e.printStackTrace();
        }

        Assert.assertNotNull(applicant);
    }

    @Test
    public void testGetApplicantFalse(){
        Applicant applicant = null;
        try{
            applicant = ApplicantDBProvider.INSTANCE.getApplicant(100);
        }catch (Exception e){
            e.printStackTrace();
        }

        Assert.assertNull(applicant);
    }

    @Test
    public void testSaveApplicantIsSave() throws Exception {
        Applicant applicant = new Applicant();
        //applicant.setId(0);
        applicant.setProfessionId(2);
        applicant.setFirstName("Bukashka");
        applicant.setLastName("Bukashkovna");
        applicant.setEntranceYear(2006);

        ApplicantDBProvider.INSTANCE.saveApplicant(applicant);
    }


    @Test
    public void testDeleteApplicantIsDelete() throws Exception {
        ApplicantDBProvider.INSTANCE.deleteApplicant(30);
    }

    @Test
    public  void  testSaveApplicantIsEdit() throws Exception {
        Applicant applicant = ApplicantDBProvider.INSTANCE.getApplicant(4);
        ApplicantDBProvider.INSTANCE.saveApplicant(applicant);
    }
}
