/**
 * @Description
 * @author lou_gao
 */
package lougao.status;

/**
 * 下午状态
 */
public class AfternoonStage extends WorkStage {
    @Override
    public void execute(Work work) {
        if (work.getHour() < 14) {
            System.out.println(String.format("下午%s点,午休时间,补充精力，下午再战!!!", work.getHour()));
        } else if (work.getHour() < 17) {
            System.out.println(String.format("下午%s点,集中注意力,为了早点下班!!!", work.getHour()));
        } else if (work.getHour() < 18) {
            System.out.println(String.format("下午%s点,你的工作干完了吗？你晚上能陪女朋友逛街不!!!", work.getHour()));
        } else {
            work.setWorkStage(new EveningStage());
            work.doWork();
        }
    }
}
