using System;
using System.Collections.Generic;
using System.Text;

namespace CourseProjectCSver.mainClasses.SecondaryClasses
{
    /**
 * Класс, описывающий группу по названию и {@link Specialization специализации}
 * @author Ассев С.С.
 * @version 1.1
 */
    class Group : Entity
    {
        private Specialization sName;

        /**
         * Создаёт пустой Group объект.
         */
        public Group()
        {
        }

        /**
         * Создает полностью описанный Group объект.
         * @param name идентификатор группы
         * @param sName информация о {@link Specialization специализации}
         */
        public Group(string name, Specialization sName)
        {
            this.name = name;
            this.sName = sName;
        }

        /**
         * Возвращает специализацию.
         * @return ссылку на экземпляр {@link Specialization специализации}, к
         * которой относится данная группа
         */
        public Specialization getsName()
        {
            return sName;
        }

        /**
         * Задаёт специализацию.
         * @param sName новая ссылка на специализацию
         */
        public void setsName(Specialization sName)
        {
            this.sName = sName;
        }
    }
}
