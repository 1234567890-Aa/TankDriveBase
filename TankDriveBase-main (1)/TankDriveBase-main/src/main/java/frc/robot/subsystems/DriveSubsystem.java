/*  Copyright (c) FIRST and other WPILib contributors.
 Open Source Software; you can modify and/or share it under the terms of
 the WPILib BSD license file in the root directory of this project.*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class DriveSubsystem extends SubsystemBase {
   /*  Creating all our variables, we will initialize them and set their values later
   create motors : motorcontrollers are talon srx/ talon fx in code : check pheonix 5 docs
   create differential drive or arcade drive : check WPILib docs*/
  TalonSRX _talonL = new TalonSRX(1);
  TalonSRX _talonR = new TalonSRX(0);

  public DriveSubsystem() {
     //initialize motor controllers
     _talonL.configFactoryDefault();
     _talonR.configFactoryDefault();
     //set to factory defaults

     //set motors to default to braking
     _talonL.setNeutralMode(NeutralMode.Brake);
     _talonR.setNeutralMode(NeutralMode.Brake);
    //create differential drive

    //Makes follower motors do the same thing as the leaders so that we don't have to pass arguments for all four
    

    // invert left motors from the right motors because they are inverted 180 degrees
  
  
    
    
  }

  public void drive(double left, double right) {
    //Drive command
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run

    
  }

  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
  }
}
