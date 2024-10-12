package org.example.mobile;

import java.util.ArrayList;
import java.util.List;

public class MobilePhone {
    private String myNumber;
    private List<Contact> myContacts;

    //private ArrayList<String> myContacts = new ArrayList<>();

    public MobilePhone(String myNumber, List<Contact> myContacts){
        this.myNumber = myNumber;
        this.myContacts = new ArrayList<>();//BU SATIR GPT'DEN. BUNU ARAŞTIR. ISTENMIYOR gibi
    }

    public MobilePhone(String myNumber) {
        this.myNumber = myNumber;
    }

    public String getMyNumber() {
        return myNumber;
    }

    public List<Contact> getMyContacts() {
        return myContacts;
    }


    public boolean addNewContact(Contact contact){
        int isFoundContact = findContact(contact);
        if (isFoundContact<0){
            myContacts.add(contact);
            return true;
        }
        return false;
    }

    public boolean updateContact(Contact contact1, Contact contact2){
        int isFoundOldContact = findContact(contact1);
        if(isFoundOldContact>=0){
            myContacts.remove(contact1);
            myContacts.add(isFoundOldContact, contact2);
            return true;
        }
        return false;
    }

    public boolean removeContact(Contact contact){
        int isFoundContact = findContact(contact);
        if (isFoundContact >= 0) {
            myContacts.remove(contact);
            return true;
        }
        return false;
    }

    public int findContact(Contact contact) {
        return myContacts.indexOf(contact);

    }

    public int findContact(String contactName){
        for (int i = 0; i <myContacts.size() ; i++) {
            Contact contact = myContacts.get(i);
            if(contact.getName().equals(contactName)){
                return i;
            }
        }
        return -1;
    }

    public Contact queryContact(String name){
        for (Contact myContact : myContacts) {
            if (myContact.getName().equals(name)) {
                return myContact;
            }
        }
        return null;
    }

    public void printContact(){
        for (int i = 0; i < myContacts.size(); i++) {
            System.out.println(i+1+". " + myContacts.get(i).getName() + "-> " + myContacts.get(i).getPhoneNumber());
        }
    }

    @Override
    public String toString() {
        return "MobilePhone{" +
                "myNumber='" + myNumber + '\'' +
                ", myContacts=" + myContacts +
                '}';
    }
}
