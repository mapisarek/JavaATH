import java.io.BufferedReader;
import java.io.InputStreamReader;

public class InputData {

    //region class instantiate
    NumDivisibility numDivisibility = new NumDivisibility();
    InputStreamReader inputSR=new InputStreamReader(System.in);
    BufferedReader bufferedReader=new BufferedReader(inputSR);
    //endregion

    int min, max;

    public void getUserInputData(){
        try{
            System.out.println("Wprowadź dolną granice przedziału (MIN)");
            min = Integer.parseInt(bufferedReader.readLine());
            System.out.println("Wprowadź górną granice przedziału (MAX)");
            max = Integer.parseInt(bufferedReader.readLine());
        }catch(Exception exception){
            System.out.println("Wprowadzone dane nie są poprawne");
            getUserInputData();
        }

    }
}
