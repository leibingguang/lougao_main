/**
 * @Description
 * @author lou_gao
 */
package lougao.status;

/**
 * 测试
 */
public class StageTest {
    public static void main(String[] args) {
        Work stageContext = new Work();
        stageContext.setHour(10);
        stageContext.doWork();
        stageContext.setHour(11);
        stageContext.doWork();
        stageContext.setHour(13);
        stageContext.doWork();
        stageContext.setHour(17);
        stageContext.doWork();
        stageContext.setHour(19);
        stageContext.doWork();
        stageContext.setHour(21);
        stageContext.setWorkFinished(true);
        stageContext.doWork();
        stageContext.setHour(22);
        stageContext.doWork();
    }
}
