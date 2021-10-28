using System;
using System.IO;
using System.Collections;
using System.Collections.Generic;
using System.Text;
using CourseProjectCSver.mainClasses;
using CourseProjectCSver.mainClasses.SecondaryClasses;


namespace CourseProjectCSver
{
    /**
    * Абстрактный класс, описывающий заполнение списков из базы данных и их
    * вывод на экран.
    * @author Асеев С.С.
    * @version 1.0
    */
    class OutputOnDisplay
    {

        /**
         * Метод для чтения из базы данных.
         * @param arg имя списка, используемого как база данных
         * @param listOfStudents список студентов
         * @param listOfTeachers список преподавателей
         */
        public static void readFromFile(string arg, SortedSet<Student> listOfStudents,
                SortedSet<Teacher> listOfTeachers)
        {
            try
            {
                StreamReader sc = new StreamReader(arg,
                    Encoding.GetEncoding(1251));
                string[] scStr = null;
                while (!(sc.EndOfStream))
                {
                    int index = 0;
                    string surname, firstname, patronymic;
                    int yearOfBirthday;
                    int yearOfReceit = 0;
                    scStr = sc.ReadLine().Split(';');
                    surname = scStr[index++];
                    firstname = scStr[index++];
                    patronymic = scStr[index++];
                    yearOfBirthday = int.Parse(scStr[index++]);
                    if (int.TryParse(scStr[index], out yearOfReceit))
                    {
                        int course = int.Parse(scStr[++index]),
                            formOfStudy = int.Parse(scStr[++index]),
                            departmentInt = int.Parse(scStr[++index]);
                        bool department = false;
                        string recordBook = scStr[++index],
                            groupName = scStr[++index],
                            pulpit = scStr[++index],
                            cipher = scStr[++index],
                            faculty = scStr[++index];
                        if (departmentInt == 1)
                            department = true;
                        listOfStudents.Add(new Student(surname, firstname, patronymic,
                                    yearOfBirthday, new Group(groupName,
                                    new Specialization(pulpit.ToString().Trim(), cipher,
                                    new Faculty(faculty.ToString().Trim()))), course, recordBook,
                                    formOfStudy, department, yearOfReceit));
                    }
                    else
                    {
                        string[] pulpit = new string[2],
                            faculty = new string[pulpit.Length],
                            phone = new string[pulpit.Length],
                            position = new string[pulpit.Length];
                        int[] audience = new int[pulpit.Length],
                                salary = new int[pulpit.Length];
                        for (int i = 0; i < pulpit.Length && index < scStr.Length; i++)
                        {
                            pulpit[i] = scStr[index];
                            audience[i] = int.Parse(scStr[++index]);
                            phone[i] = scStr[++index];
                            faculty[i] = scStr[++index];
                            position[i] = scStr[++index];
                            salary[i] = int.Parse(scStr[++index]);
                            index++;
                        }
                        listOfTeachers.Add(new Teacher(surname, firstname, patronymic,
                                yearOfBirthday, pulpit, audience, phone, faculty,
                                position, salary));
                    }
                }
            }
            catch (FileNotFoundException exc)
            {
                Console.WriteLine("Файл не найден");
            }
        }

            /**
             * Метод для вывода на экран списка студентов.
             * @param listOfStudents список студентов
             */
            public static void showStudents(SortedSet<Student> listOfStudents)
        {
            IEnumerator<Student> itr = listOfStudents.GetEnumerator();
            int count = 1;
            printTitleWithUnderScore("#  |    Фамилия    |      Имя      |   Отчество    |"
                    + "год рождения|год поступления|курс|форма обучения|отделение|"
                    + "группа|шифр специализации|# зачетной книжки|"
                    + "                      факультет                      |");
            while (itr.MoveNext())
            {
                Student current = itr.Current;
                Console.WriteLine ("{0,3}|{1,-15}|{2,-15}|{3,-15}|{4,12}|" +
                    "{5,15}|{6,4}|{7,-14}|{8,-9}|{9,6}|{10,18}|{11,17}" +
                    "|{12,-53}|", count, current.getSurname(),
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
        public static void showTeachers(SortedSet<Teacher> listOfTeachers)
        {
            IEnumerator<Teacher> itr = listOfTeachers.GetEnumerator();
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
            while (itr.MoveNext())
            {
                Teacher current = itr.Current;
                IDictionaryEnumerator itrForD;
                itrForD = current.getPosition().GetEnumerator(); 
                Console.Write("{0,3}|{1,-15}|{2,-15}|{3,-15}|{4,12}|", count,
                        current.getSurname(), current.getFirstname(),
                        current.getPatronymic(), current.getYearOfBirth());
                while (itrForD.MoveNext())
                {
                    Console.Write("{0,-75}|{1,-53}|{2,-17}|",
                            ((Pulpit)itrForD.Value).getName(),
                            ((Pulpit)itrForD.Value).getfName().getName(),
                            ((Position)itrForD.Key).getName());
                    
                }
                Console.WriteLine();
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
        public static void showFaculties(string[] FACULTY, int chosenFaculty,
                SortedSet<Student> listOfStudents, SortedSet<Teacher> listOfTeachers)
        {
            IEnumerator<Student> itrStd = listOfStudents.GetEnumerator();
            IEnumerator<Teacher> itrTch = listOfTeachers.GetEnumerator();
            int count = 1;
            printTitleWithUnderScore("#  |    Фамилия    |      Имя      |   Отчество    |"
                    + "группа/должность");
            while (itrTch.MoveNext())
            {
                bool flag = false;
                Teacher current = itrTch.Current;
                IDictionaryEnumerator itrForD;
                itrForD = current.getPosition().GetEnumerator();
                string position = null;
                while (itrForD.MoveNext())
                {
                    if (((Pulpit)itrForD.Value).getfName().getName()
                            .Equals(FACULTY[chosenFaculty]))
                    {
                        flag = true;
                        position = ((Position)itrForD.Key).getName();
                    }
                    else
                        flag = false;
                }
                if (flag)
                {
                    Console.WriteLine("{0,3}|{1,-15}|{2,-15}|{3,-15}|{4,-16}", count,
                            current.getSurname(), current.getFirstname(),
                            current.getPatronymic(), position);
                    count++;
                }
            }
            while (itrStd.MoveNext())
            {
                Student current = itrStd.Current;
                if (current.getgName().getsName().getfName().getName()
                        .Equals(FACULTY[chosenFaculty]))
                {
                    Console.WriteLine("{0,3}|{1,-15}|{2,-15}|{3,-15}|{4,-16}", count,
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
        public static void printTitleWithUnderScore(string printStr)
        {
            Console.WriteLine(printStr);
            for (int i = 0; i < printStr.Length; i++)
                Console.Write("_");
            Console.WriteLine();
        }
    }
}
