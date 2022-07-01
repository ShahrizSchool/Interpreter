package interpreter;

import interpreter.bytecode.ByteCode;
import interpreter.virtualmachine.Program;
import interpreter.virtualmachine.VirtualMachine;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.StringTokenizer;


public final class ByteCodeLoader {

    private BufferedReader byteSource;
    private StringTokenizer tok;

    /**
     * Constructor Simply creates a buffered reader.
     * YOU ARE NOT ALLOWED TO READ FILE CONTENTS HERE
     * THIS NEEDS TO HAPPEN IN loadCodes.
     */
    public ByteCodeLoader(String file) throws IOException {
        this.byteSource = new BufferedReader(new FileReader(file));
    }
    /**
     * This function should read one line of source code at a time.
     * For each read line:
     *      Tokenize string to break it into parts. Can also use the split function in the String class.
     *      Grab THE correct class name for the given ByteCode from CodeTable
     *      Create an instance of the ByteCode class name returned from code table.
     *      Parse any additional arguments for the given ByteCode and send them to
     *      the newly created ByteCode instance via the init function.
     *      Then add newly created and initialize ByteCode to the program
     */
    public Program loadCodes()  {
        String line;
        String[] items;
        String byteCodeName; //Byte code name from .x.cod file
        String className; // class name after it's mapped from name in source code to class name.
        Class classBlueprint;
        ArrayList<String> args = new ArrayList<>();
        Program program = new Program();
        ByteCode bc;

        try {
            while (this.byteSource.ready()) {
                line = this.byteSource.readLine();
                items = line.split("\\s+");
                byteCodeName = items[0];
                className = CodeTable.getClassName(byteCodeName);
//                System.out.println(" Class name: " + className);
//                System.out.println(" ByteCode Name: " + byteCodeName);
                classBlueprint = Class.forName("interpreter.bytecode." + className);

                bc = (ByteCode) classBlueprint.getDeclaredConstructor().newInstance();
//                System.out.println(bc);

                for (int i = 1; i < items.length; i++){
                    args.add(items[i]);
                }

                bc.init(args);
                program.add(bc);
                args.clear();
            }
        } catch(IOException ex){
            System.out.println("Load Codes error");
            System.out.println(ex);
            System.exit(255);
        } catch (ClassNotFoundException ex){
            System.out.println("class not found error");
            System.out.println(ex);
            System.exit(255);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
        program.resolveAddress();
        return program;
    }
}
