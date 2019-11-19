import java.io.*;

public class Program {

    public static void main(String[] args){
        InputData inputData = new InputData();
        NumDivisibility numDivisibility = new NumDivisibility();
        inputData.getUserInputData();
        numDivisibility.getNumCollection(inputData.min, inputData.max,numDivisibility.getRandomDivNum(1, 14));
        System.out.print("Liczby podzielne z przedziału: ");
        numDivisibility.numCollection.forEach((n) -> System.out.print(n + " "));
    }
}
