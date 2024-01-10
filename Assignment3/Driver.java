package comp248.Assignment3;
import java.util.Scanner;

public class Driver {
    /* START HARD CODED AS REQUESTED IN ASSIGNMENT */
    private static  Ticketbooth boothOneSame = null;
    private static Ticketbooth boothTwoSame = null;
    private static Ticketbooth boothThree = null;
    private static Ticketbooth boothFour = null;
    private static Ticketbooth boothFive = null;
    private static Ticket ticket1 = new Ticket(2, 2, 3, 4, 5);
    private static Ticket ticket2 = new Ticket(5, 5, 5, 1, 0);
    private static Ticket ticket3= new Ticket(11, 1, 4, 55, 51);
    private static Ticket ticket4= new Ticket(11, 1, 4, 55, 51);
    private static Ticket[] allTickets = {ticket1,ticket2,ticket3,ticket4};
    private static Scanner keyboar = new Scanner(System.in);
    private static OPUSCard card1 = new OPUSCard("regular", "alain", 10, 2020);
    private static OPUSCard card2 = new OPUSCard("junior", "alain", 10, 2020);
    private static OPUSCard card3 = new OPUSCard("senior", "alain", 10, 2020);
    private static OPUSCard card4 = new OPUSCard("regular", "alain", 10, 2020);
    private static OPUSCard card5 = new OPUSCard("daily", "alain", 10, 2020);
    private static OPUSCard card6 = new OPUSCard("weekly", "alain", 10, 2020);
    /* END HARD CODED AS REQUESTED IN ASSIGNMENT */
    public static void main(String[] args) {
       OPUSCard[] cards1 = {card1, card2, card3, card4};
       OPUSCard[] cards2 = {card1, card2, card3, card4};
       OPUSCard[] cards3 = {card5, card6, card2, card1};


        boothOneSame = new Ticketbooth(ticket3, cards1);
        boothTwoSame = new Ticketbooth(ticket1, cards1);
        boothThree = new Ticketbooth(ticket2, cards2);
        boothFour = new Ticketbooth(ticket4, cards3);
        boothFive = new Ticketbooth(ticket4, cards3);

        int choice = presentMenu();
        optionOne();

    }

    /**
     * queries the use for their option
     * @return user option choice
     */
    public static int presentMenu(){
        System.out.println("what would you like to do?: ");
        int choice = getUserInput("1. See the Content of all Ticketbooth\n2.See the content of One ticketBooth\n3.List Ticketbooths with the same tickets amount of ticket value\n4.List ticketbooth with the same tickets amount\n5.list ticketbooths with the same amount of tickets value and same number of opus card\n6.add a opus card to an exissting ticketbooth\n7.remove an exiting opus card fom a ticketbooth\n8.update the expiry date of an existing opus card\n9.add tickets to a ticketbooth\n0. exit\nChoice: ");
        if (choice >= 0 && choice < 9 ){
            return choice;
        }
        System.out.println("invalid choice entered");
        return 0;
    }

    /**
     * 
     * @param message
     * @return option chosen from user
     */
    public static int getUserInput(String message){
        System.out.print(message);
        return keyboar.nextInt();
    }

    /**
     *prints all ticketbooth values
     */
    public static void optionOne(){
        System.out.println(boothOneSame.toString());
        System.out.println(boothTwoSame.toString());
        System.out.println(boothThree.toString());
        System.out.println(boothFour.toString());
        System.out.println(boothFive.toString());
    }

    /**
     * 
     * @param toView
     * @return string details of chosen booth
     */
    public static String optionTwo(Ticketbooth toView){
        return(toView.toString());
    }

    /**
     * displays ticketbooth with same total tickets
     * @return string display
     */
    public static String optionThree(){
        Ticket toDisplay = null;

        for (int i = 0; i < allTickets.length - 1; i++){
            for (int k = i+ 1; k < allTickets.length; k++){
                if (allTickets[i].ticketsTotal() == allTickets[k].ticketsTotal()){
                    return allTickets[i].toString() + "\n" + allTickets[k].toString();
                }
            }
        }
        return "no such tickets";
    }

    /**
     * List Ticketbooths with same Tickets amount 
     * @return  tostring description of ticket details
     */
    public static String optionFour(){
        Ticket toDisplay = new Ticket();

        for (int i = 0; i < allTickets.length - 1; i++){
            for (int k = i + 1; k < allTickets.length; k++){
                int ticketOne = allTickets[i].getRegularTickets() +allTickets[i].getJuniorTickets()+ allTickets[i].getSeniorTickets() + allTickets[i].getDailyTickets() + allTickets[i].getWeeklyTickets();
                int ticketTwo = allTickets[k].getRegularTickets() +allTickets[k].getJuniorTickets()+ allTickets[k].getSeniorTickets() + allTickets[k].getDailyTickets() + allTickets[k].getWeeklyTickets();

                if (ticketOne == ticketTwo){
                    return allTickets[i].toString() + "\n" + allTickets[k].toString();
                }
                
            }
        } 
        return "no such tickets";
    }

    /**
     * List Ticketbooths with same amount of tickets values and same number of OPUS cards 
     * @return string display to booth if booth within the created booths
     */
    public static String optionFive(){
        Ticketbooth[] allBooths = {boothOneSame, boothTwoSame, boothThree, boothFour, boothFive};
        Ticketbooth toDisplay = null;
        for (int i = 0; i < allBooths.length - 1; i++){
            for (int k = i + 1; k < allBooths.length; k++){
                if (allBooths[i].getTotalTicketsBooth() == allBooths[k].getTotalTicketsBooth() && allBooths[i].getNumberOpusCardsBooth() == allBooths[k].getNumberOpusCardsBooth()){
                    toDisplay = allBooths[i];
                }
            }
        }
        return toDisplay.toString();


    }

    /**
     * Add a OPUS card to an existing Ticketbooth  
     * @param toadd
     * @param boothToAdd
     * @return true if added correctly
     */
    public static boolean optionSix(OPUSCard toadd, Ticketbooth boothToAdd){
        try{
            boothToAdd.addNewOpusCard(toadd);
            return true;
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            System.out.println("operation failed");
            return false;
        }
    }

    /**
     * Remove an existing OPUS card from a Ticketbooth  
     * @param toremove
     * @param boothToRemove
     * @return true if removed correctly
     */
    public static boolean optionSeven(OPUSCard toremove, Ticketbooth boothToRemove){
        try{
            boothToRemove.removeOpusCard(toremove);
            return true;
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            System.out.println("operation failed");
            return false;
        }
    }

    /**
     * Update the expiry date of an existing OPUS card 
     * @param newMonth
     * @param newYear
     * @param cardToUpdate
     * @return true if update done correctly.
     */
    public static boolean optionEight(int newMonth, int newYear, OPUSCard cardToUpdate){

            OPUSCard[] allcards = {card1,card2,card3, card4, card5, card6};

            for (int i =0; i < allcards.length; i++){
                if (allcards[i].equals(cardToUpdate)){
                    allcards[i].setExpiryMonth(newMonth);
                    allcards[i].setExpiryYear(newYear);
                    return true;
                }
            }
            return false;
         }

    
    
}
