import java.io.*;
import java.util.ArrayList;
import java.util.Objects;

public class Store {

    int Anidentificationnumber;
    String Name;
    String description;
    float UnitPrice;
    int NumberOfUnitsInStock;
    String unit ;

    public Store(){
        Anidentificationnumber = 0;
        Name = null;
        description = null;
        UnitPrice = 0;
        NumberOfUnitsInStock = 0;
        unit = null;
    }

    public Store(int Anidentificationnumbe, String Name, String description, float UnitPrice, int NumberOfUnitsInStock, String unit) {
        this.Anidentificationnumber = Anidentificationnumbe;
        this.Name = Name;
        this.description = description;
        this.UnitPrice = UnitPrice;
        this.NumberOfUnitsInStock = NumberOfUnitsInStock;
        this.unit = unit;
    }

    public Store(Store stor){
        this.Anidentificationnumber = stor.Anidentificationnumber;
        this.Name = stor.Name;
        this.description = stor.description;
        this.UnitPrice = stor.UnitPrice;
        this.NumberOfUnitsInStock = stor.NumberOfUnitsInStock;
        this.unit = stor.unit;
    }

    @Override
    public String toString() {
        return  "Anidentificationnumber='" + Anidentificationnumber + '\'' +
                ", Name='" + Name + '\'' +
                ", description='" + description + '\'' +
                ", UnitPrice=" + UnitPrice +
                ", NumberOfUnitsInStock=" + NumberOfUnitsInStock +
                ", unit=" + unit +
                '}';
    }

    public Store copy(Store stor){

        return new Store(stor);
    }
    public int getNumberInTable() {

        return Anidentificationnumber;
    }


    //AutoCreated Equals method
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Store store = (Store) o;
        return UnitPrice == store.UnitPrice && NumberOfUnitsInStock == store.NumberOfUnitsInStock && Anidentificationnumber == store.Anidentificationnumber && Name.equals(store.Name) && description.equals(store.description) && unit.equals(store.unit);
    }

    public int compareTo(Store o) {
        int comparAnidentificationnumber = ((Store) o).getNumberInTable();
        return this.Anidentificationnumber - comparAnidentificationnumber;
    }

    public static Store createStoreFromString(String string) {
        String[] stringArray = string.split(",");
        int identificationNumber = Integer.parseInt(stringArray[0]);
        String name = stringArray[1];
        String description = stringArray[2];
        float unitPrice = Float.parseFloat(stringArray[3]);
        int numberOfUnitsInStock = Integer.parseInt(stringArray[4]);
        String unit = stringArray[5];

        return new Store(identificationNumber, name, description, unitPrice, numberOfUnitsInStock, unit);
    }

    public static ArrayList<Store> input(File resource) {
        ArrayList<Store> storeList = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(resource))) {
            String st;
            while ((st = br.readLine()) != null) {
                if (st.isEmpty()) {
                    // ignore empty lines
                } else {
                    storeList.add(createStoreFromString(st));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return storeList;
    }
}
