import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class MorseCode {
    private static final List<Character> Letters = Arrays.asList('A','B','C','D','E','F','G','H','I','J','K','L','M','N',
            'O','P','Q','R','S','T','U','V','W','X','Y','Z','1','2','3','4','5',
            '6','7','8','9','0');
    private static final List<String> Code = Arrays.asList(".-","-...","-.-.","-..",".","..-.","--.","....","..",".---",
            "-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",
            ".--","-..-","-.--","--..",".----","..---","...--","....-",".....","-....",
            "--...","---..","----.","-----");

    public static void main(String[] args) {
        if(args.length==0 || args[0].equals("-h") || args[0].equals("--help")){
            DisplayHelp();
        }
        if (args[0].equals("-r")){
            MorseToEnglish(args);
        }
        EnglishToMorse(args);
    }
    private static void DisplayHelp(){
        System.out.println("\t\tMorse Code Generator!\n\nusage: java MorseCode <input>\n\n" +
                            "Example: java MorseCode hello or java MorseCode \"Help Me\"\n\n" +
                            "Options: -h\thelp\n         -r\tmorsecode to english\n\n"+
                            "NOTE: in this program the white spaces (' ') are converted as '/' and vice versa.");
        System.exit(0);
    }
    private static void EnglishToMorse(String[] EnglishInput){
        HashMap<Character,String> morsecode = new HashMap<>();
        for(int i=0;i<Letters.size();i++) {
            morsecode.put(Letters.get(i), Code.get(i));
        }
        for (String s : EnglishInput) {
            char[] input = s.toUpperCase().toCharArray();
            StringBuilder output = new StringBuilder();
            for (char letter : input) {
                if (letter == ' ') {
                    output.append("/ ");
                    continue;
                }
                if (morsecode.get(letter) == null){
                    System.out.println("invalid input");
                    System.exit(0);
                }
                output.append(morsecode.get(letter)).append(" ");
            }
            System.out.println(output);
        }
        System.exit(0);
    }
    private static void MorseToEnglish(String[] MorseInput){
        HashMap<String,Character> englishletter = new HashMap<>();
        for(int i=0;i<Letters.size();i++) {
            englishletter.put(Code.get(i), Letters.get(i));
        }
        for (int i=1;i<MorseInput.length;i++) {
            String[] code = MorseInput[i].split(" ");
            StringBuilder output = new StringBuilder();
            for (String input:
                 code) {
                if (input.equals("/")){
                    output.append(" ");
                    continue;
                }
                if (englishletter.get(input) == null){
                    System.out.println("invalid input");
                    System.exit(0);
                }
                output.append(englishletter.get(input));
            }
            System.out.println(output);
        }
        System.exit(0);
    }
}
