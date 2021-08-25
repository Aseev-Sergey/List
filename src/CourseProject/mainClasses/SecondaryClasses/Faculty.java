package CourseProject.mainClasses.SecondaryClasses;

import CourseProject.Entity;

/**
 * Класс, описывающий факультет по названию
 * @author Асеев С.С.
 * @version 1.1
 */
public class Faculty extends Entity
{

   /**
    * Создаёт пустой Faculty объект.
    */
   public Faculty()
   {
   }

   /**
    * Создает полностью описанный Faculty объект.
    * @param name название факультета
    */
   public Faculty(String name)
   {
      this.name = name;
   }
}
