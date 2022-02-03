package ru.java.courses;

import java.util.*;
import java.util.Map.Entry;
import java.util.stream.Collectors;
import javax.swing.tree.TreeCellEditor;

public class Lesson11to12_SetMap {

  public static class User {

    private String name;
    private int age;
    private String phone;

    public User(String name, int age) {
      this.name = name;
      this.age = age;
    }

    public User(String phone) {
      this.phone = phone;
    }

    public String getName() {
      return name;
    }

    public void setName(String name) {
      this.name = name;
    }

    public int getAge() {
      return age;
    }

    public void setAge(int age) {
      this.age = age;
    }

    public String getPhone() {
      return phone;
    }

    public void setPhone(String phone) {
      this.phone = phone;
    }
  }

  /**
   * В этом методе необходимо реализовать:
   * 1. На вход получаем коллекцию пользователей
   * 2. Удаляем все дубли (одинаковое имя и возраст)
   * 3. Сортируем по имени и возрасту
   * 4. Возвращаем последнего пользователя
   */
  public static User task1(Collection<User> source) {
    TreeMap<String, Integer> map = new TreeMap<>(new Comparator<String>() {
      @Override
      public int compare(String o1, String o2) {
        return String.valueOf(o1).compareTo(String.valueOf(o2));
      }
    });
    for (User user : source) {
      if (!map.containsKey(user.getName()) && !map.containsValue(user.getAge())) {
        map.put(user.getName(), user.getAge());
      }
    }
    return new User(map.lastEntry().getKey(), map.lastEntry().getValue());
  }

  /**
   * В этом методе необходимо реализовать следующий алгоритм:
   * 1. На вход получаем коллекцию пользователей
   * 2. Преобразовываем его в справочник [номер телефона -> пользователь]
   * 3. Один номер телефона на одного пользователя
   * 4. Вернуть количество записей в справочнике
   */
  public static int task2(Collection<User> source) {
    Map<String, User> dictionary = new HashMap<>();
    for (User user : source) {
      if (!dictionary.containsKey(user.getPhone())) {
        dictionary.put(user.getPhone(), user);
      }
    }
    return dictionary.size();
  }


  /**
   * В этом методе необходимо реализовать следующий алгоритм:
   * 1. На вход получаем список названий книг
   * 2. Распределяем книги по полкам так, чтобы на каждой полке было примерно одинаковое количество книг
   * 3. Все книги должны быть отсортированы по алфавиту с первой до последней полки
   * 4. Количество полок константное - 5 штук
   * 5. Вернуть книги распределенные по полкам
   * <p>
   * Нумерация полок начинается с единицы!
   */
  public static Map task3(Collection<String> source) {
    Map<Integer, List<String>> shelves = new HashMap<>();
    int amountBooksOnShelve = source.size() / 5;
    ArrayList<String> booksNames = new ArrayList<>(source);
    Collections.sort(booksNames);
    int startIndex = 0;
    int lastIndex = amountBooksOnShelve;
    for (int i = 1; i <= 5; i++) {
      List<String> shelve;
      if (lastIndex <= booksNames.size()) {
        shelve = booksNames.subList(startIndex, lastIndex);
        startIndex += amountBooksOnShelve;
        lastIndex += amountBooksOnShelve;
      } else {
        lastIndex = booksNames.size();
        shelve = booksNames.subList(startIndex, lastIndex);
      }
      shelves.put(i, shelve);
    }
    return shelves;
  }


  /**
   * В этом методе необходимо реализовать следующий алгоритм:
   * 1. На вход получаем книги, распределенные по полкам
   * 5. Вернуть справочник [название книги -> номер полки]
   */
  public static Map task4(Map<Integer, String> source) {
    Collection<String> tmpBooksNames = source.values();
    Collection<Integer> tmpShelves = source.keySet();
    ArrayList<String> booksNames = new ArrayList<>(tmpBooksNames);
    ArrayList<Integer> shelves = new ArrayList<>(tmpShelves);
    Map<String, Integer> books = new HashMap<>();
    for (int i = 0; i < source.size(); i++) {
      books.put(booksNames.get(i), shelves.get(i));
    }
    return books;
  }
}
