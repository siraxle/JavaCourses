package ru.java.courses;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Lesson10_CollectionsLists {

  /**
   * В этом методе необходимо реализовать:
   * 1. На вход получаем список чисел
   * 2. Удаляем все дубли
   * 3. Сортируем список по возрастанию
   * 4. Преобразуем числа в строки
   * <p>
   * Подсказки:
   * Collections.sort() - сортировка
   * Удалять элементы из итерируемого списка нельзя - выпадет исключение
   */
  public static List<String> task1(List<Integer> source) {
    List<String> strings = new ArrayList<>();

    Collections.sort(source);

    for (int i = 0; i < source.size(); i++) {
      if (i == source.size() - 1) {
        strings.add(String.valueOf(source.get(i)));
        break;
      }
      if (!source.get(i).equals(source.get(i + 1))) {
        strings.add(String.valueOf(source.get(i)));
      }
    }

    return strings;
  }

  /**
   * В этом методе необходимо реализовать следующий алгоритм:
   * 1. Получаем на входе массив чисел
   * 2. Преобразовываем его к списку
   * 4. Все четные числа увеличиваем на единицу
   * 5. Возвращаем кусок списка с 3-го по 7-й элемент
   * <p>
   * Подсказка: на входе может быть любое количество чисел
   */
  public static List<Integer> task2(Integer... array) {
    List<Integer> integers = new ArrayList<>(Arrays.asList(array));
    ArrayList<Integer> res = new ArrayList<>();

    for (int i = 0; i < integers.size(); i++) {
      if (integers.get(i) % 2 == 0) {
        integers.set(i, integers.get(i) + 1);
      }
      if (i >= 3 && i < 8 && i < array.length) {
        res.add(integers.get(i));
      }
    }

    return res;
  }
}
