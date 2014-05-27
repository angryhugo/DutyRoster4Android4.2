package com.example.dutyroster2;

public class InforCalc {
	public static String[] s = { "��Ϣ ^o^", "����6��", "����7���"};
	public static int period=18;
	public static String beginDay = "2014/5/24";
	/**
	 * 
	 * @param calDay ��������� ��ʽ����/��/��
	 * @return String �Ű���Ϣ
	 */
	public static String CalculateRoster(String calDay) {
		int result =  ((int)BetweenDays.betweenTwoDays(beginDay, calDay) % period);
		result = result >=0 ? result : (result + period);
		if(result % 3 == 0){
			if(result<=9){
				return s[1];
			}else{
				return s[2];
			}
		}else{
			return s[0];
		}
	}
}
