import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class Program {
    public static void main(String[] args) throws InvalidDataException {

        Room salon = new Room(3,7.7,7);
        Room sypialnia = new Room(2.5,4.5,5.5);
        Room kuchnia = new Room(2.8,4.8,4.5);

        System.out.println("==========================");
        System.out.println("POKÓJ: Salon");
        salon.showFloorCost(5);
        salon.showPaintCost(10);
        salon.showFloorSurface();
        salon.showWallSurface();
        salon.showRoomVolume();

        System.out.println("==========================");
        System.out.println("POKÓJ: Sypialnia");
        sypialnia.showFloorCost(5);
        sypialnia.showPaintCost(10);
        sypialnia.showFloorSurface();
        sypialnia.showWallSurface();
        sypialnia.showRoomVolume();

        System.out.println("==========================");
        System.out.println("POKÓJ: Kuchnia");
        kuchnia.showFloorCost(5);
        kuchnia.showPaintCost(10);
        kuchnia.showFloorSurface();
        kuchnia.showWallSurface();
        kuchnia.showRoomVolume();


        System.out.println("==========================");
        System.out.println("Test custom exception");
        try {
            Room testException = new Room(-5, -5, -5);
        } catch(InvalidDataException exception) {
            System.out.println("Exception in catch");
            System.out.println("Error message: " + exception.getMessage());
            System.out.println("Error Code: " + exception.getErrorCode());
        }finally {
            System.out.println("Final part of try-catch-block");
            System.out.println("=========================");
        }

        try{
            Room testMethodException = new Room(1000,1000,1000);
            testMethodException.showRoomVolume();
        } catch(InvalidDataException exception){
            System.out.println("Exception in catch");
            System.out.println("Error Message: " + exception.getMessage());
            System.out.println("Error Code: " + exception.getErrorCode());
        }
        System.out.println("=========================");
    }
}
