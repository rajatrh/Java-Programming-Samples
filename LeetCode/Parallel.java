import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Comparator;
import java.util.Map;
import java.util.Scanner;

class Parallel {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);  // Create a Scanner object
        scan.close();
        List ev1 = new ArrayList<>();
        ev1.add("MoSaPa kaji 45+2 R");
        ev1.add("MoSaPa kaji 45+2 G");
        ev1.add("A 13 G");       
        List ev2 = new ArrayList<>();
        ev2.add("R 90+2 Y");
        ev1.add("MoSaPa kaji 45+2 Y");
        ev2.add("MoSaPa 23 S F");
        ev2.add("Z 46 G");

        getEventsOrder("ABC", "CBA", ev1, ev2);
        // parseEvents("ABC", "Mo 45 S So Ba");

    }

    public static List<String> getEventsOrder(String team1, String team2, List<String> events1, List<String> events2) {

        List<Event> eventList = new ArrayList<Event>();
        for(String event: events1) {
            eventList.add(parseEvents(team1, event));
        }
        for(String event: events2) {
            eventList.add(parseEvents(team2, event));
        }

        // Map used to measure wrt to Events
        Map<Character, Integer> eventMap = new HashMap<>();
        eventMap.put('G', 1);
        eventMap.put('Y', 2);
        eventMap.put('R', 3);
        eventMap.put('S', 4);
        
        // Override the comparator
        Collections.sort(eventList, new Comparator<Event>() {
            @Override
            public int compare(Event p1, Event p2) {
                if (p1.time < p2.time) {
                    return -1;
                } else if (p1.time > p2.time) {
                    return 1;
                } else {
                    if (eventMap.get(p1.eventType) < eventMap.get(p2.eventType)) {
                        return -1;
                    } else if (eventMap.get(p1.eventType) > eventMap.get(p2.eventType)) {
                        return 1;
                    } else {
                        {
                            int teamComparison = p1.teamName.compareToIgnoreCase(p2.teamName);
                        if (teamComparison != 0) {
                            return teamComparison;
                        }  else {
                             return p1.playerName.compareToIgnoreCase(p2.playerName);
                        }
                        }
                    }
                    }
                }
            });
            List<String> res = new ArrayList<String>();
            for (Event e: eventList) {
                res.add(e.og);
                System.out.println(e);
            }
        return res;
        }

    public static Event parseEvents(String team, String event) {
            String[] eventBreakdown = event.split(" ");
            Event ev = new Event();
            ev.og = team + ' ' + event;
            ev.teamName = team;
            ev.playerName = eventBreakdown[0];
            int nameCompleted = 1;
            while (!eventBreakdown[nameCompleted].matches(".*\\d.*")) {
                ev.playerName += (" " + eventBreakdown[nameCompleted]);
                nameCompleted++;
            }
            ev.time = getTime(eventBreakdown[nameCompleted]);
            ev.eventType = eventBreakdown[nameCompleted + 1].charAt(0);
            return ev;
        }

    public static double getTime(String time) {
        String[] timeBreakdown = time.split("\\+");
        if (timeBreakdown.length == 1) {
            return Double.parseDouble(timeBreakdown[0]);
        } else {
            return Double.parseDouble(String.join(".", timeBreakdown));
        }
    }
}

class Event {
    String teamName;
    String playerName;
    Double time;
    char eventType;
    String og;

    @Override
    public String toString() {
        return teamName + " :: " + playerName + " :: " + time + " :: " + eventType + " :: " + og;
    }
}