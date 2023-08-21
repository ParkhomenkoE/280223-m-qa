package HW;
/* Постройте частотный словарь букв русского (или английского) алфавита.
для решения можно использовать Array или HashMap ( на ваше усмотрение)..
Пример:
text = "Привет, как дела?"
{'а': 2, 'в': 1, 'д': 1, 'е': 2,  'и': 1, 'к': 2, 'л': 1, 'п': 1, 'р': 1,  'т': 1,  'я': 1} */
public class Main {
    public static void main(String[] args) {
        String text = "Привет, как дела?";
        int[] frequencyArray = new int[Character.MAX_VALUE];
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            if (Character.isLetter(c)) {
                c = Character.toLowerCase(c);
                frequencyArray[c]++;
            }
        }
        for (int i = 0; i < Character.MAX_VALUE; i++) {
            if (frequencyArray[i] > 0) {
                System.out.print((char) i + ": " + frequencyArray[i] + ", ");
            }
        }
    }
}
