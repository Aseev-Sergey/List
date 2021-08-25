package CourseProject.mainClasses.SecondaryClasses;

import CourseProject.Entity;

/**
 * Класс, описывающую должность по названию и окладу.
 * @author Асеев С.С.
 * @version 1.1
 */
public class Position extends Entity
{
   private int salary;

   /**
    * Создаёт пустой Position объект.
    */
   public Position()
   {
   }

   /**
    * Создает полностью описанный Position объект.
    * @param name наименование
    * @param salary оклад
    */
   public Position(String name, int salary)
   {
      this.name = name;
      this.salary = salary;
   }
   
   /**
    * Возвращает оклад.
    * @return целое число, содержащее оклад
    */
   public int getSalary()
   {
      return salary;
   }

   /**
    * Задаёт оклад.
    * @param salary новый оклад
    */
   public void setSalary(int salary)
   {
      this.salary = salary;
   }
}
