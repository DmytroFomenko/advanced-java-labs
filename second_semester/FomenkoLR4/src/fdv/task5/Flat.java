package fdv.task5;


public class Flat implements Comparable<Flat>{
    private int square;
    private int roomCount;
    private int floor;

    public Flat(int square, int roomCount, int floor) {
        this.square = square;
        this.roomCount = roomCount;
        this.floor = floor;
    }


    public int getSquare() {return square;}
    public int getRoomCount() {return roomCount;}
    public int getFloor() {return floor;}

    public void setSquare(int square) {this.square = square;}
    public void setRoomCount(int roomCount) {this.roomCount = roomCount;}
    public void setFloor(int floor) {this.floor = floor;}


    @Override
    public String toString() {return "Square: " + square + "    Rooms count: " + roomCount + "    Floor: " + floor;}



    @Override
    public int compareTo(Flat o) {
        if (this.roomCount > o.roomCount)
            return 1;
        else if (this.roomCount < o.roomCount)
            return -1;
        else {
            if (this.square > o.square)
                return -1;
            else if (this.square < o.square)
                return 1;
            else return 0;
        }
    }
}
