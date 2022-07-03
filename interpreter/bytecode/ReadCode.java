package interpreter.bytecode;

import interpreter.virtualmachine.VirtualMachine;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;


public class ReadCode extends ByteCode{

    private String userInput;
    Scanner scanInput = new Scanner(System.in);
    @Override
    public void init(ArrayList<String> args) {

    }

    @Override
    public void execute(VirtualMachine vm) {
        System.out.println("Please enter an integer: ");
        userInput = scanInput.nextLine();

        try{
            int value = Integer.parseInt(userInput);

        } catch (Exception err) {
            System.out.println("Please Enter an Integer!");

        }
    }

    @Override
    public String print() {
        return ("ReadCode ");
    }
}
