using System;
using CourseProjectCSver.mainClasses;
using System.Collections.Generic;
using CourseProjectCSver.Comparators;

namespace CourseProjectCSver
{
    class Program : Menu
    {
        /**
        * Главный класс.
        * @author Асеев С.С.
        * @version 1.4
        */
        static void Main(string[] args) 
        {

            /**
             * Метод, с которого начинает работать программа.
             * @param args хранит имя списка, используемого как
             * база данных студентов и преподавателей
             */
            if (args.Length == 0 || !"RndList.csv".Equals(args[0]))
            {
                Console.WriteLine("Не подключёна база данных RndList.csv");
                return;
            }
            SortedSet<Student> listOfStudents = 
                new SortedSet<Student>(new SortByFullName());
            SortedSet<Teacher> listOfTeachers = 
                new SortedSet<Teacher>(new SortByFullName());
            readFromFile(args[0], listOfStudents, listOfTeachers);
            while (true)
            {
                Menu.printMenu();
                switch (Menu.chooseMenu())
                {
                    case '1':
                        showStudents(listOfStudents);
                        break;
                    case '2':
                        showTeachers(listOfTeachers);
                        break;
                    case '3':
                        FacultyMenu(listOfStudents, listOfTeachers);
                        break;
                    case '4':
                        return;
                    default:
                        Console.WriteLine("Неверный ввод");
                        break;
                }
            }
        }
    }
}
