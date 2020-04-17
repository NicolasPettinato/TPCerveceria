
public class ProductorConsumidor {


      public static void main(String[] args) throws InterruptedException {

          BeerHouse local = new BeerHouse();
          Thread productor = new Thread(new BeerProducer(local,1));
          Thread consumidor1 = new Thread(new BeerConsumer(local,1));
          Thread consumidor2 = new Thread(new BeerConsumer(local,2));
          Thread consumidor3 = new Thread(new BeerConsumer(local,3));
          Thread consumidor4 = new Thread(new BeerConsumer(local,4));
          Thread consumidor5 = new Thread(new BeerConsumer(local,5));

          consumidor1.start();
          consumidor2.start();
          consumidor3.start();
          consumidor4.start();
          consumidor5.start();

          productor.start();

          
    }

}
