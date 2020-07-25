import java.util.ArrayList;
import java.util.Random;

class Card {
  private String name;
  private String suit;
  private int direction;
  private ArrayList<String> fortunes;
  private ArrayList<String> positiveMeanings;
  private ArrayList<String> negativeMeanings;

  public Card(){}

  public void setName(String name){
    this.name = name;
  }
  public void setDirection(int direction){
    this.direction = direction;
  }
  public String getDirection(){
    if (direction == 1) {
      return "The card faces you.";
    }
    return "The card faces me.";
  }
  public String getName(){
    return name;
  }
  public void setSuit(String suit){
    this.suit = suit;
  }
  public String getSuit(){
    return suit;
  }
  public void setFortunes(ArrayList<String> fortunes){
    this.fortunes = fortunes;
  }
  public void setPositiveMeanings(ArrayList<String> positiveMeanings){
    this.positiveMeanings = positiveMeanings;
  }
  public void setNegativeMeanings(ArrayList<String> negativeMeanings){
    this.negativeMeanings = negativeMeanings;
  }

  public String interpret(){
    /*
    Interprets cards based on `algorithm`
    */
    Random randomNum = new Random();
    String fortune = "I predict that you will be ";
    if (suit == "major") {
      // return random choice from fortunes
      return fortune + fortunes.get(randomNum.nextInt(fortunes.size())).toLowerCase() + "!";
    }
    else {
      if (direction == 1) {
        // return random choice from positive meanings
        return fortune + positiveMeanings.get(randomNum.nextInt(positiveMeanings.size())).toLowerCase() + "!";
      }
      else {
        // return random choice from negative meanings
        return fortune + negativeMeanings.get(randomNum.nextInt(negativeMeanings.size())).toLowerCase() + "!";
      }
    }
  }

  public void printCard(){
    /*
    debugging tool
    */
    System.out.println(name);
    System.out.println();
    System.out.println(suit);
    System.out.println();
    for (String fortune : fortunes) {
      System.out.println(fortune);
    }
    System.out.println();
    for (String meaning : positiveMeanings) {
      System.out.println(meaning);
    }
    System.out.println();
    for (String meaning1 : negativeMeanings ) {
      System.out.println(meaning1);
    }
  }
}
