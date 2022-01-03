package huffman;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Collections;

/**
 * This class contains methods which, when used together, perform the
 * entire Huffman Coding encoding and decoding process
 * 
 * @author Ishaan Ivaturi
 * @author Prince Rawal
 */
public class HuffmanCoding {
    /**
     * Writes a given string of 1's and 0's to the given file byte by byte
     * and NOT as characters of 1 and 0 which take up 8 bits each
     * 
     * @param filename The file to write to (doesn't need to exist yet)
     * @param bitString The string of 1's and 0's to write to the file in bits
     */
    public static void writeBitString(String filename, String bitString) {
        byte[] bytes = new byte[bitString.length() / 8 + 1];
        int bytesIndex = 0, byteIndex = 0, currentByte = 0;

        // Pad the string with initial zeroes and then a one in order to bring
        // its length to a multiple of 8. When reading, the 1 signifies the
        // end of padding.
        int padding = 8 - (bitString.length() % 8);
        String pad = "";
        for (int i = 0; i < padding-1; i++) pad = pad + "0";
        pad = pad + "1";
        bitString = pad + bitString;

        // For every bit, add it to the right spot in the corresponding byte,
        // and store bytes in the array when finished
        for (char c : bitString.toCharArray()) {
            if (c != '1' && c != '0') {
                System.out.println("Invalid characters in bitstring");
                System.exit(1);
            }

            if (c == '1') currentByte += 1 << (7-byteIndex);
            byteIndex++;
            
            if (byteIndex == 8) {
                bytes[bytesIndex] = (byte) currentByte;
                bytesIndex++;
                currentByte = 0;
                byteIndex = 0;
            }
        }
        
        // Write the array of bytes to the provided file
        try {
            FileOutputStream out = new FileOutputStream(filename);
            out.write(bytes);
            out.close();
        }
        catch(Exception e) {
            System.err.println("Error when writing to file!");
        }
    }
    
    /**
     * Reads a given file byte by byte, and returns a string of 1's and 0's
     * representing the bits in the file
     * 
     * @param filename The encoded file to read from
     * @return String of 1's and 0's representing the bits in the file
     */
    public static String readBitString(String filename) {
        String bitString = "";
        
        try {
            FileInputStream in = new FileInputStream(filename);
            File file = new File(filename);

            byte bytes[] = new byte[(int) file.length()];
            in.read(bytes);
            in.close();
            
            // For each byte read, convert it to a binary string of length 8 and add it
            // to the bit string
            for (byte b : bytes) {
                bitString = bitString + 
                String.format("%8s", Integer.toBinaryString(b & 0xFF)).replace(' ', '0');
            }

            // Detect the first 1 signifying the end of padding, then remove the first few
            // characters, including the 1
            for (int i = 0; i < 8; i++) {
                if (bitString.charAt(i) == '1') return bitString.substring(i+1);
            }
            
            return bitString.substring(8);
        }
        catch(Exception e) {
            System.out.println("Error while reading file!");
            return "";
        }
    }

    /**
     * Reads a given text file character by character, and returns an arraylist
     * of CharFreq objects with frequency > 0, sorted by frequency
     * 
     * @param filename The text file to read from
     * @return Arraylist of CharFreq objects, sorted by frequency
     */
    public static ArrayList<CharFreq> makeSortedList(String filename) {
        StdIn.setFile(filename);
        /* Your code goes here */

        //Count the number of chars in the input file
        double count = 0;

        ArrayList<CharFreq> list = new ArrayList<CharFreq>();
        int[] freq = new int[128];
        char c;
        //Reading through each char in the input file
        while(StdIn.hasNextChar()){
            c = StdIn.readChar();
            count++;
            //Updates the number of times a char appears in the list
            freq[c]++;
        }

        double probOcc = 0;
        for(int i = 0; i < freq.length; i++){
            if(freq[i] != 0){
                probOcc = freq[i]/count;
                list.add(new CharFreq((char)i, probOcc));
            }
        }

        //If there is only one distinct value
        if(list.size() == 1){
            if(list.get(0).getCharacter().charValue() == 127){
                list.add(new CharFreq((char)0, 0));
            } else {
                list.add(new CharFreq((char)(list.get(0).getCharacter().charValue() + 1), 0));
            }
        }
        Collections.sort(list);
        return list; 
    }

    /**
     * Uses a given sorted arraylist of CharFreq objects to build a huffman coding tree
     * 
     * @param sortedList The arraylist of CharFreq objects to build the tree from
     * @return A TreeNode representing the root of the huffman coding tree
     */
    public static TreeNode makeTree(ArrayList<CharFreq> sortedList) {
        /* Your code goes here */

        Queue<TreeNode> source = new Queue<TreeNode>();
        Queue<TreeNode> target = new Queue<TreeNode>();


        //Adding treeNodes in ascending order using the sortedList param
        TreeNode temp;
        for(int i = 0; i < sortedList.size(); i++){
            temp = new TreeNode();
            temp.setData(sortedList.get(i));
            source.enqueue(temp);
        }   


        /**
         * Continue here
         **/

        TreeNode left = source.dequeue();
        TreeNode right = source.dequeue();

        //Adding the first node into the target queue
        temp = new TreeNode();
        temp.setData(new CharFreq(null, left.getData().getProbOccurrence() + right.getData().getProbOccurrence()));
        temp.setLeft(left);
        temp.setRight(right);
        target.enqueue(temp);

        while(target.size() != 1 || !source.isEmpty()){ //might have to add the target.size() == 1
            //source.size() != 0 could be a redudent check
            if(source.size() != 0 && source.peek().getData().getProbOccurrence() <= target.peek().getData().getProbOccurrence()){
                left = source.dequeue();
            } else {
                left = target.dequeue();
            }

            if(source.size() != 0 && (target.size() == 0 || source.peek().getData().getProbOccurrence() <= target.peek().getData().getProbOccurrence())){
                right = source.dequeue();
            } else {
                right = target.dequeue();
            }

           //Adding new TreeNode into the target queue
           temp = new TreeNode();
           temp.setData(new CharFreq(null, left.getData().getProbOccurrence() + right.getData().getProbOccurrence()));
           temp.setLeft(left);
           temp.setRight(right);
           target.enqueue(temp);
        }

        return target.dequeue(); 
    }

    /**
     * Uses a given huffman coding tree to create a string array of size 128, where each
     * index in the array contains that ASCII character's bitstring encoding. Characters not
     * present in the huffman coding tree should have their spots in the array left null
     * 
     * @param root The root of the given huffman coding tree
     * @return Array of strings containing only 1's and 0's representing character encodings
     */
    public static String[] makeEncodings(TreeNode root) {
        /* Your code goes here */
        String[] encoding = new String[128];
        traverse(root, "", encoding);
        return encoding; // Delete this line
    }
    
    private static void traverse(TreeNode root, String bitString, String[] encoding){
        if(root == null) { //base case
            return;
        }
        if(root.getLeft() == null && root.getRight() == null){
            encoding[root.getData().getCharacter().charValue()] = bitString;
        }
        traverse(root.getLeft(), bitString + "0", encoding);
        traverse(root.getRight(), bitString + "1", encoding);

    }

    /**
     * Using a given string array of encodings, a given text file, and a file name to encode into,
     * this method makes use of the writeBitString method to write the final encoding of 1's and
     * 0's to the encoded file.
     * 
     * @param encodings The array containing binary string encodings for each ASCII character
     * @param textFile The text file which is to be encoded
     * @param encodedFile The file name into which the text file is to be encoded
     */
    public static void encodeFromArray(String[] encodings, String textFile, String encodedFile) {
        StdIn.setFile(textFile);
        String bitString = "";
        while(StdIn.hasNextChar()){
            bitString += encodings[StdIn.readChar()];
            
        }
        writeBitString(encodedFile, bitString);
        
    }
    
    /**
     * Using a given encoded file name and a huffman coding tree, this method makes use of the 
     * readBitString method to convert the file into a bit string, then decodes the bit string
     * using the tree, and writes it to a file.
     * 
     * @param encodedFile The file which contains the encoded text we want to decode
     * @param root The root of your Huffman Coding tree
     * @param decodedFile The file which you want to decode into
     */
    public static void decode(String encodedFile, TreeNode root, String decodedFile) {
        System.out.println(encodedFile.length());
        StdOut.setFile(decodedFile);
        /* Your code goes here */
        String bitString = readBitString(encodedFile);
        System.out.println(bitString);
        TreeNode temp = root;
        char c;
        String decodedStr = "";
        for(int i = 0; i < bitString.length(); i++){
            c = bitString.charAt(i);
            if(c == '1'){
                temp = temp.getRight();
            } else {
                temp = temp.getLeft();
            }

            if(temp.getRight() == null && temp.getLeft() == null){
                decodedStr += temp.getData().getCharacter();
                temp = root;
            }
            
        }
        StdOut.print(decodedStr);

    }
}
