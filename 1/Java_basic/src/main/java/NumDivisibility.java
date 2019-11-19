import java.util.Random;
import java.util.Vector;

public class NumDivisibility {

    Vector<Integer> numCollection;

    NumDivisibility(){
        numCollection = new Vector<Integer>();
    }

    public int getRandomDivNum(int min, int max){
        if(min != 0){
            int receivedValue;
            int range = max - min + 1;
            Random generator = new Random();
            receivedValue = generator.nextInt(range) + min;
            return receivedValue;
        }
        else{
            System.out.println("Divider cannot be 0");
            return 0;
        } }



    public Vector<Integer> getNumCollection(int min, int max, int divider){

        for (int i = min; min < max + 1; min++) {
            if (min % divider == 0)
                numCollection.add(min);
        }
        System.out.println("Wylosowany dzielnik: " + divider);
        return numCollection;
    }




}
