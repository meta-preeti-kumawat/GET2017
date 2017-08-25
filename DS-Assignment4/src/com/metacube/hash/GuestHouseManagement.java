package com.metacube.hash;

public class GuestHouseManagement {
    
    public static void main(String[] args) {
        GuestHouse guestHouse = new GuestHouse("ABC", 5);
        
        System.out.println(guestHouse.addGuest(new Guest("A", 22)));
        System.out.println(guestHouse.addGuest(new Guest("B", 32)));
        System.out.println(guestHouse.addGuest(new Guest("C", 52)));
        System.out.println(guestHouse.addGuest(new Guest("D", 22)));
        System.out.println(guestHouse.addGuest(new Guest("E", 32)));
        System.out.println(guestHouse.addGuest(new Guest("F", 32)));
        
        Guest[] storage = guestHouse.getGuestRoomAllotments().getTable();
        System.out.println("Room Number\tGuest Name\tGuest Age");
        for (int room = 1; room < storage.length; room++) {
            if(storage[room] == null){
                System.out.println(room+"\t\t-\t\t-");
            }
            else{
                System.out.println(room+"\t\t"+storage[room].getName()+"\t\t"+storage[room].getAge());
            }
        }
    }
}
