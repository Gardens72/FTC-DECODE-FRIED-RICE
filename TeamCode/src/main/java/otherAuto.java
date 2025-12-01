import com.acmerobotics.roadrunner.Action;
import com.acmerobotics.roadrunner.Pose2d;
import com.acmerobotics.roadrunner.TrajectoryActionBuilder;
import com.acmerobotics.roadrunner.Vector2d;
import com.acmerobotics.roadrunner.ftc.Actions;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.teamcode.MecanumDrive;

//import org.firstinspires.ftc.teamcode.tuning.autoArms;

@Autonomous(name = "otherAuto")
public class otherAuto extends LinearOpMode {
    @Override
    public void runOpMode() throws InterruptedException {
        ControlHub hub = new ControlHub();
        //should be -12,-60, but i am changing it for comp!!
        Pose2d initialPose = new Pose2d(-0, -0, Math.toRadians(0));
        MecanumDrive drive = new MecanumDrive(hardwareMap, initialPose);
        hub.init(hardwareMap, initialPose);
        //autoArms arms = new autoArms(hardwareMap);

        //TrajectoryActionBuilder test_trajectory = drive.actionBuilder(initialPose)
        //.lineToX(52)
        //.lineToY(60)

        // go from start pos to near target and shoot
                /*
                .strafeTo(new Vector2d(-48,48))
                .turn(Math.toRadians(-45))
                //.stopAndAdd(outtake.shoot())
                //.stopAndAdd(outtake.shoot())
                //.stopAndAdd(outtake.shoot())

                // go to lever and release all balls in gate
                .turn(Math.toRadians(-180+45))
                //lever
                .strafeTo(new Vector2d(-40,0))
                .strafeTo(new Vector2d(-29, 29))
                .turn(Math.toRadians(90))
                .strafeTo(new Vector2d(-53,0))

                 */
        //should be -40 but changing for comp// hopecore
        //.strafeTo(new Vector2d(400,0));


        //Action test_action = test_trajectory.build();

        waitForStart();
        hub.timer=new ElapsedTime();
        while(hub.timer.seconds()<2){
            hub.leftBack.setPower(.2*.85);
            hub.rightBack.setPower(.2);
            hub.leftFront.setPower(.2*.85);
            hub.rightFront.setPower(.2*.85);
        }
        while(hub.timer.seconds()<3){
            hub.leftBack.setPower(.2*.85);
            hub.rightBack.setPower(-.2);
            hub.leftFront.setPower(-.2*.85);
            hub.rightFront.setPower(.2*.85);
        }

        //Actions.runBlocking(
        //test_action
        //);
    }

}
//Menelamonemapoppy
//meow