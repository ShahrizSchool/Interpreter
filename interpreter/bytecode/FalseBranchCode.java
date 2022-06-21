package interpreter.bytecode;

import interpreter.virtualmachine.VirtualMachine;

import java.util.ArrayList;

public class FalseBranchCode extends BranchCode{

    //Bytecode


    @Override
    public void init(ArrayList<String> args) {

    }

    @Override
    public void execute(VirtualMachine vm) {

    }

    //Branch code
    @Override
    public int getTargetAddress() {
        return 0;
    }

    @Override
    public void setTargetAddress(int n) {

    }

    @Override
    public String getLabel() {
        return null;
    }
}
