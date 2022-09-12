package hello.refactoring.Chapter8;

/*
* 베열을 객체로 전환
* 배열을 구성하는 원소가 다양한 의미를 가질 때는 객체로 전환하자.
* */
public class ReplaceArrayWithObjectV2 {

    public void teamInfo(){
        performance row = new performance();
        row.setTeam("리버풀");
        row.setWin("15");
        row.setLose("4");

        String name = row.getTeam();
        int wins = Integer.parseInt(row.getWin());
        int loses = Integer.parseInt(row.getLose());

    }

    class performance{
        private String _team;
        private String _win;
        private String _lose;

        public String getTeam() {
            return _team;
        }

        public void setTeam(String team) {
            this._team = team;
        }

        public String getWin() {
            return _win;
        }

        public void setWin(String win) {
            this._win = win;
        }

        public String getLose() {
            return _lose;
        }

        public void setLose(String lose) {
            this._lose = lose;
        }
    }
}
