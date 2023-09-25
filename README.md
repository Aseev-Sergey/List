# List
Курсовая работа по дисциплине: Основы программной реализации информационных технологий

Тема: «Разработка объекта для описания университетских списков»

Создать базовый объект со свойствами — ФИО, дата рождения.
Создать 2 объекта на основе базового. Первый со свойствами — группа, содержащая название и специализацию, в которой содержится название направления, его шифр и факультет, курс, номер зачётной книжки, форма обучения, тип отделения, год поступления.
Второй – должность, содержащую её наименование и жалование, кафедра, в которой имеется её название, номер аудитории, где она находится, контактный номер телефона и факультет.
Программно заполнить массивы созданными объектами (разными), размер
массива 500.
Упорядочить массив по ФИО и вывести элементы на экран. Также организовать вывод списка по факультетам.

![image](https://github.com/Aseev-Sergey/List/assets/85245803/08c2bdb6-fe0b-4ad2-9933-3a97a08fcef0)

В пакете CourseProject:

Main.java – главный класс.

OutputOnDisplay.java – абстрактный класс, содержащий методы вывода на экран требуемой информации.
Menu.java – абстрактный класс, содержащий методы для работы текстового интерфейса программы.

Entity.java – класс-родитель, содержащий свойство name и методы для работы с ним.

В пакете CourseProject.Comparators:

SortByFullName.java – класс, реализующий интерфейс Comparator, для сортировки данных по ФИО.

В пакете CourseProject.mainClasses:

Person.java – основной класс, описывающий человека как объект и содержащий свойства и методы для работы с ними.

Student.java – класс-наследник от Person, описывающий студента как объект и содержащий свойства и методы для работы с ними.

Teacher.java – класс-наследник от Person, описывающий преподавателя как объект и содержащий свойства и методы для работы с ними.

В пакете CourseProject.mainClasses.secondaryClasses:

Faculty.java – вспомогательный класс, описывающий факультет как объект и содержащий свойства и методы для работы с ними.

Group.java – вспомогательный класс, описывающий группу как объект и содержащий свойства и методы для работы с ними.

Specialization.java – вспомогательный класс, описывающий специализацию как объект и содержащий свойства и методы для работы с ними.

Pulpit.java – вспомогательный класс, описывающий кафедру как объект и содержащий свойства и методы для работы с ними.

Position.java - вспомогательный класс, описывающий должность как объект и содержащий свойства и методы для работы с ними.



