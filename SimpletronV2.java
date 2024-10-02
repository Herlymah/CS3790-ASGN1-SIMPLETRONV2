import java.io.*;
import java.util.*;

public class SimpletronV2{

    public int[] memory = new int[10000]; //10000 words of memory
    public int pages = 100; //100 pages
    public int accumulator = 0;
    public int instructionCounter = 0;
    public int instructionRegister = 0;
    public int indexRegister = 0;


    public static void main(String[] args) throws IOException {
        SimpletronV2 simpletron = new SimpletronV2();
        Scanner input = new Scanner(System.in);

        System.out.println("*** Welcome to Simpletron V2! ***\n***");
        System.out.println("Do you have a file that contains your SML program (Y/N) ? ");

        String answer = input.next();

        input.nextLine();

        if(answer.equalsIgnoreCase("Y")){
            System.out.print("Enter the filename:");
            String filename = input.nextLine();
            simpletron.runFromFile(filename);
        } else simpletron.runFromKeyboard();

        simpletron.execute();

        //input.close();;

    }

    public void runFromFile(String filename) throws IOException{
        try{
            File myFile = new File(filename);
            Scanner input = new Scanner (myFile);
            int memoryIndex = 0;
            while(input.hasNextInt() && memoryIndex < pages) {
                int instruction = input.nextInt();
                if (instruction >= -9999999 && instruction <= 999999){
                    memory[memoryIndex++] = instruction;
                } else {
                    System.out.println("Invalid instruction range: " + instruction);
                }
            }
            input.close();
        }catch (FileNotFoundException e) {
            throw new IOException("File not found : " + e.getMessage());
        }
        
    }


    public void runFromKeyboard(){
        Scanner userInput = new Scanner(System.in);
        int memoryIndex = 0;

        System.out.println("*** Please enter your program one instruction (or data word) at a time       ***");
        System.out.println("*** I will type the location number and a question mark (?). You then        ***");
        System.out.println("*** type the word for that locatio. Type the word GO to execute your program ***");

        while (memoryIndex < pages){
            System.out.printf("%02d ? ", memoryIndex);
            String input = userInput.next();

            if (input.equalsIgnoreCase("go")){
                break;
            }

            try{
            int instruction = Integer.parseInt(input);
            if (instruction >= -999999 && instruction <=999999) {
                memory[memoryIndex++] = instruction;
            } else {
                System.out.println("Invalid instruction range.");
            }
        }  catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter a valid number or 'go' to execute the program. ");
        }
        } userInput.close();
    }

    public void execute(){
        boolean running = true;
        Scanner input = new Scanner(System.in);

        while (running){
            instructionRegister = memory[instructionCounter];
            int operationCode = Math.abs(instructionRegister)/10000;
            int operand = Math.abs(instructionRegister)%10000;

            System.out.printf("Executing instruction: %06d, operationCode: %d, Operand: %d%n", instructionRegister, operationCode, operand);

            //Exexuting instruction based on the operation code
            switch (operationCode){
                case 10: //read
                System.out.print("Enter an integer: ");
                int userInput = input.nextInt();
                memory[operand] = userInput;
                break;

                case 11: //write
                System.out.println("Output: " + memory[operand]);
                break;

                case 20: //load
                accumulator = memory[operand];
                break;

                case 21: //loadim
                accumulator = operand;
                break;

                case 22: //loadx
                indexRegister = memory[operand];
                break;

                case 25: //store
                memory[operand] = accumulator;
                break;

                case 26: //storeidx
                memory[indexRegister] = accumulator;
                break;

                case 30: //add
                accumulator += memory[operand];
                break;

                case 31: //addx
                accumulator += memory[indexRegister];
                break;

                case 32: //subtract
                accumulator -= memory[operand];
                break;

                case 33: //subtractx
                accumulator -= memory[indexRegister];
                break;

                case 34: //divide
                if(memory[operand] == 0){
                    handleDivisionbyZeroError();
                } else {
                    accumulator /= memory[operand];
                }
                break;

                case 35: //dividex
                if(memory[indexRegister] == 0){
                    handleDivisionbyZeroError();
                } else {
                    accumulator /= memory[indexRegister];
                }
                break;

                case 36: // multiply
                accumulator *= memory[operand];
                break;

                case 37: //multiplyx
                accumulator *= memory[instructionRegister];
                break;

                case 38: //inc
                indexRegister++;
                break;

                case 39: //dec
                indexRegister--;
                break;

                case 40: //branch
                instructionCounter = operand - 1;
                break;

                case 41: //branchneg
                if (accumulator < 0){
                    instructionCounter = operand - 1;
                }
                break;

                case 42: //branchzero
                if (accumulator == 0){
                    instructionCounter = operand - 1;
                }
                break;

                case 43: //swap
                int temp = accumulator;
                accumulator = indexRegister;
                indexRegister = temp;
                break;

                case 45: //halt
                System.out.println("*** Simpletron execution terminated ***");
                dumpCore(operand/100, operand%100);
                running = false;
                break;

                default:
                System.out.println("*** Invalid operation code encountered ***");
                dumpCore(0,1);
                running = false;
                break;

            }

            if (accumulator > 999999 || accumulator < -999999) {
                handleAccumulatorOverFlowError();
            }
            
            instructionCounter++;
        }

        input.close();
    }

    public void handleDivisionbyZeroError(){
        System.out.println("*** Attempt to divide by zero ***");
        dumpCore(0,5);
        System.exit(1);
    }

    public void handleAccumulatorOverFlowError(){
        System.out.println("*** Accumulator overflow ***");
        dumpCore(0,5);
        System.exit(1);
    }

    public void dumpCore (int startPage, int endPage){
        for (int page = startPage; page <= endPage; page++){

        System.out.printf("%nPAGE #%02d%n%n", page);

        System.out.println("\n REGISTERS : ");
        System.out.printf("accumulator         %06d%n", accumulator);
        System.out.printf("InstructionCounter  %06d%n", instructionCounter);
        System.out.printf("IndexRegister       %06d%n", indexRegister);
        System.out.printf("operationCode       %06d%n", Math.abs(instructionRegister));
        System.out.printf("operand             %06d%n", Math.abs(instructionRegister));
        
        System.out.println("\n MEMORY %n");
        System.out.println("          0       1        2       3       4       5       6       7       8       9");

        for (int i =0; i<10; i++){
            System.out.printf("%3d ", i*10);
            for (int j =0; j<10; j++){
                int address = startPage * pages + i * 10 + j;
                System.out.printf("%06d ", memory[address]);
            }
            System.out.println();
        
        }
    }
    }
}