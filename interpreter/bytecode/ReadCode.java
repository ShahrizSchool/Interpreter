package interpreter.bytecode;

import interpreter.virtualmachine.VirtualMachine;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;


public class ReadCode extends ByteCode{

    private int userInput;
    Scanner scanInput = new Scanner(System.in);
    @Override
    public void init(ArrayList<String> args) {

    }

    @Override
    public void execute(VirtualMachine vm) {
        boolean invalid = false;

        System.out.println("Please enter an integer: ");

        do{
            try{
                userInput = scanInput.nextInt();
                invalid = false;
            }
            catch (InputMismatchException ex){
                invalid = true;
                System.out.println("Please Enter an interger: ");
                scanInput.nextLine();
            }
        } while(invalid);
        vm.pushRunTimeStack(userInput);
    }

    @Override
    public String print() {
        return ("ReadCode ");
    }
}
