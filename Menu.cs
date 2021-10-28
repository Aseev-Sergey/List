using System;
using System.Collections.Generic;
using System.Text;
using CourseProjectCSver.mainClasses;

namespace CourseProjectCSver
{
    /**
 * Абстрактный класс, описыващий текстовой интерфейс меню.
 * @author Асеев С.С.
 * @version 1.2
 */
    class Menu : OutputOnDisplay
    {

        /**
         * Массив строк, содержащий названия факультетов, используемые для печати
         * пунктов дополнительного меню. 
         * В C# не получается объявить массив константой
         */
        public static string[] FACULTYSTR =
   {
      "архитектуры и градостроительства",
      "инженерных систем и сооружений",
      "информационных технологий и компьютерной безопасности",
      "машиностроения и аэрокосмической техники",
      "радиотехники и электроники",
      "экономики, менеджмента и информационных технологий",
      "энергетики и систем управления"
   };

   /**
    * Метод для вывода на экран пунктов основное меню.
    */
   public static void printMenu()
        {
            Console.WriteLine("1. Список студентов");
            Console.WriteLine("2. Список преподавателей");
            Console.WriteLine("3. Список факультетов");
            Console.WriteLine("4. Выйти из программы");
            printTell();
        }

        /**
         * Метод для вывода на экран пунктов дополнительного меню.
         */
        public static void printFacultyMenu()
        {
            for (int i = 0; i < FACULTYSTR.Length; i++)
            {
                Console.WriteLine((i + 1) + ". Факультет " + FACULTYSTR[i]);
            }
            Console.WriteLine("e. Вернуться в предыдущее меню");
            printTell();
        }

        /**
         * Метод для работы с дополнительным меню.
         * @param listOfStudents список студентов
         * @param listOfTeachers список преподавателей
         */
        public static void FacultyMenu(SortedSet<Student> listOfStudents,
            SortedSet<Teacher> listOfTeachers)
        {
            char choose;
            while (true)
            {
                Menu.printFacultyMenu();
                switch (choose = chooseMenu())
                {
                    case '1':
                    case '2':
                    case '3':
                    case '4':
                    case '5':
                    case '6':
                    case '7':
                        showFaculties(FACULTYSTR, choose - '1',
                                listOfStudents, listOfTeachers);
                        break;
                    case 'e':
                    case 'E':
                    case 'е':
                    case 'Е':
                        return;
                    default:
                        Console.WriteLine("Неверный ввод");
                        break;
                }
            }
        }

        /**
         * Метод для вывода на экран инструкций перед передачей управления
         * пользователю.
         */
        public static void printTell()
        {
            Console.WriteLine("Введите пункт меню и нажмите Enter");
        }

        public static char chooseMenu()
        {
            int choose;
            choose = Console.Read();
            Console.ReadLine();
            return Convert.ToChar(choose);

        }
    }
}
