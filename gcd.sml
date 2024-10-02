101007    // Read the first number into memory[0007]
101008    // Read the second number into memory[0008]
201007    // Load the first number into the accumulator
311008    // Subtract the second number
410013    // If accumulator is negative, branch to line 13 (swap)
420015    // If accumulator is zero, branch to line 15 (halt with GCD)
200008    // Load the second number into the accumulator
310007    // Subtract the first number
400003    // Branch back to line 3 to repeat the process
210007    // Store the second number in memory[0007]
200008    // Load the second number into the accumulator
210008    // Store it in memory[0008] (swap)
400002    // Branch back to line 2 to continue
110007    // Output the GCD stored in memory[0007]
430000    // Halt (GO)