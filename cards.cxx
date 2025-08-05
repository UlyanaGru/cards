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