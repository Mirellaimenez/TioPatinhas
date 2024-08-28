import java.util.Scanner;

public class Main{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        User tioPatinhas = new User("Tio Patinhas", "tio@patinhas.com", "senha123");
        Conta conta = new Conta(tioPatinhas, 500000.00);

        System.out.println("Bem vindo ao gerencimaneto de Criptomoedas!");
        pulaLinha();
        System.out.println("Digite seu email:");
        String email = scanner.nextLine();
        System.out.println("Digite sua senha:");
        String senha = scanner.nextLine();

        if (tioPatinhas.validarUsuario(email, senha)) {
            limpaTerminal();
            System.out.println("Login realizado com sucesso!");
            System.out.println("Saldo: R$"+ conta.getSaldo());
            pulaLinha();


            while (true) {
                System.out.println("Escolha uma transação:");
                System.out.println("1. Vender");
                System.out.println("2. Comprar");
                System.out.println("3. Transferir");
                System.out.println("4. Sair");
                int escolha = scanner.nextInt();

                if (escolha == 4) {
                    break;
                }

                System.out.print("Digite o valor: ");
                double valor = scanner.nextDouble();

                switch (escolha) {
                    case 1:
                        conta.realizarTransacao("vender", valor);
                        break;
                    case 2:
                        conta.realizarTransacao("comprar", valor);
                        break;
                    case 3:
                        conta.realizarTransacao("transferir", valor);
                        break;
                    default:
                        System.out.println("Escolha inválida.");
                        break;
                }

                System.out.println("Saldo atual: R$ " + conta.getSaldo());
            }

            scanner.close();
        }
    }
        private static void limpaTerminal(){
            System.out.print("\033[H\033[2J");
            System.out.flush();
        }
        private static void pulaLinha(){
            System.out.println("");
        }

    }

