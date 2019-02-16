/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.DigitalInput;
import frc.robot.subsystems.PneumaticClaw;
import frc.robot.Robot;
import frc.robot.RobotMap;

/**
 * An example command. You can replace me with your own command.
 */
public class PneumaticsWithSwitch extends Command {

  private PneumaticClaw Cylinder = PneumaticClaw.getInstance();
  DigitalInput limitSwitchOne;
  DigitalInput limitSwitchTwo;

  public PneumaticsWithSwitch() {
    requires(Robot.m_subsystem);

  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    limitSwitchOne = new DigitalInput(RobotMap.DIGITALINPUT1);
    limitSwitchTwo = new DigitalInput(RobotMap.DIGITALINPUT2);
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {

    // System.out.println("Checking: " +
    // canifierLimits.get(GeneralPin.SPI_MISO_PWM2P));
    if (!limitSwitchOne.get() && !limitSwitchTwo.get()) {

      Cylinder.pneumaticOut();
      // System.out.println("Limit switches are being pressed.");
    }

  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return false;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
  }
}