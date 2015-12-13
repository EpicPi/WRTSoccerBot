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
import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.Solenoid;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;


/**
 *controls the intake solenoids
 */
abstract public class AbstractIntake extends Subsystem {

	//enumerates the two cases used later; up, and fall
	public enum ArmMovement {
		up, fall, block
	}
	public enum ArmPosition {
		up, high, dribble, low, flat
	}

	protected ArmMovement action;
    //protected IntakeFlat flatCommand = new IntakeFlat(); 
	
    protected final Solenoid extend = RobotMap.intakeArmExtend;
    protected final CANTalon armTalon = RobotMap.intakeArmTalon;
    protected final Solenoid retract = RobotMap.intakeArmRetract;

    
    public void initDefaultCommand() {
        setDefaultCommand(new IntakeManual());
    }
    
    public void startFlat() {
    	new IntakeFlat().start();
    }
    
    public void endFlat() {
    	new IntakeManual().start();
    }
    
    //sets solenoid values to true/false depending on case
    public void setArmMovement(ArmMovement move)
    {	
    	switch(move){
    	case fall:
    		extend.set(true);
    		retract.set(false);
    		break;
    	case up:
    		extend.set(false);
    		retract.set(true);
    		break;
    	case block:
    		extend.set(false);
    	    retract.set(false);
    		break;    		
    	}
    	action = move;
    	SmartDashboard.putString("arm movement", action.toString());
    }  
    
    public ArmMovement getAction()
    {
    	return action;
    }
    /**
     * sets speed of motor on intake arm
     * @param speed da speed
     */
    public void setMotorPower(double speed)
    {
    	armTalon.set(speed);
    }
    
    abstract public ArmPosition getArmPosition();    
}

