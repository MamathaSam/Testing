package RandomDataGenerator;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class TestDataGenerator_Demo {
	private static final int MIN_WORDS_PER_LINE = 9;
    private static final int MAX_WORDS_PER_LINE = 19;
    private static final int MIN_WORD_LENGTH = 6;
    private static final int MAX_WORD_LENGTH = 15;
   
    public static void main(String[] args) throws IOException {
	        String filePath = "src/test/java/" + "Test File Finance.txt";
	        int count=0;
	    	int Num_lines=155;
	        int financeWordIndex = new Random().nextInt(MAX_WORDS_PER_LINE - MIN_WORDS_PER_LINE + 1) + MIN_WORDS_PER_LINE - 1;
	        int financeWordIndex2 = new Random().nextInt(145 - 6 + 1) + 6;
	        int financeWordIndex3 = new Random().nextInt(145 - 6 + 1) + 6;

	        BufferedWriter writer = new BufferedWriter(new FileWriter(filePath));
	        for (int i = 0; i < Num_lines; i++) {
	            String line = generateLine(i, financeWordIndex, financeWordIndex2, financeWordIndex3);
	            writer.write(line);
	            writer.newLine();
	            count++;     
	        }
	        // End of the File
	        writer.write("<EOF>");
	        count = count+1;
	        writer.close();
	        System.out.println("Number of lines in file : " + count);
	        System.out.println("File generated successfully");
	    }
	    private static String generateLine(int lineIndex, int financeWordIndex, int financeWordIndex2, int financeWordIndex3) {
	        StringBuilder lineBuilder = new StringBuilder();
	        Random random = new Random();
	        int numWords = new Random().nextInt(MAX_WORDS_PER_LINE - MIN_WORDS_PER_LINE + 1) + MIN_WORDS_PER_LINE;
	        for (int i = 0; i < numWords; i++) {
	            String word = generateWord(i == 0,random);
	            if (lineIndex == financeWordIndex && i == numWords - 1) {
	                word = "Finance";
	            } else if (lineIndex == financeWordIndex2 && i == numWords - 1) {
	                word = "finance";
	            } else if (lineIndex == financeWordIndex3 && i == numWords - 1) {
	                word = "finance";
	            }
	            lineBuilder.append(word).append(" ");
	        }
	        if(lineIndex==0) {
		        System.out.println("Number of words for first line : " + numWords);
                }
	        return lineBuilder.toString().trim();
	    }

	    private static String generateWord(boolean isFirstWord,Random random) {
	        int wordLength = new Random().nextInt(MAX_WORD_LENGTH - MIN_WORD_LENGTH + 1) + MIN_WORD_LENGTH;
	        StringBuilder wordBuilder = new StringBuilder();
	        //Generate Random word
	        for (int i = 0; i < wordLength; i++) {
	            char c = (char) (random.nextInt(26) + 'a');
	         // capitalize first word in sentence
	            if (i == 0 && isFirstWord) {
	                c = Character.toUpperCase(c);
	            }
	            wordBuilder.append(c);
	        }
	        return wordBuilder.toString();
	    }


}
