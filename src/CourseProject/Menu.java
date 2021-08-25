package CourseProject;

import static CourseProject.Main.showFaculties;
import java.util.Scanner;
import java.util.TreeSet;
import java.util.InputMismatchException;

/**
 * Абстрактный класс, описыващий текстовой интерфейс меню.
 * @author Асеев С.С.
 * @version 1.2
 */
public abstract class Menu extends OutputOnDisplay
{

   /**
    * Массив строк, содержащий названия факультетов, используемые для печати
    * пунктов дополнительного меню.
    */
   public static final String[] FACULTYSTR =
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
      System.out.println("1. Список студентов");
      System.out.println("2. Список преподавателей");
      System.out.println("3. Список факультетов");
      System.out.println("4. Выйти из программы");
      printTell();
   }

   /**
    * Метод для вывода на экран пунктов дополнительного меню.
    */
   public static void printFacultyMenu()
   {
      for (int i = 0; i < FACULTYSTR.length; i++)
      {
         System.out.println((i + 1) + ". Факультет " + FACULTYSTR[i]);
      }
      System.out.println("e. Вернуться в предыдущее меню");
      printTell();
   }

   /**
    * Метод для работы с дополнительным меню.
    * @param listOfStudents список студентов
    * @param listOfTeachers список преподавателей
    */
   public static void FacultyMenu(TreeSet listOfStudents, TreeSet listOfTeachers)
   {
      char choose;
      while (true)
      {
         Menu.printFacultyMenu();
         try
         {
            Scanner sc = new Scanner(System.in, "Windows-1251");
            choose = sc.nextLine().charAt(0);
         } catch (InputMismatchException exc)
         {
            System.out.println("Неверный ввод");
            continue;
         }
         switch (choose)
         {
            case '1':
            case '2':
            case '3':
            case '4':
            case '5':
            case '6':
            case '7':
               showFaculties(FACULTYSTR, choose - '0',
                       listOfStudents, listOfTeachers);
               break;
            case 'e':
            case 'E':
            case 'е':
            case 'Е':
               return;
            default:
               System.out.println("Неверный ввод");
         }
      }
   }

   /**
    * Метод для вывода на экран инструкций перед передачей управления
    * пользователю.
    */
   public static void printTell()
   {
      System.out.println("Введите пункт меню и нажмите Enter");
   }
}
