package hello.refactoring.Chapter6;

import java.util.Arrays;
import java.util.List;

/*
* 알고리즘 전환
* */
public class SubstituteAlgorithmV2 {

    //이렇게 알고리즘을 바꿀때는 여러번의 테스트를 실시해야한다.
    String foundPerson(String[] people){
        List candidates = Arrays.asList(new String[] {"Don", "John", "Kent"});
        for(int i=0;i<people.length; i++){
            if(candidates.contains(people[i])) {
                return people[i];
            }
        }
        return "";
    }

}
