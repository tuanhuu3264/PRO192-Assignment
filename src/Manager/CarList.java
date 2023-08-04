package Manager;

import DTO.Brand;
import DTO.Car;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CarList extends ArrayList<Car> {

    public CarList() {
        super();
    }
// SEARCH ID, FRAME ID, ENGINE ID OF LIST BASED ON ID INPUT

    public Car searchID(String id) {
        for (int i = 0; i < this.size(); i++) {
            if (this.get(i).getID().equals(id)) {
                return this.get(i);
            }
        }
        return null;
    }

    public Car searchFrameID(String id) {
        for (int i = 0; i < this.size(); i++) {
            if (this.get(i).getFrameID().equals(id)) {
                return this.get(i);
            }
        }
        return null;
    }

    public Car searchEngineID(String id) {
        for (int i = 0; i < this.size(); i++) {
            if (this.get(i).getEngineID().equals(id)) {
                return this.get(i);
            }
        }
        return null;
    }
// INPUT EACH ELEMENT OF CAR

    public String inputID() {
        boolean flag;
        String id = new String();
        do {
            id = Inputter.inputNonBlank("Input your ID of Car: ");
            if (this.searchID(id) != null) {
                flag = true;
                System.out.println("The code is dupplicated");
            } else {
                flag = false;
            }
        } while (flag);
        return id;
    }

    public String inputColor() {
        String color = Inputter.inputNonBlank("Input the color: ");
        return color;
    }

    public String inputFrameID() {
        boolean flag = true;
        String FrameID;
        do {
            FrameID = Inputter.inputPattern("Input your Frame ID of Car: ", "[A-Z][0-9]{1,5}");
            if (this.searchFrameID(FrameID) != null) {
                flag = true;
                System.out.println("The code is dupplicated");
            } else {
                flag = false;
            }
        } while (flag);
        return FrameID;

    }

    public String inputEngineID() {
        boolean flag = true;
        String EngineID;
        do {
            EngineID = Inputter.inputPattern("Input your Engine ID of Car: ", "[A-Z][0-9]{1,5}");
            if (this.searchEngineID(EngineID) != null) {
                flag = true;
                System.out.println("The code is dupplicated");
            } else {
                flag = false;
            }
        } while (flag);
        return EngineID;
    }

    // ADD NEW CAR
    public void addNew(BrandList t) {
        boolean flag = true;
        String id = inputID();
        String brandid = new String();
        do {
            brandid = Inputter.inputNonBlank("Input the ID brand of car: ");
            Brand k = t.searchID(brandid);
            if (k == null) {
                System.out.println("The brand id " + brandid + " does not existed in file brand.txt!");
                flag = true;
            } else {
                flag = false;
            }
        } while (flag);
        String color = inputColor();
        String FrameID = inputFrameID();
        String EngineID = inputEngineID();
        Car a = new Car(id, brandid, color, FrameID, EngineID);
        this.add(a);
        loadDataInto(t);
    }

    public void ListBasedName(BrandList t) {
        if (this.isEmpty()) {
            System.out.println("The Car List is Empty!!");
        } else {
            int dem=0; 
            String name = Inputter.inputNonBlank("Input the name car you want to find: ");
            CharSequence ch=name; 
            List<String> k= new ArrayList<>();
            for(int i=0;i<t.size();i++)
                if(t.get(i).getBrandName().contains(name)) k.add(t.get(i).getID());
            
            for(int i=0;i<k.size();i++)
                for(int j=0;j<this.size();j++)
                    if(k.get(i).equals(this.get(j).getBrandID())) 
                    {  dem++; 
                        System.out.println("Brand Name: "+this.get(j).getBrand().getBrandName());
                        printCar(this.get(j));
                    }
            if(dem==0) System.out.println("No car in car list has brand name "+name);
            
        }

    }

    public void ListSort() {

        Collections.sort(this);

        for (int i = 0; i < this.size(); i++) {
            System.out.println("Brand Name: " + this.get(i).getBrand().getBrandName());
            printCar(this.get(i));
        }

    }

    public void removeOld(BrandList brand) {
        int index;
        if (this.isEmpty()) {
            System.out.println("The list is empty!!");
        } else {
            String id = Inputter.inputNonBlank("Input the id car you want to remove ");
            if (searchID(id) != null) {
                this.remove(searchID(id));
                System.out.println("Remove Success!!");
            } else {
                System.out.println("The Car " + id + " doesn't existed!!");
            }
        }
    }

    public void updateCar(BrandList t) {
        String id = Inputter.inputNonBlank("Input the id car you want to update: ");
        if (this.isEmpty()) {
            System.out.println("The Car list is empty!!");
        } else if (searchID(id) == null) {
            System.out.println("The car id " + id + " does not exist!!");
        } else {
            boolean flag = true;
            String brandid;
            do {
                brandid = Inputter.inputNonBlank("Input the ID brand of car: ");
                if (t.searchID(brandid) == null) {
                    System.out.println("The brand id " + brandid + " does not existed in file brand.txt!");
                    flag = true;
                } else {
                    flag = false;
                }
            } while (flag);
            String color = inputColor();
            String FrameID = inputFrameID();
            String EngineID = inputEngineID();
            this.searchID(id).setBrandID(brandid);
            this.searchID(id).setColor(color);
            this.searchID(id).setFrameID(FrameID);
            this.searchID(id).setEngineID(EngineID);
            loadDataInto(t);
        }
        

    }

    public void readFile() throws FileNotFoundException, IOException {
        try {
            File f = new File("cars.txt");
            if (!f.exists()) {
                return;
            }
            FileReader fr = new FileReader(f);
            BufferedReader bf = new BufferedReader(fr);
            String line;
            int index = 0;
            while ((line = bf.readLine()) != null) {
                String[] st = line.split(",");
                String id = st[0].trim();
                String brandid = st[1].trim();
                String color = st[2].trim();
                String frameid = st[3].trim();
                String engineid = st[4].trim();

                Car a = new Car(id, brandid, color, frameid, engineid);
                this.add(a);

            }
            bf.close();
            fr.close();

        } catch (IOException e) {
            System.out.println(e);
        }
    }

    public void saveFile() throws IOException {
        File f = new File("cars.txt");
        if (!f.exists()) {
            f.createNewFile();
        }

        try (FileWriter fr = new FileWriter(f, false)) {
            if (!this.isEmpty()) {
                for (int i = 0; i < this.size(); i++) {
                    fr.write(this.get(i).toString() + "\n");
                }
            System.out.println("Save Success!!");
            }
        } catch (Exception e) {
            System.out.println(e);

        }
    }

    public void loadDataInto(BrandList t) {
        for (int i = 0; i < this.size(); i++) {
            for (int j = 0; j < t.size(); j++) {
                if (this.get(i).getBrandID().equals(t.get(j).getID())) {
                    this.get(i).getBrand().setBrandName(t.get(j).getBrandName());
                }
            }
        }
    }

    public void printCar(Car car) {
        System.out.println("ID Car: " + car.getID());
        System.out.println("Brand ID: " + car.getBrandID());
        System.out.println("Color:  " + car.getColor());
        System.out.println("Frame ID: " + car.getFrameID());
        System.out.println("Engine ID: " + car.getEngineID());
        System.out.printf("\n");
    }

}
