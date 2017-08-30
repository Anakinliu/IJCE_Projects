package InnerClass;

/**
 * Created by Anakinliu on 2017/3/2.
 * If you only do what you can do,
 * you'll never be more than you are now.
 */

/*
控制温室的运作: 控制各种事物的开关, 响铃, 重启系统, 每个动作完全不同.
控制框架的设计使得分离这些不同的代码变得很容易.

使用内部类, 在单一的一个类里, 产生对同一个基类Event的多种导出版本.
 */

public class GreenhouseControls extends Controller {
    private boolean light = false;

    public class LightOn extends Event {
        public LightOn (long delayTime) { super(delayTime); }

        @Override
        public void action() {
            // Put hardware control code here to physically turn on the light.
            light = true;
        }

        @Override
        public String toString() {
            return "Light is on!";
        }
    }

    public class LightOff extends Event {
        public LightOff (long delayTime) { super(delayTime); }

        @Override
        public void action() {
            // Put hardware control code here to physically turn on the light.
            light = false;
        }

        @Override
        public String toString() {
            return "Light is off!";
        }
    }

    private boolean water = false;

    public class WaterOn extends Event {
        public WaterOn (long delayTime) { super(delayTime); }

        @Override
        public void action() {
            // Put hardware control code here to physically turn on the light.
            water = true;
        }

        @Override
        public String toString() {
            return "Greenhouse water is on!";
        }
    }


    public class WaterOff extends Event {
        public WaterOff (long delayTime) { super(delayTime); }

        @Override
        public void action() {
            // Put hardware control code here to physically turn on the light.
            water = false;
        }

        @Override
        public String toString() {
            return "Greenhouse water is off!";
        }

    }

    private String thermostat = "Day";

    public class ThermostatNight extends Event {
        public ThermostatNight (long delayTime) {
            super(delayTime);
        }

        @Override
        public void action() {
            // put hardware control code here.
            thermostat = "Night";
        }

        @Override
        public String toString() {
            return "Thermostat on night setting";
        }
    }

    public class ThermostatDay extends Event {
        public ThermostatDay (long delayTime) {
            super(delayTime);
        }

        @Override
        public void action() {
            // put hardware control code here.
            thermostat = "Day";
        }

        @Override
        public String toString() {
            return "Thermostat on day setting";
        }
    }

    //An example of an action() that inserts a new
    //one of itself into the event list:
    public class Bell extends Event {
        public Bell (long delayTime) {
            super(delayTime);
        }

        @Override
        public void action() {
            addEvent(new Bell(delayTime));
        }

        @Override
        public String toString() {
            return "Bing";
        }
    }

    public class Restart extends Event {
        private Event[] eventList;

        public Restart (long delayTime, Event[] eventList) {
            //NO default constructor in Event, so call super()
            super(delayTime);
            this.eventList = eventList;
            for (Event e : eventList) {
                addEvent(e);
            }

        }

        @Override
        public void action() {
            for (Event e : eventList) {
                e.start();
                addEvent(e);
            }
            start();
            addEvent(this);
        }

        @Override
        public String toString() {
            return "Restarting system";
        }
    }

    public static class Terminate extends Event {

        public Terminate (long delayTime) {
            super(delayTime);
        }

        public void action() {
            System.exit(0);
        }

        public String toString() {
            return "Terminating";
        }
    }

    private boolean fan = false;

    public class FansOn extends Event {
        public FansOn (long delayTime) {
            super(delayTime);
        }

        @Override
        public void action() {
            fan = true;
            System.out.println("Fans on");
        }

        @Override
        public String toString() {
            return "Fans";
        }
    }

    public class FansOff extends Event {
        public FansOff (long delayTime) {
            super(delayTime);
        }

        @Override
        public void action() {
            fan = false;
            System.out.println("Fans off");
        }

        @Override
        public String toString() {
            return "Fans";
        }
    }


}
