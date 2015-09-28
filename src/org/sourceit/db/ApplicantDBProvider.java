package org.sourceit.db;

import org.sourceit.entities.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * You must finish implementation of this class.
 * Methods:
 * -- getApplicant
 * -- getApplicants
 * -- saveApplicant
 * -- deleteApplicant
 * <p>
 * TODO: And your task is add similar methods for Subject, SpecialitySubject, ApplicantResult
 */
public enum ApplicantDBProvider {

    INSTANCE;

    private Connection connection;

    private ApplicantDBProvider() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_applicant", "root", "12231990");
        } catch (ClassNotFoundException | SQLException e) {
            System.err.println("Class not found: com.mysql.jdbc.Driver " + e);
            throw new RuntimeException("Class not found: com.mysql.jdbc.Driver");
        }
    }
    //applicant
    public Applicant getApplicant(long applicantId) throws Exception {

        PreparedStatement preparedStatement = null;
        Applicant applicant = null;
        try {
            //preparedStatement = connection.prepareStatement("SELECT * FROM applicant WHERE applicant_id=?");
            preparedStatement = connection.prepareStatement("SELECT * FROM applicant LEFT JOIN profession ON applicant.profession_id = profession.profession_id WHERE applicant_id=?");
            preparedStatement.setInt(1, (int) applicantId);

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                applicant = new Applicant();
                applicant.setId(resultSet.getInt("applicant_id"));
                applicant.setEntranceYear(resultSet.getInt("entrance_year"));
                applicant.setFirstName(resultSet.getString("first_name"));
                applicant.setLastName(resultSet.getString("last_name"));
                applicant.setProfessionName(resultSet.getString("profession_name"));
                applicant.setProfessionId(resultSet.getInt("profession_id"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (preparedStatement != null) {
                preparedStatement.close();
            }
        }

        return applicant;

       //return null;
    }

    public List<Applicant> getApplicants() throws Exception {

        Statement statement = null;
        List<Applicant> applicants = new ArrayList<>();

        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM applicant LEFT JOIN profession ON applicant.profession_id = profession.profession_id");
            Applicant applicant = null;
            while (resultSet.next()) {
                applicant = new Applicant();
                applicant.setEntranceYear(resultSet.getInt("entrance_year"));
                applicant.setFirstName(resultSet.getString("first_name"));
                applicant.setLastName(resultSet.getString("last_name"));
                applicant.setProfessionId(resultSet.getInt("profession_id"));
                applicant.setProfessionName(resultSet.getString("profession_name"));
                applicant.setId(resultSet.getInt("applicant_id"));
                applicants.add(applicant);
            }
        } catch (SQLException e) {
            throw new Exception(e);
        }

        return applicants;

        }

    public void saveApplicant(Applicant applicant) throws Exception {
        PreparedStatement preparedStatement = null;

        try {
            if (applicant.getId() > 0) {
                preparedStatement = connection.prepareStatement(
                        "UPDATE applicant SET last_name=?,first_name=?,entrance_year=?,profession_id=? WHERE applicant_id=?");
                preparedStatement.setString(2, applicant.getFirstName());
                preparedStatement.setString(1, applicant.getLastName());
                preparedStatement.setInt(3, applicant.getEntranceYear());
                preparedStatement.setLong(4, applicant.getProfessionId());
                preparedStatement.setInt(5, (int) applicant.getId());
            } else {
                preparedStatement = connection.prepareStatement("" +
                        "INSERT INTO applicant (last_name,first_name,entrance_year, profession_id) VALUES (?, ?, ?, ?) ");
                preparedStatement.setString(2, applicant.getFirstName());
                preparedStatement.setString(1, applicant.getLastName());
                preparedStatement.setInt(3, applicant.getEntranceYear());
                preparedStatement.setLong(4, applicant.getProfessionId());
            }
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new Exception(e);
        } finally {
            if (preparedStatement != null) {
                preparedStatement.close();
            }
        }
    }

    public void deleteApplicant(long applicantId) throws Exception {
        PreparedStatement preparedStatement = null;

        try {
            preparedStatement = connection.prepareStatement("DELETE FROM applicant WHERE applicant_id=?");

            preparedStatement.setInt(1, (int) applicantId);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new Exception(e);
        } finally {
            if (preparedStatement != null) {
                preparedStatement.close();
            }
        }
    }


    //profession
    public Profession getProfession(long professionId) throws Exception {
        PreparedStatement preparedStatement = null;
        Profession profession = null;
        try {
            preparedStatement = connection.prepareStatement("SELECT * FROM profession WHERE profession_id=?");
            preparedStatement.setInt(1, (int) professionId);

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                profession = new Profession();
                profession.setId(resultSet.getInt("profession_id"));
                profession.setProfessionName(resultSet.getString("profession_name"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (preparedStatement != null) {
                preparedStatement.close();
            }
        }

        return profession;
    }

    public List<Profession> getProfessions() throws Exception {
        Statement statement = null;

        List<Profession> professions = new ArrayList<>();
        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM profession");
            Profession profession = null;
            while (resultSet.next()) {
                profession = new Profession();
                profession.setId(resultSet.getInt("profession_id"));
                profession.setProfessionName(resultSet.getString("profession_name"));
                professions.add(profession);
            }

        } catch (SQLException e) {
            throw new Exception(e);
        } finally {
            if (statement != null) {
                statement.close();
            }
        }

        return professions;
    }

    public void saveProfession(Profession profession) throws Exception {
        PreparedStatement preparedStatement = null;

        try {
            if (profession.getId() == -1) {
                preparedStatement = connection.prepareStatement("INSERT INTO profession (profession_name) VALUES (?) ");

                preparedStatement.setString(1, profession.getProfessionName());
            } else {
                preparedStatement = connection.prepareStatement("UPDATE profession SET profession_name=? WHERE profession_id=?");

                preparedStatement.setString(1, profession.getProfessionName());
                preparedStatement.setInt(2, (int) profession.getId());
            }
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new Exception(e);
        } finally {
            if (preparedStatement != null) {
                preparedStatement.close();
            }
        }

    }

    public void deleteProfession(long professionId) throws Exception {
        PreparedStatement preparedStatement = null;

        try {
            preparedStatement = connection.prepareStatement("DELETE FROM profession WHERE profession_id=?");

            preparedStatement.setInt(1, (int) professionId);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new Exception(e);
        } finally {
            if (preparedStatement != null) {
                preparedStatement.close();
            }
        }
    }


    //speciality subject
    public SpecialitySubject getSpecialitySubject(long specialitySubjectId) throws Exception{
        PreparedStatement preparedStatement = null;
        SpecialitySubject specialitySubject = null;
        try {
            preparedStatement = connection.prepareStatement("SELECT ss. *, p.name, s.name FROM speciality_subject AS ss " +
                    "LEFT JOIN profession AS p ON ss.profession_id = p.profession_id " +
                    "LEFT JOIN subject AS s ON ss.subject_id = s.subject_id WHERE ss.id=?" );

            preparedStatement.setInt(1, (int) specialitySubjectId);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                specialitySubject = new SpecialitySubject();
                specialitySubject.setId(resultSet.getInt("sp_sb_id"));
                specialitySubject.setProfessionSubject(resultSet.getInt("profession_id"));
                specialitySubject.setProfessionName(resultSet.getString("profession_name"));
                specialitySubject.setSubjectName(resultSet.getString("subject_name"));
                specialitySubject.setSubjectId(resultSet.getInt("subject_id"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (preparedStatement != null) {
                preparedStatement.close();
            }
        }

        return specialitySubject;
        //return null;
    }

    public List<SpecialitySubject> getSpecialitySubjects() throws Exception{
        Statement statement = null;
        List<SpecialitySubject> specialitySubjects = new ArrayList<>();

        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM speciality_subject LEFT JOIN profession ON speciality_subject.profession_id = profession.profession_id " +
                    "LEFT JOIN subject ON speciality_subject.subject_id = subject.subject_id");
            SpecialitySubject specialitySubject = null;
            while (resultSet.next()) {
                specialitySubject = new SpecialitySubject();
                //specialitySubject.setProfessionSubject(resultSet.getInt("profession_id"));
                specialitySubject.setProfessionName(resultSet.getString("profession_name"));
                specialitySubject.setSubjectName(resultSet.getString("subject_name"));
                //specialitySubject.setSubjectId(resultSet.getInt("subject_id"));
                specialitySubject.setId(resultSet.getInt("sp_sb_id"));
                specialitySubjects.add(specialitySubject);
            }
        } catch (SQLException e) {
            throw new Exception(e);
        }

        return specialitySubjects;

    }

    public void saveSpecialitySubject(SpecialitySubject specialitySubject) throws Exception{
        PreparedStatement preparedStatement = null;
        try {
            if (specialitySubject.getId() > 0) {
                preparedStatement = connection.prepareStatement(
                        "UPDATE speciality_subject SET profession_id=?,subject_id=? WHERE sp_sb_id=?");
                preparedStatement.setLong(1, specialitySubject.getProfessionSubject());
                preparedStatement.setLong(2, specialitySubject.getSubjectId());
                preparedStatement.setInt(3, (int) specialitySubject.getId());
            } else {
                preparedStatement = connection.prepareStatement("" +
                        "INSERT INTO speciality_subject (profession_id,subject_id) VALUES (?, ?) ");
                preparedStatement.setLong(1, specialitySubject.getProfessionSubject());
                preparedStatement.setLong(2, specialitySubject.getSubjectId());
            }
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new Exception(e);
        } finally {
            if (preparedStatement != null) {
                preparedStatement.close();
            }
        }
    }

    public void deleteSpecialitySubject(long specialitySubjectId) throws Exception{
        PreparedStatement preparedStatement = null;

        try {
            preparedStatement = connection.prepareStatement("DELETE FROM speciality_subject WHERE sp_sb_id=?");

            preparedStatement.setInt(1, (int) specialitySubjectId);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new Exception(e);
        } finally {
            if (preparedStatement != null) {
                preparedStatement.close();
            }
        }
    }


    // subject
    public Subject getSubject(long subjectId) throws Exception {
        PreparedStatement preparedStatement = null;
        Subject subject = null;
        try {
            preparedStatement = connection.prepareStatement("SELECT * FROM subject WHERE subject_id=?");
            preparedStatement.setInt(1, (int) subjectId);

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                subject = new Subject();
                subject.setId(resultSet.getInt("subject_id"));
                subject.setSubjectName(resultSet.getString("subject_name"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (preparedStatement != null) {
                preparedStatement.close();
            }
        }

        return subject;
    }

    public List<Subject> getSubjects() throws Exception {
        Statement statement = null;

        List<Subject> subjects = new ArrayList<>();
        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM subject");
            Subject subject = null;
            while (resultSet.next()) {
                subject = new Subject();
                subject.setId(resultSet.getInt("subject_id"));
                subject.setSubjectName(resultSet.getString("subject_name"));
                subjects.add(subject);
            }

        } catch (SQLException e) {
            throw new Exception(e);
        } finally {
            if (statement != null) {
                statement.close();
            }
        }

        return subjects;
    }

    public void saveSubject(Subject subject) throws Exception {
        PreparedStatement preparedStatement = null;

        try {
            if (subject.getId() > 0) {

                preparedStatement = connection.prepareStatement("UPDATE subject SET subject_name=? WHERE subject_id=?");
                preparedStatement.setString(1, subject.getSubjectName());
                preparedStatement.setInt(2, (int) subject.getId());

            } else {
                preparedStatement = connection.prepareStatement("INSERT INTO subject (subject_name) VALUES (?) ");
                preparedStatement.setString(1, subject.getSubjectName());
            }
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new Exception(e);
        } finally {
            if (preparedStatement != null) {
                preparedStatement.close();
            }
        }

    }

    public void deleteSubject(long subjectId) throws Exception {
        PreparedStatement preparedStatement = null;

        try {
            preparedStatement = connection.prepareStatement("DELETE FROM subject WHERE subject_id=?");

            preparedStatement.setInt(1, (int) subjectId);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new Exception(e);
        } finally {
            if (preparedStatement != null) {
                preparedStatement.close();
            }
        }
    }


    //applicant result
    public ApplicantResult getApplicantResult(long applicantResultId) throws Exception {

        PreparedStatement preparedStatement = null;
        ApplicantResult applicantResult = null;
        try {
            preparedStatement = connection.prepareStatement("SELECT*FROM applicant_result LEFT JOIN applicant ON applicant_result.applicant_id = applicant.applicant_id " +
                    "LEFT JOIN subject ON applicant_result.subject_id = subject.subject_id" +
                    " WHERE applicant_result_id=?");
            preparedStatement.setInt(1, (int) applicantResultId);

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                applicantResult = new ApplicantResult();
                applicantResult.setId(resultSet.getInt("applicant_result_id"));
                applicantResult.setSubjectName(resultSet.getString("subject_name"));
                applicantResult.setApplicantName(resultSet.getString("applicant_name"));
               // applicantResult.setApplicantId(resultSet.getInt("applicant_id"));
                applicantResult.setMark(resultSet.getInt("mark"));
               // applicantResult.setSubjectId(resultSet.getInt("subject_id"));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (preparedStatement != null) {
                preparedStatement.close();
            }
        }

        return applicantResult;

        //return null;
    }

    public List<ApplicantResult> getApplicantResults() throws Exception {

        Statement statement = null;
        List<ApplicantResult> applicantResults = new ArrayList<>();

        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT*FROM applicant_result LEFT JOIN applicant ON applicant_result.applicant_id = applicant.applicant_id " +
                    "LEFT JOIN subject ON applicant_result.subject_id = subject.subject_id");
            ApplicantResult applicantResult = null;
            while (resultSet.next()) {
                applicantResult = new ApplicantResult();
                applicantResult.setId(resultSet.getInt("applicant_result_id"));
                //applicantResult.setApplicantId(resultSet.getInt("applicant_id"));
                applicantResult.setSubjectName(resultSet.getString("subject_name"));
                applicantResult.setApplicantName(resultSet.getString("first_name") +" " + resultSet.getString("last_name"));
                applicantResult.setMark(resultSet.getInt("mark"));
               // applicantResult.setSubjectId(resultSet.getInt("subject_id"));
                applicantResults.add(applicantResult);
            }
        } catch (SQLException e) {
            throw new Exception(e);
        }

        return applicantResults;

    }

    public void saveApplicantResult(ApplicantResult applicantResult) throws Exception {
        PreparedStatement preparedStatement = null;

        try {
            if (applicantResult.getId() > 0) {
                preparedStatement = connection.prepareStatement(
                        "UPDATE applicant_result SET applicant_id=?,mark=?,subject_id=? WHERE applicant_result_id=?");
                preparedStatement.setLong(1, applicantResult.getApplicantId());
                preparedStatement.setInt(2, applicantResult.getMark());
                preparedStatement.setLong(3, applicantResult.getSubjectId());
                preparedStatement.setInt(4, (int) applicantResult.getId());
            } else {
                preparedStatement = connection.prepareStatement("" +
                        "INSERT INTO applicant_result (applicant_id,mark,subject_id) VALUES (?, ?, ?) ");
                preparedStatement.setLong(1, applicantResult.getApplicantId());
                preparedStatement.setInt(2, applicantResult.getMark());
                preparedStatement.setLong(3, applicantResult.getSubjectId());
            }
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new Exception(e);
        } finally {
            if (preparedStatement != null) {
                preparedStatement.close();
            }
        }
    }

    public void deleteApplicantResult(long applicantResultId) throws Exception {
        PreparedStatement preparedStatement = null;

        try {
            preparedStatement = connection.prepareStatement("DELETE FROM applicant_result WHERE applicant_result_id=?");

            preparedStatement.setInt(1, (int) applicantResultId);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new Exception(e);
        } finally {
            if (preparedStatement != null) {
                preparedStatement.close();
            }
        }
    }
}
