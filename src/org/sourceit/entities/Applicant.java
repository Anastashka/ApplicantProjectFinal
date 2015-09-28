package org.sourceit.entities;

public class Applicant extends Entity {

    private long professionId;
    String professionName;
    private String lastName;
    private String firstName;
    private int entranceYear;

    public Applicant() {
    }

    public Applicant(long professionId, String lastName, String firstName, int entranceYear, String professionName) {
        this.professionId = professionId;
        this.lastName = lastName;
        this.firstName = firstName;
        this.entranceYear = entranceYear;
        this.professionName = professionName;
    }

    public long getProfessionId() {
        return professionId;
    }

    public String getProfessionName(){
        return professionName;
    }

    public void setProfessionId(long professionId) {
        this.professionId = professionId;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setProfessionName(String professionName){
        this.professionName = professionName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public int getEntranceYear() {
        return entranceYear;
    }

    public void setEntranceYear(int entranceYear) {
        this.entranceYear = entranceYear;
    }

    @Override
    public String toString() {
        return "Applicant{" +
                "professionId=" + professionId +
                "professionName" + professionName +
                ", lastName='" + lastName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", entranceYear=" + entranceYear +
                '}';
    }
}
