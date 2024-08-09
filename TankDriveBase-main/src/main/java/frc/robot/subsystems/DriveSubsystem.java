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
import edu.wpi.first.wpilibj.drive.*;
import com.ctre.phoenix.motorcontrol.can.*;

public class DriveSubsystem extends SubsystemBase {
   /*  Creating all our variables, we will initialize them and set their values later
   create motors : motorcontrollers are talon srx/ talon fx in code : check pheonix 5 docs
   create differential drive or arcade drive : check WPILib docs*/
  WPI_TalonSRX _talonLeaderL = new WPI_TalonSRX(0);
  WPI_TalonSRX _talonLeaderR = new WPI_TalonSRX(1);
  WPI_TalonSRX _talonFollowerL = new WPI_TalonSRX(2);
  WPI_TalonSRX _talonFollowerR = new WPI_TalonSRX(3);
  DifferentialDrive _drive = new DifferentialDrive(_talonLeaderL, _talonLeaderR);
  Joystick _joystick = new Joystick(0);

 
  

  public DriveSubsystem() {
     //initialize motor controllers
     _talonLeaderL.configFactoryDefault();
     _talonLeaderR.configFactoryDefault();
     _talonFollowerL.configFactoryDefault();
     _talonFollowerR.configFactoryDefault();
     //set to factory defaults
      

     //set motors to default to braking
     _talonLeaderL.setNeutralMode(NeutralMode.Brake);
     _talonLeaderR.setNeutralMode(NeutralMode.Brake);
    //create differential drive
    DifferentialDrive _drive = new DifferentialDrive(_talonLeaderL, _talonLeaderR);
    //Makes follower motors do the same thing as the leaders so that we don't have to pass arguments for all four
    _talonLeaderL.setInverted(true);

    // invert left motors from the right motors because they are inverted 180 degrees
  _talonLeaderL.setInverted(true);
  
    
    
  }

  public void drive(double left, double right) {
    //Drive command
      _drive.tankDrive(left, right);
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