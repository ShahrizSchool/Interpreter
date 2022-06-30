package interpreter.bytecode;

import interpreter.virtualmachine.VirtualMachine;

import java.util.ArrayList;

public class GotoCode extends BranchCode{
    private String label;
    private int targetAddress;
    //Bytecode

    @Override
    public void init(ArrayList<String> args) {
        this.label = args.get(0);
    }

    @Override
    public void execute(VirtualMachine vm) {
        vm.setProgramCounter(targetAddress - 1);
    }

    //BranchCode


    @Override
    public void setTargetAddress(int n) {
        this.targetAddress = n;
    }

    @Override
    public int getTargetAddress() {
        return 0;
    }

    @Override
    public String getLabel() {
        return this.label;
    }

    public void setLabel(int i){
        label = Integer.toString(i);
    }

    @Override
    public String print() {
        return ("GoToCode " + label);
    }
}
