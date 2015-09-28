package org.sourceit.entities;

public class SpecialitySubject extends Entity {

    private long professionSubject;
    private long subjectId;
    String professionName;
    String subjectName;

    public long getProfessionSubject() {
        return professionSubject;
    }

    public void setProfessionSubject(long professionSubject) {
        this.professionSubject = professionSubject;
    }

    public long getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(long subjectId) {
        this.subjectId = subjectId;
    }

    public void setProfessionName(String professionName){
        this.professionName = professionName;
    }

    public String getProfessionName() {
        return professionName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public String getSubjectName() {
        return subjectName;
    }
}
