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
        
        // Перебираем все возможные комбинации 6 карт
        // Используем 6 вложенных циклов для генерации комбинаций
        int n = cards.size();
        for (int i1 = 0; i1 < n; i1++) {
            for (int i2 = i1 + 1; i2 < n; i2++) {
                for (int i3 = i2 + 1; i3 < n; i3++) {
                    for (int i4 = i3 + 1; i4 < n; i4++) {
                        for (int i5 = i4 + 1; i5 < n; i5++) {
                            for (int i6 = i5 + 1; i6 < n; i6++) {
                                totalCombinations++;
                                // Суммируем очки в комбинации
                                int sum = cards.get(i1) + cards.get(i2) + cards.get(i3) + 
                                          cards.get(i4) + cards.get(i5) + cards.get(i6);
                                if (sum == 21) {
                                    successfulCombinations++;
                                }
                            }
                        }
                    }
                }
            }
        }
        
        // Вычисляем вероятность
        double probability = (double) successfulCombinations / totalCombinations;
        
        // Выводим результат с округлением до 6 знаков
        System.out.printf("%.6f%n", probability);
    }
}