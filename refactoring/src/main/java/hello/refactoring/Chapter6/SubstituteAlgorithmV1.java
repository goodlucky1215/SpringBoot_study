package hello.refactoring.Chapter6;

/*
* 알고리즘 전환
* */
public class SubstituteAlgorithmV1 {


    String foundPerson(String[] people){
        for(int i=0;i<people.length; i++){
            if(people[i].equals("Don")){
                return "Don";
            }
            else if(people[i].equals("John")){
                return "John";
            }
            else if(people[i].equals("Kent")){
                return "Kent";
            }
        }
        return "";
    }

}
