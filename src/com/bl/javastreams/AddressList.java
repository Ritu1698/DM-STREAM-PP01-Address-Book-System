package com.bl.javastreams;

import java.util.*;
import java.util.stream.Collectors;

public class AddressList {

    public static HashMap<String,AddressBookMain> AddressListMap;


    public AddressList()
    {
        AddressListMap= new HashMap<String,AddressBookMain>();
    }

    public void AddAddressBookByName(String name) {


        Scanner sc3 = new Scanner(System.in);
        System.out.println("Welcome to Address Book Program in AddressBookMain class on Master Branch \n");
        AddressBookMain a= new AddressBookMain();

        boolean flag1=true;
        while(flag1) {
            System.out.println("\n1.Add\n2.Edit\n3.Delete\nEnter your choice : ");
            int choice = sc3.nextInt();
            switch(choice) {
                case 1:
                    a.AddDetails();
                    break;

                case 2:
                    System.out.println("Enter firstname to edit");
                    Scanner sc4 = new Scanner(System.in);
                    String a1= sc4.nextLine();
                    a.EditDetailsByFirstName(a1);
                    break;

                case 3:
                    System.out.println("Enter firstname to delete");
                    Scanner sc5 = new Scanner(System.in);
                    String a2= sc5.nextLine();
                    a.DeleteByFirstName(a2);;
                    break;

                default:
                    System.out.println("Adding the AddressBook to AddressList");
                    flag1=false;
                    break;
            }
        }

        AddressListMap.put(name, a);
        System.out.println("AddressBooks in AddressList:\n");
        for (Map.Entry<String,AddressBookMain> entry : AddressListMap.entrySet()){
            int i=1;
            System.out.println(i+". AddressBook = " + entry.getKey());
            i++;
        }
    }


    public void SearchPersonByCityOrState(String location, int CityOrStateFlag) {

        if(CityOrStateFlag ==0) {                   //SearchByCity
            for(Map.Entry<String, AddressBookMain> entry: AddressListMap.entrySet())
            {

                AddressBookMain addBook = entry.getValue();
                List<Contact> contactsList = addBook.persons.stream().filter(findCity -> findCity.city.equals(location)).collect(Collectors.toList());
                for(Contact contact:contactsList)
                {
                    System.out.println(contact.firstname+" "+contact.lastname+" "+contact.address+" "+contact.city+" "+contact.email+" "+contact.number+" "+contact.state+" "+contact.zip+"\n");
                }
            }
        }

        else if(CityOrStateFlag == 1) {
            for(Map.Entry<String, AddressBookMain> entry: AddressListMap.entrySet())
            {
                AddressBookMain addBook = entry.getValue();
                List<Contact> contactsList = addBook.persons.stream().filter(findState -> findState.state.equals(location)).collect(Collectors.toList());
                for(Contact contact:contactsList)
                {
                    System.out.println(contact.firstname+" "+contact.lastname+" "+contact.address+" "+contact.city+" "+contact.email+" "+contact.number+" "+contact.state+" "+contact.zip+"\n");
                }
            }
        }
    }

    public static void main(String[] args) {

        System.out.println("Welcome to Address Book Program in AddressList class on Master Branch \n");
        AddressList AddList= new AddressList();

        boolean flag2 = true;
        while(flag2)
        {
            System.out.println("Enter 1 to Add New AddressBook to AddressList\nEnter 2 to Search Person By City Or State");
            Scanner sc7=new Scanner(System.in);
            int choice=sc7.nextInt();
            switch(choice)
            {
                case 1:
                    System.out.println("Enter address book name: ");
                    Scanner sc6= new Scanner(System.in);
                    String AddBookName= sc6.nextLine();

                    if(AddressListMap.containsKey(AddBookName))
                    {
                        System.out.println("Already PRESENT");
                        break;
                    }

                    AddList.AddAddressBookByName(AddBookName);
                    break;
                case 2:
                    System.out.println("Enter 0 To Choose City / 1 To Choose State : ");
                    Scanner sc8= new Scanner(System.in);
                    int cityOrStateFlag= sc8.nextInt();
                    if(cityOrStateFlag ==0) {
                        System.out.println("Enter City For Which You Want To Search Contact : ");
                        Scanner sc9= new Scanner(System.in);
                        String city= sc9.nextLine();
                        AddList.SearchPersonByCityOrState(city, cityOrStateFlag);
                    }
                    if(cityOrStateFlag ==1) {
                        System.out.println("Enter State For Which You Want To Search Contact : ");
                        Scanner sc9= new Scanner(System.in);
                        String state= sc9.nextLine();
                        AddList.SearchPersonByCityOrState(state, cityOrStateFlag);
                    }
                    break;

                default:
                    sc7.close();
                    flag2 = false;
                    break;

            }
        }
    }

}
