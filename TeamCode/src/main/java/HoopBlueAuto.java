import com.acmerobotics.roadrunner.Action;
import com.acmerobotics.roadrunner.Pose2d;
import com.acmerobotics.roadrunner.TrajectoryActionBuilder;
import com.acmerobotics.roadrunner.Vector2d;
import com.acmerobotics.roadrunner.ftc.Actions;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.MecanumDrive;

//import org.firstinspires.ftc.teamcode.tuning.autoArms;

@Autonomous(name = "HoopBlueAuto")
public class HoopBlueAuto extends LinearOpMode {
    @Override
    public void runOpMode() throws InterruptedException {
        ControlHub hub = new ControlHub();
        Pose2d initialPose = new Pose2d(-48, -48, Math.toRadians(0));
        MecanumDrive drive = new MecanumDrive(hardwareMap, initialPose);
        hub.init(hardwareMap, initialPose);
        //autoArms arms = new autoArms(hardwareMap);

        TrajectoryActionBuilder test_trajectory = drive.actionBuilder(initialPose)
                //.lineToX(52)
                //.lineToY(60)

                // go from start pos to near target and shoot
                .turn(Math.toRadians(-45))
                //.stopAndAdd(outtake.shoot())
                //.stopAndAdd(outtake.shoot())
                //.stopAndAdd(outtake.shoot())

                // go to lever and release all balls in gate
                /*
                .turn(Math.toRadians(-180+45))
                .strafeTo(new Vector2d(-40,0))
                .strafeTo(new Vector2d(-29, 29))
                .turn(Math.toRadians(90))
                .strafeTo(new Vector2d(-53,0))
                .strafeTo(new Vector2d(-40,0))
                 */
                .turn(Math.toRadians(0));


        Action test_action = test_trajectory.build();

        waitForStart();

        Actions.runBlocking(
                test_action
        );
    }

}
//Menelamonemapoppy
//meow