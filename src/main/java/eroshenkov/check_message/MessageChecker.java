package eroshenkov.check_message;

import java.util.HashMap;
import java.util.Map;

public class MessageChecker {
  public static void main(String[] args) {
    String text = "qwerty ght lsd keks oaos ok, qws. ght";
    String message = "lsd keks ght ght";

    boolean isMessageInText = checkIfMessageInText(text, message);
    System.out.println(isMessageInText);
  }

  private static boolean checkIfMessageInText(String text, String message) {
    Map<String, Integer> wordsAndItsAmount = putWordsInMap(text);
    String[] wordsInMessage = message.split("\\W+");
    for (String word : wordsInMessage) {
      if (!wordsAndItsAmount.containsKey(word)) {
        return false;
      }
      if (wordsAndItsAmount.get(word) == 1) {
        wordsAndItsAmount.remove(word);
        continue;
      }
      wordsAndItsAmount.compute(word, (key, value) -> value--);
    }
    return true;
  }

  private static Map<String, Integer> putWordsInMap(String text) {
    Map<String, Integer> wordsAndItsAmount = new HashMap<>();
    String[] wordsInText = text.split("\\W+");
    for (String word : wordsInText) {
      wordsAndItsAmount.merge(word, 1, (oldValue, newValue) -> oldValue + newValue);
    }
    return wordsAndItsAmount;
  }
}
