import java.util.Scanner;

class ReturnObj {
    int totalMarks;
    float avg;
    char grade;

    public ReturnObj(){}

    public ReturnObj(int totalMarks, float avg, char grade){
        this.totalMarks = totalMarks;
        this.avg = avg;
        this.grade = grade;
    }


}

public class StudentGradeCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please input your marks: ");

        System.out.println("Maths: ");
        int maths = sc.nextInt();
        System.out.println("Physics: ");
        int physics = sc.nextInt();
        System.out.println("Chemistry: ");
        int chemistry = sc.nextInt();

        ReturnObj result = gradeCalculator(maths,physics,chemistry);

        System.out.println("Your Total Marks are: " + result.totalMarks);
        System.out.println(("Your Percents are: ") + result.avg);
        System.out.println(("your Grade is: ") + result.grade);
    }
    public static ReturnObj gradeCalculator(int maths, int physics, int chemistry){

        int totalMarks = maths+physics+chemistry;

        float avgPercent = Math.round((totalMarks/3F) * 100) / 100.0f;;

        char grade;
        if(avgPercent>=0 && avgPercent<30){
            grade = 'F';
        }
        else if(avgPercent>=30 && avgPercent<50){
            grade= 'E';
        }
        else if(avgPercent>=50 && avgPercent<70){
            grade = 'D';
        }
        else if(avgPercent>=70 && avgPercent<80){
            grade = 'C';
        }
        else if(avgPercent>=80 && avgPercent<90){
            grade = 'B';
        }
        else{
            grade = 'A';
        }

        return new ReturnObj(totalMarks,avgPercent,grade);
    }
}
