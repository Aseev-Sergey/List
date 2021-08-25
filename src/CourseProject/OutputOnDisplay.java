package CourseProject;

import CourseProject.mainClasses.Student;
import CourseProject.mainClasses.Teacher;
import CourseProject.mainClasses.SecondaryClasses.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeSet;

/**
 * Абстрактный класс, описывающий заполнение списков из базы данных и их
 * вывод на экран.
 * @author Асеев С.С.
 * @version 1.0
 */
public abstract class OutputOnDisplay
{

   /**
    * Метод для чтения из базы данных.
    * @param arg имя списка, используемого как база данных
    * @param listOfStudents список студентов
    * @param listOfTeachers список преподавателей
    */
   public static void readFromFile(String arg, TreeSet listOfStudents,
           TreeSet listOfTeachers)
   {
      try (Scanner sc = new Scanner(new File(arg), "Windows-1251"))
      {
         String str;
         while (sc.hasNext())
         {
            str = sc.nextLine();
            try (Scanner scStr = new Scanner(str))
            {
               String surname, firstname, patronymic;
               int yearOfBirthday;
               surname = scStr.next();
               firstname = scStr.next();
               patronymic = scStr.next();
               yearOfBirthday = scStr.nextInt();
               if (scStr.hasNextInt())
               {
                  int yearOfReceit = scStr.nextInt(), course = scStr.nextInt(),
                          formOfStudy = scStr.nextInt(),
                          departmentInt = scStr.nextInt();
                  boolean department = false;
                  String recordBook = scStr.next(), groupName = scStr.next();
                  StringBuilder pulpit = new StringBuilder();
                  String cipher;
                  if (departmentInt == 1)
                     department = true;
                  while (true)
                  {
                     String partOfStr = scStr.next();
                     if (partOfStr.length() >= 2 && partOfStr.charAt(2) == '.')
                     {
                        cipher = partOfStr;
                        break;
                     }
                     pulpit.append(partOfStr).append(' ');
                  }
                  String faculty = scStr.nextLine().trim();
                  listOfStudents.add(new Student(surname, firstname, patronymic,
                           yearOfBirthday, new Group(groupName,
                           new Specialization(pulpit.toString().trim(), cipher,
                           new Faculty(faculty))), course, recordBook,
                           formOfStudy, department, yearOfReceit));
               }
               else
               {
                  StringBuilder[] pulpit = new StringBuilder[2];
                  StringBuilder[] faculty = new StringBuilder[pulpit.length];
                  String[] phone = new String[pulpit.length];
                  String[] position = new String[pulpit.length];
                  int[] audience = new int[pulpit.length],
                          salary = new int[pulpit.length];
                  int i = 0;
                  while (scStr.hasNext())
                  {
                     faculty[i] = new StringBuilder();
                     pulpit[i] = new StringBuilder();
                     while (true)
                     {
                        if (scStr.hasNextInt())
                        {
                           audience[i] = scStr.nextInt();
                           phone[i] = scStr.next();
                           break;
                        }
                        String partOfStr = scStr.next();
                        pulpit[i].append(partOfStr).append(' ');
                     }
                     while (true)
                     {
                        String partOfStr;
                        if (!scStr.hasNextInt())
                        {
                           partOfStr = scStr.next();
                           if (scStr.hasNextInt())
                           {
                              position[i] = partOfStr;
                              salary[i] = scStr.nextInt();
                              break;
                           }
                           else
                           {
                              faculty[i].append(partOfStr).append(' ');
                              partOfStr = scStr.next();
                              if (scStr.hasNextInt())
                              {
                                 position[i] = partOfStr;
                                 salary[i] = scStr.nextInt();
                                 break;
                              }
                              else
                                 faculty[i].append(partOfStr).append(' ');
                           }
                        }
                     }
                     i++;
                  }
                  String[] pulpitStr = new String[pulpit.length],
                          facultyStr = new String[pulpit.length];
                  for (i = 0; i < pulpitStr.length; i++)
                  {
                     if (pulpit[i] != null)
                     {
                        pulpitStr[i] = pulpit[i].toString().trim();
                        facultyStr[i] = faculty[i].toString().trim();
                     }
                     else
                        break;
                  }
                  listOfTeachers.add(new Teacher(surname, firstname, patronymic,
                          yearOfBirthday, pulpitStr, audience, phone, facultyStr,
                          position, salary));
               }
            }
         }
      } catch (FileNotFoundException exc)
      {
         System.out.println("Файл не найден");
      }
   }

   /**
    * Метод для вывода на экран списка студентов.
    * @param listOfStudents список студентов
    */
   public static void showStudents(TreeSet listOfStudents)
   {
      Iterator<Student> itr = listOfStudents.iterator();
      int count = 1;
      printTitleWithUnderScore("#  |    Фамилия    |      Имя      |   Отчество    |"
              + "год рождения|год поступления|курс|форма обучения|отделение|"
              + "группа|шифр специализации|# зачетной книжки|"
              + "                      факультет                      |");
      while (itr.hasNext())
      {
         Student current = itr.next();
         System.out.printf("%3d|%-15s|%-15s|%-15s|%12d|%15d|%4d|%-14s|%-9s|%6s|%18s|"
                 + "%17s|%-53s|\n", count, current.getSurname(),
                 current.getFirstname(), current.getPatronymic(),
                 current.getYearOfBirth(), current.getYearOfReceipt(),
                 current.getCourse(), current.getFormOfStudy(),
                 current.getDepartment(), current.getgName().getName(),
                 current.getgName().getsName().getCipher(), current.getRecordBook(),
                 current.getgName().getsName().getfName().getName());
         count++;
      }
   }

   /**
    * Метод для вывода на экран списка преподавателей.
    * @param listOfTeachers список преподавателей
    */
   public static void showTeachers(TreeSet listOfTeachers)
   {
      Iterator<Teacher> itr = listOfTeachers.iterator();
      int count = 1;
      printTitleWithUnderScore("#  |    Фамилия    |      Имя      |   Отчество    |"
              + "год рождения|"
              + "                                  кафедра                     "
              + "             |"
              + "                      факультет                      "
              + "|    должность    |"
              + "                                  кафедра                     "
              + "             |"
              + "                      факультет                      "
              + "|    должность    |");
      while (itr.hasNext())
      {
         Teacher current = itr.next();
         Iterator<Map.Entry<Position, Pulpit>> itrForHM;
         itrForHM = current.getPosition().entrySet().iterator();
         System.out.printf("%3d|%-15s|%-15s|%-15s|%12d|", count,
                 current.getSurname(), current.getFirstname(),
                 current.getPatronymic(), current.getYearOfBirth());
         while (itrForHM.hasNext())
         {
            Map.Entry entry = itrForHM.next();
            System.out.printf("%-75s|%-53s|%-17s|",
                    ((Pulpit) entry.getValue()).getName(),
                    ((Pulpit) entry.getValue()).getfName().getName(),
                    ((Position) entry.getKey()).getName());
         }
         System.out.println();
         count++;
      }
   }

   /**
    * Метод для вывода списка студентов и преподавателей по определенному
    * факультету.
    * @param FACULTY список факультетов
    * @param chosenFaculty доступ к выбранному пользователем факультету
    * @param listOfStudents список студентов
    * @param listOfTeachers список преподавателей
    */
   public static void showFaculties(final String[] FACULTY, int chosenFaculty,
           TreeSet listOfStudents, TreeSet listOfTeachers)
   {
      Iterator<Student> itrStd = listOfStudents.iterator();
      Iterator<Teacher> itrTch = listOfTeachers.iterator();
      int count = 1;
      printTitleWithUnderScore("#  |    Фамилия    |      Имя      |   Отчество    |"
              + "группа/должность");
      while (itrTch.hasNext())
      {
         boolean flag = false;
         Teacher current = itrTch.next();
         Iterator<Map.Entry<Position, Pulpit>> itrForHM;
         itrForHM = current.getPosition().entrySet().iterator();
         String position = new String();
         while (itrForHM.hasNext())
         {
            Map.Entry entry = itrForHM.next();
            if (((Pulpit) entry.getValue()).getfName().getName()
                    .equals(FACULTY[chosenFaculty]))
            {
               flag = true;
               position = ((Position) entry.getKey()).getName();
            }
            else
               flag = false;
         }
         if (flag)
         {
            System.out.printf("%3d|%-15s|%-15s|%-15s|%-16s\n", count,
                    current.getSurname(), current.getFirstname(),
                    current.getPatronymic(), position);
            count++;
         }
      }
      while (itrStd.hasNext())
      {
         Student current = itrStd.next();
         if (current.getgName().getsName().getfName().getName()
                 .equals(FACULTY[chosenFaculty]))
         {
            System.out.printf("%3d|%-15s|%-15s|%-15s|%-16s\n", count,
                    current.getSurname(), current.getFirstname(),
                    current.getPatronymic(), current.getgName().getName());
            count++;
         }
      }
   }

   /**
    * Метод для вывода на экран заголовка таблицы с ограничением снизу.
    * @param printStr заголовок
    */
   public static void printTitleWithUnderScore(String printStr)
   {
      System.out.println(printStr);
      for (int i = 0; i < printStr.length(); i++)
         System.out.print("_");
      System.out.println();
   }
}
