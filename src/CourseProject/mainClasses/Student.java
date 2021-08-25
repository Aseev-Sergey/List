package CourseProject.mainClasses;

import CourseProject.mainClasses.SecondaryClasses.Group;

/**
 * Класс, описывающий студента по {@link Group группе}, курсу, номеру зачётной
 * книжки, форме обучения, отделению, году поступления
 * @author Асеев С.С.
 * @version 1.1
 */
public class Student extends Person
{

   private Group gName;
   private int course;
   private String recordBook;
   private int formOfStudy;
   private boolean department;
   private int yearOfReceipt;

   /**
    * Создаёт пустой Student объект.
    */
   public Student()
   {
   }

   /**
    * Создает полностью описанный Student объект.
    * @param xsurN фамилия
    * @param xfirstN имя
    * @param xpatr отчество
    * @param xbirth год рождения
    * @param gName {@link Group группа}
    * @param course номер курса
    * @param recordBook номер зачётной книжки
    * @param formOfStudy форма обучения
    * @param department отделение обучающегося студента
    * @param yearOfReceipt год поступления
    */
   public Student(String xsurN, String xfirstN, String xpatr, int xbirth,
           Group gName, int course, String recordBook, int formOfStudy,
           boolean department, int yearOfReceipt)
   {
      super(xsurN, xfirstN, xpatr, xbirth);
      this.gName = gName;
      this.course = course;
      this.recordBook = recordBook;
      this.formOfStudy = formOfStudy;
      this.department = department;
      this.yearOfReceipt = yearOfReceipt;
   }

   /**
    * Возвращает группу.
    * @return ссылку на экземпляр {@link Group группы} студента
    */
   public Group getgName()
   {
      return gName;
   }

   /**
    * Возвращает номер курса.
    * @return целое число, содержащее номер курса
    */
   public int getCourse()
   {
      return course;
   }

   /**
    * Возвращает номер зачётной книжки.
    * @return строку, содержащую номер зачётной книжки
    */
   public String getRecordBook()
   {
      return recordBook;
   }

   /**
    * Возвращает форму обучения.
    * @return строку, содержащую форму обучения студента, в зависимости от
    * установленного значения.
    * <br><br>
    * 0 - "Очная"<br>
    * 1 - "Заочная"<br>
    * 2 - "Очно-заочная"<br>
    * остальные - "Нет информации"
    */
   public String getFormOfStudy()
   {
      switch (formOfStudy)
      {
         case 0:
            return "Очная";
         case 1:
            return "Заочная";
         case 2:
            return "Очно-заочная";
         default:
            return "Нет информации";
      }
   }

   /**
    * Возвращает отделение обучающегося студента.
    * @return строку, содержащую отделение, в зависимости от boolean значения
    * <br><br>
    * true - "Бюджетное"<br>
    * false - "Платное"
    */
   public String getDepartment()
   {
      return department ? "Бюджетное" : "Платное";
   }

   /**
    * Возвращает год поступления.
    * @return целое число, содержащее год поступления
    */
   public int getYearOfReceipt()
   {
      return yearOfReceipt;
   }

   /**
    * Задаёт группу.
    * @param gName новая ссылка на группу студента
    */
   public void setgName(Group gName)
   {
      this.gName = gName;
   }

   /**
    * Задаёт номер курса.
    * @param course новый номер курса
    */
   public void setCourse(int course)
   {
      this.course = course;
   }

   /**
    * Задаёт номер зачётной книжки.
    * @param recordBook новый номер зачётной книжки
    */
   public void setRecordBook(String recordBook)
   {
      this.recordBook = recordBook;
   }

   /**
    * Задаёт форму обучения.
    * <br><br>
    * Для корректной работы следует задавать следующие значения:<br>
    * 0 - "Очная"<br>
    * 1 - "Заочная"<br>
    * 2 - "Очно-заочная"
    * @param formOfStudy целое число, означающее определенную форму обучения
    */
   public void setFormOfStudy(int formOfStudy)
   {
      this.formOfStudy = formOfStudy;
   }

   /**
    * Задаёт отделение обучаемого.
    * <br><br>
    * Для корректной работы следует задавать следующие значения:<br>
    * true - "Бюджетное"<br>
    * false - "Платное"
    * @param department новое логическое значение, определяющее отделение
    */
   public void setDepartment(boolean department)
   {
      this.department = department;
   }

   /** 
    * Задаёт год поступления.
    * @param yearOfReceipt новый год поступления
    */
   public void setYearOfReceipt(int yearOfReceipt)
   {
      this.yearOfReceipt = yearOfReceipt;
   }
}
