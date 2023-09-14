package org.example;

// Streams and Readers
import java.io.*;

// File and Path
import java.nio.file.Path;
import java.nio.file.Files;

// Both Methods!

import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    static String fileName = "inputStream.txt";
    static String outputFileName = "outputFile.txt";
    static ArrayList<String> itemList = new ArrayList<>(Arrays.asList("Milk","Cheese","Eggs"));

    public static void main(String[] args) {
        try {
            writeToFileStreaming(outputFileName, itemList);
//            readFromFileStreamingNoHeader(fileName);
//            String outputString = readFromFile(fileName);
//            System.out.println(outputString);
//
//            String inputString = "I updated the file using writeToFile()!";
//            writeToFile(fileName, inputString); // arguments // call,execute,invoke,run
//            System.out.println("Wrote: '" + inputString + "' to file!");

        }
        catch (IOException e){
            System.out.println(e);
        }

        /*
        File Operation Classes
        Path: pwd, outputs a path of a file
        Files: A class which contains functions for operating on files
        Relative Pathing: Referencing a path based on where you are currently navigating

        Reading a File
        1. Import the necessary libraries
        2. Create a Path
        3. Read from the file
        4. Create a method

        Streams and Readers Method
        1. Import the libraries
        2. Create a FileInputStream
        3. Create a InputStreamReader
        4. Create a BufferedReader which uses the InputStreamReader
        5. Read from the file line-by-line using BufferedReader
        6. Close the FileInputStream when done
         */
    }

    public static String readFromFile(String fileName) throws IOException {
        // FileNotFoundException: When given path does not match a file on your computer
        // IOException: General exception for errors during read/write
        Path filePath = Path.of(fileName);
        return Files.readString(filePath);
    }

    public static void writeToFile(String fileName, String content) throws IOException { // parameters
        Path filePath = Path.of(fileName);
        Files.writeString(filePath, content);
    }

    public static void readFromFileStreaming(String fileName) throws IOException {
        FileInputStream inputStream = new FileInputStream(fileName); // ByteStream
        InputStreamReader inputReader = new InputStreamReader(inputStream);
        BufferedReader bReader = new BufferedReader(inputReader);

        String line;
        while ((line = bReader.readLine()) != null) {
            System.out.println(line);
        }

        inputStream.close(); // We must close the stream!
    }

    /* Writing to a file using Streams
    1. Import Libraries
    2. Create a FileWriter object using the file name
    3. Create a BufferedWriter which uses the FileWriter
    4. Write to the file using BufferedWriter
    5. Close the FileWriter by closing the BufferedWriter
        calling .close() // kinda like a save method
     */

    public static void writeToFileStreaming(String fileName, ArrayList<String> contentList) throws IOException {
        // Create our I/O Objects
        FileWriter fileWriter = new FileWriter(fileName, true);
        BufferedWriter bWriter = new BufferedWriter(fileWriter);

        for (int i=0; i < contentList.size(); i++) {
            // Write
            bWriter.write(contentList.get(i));
            // Write a newline character to separate our data
            bWriter.write("\n"); // LF style line separator
        }
        // Always close the file // ABC Always Be Closing!
        bWriter.close();

        /*
        If the file doesn't exist, it will be created (As long as you have access to the directory)
        If the file exists, by default content will be overwritten!
         */

    }

    public static void readFromFileStreamingNoHeader(String fileName) throws IOException {
        // Declare data types and variables for operation
        ArrayList<String> contentList = new ArrayList<>();
        String contentLine;
        String header;

        // Open our fileInputStream
        FileInputStream inputStream = new FileInputStream(fileName); // ByteStream
        InputStreamReader inputReader = new InputStreamReader(inputStream);
        BufferedReader bReader = new BufferedReader(inputReader);

        // Read and discard header
        header = bReader.readLine();

        // Read the rest of the file
        while ((contentLine = bReader.readLine()) != null) {
            contentList.add(contentLine);
        }

        // Display menuList
        System.out.println(contentList);

        // Always have to close our stream
        inputStream.close();

    }
}