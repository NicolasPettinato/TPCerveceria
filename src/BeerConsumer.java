import java.util.Random;
import java.util.TreeMap;

public class BeerConsumer implements Runnable {

    private BeerHouse local;
    private int idConsumidor;
    private boolean continuar = true;

    public BeerConsumer( BeerHouse local, int idConsumidor) {
        this.local = local;
        this.idConsumidor = idConsumidor;
    }

    @Override
    public void run() {
        while (continuar) {
            int cantidad = new Random().nextInt(20);
            this.local.consumir(this.idConsumidor, cantidad);
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                System.out.println("Error: " + e.getMessage());
            }
            if(this.local.getStock() == 0){
                continuar = false;
                System.out.println("Consumidor: " + idConsumidor + " No hay más birra!");
            }
        }
    }
}
