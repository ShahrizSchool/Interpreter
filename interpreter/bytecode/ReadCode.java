package interpreter.bytecode;

import interpreter.virtualmachine.VirtualMachine;

import java.util.ArrayList;
import java.util.Scanner;

public class ReadCode extends ByteCode{
    private int userInput;
    Scanner scan = new Scanner(System.in);
    @Override
    public void init(ArrayList<String> args) {

    }

    @Override
    public void execute(VirtualMachine vm) {
        vm.read();
        vm.pushRunTimeStack(userInput);
    }

    @Override
    public String print() {
        return ("ReadCode ");
    }
}
