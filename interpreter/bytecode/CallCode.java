package interpreter.bytecode;

import interpreter.virtualmachine.VirtualMachine;

import java.util.ArrayList;

public class CallCode extends BranchCode{
    private String label;
    private int targetAddress;
    private int addressC;
    private String argPassed;

    //ByteCode
    @Override
    public void init(ArrayList<String> args) {
        label = args.get(0);
    }

    @Override
    public void execute(VirtualMachine vm) {
        addressC = vm.getProgramCounter();
        vm.setProgramCounter(targetAddress - 1);
        vm.pushReturnAddress(addressC);
        argPassed = vm.peekFrameRunTimeStack();
    }

    //BranchCode
    @Override
    public int getTargetAddress() {
        return 0;
    }

    @Override
    public String getLabel() {
        return null;
    }

    public void setLabel(int n ){
        label = Integer.toString(n);
    }

    @Override
    public void setTargetAddress(int n) {
        addressC = n;
    }

    @Override
    public String print() {
       return ("Call " + label);
    }

}
