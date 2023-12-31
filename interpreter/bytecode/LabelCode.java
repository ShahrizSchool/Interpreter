package interpreter.bytecode;

import interpreter.virtualmachine.VirtualMachine;

import java.util.ArrayList;

public class LabelCode extends ByteCode{
    private String label;
    private int addressC;
    @Override
    public void init(ArrayList<String> args) {
        label = args.get(0);
    }

    @Override
    public void execute(VirtualMachine vm) {

    }

    public String getLabel(){
        return this.label;
    }

    public void setLabel(int n ){
        label = Integer.toString(n);
    }

    public void setTargetAddress(int n) {
        addressC = n;
    }

    @Override
    public String print() {
        return ("Label " + label);
    }
}
