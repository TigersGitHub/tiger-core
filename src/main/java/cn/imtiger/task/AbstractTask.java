package cn.imtiger.task;

/**
 * ��ʱ���������
 * @author shen_hongtai
 * @date 2019-10-5
 */
public abstract class AbstractTask {
	/**
	 * ��������
	 */
	private String taskName;
	/**
	 * ������ʱ��(��)
	 */
	private Integer delay;
	
	/**
	 * Ĭ�Ϲ��췽��
	 */
	public AbstractTask() {
		this.init();
	}
	
	/**
	 * �����ʼ���������������Ƽ����ʱ��
	 */
	public abstract void init();

	/**
	 * ����ִ���߼�
	 */
	public abstract void run();

	public String getTaskName() {
		return taskName;
	}

	public Integer getDelay() {
		return delay;
	}

	protected void setTaskName(String taskName) {
		this.taskName = taskName;
	}

	protected void setDelay(Integer delay) {
		this.delay = delay;
	}
}
