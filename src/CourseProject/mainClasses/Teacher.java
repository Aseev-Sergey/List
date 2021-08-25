package CourseProject.mainClasses;

import CourseProject.mainClasses.SecondaryClasses.Faculty;
import CourseProject.mainClasses.SecondaryClasses.Position;
import CourseProject.mainClasses.SecondaryClasses.Pulpit;
import java.util.HashMap;

/**
 * Класс, описыващий преподателя по {@link Pulpit кафедре} и занимаемой на ней
 * {link Position должности}.
 *
 * @author Ассев С.С.
 * @version 1.1
 */
public class Teacher extends Person
{

   private HashMap<Position, Pulpit> position;

   /**
    * Создаёт пустой Teacher объект.
    */
   public Teacher()
   {
      position = new HashMap();
   }

   /**
    * Создает полностью описанный Teacher объект.
    *
    * @param xsurN фамилия
    * @param xfirstN имя
    * @param xpatr отчество
    * @param xbirth год рождения
    * @param position информация о кафедре и должности, занимаемой на ней
    * преподавателем
    */
   public Teacher(String xsurN, String xfirstN, String xpatr, int xbirth,
           HashMap<Position, Pulpit> position)
   {
      super(xsurN, xfirstN, xpatr, xbirth);
      this.position = position;
   }

   /**
    * Создает полностью описанный Teacher объект с учётом того, что преподаватель
    * работает на нескольких кафедрах.
    *
    * @param xsurN фамилия
    * @param xfirstN имя
    * @param xpatr отчество
    * @param xbirth год рождения
    * @param pulName массив данных, содержащих наименования кафедр, на которых
    * работает преподаватель
    * @param audience массив данных, содержащий кабинеты кафедр
    * @param phoneNumb массив данных, содержащий номера телефонов кафедр
    * @param fName массив данных, содержащий названия факультетов, к которым
    * относятся кафедры
    * @param posName массив данных, содержащий название должности преподавателей
    * на задаваемых кафедрах
    * @param salary массив данных, содержащий оклад преподавателей по занимаемым
    * должностям на кафедрах
    */
   public Teacher(String xsurN, String xfirstN, String xpatr, int xbirth,
           String[] pulName, int[] audience, String[] phoneNumb,
           String[] fName, String[] posName, int[] salary)
   {
      super(xsurN, xfirstN, xpatr, xbirth);
      this.position = new HashMap();
      for (int i = 0; i < posName.length; i++)
         if (pulName[i] != null)
            position.put(new Position(posName[i], salary[i]),
                    new Pulpit(pulName[i], audience[i], phoneNumb[i],
                            new Faculty(fName[i])));
   }

   /**
    * Метод, добавляющий информацию о {@link Pulpit кафедре}, на которой
    * работает преподаватель.
    *
    * @param pulName наименование кафедры
    * @param audience номер кабинета
    * @param phoneNumb номер телефона
    * @param fName название факультета, к которому относится кафедра
    * @param posName название занимаемой преподавателем должности на кафедре
    * @param salary оклад занимаемой преподавателем должности на кафедре
    */
   public void addPosition(String pulName, int audience, String phoneNumb,
           String fName, String posName, int salary)
   {
      position.put(new Position(posName, salary),
              new Pulpit(pulName, audience, phoneNumb, new Faculty(fName)));
   }

   /**
    * Возвращает коллекцию Hashmap, описывающую преподавателя по кафедрам и
    * должностям, занимаемых на них.
    *
    * @return ссылку на Hashmap, содержащий информацию о
    * {@link Pulpit кафедре} и занимаемой на ней {link Position должности}
    */
   public HashMap<Position, Pulpit> getPosition()
   {
      return position;
   }
}
