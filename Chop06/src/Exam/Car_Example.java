package Exam;

public class Car_Example {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Car ca = new Car();
		System.out.println("���� ȸ�� : "+ca.company);
		System.out.println("�𵨸� : "+ca.model);
		System.out.println("���� : "+ca.color);
		System.out.println("�ְ� �ӵ� : "+ca.maxSpeed);
		System.out.println("���� �ӵ� : "+ca.speed);
		
		System.out.println("�ӵ� : "+ca.modify_Speed(20));
		
		int current_Speed = ca.modify_Speed(90);
		System.out.println("������ ����   �ӵ�  " +current_Speed + " km/h  �Դϴ� ");
	}

}
