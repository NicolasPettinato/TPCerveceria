import java.awt.font.TextHitInfo;

public class BeerHouse {

    private int stock;
    private boolean sinStock = true;

    public BeerHouse() {
        this.stock = 0;
    }

    public int getStock() {
        return this.stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public synchronized void reponer(int idproductor, int cantidad){
        while (this.stock == 100){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        stock = stock + cantidad;
        sinStock = false;
        System.out.println("El Productor " + idproductor + " hizo reposición: " + cantidad + "lts.      Stock Total =  " + stock);
        notifyAll();
    }

    public synchronized void consumir(int idconsumidor, int cantidad){
        while (this.stock == 0){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        if(cantidad > this.stock) {
            cantidad = this.stock;
        }
        this.stock = this.stock - cantidad;
        System.out.println("El Consumidor " + idconsumidor + " Compro: " + cantidad + "lts.              Stock Total =  " + stock);
        notifyAll();
    }


}


