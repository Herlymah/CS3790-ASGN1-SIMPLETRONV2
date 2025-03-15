Name : Halimah Abdulrasheed
Title : SimpletronV2 Simulator
Instructor : Franco Carlacci

Description:

SimpletronV2 is a Java-based (SML) simulator that emulates a simple machine with 10,000 words
of memory and a variety of operations. It stimulates a primitive computer system that can 
load and execute programs written in Simpletron Machine Language (SML). The Simulator
can read input from both the keyboard and from a file, allowing you to load, execute and interact 
with SML programs.

Implementation: 

To compile,type and run the following command in the terminal "javac SimpletronV2.java"
To Run, type and run the following command in the terminal "java SimpletronV2"

After launching the program, the simulator will prompt you to either load a 
program from a file or enter it manually.

To load from a file, type "Y" when prompted and provide the filename (.sml file).
To enter manually, type "N" and input each instruction one by one, ending with the keyword "GO"

Once the program is loaded, the simulator will automatically execute the instructions in memory.

Instruction Format:
Each instruction is a 4-digit number:
- First two digits: Operation code
- Last two digits: Operand (memory address)


EXAMPLE RUN: 
*** Welcome to Simpletron V2! ***
***
Do you have a file that contains your SML program (Y/N) ? 
y
Enter the filename:gcd.sml
Executing instruction: 101007, operationCode: 10, Operand: 1007
Enter an integer: 12
Executing instruction: 000000, operationCode: 0, Operand: 0
*** Invalid operation code encountered ***

PAGE #00


 REGISTERS :
accumulator         000000
InstructionCounter  000001
IndexRegister       000000
operationCode       000000
operand             000000

 MEMORY %n
          0       1        2       3       4       5       6       7       8       9
  0 101007 000000 000000 000000 000000 000000 000000 000000 000000 000000
 10 000000 000000 000000 000000 000000 000000 000000 000000 000000 000000
 20 000000 000000 000000 000000 000000 000000 000000 000000 000000 000000 
 30 000000 000000 000000 000000 000000 000000 000000 000000 000000 000000
 40 000000 000000 000000 000000 000000 000000 000000 000000 000000 000000
 50 000000 000000 000000 000000 000000 000000 000000 000000 000000 000000
 60 000000 000000 000000 000000 000000 000000 000000 000000 000000 000000 
 70 000000 000000 000000 000000 000000 000000 000000 000000 000000 000000
 80 000000 000000 000000 000000 000000 000000 000000 000000 000000 000000 
 90 000000 000000 000000 000000 000000 000000 000000 000000 000000 000000

PAGE #01


 REGISTERS :
accumulator         000000
InstructionCounter  000001
IndexRegister       000000
operationCode       000000
operand             000000
 MEMORY %n
          0       1        2       3       4       5       6       7       8       9
 10 000000 000000 000000 000000 000000 000000 000000 000000 000000 000000
 20 000000 000000 000000 000000 000000 000000 000000 000000 000000 000000
 30 000000 000000 000000 000000 000000 000000 000000 000000 000000 000000
 40 000000 000000 000000 000000 000000 000000 000000 000000 000000 000000
 50 000000 000000 000000 000000 000000 000000 000000 000000 000000 000000
 60 000000 000000 000000 000000 000000 000000 000000 000000 000000 000000
 70 000000 000000 000000 000000 000000 000000 000000 000000 000000 000000
 80 000000 000000 000000 000000 000000 000000 000000 000000 000000 000000
 90 000000 000000 000000 000000 000000 000000 000000 000000 000000 000000
PS C:\Users\HALIMA\OneDrive - Northwestern Polytechnic\Documents\NWP\FALL 2024\CS3790\LABS\LAB 1> ^C
PS C:\Users\HALIMA\OneDrive - Northwestern Polytechnic\Documents\NWP\FALL 2024\CS3790\LABS\LAB 1>
PS C:\Users\HALIMA\OneDrive - Northwestern Polytechnic\Documents\NWP\FALL 2024\CS3790\LABS\LAB 1>  c:; cd 'c:\Users\HALIMA\OneDrive - Northwestern Polytechnic\Documents\NWP\FALL 2024\CS3790\LABS\LAB 1'; & 'C:\Program Files\Java\jdk-21\bin\java.exe' '-XX:+ShowCodeDetailsInExceptionMessages' '-cp' 'C:\Users\HALIMA\AppData\Roaming\Code\User\workspaceStorage\c61dda60437a052f59e66fc393c68ea1\redhat.java\jdt_ws\LAB 1_31bc69d\bin' 'SimpletronV2' 
*** Welcome to Simpletron V2! ***
***
Do you have a file that contains your SML program (Y/N) ? 
n
*** Please enter your program one instruction (or data word) at a time       ***
*** I will type the location number and a question mark (?). You then        ***
*** type the word for that locatio. Type the word GO to execute your program ***
00 ? 200009
01 ? 300009
02 ? 250009
03 ? 110009
04 ? 450000
05 ? go
Executing instruction: 200009, operationCode: 20, Operand: 9
Executing instruction: 300009, operationCode: 30, Operand: 9
Executing instruction: 250009, operationCode: 25, Operand: 9
Executing instruction: 110009, operationCode: 11, Operand: 9
Output: 0
Executing instruction: 450000, operationCode: 45, Operand: 0
*** Simpletron execution terminated ***

PAGE #00


 REGISTERS :
accumulator         000000
InstructionCounter  000004
IndexRegister       000000
operationCode       450000
operand             450000

 MEMORY %n
          0       1        2       3       4       5       6       7       8       9
  0 200009 300009 250009 110009 450000 000000 000000 000000 000000 000000 
 10 000000 000000 000000 000000 000000 000000 000000 000000 000000 000000
 20 000000 000000 000000 000000 000000 000000 000000 000000 000000 000000
 30 000000 000000 000000 000000 000000 000000 000000 000000 000000 000000 
 40 000000 000000 000000 000000 000000 000000 000000 000000 000000 000000
 50 000000 000000 000000 000000 000000 000000 000000 000000 000000 000000
 60 000000 000000 000000 000000 000000 000000 000000 000000 000000 000000 
 70 000000 000000 000000 000000 000000 000000 000000 000000 000000 000000
 80 000000 000000 000000 000000 000000 000000 000000 000000 000000 000000
 90 000000 000000 000000 000000 000000 000000 000000 000000 000000 000000 
PS C:\Users\HALIMA\OneDrive - Northwestern Polytechnic\Documents\NWP\FALL 2024\CS3790\LABS\LAB 1> 
