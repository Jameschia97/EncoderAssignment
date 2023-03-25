public interface EncoderInf {
    
    public Integer shiftAmount(Character offsetCharacter);
    public String encode(String plainText);
    public String decode(String encodedText);
}
