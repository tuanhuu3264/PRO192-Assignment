
package Manager;

import DTO.Brand;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;


public class BrandList extends ArrayList<Brand> {

    public BrandList() {
        super();
    }

    //SEARCH ID;
    public Brand searchID(String id) {

        for (int i = 0; i < this.size(); i++) {
            if (this.get(i).getID().equals(id)) {
                return this.get(i);
            }
        }
        return null;
    }
    
    public void searchOld() {
        if (this.isEmpty()) {
            System.out.println("Brand List does not have any brand!!");
        } else {
            String id = Inputter.inputNonBlank("Input the id need to search: ");
            if (searchID(id) == null) {
                System.out.println("The brand " + id + " does not existed!!");
            } else {
                printBrand(searchID(id));
            }
        }
    }

    public void addNew() {
        boolean flag = true;
        String id = new String();
        do {
            id = Inputter.inputNonBlank("Input your ID of Brand: ");
            if (searchID(id)!=null) {
                flag = true;
                System.out.println("The code is dupplicated");
            } else {
                flag = false;
            }
        } while (flag);
        String name = Inputter.inputNonBlank("Input name of Brand: ");
        String sound = Inputter.inputNonBlank("Input sound of Brand: ");
        double price = Inputter.inputDouble("Input price of Brand: ", 0);
        Brand a = new Brand(id, name, sound, price);
        this.add(a);

    }

    public void ListAll() {
        if (this.isEmpty()) {
            System.out.println("The Brand List does not have any brand!");
        } else {
            for (int i = 0; i < this.size(); i++) {
                printBrand(this.get(i));
            }
        }
    }

    public void updateOld() {
        String id = Inputter.inputNonBlank("Input the brand need to update: ");
        if (searchID(id) == null) {
            System.out.println("The brand "+id+" is not in the list!");

        } else {
            String name = Inputter.inputNonBlank("Input name of Brand: ");
            String sound = Inputter.inputNonBlank("Input sound of Brand: ");
            double price = Inputter.inputDouble("Input price of Brand: ", 0);
            this.searchID(id).setBrandName(name);
            this.searchID(id).setSound(sound);
            this.searchID(id).setPrice(price);
        }
    }
    
    public void loadFile()
    {
         try {
            File f = new File("brands.txt");
            if (!f.exists()) {
                return;
            }
            FileReader fr = new FileReader(f);
            BufferedReader bf = new BufferedReader(fr);
            String line;
            while ((line = bf.readLine()) != null) {
                String[] st = line.split(",");
                String id = st[0].trim();
                String name = st[1].trim();
                String[] st2=st[2].split(":");
                String sound = st2[0].trim();
                double price=Double.parseDouble(st2[1].trim());
                Brand a = new Brand(id, name, sound, price);
                this.add(a);

            }
            bf.close();
            fr.close();

        } catch (IOException | NumberFormatException e) {
            System.out.println(e);
        }
    }
    public void saveFile() throws IOException {
        File f = new File("brands.txt");
        if (!f.exists()) {
            f.createNewFile();
        }

        try (FileWriter fr = new FileWriter(f, false)) {
            if (!this.isEmpty()) {
                for (int i = 0; i < this.size(); i++) {
                fr.write(this.get(i).toString()+ "\n");
                }
                System.out.println("Save Success!!");
            }
        } catch (Exception e) {
            System.out.println(e);

        }

    }
    
    public void printBrand(Brand brand)
    {
        System.out.println("Brand ID: "+brand.getID());
        System.out.println("Brand Name: "+brand.getBrandName());
        System.out.println("Sound Brand: "+brand.getSound());
        System.out.println("Price: "+brand.getPrice());
        System.out.printf("\n");
    }
    
}
