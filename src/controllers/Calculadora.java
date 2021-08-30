package controllers;

public class Calculadora {
    private javax.swing.JTextField pantalla;
    private double memoria;
    private String operador;
    private String ultimoBoton;
    
    public Calculadora(javax.swing.JTextField display){
        this.pantalla = display;
        this.operador = null;
        this.memoria = 0;
        this.ultimoBoton = "";
    }
    
    /**
     * Añade un dígito en la pantalla.
     * @param numero Digito a mostrar
     */
    public void digitar(String numero){
        System.out.println(this.ultimoBoton);
        switch(this.ultimoBoton){
            case "+":
            case "-":
            case "/":
            case "*":
                this.pantalla.setText("0");
                break;
        }
 int el_numero = Integer.parseInt(numero); //Parsear
                int en_pantalla = Integer.parseInt(this.pantalla.getText());
                if(en_pantalla == 0 && el_numero == 0){
                    //nos se hace nada
                } else {
                    if(this.pantalla.getText().length() < 9){
                        if(en_pantalla == 0){
                            this.pantalla.setText(numero);
                        } else {
                            this.pantalla.setText(en_pantalla+""+numero);        
                        }    
                    }   
                }
                this.ultimoBoton = numero;       
    }
    
    /**
     * Borra pantalla y memoria
     */
    public void limpiar(){
        this.memoria = 0;
        this.pantalla.setText("0");
    }
    
    /**
     * Borra el último número digitado
     */
    public void corregir() {
        int caracteres = this.pantalla.getText().length();
        if(caracteres > 1){
            //eliminamos el último dígito ingresado
            String contenido = this.pantalla.getText();
            this.pantalla.setText(contenido.substring(0, caracteres -1));
        } else {
            //borramos el contenido y dejamos en cero
            this.pantalla.setText("0");
        }
    }
    
    /**
     * 
     * @param op 
     */
    public void operar(String op){
        System.out.println(this.ultimoBoton);
        if(this.memoria == 0 && this.operador == null){
            this.memoria = Double.parseDouble(this.pantalla.getText());
            this.operador = op;
            this.ultimoBoton = op;
        } else {
            double numero_pantalla = Double.parseDouble(this.pantalla.getText());
            switch(this.operador){
                case "+":
                    this.memoria = this.memoria + numero_pantalla;
                    break;
                case "-":
                    this.memoria = this.memoria - numero_pantalla;
                    break;
                case "*":
                    this.memoria = this.memoria * numero_pantalla;
                    break;
                case "/":
                    this.memoria = this.memoria - numero_pantalla;
                    break;
            }
            this.pantalla.setText(String.valueOf(this.memoria));
            this.operador = op;
            this.ultimoBoton = op;
        }
    }
    
    
}
