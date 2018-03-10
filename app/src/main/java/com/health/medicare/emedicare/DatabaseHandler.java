package com.health.medicare.emedicare;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabaseCorruptException;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;




/**
 * DatabaseHandler is the class derived from the base class
 * SQLiteOpenHelper. It is used to create and update the tables.
 */
public class DatabaseHandler extends SQLiteOpenHelper {


    public DatabaseHandler(Context context, String name,
                           int version) {
        super(context, name, null, version);
    }

    // All Static variables
    // Database Version
    private static final int DATABASE_VERSION = 2;

    // Database Name
    private static final String DATABASE_NAME = "medicineManager";

    // Medicines table name
    private static final String TABLE_MEDICINES = "medicines";
    private static final String TABLE_USER_DETAILS = "userDetails";
    private static final String TABLE_DOCTOR_DETAILS = "doctorDetails";
    // MEDICINES Table Columns names
    private static final String KEY_ID = "id";
    private static final String KEY_CATEGORY = "category";
    private static final String KEY_MEDICINE_NAME = "medicineName";
    private static final String KEY_PRICE = "price";
    private static final String KEY_EXPIRY_DATE = "expiryDate";

    // user details Table Columns names
    private static final String KEY_USER_ID_ = "id";
    private static final String KEY_USER_NAME = "userName";
    private static final String KEY_MOBILE_NUMBER = "mobileNumber";
    private static final String KEY_EMAIL = "email";
    private static final String KEY_ADDRESS = "address";
    private static final String KEY_PASSWORD = "password";

    // doctor details Table Columns names
    private static final String KEY_DOCTOR_ID = "id";
    private static final String KEY_DOCTOR_NAME = "userName";
    private static final String KEY_DOCTOR_MOBILE_NUMBER = "mobileNumber";
    private static final String KEY_DOCTOR_EXPERIENCE = "email";
    private static final String KEY_DOCTOR_SPECIALIZATION = "address";
    private static final String KEY_DOCTOR_FEES = "doctorFees";


    public DatabaseHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    /**
     * This method is called, when an instance of DatabaseHandler is created.
     * All the tables should be created in this place.
     *
     * @param db
     */
    @Override
    public void onCreate(SQLiteDatabase db) {
        // Create tables.
        String CREATE_MEDICINES_TABLE = "CREATE TABLE " + TABLE_MEDICINES + "("
                + KEY_ID + " INTEGER PRIMARY KEY," + KEY_CATEGORY + " TEXT," + KEY_MEDICINE_NAME + " TEXT," + KEY_PRICE + " TEXT,"
                + KEY_EXPIRY_DATE + " TEXT" + ")";
        db.execSQL(CREATE_MEDICINES_TABLE);

        String CREATE_USER_TABLE = "CREATE TABLE " + TABLE_USER_DETAILS + "("
                + KEY_USER_ID_ + " INTEGER PRIMARY KEY," + KEY_PASSWORD + " TEXT," + KEY_USER_NAME + " TEXT," + KEY_MOBILE_NUMBER + " TEXT," + KEY_EMAIL + " TEXT,"
                + KEY_ADDRESS + " TEXT" + ")";
        db.execSQL(CREATE_USER_TABLE);

        String CREATE_DOCTOR_TABLE = "CREATE TABLE " + TABLE_DOCTOR_DETAILS + "("
                + KEY_DOCTOR_ID + " INTEGER PRIMARY KEY," + KEY_DOCTOR_NAME + " TEXT," + KEY_DOCTOR_MOBILE_NUMBER + " TEXT," + KEY_DOCTOR_SPECIALIZATION + " TEXT,"
                + KEY_DOCTOR_FEES + " TEXT," + KEY_DOCTOR_EXPERIENCE + " TEXT" + ")";
        db.execSQL(CREATE_DOCTOR_TABLE);
    }

    /**
     * This method is called when the database is upgraded.
     *
     * @param db
     * @param oldVersion
     * @param newVersion
     */
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop all tables.
        db.execSQL("DROP TABLE IF EXISTS "
                + TABLE_MEDICINES);
        db.execSQL("DROP TABLE IF EXISTS "
                + TABLE_USER_DETAILS);
        db.execSQL("DROP TABLE IF EXISTS "
                + TABLE_DOCTOR_DETAILS);

        // Create a new one.
        onCreate(db);
    }

    // Adding new user
    void addUserDetails(UserDetails userDetails) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_USER_NAME, userDetails.getUserName()); // User Name
        values.put(KEY_MOBILE_NUMBER, userDetails.getMobileNumber()); // Contact Phone
        values.put(KEY_EMAIL, userDetails.getEmail()); // Email
        values.put(KEY_ADDRESS, userDetails.getAddress()); // Email
        values.put(KEY_PASSWORD, userDetails.getPassword()); // Email

        // Inserting Row
        db.insert(TABLE_USER_DETAILS, null, values);
        db.close(); // Closing database connection
    }

    UserDetails getUserDetails() {
        String selectQuery = "SELECT  * FROM " + TABLE_USER_DETAILS ;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        UserDetails userDetails = new UserDetails();
        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {

                userDetails.setUserName((cursor.getString(2)));
                userDetails.setMobileNumber(cursor.getString(3));
                userDetails.setEmail(cursor.getString(4));
                userDetails.setAddress(cursor.getString(5));
                cursor.getString(1);
            } while (cursor.moveToNext());
        }
        cursor.close();
        return userDetails;


    }

    boolean isUserExist(String mobileNumber, String password) {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TABLE_USER_DETAILS, new String[]{
                        KEY_USER_NAME}, KEY_MOBILE_NUMBER + "=?  AND " + KEY_PASSWORD + "=?",
                new String[]{String.valueOf(mobileNumber), String.valueOf(password)}, null, null, null, null);
        if (cursor != null)
            return true;

        // UserDetails userDetails = new UserDetails(cursor.getString(0));
        // return contact
        return false;
    }

    // Adding new user
    void addMedicines(Medicine medicine) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_CATEGORY, medicine.getCategory());
        values.put(KEY_MEDICINE_NAME, medicine.getMedicineName());
        values.put(KEY_EXPIRY_DATE, medicine.getExpiryDate());
        values.put(KEY_PRICE, medicine.getPriceOfTenTablet());


        // Inserting Row
        db.insert(TABLE_MEDICINES, null, values);
        db.close(); // Closing database connection
    }

    // Getting All Medicines of chosen category
    public List<Medicine> getAllMedicines(String category) {
        List<Medicine> medicineList = new ArrayList<Medicine>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_MEDICINES + " WHERE " + KEY_CATEGORY + "='" + category + "'";

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                Medicine medicine = new Medicine();
                medicine.setMedicineName((cursor.getString(2)));
                medicine.setPriceOfTenTablet(cursor.getString(3));
                medicine.setExpiryDate(cursor.getString(4));

                // Adding contact to list
                medicineList.add(medicine);
            } while (cursor.moveToNext());
        }
        cursor.close();
        // return contact list
        return medicineList;
    }

    // Adding new doctor
    void addDoctors(Doctor doctor) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_DOCTOR_NAME, doctor.getDoctorName());
        values.put(KEY_DOCTOR_MOBILE_NUMBER, doctor.getDoctorPhoneNumber());
        values.put(KEY_DOCTOR_SPECIALIZATION, doctor.getDoctorSpecialization());
        values.put(KEY_DOCTOR_EXPERIENCE, doctor.getYearsOfExperience());
        values.put(KEY_DOCTOR_FEES, doctor.getFeesOfDoctor());

        // Inserting Row
        db.insert(TABLE_DOCTOR_DETAILS, null, values);
        db.close(); // Closing database connection
    }

    // Getting All Doctors
    public List<Doctor> getAllDoctors(String categoryName) {
        List<Doctor> doctorList = new ArrayList<Doctor>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_DOCTOR_DETAILS + " WHERE " + KEY_DOCTOR_SPECIALIZATION + "='" + categoryName + "'";
        ;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                Doctor doctor = new Doctor();
                doctor.setDoctorName((cursor.getString(1)));
                doctor.setDoctorPhoneNumber(cursor.getString(2));
                doctor.setDoctorSpecialization(cursor.getString(3));
                doctor.setFeesOfDoctor(cursor.getString(4));
                doctor.setYearsOfExperience(cursor.getString(5));


                // Adding contact to list
                doctorList.add(doctor);
            } while (cursor.moveToNext());
        }
        cursor.close();
        // return contact list
        return doctorList;
    }


}
