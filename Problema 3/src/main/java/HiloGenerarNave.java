public class HiloGenerarNave extends Thread{
    @Override
    public void run(){
    try {
    Thread.sleep(5000); 
    }
    catch (InterruptedException e) {
    System.out.println(e);
    }
        while(Panel.juevoEmpezado){
            int lugar=(int)Math.ceil(Ventana.totalNaves/20);
            boolean bandera=true;
             while(bandera){
             int random_int = (int)(Math.random() * (19  + 1) );
               
              Nave aux=Ventana.naves[random_int][lugar];
              if(aux==null){
              Nave naveCabeza=Ventana.naves[random_int][0];
              Nave nuevaNave=new Nave(naveCabeza.getX(), naveCabeza.getY()-(lugar-2)*20);
              Ventana.totalNaves++;
              Ventana.navesVivas++;
              
              Ventana.naves[random_int][lugar]=nuevaNave;
             Panel.panel1.add(nuevaNave);
             Panel.panel1.updateUI();
              bandera=false;
              }
             
             
             } 
             //sleept
            try {
                Thread.sleep(2500-Panel.velocidadAparicionNave); 
            }
            catch (InterruptedException e) {
                System.out.println(e);
            }
                
        }
    }
}
