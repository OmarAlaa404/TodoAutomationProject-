package com.qacart.todo.config;

/**
 * EndPoint class holds the API and web page endpoints used throughout the application.
 * These constants centralize the management of endpoint paths, ensuring consistency.
 */
public class EndPoint {

    // User-related endpoints
    public static final String API_REGISTER_ENDPOINT = "api/v1/users/register";

    // Task-related endpoints
    public static final String API_TASK_ENDPOINT = "api/v1/tasks";

    // Web page endpoints
    public static final String NEW_TODO_ENDPOINT = "todo/new";
    public static final String TODO_PAGE_ENDPOINT = "todo";

    // Private constructor to prevent instantiation
    private EndPoint() {
        throw new UnsupportedOperationException("This is a utility class and cannot be instantiated");
    }
}
