package com.example;

class Main {


    // Room class
    public static class Room {

        public enum roomType {
            ONE_BEDRM, TWO_BEDRM, THREE_BEDRM, PENTHOUSE
        }

        private boolean available;
        private Guest occupant;
        private int roomNum;
        private double price;
        private roomType type;


        // constructor
        public Room(int roomNum, double price, roomType type) {
            this.roomNum = roomNum;
            this.price = price;
            this.type = type;
        }

        public boolean isAvailable() {
            return this.available;
        }

        public boolean getAvailable() {
            return available;
        }

        public void setAvailable(boolean available) {
            this.available = available;
        }

        public double getPrice() {
            return price;
        }

        public void setPrice(double price) {
            this.price = price;
        }

        public roomType getRoomType() {
            return type;
        }

        public void setRoomType(roomType type) {
            this.type = type;
        }

        public int getRoomNumber() {
            return roomNum;
        }

        public void setRoomNumber(int roomNum) {
            this.roomNum = roomNum;
        }

        public Guest getGuest() {
            return occupant;
        }

        public void setGuest(Guest occupant) {
            this.occupant = occupant;
        }

    }


    // Guest class 
    public static class Guest {

        private String name;
        private boolean checkedIn;
        private Room room;

        // constructor
        public Guest(String name) {
            this.name = name;
        }

        public void checkIn(Room room) {
            if (this.getStatus() == false) {
                this.setCheckedIn(true);
                this.setRoom(room);
            }
        }

        public void checkOut() {
            if (this.getStatus() == true) {
                this.setCheckedIn(false);
                this.setRoom(null);
            }
        }

        public boolean getStatus() {
            return checkedIn;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Room getRoom() {
            return room;
        }

        public void setRoom(Room room) {
            this.room = room;
        }

        public void setCheckedIn(boolean checkedIn) {
            this.checkedIn = checkedIn;
        }

        public void getRoomInfo(Room room) {
            System.out.println("Room # : " + room.getRoomNumber());
            System.out.println("Room price : " + room.getPrice());
            System.out.println("Room type : " + room.getRoomType());
            System.out.println("Room occupant : " + room.getGuest().getName());
        }
    }

    // main
    public static void main(String[] args) throws Exception {

        Guest mike = new Guest("mike");

        Room one_bedroom1 = new Room(1001, 100.00, Room.roomType.ONE_BEDRM);
        Room two_bedroom1 = new Room(2001, 200.00, Room.roomType.TWO_BEDRM);

        one_bedroom1.setAvailable(true);
        two_bedroom1.setAvailable(true);

        System.out.println(one_bedroom1.isAvailable());

        mike.checkIn(one_bedroom1);
        one_bedroom1.setGuest(mike);
        mike.getRoomInfo(one_bedroom1);

    }

}