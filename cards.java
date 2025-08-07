import java.util.ArrayList;
import java.util.List;

public class CardProbability {
    public static void main(String[] args) {
        // Создаем список всех карт в колоде с их очками
        List<Integer> cards = new ArrayList<>();
        // Карты от 2 до 10, валет (11), дама (12), король (13), туз (14)
        // В колоде 4 масти для каждого номинала, всего 52 карты
        for (int value = 2; value <= 14; value++) {
            int points = value; // Очки совпадают с номиналом для всех карт
            for (int i = 0; i < 4; i++) { // 4 масти
                cards.add(points);
            }
        }

        int totalCombinations = 0;
        int successfulCombinations = 0;

        // Перебираем все возможные комбинации 6 карт
        // Используем рекурсивный подход для генерации комбинаций
        generateCombinations(cards, 0, 6, new ArrayList<>(), 0, totalCombinations, successfulCombinations);

        // Вычисляем вероятность
        double probability = (double) successfulCombinations / totalCombinations;

        // Округляем до 6 знаков после запятой
        System.out.printf("%.6f", probability);
    }

    private static void generateCombinations(List<Integer> cards, int start, int k, 
                                           List<Integer> current, int currentSum,
                                           int totalCombinations, int successfulCombinations) {
        if (k == 0) {
            totalCombinations++;
            if (currentSum == 21) {
                successfulCombinations++;
            }
            return;
        }
        for (int i = start; i <= cards.size() - k; i++) {
            current.add(cards.get(i));
            generateCombinations(cards, i + 1, k - 1, current, currentSum + cards.get(i), 
                                totalCombinations, successfulCombinations);
            current.remove(current.size() - 1);
        }
    }
}