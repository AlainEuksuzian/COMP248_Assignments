package comp248.Assignment3;

public class testIt {
    public static void main(String[] args) {
        OPUSCard card = new OPUSCard("asdf", "alain", 10, 2024);
        OPUSCard card2 = new OPUSCard("asdaaf", "alsain", 11, 2245);
        OPUSCard card3 = new OPUSCard("asaadf", "aladin", 11, 2028);

        OPUSCard[] allCards = {card,card2,card3};

        for (OPUSCard e :allCards){
            System.out.println(e);
            System.out.println("__________________________________");
        }

       Ticketbooth myboot = new Ticketbooth();


    }

    
    
}
