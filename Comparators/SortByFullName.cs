using System;
using System.Collections.Generic;
using System.Text;
using CourseProjectCSver.mainClasses;

namespace CourseProjectCSver.Comparators
{
    /**
 * Класс-компаратор, сортирующий по ФИО.
 *
 * @author Асеев С.С.
 * @version 1.0
 */
    class SortByFullName : IComparer<Person>
    {
        /**
    * Переопределенный метод из интерфейса
    * {@link Comparator Comparator}, сравнивающий экземпляры класса
    * {@link Person Person}: сначала по фамилии, 
    * потом по имени и затем по отчеству при одинаковом значении оных.
    * @param obj1 первый объект, который нужно сравнить
    * @param obj2 второй объект, который нужно сравнить
    * @return отрицательное целое число, нуль или положительное целое число,
    * если первый аргумент меньше, равен или больше второго соответственно
    */
   public int Compare(Person obj1, Person obj2)
        {
            int compareResult;
            compareResult = obj1.getSurname().CompareTo(obj2.getSurname());
            if (compareResult == 0)
                compareResult = obj1.getFirstname().CompareTo(obj2.getFirstname());
            else
                return compareResult;
            if (compareResult == 0)
                compareResult = obj1.getPatronymic().CompareTo(obj2.getPatronymic());
            return compareResult;
        }
    }
}
