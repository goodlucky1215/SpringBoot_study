package hello.refactoring.Chapter8;

import java.util.Set;

/*
* 컬렉션 캡슐화
*
* 컬렉션은 get()/set()의 읽기/쓰기 방식을 사용해서는 안된다.
* 참조 부분이 지나치게 노출 될 경우 무슨 일이 일어날지 모르기 때문이다.
* 일기 메서드는 컬력션 조작이 불가능한 형식을 반환하고 구조 정보는 감춰야 한다.
* 쓰기 메서드는 절대 있으면 안되고, 원소를 추가하는 메서드와 삭제하는 메서드를 대신 사용해야 한다.
* */
public class EncapsulateCollenctionV1 {

    class Course{
        public Course(String name, boolean isAdvaced){};
    }

    class Student{

        private Set _courses;

        public Set getCourses() {
            return _courses;
        }

        public void setCourses(Set courses) {
            this._courses = courses;
        }
    }
}
