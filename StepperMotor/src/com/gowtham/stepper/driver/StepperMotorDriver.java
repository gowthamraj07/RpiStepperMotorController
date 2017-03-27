package com.gowtham.stepper.driver;

import java.io.IOException;

import com.pi4j.io.gpio.GpioController;
import com.pi4j.io.gpio.GpioFactory;
import com.pi4j.io.gpio.GpioPinDigitalOutput;
import com.pi4j.io.gpio.PinState;
import com.pi4j.io.gpio.RaspiPin;

public class StepperMotorDriver {

	//	package de.buschbaum.java.pathfinder;

	
	private static final int STEP_DELAY= 2000;


	/**
	 * Hello world!
	 */


	public static void main(String[] args) {
		final GpioController gpio = GpioFactory.getInstance();
		final GpioPinDigitalOutput pin1 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_00,"MY_LED",PinState.HIGH);
		final GpioPinDigitalOutput pin2 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_02,"MY_LED",PinState.HIGH);
		final GpioPinDigitalOutput pin3 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_03,"MY_LED",PinState.HIGH);
		final GpioPinDigitalOutput pin4 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_12,"MY_LED",PinState.HIGH);
		
		pin1.setShutdownOptions(true, PinState.LOW);
		pin2.setShutdownOptions(true, PinState.LOW);
		pin3.setShutdownOptions(true, PinState.LOW);
		pin4.setShutdownOptions(true, PinState.LOW);
		
		try {
			Runtime.getRuntime().exec("gpio mode 0 out");
			Runtime.getRuntime().exec("gpio mode 2 out");
			Runtime.getRuntime().exec("gpio mode 3 out");
			Runtime.getRuntime().exec("gpio mode 12 out");
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		int i=0;
		
		while(i++<100) {
			
			System.out.println("Step 1");
			//Step 1:
			/*pin1.high();
			pin2.low();
			pin3.low();
			pin4.low();*/
			
			try {
				Runtime.getRuntime().exec("gpio write 0 1");
				Runtime.getRuntime().exec("gpio write 2 0");
				Runtime.getRuntime().exec("gpio write 3 0");
				Runtime.getRuntime().exec("gpio write 12 0");
				Thread.sleep(STEP_DELAY);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			System.out.println("Step 2");
			//Step 2:
			/*pin1.low();
			pin2.low();
			pin3.low();
			pin4.high();*/
			try {
				Runtime.getRuntime().exec("gpio write 0 0");
				Runtime.getRuntime().exec("gpio write 2 0");
				Runtime.getRuntime().exec("gpio write 3 1");
				Runtime.getRuntime().exec("gpio write 12 0");
				Thread.sleep(STEP_DELAY);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			System.out.println("Step 3");
			//Step 3:
			/*pin1.low();
			pin2.low();
			pin3.high();
			pin4.low();*/
			/*try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}*/
			
			try {
				Runtime.getRuntime().exec("gpio write 0 0");
				Runtime.getRuntime().exec("gpio write 2 1");
				Runtime.getRuntime().exec("gpio write 3 0");
				Runtime.getRuntime().exec("gpio write 12 0");
				Thread.sleep(STEP_DELAY);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			System.out.println("Step 4");
			//Step 4:
			/*pin1.low();
			pin2.high();
			pin3.low();
			pin4.low();
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}*/
			try {
				Runtime.getRuntime().exec("gpio write 0 0");
				Runtime.getRuntime().exec("gpio write 2 0");
				Runtime.getRuntime().exec("gpio write 3 0");
				Runtime.getRuntime().exec("gpio write 12 1");
				Thread.sleep(STEP_DELAY);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		gpio.shutdown();
	}

	
}