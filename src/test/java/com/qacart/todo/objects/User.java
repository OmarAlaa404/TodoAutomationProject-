package com.qacart.todo.objects;

/**
 * User class represents a user in the system, containing personal information
 * such as first name, last name, email, and password.
 */
public class User {

    private String email;
    private String password;
    private String firstName;
    private String lastName;

    /**
     * Constructs a new User with the specified first name, last name, email, and password.
     *
     * @param firstName the user's first name.
     * @param lastName the user's last name.
     * @param email the user's email address.
     * @param password the user's password.
     */
    public User(String firstName, String lastName, String email, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
    }

    /**
     * Returns the user's email address.
     *
     * @return the email address.
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets the user's email address.
     *
     * @param email the new email address.
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Returns the user's password.
     *
     * @return the password.
     */
    public String getPassword() {
        return password;
    }

    /**
     * Sets the user's password.
     *
     * @param password the new password.
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Returns the user's first name.
     *
     * @return the first name.
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Sets the user's first name.
     *
     * @param firstName the new first name.
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Returns the user's last name.
     *
     * @return the last name.
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Sets the user's last name.
     *
     * @param lastName the new last name.
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Provides a string representation of the User object.
     *
     * @return a string describing the user.
     */
    @Override
    public String toString() {
        return "User{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    /**
     * Compares this User object to another object for equality based on email.
     *
     * @param obj the object to compare to.
     * @return true if the other object is a User with the same email, false otherwise.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        User user = (User) obj;

        return email != null ? email.equals(user.email) : user.email == null;
    }

    /**
     * Generates a hash code for the User object based on email.
     *
     * @return the hash code.
     */
    @Override
    public int hashCode() {
        return email != null ? email.hashCode() : 0;
    }
}
