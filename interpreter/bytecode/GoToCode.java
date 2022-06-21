package interpreter.bytecode;

import interpreter.virtualmachine.VirtualMachine;

import java.util.ArrayList;

public class GoToCode extends BranchCode{
    //Bytecode

    @Override
    public void init(ArrayList<String> args) {

    }

    @Override
    public void execute(VirtualMachine vm) {

    }

    //BranchCode


    @Override
    public void setTargetAddress(int n) {

    }

    @Override
    public int getTargetAddress() {
        return 0;
    }

    @Override
    public String getLabel() {
        return null;
    }
}
