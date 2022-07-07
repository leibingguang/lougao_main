/**
 * @Description
 * @author lou_gao
 */
package lougao.status;

/**
 * 早上状态
 */
public class MorningStage extends WorkStage {
    @Override
    public void execute(Work work) {
        if (work.getHour() < 11) {
            System.out.println(String.format("早上%s点,状态满满!!!", work.getHour()));
        } else if (work.getHour() < 12) {
            System.out.println(String.format("早上%s点,需要补充能量!!!", work.getHour()));
        } else {
            work.setWorkStage(new AfternoonStage());
            work.doWork();
        }
    }
}
