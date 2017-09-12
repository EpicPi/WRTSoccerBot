// RobotBuilder Version: 2.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.


package org.usfirst.frc2974.SoccerBot.subsystems;

import org.usfirst.frc2974.SoccerBot.RobotMap;
import org.usfirst.frc2974.SoccerBot.commands.*;
import edu.wpi.first.wpilibj.AnalogPotentiometer;
import edu.wpi.first.wpilibj.Solenoid;

import edu.wpi.first.wpilibj.command.Subsystem;


/**
 *controls intake solenoids with an actual potentiometer
 */
public class Intake extends AbstractIntake {

	//enumerates the two cases used later; up, and fall
	private final double transitionUpHigh = 840; //todo to be tuned 
	private double transitionHighDribble = 660;
	private double transitionDribbleLow = 620;
	private final double transitionLowFlat = 610;

    private final AnalogPotentiometer angleSensor = RobotMap.intakeAngleSensor;
      
    public ArmPosition getArmPosition()
    {
    	double position = angleSensor.get();
    	if(position > transitionUpHigh){
    		return ArmPosition.up;	
    	}
    	if(position > transitionHighDribble){
    		return ArmPosition.high;
    	}
    	if(position > transitionDribbleLow){
    		return ArmPosition.dribble;
    	}
    	if(position > transitionLowFlat){
    		return ArmPosition.low;
    	}
    	return ArmPosition.flat;
    }
    
    public void setDribbleMode()
    {
    	transitionHighDribble = 660;
    	transitionDribbleLow = 620;
    }
    
    public void setLoadMOde()
    {
    	transitionHighDribble = 700;
    	transitionDribbleLow = 660;
    }
}

