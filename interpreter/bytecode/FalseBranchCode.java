package interpreter.bytecode;

import interpreter.virtualmachine.VirtualMachine;

import java.util.ArrayList;

public class FalseBranchCode extends BranchCode{

    private String label;
    private int targetAddress;
    //Bytecode

    @Override
    public void init(ArrayList<String> args) {
        label = args.get(0);
    }

    @Override
    public void execute(VirtualMachine vm) {
        if(vm.popRunTimeStack() == 0){
            vm.setProgramCounter(targetAddress-1);
        }
    }

    //Branch code
    @Override
    public int getTargetAddress() {
        return 0;
    }

    @Override
    public void setTargetAddress(int n) {
        this.targetAddress = n;
    }

    @Override
    public String getLabel() {
        return this.label;
    }

    public void setLabel(int index){
        this.label = Integer.toString(index);
    }

    @Override
    public String print() {
        return ("FalseBranchCode " + label);
    }
}
