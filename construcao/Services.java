package construcao;

public abstract class Services {
  private float pedreiro;
  private float servente;
  private int argamassa;

  private float custoPedreiro;
  private float custoServente;
  private float custoArgamassa;

  public abstract void calculaCusto();

  public abstract void calculaInsumos(float area);

  public Services(float pedreiro, float servente, int argamassa, float custoPedreiro, float custoServente,
      float custoArgamassa) {
    setArgamassa(argamassa);
    setCustoArgamassa(custoArgamassa);
    setCustoPedreiro(custoPedreiro);
    setCustoServente(custoServente);
    setPedreiro(pedreiro);
    setServente(servente);
  }

  public int getArgamassa() {
    return argamassa;
  }

  public void setArgamassa(int argamassa) {
    this.argamassa = argamassa;
  }

  public float getCustoArgamassa() {
    return custoArgamassa;
  }

  public void setCustoArgamassa(float custoArgamassa) {
    this.custoArgamassa = custoArgamassa;
  }

  public float getCustoPedreiro() {
    return custoPedreiro;
  }

  public void setCustoPedreiro(float custoPedreiro) {
    this.custoPedreiro = custoPedreiro;
  }

  public float getCustoServente() {
    return custoServente;
  }

  public void setCustoServente(float custoServente) {
    this.custoServente = custoServente;
  }

  public float getPedreiro() {
    return pedreiro;
  }

  public void setPedreiro(float pedreiro) {
    this.pedreiro = pedreiro;
  }

  public float getServente() {
    return servente;
  }

  public void setServente(float servente) {
    this.servente = servente;
  }

}