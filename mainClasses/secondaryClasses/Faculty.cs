using System;
using System.Collections.Generic;
using System.Text;

namespace CourseProjectCSver.mainClasses.SecondaryClasses
{
    /**
 * Класс, описывающий факультет по названию
 * @author Асеев С.С.
 * @version 1.1
 */
    public class Faculty : Entity
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
    public Faculty(string name)
    {
        this.name = name;
    }
}
}
