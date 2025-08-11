import java.util.ArrayList;
import java.util.List;

public class CardProbability {

    public static void main(String[] args) {
        // Создаем список всех карт в колоде с их очками
        List<Integer> cards = new ArrayList<>();
        
        // Заполняем колоду: карты от 2 до 14 (туз)
        for (int value = 2; value <= 14; value++) {
            int points;
            // Определяем очки для карт с особыми значениями
            if (value == 11) {      // Валет
                points = 11;
            } else if (value == 12) { // Дама
                points = 12;
            } else if (value == 13) { // Король
                points = 13;
            } else if (value == 14) {  // Туз
                points = 14;
            } else {
                points = value;       // Карты 2-10
            }
            
            // Добавляем 4 карты этого номинала (по одной для каждой масти)
            for (int i = 0; i < 4; i++) {
                cards.add(points);
            }
        }
        
        long totalCombinations = 0;
        long successfulCombinations = 0;