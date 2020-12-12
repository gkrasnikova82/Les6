package com.task1;
 /*ДЗ  6 Смоделировать предметную область
        Используя полученные знания об объектно-ориентированном программировании смоделировать какую-нибудь
        предметную область.

        Например: банк, университет, библиотека, склад, магазин, пруд и т.д.

                Ограничения:

        Минимум 3 класса
        Наличие нескольких полей и методов
        Использование модификаторов доступа
        Использование принципов ООП*/

class Student { // информация о студенте
    String FIO;
    int age;
    String gender;
    Library BookForStudent = new Library();// объявение экземпляра класса Library

    void SetStudent (String name, int a, String g) { // метод ввода информации о студенте
        FIO = name;
        age = a;
        gender = g;
    }

    Universitet StudentUnuversity = new Universitet();// информация об Университете
    void printinfo() { //метод вывода информации о студенте (какую книгу необходимо выдать студенту)
        System.out.println();
        System.out.print(StudentUnuversity.getCourseString(age));
        System.out.println(" ФИО: " + FIO + " Возраст " + age + " пол " + gender);
        System.out.println("Книга для изучения: " + BookForStudent.getBooks(age,gender));
    }
}


class Library extends Universitet {// родитель, класс университет
     private String [][] books = {{"ввод в Бухучет", "1С Бухгалтерия", "Бухгалтерский учет и аудит", "Бухгалтерский учет в банках","Бухучет.Практикум", "Бухучет в РФ "},{"Ручной словарь для инженеров", "Инженер и научный работник", "Программирование", "Основы математики","Основы конструирования", "Построй космический корабль сам (автор Иллон Маск)"}};

        public String getBooks(int age, String g){// метод определяющий книгу для студента
        if (g == "Юноша") return books [1][getCourseNumber(age)];
       else return books [0][getCourseNumber(age)];
    }

}

class Universitet {

        String Course;

    public String getCourseString(int a) { //метод, который возвращает номер курса (строка) для студента по его возрасту
        if ((a - 17) <= 4 & (a > 16)) Course = "Курс " + (a - 16);
        else Course = "Не студент";
        return Course;
    }

    public int getCourseNumber(int a) { //метод, который возвращает номер курса (число) для студента по его возрасту
        if ((a - 17) <= 4 & (a > 16)) return (a - 16);
        else return 0;

    }
}

public class Main {

    public static void main(String[] args) {

                Student Student1 = new Student();

                Student1.SetStudent("Лиза", 18, "Девушка");//ввод данных о студенте
                Student1.printinfo();

                Student1.SetStudent("Андрей", 20, "Юноша");
                Student1.printinfo();
    }

}




