package edu.neu.madcourse.numadsp22_finalproject;

public class User {

    public String username, password, email, uuid;
    public int rank;

    public User(){}

    public User(String uuid, String username){
        this.uuid = uuid;
        this.username = username;
        this.rank = 0;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }


}
