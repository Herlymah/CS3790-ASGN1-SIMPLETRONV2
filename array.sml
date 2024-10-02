101009    // Read the size of the array into memory[0009]
201009    // Load the size of the array into the accumulator
310000    // Subtract 0 (check if the array has elements)
400015    // If size is 0, branch to line 15 (halt)
101000    // Read the first element into memory[0000]
201000    // Load the first element into the accumulator
211010    // Store as largest element in memory[0010]
211011    // Store as smallest element in memory[0011]

101100    // Read the next element into memory[0100] (array element)
201010    // Load the current largest element
311100    // Subtract the new element
410023    // If result is negative, branch to line 23 (update largest)
110010    // Output the largest element

201011    // Load the current smallest element
311100    // Subtract the new element
420026    // If result is positive, branch to line 26 (update smallest)

110011    // Output the smallest element
430000    // Halt (GO)

211010    // Store the new largest element in memory[0010]
400018    // Branch back to line 18 to process the next element

211011    // Store the new smallest element in memory[0011]
400018    // Branch back to line 18 to process the next element