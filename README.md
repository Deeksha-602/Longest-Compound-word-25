### Word Composition Problem Using Trie (Java Implementation)

# Problem Statement
The problem statement is available in the [Exercise Fresher Word Problem](https://github.com/Deeksha-602/Longest-Compound-word-25/blob/main/Exercise_Fresher_Word_Problem.pdf)file.


## Algorithm  

- **[1] Efficient Trie Construction:** Read words from the file and insert them into a Trie for optimized lookup and prefix matching.  
- **[2] Prefix and Suffix Validation:** Extract valid prefixes of each word, check for corresponding suffixes, and determine if the word is a compound word.  
- **[3] Optimized Multi-threading:** Utilize parallel processing to handle multiple input files concurrently, improving efficiency and reducing execution time.  
- **[4] Identification of Longest Compound Words:** Analyze all compound words found and determine the longest and second-longest ones for better insights.  

# Execution Steps

- Clone or download the repository.
- Ensure your input files (`Input_01.txt`, `Input_02.txt`) are placed in the correct directory.
- Modify the file paths in `Solution.java`:
  - `String filePath1 = "C:\\TId\\Input_01.txt";`
  - `String filePath2 = "C:\\TId\\Input_02.txt";`
- Compile and run the program using:
  - `javac Solution.java`
  - `java Solution`
- The program will output the compound words found in each file along with the execution time.

# Features

- ✅ Efficient Trie-based implementation
- ✅ Multi-threaded execution for faster processing
- ✅ Scalability for large input files
- ✅ Easily customizable file paths

# Result
Output for File: Input_01.txt
![Output Screenshot](https://github.com/Deeksha-602/Longest-Compound-word-25/blob/main/Input_01.txt.png)

Output for File: Input_02.txt

![Output Screenshot](https://github.com/Deeksha-602/Longest-Compound-word-25/blob/main/Input_02.txt.png)

