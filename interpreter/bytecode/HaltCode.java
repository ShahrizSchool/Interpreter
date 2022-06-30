package interpreter.bytecode;

import interpreter.virtualmachine.VirtualMachine;

import java.util.ArrayList;

public class HaltCode extends ByteCode {
    public void init(ArrayList<String> args) {

    }

    public void execute(VirtualMachine vm) {
        vm.setIsRunning(false);
    }

    @Override
    public String print() {
        return ("HALT");
    }
}
