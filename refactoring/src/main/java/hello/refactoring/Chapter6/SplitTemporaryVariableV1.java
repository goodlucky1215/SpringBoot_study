package hello.refactoring.Chapter6;

/*
* 임서변수 분리
* */
public class SplitTemporaryVariableV1 {
    double _primaryForce;
    double _secondaryForce;
    double _mass;
    int _delay = 1;

    double getDistanceTravelled(int time){
        
        double result;
        double acc = _secondaryForce / _mass; //acc의 첫번째 용도
        int primaryTime = Math.min(time, _delay);
        result = 0.5 * acc * primaryTime * primaryTime;
        int secondaryTime = time - _delay;
        if(secondaryTime>0){
            double primaryVel = acc*_delay;
            acc = (_primaryForce + _secondaryForce) / _mass; //acc의 두번째 용도
            result += primaryVel * secondaryTime + 0.5 * acc * secondaryTime * secondaryTime;
        }
        return result;
    }
}
