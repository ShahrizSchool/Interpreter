package interpreter.bytecode;

import interpreter.virtualmachine.VirtualMachine;

import java.util.ArrayList;

public class StoreCode extends ByteCode{

    private int value;
    private String offset;
    private String id;

    public void init(ArrayList<String> args) {
        this.value = Integer.parseInt(args.get(0));
        this.offset = args.get(0);
        this.id = args.get(1);
    }

    @Override
    public void execute(VirtualMachine vm) {
        vm.StoreRunTimeStack(value);
    }

    @Override
    public String print() {
        return  ("STORE " + offset + " " + id + " = " + value);
    }
}
