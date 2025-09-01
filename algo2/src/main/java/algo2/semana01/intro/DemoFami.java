package algo2.semana01.intro;

public class DemoFami {
	public int var1;
	protected int var2;
	int var3;
	private int var4;
	
	public static int var5;
	protected static int var6;
	static int var7;
	private static int var8;
	
	public void met1() {};
	protected void met2() {};
	void met3() {};
	private void met4() {};
	
	public static void met5() {};
	protected static void met6() {};
	static void met7() {};
	private static void met8() {};
	public void privateUse() {
		System.out.println(""+var4+""+var8);
		met4(); met8();
	}
}