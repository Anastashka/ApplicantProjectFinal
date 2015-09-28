import junit.framework.Assert;
import org.junit.Test;
import org.sourceit.db.ApplicantDBProvider;
import org.sourceit.entities.Applicant;
import org.sourceit.entities.Profession;

import java.util.List;

/**
 * Created by Anastasia on 19.09.2015.
 */
public class TestProfession {
    ApplicantDBProvider provider = ApplicantDBProvider.INSTANCE;

    @Test
    public void testGetProfessionsNotNull(){
        List<Profession> professions = null;
        try{
            professions = ApplicantDBProvider.INSTANCE.getProfessions();
        }catch (Exception e){
            e.printStackTrace();
        }
        Assert.assertNotNull(professions);
    }

    @Test
    public void testGetProfessionTrue(){
        Profession profession = null;
        try{
            profession = ApplicantDBProvider.INSTANCE.getProfession(3);
        }catch (Exception e){
            e.printStackTrace();
        }

        Assert.assertNotNull(profession);
    }

    @Test
    public void testGetApplicantFalse(){
        Profession profession = null;
        try{
            profession = ApplicantDBProvider.INSTANCE.getProfession(40);
        }catch (Exception e){
            e.printStackTrace();
        }

        Assert.assertNull(profession);
    }

    @Test
    public void testSaveProfessionIsSave()    {
        Profession profession = new Profession();
        profession.setProfessionName("NameProf");
        //profession.setId(2);
        try{
            ApplicantDBProvider.INSTANCE.saveProfession(profession);
        }catch (Exception e){
            e.printStackTrace();
        }


    }

    @Test
    public void testDeleteProfessionIsDelete() throws Exception {
        ApplicantDBProvider.INSTANCE.deleteProfession(30);
    }

    @Test
    public  void  testSaveApplicantIsEdit() throws Exception {
        Profession profession = ApplicantDBProvider.INSTANCE.getProfession(3);
        ApplicantDBProvider.INSTANCE.saveProfession(profession);
    }
}
