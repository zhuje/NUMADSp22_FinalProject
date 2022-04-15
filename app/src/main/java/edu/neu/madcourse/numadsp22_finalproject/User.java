package edu.neu.madcourse.numadsp22_finalproject;

public class User {

    public String username, password, email, uuid;
    public int rank;
    public String imageURL;
    public String status;
    public String search;

    public User(){}

    public User(String uuid){
        this.uuid = uuid;
        this.rank = 0;
    }

    public User(String username, String imageURL, String status, String search) {
        this.username = username;
        this.imageURL = imageURL;
        this.status = status;
        this.search = search;
    }


    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
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


    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getSearch() {
        return search;
    }

    public void setSearch(String search) {
        this.search = search;
    }
}
