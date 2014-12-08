package newRoadways;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;
import javax.swing.*;
import javax.swing.*;
import javax.xml.parsers.*;
import org.w3c.dom.*;

public class Car {
	

	int carN = 0;
	double speed = 0;
	int locX = 0;
	char locY = 0;
	String color = "";
	boolean isRed = false;
	boolean isBlue = false;
	boolean isYellow = false;
	boolean isOrange = false;
	/**
	 * @return the carN
	 */
	public int getCarN() {
		return carN;
	}

	/**
	 * @return the speed
	 */
	public double getSpeed() {
		return speed;
	}

	/**
	 * @return the locX
	 */
	public int getLocX() {
		return locX;
	}

	/**
	 * @return the locY
	 */
	public char getLocY() {
		return locY;
	}

	/**
	 * @return the color
	 */
	public String getColor() {
		return color;
	}

	/**
	 * @return the isRed
	 */
	public boolean isRed() {
		return isRed;
	}

	/**
	 * @return the isBlue
	 */
	public boolean isBlue() {
		return isBlue;
	}

	/**
	 * @return the isYellow
	 */
	public boolean isYellow() {
		return isYellow;
	}

	/**
	 * @return the isOrange
	 */
	public boolean isOrange() {
		return isOrange;
	}

	/**
	 * @return the isGreen
	 */
	public boolean isGreen() {
		return isGreen;
	}

	boolean isGreen = false;

	public Car() {
		super();
	}

	public void setCarN(int carN){
		this.carN = carN;
	}
	public int getCarN(int carN){
		return this.carN;
	}
	public void setSpeed(double speed){
		this.speed = speed;
	}
	public void setLocX(int locX){
		this.locX = locX;
	}
	public void setLocY(char locY){
		this.locY = locY;
	}
	public void setColor(String color){
		this.color = color;
		if (this.color.equals("red")){
			this.isRed = true;
			this.isBlue = false;
			this.isYellow = false;
			this.isOrange = false;
			this.isGreen = false;
		}
		else if (this.color.equals("blue")){
			this.isRed = false;
			this.isBlue = true;
			this.isYellow = false;
			this.isOrange = false;
			this.isGreen = false;
		}
		else if (this.color.equals("yellow")){
			this.isRed = false;
			this.isBlue = false;
			this.isYellow = true;
			this.isOrange = false;
			this.isGreen = false;
		}
		else if (this.color.equals("orange")){
			this.isRed = false;
			this.isBlue = false;
			this.isYellow = false;
			this.isOrange = true;
			this.isGreen = false;
		}
		else if (this.color.equals("green")){
			this.isRed = false;
			this.isBlue = false;
			this.isYellow = false;
			this.isOrange = false;
			this.isGreen = true;
		}
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Car [carN=" + carN + ", speed=" + speed + ", locX=" + locX
				+ ", locY=" + locY + ", color=" + color + ", isRed=" + isRed
				+ ", isBlue=" + isBlue + ", isYellow=" + isYellow
				+ ", isOrange=" + isOrange + ", isGreen=" + isGreen + "]";
	}
}