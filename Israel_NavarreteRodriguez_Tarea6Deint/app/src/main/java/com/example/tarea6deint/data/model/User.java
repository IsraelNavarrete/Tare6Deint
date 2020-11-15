package com.example.tarea6deint.data.model;

public class User {
    private String Correo;
    private String UserName;
    private String Password;

    public User(String correo, String userName, String password) {
        Correo = correo;
        UserName = userName;
        Password = password;
    }

    public User() {
    }

    public String getCorreo() {
        return Correo;
    }

    public void setCorreo(String correo) {
        Correo = correo;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }


    @Override
    public String toString() {
        return "User{" +
                "Correo='" + Correo + '\'' +
                ", UserName='" + UserName + '\'' +
                ", Password='" + Password + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        return Correo.equals(user.Correo);
    }

    @Override
    public int hashCode() {
        return Correo.hashCode();
    }
}
