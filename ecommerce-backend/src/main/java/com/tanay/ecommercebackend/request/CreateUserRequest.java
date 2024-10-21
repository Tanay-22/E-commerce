package com.tanay.ecommercebackend.request;

public class CreateUserRequest
{
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private Long mobile;


    public CreateUserRequest()
    {
    }

    public CreateUserRequest(String firstName, String lastName, String email, String password, Long mobile)
    {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.mobile = mobile;
    }

    public String getFirstName()
    {
        return firstName;
    }

    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }

    public String getLastName()
    {
        return lastName;
    }

    public void setLastName(String lastName)
    {
        this.lastName = lastName;
    }

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    public Long getMobile()
    {
        return mobile;
    }

    public void setMobile(Long mobile)
    {
        this.mobile = mobile;
    }
}
