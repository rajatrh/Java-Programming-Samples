import java.util.*;

class Shipment {
    int id;
    int wareHosueId;
    int priority;
    Shipment(int id, int wid, int p) {
        this.id = id;
        this.wareHosueId = wid;
        this.priority =p;
    }

    public String toString() {
        return "Id: " + this.id + " wareHouse: " + this.wareHosueId + " Priority: " + this.priority;
    }
}

class ShipmentPriorityComparator implements Comparator<Shipment> {

    public int compare(Shipment a, Shipment b) {
        return b.priority - a.priority;
    }
}
class WareHouseMgmt {
    public static void main(String[] args) {
        List<Shipment> shipment = new ArrayList<Shipment>();
        shipment.add(new Shipment(1,1,4));
        shipment.add(new Shipment(2,1,3));
        shipment.add(new Shipment(3,1,2));
        shipment.add(new Shipment(12,3,4));
        shipment.add(new Shipment(13,1,1));
        shipment.add(new Shipment(19,3,2));
        shipment.add(new Shipment(11,3,3));
        shipment.add(new Shipment(4,2,1));
        shipment.add(new Shipment(5,2,4));
        shipment.add(new Shipment(6,2,2));
        shipment.add(new Shipment(10,3,2));
        shipment.add(new Shipment(11,3,3));
        shipment.add(new Shipment(7,2,3));
        shipment.add(new Shipment(8,3,3));
        shipment.add(new Shipment(9,3,1));
        shipment.add(new Shipment(14,1,5));
        shipment.add(new Shipment(15,1,6));
        shipment.add(new Shipment(16,2,5));
        shipment.add(new Shipment(17,2,6));
        shipment.add(new Shipment(18,3,5));

        // Iterator itr = shipment.iterator();
        // while(itr.hasNext()) {
        //     System.out.println(itr.next());
        // }

        Comparator<Shipment> shipmentId = new Comparator<Shipment>() {
            @Override
            public int compare(Shipment o1, Shipment o2) {
                
                return o2.id - o1.id;
            }
        };

        // Collections.sort(shipment, shipmentId);
        // Iterator itr = shipment.iterator();
        // while(itr.hasNext()) {
        //     System.out.println(itr.next());
        // }

        HashMap<Integer, PriorityQueue<Shipment>> wareHouseMap = new HashMap<>();
        Iterator itr = shipment.iterator();
        while(itr.hasNext()) {
            Shipment temp = (Shipment)itr.next();
            if(!wareHouseMap.containsKey(temp.wareHosueId)) {
                System.out.println("Creating a new queue for Ware House#" + temp.wareHosueId);
                wareHouseMap.put(temp.wareHosueId, new PriorityQueue<Shipment>(new ShipmentPriorityComparator()));
            } else {
                if (wareHouseMap.get(temp.wareHosueId).size() < 3) {
                    wareHouseMap.get(temp.wareHosueId).add(temp);
                } else if (temp.priority < wareHouseMap.get(temp.wareHosueId).peek().priority) {
                    Shipment s = wareHouseMap.get(temp.wareHosueId).poll();
                    wareHouseMap.get(temp.wareHosueId).add(temp);
                    System.out.println("Removed : " + s);
                } 
                System.out.println("Current PQ : " + wareHouseMap.get(temp.wareHosueId));
            }
        }

        System.out.println(wareHouseMap.get(1));
        System.out.println(wareHouseMap.get(2));
        System.out.println(wareHouseMap.get(3));
    }
}