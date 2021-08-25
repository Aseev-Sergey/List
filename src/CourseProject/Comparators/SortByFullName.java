package CourseProject.Comparators;

import CourseProject.mainClasses.Person;
import java.util.Comparator;

/**
 * Класс-компаратор, сортирующий по ФИО.
 *
 * @author Асеев С.С.
 * @version 1.0
 */
public class SortByFullName implements Comparator<Person>
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
   @Override
   public int compare(Person obj1, Person obj2)
   {
      int compareResult;
      compareResult = obj1.getSurname().compareTo(obj2.getSurname());
      if (compareResult == 0)
         compareResult = obj1.getFirstname().compareTo(obj2.getFirstname());
      else
         return compareResult;
      if (compareResult == 0)
         compareResult = obj1.getPatronymic().compareTo(obj2.getPatronymic());
      return compareResult;
   }
}
