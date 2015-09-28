import junit.framework.Assert;
import org.junit.Test;
import org.sourceit.db.ApplicantDBProvider;
import org.sourceit.entities.SpecialitySubject;
import org.sourceit.entities.Subject;

import java.util.List;

/**
 * Created by Anastasia on 19.09.2015.
 */
public class TestSpecialitySubject {
    ApplicantDBProvider provider = ApplicantDBProvider.INSTANCE;

//    @Test
//    public void testGetSpecialitySubjectsNotNull(){
//        List<SpecialitySubject> specialitySubjects = null;
//        try{
//            specialitySubjects = ApplicantDBProvider.INSTANCE.getSpecialitySubjects();
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//        Assert.assertNotNull(specialitySubjects);
//    }

//    @Test
//    public void testGetSpecialitySubjectTrue(){
//        SpecialitySubject specialitySubject = null;
//        try{
//            specialitySubject = ApplicantDBProvider.INSTANCE.getSpecialitySubject(10);
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//
//        Assert.assertNotNull(specialitySubject);
//    }

//    @Test
//    public void testGetSpecialitySubjectFalse(){
//        SpecialitySubject specialitySubject = null;
//        try{
//            specialitySubject = ApplicantDBProvider.INSTANCE.getSpecialitySubject(100);
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//
//        Assert.assertNull(specialitySubject);
//    }

//    @Test
//    public void testSaveSpecialitySubjectIsSave() throws Exception {
//        SpecialitySubject specialitySubject = new SpecialitySubject();
//        specialitySubject.setSubjectId(1);
//        specialitySubject.setProfessionSubject(1);
//
//        ApplicantDBProvider.INSTANCE.saveSpecialitySubject(specialitySubject);
//
//    }

//
//    @Test
//    public void testDeleteSpecialitySubjectIsDelete() throws Exception {
//        ApplicantDBProvider.INSTANCE.deleteSpecialitySubject(30);
//    }

//    @Test
//    public  void  testSaveApplicantIsEdit() throws Exception {
//        SpecialitySubject subject = ApplicantDBProvider.INSTANCE.getSpecialitySubject(19);
//        try{
//            ApplicantDBProvider.INSTANCE.saveSpecialitySubject(subject);
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//
//    }
}
