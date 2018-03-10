package com.health.medicare.emedicare;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;

import org.greenrobot.eventbus.EventBus;


public class HomeActivity extends AppCompatActivity implements View.OnClickListener {
    private static final String PREFERENCES_NAME = "Preferences";
    EditText mobileNumberEditText;
    EditText passwordEditText;
    Button orderMedicines;
    Button doctors;
    FrameLayout doctorsFrameLayout;
    FrameLayout medicinesFrameLayout;
    private Boolean firstTime = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        medicinesFrameLayout = (FrameLayout) findViewById(R.id.btn_order_med);
        doctorsFrameLayout = (FrameLayout) findViewById(R.id.btn_doctors_framelayout);
        medicinesFrameLayout.setOnClickListener(this);
        doctorsFrameLayout.setOnClickListener(this);
        isFirstTime();
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.btn_order_med:
                Intent intent2 = new Intent(this, SelectMedicineCategoryActivity.class);
                startActivity(intent2);
                break;
            case R.id.btn_doctors_framelayout:
                Intent intent3 = new Intent(this, SelectDoctorCategoryActivity.class);
                startActivity(intent3);
                break;
        }
    }

    /**
     * Checks if the user is opening the app for the first time.
     * Note that this method should be placed inside an activity and it can be called multiple times.
     *
     * @return boolean
     */
    private boolean isFirstTime() {
        if (firstTime == null) {
            SharedPreferences mPreferences = this.getSharedPreferences(PREFERENCES_NAME, Context.MODE_PRIVATE);
            firstTime = mPreferences.getBoolean("firstTime", true);
            if (firstTime) {
                SharedPreferences.Editor editor = mPreferences.edit();
                editor.putBoolean("firstTime", false);
                editor.commit();
                prepopulateMedicines();
                prepopulateDoctors();
            }
        }
        return firstTime;
    }

    private void prepopulateDoctors() {
        DatabaseHandler databaseHandler = new DatabaseHandler(this);
        Doctor doctor = new Doctor("Dr. Nagaraj", "General Physician", "10 years of experience", "9834567859", "300");
        Doctor doctor1 = new Doctor("Dr. Sheetal", "General Physician", "12 years of experience", "9834567859", "200");
        Doctor doctor2 = new Doctor("Dr. Srivastava", "General Physician", "7 years of experience", "9834567859", "100");
        Doctor doctor3 = new Doctor("Dr. Patil", "General Physician", "9 years of experience", "9834567859", "500");
        Doctor doctor4 = new Doctor("Dr. Sheetal", "General Physician", "3 years of experience", "9834567859", "200");
        Doctor entdoctor = new Doctor("Dr. Ajay", "ENT Specialist", "10 years of experience", "9834567859", "300");
        Doctor entdoctor1 = new Doctor("Dr. Fayez", "ENT Specialist", "12 years of experience", "9834567859", "300");
        Doctor entdoctor2 = new Doctor("Dr. Ankita", "ENT Specialist", "7 years of experience", "9834567859", "300");
        Doctor entdoctor3 = new Doctor("Dr. Patil", "ENT Specialist", "9 years of experience", "9834567859", "300");
        Doctor entdoctor4 = new Doctor("Dr. Neha", "ENT Specialist", "3 years of experience", "9834567859", "300");
        Doctor skindoctor = new Doctor("Dr. Anita", "Dermatologist", "10 years of experience", "9834567859", "300");
        Doctor skindoctor1 = new Doctor("Dr. Naina", "Dermatologist", "12 years of experience", "9834567859", "300");
        Doctor skindoctor2 = new Doctor("Dr. Peeyush", "Dermatologist", "7 years of experience", "9834567859", "300");
        Doctor skindoctor3 = new Doctor("Dr. Geeta", "Dermatologist", "9 years of experience", "9834567859", "300");
        Doctor skindoctor4 = new Doctor("Dr. Neha", "Dermatologist", "3 years of experience", "9834567859", "300");
        Doctor eyedoctor = new Doctor("Dr. Anita", "Opthalmologist", "10 years of experience", "9834567859", "300");
        Doctor eyedoctor1 = new Doctor("Dr. Naina", "Opthalmologist", "12 years of experience", "9834567859", "300");
        Doctor eyedoctor2 = new Doctor("Dr. Peeyush", "Opthalmologist", "7 years of experience", "9834567859", "300");
        Doctor eyedoctor3 = new Doctor("Dr. Geeta", "Opthalmologist", "9 years of experience", "9834567859", "300");
        Doctor eyedoctor4 = new Doctor("Dr. Neha", "Opthalmologist", "3 years of experience", "9834567859", "300");
        Doctor toothdoctor = new Doctor("Dr. Ajay", "Dentist", "10 years of experience", "9834567859", "300");
        Doctor toothdoctor1 = new Doctor("Dr. Fayez", "Dentist", "12 years of experience", "9834567859", "300");
        Doctor toothdoctor2 = new Doctor("Dr. Ankita", "Dentist", "7 years of experience", "9834567859", "300");
        Doctor toothdoctor3 = new Doctor("Dr. Patil", "Dentist", "9 years of experience", "9834567859", "300");
        Doctor toothdoctor4 = new Doctor("Dr. Neha", "Dentist", "3 years of experience", "9834567859", "300");
        Doctor bonedoctor1 = new Doctor("Dr. Naina", "Orthopodist", "12 years of experience", "9834567859", "300");
        Doctor bonedoctor2 = new Doctor("Dr. Peeyush", "Orthopodist", "7 years of experience", "9834567859", "300");
        Doctor bonedoctor3 = new Doctor("Dr. Geeta", "Orthopodist", "9 years of experience", "9834567859", "300");
        Doctor bonedoctor4 = new Doctor("Dr. Neha", "Orthopodist", "3 years of experience", "9834567859", "300");
        Doctor nervesdoctor = new Doctor("Dr. Nagaraj", "Neurologist", "10 years of experience", "9834567859", "300");
        Doctor nervesdoctor1 = new Doctor("Dr. Sheetal", "Neurologist", "12 years of experience", "9834567859", "300");
        Doctor nervesdoctor2 = new Doctor("Dr. Srivastava", "Neurologist", "7 years of experience", "9834567859", "300");
        Doctor nervesdoctor3 = new Doctor("Dr. Patil", "Neurologist", "9 years of experience", "9834567859", "300");
        Doctor nervesdoctor4 = new Doctor("Dr. Sheetal", "Neurologist", "3 years of experience", "9834567859", "300");
        Doctor urologydoctor = new Doctor("Dr. Nayani", "Urologist", "10 years of experience", "9834567859", "300");
        Doctor urologydoctor1 = new Doctor("Dr. Rahul", "Urologist", "12 years of experience", "9834567859", "300");
        Doctor urologydoctor2 = new Doctor("Dr. Suchitra", "Urologist", "7 years of experience", "9834567859", "300");
        Doctor urologydoctor3 = new Doctor("Dr. Patil", "Urologist", "9 years of experience", "9834567859", "300");
        Doctor urologydoctor4 = new Doctor("Dr. Nazima", "Urologist", "3 years of experience", "9834567859", "300");
        databaseHandler.addDoctors(doctor);
        databaseHandler.addDoctors(doctor1);
        databaseHandler.addDoctors(doctor2);
        databaseHandler.addDoctors(doctor3);
        databaseHandler.addDoctors(doctor4);
        databaseHandler.addDoctors(entdoctor);
        databaseHandler.addDoctors(entdoctor1);
        databaseHandler.addDoctors(entdoctor2);
        databaseHandler.addDoctors(entdoctor3);
        databaseHandler.addDoctors(entdoctor4);
        databaseHandler.addDoctors(skindoctor);
        databaseHandler.addDoctors(skindoctor1);
        databaseHandler.addDoctors(skindoctor2);
        databaseHandler.addDoctors(skindoctor3);
        databaseHandler.addDoctors(skindoctor4);
        databaseHandler.addDoctors(eyedoctor);
        databaseHandler.addDoctors(eyedoctor1);
        databaseHandler.addDoctors(eyedoctor2);
        databaseHandler.addDoctors(eyedoctor3);
        databaseHandler.addDoctors(eyedoctor4);
        databaseHandler.addDoctors(toothdoctor);
        databaseHandler.addDoctors(toothdoctor1);
        databaseHandler.addDoctors(toothdoctor2);
        databaseHandler.addDoctors(toothdoctor3);
        databaseHandler.addDoctors(toothdoctor4);
        databaseHandler.addDoctors(bonedoctor1);
        databaseHandler.addDoctors(bonedoctor2);
        databaseHandler.addDoctors(bonedoctor3);
        databaseHandler.addDoctors(bonedoctor4);
        databaseHandler.addDoctors(nervesdoctor);
        databaseHandler.addDoctors(nervesdoctor1);
        databaseHandler.addDoctors(nervesdoctor2);
        databaseHandler.addDoctors(nervesdoctor3);
        databaseHandler.addDoctors(nervesdoctor4);
        databaseHandler.addDoctors(urologydoctor);
        databaseHandler.addDoctors(urologydoctor1);
        databaseHandler.addDoctors(urologydoctor2);
        databaseHandler.addDoctors(urologydoctor3);
        databaseHandler.addDoctors(urologydoctor4);
    }

    private void prepopulateMedicines() {
        DatabaseHandler databaseHandler = new DatabaseHandler(this);
        Medicine medicine = new Medicine("Fever", "Algin", "Feb 2019", "37.43");
        Medicine medicine1 = new Medicine("Fever", "Aspirin", "March 2019", "80");
        Medicine medicine2 = new Medicine("Fever", "Beclasone-C", "Feb 2019", "75");
        Medicine medicine3 = new Medicine("Fever", "Clavix AS", "Oct 2019", "60");
        Medicine medicine4 = new Medicine("Fever", "Decil", "May 2019", "25");
        Medicine medicine5 = new Medicine("Fever", "Crocin", "June 2019", "18");
        Medicine medicine6 = new Medicine("Fever", "Diaprin", "Aug 2019", "90");
        databaseHandler.addMedicines(medicine);
        databaseHandler.addMedicines(medicine1);
        databaseHandler.addMedicines(medicine2);
        databaseHandler.addMedicines(medicine3);
        databaseHandler.addMedicines(medicine4);
        databaseHandler.addMedicines(medicine5);
        databaseHandler.addMedicines(medicine6);

        //For Cold and Cough
        Medicine med0 = new Medicine("Cold and Cough", "Sinarest", "Feb 2019", "37.43");
        Medicine med1 = new Medicine("Cold and Cough", "Dolo BM syrup", "March 2019", "80");
        Medicine med2 = new Medicine("Cold and Cough", "Disprin", "Feb 2019", "75");
        Medicine med3 = new Medicine("Cold and Cough", "Medler", "Oct 2019", "60");
        Medicine med4 = new Medicine("Cold and Cough", "Zyncet", "May 2019", "25");
        Medicine med5 = new Medicine("Cold and Cough", "Crocin", "June 2019", "18");
        Medicine med6 = new Medicine("Cold and Cough", "Diaprin", "Aug 2019", "90");
        databaseHandler.addMedicines(med0);
        databaseHandler.addMedicines(med1);
        databaseHandler.addMedicines(med2);
        databaseHandler.addMedicines(med3);
        databaseHandler.addMedicines(med4);
        databaseHandler.addMedicines(med5);
        databaseHandler.addMedicines(med6);

        //For HeartDisease
        Medicine medForHeart0 = new Medicine("Heart Disease", "Warfarin", "Feb 2019", "37.43");
        Medicine medForHeart1 = new Medicine("Heart Disease", "NOACs", "March 2019", "80");
        Medicine medForHeart2 = new Medicine("Heart Disease", "Statins", "Feb 2019", "75");
        Medicine medForHeart3 = new Medicine("Heart Disease", "Nitrates", "Oct 2019", "60");
        Medicine medForHeart4 = new Medicine("Heart Disease", "Zyncet", "May 2019", "25");
        Medicine medForHeart5 = new Medicine("Heart Disease", "Diaprin", "June 2019", "18");
        Medicine medForHeart6 = new Medicine("Heart Disease", "Aspirin", "Aug 2019", "90");
        databaseHandler.addMedicines(medForHeart0);
        databaseHandler.addMedicines(medForHeart1);
        databaseHandler.addMedicines(medForHeart2);
        databaseHandler.addMedicines(medForHeart3);
        databaseHandler.addMedicines(medForHeart4);
        databaseHandler.addMedicines(medForHeart5);
        databaseHandler.addMedicines(medForHeart6);

        //For Thyroid
        Medicine medForThyroid0 = new Medicine("Thyroid", "Cytomel", "Feb 2019", "85.43");
        Medicine medForThyroid1 = new Medicine("Thyroid", "Levo-T", "March 2019", "80");
        Medicine medForThyroid2 = new Medicine("Thyroid", "Tirosint", "Feb 2019", "75");
        Medicine medForThyroid3 = new Medicine("Thyroid", "Levoxyl", "Oct 2019", "65");
        Medicine medForThyroid4 = new Medicine("Thyroid", "Thyrogen", "May 2019", "25");
        Medicine medForThyroid5 = new Medicine("Thyroid", "Westhroid", "June 2019", "18");
        Medicine medForThyroid6 = new Medicine("Thyroid", "Aspirin", "Aug 2019", "90");
        databaseHandler.addMedicines(medForThyroid0);
        databaseHandler.addMedicines(medForThyroid1);
        databaseHandler.addMedicines(medForThyroid2);
        databaseHandler.addMedicines(medForThyroid3);
        databaseHandler.addMedicines(medForThyroid4);
        databaseHandler.addMedicines(medForThyroid5);
        databaseHandler.addMedicines(medForThyroid6);

        //For SeniorCare
        Medicine medForSeniorCare0 = new Medicine("Senior Care", "Hot Water Bags", "Feb 2019", "85.43 ");
        Medicine medForSeniorCare1 = new Medicine("Senior Care", "Knee Cap", "March 2019", "80 ");
        Medicine medForSeniorCare2 = new Medicine("Senior Care", "Heat Belts", "Feb 2019", "75");
        Medicine medForSeniorCare3 = new Medicine("Senior Care", "Accu Check", "Oct 2019", "65 ");
        Medicine medForSeniorCare4 = new Medicine("Senior Care", "BP Monitor", "May 2019", "250 ");
        Medicine medForSeniorCare5 = new Medicine("Senior Care", "Nebulisers", "June 2019", "180");
        Medicine medForSeniorCare6 = new Medicine("Senior Care", "Thermometer", "Aug 2019", "90");
        databaseHandler.addMedicines(medForSeniorCare0);
        databaseHandler.addMedicines(medForSeniorCare1);
        databaseHandler.addMedicines(medForSeniorCare2);
        databaseHandler.addMedicines(medForSeniorCare3);
        databaseHandler.addMedicines(medForSeniorCare4);
        databaseHandler.addMedicines(medForSeniorCare5);
        databaseHandler.addMedicines(medForSeniorCare6);

        //For Diabetes
        Medicine medForDiabetes0 = new Medicine("Diabetes", "Apidra", "Feb 2019", "85.43");
        Medicine medForDiabetes1 = new Medicine("Diabetes", "Humalog", "March 2019", "80");
        Medicine medForDiabetes2 = new Medicine("Diabetes", "Afrezza", "Feb 2019", "75");
        Medicine medForDiabetes3 = new Medicine("Diabetes", "Levoxyl", "Oct 2019", "65");
        Medicine medForDiabetes4 = new Medicine("Diabetes", "Humulin R", "May 2019", "25");
        Medicine medForDiabetes5 = new Medicine("Diabetes", "Tresiba", "June 2019", "18");
        Medicine medForDiabetes6 = new Medicine("Diabetes", "Levemir", "Aug 2019", "90");
        databaseHandler.addMedicines(medForDiabetes0);
        databaseHandler.addMedicines(medForDiabetes1);
        databaseHandler.addMedicines(medForDiabetes2);
        databaseHandler.addMedicines(medForDiabetes3);
        databaseHandler.addMedicines(medForDiabetes4);
        databaseHandler.addMedicines(medForDiabetes5);
        databaseHandler.addMedicines(medForDiabetes6);


        //For Blood Pressure
        Medicine medForBloodPressure0 = new Medicine("Blood Pressure", "Bumex", "Feb 2019", "85.43");
        Medicine medForBloodPressure1 = new Medicine("Blood Pressure", "Hygroton", "March 2019", "80");
        Medicine medForBloodPressure2 = new Medicine("Blood Pressure", "Diurin", "Feb 2019", "75");
        Medicine medForBloodPressure3 = new Medicine("Blood Pressure", "Edecrin", "Oct 2019", "65");
        Medicine medForBloodPressure4 = new Medicine("Blood Pressure", "Lasix", "May 2019", "25");
        Medicine medForBloodPressure5 = new Medicine("Blood Pressure", "Lozol", "June 2019", "18");
        Medicine medForBloodPressure6 = new Medicine("Blood Pressure", "Enduron", "Aug 2019", "90");
        databaseHandler.addMedicines(medForBloodPressure0);
        databaseHandler.addMedicines(medForBloodPressure1);
        databaseHandler.addMedicines(medForBloodPressure2);
        databaseHandler.addMedicines(medForBloodPressure3);
        databaseHandler.addMedicines(medForBloodPressure4);
        databaseHandler.addMedicines(medForBloodPressure5);
        databaseHandler.addMedicines(medForBloodPressure6);

        //For General Medicines
        Medicine medGeneralPurpose0 = new Medicine("General Medicines", "Paracetamol", "June 2019", "85.43");
        Medicine medGeneralPurpose1 = new Medicine("General Medicines", "Pentazocine", "March 2019", "80");
        Medicine medGeneralPurpose2 = new Medicine("General Medicines", "Amoxycylin", "Feb 2019", "75");
        Medicine medGeneralPurpose3 = new Medicine("General Medicines", "Edecrin", "Oct 2019", "65");
        Medicine medGeneralPurpose4 = new Medicine("General Medicines", "Azithromycin", "May 2019", "25");
        Medicine medGeneralPurpose5 = new Medicine("General Medicines", "Cefotaxime", "June 2019", "18");
        Medicine medGeneralPurpose6 = new Medicine("General Medicines", "Ciprofloxacin 25mg", "Aug 2019", "90");
        databaseHandler.addMedicines(medGeneralPurpose0);
        databaseHandler.addMedicines(medGeneralPurpose1);
        databaseHandler.addMedicines(medGeneralPurpose2);
        databaseHandler.addMedicines(medGeneralPurpose3);
        databaseHandler.addMedicines(medGeneralPurpose4);
        databaseHandler.addMedicines(medGeneralPurpose5);
        databaseHandler.addMedicines(medGeneralPurpose6);
    }

}
