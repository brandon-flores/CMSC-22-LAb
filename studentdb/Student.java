public class Student {
  private String studentNumber;
  private String firstName;
  private char middleInitial;
  private String lastName;
  private String course;
  private int yearLevel;
  
  public Student(){
  }
  
  public Student(String studentNumber, String firstName, char middleInitial, String lastName, String course, int yearLevel) {
    this.studentNumber = studentNumber;
    this.firstName = firstName;
    this.middleInitial = middleInitial;
    this.lastName = lastName;
    this.course = course;
    this.yearLevel = yearLevel;
  }
  
  public String getStudentNum() {
    return studentNumber;
  }
  public String getFirstName() {
    return firstName;
  }
  public char getMiddleInitial() {
    return middleInitial;
  }
  public String getLastName() {
    return lastName;
  }
  public String getCourse() {
    return course;
  }
  public int getYearLevel() {
    return yearLevel;
  }

  public void setStudentNum(String studentNumber) {
    this.studentNumber = studentNumber;
  }
  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }
  public void setMiddleInitial(char middleInitial) {
    this.middleInitial = middleInitial;
  }
  public void setLastName(String lastName) {
    this.lastName = lastName;
  }
  public void setCourse(String course) {
    this.course = course;
  }
  public void setYearLevel(int yearLevel) {
    this.yearLevel = yearLevel;
  }  
  
  public String toString(){
    return String.format("Student Number: %s\nName: %s, %s %c\nProgram: %s\nYear Level: %d", studentNumber, lastName, firstName, middleInitial, course, yearLevel);
  }
}