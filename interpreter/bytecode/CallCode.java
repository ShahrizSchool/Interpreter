package interpreter.bytecode;

import interpreter.virtualmachine.VirtualMachine;

import java.util.ArrayList;

public class CallCode extends BranchCode{

    //ByteCode
    @Override
    public void init(ArrayList<String> args) {

    }

    @Override
    public void execute(VirtualMachine vm) {

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

    @Override
    public void setTargetAddress(int n) {

    }
}
