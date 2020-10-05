package com.bl.javastreams;

import java.util.*;
import java.util.stream.Collectors;

public class AddressBookMain {

    public static ArrayList<Contact> persons;
    public HashMap<String, ArrayList<Contact>> StatePersonMap;
    public HashMap<String, ArrayList<Contact>> CityPersonMap;


    Scanner sc = new Scanner(System.in);
    Scanner sc1 = new Scanner(System.in);
    Scanner sc2 = new Scanner(System.in);

    public AddressBookMain(){

        persons = new ArrayList<Contact>();
        StatePersonMap = new HashMap<String,ArrayList<Contact>>();
        CityPersonMap = new HashMap<String,ArrayList<Contact>>();
    }

    public static Contact SearchByFirstName(String firstname){

        Contact x = new Contact();

        for(int i=0;i<persons.size();i++){

            Contact y = (Contact)persons.get(i);
            if(firstname.equals(y.firstname)){

                x = y;
            }

        }

        return x;

    }

    public void AddDetails(){
        String firstname,lastname,address,city,state,zip,number,email;
        System.out.println("Enter your details:\n");
        System.out.println("Firstname\n");
        firstname=sc.nextLine();

        List<String> names = persons.stream().map(Contact::getFirstname).collect(Collectors.toList());
        boolean checkDuplicateName = names.stream().anyMatch(str -> firstname.equals(str));
        if(checkDuplicateName == true)
        {
            System.out.println("This Name is already present in this given AddressBook!!!!\n");
            return;
        }

        System.out.println("Lastname\n");
        lastname=sc.nextLine();
        System.out.println("Address\n");
        address=sc.nextLine();
        System.out.println("City\n");
        city=sc.nextLine();
        System.out.println("State\n");
        state=sc.nextLine();
        System.out.println("Zip\n");
        zip=sc.nextLine();
        System.out.println("Phone No.\n");
        number=sc.nextLine();
        System.out.println("Email\n");
        email=sc.nextLine();
        Contact c= new Contact(firstname, lastname, address, city, state, zip, number, email);
        persons.add(c);

        System.out.println("State"+state);

        if(!StatePersonMap.containsKey(state))
            StatePersonMap.put(state, new ArrayList<Contact>());
        StatePersonMap.get(state).add(c);

        if(!CityPersonMap.containsKey(city))
            CityPersonMap.put(city, new ArrayList<Contact>());
        CityPersonMap.get(city).add(c);



        System.out.println("Contact Successfully Added!!!\n\nContactList Contains\n");

        for (int i = 0; i < persons.size(); i++){
            System.out.println(i+1+". Firstname "+persons.get(i).firstname+" Lastname "+persons.get(i).lastname+
                    " Address "+persons.get(i).address+" City "+persons.get(i).city+" State "+persons.get(i).state+
                    " Zip "+persons.get(i).zip+" Phone number "+persons.get(i).number+" Email "+persons.get(i).email+"\n");
        }

    }

    public void EditDetailsByFirstName(String firstname) {

        System.out.println("Enter Choice of what you want to Edit\n\n\n1.FirstName\n2.Lastname\n3.Address\n4.City\n5.State\n6.Zip\n7.Phone\n8.Email\n");
        Contact a = SearchByFirstName(firstname);
        int choice = sc1.nextInt();

        switch(choice) {

            case 1:
                System.out.println("Enter new firstname: \n");
                a.firstname = sc2.nextLine();
                break;

            case 2:
                System.out.println("Enter new lastname: \n");
                a.lastname = sc2.nextLine();
                break;

            case 3:
                System.out.println("Enter new address: \n");
                a.address = sc2.nextLine();
                break;

            case 4:
                System.out.println("Enter new city: \n");
                a.city = sc2.nextLine();
                break;

            case 5:
                System.out.println("Enter new state: \n");
                a.state = sc2.nextLine();
                break;

            case 6:
                System.out.println("Enter new zip: \n");
                a.zip = sc2.nextLine();
                break;

            case 7:
                System.out.println("Enter new ph. number: \n");
                a.number = sc2.nextLine();
                break;

            case 8:
                System.out.println("Enter new email id: \n");
                a.email = sc2.nextLine();
                break;
            default:
                break;
        }

        System.out.println("Contact Succesfully Edited!!!\n\nContactList Contains\n");
        for (int i = 0; i < persons.size(); i++){
            System.out.println(i+1+". Firstname "+persons.get(i).firstname+" Lastname "+persons.get(i).lastname+
                    " Address "+persons.get(i).address+" City "+persons.get(i).city+" State "+persons.get(i).state+
                    " Zip "+persons.get(i).zip+" Phone number "+persons.get(i).number+" Email "+persons.get(i).email+"\n");
        }



    }

    public void DeleteByFirstName(String firstname) {

        for(int i=0;i<persons.size();i++){

            Contact x = (Contact)persons.get(i);
            if(firstname.equals(x.firstname)){
                persons.remove(i);
            }
        }
        System.out.println("Contact Succesfully Deleted!!!\n\nContactList Contains\n");
        for (int i = 0; i < persons.size(); i++){
            System.out.println(i+1+". Firstname "+persons.get(i).firstname+" Lastname "+persons.get(i).lastname+
                    " Address "+persons.get(i).address+" City "+persons.get(i).city+" State "+persons.get(i).state+
                    " Zip "+persons.get(i).zip+" Phone number "+persons.get(i).number+" Email "+persons.get(i).email+"\n");
        }

    }

}