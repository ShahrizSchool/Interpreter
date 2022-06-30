package interpreter.bytecode;

import interpreter.virtualmachine.VirtualMachine;

import java.util.ArrayList;

public class ReturnCode extends ByteCode{
    private String label;
    private int address;
    @Override
    public void init(ArrayList<String> args) {
        if(!args.isEmpty()){
            label = args.get(0);
        }
        else{
            label = "NULL";
        }
    }

    @Override
    public void execute(VirtualMachine vm) {
        address = vm.popReturnAddress();
        vm.setProgramCounter(address);
        vm.popFrameRunTimeStack();
    }

    @Override
    public String print() {
        return ("Return " + label);
    }
}
