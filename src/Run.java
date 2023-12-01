import java.util.Scanner;
import calcs.calc_percentage;

class course{
    public course(String _name, int max_degree)
    {
        courseName = _name;
        maxDegree = max_degree;
    }
    public course(String _name, int max_degree, int degree)
    {
        courseName = _name;
        maxDegree = max_degree;
        courseDegree = degree;
    }
    public String courseName;
    public int courseDegree;
    public char courseGrade = '#';
    public boolean isPassed = true;
    public int maxDegree;
}
class student
{
    course[] courses = new course[10];
    public String name;
    public int age;
    private int id;
    private int coursesCount = 0;

    public student(String _name, int _age, int _id)
    {
        name = _name;
        age = _age;
        id = _id;
    }

    /// setters
    public void addCourse(String courseName, int maxDegree, int degree)
    {
        courses[coursesCount] = new course(courseName, maxDegree, degree);
        if(degree >= 90)
            setGrade(coursesCount, 'A');
        else if(degree >= 80)
            setGrade(coursesCount, 'B');
        else if(degree >= 70)
            setGrade(coursesCount, 'C');
        else if(degree >= 60)
            setGrade(coursesCount, 'D');
        else if(degree >= 50)
            setGrade(coursesCount, 'E');
        else {
            setGrade(coursesCount, 'F');
            setFailed(coursesCount);
        }

        coursesCount++;
    }
    public void setDegree(String courseName, int newDegree)
    {
        int ind = -1;
        for(int i = 0; i<10; i++)
        {
            if(courses[i].courseName == courseName)
            {
                ind = i;
                break;
            }
        }
        if(ind != -1)
            courses[ind].courseDegree = newDegree;
    }
    public int coursesCount(){return coursesCount;}
    void setPassed(String courseName)
    {
        int ind = -1;
        for(int i = 0; i<10; i++)
        {
            if(courses[i].courseName == courseName)
            {
                ind = i;
                break;
            }
        }
        if(ind != -1)
           courses[ind].isPassed = true;
    }

    void setGrade(int ind, char _grade)
    {
       courses[ind].courseGrade = _grade;
    }

    void setFailed(int ind)
    {
       courses[ind].isPassed = false;
    }
    // getters
    public float getPercentage()
    {
        int sum = 0,dsum = 0;
        for(int i = 0; i<coursesCount; i++)
        {
            dsum += courses[i].courseDegree;
            sum += courses[i].maxDegree;
        }
        calc_percentage calc = new calc_percentage(sum, dsum);
        return calc.per;
    }

    boolean isBased(String courseName)
    {
        int ind = -1;
        for(int i = 0; i<10; i++)
        {
            if(courses[i].courseName == courseName)
            {
                ind = i;
                break;
            }
        }
        return courses[ind].isPassed;
    }

    void introduce()
    {
        System.out.printf("[name] %s%n[age] %d%n[id] %s%n---[courses]---%n", name, age, id);
        System.out.printf("[course name]");
        for(int i = 0; i<coursesCount; i++)
        {
            System.out.print(" " + courses[i].courseName);
        }

        System.out.printf("%n[course degree]");
        for(int i = 0; i<coursesCount; i++)
        {
            System.out.print(" " + courses[i].courseDegree);
        }

        System.out.printf("%n[course grade]");
        for(int i = 0; i<coursesCount; i++)
        {
            System.out.print(" " + courses[i].courseGrade);
        }
    }



}



public class Run
{
    public static void adde(int f, int s)
    {
        return (s + f);
    }

    public static void main(String[] args)
    {
        student s1 = new student("mohamed", 19, 2022170379);
        s1.addCourse("math", 100, 95);
        s1.addCourse("physics", 100, 80);
        s1.introduce();
        System.out.print(s1.getPercentage());



    }

}
