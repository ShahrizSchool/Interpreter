package interpreter.bytecode;

import interpreter.virtualmachine.VirtualMachine;

import java.util.ArrayList;

public class LoadCode extends ByteCode{
    private int value;
    private String id;
    private String offset;
    @Override
    public void init(ArrayList<String> args) {
        this.value = Integer.parseInt(args.get(0));

        if(!args.isEmpty()){
            offset = args.get(0);
            value = args.size();
            if(args.size() == 2){
                id = args.get(1);
            }
        }
    }

    @Override
    public void execute(VirtualMachine vm) {
        vm.loadRunTimeStack(value);
    }

    @Override
    public String print() {
        return ("LoadCode"+ offset + " " + id);
    }
}
