package com.atv.medidor.energia;
import java.util.Locale;
import java.util.Scanner;

public class AppMedidorEnergia {
    static MedidorEnergia medidorEnergia = new MedidorEnergia();
    static Scanner scan = new Scanner(System.in);

    public static void main (String[] args){

        int opcao;

        do {
            System.out.println("\n*** Seletor de Opções ***");
            System.out.println();
            System.out.println("1 - Cadastrar Medidor");
            System.out.println("2 - Tirar Consumo");
            System.out.println("0 - Finalizar");

            System.out.print("\nOpção: ");
            opcao = scan.nextInt();

            switch (opcao) {
                case 1:
                     cadastrarMedidor();
                    break;
                case 2:
                    tirarConsumo();
                    break;
                case 0:
                    System.out.println("\n--- PROGRAMA FINALIZADO");
                    break;
                default:
                    System.out.println("\nOpção incorreta");

            }

        } while (opcao !=0);

        }

    public static void cadastrarMedidor(){

        System.out.println();
        System.out.println("****** Cadastrar Medidor ******");
        int idMedidor;
        do{
            System.out.print("Informe o ID do medidor: ");
            idMedidor = scan.nextInt();
            if(idMedidor <= 0){
                System.out.println("O ID do medidor deve ser um número positivo");
                continue;
            }
            break;
        } while (true);

        String nrSerie;
        do{
            System.out.print("Informe o NR série do medidor: ");
            nrSerie = scan.next();
            if(nrSerie.isEmpty()){
                System.out.println("O número de série deve conter dados");
                continue;
            }
            break;
        }while(true);

        char tipoUcInstalado;
        do{
            System.out.print("Informe o Tipo de consumo de unidade do medidor: ");
            tipoUcInstalado = scan.next().toUpperCase().charAt(0);
            if(tipoUcInstalado != 'C' && tipoUcInstalado != 'I' && tipoUcInstalado != 'R'){
                System.out.println("Informe o carectere adequado para o tipo de unidade de medidor");
                continue;
            }
            break;
        } while (true);

        int leituraAtual;

        do {
            System.out.print("Informe a leitura atual do medidor: ");
            leituraAtual = scan.nextInt();
            if (leituraAtual <= 0) {
                System.out.println("O número da leitura atual deve ser um número positivo");
                continue;
            }
            break;
        }while (true);

        medidorEnergia = new MedidorEnergia(idMedidor, nrSerie, tipoUcInstalado, leituraAtual);

        System.out.println();
        System.out.println("****** Medidor Casdastrado ******");
        System.out.println("O ID do medidor é : " + medidorEnergia.getIdMedidor());
        System.out.println("O NR série do medidor é : " + medidorEnergia.getNrSerie());
        System.out.println("O  Tipo de Consumo de Unidade é : " + medidorEnergia.getTipoUcInstalado());
        System.out.println("A leitura atual do medidor é : " + medidorEnergia.getLeituraAtual());
        System.out.println("A leitura anterior do medidor é : " + medidorEnergia.getLeituraAnterior());
        System.out.println("o valor do consumo é : " + medidorEnergia.getConsumo());
        System.out.println("o valor da conta é : " + medidorEnergia.getValorConta());
        System.out.println();

        //Mostrar os GETS
    }

    public static void tirarConsumo(){
        System.out.println("****** Tirar consumo do Medidor ******");
        System.out.println("O ID do medidor é : " + medidorEnergia.getIdMedidor());
        System.out.println("O NR série do medidor é : " + medidorEnergia.getNrSerie());
        System.out.println("O  Tipo de Consumo de Unidade é : " + medidorEnergia.getTipoUcInstalado());
        System.out.println("A leitura anterior do medidor é : " + medidorEnergia.getLeituraAnterior());
        int leituraAtual;
        do{
            System.out.println("Informe a leitura atual do medidor: ");
            leituraAtual = scan.nextInt();
            if(leituraAtual <= 0 || leituraAtual < medidorEnergia.getLeituraAnterior()){
                if(leituraAtual <= 0 ){
                    System.out.println("O número da leitura atual deve ser um número positivo");
                    continue;
                }else{
                    System.out.println("O número da leitura atual deve ser maior do que a leitura anterior");
                    continue;
                }
            }
            medidorEnergia.registrarLeitura(leituraAtual);
            break;

        }while(true);

        System.out.println(medidorEnergia.getLeituraAtual());
        System.out.println("o valor do consumo é : " + medidorEnergia.getConsumo());
        System.out.println("o valor da conta é : " + medidorEnergia.getValorConta());

    }

}
