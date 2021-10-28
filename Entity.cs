using System;
using System.Collections.Generic;
using System.Text;

namespace CourseProjectCSver
{
    public class Entity
    {
        /**
    * string тип, используемый для хранения имени/наименования и т.п.
    */
        protected string name;

        /**
         * Конструктор по умолчанию.
         * 
         */
        public Entity()
        {
        }

        /**
    * Создает Entity объект с заданным параметром string.
    * @param name строка, содержащая имя/наименование и т.п.
    * 
    */
        public Entity(string name)
        {
            this.name = name;
        }

        /**
    * Возвращает имя/название типа string.
    * @return значение {@link Entity#name name} этого объекта
    * 
    */
        public string getName()
        {
            return name;
        }

        /**
         * Заменяет текущее значение {@link Entity#name name} этого объекта.
         * @param name устанавливает значение {@link Entity#name name} этого объекта
         */
        public void setName(string name)
        {
            this.name = name;
        }
    }
}
