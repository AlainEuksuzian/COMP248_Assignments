package comp248.Assignment3;

public class testIt {
    public static void main(String[] args) {
        OPUSCard card = new OPUSCard("asdf", "alain", 10, 2024);
        OPUSCard card2 = new OPUSCard("REMOVE", "REMOVE", 11, 2245);
        OPUSCard card3 = new OPUSCard("asaadf", "jack", 11, 2028);
        OPUSCard card4 = new OPUSCard("aaaa", "adss", 11, 2028);

        int[] cardNumbers = {0,1,2,0,5};

       String[] description = {"the number of regular tickets: ", "the number of junior tickets: ",
       "the number of senior tickets: ", "the number of daily tickets: ", "the number of weekly tickets: " };
       final String NOCARD = " No OPUS cards";

       String outputTicketNumbers = "";

        for (int i = 0; i < cardNumbers.length; i++){
            if (cardNumbers[i] > 0){
                outputTicketNumbers += description[i] + cardNumbers[i] + "\n";
            }
            else {
                outputTicketNumbers += description[i] + NOCARD + "\n";
            }
        }

        System.out.println(outputTicketNumbers);
    }



   /* public static void gs(){
                OPUSCard[] busCards = {card,card2,card3, card4};
        String output = "";
        for (OPUSCard e: busCards){
            output +="Cardholder type: " + e.getCardType() + "\nCardholder Name: " 
            + e.getCardHolderName() + "\nexipiry date: " + e.getExpiryMonth() + "\nexpiry year: " + e.getExpiryYear() + "\n-------------------------\n";
           
        } */
     
    }


    
    

