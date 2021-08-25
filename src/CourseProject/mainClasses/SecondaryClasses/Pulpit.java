package CourseProject.mainClasses.SecondaryClasses;

import CourseProject.Entity;

/**
 * Класс, описывающий кафедру по названию, её номеру кабинета, контактному
 * телефону и названию {@link Faculty факультета}.
 * @author Асеев С.С.
 * @version 1.1
 */
public class Pulpit extends Entity
{
   private int audience;
   private String phoneNumb;
   private Faculty fName;

   /**
    * Создаёт пустой Pulpit объект.
    */
   public Pulpit()
   {
   }

   /**
    * Создает полностью описанный Pulpit объект.
    * @param name наименование кафедры
    * @param audience номер кабинета
    * @param phoneNumb контактный номер телефона
    * @param fName информация о {@link Faculty факультете}, к которому
    * относится кафедра
    */
   public Pulpit(String name, int audience, String phoneNumb, Faculty fName)
   {
      this.name = name;
      this.audience = audience;
      this.phoneNumb = phoneNumb;
      this.fName = fName;
   }

   /**
    * Возвращает номер кабинета.
    * @return целочисленное число, содержащее номер кабинета кафедры
    */
   public int getAudience()
   {
      return audience;
   }

   /**
    * Возвращает контактный номер телефона.
    * @return строку, содержащую контактный номер телефона кафедры с кодом
    * города
    */
   public String getPhoneNumb()
   {
      return phoneNumb;
   }

   /**
    * Возвращает факультет.
    * @return ссылку на экземпляр {@link Faculty факультета}, к которой
    * относится кафедра
    */
   public Faculty getfName()
   {
      return this.fName;
   }

   /**
    * Задаёт номер кабинета.
    * @param audience новый номер кабинета кафедры
    */
   public void setAudience(int audience)
   {
      this.audience = audience;
   }

   /**
    * Задаёт контактный номер телефона
    * @param phoneNumb задаваемый контактный номер телефона кафедры
    * <br><br>
    * Формат - "+7(472)xxx-xx-xx", где x - цифры от 0 до 9
    */
   public void setPhoneNumb(String phoneNumb)
   {
      this.phoneNumb = phoneNumb;
   }

   /**
    * Задаёт факультет.
    * @param fName новая ссылка на факультет, к которой относится кафедра
    */
   public void setfName(Faculty fName)
   {
      this.fName = fName;
   }
}
