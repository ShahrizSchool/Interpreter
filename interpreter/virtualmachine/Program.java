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

        for(int i = 0; i < program.size(); i++){
            ByteCode bc = program.get(i);
            if(bc instanceof GotoCode){
                addressMap.put(((GotoCode) bc).getLabel(), i);
            }
            if(bc instanceof LabelCode){
                LabelCode code = (LabelCode) program.get(i);
                addressMap.put(code.getLabel(), i);
            }
        }

        for (int i = 0; i < program.size(); i++) {
            ByteCode bc = program.get(i);
            if (bc instanceof BranchCode) {
                    BranchCode bcc = (BranchCode) bc;
                    bcc.setTargetAddress(addressMap.get(bcc.getLabel()));

            }
        }

//        for(int i = 0; i < program.size(); i++){
//            ByteCode bc = program.get(i);
//            if (bc instanceof FalseBranchCode) {
//                FalseBranchCode fbc = (FalseBranchCode) bc;
//                fbc.setTargetAddress(addressMap.get(fbc.getLabel()));
//            } else if (bc instanceof  CallCode) {
//                CallCode cc = (CallCode) bc;
//                cc.setTargetAddress(addressMap.get(cc.getLabel()));
//            } else if (bc instanceof  GotoCode) {
//                GotoCode gtc = (GotoCode) bc;
//                gtc.setTargetAddress(addressMap.get(gtc.getLabel()));
//            }
//        }
    }
}