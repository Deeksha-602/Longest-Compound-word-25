### Compound Word Detection Using Trie (Java Implementation)

# Problem Statement
This program detects compound words from a given input file. A compound word is formed by concatenating two or more valid words from the file. The input file contains one word per line, sorted in alphabetical order.

# Algorithm
• Efficient Trie Construction: Read words from the file and insert them into a Trie for optimized lookup and prefix matching.
• Prefix and Suffix Validation: Extract valid prefixes of each word, check for corresponding suffixes, and determine if the word is a compound word.
• Optimized Multi-threading: Utilize parallel processing to handle multiple input files concurrently, improving efficiency and reducing execution time.
• Identification of Longest Compound Words: Analyze all compound words found and determine the longest and second-longest ones for better insights.

# Code Execution
# Requirements  : Java 8+ installed on your system.

# Execution Steps
• Clone or download the repository.
• Ensure that your input files (Input_01.txt, Input_02.txt) are placed in the correct directory.
• Modify the file paths in Solution.java.
  String filePath1 = "C:\\TId\\Input_01.txt";
  String filePath2 = "C:\\TId\\Input_02.txt";
• Compile and run the program using the command
• The program will output the compound words found in each file along with the execution time.

# Features
✅ Efficient Trie-based implementation
✅ Multi-threaded execution for faster processing
✅ Scalability for large input files
✅ Easily customizable file paths

# Result
Output for File: Input_01.txt
![Output Screenshot](images/output.png)

Output for File: Input_02.txt
