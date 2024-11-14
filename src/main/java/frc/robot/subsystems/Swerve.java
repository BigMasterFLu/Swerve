// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix6.mechanisms.swerve.SwerveModule;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Swerve extends SubsystemBase {
  /** Creates a new Swerve. */
  
  public Swerve() {
    swervemods = new SwerveModule[]{
      Constants.Swerve.Mod0.driveMotorID;
      Constants.Swerve.Mod0.angleMotorID;
      Constants.Swerve.Mod0.canCoderID;
      Constants.Swerve.Mod0.angleOffset;
    }
    swervemods = new SwerveModule[]{
      Constants.Swerve.Mod1.driveMotorID;
      Constants.Swerve.Mod1.angleMotorID;
      Constants.Swerve.Mod1.canCoderID;
      Constants.Swerve.Mod1.angleOffset;
    }
    swervemods = new SwerveModule[]{
      Constants.Swerve.Mod2.driveMotorID;
      Constants.Swerve.Mod2.angleMotorID;
      Constants.Swerve.Mod2.canCoderID;
      Constants.Swerve.Mod2.angleOffset;
    }swervemods = new SwerveModule[]{
      Constants.Swerve.Mod3.driveMotorID;
      Constants.Swerve.Mod3.angleMotorID;
      Constants.Swerve.Mod3.canCoderID;
      Constants.Swerve.Mod3.angleOffset;
    }
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
