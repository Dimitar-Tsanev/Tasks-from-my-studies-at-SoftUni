package traffic_lights;

import java.util.ArrayList;
import java.util.List;

class TrafficLight {

    private List<TrafficLights> currentLights;

    public TrafficLight (String... strings) {
        this.setCurrentLights ( strings );
    }

    public List<TrafficLights> getCurrentLights () {
        return currentLights;
    }

    private void setCurrentLights ( String... strings ) {
        if (this.currentLights == null){
            currentLights = new ArrayList<> ();

        }
        for ( String light: strings ){
            if ("red".toUpperCase ().equals ( light ) ||
                    "yellow".toUpperCase ().equals ( light )||
                    "green".toUpperCase ().equals ( light )) {

                getCurrentLights ( ).add ( TrafficLights.valueOf ( light ) );
            }
        }
    }
    public List<TrafficLights> getNextLights(){
        //red -> green -> yellow -> red
        List<TrafficLights> nextLights = new ArrayList<> ();
        for ( TrafficLights light: currentLights ){
            if ( light.ordinal () == 2 ){
                light = TrafficLights.RED;

            } else if ( light.ordinal () == 1 ) {
                light = TrafficLights.YELLOW;

            } else if ( light.ordinal () == 0 ) {
                light = TrafficLights.GREEN;
            }
            nextLights.add ( light );
        }
        changeLights(nextLights);
        return nextLights;
    }
    private void changeLights ( List<TrafficLights> nextLights ) {
        this.currentLights = nextLights;
    }
}
