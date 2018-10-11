package com.viet.rooparam.viet2.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.viet.rooparam.viet2.Student.StudentDataModel;

import java.util.ArrayList;

public class Viet_database extends SQLiteOpenHelper {


    private final static int DATABASE_VERSION = 1;
    private final static String DATABASE_NAME = "viet_Student_Data";

    private final static String TABLE_NAME = "student_databse";
    private final static String STUDENT_ID = "student_id";
    private final static String STUDENT_NAME = "student_name";
    private final static String FATHER_NAME = "father_name";
    private final static String ROLL_NUMBER = "roll_number";
    private final static String D_O_B = "d_o_b";
    private final static String GENDER = "gender";
    private final static String EMAIL = "email";
    private final static String MOBILE_NUMBER = "mobile_number";
    private final static String BRANCH = "branch";
    private final static String SEMESTER = "semester";
    private final static String ADDRESS = "address";
    private final static String STATE = "state";
    private final static String CITY = "city";
    private final static String PIN_CODE = "pin_code";
    private final static String PASSWORD = "password";
    private final static String USERTYPE = "usertype";


    private final static String TABLE_NAME_TIME = "time_table";
    private final static String TIME_TABLE_ID = "time_table_id";
    private final static String DAY = "day";
    private final static String TIME = "time";
    private final static String SUBJECT_NAME = "subject_name";
    private final static String TEACHER_NAME = "teacher_name";
    private final static String ROOM_NUMBER = "room_number";
    private final static String BRANCH_NAME = "branch_name";
    private final static String SEMESTER_NAME = "semester_name";

    private ContentValues cValues;
    private Cursor cursor;
    private SQLiteDatabase database = null;

    private String usertype = "";

    public Viet_database(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String create_table = "create table if not exists " + TABLE_NAME + "(" + STUDENT_ID + " INTEGER PRIMARY KEY autoincrement, " +
                STUDENT_NAME + " TEXT NOT NULL, " + FATHER_NAME + " TEXT , " + ROLL_NUMBER + " TEXT NOT NULL UNIQUE, " + D_O_B + " TEXT, " +
                GENDER + " TEXT, " + EMAIL + " TEXT NOT NULL, " + MOBILE_NUMBER + " TEXT, " + BRANCH + " TEXT, " + SEMESTER + " TEXT, " + ADDRESS
                + " TEXT, " + STATE + " TEXT, " + CITY + " TEXT, " + PIN_CODE + " TEXT, " + PASSWORD + " TEXT NOT NULL, " + USERTYPE + " TEXT NOT NULL)";

        String create_time_table = "create table if not exists " + TABLE_NAME_TIME + "(" + TIME_TABLE_ID + " INTEGER PRIMARY KEY autoincrement, " +
                DAY + " TEXT, " + TIME + " TEXT, " + SUBJECT_NAME + " TEXT, " + TEACHER_NAME + " TEXT, " + ROOM_NUMBER + " TEXT, "
                + BRANCH_NAME + " TEXT, " + SEMESTER_NAME + " TEXT)";
        db.execSQL(create_table);
        db.execSQL(create_time_table);
    }

    public void getTimeTableData(String day, String branch, String semester, String time, String subject_name, String teacher_name, String room_number) {
        Log.d("getTime tablench,sem", day + branch + semester + time + subject_name + teacher_name + room_number);


        if (timeTableExistsOrNot(day, branch, semester, time)) {
            SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
            cValues = new ContentValues();

            cValues.put(DAY, day);
            cValues.put(BRANCH_NAME, branch);
            cValues.put(SEMESTER_NAME, semester);
            cValues.put(TIME, time);
            cValues.put(SUBJECT_NAME, subject_name);
            cValues.put(TEACHER_NAME, teacher_name);
            cValues.put(ROOM_NUMBER, room_number);

            long i = sqLiteDatabase.insert(TABLE_NAME_TIME, null, cValues);

            sqLiteDatabase.close();
        } else {
            SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
            cValues = new ContentValues();

            cValues.put(DAY, day);
            cValues.put(BRANCH_NAME, branch);
            cValues.put(SEMESTER_NAME, semester);
            cValues.put(TIME, time);
            cValues.put(SUBJECT_NAME, subject_name);
            cValues.put(TEACHER_NAME, teacher_name);
            cValues.put(ROOM_NUMBER, room_number);

            long i = sqLiteDatabase.update(TABLE_NAME_TIME, cValues, TIME + " = '" + time + "'", null);

            sqLiteDatabase.close();

        }

    }

    private boolean timeTableExistsOrNot(String day, String branch_name, String semester, String time) {

        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();

        String query = "select * from " + TABLE_NAME_TIME + " where " + DAY + " = '" + day + "' " + " AND " + BRANCH_NAME + " = '" + branch_name + "'" + " AND " + SEMESTER_NAME + " = '" + semester + "'" + " AND " + TIME + " = '" + time + "'";

        Cursor cursor = sqLiteDatabase.rawQuery(query, null);

        if (cursor.getCount() <= 0) {
            cursor.close();
            sqLiteDatabase.close();
            return true;

        } else {
            cursor.close();
            sqLiteDatabase.close();
            return false;
        }

    }

    public void signupData(String student_name, String student_roll_number, String student_email, String student_password) {


        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        cValues = new ContentValues();

        cValues.put(STUDENT_NAME, student_name);
        cValues.put(ROLL_NUMBER, student_roll_number);
        cValues.put(EMAIL, student_email);
        cValues.put(PASSWORD, student_password);

        if (student_roll_number.equalsIgnoreCase("VIET@120")) {
            usertype = "Admin";
        } else {
            usertype = "Student";
        }

        cValues.put(USERTYPE, usertype);

        long i = sqLiteDatabase.insert(TABLE_NAME, null, cValues);

        sqLiteDatabase.close();

    }

    public StudentDataModel profileData(String father_name, String roll_number, String d_o_b, String gender, String mobile_number,
                                        String branch, String semester, String address, String state, String city, String pin_code) {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        cValues = new ContentValues();

        cValues.put(FATHER_NAME, father_name);
        cValues.put(D_O_B, d_o_b);
        cValues.put(GENDER, gender);
        cValues.put(MOBILE_NUMBER, mobile_number);
        cValues.put(BRANCH, branch);
        cValues.put(SEMESTER, semester);
        cValues.put(ADDRESS, address);
        cValues.put(STATE, state);
        cValues.put(CITY, city);
        cValues.put(PIN_CODE, pin_code);

        long i = sqLiteDatabase.update(TABLE_NAME, cValues, ROLL_NUMBER + " =? ", new String[]{String.valueOf(roll_number)});

        sqLiteDatabase.close();
        return null;
    }

    public boolean dataExistsOrNot(String roll_number) {

        SQLiteDatabase sqDb = this.getWritableDatabase();

        String query = "select * from " + TABLE_NAME + " where " + ROLL_NUMBER + " = '" + roll_number + "'";

        Cursor cursor = sqDb.rawQuery(query, null);

        if (cursor.getCount() <= 0) {
            cursor.close();
            sqDb.close();
            return true;

        } else {
            cursor.close();
            sqDb.close();
            return false;
        }
    }


    public boolean passwordMatchesOrNot(String roll_number, String password) {

        SQLiteDatabase sqDb = this.getWritableDatabase();

        String query = "select * from " + TABLE_NAME + " where " + ROLL_NUMBER + " = '" + roll_number + "' " + " and " + PASSWORD + " = '" + password + "'";

        Cursor cursor = sqDb.rawQuery(query, null);

        if (cursor.getCount() <= 0) {
            cursor.close();
            sqDb.close();
            return true;

        } else {
            cursor.close();
            sqDb.close();
            return false;
        }
    }

    public StudentDataModel getStudent(String roll) {
        database = getReadableDatabase();

        cursor = database.rawQuery(" Select * from " + TABLE_NAME + " where " + ROLL_NUMBER + " = '" + roll + "'", null);
        StudentDataModel studentModel = null;
        if (cursor.moveToFirst()) {
            do {
                String student_id = cursor.getString(0);
                String student_name = cursor.getString(1);
                String father_name = cursor.getString(2);
                String student_roll = cursor.getString(3);
                String d_o_b = cursor.getString(4);
                String gender = cursor.getString(5);
                String email = cursor.getString(6);
                String mobile = cursor.getString(7);
                String branch = cursor.getString(8);
                String sem = cursor.getString(9);
                String add = cursor.getString(10);
                String state = cursor.getString(11);
                String city = cursor.getString(12);
                String pin = cursor.getString(13);
                String password = cursor.getString(14);
                String user_type = cursor.getString(15);

                studentModel = new StudentDataModel(student_id, student_name, father_name, student_roll,
                        d_o_b, gender, email, mobile, branch, sem, add, state, city, pin, password, user_type);

                Log.d("data in database",studentModel.toString() + "");

            } while (cursor.moveToNext());
        }

        cursor.close();
        database.close();
        return studentModel;
    }

    public StudentDataModel gettimetable(String day_name, String branch, String semester) {
        database = getReadableDatabase();
        cursor = database.rawQuery("select * from " + TABLE_NAME_TIME + " where " + DAY + " = '" + day_name + "'" + " AND "
                + BRANCH_NAME + " = '" + branch + "'" + " AND " + SEMESTER_NAME + " = '" + semester + "'", null);
        StudentDataModel studentTimetable = null;

        if (cursor.moveToFirst()) {
            do {
                String day = cursor.getString(1);
                String time = cursor.getString(2);
                String subject_name = cursor.getString(3);
                String teacher_name = cursor.getString(4);
                String room_no = cursor.getString(5);
                String branch_name = cursor.getString(6);
                String semester_name = cursor.getString(7);

                studentTimetable = new StudentDataModel(day, time, subject_name, teacher_name, room_no, branch_name, semester_name);
            } while (cursor.moveToNext());
        }

        cursor.close();
        database.close();
        return studentTimetable;
    }

    public ArrayList<StudentDataModel> getTimetable(String day_name, String branch, String semester) {
        database = getReadableDatabase();

        ArrayList<StudentDataModel> dataModels = new ArrayList<>();

        cursor = database.rawQuery("select * from " + TABLE_NAME_TIME + " where " + DAY + " = '" + day_name + "'" + " AND "
                + BRANCH_NAME + " = '" + branch + "'" + " AND " + SEMESTER_NAME + " = '" + semester + "'", null);

        StudentDataModel studentTimetable = null;

        if (cursor.moveToFirst()) {

            do {
                String day = cursor.getString(1);
                String time = cursor.getString(2);
                String subject_name = cursor.getString(3);
                String teacher_name = cursor.getString(4);
                String room_no = cursor.getString(5);
                String branch_name = cursor.getString(6);
                String semester_name = cursor.getString(7);

                StudentDataModel studentDataModel = new StudentDataModel();
                studentDataModel.setDay(day);
                studentDataModel.setTime(time);
                studentDataModel.setSubject(subject_name);
                studentDataModel.setTeacher_name(teacher_name);
                studentDataModel.setRoom_Number(room_no);
                studentDataModel.setBranch(branch_name);
                studentDataModel.setSemester(semester_name);
                dataModels.add(studentDataModel);

            } while (cursor.moveToNext());
        }

        cursor.close();
        database.close();
        return dataModels;
    }

    public String isEmpty(String roll) {
        Log.d("runing", "yes");

        database = getReadableDatabase();
        String flag = "false";
        cursor = database.rawQuery("select * from " + TABLE_NAME + " where " + ROLL_NUMBER + " = '" + roll + "'", null);

        if (cursor.moveToFirst()) {
            String father_name = cursor.getString(2);

            father_name = father_name + "/";
            Log.d("father name2", father_name);
            if (father_name.equalsIgnoreCase("null/")) {
                flag = "true";
                Log.d("flag", flag);
            }
        }

        cursor.close();
        database.close();
        return flag;
    }

    public ArrayList<StudentDataModel> getlist() {
        database = getReadableDatabase();

        ArrayList<StudentDataModel> studentDataModels = new ArrayList<>();

        cursor = database.rawQuery("select * from " + TABLE_NAME, null);
        if (cursor.moveToFirst()) {
            do {
                String student_id = cursor.getString(0);
                String student_name = cursor.getString(1);
                String father_name = cursor.getString(2);
                String student_roll = cursor.getString(3);
                String d_o_b = cursor.getString(4);
                String gender = cursor.getString(5);
                String email = cursor.getString(6);
                String mobile = cursor.getString(7);
                String branch = cursor.getString(8);
                String sem = cursor.getString(9);
                String add = cursor.getString(10);
                String state = cursor.getString(11);
                String city = cursor.getString(12);
                String pin = cursor.getString(13);

                StudentDataModel studentDataModel = new StudentDataModel();
                studentDataModel.setStudent_id(student_id);
                studentDataModel.setStudent_name(student_name);
                studentDataModel.setFather_name(father_name);
                studentDataModel.setRoll_number(student_roll);
                studentDataModel.setD_o_b(d_o_b);
                studentDataModel.setGender(gender);
                studentDataModel.setEmail(email);
                studentDataModel.setMobile_number(mobile);
                studentDataModel.setBranch(branch);
                studentDataModel.setSemester(sem);
                studentDataModel.setAddress(add);
                studentDataModel.setState(state);
                studentDataModel.setCity(city);
                studentDataModel.setPin_code(pin);

                studentDataModels.add(studentDataModel);
            } while (cursor.moveToNext());
        }

        cursor.close();
        database.close();
        return studentDataModels;
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL(TABLE_NAME);
        onCreate(db);
    }

}
