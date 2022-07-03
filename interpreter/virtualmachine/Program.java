package interpreter.virtualmachine;

import interpreter.bytecode.*;

import java.util.ArrayList;
import java.util.HashMap;

public class Program {

    private ArrayList<ByteCode> program;
    private HashMap<String, Integer> addressMap = new HashMap<>();

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
    }
    public void resolveAddress() {
//        for(int i = 0; i < program.size(); i++){
//            ByteCode bc = program.get(i);
//            if (bc instanceof BranchCode){
//                BranchCode bcc = (BranchCode) bc;
//                bcc.setTargetAddress(addressMap.get(bcc.getLabel()));
//            }
//        }

        for (int i = 0; i < program.size(); i++) {
            ByteCode addressOne = program.get(i);

            if(addressOne instanceof GotoCode){
                addressMap.put(((GotoCode) addressOne).getLabel(), i);
            }

            if (addressOne instanceof LabelCode) {
                addressMap.put(((LabelCode) addressOne).getLabel(), i);
            }
        }

        for (int i = 0; i < program.size(); i++) {
            ByteCode addressTwo = program.get(i);

            if (addressTwo instanceof FalseBranchCode) {
                if (addressMap.containsKey(((FalseBranchCode) addressTwo).getLabel())) {
                    FalseBranchCode FBC = (FalseBranchCode) addressTwo;
                    FBC.setTargetAddress(addressMap.get(FBC.getLabel()));
                }
            }

            if (addressTwo instanceof GotoCode) {
                if (addressMap.containsKey(((GotoCode) addressTwo).getLabel())) {
                    GotoCode GTC = (GotoCode) addressTwo;
                    GTC.setTargetAddress(addressMap.get(GTC.getLabel()));
                }
            }

            if (addressTwo instanceof CallCode) {
                if (addressMap.containsKey(((CallCode) addressTwo).getLabel())) {
                    CallCode CC = (CallCode) addressTwo;
                    CC.setTargetAddress(addressMap.get(CC.getLabel()));
                }

            }
        }
    }
}