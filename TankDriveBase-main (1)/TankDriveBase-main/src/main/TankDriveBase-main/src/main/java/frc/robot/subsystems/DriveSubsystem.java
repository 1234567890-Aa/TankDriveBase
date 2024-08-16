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

  WPI_TalonFX _talonLeaderL;
  WPI_TalonFX _talonLeaderR;
  WPI_TalonFX _talonFollowerL;
  WPI_TalonFX _talonFollowerR;
  DifferentialDrive _drive;

  public DriveSubsystem() {
    TalonSRX _talonLeaderL = new TalonSRX(Constants.leftLeaderCANID);
    TalonSRX _talonLeaderR = new TalonSRX(Constants.rightLeaderCANID);
    TalonSRX _talonFollowerL = new TalonSRX(Constants.leftFollowerCANID);
    TalonSRX _talonFollowerR = new TalonSRX(Constants.rightFollowerCANID);

     //initialize motor controllers
     _talonLeaderL.configFactoryDefault();
     _talonLeaderR.configFactoryDefault();
     _talonFollowerL.configFactoryDefault();
     _talonFollowerR.configFactoryDefault();
     //set to factory defaults

     //set motors to default to braking
     _talonLeaderL.setNeutralMode(NeutralMode.Brake);
     _talonLeaderR.setNeutralMode(NeutralMode.Brake);
     _talonFollowerL.setNeutralMode(NeutralMode.Brake);
     _talonFollowerR.setNerutralMode(NeutralMode.Brake);
    //create differential drive
    _drive = new DifferentialDrive(_talonLeaderL, _talonLeaderR);
    //Makes follower motors do the same thing as the leaders so that we don't have to pass arguments for all four
    _talonFollowerL.follow(_talonLeaderL);
    _talonFollowerR.follow(_talonLeaderR);
    // invert left motors from the right motors because they are inverted 180 degrees
    _talonLeaderL.setInverted(true);
    _talonFollowerL.setInverted(true);
  
    
    
  }

  public void drive(double left, double right) {
    //Drive command
    drive.tankDrive(left, right);
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
