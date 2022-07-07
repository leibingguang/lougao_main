/**
 * @Description
 * @author lou_gao
 */
package lougao.status;

/**
 * 状态抽象
 */
public abstract class WorkStage {
    /**
     * 执行
     * @param work
     */
    public abstract void execute(Work work);
}
