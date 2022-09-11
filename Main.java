import java.util.Scanner;

import construcao.Calcular;
import construcao.Muro;

public class Main {

  private static Scanner input = new Scanner(System.in);

  private static Muro muro;
  private static float lucro;

  private static void coletarLucro() {
    System.out.printf("Insira o lucro desejável (Exemplo: 0.25): ");
    lucro = getNextInput();
  }

  private static Muro criarMuro() {

    System.out.println("Dimensão do muro: ");
    System.out.printf("Altura (m): ");
    float altura = getNextInput();

    System.out.printf("Comprimento (m): ");
    float comprimento = getNextInput();

    System.out.println();
    System.out.println("Entre com os custos dos insumos: ");

    System.out.printf("Hora do pedreiro: ");
    float custoPedreiro = getNextInput();

    System.out.printf("Hora do servente: ");
    float custoServente = getNextInput();

    System.out.printf("Tijolo: ");
    float custoTijolo = getNextInput();

    System.out.printf("Argamassa: ");
    float custoArgamassa = getNextInput();

    return new Muro(altura, comprimento, custoPedreiro, custoServente, custoArgamassa, custoTijolo);

  }

  private static float getNextInput() {
    boolean flag = false;
    String value;
    float valueFloat = 0;

    while (!flag) {
      try {
        value = input.next();
        value = value.replaceAll(",", ".");
        valueFloat = Float.parseFloat(value);
        flag = true;

      } catch (Exception NumberFormatException) {
        System.out.println("Digite apenas números!");
      }
    }

    return valueFloat;
  }

  private static float imprimirCustos() {
    float custoPedreiro = Calcular.duasCasasDecimais(muro.calcularTotalCustoPedreiro());
    float custoServente = Calcular.duasCasasDecimais(muro.calcularTotalCustoServente());
    float custoTijolo = Calcular.duasCasasDecimais(muro.calcularTotalCustoTijolo());
    float custoArgamassa = Calcular.duasCasasDecimais(muro.calcularTotalCustoArgamassa());

    float custoTotal = Calcular.duasCasasDecimais(custoPedreiro + custoServente + custoTijolo + custoArgamassa);

    System.out.println();
    System.out.println("=========================CUSTOS=========================");
    System.out.println();
    System.out.println("                    Custos da Alvenaria:");
    System.out.printf("   Pedreiro: R$ %.2f \n",
        Calcular.duasCasasDecimais(muro.getAlvenaria().getCustoPedreiro()));
    System.out.printf("   Servente: R$ %.2f \n",
        Calcular.duasCasasDecimais(muro.getAlvenaria().getCustoServente()));
    System.out.printf("   Tijolo: R$ %.2f \n", Calcular.duasCasasDecimais(muro.getAlvenaria().getCustoTijolo()));
    System.out.printf("   Argamassa: R$ %.2f \n", Calcular.duasCasasDecimais(muro.getAlvenaria().getCustoArgamassa()));
    System.out.println("--------------------------------------------------------");
    System.out.println("                    Custos do Emboco:");
    System.out.printf("   Pedreiro: R$ %.2f \n",
        Calcular.duasCasasDecimais(muro.getEmboco().getCustoPedreiro()));
    System.out.printf("   Servente: R$ %.2f \n",
        Calcular.duasCasasDecimais(muro.getEmboco().getCustoServente()));
    System.out.printf("   Argamassa: R$ %.2f \n", Calcular.duasCasasDecimais(muro.getEmboco().getCustoArgamassa()));
    System.out.println("--------------------------------------------------------");
    System.out.println("                    Custos Totais por Insumo:");
    System.out.println("--------------------------------------------------------");
    System.out.printf("   Pedreiro: R$ %.2f \n", custoPedreiro);
    System.out.printf("   Servente: R$ %.2f \n", custoServente);
    System.out.printf("   Tijolo: R$ %.2f \n", custoTijolo);
    System.out.printf("   Argamassa: R$ %.2f \n", custoArgamassa);
    System.out.println("--------------------------------------------------------");
    System.out.printf("         Custo Total: R$ %.2f \n", custoTotal);
    System.out.println("========================================================");
    System.out.println();
    System.out.println();

    return custoTotal;
  }

  private static void imprimirInsumos(Muro muro) {
    float insumoPedreiroAlvenaria = Calcular.duasCasasDecimais(muro.getAlvenaria().getPedreiro());
    float insumoServenteAlvenaria = Calcular.duasCasasDecimais(muro.getAlvenaria().getServente());
    float insumoPedreiroEmboco = Calcular.duasCasasDecimais(muro.getEmboco().getPedreiro());
    float insumoServenteEmboco = Calcular.duasCasasDecimais(muro.getEmboco().getServente());
    float insumoPedreiroTotal = Calcular.duasCasasDecimais(muro.calcularTotalPedreiro());
    float insumoServenteTotal = Calcular.duasCasasDecimais(muro.calcularTotalServente());

    System.out.println();
    System.out.println();
    System.out.println("=========================INSUMOS=========================");
    System.out.println();
    System.out.println("                    Insumos para Alvenaria:");
    System.out.printf("   Pedreiro: %.2f h (%s)\n", insumoPedreiroAlvenaria, Calcular.tempo(insumoPedreiroAlvenaria));
    System.out.printf("   Horas do Servente: %.2f h (%s) \n", insumoServenteAlvenaria, Calcular.tempo(insumoServenteAlvenaria));
    System.out.printf("   Tijolo: %d \n", muro.getAlvenaria().getTijolo());
    System.out.printf("   Argamassa: %d \n", muro.getAlvenaria().getArgamassa());
    System.out.println("--------------------------------------------------------");
    System.out.println("                    Insumos para Emboco:");
    System.out.printf("   Horas do Pedreiro: %.2f h (%s) \n", insumoPedreiroEmboco, Calcular.tempo(insumoPedreiroEmboco));
    System.out.printf("   Horas do Servente: %.2f h (%s) \n", insumoServenteEmboco, Calcular.tempo(insumoServenteEmboco));
    System.out.printf("   Argamassa: %d \n", muro.getEmboco().getArgamassa());
    System.out.println("--------------------------------------------------------");
    System.out.println("                    Total de Insumos:");
    System.out.println("--------------------------------------------------------");
    System.out.printf("   Horas do Pedreiro: %.2f h (%s) \n", insumoPedreiroTotal, Calcular.tempo(insumoPedreiroTotal));
    System.out.printf("   Horas do Servente: %.2f h (%s) \n", insumoServenteTotal, Calcular.tempo(insumoServenteTotal));
    System.out.printf("   Tijolo: %d \n", muro.calcularTotalTijolo());
    System.out.printf("   Argamassa: %d \n", muro.calcularTotalArgamassa());
    System.out.println("========================================================");
    System.out.println();

  }

  private static void imprimirLucro(float custoTotal) {
    System.out.println();
    System.out.println();
    System.out.println("=========================LUCRO=========================");
    System.out.println();
    System.out.printf("   Custo Total s/ Lucro: R$ %.2f \n", Calcular.duasCasasDecimais(custoTotal));
    System.out.printf("   Custo Total c/ Lucro: R$ %.2f \n", Calcular.duasCasasDecimais((1.0f + lucro) * custoTotal));
    System.out.println("========================================================");
    System.out.println();
  }

  public static void main(String[] args) {
    muro = criarMuro();

    imprimirInsumos(muro);

    float custoTotal = imprimirCustos();

    coletarLucro();

    imprimirLucro(custoTotal);

  }

}