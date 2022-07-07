/**
 * @Description
 * @author lou_gao
 */
package lougao.status;

/**
 * 工作
 */
public class Work {
    private WorkStage workStage;
    private Integer hour;
    private Boolean workFinished;

    public void setHour(Integer hour) {
        this.hour = hour;
    }

    public void setWorkFinished(Boolean workFinished) {
        this.workFinished = workFinished;
    }

    public Integer getHour() {
        return hour;
    }

    public Boolean getWorkFinished() {
        return workFinished;
    }

    public void setWorkStage(WorkStage workStage) {
        this.workStage = workStage;
    }

    public void doWork() {
        if (hour == null) {
            System.out.println("时间为空");
            return;
        }
        if (workStage == null) {
            workStage = new MorningStage();
        }
        workStage.execute(this);
    }
}
