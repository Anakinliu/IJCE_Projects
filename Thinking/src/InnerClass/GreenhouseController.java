package InnerClass;

/**
 * Created by Anakinliu on 2017/3/2.
 * If you only do what you can do,
 * you'll never be more than you are now.
 */
public class GreenhouseController {
    public static void main(String[] args) {
        GreenhouseControls greenhouseControls = new GreenhouseControls();

        //Instead of hard-wiring, you could parse
        //configuration information from a text file here
        greenhouseControls.addEvent(greenhouseControls.new Bell(1000));

        Event[] eventList = {
                greenhouseControls.new ThermostatNight(0),
                greenhouseControls.new FansOn(100),
                greenhouseControls.new FansOff(200),
                greenhouseControls.new LightOn(600),
                greenhouseControls.new LightOff(400),
                greenhouseControls.new WaterOn(1000),
                greenhouseControls.new WaterOff(1300),
                greenhouseControls.new ThermostatDay(2000),
        };

        greenhouseControls.addEvent(greenhouseControls.new Restart(1000, eventList));

        if (args.length == 1) {
            greenhouseControls.addEvent(
                    new GreenhouseControls.Terminate(
                            new Integer(args[0])
                    )
            );
        }
        greenhouseControls.run();
    }
}
