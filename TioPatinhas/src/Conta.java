import java.text.SimpleDateFormat;
import java.util.Date;

public class Conta {
    private User usuario;
    private double saldo;

    public Conta(User usuario, double saldo) {
        this.usuario = usuario;
        this.saldo = saldo;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public void imprimirTransacao(String tipo, double valor) {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date data = new Date();
        System.out.println("Ação: " + tipo);
        System.out.println("Valor: R$ " + valor);
        System.out.println("Data: " + formatter.format(data));
    }

    public void realizarTransacao(String tipo, double valor) {
        if (tipo.equalsIgnoreCase("vender")) {
            saldo += valor;
            imprimirTransacao(tipo, valor);
        } else if (tipo.equalsIgnoreCase("comprar")) {
            if (valor <= saldo) {
                saldo -= valor;
                imprimirTransacao(tipo, valor);
            } else {
                System.out.println("Saldo insuficiente para a transação.");
            }
        } else if (tipo.equalsIgnoreCase("transferir")) {
            if (valor <= saldo) {
                saldo -= valor;
                imprimirTransacao(tipo, valor);
            } else {
                System.out.println("Saldo insuficiente para a transação.");
            }
        } else {
            System.out.println("Tipo de transação inválido.");
        }

    }
    }


