using System;
using System.Collections.Generic;
using System.Text;

namespace CourseProjectCSver.mainClasses.SecondaryClasses
{
    /**
 * Класс, описывающий специализацию по названию, шифру и
 * {@link Faculty факультету}, к которому она относится.
 *
 * @author Асеев С.С.
 * @version 1.1
 */
    class Specialization : Entity
    {
        private string cipher;
        private Faculty fName;

        /**
         * Создаёт пустой Specialization объект.
         */
        public Specialization()
        {

        }

        /**
         * Создает полностью описанный Specialization объект.
         * @param name название
         * @param cipher шифр
         * @param fName информация о {@link Faculty факультете}, к которому относится
         * специализация
         */
        public Specialization(string name, string cipher, Faculty fName)
        {
            this.name = name;
            this.cipher = cipher;
            this.fName = fName;
        }

        /**
         * Возвращает шифр.
         * @return строку, содержащую шифр данной специализации
         */
        public string getCipher()
        {
            return cipher;
        }

        /**
         * Возвращает факультет.
         * @return ссылку на экземпляр {@link Faculty факультета}, к которой
         * относится специализация
         */
        public Faculty getfName()
        {
            return fName;
        }

        /**
         * Задаёт шифр.
         * @param cipher новый шифр специализации в виде строки.
         * <br><br>
         * Формат "xx.xx.xx", где x - цифры от 0 до 9
         */
        public void setCipher(string cipher)
        {
            this.cipher = cipher;
        }

        /**
         * Задаёт факультет.
         * @param fName новая ссылка на факультет, к которой относится специализация
         */
        public void setfName(Faculty fName)
        {
            this.fName = fName;
        }
    }
}
