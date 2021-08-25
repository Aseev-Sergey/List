package CourseProject;

import CourseProject.Comparators.SortByFullName;
import CourseProject.mainClasses.Student;
import CourseProject.mainClasses.Teacher;
import java.util.Scanner;
import java.util.TreeSet;
import java.util.InputMismatchException;

/**
 * Главный класс.
 * @author Асеев С.С.
 * @version 1.4
 */
public class Main extends Menu
{

   /**
    * Метод, с которого начинает работать программа.
    * @param args хранит имя списка, используемого как
    * база данных студентов и преподавателей
    */
   public static void main(String[] args)
   {
      if (args.length == 0 || !"RndList.db".equals(args[0]))
      {
         System.out.println("Не подключёна база данных RndList.db");
         return;
      }
      TreeSet<Student> listOfStudents = new TreeSet(new SortByFullName());
      TreeSet<Teacher> listOfTeachers = new TreeSet(new SortByFullName());
      int countM;
      readFromFile(args[0], listOfStudents, listOfTeachers);
      while (true)
      {
         Menu.printMenu();
         try
         {
            Scanner sc = new Scanner(System.in, "Windows-1251");
            countM = sc.nextInt();
         } catch (InputMismatchException exc)
         {
            System.out.println("Неверный ввод");
            continue;
         }
         switch (countM)
         {
            case 1:
               showStudents(listOfStudents);
               break;
            case 2:
               showTeachers(listOfTeachers);
               break;
            case 3:
               FacultyMenu(listOfStudents, listOfTeachers);
               break;
            case 4:
               return;
            default:
               System.out.println("Неверный ввод");
         }
      }
   }
}
