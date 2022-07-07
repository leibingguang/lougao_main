/**
 * @Description
 * @author lou_gao
 */
package lougao.status;

/**
 * 晚上状态
 */
public class EveningStage extends WorkStage {
    @Override
    public void execute(Work work) {
        if (work.getWorkFinished() != null && work.getWorkFinished()) {
            System.out.println(String.format("晚上%s点,下班回家陪女朋友!!!", work.getHour()));
            return;
        }
        if (work.getHour() < 20) {
            System.out.println(String.format("晚上%s点,加班正式开始!!!", work.getHour()));
        } else if (work.getHour() < 22) {
            System.out.println(String.format("晚上%s点,加班中...，勿打扰!!!", work.getHour()));
        } else {
            System.out.println(String.format("晚上%s点,不行了,再不下班要猝死了!!!", work.getHour()));
        }
    }
}
