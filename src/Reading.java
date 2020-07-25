import java.util.Random;
import java.util.ArrayList;

class Reading {
  private ArrayList<Card> cards;
  private ArrayList<Card> reading;

  public Reading(ArrayList<Card> cards){
    /*
    choose four cards that haven't been chosen before
    */
    this.cards = cards;
    reading = new ArrayList<Card>();

    Random ran = new Random();
    ArrayList<Integer> alreadyChosenIndices = new ArrayList<Integer>();

    int index = ran.nextInt(cards.size());
    alreadyChosenIndices.add(index);

    while (reading.size() < 5) {
      reading.add(cards.get(index));
      while (alreadyChosenIndices.contains(index)) {
        index = ran.nextInt(cards.size());
      }
      alreadyChosenIndices.add(index);
    }
  }

  public String createFortune(){
    /*
    create a fortune for the four cards that have been chosen 
    */
    String fortune = new String();
    fortune += "Romance: " + reading.get(0).getName() + "\n";
    fortune += reading.get(0).getDirection() + "\n";
    fortune += reading.get(0).interpret() + "\n\n";
    fortune += "Finances: " + reading.get(1).getName() + "\n";
    fortune += reading.get(1).getDirection() + "\n";
    fortune += reading.get(1).interpret() + "\n\n";
    fortune += "Health and Happiness: " + reading.get(2).getName() + "\n";
    fortune += reading.get(3).getDirection() + "\n";
    fortune += reading.get(2).interpret() + "\n\n";
    fortune += "Career: " + reading.get(3).getName() + "\n";
    fortune += reading.get(3).getDirection() + "\n";
    fortune += reading.get(3).interpret() + "\n\n";

    return fortune;
  }
}
