import com.acmerobotics.dashboard.FtcDashboard;
import com.acmerobotics.roadrunner.Pose2d;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.Gamepad;
@TeleOp(name="CucumberTeleop")
public class CucumberTeleop extends LinearOpMode {
    ControlHub hub;
    @Override
    public void runOpMode() throws InterruptedException {
        hub = new ControlHub();
        hub.init(hardwareMap,new Pose2d(10,10,1));
        FtcDashboard dashboard;
        dashboard = FtcDashboard.getInstance();
        telemetry = dashboard.getTelemetry();
        waitForStart();
        while (opModeIsActive()) {

            motorAction(gamepad1,gamepad2);


        }
    }

    public void motorAction(Gamepad gamepad, Gamepad gamepad2 ) {
        double y = -gamepad.left_stick_y; // Remember, Y stick value is reversed
        double x = gamepad.left_stick_x * 1.1; // Counteract imperfect strafing
        double rx = gamepad.right_stick_x;

        //telemetry.addLine("You're telling me a shrimp fried this rice?!");
        //telemetry.update();

        if (gamepad2.a){
            hub.bob.setPower(-1);
            hub.marvo.setPower(-1);
            hub.servo3.setPower(1);
        }
        if (gamepad2.b){
            hub.bob.setPower(0);
            hub.marvo.setPower(0);
            hub.servo3.setPower(0);
        }
        //if(gamepad.left_trigger>.1){
        //    hub.leftWheel.setPower(gamepad.left_trigger);
        //}
        // Denominator is the largest motor power (absolute value) or 1
        // This ensures all the powers maintain the same ratio,
        // but only if at least one is out of the range [-1, 1]
        double denominator = Math.max(Math.abs(y) + Math.abs(x) + Math.abs(rx), 1);
        double frontLeftPower = (y + x + rx) / denominator;
        double backLeftPower = (y - x + rx) / denominator;
        double frontRightPower = (y - x - rx) / denominator;
        double backRightPower = (y + x - rx) / denominator;
        if (gamepad.x){
            frontLeftPower=0;
            frontRightPower=0;
            backLeftPower=0;
            backRightPower=0;
        }
        hub.outtake.setPower(gamepad2.left_stick_y);
        hub.outtake2.setPower(-gamepad2.right_stick_y);
        //if (gamepad.left_trigger>.1){
        //    hub.intake.setPower(1);
        //}
        //if(gamepad.right_trigger>.1){
        //    hub.outtake1.setPower(.5);
        //    hub.outtake2.setPower(.5);
        //}

        if (!gamepad.x){
            hub.leftFront.setPower(frontLeftPower);
            hub.leftBack.setPower(backLeftPower);
            hub.rightFront.setPower(frontRightPower);
            hub.rightBack.setPower(backRightPower);
        }
    }

}