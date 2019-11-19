public class Room {

    double height, width, length;

    Room(double h, double w, double l) throws InvalidDataException {
        this.height = h;
        this.width = w;
        this.length = l;
        if(h < 0 || w < 0 || l < 0)
            throw new InvalidDataException("Room size below 0", 500);
    }

    public void showRoomVolume() throws InvalidDataException {
        System.out.println("Objętość pokoju wynosi: " + calculateVolume());
    }

    private double calculateVolume() throws InvalidDataException{
        double temporaryVolume = Math.round(height * width * length);
        if(temporaryVolume > 10000)
            throw new InvalidDataException("Impossible, room too big!", 521);
        else return temporaryVolume;
    }

    public void showWallSurface(){
        System.out.println("Powierzchnia ścian pokoju wynosi: " + calculateWallSurface());
    }

    private double calculateWallSurface(){
        return Math.round(2*(length * height) + 2*(width*height));
    }

    public void showFloorSurface(){
        System.out.println("Powierzchnia podłogi wynosi " + calculateFloorSurface());
    }

    private double calculateFloorSurface(){
    return Math.round((length * width));
    }

    public void showPaintCost(float costPerMeter){
        System.out.println("Malowanie pokoju wyniesie: " + calculatePaintCost(costPerMeter));
    }
    private double calculatePaintCost(float costPerMeter){
       return Math.round(calculateWallSurface() * costPerMeter);
    }

    public void showFloorCost(float costPerMeter){
        System.out.println("Podłoga pokoju wyniesie: " + calculateFloorCost(costPerMeter));
    }

    private double calculateFloorCost(float costPerMeter){
        return Math.round(calculateFloorSurface() * costPerMeter);
    }
}
