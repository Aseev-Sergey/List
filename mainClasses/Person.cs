using System;
using System.Collections.Generic;
using System.Text;

namespace CourseProjectCSver.mainClasses
{
    /**
 * Класс-родитель, описывающий человек по ФИО и дате рождения.
 * @author Асеев С.С.
 * @version 1.1
 */
    class Person : Entity
    {
        private string surname;
        private string patronymic;
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
        public Person(string xsurN, string xfirstN, string xpatr, int xbirth)
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
        public string getSurname()
        {
            return surname;
        }

        /**
         * Возвращает имя.
         * @return строку, содержащую имя
         */
        public string getFirstname()
        {
            return name;
        }

        /**
         * Возвращает отчество.
         * @return строку, содержащую отчество
         */
        public string getPatronymic()
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
        public void setSurname(string xsurN)
        {
            surname = xsurN;
        }

        /**
         * Задаёт имя.
         * @param xfirstN новое имя
         */
        public void setFirstName(string xfirstN)
        {
            name = xfirstN;
        }

        /**
         * Задаёт отчество.
         * @param xpatr новое отчество
         */
        public void setPatronymic(string xpatr)
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
}
