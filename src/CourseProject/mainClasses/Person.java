package CourseProject.mainClasses;

import CourseProject.Entity;

/**
 * Класс-родитель, описывающий человек по ФИО и дате рождения.
 * @author Асеев С.С.
 * @version 1.1
 */
public class Person extends Entity
{

   private String surname;
   private String patronymic;
   private int yearOfBirth;

   /**
    * Создаёт пустой Person объект.
    */
   public Person()
   {
   }

   /**
    * Создает полностью описанный Person объект.
    * @param xsurN фамилия
    * @param xfirstN имя
    * @param xpatr отчество
    * @param xbirth год рождения
    */
   public Person(String xsurN, String xfirstN, String xpatr, int xbirth)
   {
      surname = xsurN;
      name = xfirstN;
      patronymic = xpatr;
      yearOfBirth = xbirth;
   }

   /**
    * Возвращает фамилию.
    * @return строку, содержащую фамилию
    */
   public String getSurname()
   {
      return surname;
   }

   /**
    * Возвращает имя.
    * @return строку, содержащую имя
    */
   public String getFirstname()
   {
      return name;
   }

   /**
    * Возвращает отчество.
    * @return строку, содержащую отчество
    */
   public String getPatronymic()
   {
      return patronymic;
   }

   /**
    * Возвращает дату рождения.
    * @return целое число, содержащее дату рождения
    */
   public int getYearOfBirth()
   {
      return yearOfBirth;
   }

   /**
    * Задаёт фамилию.
    * @param xsurN новая фамилия
    */
   public void setSurname(String xsurN)
   {
      surname = xsurN;
   }

   /**
    * Задаёт имя.
    * @param xfirstN новое имя
    */
   public void setFirstName(String xfirstN)
   {
      name = xfirstN;
   }

   /**
    * Задаёт отчество.
    * @param xpatr новое отчество
    */
   public void setPatronymic(String xpatr)
   {
      patronymic = xpatr;
   }

   /**
    * Задаёт год рождения.
    * @param xbirth новая дата рождения
    */
   public void setYearOfBirth(int xbirth)
   {
      yearOfBirth = xbirth;
   }
}
