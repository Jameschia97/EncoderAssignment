public class Main {
    public static void main(String[] args) {

        
        EncoderImpl example = new EncoderImpl('B');


        //encoding method
        String encodedResult = example.encode("kuku");
        System.out.println(encodedResult); 

        //decoding method
        String decodedResult = example.decode("bjtjt");
        System.out.println(decodedResult); 
    }
}
