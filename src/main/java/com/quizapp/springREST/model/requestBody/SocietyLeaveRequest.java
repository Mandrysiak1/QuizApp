package com.quizapp.springREST.model.requestBody;

public class SocietyLeaveRequest {

    String socID;
    String userID;

    public String getSocID() {
        return socID;
    }

    public void setSocID(String socID) {
        this.socID = socID;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }
}
