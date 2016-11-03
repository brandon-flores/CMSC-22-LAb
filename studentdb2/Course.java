package studentdb;

import java.io.Serializable;

/**
 * Created by brandon on 11/3/2016.
 */
public class Course implements Serializable{
    private String courseCode;
    private String courseDescription;

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public String getCourseDescription() {
        return courseDescription;
    }

    public void setCourseDescription(String courseDiscription) {
        this.courseDescription = courseDiscription;
    }

    public String toString(){
        return String.format("Course Code: %s\nCourse Description: %s", courseCode, courseDescription);
    }

}
