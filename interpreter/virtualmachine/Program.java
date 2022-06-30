package interpreter.virtualmachine;

import interpreter.bytecode.*;

import java.util.ArrayList;
import java.util.HashMap;

public class Program {

    private ArrayList<ByteCode> program;
    private HashMap<String, Integer> address = new HashMap<>();

    public Program() {
        program = new ArrayList<>();
    }

    protected ByteCode getCode(int programCounter) {

        return this.program.get(programCounter);
    }

    /**
     * This function should go through the program and resolve all addresses.
     * Currently all labels look like LABEL <<num>>>, these need to be converted into
     * correct addresses so the VirtualMachine knows what to set the Program Counter
     * HINT: make note what type of data-structure ByteCodes are stored in.
     * **** METHOD SIGNATURE CANNOT BE CAHNGED *****
     */

    public void add(ByteCode byteCode) {

        this.program.add(byteCode);

        /*
        // this is to store the label and the line number
        if (byteCode instanceof LabelCode) {
            address.put(((LabelCode) byteCode).getLabel(), getSize());
        }
        program.add(byteCode);
        */
    }
    public void resolveAddress() {
        for(int i = 0; i < program.size(); i++){
            ByteCode bc = program.get(i);
            if (bc instanceof BranchCode){
                String labelName = ((BranchCode) bc).getLabel();
                if (address.containsKey(labelName)) {
                    ((BranchCode) bc).setTargetAddress(address.get(labelName));
                }
            }
        }

        for (int i = 0; i < program.size(); i++) {
            ByteCode addressOne = program.get(i);

            if (addressOne instanceof GotoCode) {
                address.put(((GotoCode) addressOne).getLabel(), i);
            }

            if (addressOne instanceof LabelCode) {
                address.put(((LabelCode) addressOne).getLabel(), i);
            }
        }

        for (int i = 0; i < program.size(); i++) {
            ByteCode addressTwo = program.get(i);

            if (addressTwo instanceof FalseBranchCode) {
                if (address.containsKey(((FalseBranchCode) addressTwo).getLabel())) {
                    ((FalseBranchCode) addressTwo).setLabel(address.get(((FalseBranchCode) addressTwo).getLabel()));
                }
            }

            if (addressTwo instanceof GotoCode) {
                if (address.containsKey(((GotoCode) addressTwo).getLabel())) {
                    ((GotoCode) addressTwo).setLabel(address.get(((GotoCode) addressTwo).getLabel()));
                }
            }

            if (addressTwo instanceof CallCode) {
                if (address.containsKey(((CallCode) addressTwo).getLabel())) {
                    ((CallCode) addressTwo).setLabel(address.get(((CallCode) addressTwo).getLabel()));
                }
            }
        }

    }
}
