import org.apache.logging.log4j.*;

public class Main{

    private static final Logger logger  = LogManager.getLogger(Main.class.getClass());
    private static final Marker ODD_MARKER = MarkerManager.getMarker("ODD");
    private static final Marker EVEN_MARKER = MarkerManager.getMarker("EVEN");

    public static void main(String[] args){

        String poem [] = { "At my side the Demon writhes forever",
                "Swimming around me like impalpable air",
                "As I breathe, he burns my lungs like fever",
                "And fills me with an eternal guilty desir",
                "Knowing my love of Art, he snares my senses",
                "Apearing in woman's most seductive forms",
                "And, under the sneak's plausible pretenses",
                "Lips grow accustomed to his lewd love-charmss"};

        int limit = Integer.valueOf(args[0]);
        if(limit > poem.length){
            limit = poem.length;
        }

        for(int i = 0; i < limit; i++){

            ThreadContext.push(String.valueOf(i));

        if(i == 0){
            logger.debug(poem[i]);
        }
        else if(i % 2 != 0){
            logger.warn(ODD_MARKER,poem[i]);
        }
        else{
            logger.error(EVEN_MARKER,poem[i]);
        }

        ThreadContext.clearAll();

            try {
                Thread.sleep(1500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }


        }





    }
}