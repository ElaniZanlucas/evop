package construcao;

public class Muro {
  private float area;

  private Alvenaria alvenaria;
  private Emboco emboco;

  public Muro(float altura, float comprimento, float custoPedreiro, float custoServente,
      float custoArgamassa, float custoTijolo) {
    this.alvenaria = new Alvenaria(custoPedreiro, custoServente, custoArgamassa, custoTijolo);

    this.emboco = new Emboco(custoPedreiro, custoServente, custoArgamassa);

    calcularArea(altura, comprimento);

    alvenaria.calculaInsumos(area);
    emboco.calculaInsumos(area);

    alvenaria.calculaCusto();
    emboco.calculaCusto();
  }

  public void calcularArea(float altura, float comprimento) {
    this.area = Calcular.duasCasasDecimais((altura * comprimento));
  }

  public int calcularTotalArgamassa() {
    return alvenaria.getArgamassa() + emboco.getArgamassa();
  }

  public float calcularTotalCustoArgamassa() {
    return alvenaria.getCustoArgamassa() + emboco.getCustoArgamassa();
  }

  public float calcularTotalCustoPedreiro() {
    return alvenaria.getCustoPedreiro() + emboco.getCustoPedreiro();
  }

  public float calcularTotalCustoServente() {
    return alvenaria.getCustoServente() + emboco.getCustoServente();
  }

  public float calcularTotalCustoTijolo() {
    return alvenaria.getCustoTijolo();
  }

  public float calcularTotalPedreiro() {
    return alvenaria.getPedreiro() + emboco.getPedreiro();
  }

  public float calcularTotalServente() {
    return alvenaria.getServente() + emboco.getServente();
  }

  public int calcularTotalTijolo() {
    return alvenaria.getTijolo();
  }

  public Alvenaria getAlvenaria() {
    return alvenaria;
  }

  public float getArea() {
    return area;
  }

  public Emboco getEmboco() {
    return emboco;
  }

}