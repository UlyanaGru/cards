#include <iostream>
#include <vector>
#include <iomanip>

using namespace std;

// Глобальные переменные для подсчета комбинаций
int totalCombinations = 0;
int successfulCombinations = 0;

// Функция для генерации всех комбинаций 6 карт
void generateCombinations(const vector<int>& cards, int start, int k, 
                         vector<int>& current, int currentSum) {
    if (k == 0) {
        totalCombinations++;
        if (currentSum == 21) {
            successfulCombinations++;
        }
        return;
    }
    for (int i = start; i <= cards.size() - k; i++) {
        current.push_back(cards[i]);
        generateCombinations(cards, i + 1, k - 1, current, currentSum + cards[i]);
        current.pop_back();
    }
}

int main() {
    // Создаем вектор всех карт в колоде с их очками
    vector<int> cards;
    // Карты от 2 до 10, валет (11), дама (12), король (13), туз (14)
    // В колоде 4 масти для каждого номинала, всего 52 карты
    for (int value = 2; value <= 14; value++) {
        int points = value; // Очки совпадают с номиналом для всех карт
        for (int i = 0; i < 4; i++) { // 4 масти
            cards.push_back(points);
        }
    }

    vector<int> current;
    generateCombinations(cards, 0, 6, current, 0);

    // Вычисляем вероятность
    double probability = static_cast<double>(successfulCombinations) / totalCombinations;

    // Округляем до 6 знаков после запятой
    cout << fixed << setprecision(6) << probability << endl;

    return 0;
}
