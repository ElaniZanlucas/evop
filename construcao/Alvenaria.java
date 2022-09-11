package construcao;

public class Alvenaria extends Services {
  private int tijolo;

  private float custoTijolo;

  public Alvenaria(float custoPedreiro, float custoServente, float custoArgamassa, float custoTijolo) {
    super(0.8f, 0.8f, 10, custoPedreiro, custoServente, custoArgamassa);
    setTijolo(21);
    setCustoTijolo(custoTijolo);
  }

  @Override
  public void calculaCusto() {
    setCustoArgamassa(Calcular.duasCasasDecimais(getArgamassa() * getCustoArgamassa()));
    setCustoPedreiro(Calcular.duasCasasDecimais(getPedreiro() * getCustoPedreiro()));
    setCustoServente(Calcular.duasCasasDecimais(getServente() * getCustoServente()));
    setCustoTijolo(Calcular.duasCasasDecimais(getTijolo() * getCustoTijolo()));
  }

  @Override
  public void calculaInsumos(float area) {
    setArgamassa(Calcular.inteiro(getArgamassa() * area));
    setPedreiro(Calcular.duasCasasDecimais(getPedreiro() * area));
    setServente(Calcular.duasCasasDecimais(getServente() * area));
    setTijolo(Calcular.inteiro(getTijolo() * area));
  }

  public float getCustoTijolo() {
    return custoTijolo;
  }

  public void setCustoTijolo(float custoTijolo) {
    this.custoTijolo = custoTijolo;
  }

  public int getTijolo() {
    return tijolo;
  }

  public void setTijolo(int tijolo) {
    this.tijolo = tijolo;
  }

}
