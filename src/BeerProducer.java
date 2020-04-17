
import javafx.scene.control.RadioMenuItem;

import java.util.Random;


public class BeerProducer implements Runnable {

    private BeerHouse local;
    private int idProductor;
    private boolean continuar = true;

    public BeerProducer(BeerHouse local, int idProductor) {
        this.local = local;
        this.idProductor = idProductor;
    }

    @Override
    public void run() {
        while (continuar) {
            int stock = this.local.getStock();
            int r = (int) (Math.random() * (100-stock)) + 1;
            this.local.reponer(this.idProductor,r);
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                System.out.println("Error: " + e.getMessage());
            }
            if(this.local.getStock() == 0){
                continuar = false;
                System.out.println("No hay Stock en Producción");
            }
        }
    }
}
