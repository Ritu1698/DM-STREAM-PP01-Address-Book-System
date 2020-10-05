package com.bl.javastreams;

import java.util.*;

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


    public static void main(String[] args)
    {

        System.out.println("Welcome to Address Book Program in AddressList class on Master Branch \n");
        AddressList AddList= new AddressList();

        boolean flag2 = true;
        while(flag2)
        {
            System.out.println("Press 1 to Add New AddressBook to AddressList");
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

                default:
                    sc7.close();
                    flag2 = false;
                    break;

            }
        }
    }

}
