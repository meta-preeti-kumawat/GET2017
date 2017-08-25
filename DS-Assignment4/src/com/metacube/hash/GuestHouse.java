package com.metacube.hash;

public class GuestHouse {
    private String name;
    private int rooms;
    HashTable<Guest> guestRoomAllotments;
    
    public GuestHouse(String name, int rooms) {
        this.name = name;
        this.rooms = rooms;
        guestRoomAllotments = new HashTable<Guest>(Guest.class, rooms);
    }
    public HashTable<Guest> getGuestRoomAllotments() {
        return guestRoomAllotments;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getRooms() {
        return rooms;
    }
    public void setRooms(int rooms) {
        this.rooms = rooms;
    }
    public String addGuest(Guest guest){
        Status status = guestRoomAllotments.add(guest,guest.getAge());
        if(status.isSuccess()){
            return status.getMessage();
        }
        else{
            return status.getError();
        }
    }
}
