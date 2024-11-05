package frc.robot;
// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.


import com.ctre.phoenix6.configs.TalonFXConfiguration;
import com.ctre.phoenix6.hardware.CANcoder;
import com.ctre.phoenix6.hardware.TalonFX;

import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.math.kinematics.SwerveModulePosition;
import edu.wpi.first.math.kinematics.SwerveModuleState;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
//TO-DO
//get rotation 2d from cancoder: getAbsolutePosition
//reset cancoder position
//make a state
//get a module position state
//convert to meters instead of rotations

public class SwerveModule extends SubsystemBase {
  /** Creates a new Swerve. */
  private TalonFX drivemotor;
  private TalonFX turnmotor;
  private Rotation2d angleOfset;
  private CANcoder cancoder;

  public SwerveModule(int drivemotor, int turnmotor, int cancoder, Rotation2d angleOfset) {
    this.drivemotor = new TalonFX(drivemotor);
    this.turnmotor = new TalonFX(turnmotor);
    this.cancoder = new CANcoder(cancoder);
    this.angleOfset = angleOfset;
    
    this.drivemotor.getConfigurator().apply(Robot.ctreConfigs.swerveDriveFXConfig);
    this.drivemotor.getConfigurator().setPosition(0);

    this.turnmotor.getConfigurator().apply(Robot.ctreConfigs.swerveAngleFXConfig);
    this.drivemotor.getConfigurator().setPosition(0);
    
    this.cancoder.getConfigurator().apply(Robot.ctreConfigs.swerveCANcoderConfig);
    this.cancoder.getConfigurator().setPosition(0);
    resetToAbsolute();
  }

  public Rotation2d getCANcoder(){
    return Rotation2d.fromRotations(cancoder.getAbsolutePosition().getValue());
  }

  public void resetToAbsolute(){
    //cancoder rotation in rotations subtract the ofset in rotations
    //set angle motor to absolute position
    double absolutePosition = getCANcoder().getRotations()-angleOfset.getRotations();
    turnmotor.setPosition(absolutePosition);
  }
  
  //FIRST METHOD
  //for swerve module position get the position
  //swerveModulePosition pass in the drive motor position with wheel circumference and the rotation 2d of the angle motor
  //it will automatically calculate position to x, y
  //convert to meters
  //return the class
  public SwerveModulePosition getPosition(){
    
  }
  //SECOND METHOD
  //swerveModuleState is the class name takes in angle as in rotation 2d and also takes in velocity
  //this tells the module how to move (what rotation and what speed)
  public SwerveModuleState getState(){

  } 
  public
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
