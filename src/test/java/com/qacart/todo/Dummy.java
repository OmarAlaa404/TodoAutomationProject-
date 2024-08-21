package com.qacart.todo;

import com.qacart.todo.api.RegisterAPI;

public class Dummy {

    public static void main(String[] args) {
        RegisterAPI registerApi = new RegisterAPI();
        registerApi.register();

        System.out.println(registerApi.getAccessToken());
        System.out.println(registerApi.getUserId());
        System.out.println(registerApi.getFirstName());
    }
}
