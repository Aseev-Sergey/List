using System;
using System.Collections.Generic;
using System.Text;
using CourseProjectCSver.mainClasses.SecondaryClasses;

namespace CourseProjectCSver.mainClasses
{
    /**
 * Класс, описыващий преподателя по {@link Pulpit кафедре} и занимаемой на ней
 * {link Position должности}.
 *
 * @author Ассев С.С.
 * @version 1.1
 */
    class Teacher : Person
    {
        private Dictionary<Position, Pulpit> position;

        /**
         * Создаёт пустой Teacher объект.
         */
        public Teacher()
        {
            position = new Dictionary<Position, Pulpit>();
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
        public Teacher(string xsurN, string xfirstN, string xpatr, int xbirth,
                Dictionary<Position, Pulpit> position)
            : base(xsurN, xfirstN, xpatr, xbirth)
        {
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
        public Teacher(string xsurN, string xfirstN, string xpatr, int xbirth,
                string[] pulName, int[] audience, string[] phoneNumb,
                string[] fName, string[] posName, int[] salary)
            : base(xsurN, xfirstN, xpatr, xbirth)
        {
            
            this.position = new Dictionary<Position, Pulpit>();
            for (int i = 0; i < posName.Length; i++)
                if (pulName[i] != null)
                    position.Add(new Position(posName[i], salary[i]),
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
        public void addPosition(string pulName, int audience, string phoneNumb,
                string fName, string posName, int salary)
        {
            position.Add(new Position(posName, salary),
                    new Pulpit(pulName, audience, phoneNumb, new Faculty(fName)));
        }

        /**
         * Возвращает коллекцию Hashmap, описывающую преподавателя по кафедрам и
         * должностям, занимаемых на них.
         *
         * @return ссылку на Hashmap, содержащий информацию о
         * {@link Pulpit кафедре} и занимаемой на ней {link Position должности}
         */
        public Dictionary<Position, Pulpit> getPosition()
        {
            return position;
        }
    }
}
