package hello.refactoring.Chapter8;

import org.springframework.util.Assert;

import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/*
* 컬렉션 캡슐화
*
* 컬렉션은 get()/set()의 읽기/쓰기 방식을 사용해서는 안된다.
* 참조 부분이 지나치게 노출 될 경우 무슨 일이 일어날지 모르기 때문이다.
* 일기 메서드는 컬력션 조작이 불가능한 형식을 반환하고 구조 정보는 감춰야 한다.
* 쓰기 메서드는 절대 있으면 안되고, 원소를 추가하는 메서드와 삭제하는 메서드를 대신 사용해야 한다.
* */
public class EncapsulateCollenctionV2 {

    void tests(){

        Student kent = new Student();
        Set s = new HashSet();
        s.add(new Course("math",false));
        s.add(new Course("english",true));
        kent.initializeCourses(s);

        //새로 추가시
        kent.addCourses(new Course("gogo",true));
    }

    class Course{
        public Course(String name, boolean isAdvaced){};
    }

    class Student{

        private Set _courses = new HashSet();

        public Set getCourses() {
            return Collections.unmodifiableSet(_courses); //수정 불가뷰를 반환시켜서 get으로 가져와서 수정하지 못하도록 막을 수 있다.
        }

        public void initializeCourses(Set arg){
            Assert.isTrue(_courses.isEmpty());
            _courses.addAll(arg);
        }

        public void addCourses(Course courses) {
            this._courses.add(courses);
        }
        public void removeCourses(Course courses) {
            this._courses.remove(courses);
        }
    }
}
