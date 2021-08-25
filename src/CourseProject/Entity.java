package CourseProject;

/**
 * Класс-родитель описывает параметр имени для классов-наследников.
 * @author Асеев С.С.
 * @version 1.0
 */
public class Entity
{

   /**
    * String тип, используемый для хранения имени/наименования и т.п.
    */
   protected String name;

   /**
    * Создаёт пустой Entity объект.
    * 
    */
   public Entity()
   {
   }

   /**
    * Создает Entity объект с заданным параметром String.
    * @param name строка, содержащая имя/наименование и т.п.
    * 
    */
   public Entity(String name)
   {
      this.name = name;
   }

   /**
    * Возвращает имя/название типа String.
    * @return значение {@link Entity#name name} этого объекта
    * 
    */
   public String getName()
   {
      return name;
   }

   /**
    * Заменяет текущее значение {@link Entity#name name} этого объекта.
    * @param name устанавливает значение {@link Entity#name name} этого объекта
    */
   public void setName(String name)
   {
      this.name = name;
   }
}
