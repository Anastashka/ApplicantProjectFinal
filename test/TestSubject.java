import junit.framework.Assert;
import org.junit.Test;
import org.sourceit.db.ApplicantDBProvider;
import org.sourceit.entities.Subject;

import java.util.List;

/**
 * Created by Anastasia on 19.09.2015.
 */
public class TestSubject {
    ApplicantDBProvider provider = ApplicantDBProvider.INSTANCE;

    @Test
    public void testGetSubjectsNotNull(){
        List<Subject> subjects = null;
        try{
            subjects = ApplicantDBProvider.INSTANCE.getSubjects();
        }catch (Exception e){
            e.printStackTrace();
        }
        Assert.assertNotNull(subjects);
    }

    @Test
    public void testGetSubjectTrue(){
        Subject subject = null;
        try{
            subject = ApplicantDBProvider.INSTANCE.getSubject(6);
        }catch (Exception e){
            e.printStackTrace();
        }

        Assert.assertNotNull(subject);
    }

    @Test
    public void testGetSubjectFalse(){
        Subject subject = null;
        try{
            subject = ApplicantDBProvider.INSTANCE.getSubject(100);
        }catch (Exception e){
            e.printStackTrace();
        }

        Assert.assertNull(subject);
    }

    @Test
    public void testSaveSubjectIsSave() throws Exception {
        Subject subject = new Subject();
        subject.setSubjectName("History");

        ApplicantDBProvider.INSTANCE.saveSubject(subject);
    }


    @Test
    public void testDeleteSubjectIsDelete() throws Exception {
        ApplicantDBProvider.INSTANCE.deleteSubject(30);
    }

    @Test
    public  void  testSaveSubjectIsEdit() throws Exception {
        Subject subject = ApplicantDBProvider.INSTANCE.getSubject(7);
        ApplicantDBProvider.INSTANCE.saveSubject(subject);
    }
}
