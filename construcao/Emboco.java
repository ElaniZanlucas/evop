package construcao;

public class Emboco extends Services {
  public Emboco(float custoPedreiro, float custoServente,
      float custoArgamassa) {
    super(0.5f, 0.5f, 40, custoPedreiro, custoServente, custoArgamassa);
  }

  @Override
  public void calculaCusto() {
    setCustoArgamassa(Calcular.duasCasasDecimais(getArgamassa() * getCustoArgamassa()));
    setCustoPedreiro(Calcular.duasCasasDecimais(getPedreiro() * getCustoPedreiro()));
    setCustoServente(Calcular.duasCasasDecimais(getServente() * getCustoServente()));
  }

  @Override
  public void calculaInsumos(float area) {
    area = area * 2;
    setArgamassa(Calcular.inteiro(getArgamassa() * area));
    setPedreiro(Calcular.duasCasasDecimais(getPedreiro() * area));
    setServente(Calcular.duasCasasDecimais(getServente() * area));
  }
}