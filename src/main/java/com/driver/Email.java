package com.driver;

import java.util.Date;

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

    public static class MailList {
        private Mail head,tail;
        int size,currentSize;

        public MailList(int size){
            this.size = size;
            currentSize = 0;
        }
        public Mail add(Mail mail){
            if(head==null){
                head = mail;
                tail = mail;
                currentSize=1;
                return null;
            }
            Mail trash=null;
            if(size == currentSize){
                trash = head;
                head = head.next;
                trash.next=null;
                currentSize--;
            }
            tail.next = mail;
            tail = mail;
            currentSize++;
            return trash;
        }

        public Mail delete(String message){
            Mail temp = head;

            if(head==null)return null;

            if(temp.message.equals(message)){
                head = head.next;
                temp.next = null;
                currentSize--;
                return temp;
            }

            while(temp.next != null){
                if(temp.next.message.equals(message)){
                    Mail trash = temp.next;
                    if(tail == trash){
                        tail = temp;
                    }
                    temp.next = temp.next.next;
                    trash.next = null;
                    currentSize--;
                    return trash;
                }
                temp = temp.next;
            }
            return null;
        }

        public Mail peek(){
            if(currentSize == 0)return null;
            return tail;
        }

        public Mail last(){
            if(currentSize == 0)return null;
            return head;
        }

        public int NumberOfNodes(Date d1, Date d2){
            Mail temp = head;
            int count = 0;
            while(temp != null){
                Date d = temp.date;
                if(d1.compareTo(d) <= 0 && d.compareTo(d2)<=0){
                    count++;
                }
                temp = temp.next;
            }
            return count;
        }
        public void clear(){
            Mail temp = head;
            while(temp != null){
                Mail curr = temp;
                temp = temp.next;
                curr.next = null;
            }
            head = null;
            tail = null;
            currentSize = 0;
        }

    }
}