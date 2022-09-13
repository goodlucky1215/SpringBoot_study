package hello.refactoring.Chapter8.ReplaceTypeCodeeWithSubclasses;

public class Enginner extends Employee{

    @Override
    int getType() {
        System.out.println("나는 엔지니어야~~");
        return Employee.ENCINEER;
    }
}
