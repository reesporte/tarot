import java.util.Random;
import java.util.ArrayList;

import org.json.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;


class Main
{
	public static void main(String[] args) throws FileNotFoundException {

		FileInputStream input = new FileInputStream("interpretations/tarot_interpretations.json");
		JSONTokener tokener = new JSONTokener(input);
		JSONObject json = new JSONObject(tokener);

		JSONArray interpretations = json.getJSONArray("tarot_interpretations");

		ArrayList<Card> cards = new ArrayList<Card>();

		Random randomNum = new Random();

		for (int i = 0; i <  interpretations.length(); i++) {
			JSONObject interpretation = interpretations.getJSONObject(i);
			Card card = readCard(interpretation);
			int direction = randomNum.nextInt(2);
			card.setDirection(direction);
			cards.add(card);
		}

		Reading reading = new Reading(cards);

		String fortune = reading.createFortune();

		System.out.println("🔮🔮🔮 TAROT CARD READER 🔮🔮🔮 \n");
		System.out.println(fortune);

	}

	public static Card readCard(JSONObject interpretation){
		/*
		takes a json object and returns the Card object version
		*/

		String name = interpretation.getString("name");
		String suit = interpretation.getString("suit");
		JSONArray fortunesJSON = interpretation.getJSONArray("fortune_telling");
		JSONArray positiveJSON = interpretation.getJSONObject("meanings").getJSONArray("light");
		JSONArray negativeJSON = interpretation.getJSONObject("meanings").getJSONArray("shadow");

		Card card = new Card();

		card.setName(name);
		card.setSuit(suit);

		ArrayList<String> fortunes = new ArrayList<String>();
		for (int j = 0; j < fortunesJSON.length(); j++ ) {
			fortunes.add(fortunesJSON.getString(j));
		}
		card.setFortunes(fortunes);

		ArrayList<String> positive = new ArrayList<String>();
		for (int j = 0; j < positiveJSON.length(); j++ ) {
			positive.add(positiveJSON.getString(j));
		}
		card.setPositiveMeanings(positive);

		ArrayList<String> negative = new ArrayList<String>();
		for (int j = 0; j < negativeJSON.length(); j++ ) {
			negative.add(negativeJSON.getString(j));
		}
		card.setNegativeMeanings(negative);
		return card;
	}

}
