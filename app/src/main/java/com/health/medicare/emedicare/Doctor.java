package com.health.medicare.emedicare;



public class Doctor {
    private String doctorName;
    private String doctorSpecialization;
    private String yearsOfExperience;
    private String feesOfDoctor;
    private String doctorPhoneNumber;
    Doctor() {

    }

    String getFeesOfDoctor() {
        return feesOfDoctor;
    }

    void setFeesOfDoctor(String feesOfDoctor) {
        this.feesOfDoctor = feesOfDoctor;
    }

    void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    void setDoctorSpecialization(String doctorSpecialization) {
        this.doctorSpecialization = doctorSpecialization;
    }

    void setYearsOfExperience(String yearsOfExperience) {
        this.yearsOfExperience = yearsOfExperience;
    }

    void setDoctorPhoneNumber(String doctorPhoneNumber) {
        this.doctorPhoneNumber = doctorPhoneNumber;
    }

    String getDoctorName() {

        return doctorName;
    }

    String getDoctorSpecialization() {
        return doctorSpecialization;
    }

    String getYearsOfExperience() {
        return yearsOfExperience;
    }

    String getDoctorPhoneNumber() {
        return doctorPhoneNumber;
    }

    Doctor(String doctorName, String doctorSpecialization, String yearsOfExperience, String doctorPhoneNumber, String feesOfDoctor) {

        this.doctorName = doctorName;
        this.doctorSpecialization = doctorSpecialization;
        this.yearsOfExperience = yearsOfExperience;
        this.doctorPhoneNumber = doctorPhoneNumber;
        this.feesOfDoctor=feesOfDoctor;
    }





}
