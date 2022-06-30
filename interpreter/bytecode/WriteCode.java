package interpreter.bytecode;

import interpreter.virtualmachine.VirtualMachine;

import java.util.ArrayList;

public class WriteCode extends ByteCode{

    @Override
    public void init(ArrayList<String> args) {

    }

    @Override
    public void execute(VirtualMachine vm) {
        System.out.println(vm.peekRunTimeStack());
    }

    @Override
    public String print() {
        return ("Write ");
    }
}
