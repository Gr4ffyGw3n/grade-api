package use_case;
import api.GradeDB;
import entity.Grade;
import entity.Team;

public final class GetAverageGradeUseCase {
    private final GradeDB gradeDB;

    public GetAverageGradeUseCase(GradeDB gradeDB) {
        this.gradeDB = gradeDB;
    }

    public float getAverageGrade(String course) {
        Team team = gradeDB.getMyTeam();
        GetGradeUseCase fetchGrade = new GetGradeUseCase(gradeDB);
        String[] members = team.getMembers();
        float gradeSum = 0.0f;
        for(String member: members){
            Grade memberGrade = fetchGrade.getGrade(member, course);

            gradeSum += memberGrade.getGrade();
        }
        return gradeSum / members.length;
    }
}
