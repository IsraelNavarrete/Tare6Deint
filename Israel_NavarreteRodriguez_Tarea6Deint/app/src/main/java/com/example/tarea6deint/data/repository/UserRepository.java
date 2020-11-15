package com.example.tarea6deint.data.repository;

import com.example.tarea6deint.data.model.User;

public class UserRepository {

private static UserRepository repository;
private User user;

static {
    repository =new UserRepository();
}
private UserRepository(){
    user = new User("israelnavarreterodriguez@gmail.com","Tingling","12345dsf");
}

public static UserRepository getInstance(){
    return repository;
}
}
