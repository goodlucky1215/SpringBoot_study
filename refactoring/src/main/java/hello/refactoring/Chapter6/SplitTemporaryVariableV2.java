package hello.refactoring.Chapter6;

/*
* 임서변수 분리
* */
public class SplitTemporaryVariableV2 {
    double _primaryForce;
    double _secondaryForce;
    double _mass;
    int _delay = 1;

    double getDistanceTravelled(int time){
        
        double result;
        double primaryAcc = _secondaryForce / _mass; //acc의  용도가 다르면 구분해서 사용할 것.
        int primaryTime = Math.min(time, _delay);
        result = 0.5 * primaryAcc * primaryTime * primaryTime;
        int secondaryTime = time - _delay;
        if(secondaryTime>0){
            double primaryVel = primaryAcc *_delay;
            final double secondaryAcc = (_primaryForce + _secondaryForce) / _mass; //acc의  용도가 다르면 구분해서 사용할 것.
            result += primaryVel * secondaryTime + 0.5 * secondaryAcc * secondaryTime * secondaryTime;
        }
        return result;
    }
}
