import itertools

# Определяем количество карт каждого номинала и их очки
cards = []

# Карты от 2 до 10, валет (11), дама (12), король (13), туз (14)
# В колоде 4 масти для каждого номинала, всего 52 карты
for value in range(2, 15):
    count = 4  # 4 масти для каждого номинала
    if value == 11:  # Валет
        points = 11
    elif value == 12:  # Дама
        points = 12
    elif value == 13:  # Король
        points = 13
    elif value == 14:  # Туз
        points = 14
    else:
        points = value  # Остальные карты (2-10)
    cards.extend([points] * count)  # Добавляем 4 карты этого номинала

total_combinations = 0
successful_combinations = 0

# Перебираем все возможные комбинации 6 карт
for combo in itertools.combinations(cards, 6):
    total_combinations += 1
    if sum(combo) == 21:
        successful_combinations += 1

# Вычисляем вероятность
probability = successful_combinations / total_combinations

# Округляем до 6 знаков после запятой
print("{0:.6f}".format(probability))