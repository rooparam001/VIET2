package com.viet.rooparam.viet2.Student;

public class StudentDataModel {

    public String student_id = "";
    public String student_name = "";
    public String father_name = "";
    public String roll_number = "";
    public String d_o_b = "";
    public String gender = "";
    public String email = "";
    public String mobile_number = "";
    public String branch = "";
    public String semester = "";
    public String address = "";
    public String state = "";
    public String city = "";
    public String pin_code = "";
    public String password = "";
    public String usertype = "";

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String day;
    public String time;
    public String teacher_name;
    public String room_Number;
    public String subject;

    public StudentDataModel(String day, String time, String subject_name, String teacher_name, String room_no, String branch_name, String semester_name) {

        this.time = time;
        this.subject = subject_name;
        this.teacher_name = teacher_name;
        this.room_Number = room_no;
        this.branch = branch_name;
        this.semester = semester_name;
        this.day = day;

    }

    public StudentDataModel() {

    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getTeacher_name() {
        return teacher_name;
    }

    public void setTeacher_name(String teacher_name) {
        this.teacher_name = teacher_name;
    }

    public String getRoom_Number() {
        return room_Number;
    }

    public void setRoom_Number(String room_Number) {
        this.room_Number = room_Number;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public StudentDataModel(
            String student_id, String student_name, String father_name, String roll_number, String d_o_b, String gender, String email,
            String mobile_number, String branch, String semester, String address, String state, String city, String pin_code,
            String password, String user_type) {
        this.student_id = student_id;
        this.student_name = student_name;
        this.father_name = father_name;
        this.roll_number = roll_number;
        this.d_o_b = d_o_b;
        this.gender = gender;
        this.email = email;
        this.mobile_number = mobile_number;
        this.branch = branch;
        this.semester = semester;
        this.address = address;
        this.state = state;
        this.city = city;
        this.pin_code = pin_code;
        this.password = password;
        this.usertype = user_type;
    }

    public String getUsertype() {
        return usertype;
    }

    public void setUsertype(String usertype) {
        this.usertype = usertype;
    }

    public String getStudent_id() {
        return student_id;
    }

    public void setStudent_id(String student_id) {
        this.student_id = student_id;
    }

    public String getStudent_name() {
        return student_name;
    }

    public void setStudent_name(String student_name) {
        this.student_name = student_name;
    }

    public String getFather_name() {
        return father_name;
    }

    public void setFather_name(String father_name) {
        this.father_name = father_name;
    }

    public String getRoll_number() {
        return roll_number;
    }

    public void setRoll_number(String roll_number) {
        this.roll_number = roll_number;
    }

    public String getD_o_b() {
        return d_o_b;
    }

    public void setD_o_b(String d_o_b) {
        this.d_o_b = d_o_b;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile_number() {
        return mobile_number;
    }

    public void setMobile_number(String mobile_number) {
        this.mobile_number = mobile_number;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPin_code() {
        return pin_code;
    }

    public void setPin_code(String pin_code) {
        this.pin_code = pin_code;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
