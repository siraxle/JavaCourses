package ru.java.courses;

public class Lesson5_Strings {

  /**
   * Дан массив строк, необходимо удалить из него все дубли,
   * оставшиеся строки объединить в одну в порядке следования в массиве.
   *
   * <p>
   * Подсказка: массив может быть пустой
   *
   * @param strings массив строк
   * @return полученную строку.
   */
  public static String task1(String[] strings) {
    String result = "";
    for (int i = 0; i < strings.length; i++) {
      if (!result.contains(strings[i])) {
        result += strings[i];
      }
    }
    return result;
  }


  /**
   * Дан массив пар названий книг и авторов, необходимо привести каждую пару в строку вида:
   * “Название книги” И.И.Автора
   * <p>
   * Подсказка: Кавычек может не быть, а вместо инициалов полное имя
   *
   * @param pairs массив из пар строк
   * @return массив из полученных строк отсортированный по названию книг по алфавиту.
   */
  public static String[] task2(String[][] pairs) {
    String[] result = new String[pairs.length];
    for (int i = 0; i < pairs.length; i++) {

      //нахожу верное ФИО
      String[] fio = pairs[i][1].split(" ");
      String firstName = fio[0].substring(0, 1) + ".";
      String secondName = fio[1].substring(0, 1) + ".";
      String surname = fio[2];

      //нахожу название книги
      String bookName = pairs[i][0];
      String[] splitBookName = bookName.split("\"");
      for (String s : splitBookName) {
        if (!s.equals("\"")) {
          bookName = s;
        }
      }

      //формирую результирующую строку
      result[i] = "\"" + bookName + "\"" + " " + firstName + " " + secondName + " " + surname;
    }

    return result;
  }

  /**
   * Дана строка, необходимо найти два символа и вернуть подстроку между ними.
   * <p>
   * Подсказка: одного или обоих символов может нет быть
   *
   * @param str   исходная строка
   * @param symb1 первый символ
   * @param symb2 второй символ
   * @return подстроку между найденными символами
   */
  public static String task3(String str, char symb1, char symb2) {
    String result = "";
    if (str.contains(String.valueOf(symb1)) && str.contains(String.valueOf(symb2))) {
      int indexSymb1 = str.indexOf(symb1) + 1;
      int indexSymb2 = str.indexOf(symb2);
      if (indexSymb1 > indexSymb2) {
        result = str.substring(indexSymb2 + 1, indexSymb1 - 1);
      } else {
        result = str.substring(indexSymb1, indexSymb2);
      }
    }

    return result;
  }
}
