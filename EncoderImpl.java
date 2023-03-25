import java.util.HashMap;

class EncoderImpl implements EncoderInf {

private String reference = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789()*+,-./";
private HashMap<Character,Integer> plainMap = new HashMap<>();
private HashMap<Integer,Character> decodedMap = new HashMap<>();
private Character offsetCharacter;


//constructor method
public EncoderImpl(Character offsetCharacter) {
    this.offsetCharacter = offsetCharacter;

    int index = 0;
    for (Character c : reference.toCharArray()) {
    plainMap.put(c, index);
    index += 1;
    }

    int shiftAmount = shiftAmount(offsetCharacter);
    index = shiftAmount;
    for (Character c: reference.toCharArray()) {
        decodedMap.put(index, c);
     index = (index + 1) % reference.length();
    }
    System.out.println(decodedMap);
}

// To calculate how many characters to shift right
public Integer shiftAmount(Character offsetCharacter) {
    int index = plainMap.get(offsetCharacter);
    return index;
}

//Encoding method
public String encode(String plainText) {
    //Make sure plain text is in capital casing
    String plainTextUpperCase = plainText.toUpperCase();
    String encoded = "";
    encoded += offsetCharacter;
    for (Character c: plainTextUpperCase.toCharArray()) {
     int plainIndex = plainMap.get(c);
     encoded += decodedMap.get(plainIndex);
    }
    return encoded;
}

//Decoding method
public String decode(String encodedText) {
    //Making sure encodedText is in capital casing
    String encodedTextUpperCase = encodedText.toUpperCase();

    //Case scenario for empty text to decode
    if(encodedTextUpperCase.length() < 2) {return encodedTextUpperCase;}

    //Case scenario for first character in encoded text != preset offset character
    Character firstChar = encodedTextUpperCase.charAt(0);
    if(this.offsetCharacter != firstChar) {
        return new EncoderImpl(firstChar).decode(encodedTextUpperCase);
    }

    int shiftAmount = plainMap.get(offsetCharacter);
    String decoded = "";
    for (int i = 1; i <encodedTextUpperCase.length();i++) {
        int originalIndex = plainMap.get(encodedTextUpperCase.charAt(i));
         int newIndex = (originalIndex + shiftAmount) % reference.length();
         decoded += reference.charAt(newIndex);
    }
    return decoded;
}

}