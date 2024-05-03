import java.util.HashMap;
import java.util.Scanner;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection
;


public class codigomorse {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("klk vamo a encripta");
        String original = scanner.nextLine();
        System.out.println("a q lo vamo a traduci: 1. Morse Code 2.(A1Z26) 3. Polar Cenit");
        int idioma = scanner.nextInt();
        String encriptado = "";
        switch (idioma) {
            case 1: encriptado = ponloenmorse(original); break;
            case 2: encriptado = ponloenA1Z26(original); break;
            case 3: encriptado = ponloenPolar(original); break;
            default: System.out.println("ponlo bien rm");
        }
        copipeist(encriptado);
        System.out.println("ta copiao ya patron nama dele paste");
        scanner.close();
    }


    public static String ponloenmorse(String original) {
        HashMap<Character, String> mapamorse = new HashMap<>();
        mapamorse.put('A', ".-");
        mapamorse.put('B', "-...");
        mapamorse.put('C', "-.-.");
        mapamorse.put('D', "-..");
        mapamorse.put('E', ".");
        mapamorse.put('F', "..-.");
        mapamorse.put('G', "--.");
        mapamorse.put('H', "....");
        mapamorse.put('I', "..");
        mapamorse.put('J', ".---");
        mapamorse.put('K', "-.-");
        mapamorse.put('L', ".-..");
        mapamorse.put('M', "--");
        mapamorse.put('N', "-.");
        mapamorse.put('O', "---");
        mapamorse.put('P', ".--.");
        mapamorse.put('Q', "--.-");
        mapamorse.put('R', ".-.");
        mapamorse.put('S', "...");
        mapamorse.put('T', "-");
        mapamorse.put('U', "..-");
        mapamorse.put('V', "...-");
        mapamorse.put('W', ".--");
        mapamorse.put('X', "-..-");
        mapamorse.put('Y', "-.--");
        mapamorse.put('Z', "--..");
        mapamorse.put('1', ".----");
        mapamorse.put('2', "..---");
        mapamorse.put('3', "...--");
        mapamorse.put('4', "....-");
        mapamorse.put('5', ".....");
        mapamorse.put('6', "-....");
        mapamorse.put('7', "--...");
        mapamorse.put('8', "---..");
        mapamorse.put('9', "----.");
        mapamorse.put('0', "-----");


        StringBuilder morsemangao = new StringBuilder();
        for (char c : original.toUpperCase().toCharArray()) {
            if (c == ' ') {
                morsemangao.append("// ");
            } else {
                String morse = mapamorse.getOrDefault(c, "");
                morsemangao.append(morse).append(" ");
            }
        }
        return morsemangao.toString();
    }


    public static String ponloenA1Z26(String original) {
        StringBuilder a1z26mangao = new StringBuilder();
        for (char c : original.toUpperCase().toCharArray())
            a1z26mangao.append(c == ' ' ? " " : (c - 'A' + 1) + " "); // 20 mins en esa linea
        return a1z26mangao.toString().trim();
    }


    public static String ponloenPolar(String original) {
        HashMap<Character, Character> mapapolar = new HashMap<>();
        mapapolar.put('P', 'C');
        mapapolar.put('O', 'E');
        mapapolar.put('L', 'N');
        mapapolar.put('A', 'I');
        mapapolar.put('R', 'T');
        mapapolar.put('C', 'P');
        mapapolar.put('E', 'O');
        mapapolar.put('N', 'L');
        mapapolar.put('I', 'A');
        mapapolar.put('T', 'R');
        StringBuilder polarmangao = new StringBuilder();
        for (char c : original.toUpperCase().toCharArray())
            polarmangao.append(mapapolar.getOrDefault(c, c));
        return polarmangao.toString();
    }


    public static void copipeist(String text) {
        try {
            java.awt.datatransfer.Clipboard clipboard = java.awt.Toolkit.getDefaultToolkit().getSystemClipboard();
            java.awt.datatransfer.StringSelection selection = new java.awt.datatransfer.StringSelection(text);
            clipboard.setContents(selection, selection);
        } catch (Exception e) {
            System.out.println("se copio mal " + e.getMessage());
        }
    }
}




