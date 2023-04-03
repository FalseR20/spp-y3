package com.example.lab4.Model;

public class Session {
    String room;
    String computer;
    String time;
    String user;
    String role;

    public Session(String room, String computer, String time, String user, String role) {
        this.room = room;
        this.computer = computer;
        this.time = time;
        this.user = user;
        this.role = role;
    }

    public Session(String computer, String user) {
        this.room = null;
        this.computer = computer;
        this.time = null;
        this.user = user;
        this.role = null;
    }

    public Session(String computer, String time, String user) {
        this.room = null;
        this.computer = computer;
        this.time = time;
        this.user = user;
        this.role = null;
    }

    @Override
    public String toString() {
        return "Session{" +
                "room='" + room + '\'' +
                ", computer='" + computer + '\'' +
                ", time='" + time + '\'' +
                ", user='" + user + '\'' +
                ", role='" + role + '\'' +
                '}';
    }

    public String getRoom() {
        return room;
    }

    public String getComputer() {
        return computer;
    }

    public String getTime() {
        return time;
    }

    public String getUser() {
        return user;
    }

    public String getRole() {
        return role;
    }
}
