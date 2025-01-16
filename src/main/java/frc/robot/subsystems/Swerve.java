// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix6.configs.Pigeon2Configuration;
import com.ctre.phoenix6.hardware.Pigeon2;
import com.ctre.phoenix6.mechanisms.swerve.SwerveModule;

import edu.wpi.first.math.estimator.SwerveDrivePoseEstimator;
import edu.wpi.first.math.kinematics.SwerveDriveOdometry;
import edu.wpi.first.math.kinematics.SwerveModulePosition;
import edu.wpi.first.math.kinematics.SwerveModuleState;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.SwerveModules;

public class Swerve extends SubsystemBase {
  /** Creates a new Swerve. */
  
  public Swerve() {
    
  Pigeon2 gyro = new Pigeon2(Constants.Swerve.pigeonID);  
        gyro.getConfigurator().apply(new Pigeon2Configuration());
        gyro.setYaw(0);

        SwerveModules[] mSwerveMods = new SwerveModules[] {
            new SwerveModules(0, Constants.Swerve.Mod0.driveMotorID, Constants.Swerve.Mod0.angleMotorID, Constants.Swerve.Mod0.canCoderID, Constants.Swerve.Mod0.angleOffset),
            new SwerveModules(1, Constants.Swerve.Mod1.driveMotorID, Constants.Swerve.Mod1.angleMotorID, Constants.Swerve.Mod1.canCoderID, Constants.Swerve.Mod1.angleOffset),
            new SwerveModules(2, Constants.Swerve.Mod2.driveMotorID, Constants.Swerve.Mod2.angleMotorID, Constants.Swerve.Mod2.canCoderID, Constants.Swerve.Mod2.angleOffset),
            new SwerveModules(3, Constants.Swerve.Mod3.driveMotorID, Constants.Swerve.Mod3.angleMotorID, Constants.Swerve.Mod3.canCoderID, Constants.Swerve.Mod3.angleOffset)
        };
        SwerveDriveOdometry swerveOdometry = new SwerveDriveOdometry(Constants.Swerve.swerveKinematics, getGyroYaw(), getModulePositions());
        SwerveDrivePoseEstimator robotPose = new SwerveDrivePoseEstimator(Constants.Swerve.swerveKinematics, getGyroYaw(), getModulePositions(), getPose());

  }
  public SwerveModuleState[] getModuleStates(){
    SwerveModuleState[] states = new SwerveModuleState[4];
    for(SwerveModule mod : mSwerveMods){
        states[mod.moduleNumber] = mod.getState();
    }
    return states;
}

public SwerveModulePosition[] getModulePositions(){
    SwerveModulePosition[] positions = new SwerveModulePosition[4];
    for(SwerveModule mod : mSwerveMods){
        positions[mod.moduleNumber] = mod.getPosition();
    }
    return positions;
}
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
