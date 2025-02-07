
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

class TrieNode {
      Map<Character, TrieNode> children;
      boolean isEndOfWord;

      public TrieNode() {
            children = new HashMap<>();
            isEndOfWord = false;
      }
}

class Trie {
      private TrieNode root;

      public Trie() {
            root = new TrieNode();
      }

      public void insert(String word) {
            TrieNode node = root;
            for (char c : word.toCharArray()) {
                  node.children.putIfAbsent(c, new TrieNode());
                  node = node.children.get(c);
            }
            node.isEndOfWord = true;
      }

      public boolean search(String word) {
            TrieNode node = root;
            for (char c : word.toCharArray()) {
                  node = node.children.get(c);
                  if (node == null) {
                        return false;
                  }
            }
            return node.isEndOfWord;
      }

      public List<String> getPrefixes(String word) {
            List<String> prefixes = new ArrayList<>();
            TrieNode node = root;
            StringBuilder prefix = new StringBuilder();

            for (char c : word.toCharArray()) {
                  node = node.children.get(c);
                  if (node == null) {
                        break;
                  }
                  prefix.append(c);
                  if (node.isEndOfWord) {
                        prefixes.add(prefix.toString());
                  }
            }
            return prefixes;
      }

      public List<String> collectWords() {
            List<String> words = new ArrayList<>();
            collectWords(root, "", words);
            return words;
      }

      private void collectWords(TrieNode node, String prefix, List<String> words) {
            if (node.isEndOfWord) {
                  words.add(prefix);
            }
            for (Map.Entry<Character, TrieNode> entry : node.children.entrySet()) {
                  collectWords(entry.getValue(), prefix + entry.getKey(), words);
            }
      }
}

class Pair {
      String word, suffix;

      public Pair(String word, String suffix) {
            this.word = word;
            this.suffix = suffix;
      }
}

public class Solution {
      private Trie trie;

      public Solution() {
            trie = new Trie();
      }

      public void buildTrie(String filePath) {
            try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
                  String word;
                  while ((word = br.readLine()) != null) {
                        word = word.trim();
                        trie.insert(word); // Insert all words into the Trie
                  }
            } catch (IOException e) {
                  System.out.println("Error reading file: " + e.getMessage());
                  System.exit(1);
            }
      }

      public List<String> findAllCompoundWords() {
            List<String> compoundWords = new ArrayList<>();
            for (String word : trie.collectWords()) {
                  if (isCompoundWord(word)) {
                        compoundWords.add(word);
                  }
            }
            return compoundWords;
      }

      private boolean isCompoundWord(String word) {
            for (String prefix : trie.getPrefixes(word)) {
                  String suffix = word.substring(prefix.length());
                  if (trie.search(suffix) || isCompoundWord(suffix)) {
                        return true;
                  }
            }
            return false;
      }

      public static void main(String[] args) {
            Solution sol1 = new Solution();
            Solution sol2 = new Solution();

            String filePath1 = "C:\\TId\\Input_01.txt";
            String filePath2 = "C:\\TId\\Input_02.txt";

            Thread thread1 = new Thread(() -> {
                  long startTime = System.currentTimeMillis();
                  sol1.buildTrie(filePath1);
                  List<String> compoundWords1 = sol1.findAllCompoundWords();
                  long endTime = System.currentTimeMillis();
                  System.out.println("Compound Words Found in Input_01.txt: " + compoundWords1);
                  System.out.println("Time taken for Input_01.txt: " + (endTime - startTime) + " ms");
            });
            Thread thread2 = new Thread(() -> {
                  long startTime = System.currentTimeMillis();
                  sol2.buildTrie(filePath2);
                  List<String> compoundWords2 = sol2.findAllCompoundWords();
                  long endTime = System.currentTimeMillis();
                  System.out.println("Compound Words Found in Input_02.txt: " + compoundWords2);
                  System.out.println("Time taken for Input_02.txt: " + (endTime - startTime) + " ms");
            });

            thread1.start();
            thread2.start();

            try {
                  thread1.join();
                  thread2.join();
            } catch (InterruptedException e) {
                  e.printStackTrace();
            }
      }
}
