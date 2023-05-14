package com.driver;

public class Email {

    private String emailId;
    private String password;

    public Email(String emailId){
        this.emailId = emailId;
        this.password = "Accio@123";
    }

    public String getEmailId() {
        return emailId;
    }

    public String getPassword() {
        return password;
    }

    public void changePassword(String oldPassword, String newPassword){
        //Change password only if the oldPassword is equal to current password and the new password meets all of the following:
        // 1. It contains at least 8 characters
        // 2. It contains at least one uppercase letter
        // 3. It contains at least one lowercase letter
        // 4. It contains at least one digit
        // 5. It contains at least one special character. Any character apart from alphabets and digits is a special character
        if(password.equals(oldPassword)){
            if(checkPassword(newPassword)){
                password=newPassword;
            }
        }
    }
    private boolean checkPassword(String s){
        if(s.length() < 8)return false;

        boolean uppercase = false,lowercase = false,oneDigit = false,specialChar = false;

        for(char c : s.toCharArray()){
            if('A'<=c && c<='Z'){
                uppercase = true;
            }else if('a'<=c && c<='z'){
                lowercase = true;
            }else if('0'<=c && c<='9'){
                oneDigit = true;
            }else {
                specialChar = true;
            }
        }

        return uppercase && lowercase && oneDigit && specialChar;
    }
}